package com.data.m5p.controller;

import com.data.m5p.ao.ModuleTagAO;
import com.data.m5p.common.CommonResult;
import com.data.m5p.pojo.Module;
import com.data.m5p.service.ModuleService;
import com.data.m5p.vo.ModuleVO;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class ModuleController {
    @Resource
    private ModuleService moduleService;

    @PostMapping("/modules")
    public CommonResult<String> createModule(@RequestBody ModuleTagAO moduleTagAO) {

        moduleService.createModule(moduleTagAO);

        return CommonResult.success("create module successfully");
    }

    @GetMapping("/modules")
    public CommonResult<List<ModuleTagAO>> getModule() {

        List<ModuleTagAO> moduleTagAOS = moduleService.getModule();

        return CommonResult.success(moduleTagAOS);
    }

    @GetMapping("/modules/{id}")
    public CommonResult<ModuleVO> getModuleById(@PathVariable Long id) throws NotFoundException {

        Module module = moduleService.getModuleById(id);
        ModuleVO moduleVO = ModuleService.ModuleToModuleVO(module);

        return CommonResult.success(moduleVO);
    }

    @GetMapping("modules/student/{id}")
    public CommonResult<List<ModuleTagAO>> getModuleByStudent(@PathVariable Long id) {
        List<ModuleTagAO> moduleTagAOS = moduleService.getModuleByStudent(id);

        return CommonResult.success(moduleTagAOS);

    }

    @PutMapping("/modules/{id}")
    public CommonResult<String> updateModule(@PathVariable Long id, @RequestBody Module module) {

        moduleService.updateModule(module);

        return CommonResult.success("update module successfully");
    }

    @DeleteMapping("/modules/{id}")
    public CommonResult<String> deleteModule(@PathVariable Long id) {

        moduleService.deleteModule(id);

        return CommonResult.success("delete module successfully");
    }
}

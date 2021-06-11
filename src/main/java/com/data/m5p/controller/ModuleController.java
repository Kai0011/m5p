package com.data.m5p.controller;

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
    public CommonResult<String> createModule(@RequestBody Module module) {

        moduleService.createModule(module);

        return CommonResult.success("create module successfully");
    }

    @GetMapping("/modules")
    public CommonResult<List<ModuleVO>> getModule() {

        List<Module> modules = moduleService.getModule();
        List<ModuleVO> moduleVOS = ModuleService.ModulesToModuleVOS(modules);

        return CommonResult.success(moduleVOS);
    }

    @GetMapping("/modules/{id}")
    public CommonResult<ModuleVO> getModuleById(@PathVariable Long id) throws NotFoundException {

        Module module = moduleService.getModuleById(id);
        ModuleVO moduleVO = ModuleService.ModuleToModuleVO(module);

        return CommonResult.success(moduleVO);
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

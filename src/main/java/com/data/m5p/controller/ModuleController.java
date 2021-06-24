package com.data.m5p.controller;

import com.data.m5p.ao.ModuleTagAO;
import com.data.m5p.common.CommonResult;
import com.data.m5p.pojo.Comment;
import com.data.m5p.pojo.Module;
import com.data.m5p.service.CommentService;
import com.data.m5p.service.ModuleService;
import com.data.m5p.vo.ModuleCommentVO;
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
    @Resource
    private CommentService commentService;

    @PostMapping("/modules")
    public CommonResult<String> createModule(@RequestBody ModuleTagAO moduleTagAO) {

        moduleService.saveModule(moduleTagAO);

        return CommonResult.success("create module successfully");
    }

    @PostMapping("/modules/{id}/comments")
    public CommonResult<String> createComment(@PathVariable Long id, @RequestBody Comment comment) {
        commentService.saveModuleComment(comment, id);

        return CommonResult.success("create comment successfully");
    }

    @GetMapping("/modules")
    public CommonResult<List<ModuleTagAO>> getModule() {

        List<ModuleTagAO> moduleTagAOS = moduleService.listModules();

        return CommonResult.success(moduleTagAOS);
    }

    @GetMapping("/modules/{id}")
    public CommonResult<ModuleCommentVO> getModuleById(@PathVariable Long id) throws NotFoundException {

        ModuleCommentVO moduleCommentVO = moduleService.getModuleById(id);

        return CommonResult.success(moduleCommentVO);
    }

    @GetMapping("modules/student/{id}")
    public CommonResult<List<ModuleTagAO>> getModuleByStudent(@PathVariable Long id) {
        List<ModuleTagAO> moduleTagAOS = moduleService.listModulesByStudent(id);

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

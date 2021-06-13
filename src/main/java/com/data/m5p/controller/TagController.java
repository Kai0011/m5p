package com.data.m5p.controller;


import com.data.m5p.common.CommonResult;
import com.data.m5p.pojo.Tag;
import com.data.m5p.service.TagService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@CrossOrigin(origins = "*")
@RestController
public class TagController {
    @Resource
    private TagService tagService;

    @PostMapping("/tag")
    public CommonResult<String> createTag(@RequestBody Tag tag) {

        tagService.createTag(tag);

        return CommonResult.success("create tag successfully");
    }
}

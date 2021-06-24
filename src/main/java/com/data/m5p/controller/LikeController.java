package com.data.m5p.controller;

import com.data.m5p.common.CommonResult;
import com.data.m5p.pojo.Like;
import com.data.m5p.service.LikeService;
import com.data.m5p.service.PostService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin(origins = "*")
@RestController
public class LikeController {
    @Resource
    private LikeService likeService;

    @PostMapping("/likes")
    public CommonResult<String> changeLike(@RequestBody Like like) {
        likeService.changeLike(like);

        return CommonResult.success("change like successfully");

    }

}

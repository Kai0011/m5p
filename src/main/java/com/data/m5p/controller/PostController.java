package com.data.m5p.controller;

import com.data.m5p.common.CommonResult;
import com.data.m5p.pojo.Post;
import com.data.m5p.service.PostService;
import com.data.m5p.vo.PostVO;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class PostController {
    @Resource
    private PostService postService;

    @PostMapping("/posts")
    public CommonResult<String> createPost(@RequestBody Post post) {

        postService.createPost(post);

        return CommonResult.success("create post successfully");
    }

    @GetMapping("/posts")
    public CommonResult<List<PostVO>> getPost() {

        List<Post> posts = postService.getPost();
        List<PostVO> postVOS = PostService.PostsToPostVOS(posts);

        return CommonResult.success(postVOS);
    }

    @GetMapping("/posts/{id}")
    public CommonResult<PostVO> getPostById(@PathVariable Long id) throws NotFoundException {
        Post post = postService.getPostById(id);
        PostVO postVO = PostService.PostToPostVO(post);

        return CommonResult.success(postVO);
    }

    @PutMapping("/posts/{id}")
    public CommonResult<String> updatePost(@PathVariable Long id, @RequestBody Post post) {

        postService.updatePost(post);

        return CommonResult.success("update post successfully");
    }

    @DeleteMapping("/posts/{id}")
    public CommonResult<String> deletePost(@PathVariable Long id) {

        postService.deletePost(id);

        return CommonResult.success("delete post successfully");
    }
}

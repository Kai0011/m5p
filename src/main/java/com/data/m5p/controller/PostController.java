package com.data.m5p.controller;

import com.data.m5p.ao.PostTagAO;
import com.data.m5p.common.CommonResult;
import com.data.m5p.pojo.Comment;
import com.data.m5p.pojo.Post;
import com.data.m5p.service.CommentService;
import com.data.m5p.service.PostService;
import com.data.m5p.vo.PostCommentVO;
import com.data.m5p.vo.PostTagVO;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class PostController {
    @Resource
    private PostService postService;
    @Resource
    private CommentService commentService;

    @PostMapping("/posts")
    public CommonResult<String> createPost(@RequestBody PostTagAO postTagAO) {

        postService.createPost(postTagAO);

        return CommonResult.success("create post successfully");
    }

    @PostMapping("/posts/{id}/comments")
    public CommonResult<String> createComment(@PathVariable Long id, @RequestBody Comment comment) {
        commentService.savePostComment(comment, id);

        return CommonResult.success("create comment successfully");
    }

    @GetMapping("/posts")
    public CommonResult<List<PostTagVO>> getPosts() {

        List<PostTagVO> postTagVOS = postService.listPosts();

        return CommonResult.success(postTagVOS);
    }

    @GetMapping("/posts/{id}")
    public CommonResult<PostCommentVO> getPostById(@PathVariable Long id) throws NotFoundException {
        PostCommentVO postCommentVO = postService.getPostById(id);

        return CommonResult.success(postCommentVO);
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

package com.data.m5p.service;

import com.data.m5p.common.IdWorker;
import com.data.m5p.idworker.DatacenterId;
import com.data.m5p.mapper.PostMapper;
import com.data.m5p.pojo.Post;
import com.data.m5p.vo.PostVO;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PostService {
    @Resource
    private PostMapper postMapper;

    private IdWorker idWorker = new IdWorker(1, DatacenterId.Post.getValue(),1);

    public void createPost(Post post) {

        post.setId(idWorker.nextId());
        post.setStatus(1);
        post.setCreateDate(new Date());
        post.setModifiedDate(new Date());
        postMapper.insert(post);

        System.out.println(post.getName());
    }

    public Post getPostById(Long id) throws NotFoundException {
        Post post = postMapper.selectByPrimaryKey(id);
        if (post==null) {
            throw new NotFoundException("Post not found");
        }
        return post;
    }

    public List<Post> getPost() {
        return  postMapper.selectAll();
    }

    public void updatePost(Post post) {
        post.setModifiedDate(new Date());
        postMapper.updateByPrimaryKeySelective(post);
    }

    public void deletePost(Long id) {

        Post post = this.existPost(id);
        if (post!=null) {
            post.setStatus(0);
        }
        postMapper.updateByPrimaryKeySelective(post);
    }

    public Post existPost(Long id) {
        if(postMapper.existsWithPrimaryKey(id)) {
            Post post = postMapper.selectByPrimaryKey(id);
            if (post.getStatus()==1) {
                return post;
            }
            return null;
        }
        return null;
    }

    public static PostVO PostToPostVO(Post post) {
        PostVO postVO = new PostVO();
        postVO.setId(post.getId());
        postVO.setName(post.getName());
        return postVO;
    }

    public static List<PostVO> PostsToPostVOS(List<Post> posts) {
        List<PostVO> postVOS = new ArrayList<>();
        for(Post post:posts) {
            PostVO postVO = new PostVO();
            postVO.setId(post.getId());
            postVO.setName(post.getName());
            postVOS.add(postVO);
        }
        return postVOS;
    }
}

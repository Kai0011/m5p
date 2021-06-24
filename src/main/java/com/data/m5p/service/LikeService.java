package com.data.m5p.service;

import com.data.m5p.common.IdWorker;
import com.data.m5p.idworker.DatacenterId;
import com.data.m5p.mapper.*;
import com.data.m5p.pojo.Comment;
import com.data.m5p.pojo.Like;
import com.data.m5p.pojo.Post;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class LikeService {
    @Resource
    private LikeMapper likeMapper;
    @Resource
    private PostMapper postMapper;
    @Resource
    private CommentMapper commentMapper;
    @Resource
    private UserCommentRelationMapper userCommentRelationMapper;
    @Resource
    private UserPostRelationMapper userPostRelationMapper;

    private IdWorker idWorker = new IdWorker(1, DatacenterId.Like.getValue(),1);

    public void changeLike(Like like) {
        like.setId(idWorker.nextId());
        like.setStatus(1);
        like.setCreateDate(new Date());
        like.setModifiedDate(new Date());
        likeMapper.insert(like);

        // post -> like count +1
        if (like.getType().equals(1)) {
            Post post = postMapper.selectByPrimaryKey(like.getTargetId());
            post.setLikeCount(post.getLikeCount() + 1);
            postMapper.updateByPrimaryKeySelective(post);
        }

        // comment -> like count +1
        if (like.getType().equals(2)) {
            Comment comment = commentMapper.selectByPrimaryKey(like.getTargetId());
            comment.setLikeCount(comment.getLikeCount() + 1);
            commentMapper.updateByPrimaryKeySelective(comment);
        }

    }

}

package com.data.m5p.service;

import com.data.m5p.common.IdWorker;
import com.data.m5p.idworker.DatacenterId;
import com.data.m5p.mapper.*;
import com.data.m5p.pojo.*;
import com.data.m5p.vo.CommentVO;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CommentService {
    @Resource
    private CommentMapper commentMapper;
    @Resource
    private PostCommentRelationMapper postCommentRelationMapper;
    @Resource
    private ModuleCommentRelationMapper moduleCommentRelationMapper;
    @Resource
    private UserCommentRelationMapper userCommentRelationMapper;
    @Resource
    private UserPostRelationMapper userPostRelationMapper;

    private IdWorker idWorker1 = new IdWorker(1, DatacenterId.Comment.getValue(), 1);
    private IdWorker idWorker2 = new IdWorker(1, DatacenterId.Relation.getValue(), 1);

    public void creatPostComment(Comment comment, Long id) {
        Long commentId= idWorker1.nextId();

        // create comment
        comment.setId(commentId);
        comment.setStatus(1);
        comment.setCreateDate(new Date());
        comment.setModifiedDate(new Date());
        commentMapper.insert(comment);

        // create post comment relation
        PostCommentRelation postCommentRelation = new PostCommentRelation();
        postCommentRelation.setId(idWorker2.nextId());
        postCommentRelation.setStatus(1);
        postCommentRelation.setCommentId(commentId);
        postCommentRelation.setPostId(id);
        postCommentRelation.setCreateDate(new Date());
        postCommentRelation.setModifiedDate(new Date());
        postCommentRelationMapper.insert(postCommentRelation);

        // get user Id
        Example userPostExample = new Example(UserPostRelation.class);
        Example.Criteria userPostCriteria = userPostExample.createCriteria();
        userPostCriteria.andEqualTo("postId", id);
        UserPostRelation userPostRelation =userPostRelationMapper.selectOneByExample(userPostExample);
        Long userId = userPostRelation.getUserId();

        // create user comment relation
        UserCommentRelation userCommentRelation = new UserCommentRelation();
        userCommentRelation.setId(idWorker2.nextId());
        userCommentRelation.setStatus(1);
        userCommentRelation.setCommentId(commentId);
        userCommentRelation.setUserId(userId);
        userCommentRelation.setCreateDate(new Date());
        userCommentRelation.setModifiedDate(new Date());
        userCommentRelationMapper.insert(userCommentRelation);

    }

    public void creatModuleComment(Comment comment, Long id) {
        Long commentId= idWorker1.nextId();

        // create comment
        comment.setId(commentId);
        comment.setStatus(1);
        comment.setCreateDate(new Date());
        comment.setModifiedDate(new Date());
        commentMapper.insert(comment);

        // create module comment relation
        ModuleCommentRelation moduleCommentRelation = new ModuleCommentRelation();
        moduleCommentRelation.setId(idWorker2.nextId());
        moduleCommentRelation.setModuleId(id);
        moduleCommentRelation.setCommentId(commentId);
        moduleCommentRelation.setCreateDate(new Date());
        moduleCommentRelation.setModifiedDate(new Date());
        moduleCommentRelationMapper.insert(moduleCommentRelation);

        // get user Id
        Example userPostExample = new Example(UserPostRelation.class);
        Example.Criteria userPostCriteria = userPostExample.createCriteria();
        userPostCriteria.andEqualTo("postId", id);
        UserPostRelation userPostRelation =userPostRelationMapper.selectOneByExample(userPostExample);
        Long userId = userPostRelation.getUserId();

        // create user comment relation
        UserCommentRelation userCommentRelation = new UserCommentRelation();
        userCommentRelation.setId(idWorker2.nextId());
        userCommentRelation.setStatus(1);
        userCommentRelation.setCommentId(commentId);
        userCommentRelation.setUserId(userId);
        userCommentRelation.setCreateDate(new Date());
        userCommentRelation.setModifiedDate(new Date());
        userCommentRelationMapper.insert(userCommentRelation);

    }

    public Comment getCommentById(Long id) throws NotFoundException {
        Comment comment = commentMapper.selectByPrimaryKey(id);
        if (comment==null) {
            throw new NotFoundException("Comment not found");
        }
        return comment;
    }

    public void deleteComment(Long id) {
        Comment comment = this.findComment(id);
        if (comment!=null) {
            comment.setStatus(0);
        }
        commentMapper.updateByPrimaryKeySelective(comment);
    }

    public Comment findComment(Long id) {
        if (commentMapper.existsWithPrimaryKey(id)) {
            Comment comment = commentMapper.selectByPrimaryKey(id);
            if (comment.getStatus()==1) {
                return comment;
            }
            return null;
        }
        return null;
    }

    public static CommentVO CommentToCommentVO(Comment comment) {
        CommentVO commentVO = new CommentVO();
        commentVO.setId(comment.getId());
        commentVO.setContent(comment.getContent());
        commentVO.setType(comment.getCommentType());
        return commentVO;
    }

    public static List<CommentVO> CommentsToCommentVOS(List<Comment> comments) {
        List<CommentVO> commentVOS = new ArrayList<>();
        for (Comment comment:comments){
            CommentVO commentVO = new CommentVO();
            commentVO.setId(comment.getId());
            commentVO.setRating(comment.getRating());
            commentVO.setType(comment.getCommentType());
            commentVO.setReplying(comment.getReplying());
            commentVO.setContent(comment.getContent());
            commentVOS.add(commentVO);
        }
        return commentVOS;
    }
}

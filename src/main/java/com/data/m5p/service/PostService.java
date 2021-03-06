package com.data.m5p.service;

import com.data.m5p.ao.ModuleTagAO;
import com.data.m5p.ao.PostAO;
import com.data.m5p.ao.PostTagAO;
import com.data.m5p.common.IdWorker;
import com.data.m5p.idworker.DatacenterId;
import com.data.m5p.mapper.*;
import com.data.m5p.pojo.*;
import com.data.m5p.vo.CommentVO;
import com.data.m5p.vo.PostTagVO;
import com.data.m5p.vo.PostVO;
import com.data.m5p.vo.PostCommentVO;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PostService {
    @Resource
    private PostMapper postMapper;
    @Resource
    private PostContentMapper postContentMapper;
    @Resource
    private OfferBgMapper offerBgMapper;
    @Resource
    private UserPostRelationMapper userPostRelationMapper;
    @Resource
    private OfferStudyMapper offerStudyMapper;
    @Resource
    private OfferJobMapper offerJobMapper;
    @Resource
    private UserOfferStudyRelationMapper userOfferStudyRelationMapper;
    @Resource
    private UserOfferJobRelationMapper userOfferJobRelationMapper;
    @Resource
    private CommentMapper commentMapper;
    @Resource
    private PostCommentRelationMapper postCommentRelationMapper;
    @Resource
    private PostTagRelationMapper postTagRelationMapper;
    @Resource
    private TagMapper tagMapper;

    @Resource
    private UserService userService;
    @Resource
    private HttpServletRequest request;

    private IdWorker idWorker1 = new IdWorker(1, DatacenterId.Post.getValue(),1);
    private IdWorker idWorker2 = new IdWorker(1, DatacenterId.Relation.getValue(),1);
    private IdWorker idWorker3 = new IdWorker(1, DatacenterId.PostContent.getValue(), 1);
    private IdWorker idWorker4 = new IdWorker(1, DatacenterId.Offer.getValue(), 1);
    private IdWorker idWorker5 = new IdWorker(1, DatacenterId.Bg.getValue(), 1);

    String token = request.getHeader("token");

    @Transactional
    public void createPost(PostTagAO postTagAO) {

        PostAO postAO = postTagAO.getPostAO();
        Integer type = postAO.getPostType();
        Long postId = idWorker1.nextId();
        Long contentId = idWorker3.nextId();
        Long offerId = idWorker4.nextId();
        Long bgId = idWorker5.nextId();

        Post post = new Post();
        post.setName(postAO.getTitle());
        post.setId(postId);
        post.setPostContentId(contentId);
        post.setStatus(1);
        post.setCreateDate(new Date());
        post.setModifiedDate(new Date());
        // set view like collection reply count to 0
        post.setCommentCount(0);
        post.setLikeCount(0);
        post.setCollectionCount(0);
        post.setViewCount(0);

        postMapper.insert(post);

        PostContent postContent = postAO.getPostContent();
        postContent.setId(contentId);
        postContent.setPostId(postId);
        postContent.setStatus(1);
        postContent.setCreateDate(new Date());
        postContent.setModifiedDate(new Date());
        postContentMapper.insert(postContent);

        UserPostRelation userPostRelation = new UserPostRelation();
        userPostRelation.setId(idWorker2.nextId());
        userPostRelation.setUserId(userService.getIdByToken(token));
        userPostRelation.setPostId(postId);
        userPostRelation.setStatus(1);
        userPostRelation.setCreateDate(new Date());
        userPostRelation.setModifiedDate(new Date());
        userPostRelationMapper.insert(userPostRelation);

        OfferBg offerBg = postAO.getOfferBg();
        offerBg.setId(bgId);
        offerBg.setStatus(1);
        offerBg.setCreateDate(new Date());
        offerBg.setModifiedDate(new Date());
        offerBg.setPostContentId(contentId);
        if (type.equals(1)) { offerBg.setOfferStudyId(offerId); }
        if (type.equals(2)) { offerBg.setOfferJobId(offerId); }
        offerBgMapper.insert(offerBg);

        // offer study
        if (type.equals(1)) {
            OfferStudy offerStudy = postAO.getOfferStudy();
            offerStudy.setId(offerId);
            offerStudy.setStatus(1);
            offerStudy.setCreateDate(new Date());
            offerStudy.setModifiedDate(new Date());
            offerStudy.setOfferBgId(bgId);
            offerStudyMapper.insert(offerStudy);

            UserOfferStudyRelation userOfferStudyRelation = new UserOfferStudyRelation();
            userOfferStudyRelation.setId(idWorker2.nextId());
            userOfferStudyRelation.setStatus(1);
            userOfferStudyRelation.setUserId(userService.getIdByToken(token));
            userOfferStudyRelation.setOfferStudyId(offerId);
            userOfferStudyRelation.setCreateDate(new Date());
            userOfferStudyRelation.setModifiedDate(new Date());
            userOfferStudyRelationMapper.insert(userOfferStudyRelation);
        }

        // offer job
        if (type.equals(2)) {
            OfferJob offerJob = postAO.getOfferJob();
            offerJob.setId(offerId);
            offerJob.setStatus(1);
            offerJob.setCreateDate(new Date());
            offerJob.setModifiedDate(new Date());
            offerJob.setOfferBgId(bgId);
            offerJobMapper.insert(offerJob);

            UserOfferJobRelation userOfferJobRelation = new UserOfferJobRelation();
            userOfferJobRelation.setId(idWorker2.nextId());
            userOfferJobRelation.setStatus(1);
            userOfferJobRelation.setUserId(userService.getIdByToken(token));
            userOfferJobRelation.setOfferJobId(offerId);
            userOfferJobRelation.setCreateDate(new Date());
            userOfferJobRelation.setModifiedDate(new Date());
            userOfferJobRelationMapper.insert(userOfferJobRelation);
        }

        Long tagId;
        List<Tag> tags = postTagAO.getTags();
        for (Tag tag:tags) {
            Tag sameTag = this.findTag(tag.getName());
            if(sameTag==null) {
                tagId = idWorker2.nextId();
                tag.setId(tagId);
                tag.setStatus(1);
                tag.setCreateDate(new Date());
                tag.setModifiedDate(new Date());
                tagMapper.insert(tag);

                PostTagRelation postTagRelation = new PostTagRelation();
                postTagRelation.setId(idWorker3.nextId());
                postTagRelation.setPostId(postId);
                postTagRelation.setTagId(tagId);
                postTagRelation.setCreateDate(new Date());
                postTagRelation.setModifiedDate(new Date());
                postTagRelation.setStatus(1);
                postTagRelationMapper.insert(postTagRelation);
            }

        }

        System.out.println(post.getName());
    }

    public Tag findTag(String name) {
        Example tagExample = new Example(Tag.class);
        Example.Criteria tagCriteria = tagExample.createCriteria();
        tagCriteria.andEqualTo("name", name);
        return tagMapper.selectOneByExample(tagExample);
    }

    public List<Tag> findTag(Post post) {
        Example postTagExample = new Example(PostTagRelation.class);
        Example.Criteria postTagCriteria = postTagExample.createCriteria();
        postTagCriteria.andEqualTo("postId", post.getId());
        List<Long> ids = new ArrayList<>();
        for (PostTagRelation postTagRelation: postTagRelationMapper.selectByExample(postTagExample)) {
            ids.add(postTagRelation.getTagId());
        }

        List<Tag> tags = new ArrayList<>();
        for (Long id:ids) {
            tags.add(tagMapper.selectByPrimaryKey(id));
        }

        return tags;
    }

    public PostCommentVO getPostById(Long id) {

        // ??????????????? ????????? +1

        // ???post id ?????? post content ????????????
        // ??? post content ??? offer ????????????
        // ??? offer ??? offer bg ????????????
        // ??? post id ??? comment ????????????

        PostCommentVO postCommentVO = new PostCommentVO();

        Post post = postMapper.selectByPrimaryKey(id);
        postCommentVO.setTitle(post.getName());
        postCommentVO.setViewCount(post.getViewCount() + 1);
        postCommentVO.setLikeCount(post.getLikeCount());
        postCommentVO.setCollectionCount(post.getCollectionCount());
        postCommentVO.setCommentCount(post.getCommentCount());

        // post content
        PostContent postContent = postContentMapper.selectByPrimaryKey(post.getPostContentId());
        postCommentVO.setPostContent(postContent);

        if (post.getPostType().equals(1)) {
            // offer study
            OfferStudy offerStudy = offerStudyMapper.selectByPrimaryKey(postContent.getOfferStudyId());
            postCommentVO.setUniversity(offerStudy.getUniversity());
            postCommentVO.setMajor(offerStudy.getProject());

            // offer bg
            OfferBg offerBg = offerBgMapper.selectByPrimaryKey(offerStudy.getOfferBgId());
            postCommentVO.setOfferBg(offerBg);
        }

        if (post.getPostType().equals(2)) {
            // offer job
            OfferJob offerJob = offerJobMapper.selectByPrimaryKey(postContent.getOfferJobId());
            postCommentVO.setUniversity(offerJob.getCompany());
            postCommentVO.setMajor(offerJob.getPosition());

            // offer bg
            OfferBg offerBg = offerBgMapper.selectByPrimaryKey(offerJob.getOfferBgId());
            postCommentVO.setOfferBg(offerBg);
        }

        // comments
        Example postCommentExample = new Example(PostCommentRelation.class);
        Example.Criteria postCommentCriteria = postCommentExample.createCriteria();
        postCommentCriteria.andEqualTo("postId", id);
        List<PostCommentRelation> postCommentRelations = postCommentRelationMapper.selectByExample(postCommentExample);

        List<Long> commentIds = new ArrayList<>();
        for (PostCommentRelation postCommentRelation : postCommentRelations) {
            commentIds.add(postCommentRelation.getCommentId());
        }

        List<CommentVO> commentVOS = new ArrayList<>();
        for (Long commentId : commentIds) {
            Comment comment = commentMapper.selectByPrimaryKey(commentId);
            commentVOS.add(CommentService.CommentToCommentVO(comment));
        }

        postCommentVO.setCommentVOS(commentVOS);

        return postCommentVO;
    }



//    public PostAO getPostById(Long id) throws NotFoundException {
//        PostAO postAO = new PostAO();
//        Post post = postMapper.selectByPrimaryKey(id);
//        if (post==null) {
//            throw new NotFoundException("Post not found");
//        }
//        postAO.setTitle(post.getName());
//        postAO.setPostType(post.getPostType());
//
//        // select post content
//        Example postContentExample = new Example(PostContent.class);
//        Example.Criteria postContentCriteria = postContentExample.createCriteria();
//        postContentCriteria.andEqualTo("id", post.getPostContentId());
//        PostContent postContent = postContentMapper.selectOneByExample(postContentExample);
//        postAO.setPostContent(postContent);
//
//        // select offer study
//        if (postAO.getPostType().equals(1)) {
//            Example offerStudyExample = new Example(OfferStudy.class);
//            Example.Criteria offerStudyCriteria = offerStudyExample.createCriteria();
//            offerStudyCriteria.andEqualTo("id", postContent.getOfferStudyId());
//            OfferStudy offerStudy = offerStudyMapper.selectOneByExample(offerStudyExample);
//            postAO.setOfferStudy(offerStudy);
//
//            // select offer bg
//            Example offerBgExample = new Example(OfferBg.class);
//            Example.Criteria offerBgCriteria = offerBgExample.createCriteria();
//            offerBgCriteria.andEqualTo("id", offerStudy.getOfferBgId());
//            OfferBg offerBg = offerBgMapper.selectOneByExample(offerBgExample);
//            postAO.setOfferBg(offerBg);
//        }
//
//        // select offer job
//        if (postAO.getPostType().equals(2)) {
//            Example offerJobExample = new Example(OfferJob.class);
//            Example.Criteria offerJobCriteria = offerJobExample.createCriteria();
//            offerJobCriteria.andEqualTo("id", postContent.getOfeerJobId());
//            OfferJob offerJob = offerJobMapper.selectOneByExample(offerJobExample);
//            postAO.setOfferJob(offerJob);
//
//            // select offer bg
//            Example offerBgExample = new Example(OfferBg.class);
//            Example.Criteria offerBgCriteria = offerBgExample.createCriteria();
//            offerBgCriteria.andEqualTo("id", offerJob.getOfferBgId());
//            OfferBg offerBg = offerBgMapper.selectOneByExample(offerBgExample);
//            postAO.setOfferBg(offerBg);
//        }
//
//        return postAO;
//    }

    public List<PostTagVO> listPosts() {
        List<Post> posts = postMapper.selectAll();
        List<PostTagVO> postTagVOS = new ArrayList<>();
        for (Post post: posts) {
            PostTagVO postTagVO = new PostTagVO();
            PostVO postVO = new PostVO();
            List<Tag> tags = findTag(post);
            postVO.setName(post.getName());
            postVO.setType(post.getPostType());
            postVO.setId(post.getId());
            postVO.setLikeCount(post.getLikeCount());
            postVO.setViewCount(post.getViewCount());
            postVO.setCollectionCount(post.getCollectionCount());
            postVO.setCommentCount(post.getCommentCount());
            postTagVO.setPostVO(postVO);
            postTagVO.setTags(tags);
            postTagVOS.add(postTagVO);
        }
        return postTagVOS;
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
        postVO.setType(post.getPostType());
        return postVO;
    }

    public static List<PostVO> PostsToPostVOS(List<Post> posts) {
        List<PostVO> postVOS = new ArrayList<>();
        for(Post post:posts) {
            PostVO postVO = new PostVO();
            postVO.setId(post.getId());
            postVO.setName(post.getName());
            postVO.setType(post.getPostType());
            postVO.setViewCount(post.getViewCount());
            postVO.setLikeCount(post.getLikeCount());
            postVO.setCommentCount(post.getCommentCount());
            postVO.setCollectionCount(post.getCollectionCount());
            postVOS.add(postVO);
        }
        return postVOS;
    }
}

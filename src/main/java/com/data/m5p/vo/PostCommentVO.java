package com.data.m5p.vo;

import com.data.m5p.pojo.OfferBg;
import com.data.m5p.pojo.PostContent;

import java.util.List;

public class PostCommentVO {
    private String title;
    private String university;
    private String major;
    private PostContent postContent;
    private OfferBg offerBg;
    private List<CommentVO> commentVOS;
    private Integer commentCount;
    private Integer likeCount;
    private Integer viewCount;
    private Integer CollectionCount;

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Integer getCollectionCount() {
        return CollectionCount;
    }

    public void setCollectionCount(Integer collectionCount) {
        CollectionCount = collectionCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public PostContent getPostContent() {
        return postContent;
    }

    public void setPostContent(PostContent postContent) {
        this.postContent = postContent;
    }

    public OfferBg getOfferBg() {
        return offerBg;
    }

    public void setOfferBg(OfferBg offerBg) {
        this.offerBg = offerBg;
    }

    public List<CommentVO> getCommentVOS() {
        return commentVOS;
    }

    public void setCommentVOS(List<CommentVO> commentVOS) {
        this.commentVOS = commentVOS;
    }
}

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

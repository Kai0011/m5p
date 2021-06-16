package com.data.m5p.ao;


import com.data.m5p.pojo.*;


public class PostAO {
    private Long userId;
    private String title;
    private Integer postType;
    private PostContent postContent;
    private OfferStudy offerStudy;
    private OfferJob offerJob;
    private OfferBg offerBg;

    public OfferStudy getOfferStudy() {
        return offerStudy;
    }

    public void setOfferStudy(OfferStudy offerStudy) {
        this.offerStudy = offerStudy;
    }

    public OfferJob getOfferJob() {
        return offerJob;
    }

    public void setOfferJob(OfferJob offerJob) {
        this.offerJob = offerJob;
    }

    public OfferBg getOfferBg() {
        return offerBg;
    }

    public void setOfferBg(OfferBg offerBg) {
        this.offerBg = offerBg;
    }

    public PostContent getPostContent() {
        return postContent;
    }

    public void setPostContent(PostContent postContent) {
        this.postContent = postContent;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPostType() {
        return postType;
    }

    public void setPostType(Integer postType) {
        this.postType = postType;
    }

}

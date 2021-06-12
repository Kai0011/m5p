package com.data.m5p.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "`offer_bg`")
public class OfferBg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "offer_study_id")
    private Long offerStudyId;

    @Column(name = "offer_job_id")
    private Long offerJobId;

    @Column(name = "post_content_id")
    private Long postContentId;

    private String gpa;

    private String test;

    @Column(name = "self_info")
    private String selfInfo;

    private String achievement;

    private String experience;

    @Column(name = "other_info")
    private String otherInfo;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "modified_date")
    private Date modifiedDate;

    private Integer status;

    private String content;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return offer_study_id
     */
    public Long getOfferStudyId() {
        return offerStudyId;
    }

    /**
     * @param offerStudyId
     */
    public void setOfferStudyId(Long offerStudyId) {
        this.offerStudyId = offerStudyId;
    }

    /**
     * @return offer_job_id
     */
    public Long getOfferJobId() {
        return offerJobId;
    }

    /**
     * @param offerJobId
     */
    public void setOfferJobId(Long offerJobId) {
        this.offerJobId = offerJobId;
    }

    /**
     * @return post_content_id
     */
    public Long getPostContentId() {
        return postContentId;
    }

    /**
     * @param postContentId
     */
    public void setPostContentId(Long postContentId) {
        this.postContentId = postContentId;
    }

    /**
     * @return gpa
     */
    public String getGpa() {
        return gpa;
    }

    /**
     * @param gpa
     */
    public void setGpa(String gpa) {
        this.gpa = gpa;
    }

    /**
     * @return test
     */
    public String getTest() {
        return test;
    }

    /**
     * @param test
     */
    public void setTest(String test) {
        this.test = test;
    }

    /**
     * @return self_info
     */
    public String getSelfInfo() {
        return selfInfo;
    }

    /**
     * @param selfInfo
     */
    public void setSelfInfo(String selfInfo) {
        this.selfInfo = selfInfo;
    }

    /**
     * @return achievement
     */
    public String getAchievement() {
        return achievement;
    }

    /**
     * @param achievement
     */
    public void setAchievement(String achievement) {
        this.achievement = achievement;
    }

    /**
     * @return experience
     */
    public String getExperience() {
        return experience;
    }

    /**
     * @param experience
     */
    public void setExperience(String experience) {
        this.experience = experience;
    }

    /**
     * @return other_info
     */
    public String getOtherInfo() {
        return otherInfo;
    }

    /**
     * @param otherInfo
     */
    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }

    /**
     * @return create_date
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * @return modified_date
     */
    public Date getModifiedDate() {
        return modifiedDate;
    }

    /**
     * @param modifiedDate
     */
    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    /**
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }
}
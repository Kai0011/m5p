package com.data.m5p.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "`post_content`")
public class PostContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "post_id")
    private Long postId;

    @Column(name = "offer_study_id")
    private Long offerStudyId;

    @Column(name = "offer_job_id")
    private Long offerJobId;

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
     * @return post_id
     */
    public Long getPostId() {
        return postId;
    }

    /**
     * @param postId
     */
    public void setPostId(Long postId) {
        this.postId = postId;
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
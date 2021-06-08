package com.data.m5p.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "`offer_bg`")
public class OfferBg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "offer_id")
    private Long offerId;

    @Column(name = "post_content_id")
    private Long postContentId;

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
     * @return offer_id
     */
    public Long getOfferId() {
        return offerId;
    }

    /**
     * @param offerId
     */
    public void setOfferId(Long offerId) {
        this.offerId = offerId;
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
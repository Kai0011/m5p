package com.data.m5p.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "`post`")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    /**
     * 1 - offer
2 - job
3 - other
     */
    @Column(name = "post_type")
    private Integer postType;

    @Column(name = "post_content_id")
    private Long postContentId;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "modified_date")
    private Date modifiedDate;

    private Integer status;

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
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取1 - offer
2 - job
3 - other
     *
     * @return post_type - 1 - offer
2 - job
3 - other
     */
    public Integer getPostType() {
        return postType;
    }

    /**
     * 设置1 - offer
2 - job
3 - other
     *
     * @param postType 1 - offer
2 - job
3 - other
     */
    public void setPostType(Integer postType) {
        this.postType = postType;
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
}
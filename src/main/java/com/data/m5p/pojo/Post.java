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

    @Column(name = "like_count")
    private Integer likeCount;

    @Column(name = "collection_count")
    private Integer collectionCount;

    @Column(name = "view_count")
    private Integer viewCount;

    @Column(name = "comment_count")
    private Integer commentCount;

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

    /**
     * @return like_count
     */
    public Integer getLikeCount() {
        return likeCount;
    }

    /**
     * @param likeCount
     */
    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    /**
     * @return collection_count
     */
    public Integer getCollectionCount() {
        return collectionCount;
    }

    /**
     * @param collectionCount
     */
    public void setCollectionCount(Integer collectionCount) {
        this.collectionCount = collectionCount;
    }

    /**
     * @return view_count
     */
    public Integer getViewCount() {
        return viewCount;
    }

    /**
     * @param viewCount
     */
    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    /**
     * @return comment_count
     */
    public Integer getCommentCount() {
        return commentCount;
    }

    /**
     * @param commentCount
     */
    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }
}
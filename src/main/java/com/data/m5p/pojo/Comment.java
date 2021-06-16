package com.data.m5p.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "`comment`")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    private Long replying;

    private Double rating;

    /**
     * 1 - post
2 - module
3 - other
     */
    @Column(name = "comment_type")
    private Integer commentType;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "modified_date")
    private Date modifiedDate;

    private Integer status;

    @Column(name = "like_count")
    private Integer likeCount;

    @Column(name = "reply_count")
    private Integer replyCount;

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

    /**
     * @return replying
     */
    public Long getReplying() {
        return replying;
    }

    /**
     * @param replying
     */
    public void setReplying(Long replying) {
        this.replying = replying;
    }

    /**
     * @return rating
     */
    public Double getRating() {
        return rating;
    }

    /**
     * @param rating
     */
    public void setRating(Double rating) {
        this.rating = rating;
    }

    /**
     * 获取1 - post
2 - module
3 - other
     *
     * @return comment_type - 1 - post
2 - module
3 - other
     */
    public Integer getCommentType() {
        return commentType;
    }

    /**
     * 设置1 - post
2 - module
3 - other
     *
     * @param commentType 1 - post
2 - module
3 - other
     */
    public void setCommentType(Integer commentType) {
        this.commentType = commentType;
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
     * @return reply_count
     */
    public Integer getReplyCount() {
        return replyCount;
    }

    /**
     * @param replyCount
     */
    public void setReplyCount(Integer replyCount) {
        this.replyCount = replyCount;
    }
}
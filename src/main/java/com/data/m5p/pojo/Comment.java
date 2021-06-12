package com.data.m5p.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "`comment`")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

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
}
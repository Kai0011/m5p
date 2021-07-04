package com.data.m5p.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "`module`")
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String time;

    private String requirement;

    private String briefing;

    private String icon;

    private Double rating;

    @Column(name = "comment_count")
    private Integer commentCount;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "modified_date")
    private Date modifiedDate;

    private Integer status;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "end_date")
    private String endDate;

    private String extra;

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
     * @return time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * @return requirement
     */
    public String getRequirement() {
        return requirement;
    }

    /**
     * @param requirement
     */
    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    /**
     * @return briefing
     */
    public String getBriefing() {
        return briefing;
    }

    /**
     * @param briefing
     */
    public void setBriefing(String briefing) {
        this.briefing = briefing;
    }

    /**
     * @return icon
     */
    public String getIcon() {
        return icon;
    }

    /**
     * @param icon
     */
    public void setIcon(String icon) {
        this.icon = icon;
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
     * @return start_date
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * @param startDate
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * @return end_date
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * @param endDate
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * @return extra
     */
    public String getExtra() {
        return extra;
    }

    /**
     * @param extra
     */
    public void setExtra(String extra) {
        this.extra = extra;
    }
}
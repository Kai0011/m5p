package com.data.m5p.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "`gpa`")
public class Gpa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "personal_info_id")
    private Long personalInfoId;

    @Column(name = "year1_score")
    private Long year1Score;

    @Column(name = "year1_rank")
    private String year1Rank;

    @Column(name = "year1_gpa")
    private Long year1Gpa;

    @Column(name = "year2_score")
    private Long year2Score;

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
     * @return personal_info_id
     */
    public Long getPersonalInfoId() {
        return personalInfoId;
    }

    /**
     * @param personalInfoId
     */
    public void setPersonalInfoId(Long personalInfoId) {
        this.personalInfoId = personalInfoId;
    }

    /**
     * @return year1_score
     */
    public Long getYear1Score() {
        return year1Score;
    }

    /**
     * @param year1Score
     */
    public void setYear1Score(Long year1Score) {
        this.year1Score = year1Score;
    }

    /**
     * @return year1_rank
     */
    public String getYear1Rank() {
        return year1Rank;
    }

    /**
     * @param year1Rank
     */
    public void setYear1Rank(String year1Rank) {
        this.year1Rank = year1Rank;
    }

    /**
     * @return year1_gpa
     */
    public Long getYear1Gpa() {
        return year1Gpa;
    }

    /**
     * @param year1Gpa
     */
    public void setYear1Gpa(Long year1Gpa) {
        this.year1Gpa = year1Gpa;
    }

    /**
     * @return year2_score
     */
    public Long getYear2Score() {
        return year2Score;
    }

    /**
     * @param year2Score
     */
    public void setYear2Score(Long year2Score) {
        this.year2Score = year2Score;
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
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

    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "year1_score")
    private Long year1Score;

    @Column(name = "year1_rank")
    private String year1Rank;

    @Column(name = "year2_score")
    private Long year2Score;

    @Column(name = "year2_rank")
    private String year2Rank;

    @Column(name = "year3_score")
    private Long year3Score;

    @Column(name = "year3_rank")
    private String year3Rank;

    @Column(name = "year4_score")
    private Long year4Score;

    @Column(name = "year4_rank")
    private String year4Rank;

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
     * @return student_id
     */
    public Long getStudentId() {
        return studentId;
    }

    /**
     * @param studentId
     */
    public void setStudentId(Long studentId) {
        this.studentId = studentId;
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
     * @return year2_rank
     */
    public String getYear2Rank() {
        return year2Rank;
    }

    /**
     * @param year2Rank
     */
    public void setYear2Rank(String year2Rank) {
        this.year2Rank = year2Rank;
    }

    /**
     * @return year3_score
     */
    public Long getYear3Score() {
        return year3Score;
    }

    /**
     * @param year3Score
     */
    public void setYear3Score(Long year3Score) {
        this.year3Score = year3Score;
    }

    /**
     * @return year3_rank
     */
    public String getYear3Rank() {
        return year3Rank;
    }

    /**
     * @param year3Rank
     */
    public void setYear3Rank(String year3Rank) {
        this.year3Rank = year3Rank;
    }

    /**
     * @return year4_score
     */
    public Long getYear4Score() {
        return year4Score;
    }

    /**
     * @param year4Score
     */
    public void setYear4Score(Long year4Score) {
        this.year4Score = year4Score;
    }

    /**
     * @return year4_rank
     */
    public String getYear4Rank() {
        return year4Rank;
    }

    /**
     * @param year4Rank
     */
    public void setYear4Rank(String year4Rank) {
        this.year4Rank = year4Rank;
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
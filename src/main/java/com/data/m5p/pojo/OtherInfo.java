package com.data.m5p.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "`other_info`")
public class OtherInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "personal_info_id")
    private Long personalInfoId;

    @Column(name = "student_id")
    private Long studentId;

    private String technique;

    private String field;

    private String interest;

    private String website;

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
     * @return technique
     */
    public String getTechnique() {
        return technique;
    }

    /**
     * @param technique
     */
    public void setTechnique(String technique) {
        this.technique = technique;
    }

    /**
     * @return field
     */
    public String getField() {
        return field;
    }

    /**
     * @param field
     */
    public void setField(String field) {
        this.field = field;
    }

    /**
     * @return interest
     */
    public String getInterest() {
        return interest;
    }

    /**
     * @param interest
     */
    public void setInterest(String interest) {
        this.interest = interest;
    }

    /**
     * @return website
     */
    public String getWebsite() {
        return website;
    }

    /**
     * @param website
     */
    public void setWebsite(String website) {
        this.website = website;
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
package com.data.m5p.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "`personal_info`")
public class PersonalInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "gpa_id")
    private Long gpaId;

    @Column(name = "test_id")
    private Long testId;

    @Column(name = "self_intro_id")
    private Long selfIntroId;

    @Column(name = "achivement_id")
    private Long achivementId;

    @Column(name = "experience_id")
    private Long experienceId;

    @Column(name = "other_info_id")
    private Long otherInfoId;

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
     * @return user_id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * @return gpa_id
     */
    public Long getGpaId() {
        return gpaId;
    }

    /**
     * @param gpaId
     */
    public void setGpaId(Long gpaId) {
        this.gpaId = gpaId;
    }

    /**
     * @return test_id
     */
    public Long getTestId() {
        return testId;
    }

    /**
     * @param testId
     */
    public void setTestId(Long testId) {
        this.testId = testId;
    }

    /**
     * @return self_intro_id
     */
    public Long getSelfIntroId() {
        return selfIntroId;
    }

    /**
     * @param selfIntroId
     */
    public void setSelfIntroId(Long selfIntroId) {
        this.selfIntroId = selfIntroId;
    }

    /**
     * @return achivement_id
     */
    public Long getAchivementId() {
        return achivementId;
    }

    /**
     * @param achivementId
     */
    public void setAchivementId(Long achivementId) {
        this.achivementId = achivementId;
    }

    /**
     * @return experience_id
     */
    public Long getExperienceId() {
        return experienceId;
    }

    /**
     * @param experienceId
     */
    public void setExperienceId(Long experienceId) {
        this.experienceId = experienceId;
    }

    /**
     * @return other_info_id
     */
    public Long getOtherInfoId() {
        return otherInfoId;
    }

    /**
     * @param otherInfoId
     */
    public void setOtherInfoId(Long otherInfoId) {
        this.otherInfoId = otherInfoId;
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
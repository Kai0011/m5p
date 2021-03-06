package com.data.m5p.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "`offer_study`")
public class OfferStudy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String university;

    private String project;

    @Column(name = "offer_bg_id")
    private Long offerBgId;

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
     * @return university
     */
    public String getUniversity() {
        return university;
    }

    /**
     * @param university
     */
    public void setUniversity(String university) {
        this.university = university;
    }

    /**
     * @return project
     */
    public String getProject() {
        return project;
    }

    /**
     * @param project
     */
    public void setProject(String project) {
        this.project = project;
    }

    /**
     * @return offer_bg_id
     */
    public Long getOfferBgId() {
        return offerBgId;
    }

    /**
     * @param offerBgId
     */
    public void setOfferBgId(Long offerBgId) {
        this.offerBgId = offerBgId;
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
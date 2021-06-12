package com.data.m5p.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "`user`")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login_name")
    private String loginName;

    @Column(name = "login_psw")
    private String loginPsw;

    private String icon;

    @Column(name = "display_name")
    private String displayName;

    @Column(name = "real_name")
    private String realName;

    /**
     * 1 - male
2 - female
3 - other
     */
    private Integer gender;

    /**
     * 1 - student
2 - convenor
3 - third_party
     */
    @Column(name = "user_type")
    private Integer userType;

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
     * @return login_name
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * @param loginName
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    /**
     * @return login_psw
     */
    public String getLoginPsw() {
        return loginPsw;
    }

    /**
     * @param loginPsw
     */
    public void setLoginPsw(String loginPsw) {
        this.loginPsw = loginPsw;
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
     * @return display_name
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * @param displayName
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * @return real_name
     */
    public String getRealName() {
        return realName;
    }

    /**
     * @param realName
     */
    public void setRealName(String realName) {
        this.realName = realName;
    }

    /**
     * 获取1 - male
2 - female
3 - other
     *
     * @return gender - 1 - male
2 - female
3 - other
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * 设置1 - male
2 - female
3 - other
     *
     * @param gender 1 - male
2 - female
3 - other
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     * 获取1 - student
2 - convenor
3 - third_party
     *
     * @return user_type - 1 - student
2 - convenor
3 - third_party
     */
    public Integer getUserType() {
        return userType;
    }

    /**
     * 设置1 - student
2 - convenor
3 - third_party
     *
     * @param userType 1 - student
2 - convenor
3 - third_party
     */
    public void setUserType(Integer userType) {
        this.userType = userType;
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
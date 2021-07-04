package com.data.m5p.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "`user_token`")
public class UserToken {
    @Id
    @Column(name = "user_id")
    private Long userId;

    private String token;

    private Date expire;

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
     * @return token
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * @return expire
     */
    public Date getExpire() {
        return expire;
    }

    /**
     * @param expire
     */
    public void setExpire(Date expire) {
        this.expire = expire;
    }
}
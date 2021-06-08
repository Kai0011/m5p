package com.data.m5p.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "`notification`")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @Column(name = "receiver_type")
    private Integer receiverType;

    @Column(name = "receiver_id")
    private Long receiverId;

    @Column(name = "sender_type")
    private Integer senderType;

    @Column(name = "sender_id")
    private Long senderId;

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
     * @return receiver_type
     */
    public Integer getReceiverType() {
        return receiverType;
    }

    /**
     * @param receiverType
     */
    public void setReceiverType(Integer receiverType) {
        this.receiverType = receiverType;
    }

    /**
     * @return receiver_id
     */
    public Long getReceiverId() {
        return receiverId;
    }

    /**
     * @param receiverId
     */
    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    /**
     * @return sender_type
     */
    public Integer getSenderType() {
        return senderType;
    }

    /**
     * @param senderType
     */
    public void setSenderType(Integer senderType) {
        this.senderType = senderType;
    }

    /**
     * @return sender_id
     */
    public Long getSenderId() {
        return senderId;
    }

    /**
     * @param senderId
     */
    public void setSenderId(Long senderId) {
        this.senderId = senderId;
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
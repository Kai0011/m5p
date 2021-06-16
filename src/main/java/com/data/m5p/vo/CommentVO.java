package com.data.m5p.vo;

public class CommentVO {
    private Long id;
    private String content;
    private Integer type;
    private Double rating;
    private Long replying;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Long getReplying() {
        return replying;
    }

    public void setReplying(Long replying) {
        this.replying = replying;
    }
}

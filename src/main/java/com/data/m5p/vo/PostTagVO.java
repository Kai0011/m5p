package com.data.m5p.vo;

import com.data.m5p.pojo.Tag;

import java.util.List;

public class PostTagVO {
    private PostVO postVO;
    private List<Tag> tags;

    public PostVO getPostVO() {
        return postVO;
    }

    public void setPostVO(PostVO postVO) {
        this.postVO = postVO;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}

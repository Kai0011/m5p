package com.data.m5p.ao;

import com.data.m5p.pojo.Tag;

import java.util.List;

public class PostTagAO {
    private PostAO postAO;
    private List<Tag> tags;

    public PostAO getPostAO() {
        return postAO;
    }

    public void setPostAO(PostAO postAO) {
        this.postAO = postAO;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}

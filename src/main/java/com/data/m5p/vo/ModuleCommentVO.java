package com.data.m5p.vo;

import java.util.List;

public class ModuleCommentVO {
    private ModuleVO moduleVO;
    private List<CommentVO> commentVOS;

    public ModuleVO getModuleVO() {
        return moduleVO;
    }

    public void setModuleVO(ModuleVO moduleVO) {
        this.moduleVO = moduleVO;
    }

    public List<CommentVO> getCommentVOS() {
        return commentVOS;
    }

    public void setCommentVOS(List<CommentVO> commentVOS) {
        this.commentVOS = commentVOS;
    }
}

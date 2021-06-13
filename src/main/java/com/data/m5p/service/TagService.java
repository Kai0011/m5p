package com.data.m5p.service;

import com.data.m5p.common.IdWorker;
import com.data.m5p.idworker.DatacenterId;
import com.data.m5p.mapper.TagMapper;
import com.data.m5p.pojo.Tag;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class TagService {
    @Resource
    private TagMapper tagMapper;

    private IdWorker idWorker = new IdWorker(1, DatacenterId.Tag.getValue(), 1);

    public void createTag(Tag tag) {
        tag.setId(idWorker.nextId());
        tag.setStatus(1);
        tag.setCreateDate(new Date());
        tag.setModifiedDate(new Date());

        tagMapper.insert(tag);
    }
}

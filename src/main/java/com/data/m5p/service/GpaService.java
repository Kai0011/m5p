package com.data.m5p.service;

import com.data.m5p.common.IdWorker;
import com.data.m5p.idworker.DatacenterId;
import com.data.m5p.mapper.GpaMapper;
import com.data.m5p.pojo.Gpa;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class GpaService {
    @Resource
    private GpaMapper gpaMapper;

    private IdWorker idWorker = new IdWorker(1, DatacenterId.Bg.getValue(), 1);

    public void updateGpa(Gpa gpa) {
        gpa.setModifiedDate(new Date());
        gpaMapper.updateByPrimaryKeySelective(gpa);
    }
}

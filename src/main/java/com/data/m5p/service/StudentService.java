package com.data.m5p.service;

import com.data.m5p.common.IdWorker;
import com.data.m5p.idworker.DatacenterId;
import com.data.m5p.mapper.StudentMapper;
import com.data.m5p.pojo.Student;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class StudentService {
    @Resource
    private StudentMapper studentMapper;

    private IdWorker idWorker = new IdWorker(1, DatacenterId.Student.getValue(), 1);

    public void createStudent (Student student) {

        student.setId(idWorker.nextId());
        student.setStatus(1);
        student.setCreateDate(new Date());
        student.setModifiedDate(new Date());
        studentMapper.insert(student);

        System.out.println(student.getId());
    }

    public void updateStudent(Student student) {
        student.setModifiedDate(new Date());
        studentMapper.updateByPrimaryKeySelective(student);
    }


}

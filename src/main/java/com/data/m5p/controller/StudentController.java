package com.data.m5p.controller;

import com.data.m5p.common.CommonResult;
import com.data.m5p.pojo.Gpa;
import com.data.m5p.pojo.Student;
import com.data.m5p.pojo.User;
import com.data.m5p.service.GpaService;
import com.data.m5p.service.StudentService;
import com.data.m5p.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin(origins = "*")
@RestController
public class StudentController {
    @Resource
    private StudentService studentService;
    @Resource
    private UserService userService;
    @Resource
    private GpaService gpaService;

    @PutMapping("/students/info/{id}")
    private CommonResult<String> updateInfo(@PathVariable Long id, @RequestBody Student student, User user) {
        studentService.updateStudent(student);
        userService.updateUser(user);

        return CommonResult.success("update student successfully");
    }

    @PutMapping("/students/gpa/{id}")
    private CommonResult<String> updateGpa(@PathVariable Long id, @RequestBody Gpa gpa) {
        gpaService.updateGpa(gpa);

        return CommonResult.success("update gpa successfully");
    }

}

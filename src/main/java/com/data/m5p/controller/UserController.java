package com.data.m5p.controller;

import com.data.m5p.common.CommonResult;
import com.data.m5p.pojo.User;
import com.data.m5p.service.UserService;
import com.data.m5p.vo.UserVO;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin(origins = "*")
@RestController
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/users")
    public CommonResult<String> createUser(@RequestBody User user) throws Exception {

        userService.createUser(user);

        return CommonResult.success("create user successfully");
    }

    @GetMapping("/users/{id}")
    public CommonResult<UserVO> getUser(@PathVariable Long id) throws NotFoundException {

        User user = userService.getUserById(id);
        UserVO userVO = UserService.UserToUserVO(user);

        return CommonResult.success(userVO);
    }

    @PutMapping("/users/{id}")
    public CommonResult<String> updateUser(@PathVariable Long id, @RequestBody User user) {

        userService.updateUser(user);

        return CommonResult.success("update user successfully");
    }

    @DeleteMapping("/users/{id}")
    public CommonResult<String> deleteUser(@PathVariable Long id) {

        userService.deleteUser(id);

        return CommonResult.success("delete user successfully");
    }

}
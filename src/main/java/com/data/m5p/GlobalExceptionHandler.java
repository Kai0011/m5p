package com.data.m5p;

import com.data.m5p.common.CommonResult;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = NotFoundException.class)
    @ResponseBody
    public CommonResult<String> notFoundExceptionHandler(NotFoundException e){
        return CommonResult.failed(e.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public CommonResult<String> exceptionHandler(Exception e){
        e.printStackTrace();
        return CommonResult.failed(e.getMessage());
    }
}

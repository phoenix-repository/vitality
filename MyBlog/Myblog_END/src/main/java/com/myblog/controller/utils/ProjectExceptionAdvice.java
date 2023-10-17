package com.myblog.controller.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice

public class ProjectExceptionAdvice {

    // 全局异常处理
    @ExceptionHandler
    public ResultVO  handlerException(Exception e) {
        e.printStackTrace();
        return new ResultVO("服务器异常!");
    }

}

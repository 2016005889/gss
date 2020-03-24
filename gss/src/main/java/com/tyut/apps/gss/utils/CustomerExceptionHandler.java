package com.tyut.apps.gss.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomerExceptionHandler {

    //将异常信息进行拦截
    @ExceptionHandler(value = Exception.class)
    public <E> Message handler(Exception exception) {
        //将拦截到的异常信息封装为Message，然后交给Controller返回给前端
        exception.printStackTrace();

        if (exception instanceof CustomerException) {
            return MessageUtil.error(exception.getMessage());
        } else {
            return MessageUtil.error("后台系统异常");
        }

    }

}

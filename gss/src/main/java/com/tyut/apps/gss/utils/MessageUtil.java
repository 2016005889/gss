package com.tyut.apps.gss.utils;

import java.util.Date;

/**
 * 消息工具类
 */
public class MessageUtil {

    //适用于查询接口
    public static  Message success(Object data){
        return new Message(200,"success",data,(new Date().getTime()));
    }

    //适用于更新接口---增删改
    public static Message success(String message){
        return new Message(200,message,null,(new Date().getTime()));
    }

    public static Message error(String message){
        return new Message(200,message,null,(new Date().getTime()));
    }

    //适用于其他接口
    public static Message message(int status,String message,Object data){
        return new Message(500,message,null,(new Date().getTime()));
    }
}

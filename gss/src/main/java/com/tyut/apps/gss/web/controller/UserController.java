package com.tyut.apps.gss.web.controller;

import com.tyut.apps.gss.bean.extend.BaseExtend;
import com.tyut.apps.gss.service.IBaseService;
import com.tyut.apps.gss.service.ILoginService;
import com.tyut.apps.gss.utils.JwtTokenUtil;
import com.tyut.apps.gss.utils.Message;
import com.tyut.apps.gss.utils.MessageUtil;
import com.tyut.apps.gss.vm.UserVm;
import io.jsonwebtoken.Claims;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private IBaseService baseService;

    @Resource
    private ILoginService loginService;

    @PostMapping("login")
    public Message login(@RequestBody UserVm userVm){

        //BaseExtend baseExtend = baseService.selectBaseBySno(userVm.getUsername());

        BaseExtend baseExtend = loginService.userLogin(userVm);

        String token = JwtTokenUtil.createJwt(baseExtend.getSno());

       // System.out.println(token);

        //认证用户的用户名和密码
        //如果成功产生token，将token缓存起来 返回
        //如果登录失败抛异常
        HashMap<String, String> map = new HashMap<>();
        map.put("token",token);
        return MessageUtil.success(map);
    }

    //通过token获取用户的基本信息
    @GetMapping("info")
    public Message info(String token){
        //通过token获取用户信{bid,name,gender...}

//        Map<String,Object> map = new HashMap<>();
//        map.put("username","2016005889");
//        map.put("roles",new String[]{"学生"});
//        map.put("avatar","");
//        map.put("introduction","您的角色是一名学生");
        Claims claims = JwtTokenUtil.parseJwt(token);
        String sno = claims.getSubject();



        BaseExtend baseExtend = baseService.selectBaseBySno(sno);
        String rname = baseExtend.getRoles().getRname();
        Map<String,Object> map = new HashMap<>();
        map.put("username",baseExtend.getSno());
        map.put("roles",new String[]{rname});
        return MessageUtil.success(map);
    }

    @PostMapping("logout")
    public Message logout(String token){
        return MessageUtil.success("退出成功");
    }
}

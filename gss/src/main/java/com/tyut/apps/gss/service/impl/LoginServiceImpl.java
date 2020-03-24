package com.tyut.apps.gss.service.impl;

import com.tyut.apps.gss.bean.extend.BaseExtend;
import com.tyut.apps.gss.service.IBaseService;
import com.tyut.apps.gss.service.ILoginService;
import com.tyut.apps.gss.vm.UserVm;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginServiceImpl implements ILoginService {

    @Resource
    private IBaseService baseService;


    @Override
    public BaseExtend userLogin(UserVm userVm) throws RuntimeException {
        //判断学号是否为空
        if(userVm.getUsername() == null){
            throw new RuntimeException("学号为空，请输入学号");
        }
        //学号不为空，查找该学号对应的用户信息
        BaseExtend base = baseService.selectBaseBySno(userVm.getUsername());
        //判断是否存在该用户，如果不存在，抛出异常，如果存在比较密码
        if(base == null){
            throw new RuntimeException("该用户不存在");
        }

        //将该用户的密码与输入的密码进行比较
        if(!base.getPassword().equals(userVm.getPassword())){
            throw new RuntimeException("密码错误");
        }


        return base;
    }
}

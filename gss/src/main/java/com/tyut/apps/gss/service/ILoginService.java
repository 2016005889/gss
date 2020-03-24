package com.tyut.apps.gss.service;

import com.tyut.apps.gss.bean.extend.BaseExtend;
import com.tyut.apps.gss.vm.UserVm;

public interface ILoginService {

    //登录验证的方法
    BaseExtend userLogin(UserVm userVm) throws RuntimeException;
}

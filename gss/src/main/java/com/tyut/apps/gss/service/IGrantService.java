package com.tyut.apps.gss.service;

import com.tyut.apps.gss.bean.Grant;

public interface IGrantService {

    //查询助学金的申请信息
    Grant selectGrantByBaseId(Integer baseId) throws RuntimeException;

    //保存或更改助学金的申请信息
    void saveOrUpdateGrant(Grant grant)throws RuntimeException;

    //修改助学金申请的状态
    void updateGrantStatus(Integer gid) throws RuntimeException;
}

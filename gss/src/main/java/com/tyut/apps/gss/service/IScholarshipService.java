package com.tyut.apps.gss.service;

import com.tyut.apps.gss.bean.Scholarship;

public interface IScholarshipService {

    //查询奖学金的信息
    Scholarship selectScholarshipByBaseId(Integer baseId) throws RuntimeException;

    //保存或更新奖学金的信息
    void saveOrUpdateScholarship(Scholarship scholarship) throws  RuntimeException;

    //更改奖学金的状态
    void updateScholarshipStatus(Integer scid) throws RuntimeException;
}

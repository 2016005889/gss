package com.tyut.apps.gss.service;

import com.tyut.apps.gss.bean.extend.CheckGrant;
import com.tyut.apps.gss.bean.extend.CheckScholarship;

import java.util.List;

public interface ICheckService {

    //查询所有助学金申请
    List<CheckGrant> selectAllGrant() throws RuntimeException;

    //查询所有奖学金申请
    List<CheckScholarship> selectAllScholarship() throws RuntimeException;
}

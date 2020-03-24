package com.tyut.apps.gss.service;

import com.tyut.apps.gss.bean.Detailed;

public interface IDetailedService {

    //根据baseId查询详细信息
    Detailed selectDetailedByBaseId(Integer baseId) throws RuntimeException;

    //保存或更新详细信息
    void saveOrUpdateDetailed(Detailed detailed) throws RuntimeException;

    //根据学号查询用户的详细信息
    Detailed selectDetailedBySno(String sno) throws  RuntimeException;

}
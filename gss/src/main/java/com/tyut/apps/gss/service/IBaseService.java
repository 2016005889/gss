package com.tyut.apps.gss.service;

import com.tyut.apps.gss.bean.Base;
import com.tyut.apps.gss.bean.extend.BaseExtend;

import java.util.List;

public interface IBaseService {
    //查询所有基本信息
    List<BaseExtend> selectAllBases()throws RuntimeException;

    //根据bid查询基本信息
    BaseExtend selectBaseByBid(Integer bid) throws RuntimeException;

    //根据name查找基本信息
    BaseExtend selectBaseByName(String name) throws  RuntimeException;

    //根据Sno查找基本信息
    BaseExtend selectBaseBySno(String sno) throws RuntimeException;

    //根据角色名称来查询基本信息
    List<BaseExtend> selectBaseByRoleRname(String rname) throws RuntimeException;

    //保存或更新基本信息
    void saveOrUpdateBase(Base base) throws  RuntimeException;

    //根据bid删除基本信息
    void deleteBaseByBid(Integer bid) throws RuntimeException;

    //根据bid批量删除基本信息
    void batchDeletBase(Integer[] bids) throws RuntimeException;

    List<BaseExtend> selectBaseByRid(Integer rid) throws RuntimeException;
}

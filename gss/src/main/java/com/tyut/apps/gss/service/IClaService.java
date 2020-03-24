package com.tyut.apps.gss.service;

import com.tyut.apps.gss.bean.Cla;

import java.util.List;

public interface IClaService {

    //查询所有班级
    List<Cla> selectAllClas() throws RuntimeException;

    //插入或修改班级
    void saveOrUpdateCla(Cla cla) throws RuntimeException;

    //根据班级名称查询班级
    Cla selectClaByCname(String cname) throws RuntimeException;

    //删除角色
    void deleteClaByCid(Integer cid) throws RuntimeException;
}

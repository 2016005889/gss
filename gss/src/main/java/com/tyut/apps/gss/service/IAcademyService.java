package com.tyut.apps.gss.service;

import com.tyut.apps.gss.bean.Academy;

import java.util.List;

public interface IAcademyService {

    //查找所有学院
    List<Academy> selectAllAcademys() throws RuntimeException;

    //根据学院名称查找学院
    Academy selectAcademyByAname(String aname) throws  RuntimeException;

    //保存或更新学院信息
    void saveOrUpdateAcademy(Academy academy) throws RuntimeException;

    //删除学院
    void deleteAcademyByAid(Integer rid) throws RuntimeException;

}

package com.tyut.apps.gss.service;

import com.tyut.apps.gss.bean.Role;

import java.util.List;

public interface IRoleService {



    //查询角色
    List<Role> selectAllRoles() throws RuntimeException;
    //更新/添加角色
    void saveOrUpdateRole(Role role) throws RuntimeException;
    //删除角色
    void deleteRole(Integer rid) throws RuntimeException;
    //根据角色名来查找
    Role selectRoleByRname(String rname) throws  RuntimeException;
}

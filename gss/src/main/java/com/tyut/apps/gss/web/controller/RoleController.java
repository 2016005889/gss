package com.tyut.apps.gss.web.controller;

import com.tyut.apps.gss.bean.Role;
import com.tyut.apps.gss.service.IRoleService;
import com.tyut.apps.gss.utils.Message;
import com.tyut.apps.gss.utils.MessageUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("gss")
public class RoleController {


    @Resource
    private IRoleService roleService;

    /**
     * 查找所有角色
     * @return
     */
    @GetMapping("findAllRoles")
    public Message findAllRoles(){
        List<Role> roles = roleService.selectAllRoles();
        return MessageUtil.success(roles);
    }

    /**
     * 插入或更新角色
     * @param rid
     * @param rname
     * @return
     */
    @PostMapping ("saveOrUpdateRole")
    public Message saveOrUpdateRole(Integer rid,String rname){
        Role role = new Role();
        role.setRid(rid);
        role.setRname(rname);
        roleService.saveOrUpdateRole(role);
        return MessageUtil.success("更新或插入成功");
    }

    /**
     * 删除角色
     * @param rid
     * @return
     */
    @GetMapping("deleteRoleByRid")
    public Message deleteRoleByRid(Integer rid){
       roleService.deleteRole(rid);
       return MessageUtil.success("删除成功");
    }

    /**
     * 根据角色名来查找
     */
    @GetMapping("findRoleByRname")
    public Message findRoleByName(String rname){
        Role role = roleService.selectRoleByRname(rname);
        return MessageUtil.success(role);
    }
}

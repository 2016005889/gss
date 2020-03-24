package com.tyut.apps.gss.service.impl;

import com.tyut.apps.gss.bean.Role;
import com.tyut.apps.gss.bean.RoleExample;
import com.tyut.apps.gss.mapper.RoleMapper;
import com.tyut.apps.gss.service.IRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RolesServiceImpl implements IRoleService {

    @Resource
    private RoleMapper roleMapper;

    @Resource
    private RoleExample roleExample;

    /**
     * 查询所有
     * @return
     * @throws RuntimeException
     */
    @Override
    public List<Role> selectAllRoles() throws RuntimeException{
        List<Role> roles = roleMapper.selectByExample(roleExample);
        return roles;
    }

    /**
     * 插入或更新角色
     * @param role
     */
    @Override
    public void saveOrUpdateRole(Role role) throws RuntimeException{
        if(role == null){
            throw new RuntimeException("角色为空");
        }
       if(role.getRid() == null){
           Role role1 = roleMapper.selectByRname(role.getRname());
           if(role1 != null){
               throw new RuntimeException("该角色已存在");
           }
           roleMapper.insert(role);
       }else {
           roleMapper.updateByPrimaryKey(role);
       }
    }

    /**
     * 删除角色
     * @param rid
     * @throws RuntimeException
     */
    @Override
    public void deleteRole(Integer rid) throws RuntimeException {
        if(rid == null){
            throw new RuntimeException("该角色不存在");
        }
        roleMapper.deleteByPrimaryKey(rid);
    }

    @Override
    public Role selectRoleByRname(String rname) throws RuntimeException {
        return roleMapper.selectByRname(rname);
    }

}

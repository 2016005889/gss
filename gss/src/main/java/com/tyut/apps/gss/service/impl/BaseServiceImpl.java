package com.tyut.apps.gss.service.impl;

import com.tyut.apps.gss.bean.Base;
import com.tyut.apps.gss.bean.BaseExample;
import com.tyut.apps.gss.bean.Role;
import com.tyut.apps.gss.bean.extend.BaseExtend;
import com.tyut.apps.gss.mapper.BaseMapper;
import com.tyut.apps.gss.mapper.RoleMapper;
import com.tyut.apps.gss.mapper.extend.BaseExtendMapper;
import com.tyut.apps.gss.service.IBaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BaseServiceImpl implements IBaseService {


    @Resource
    private BaseExtendMapper baseExtendMapper;

    @Resource
    private BaseMapper baseMapper;
    @Resource
    private RoleMapper roleMapper;

    @Resource
    private BaseExample baseExample;

    /**
     * 查询所有基本信息
     * @return
     * @throws RuntimeException
     */
    @Override
    public List<BaseExtend> selectAllBases() throws RuntimeException {
        return baseExtendMapper.selectAllBase();
    }

    /**
     * 依据bid查找基本信息
     * @param bid
     * @return
     * @throws RuntimeException
     */
    @Override
    public BaseExtend selectBaseByBid(Integer bid) throws RuntimeException {
        return baseExtendMapper.selectBaseByBid(bid);
    }

    /**
     * 根据name查找基本信息
     * @param name
     * @return
     * @throws RuntimeException
     */
    @Override
    public BaseExtend selectBaseByName(String name) throws RuntimeException {
        return baseExtendMapper.selectBaseByName(name);
    }

    /**
     * 根据Sno查找基本信息
     * @param sno
     * @return
     * @throws RuntimeException
     */
    @Override
    public BaseExtend selectBaseBySno(String sno) throws RuntimeException {
        return baseExtendMapper.selectBaseBySno(sno);
    }

    /**
     * 根据角色名称来查询基本信息
     * @param rname
     * @return
     * @throws RuntimeException
     */
    @Override
    public List<BaseExtend> selectBaseByRoleRname(String rname) throws RuntimeException {
        Role role = roleMapper.selectByRname(rname);
        List<BaseExtend> bases = baseExtendMapper.selectBaseByRid(role.getRid());

        return bases;
    }

    /**
     * 保存或更新基本信息
     * @param base
     * @throws RuntimeException
     */
    @Override
    public void saveOrUpdateBase(Base base) throws RuntimeException {
        if(base == null){
            throw new RuntimeException("基本信息为空");
        }
        Base b = baseMapper.selectByPrimaryKey(base.getBid());
        if(b != null){
            baseMapper.updateByPrimaryKey(base);
        }else{
            baseMapper.insert(base);
        }
    }

    /**
     * 根据bid删除基本信息
     * @param bid
     * @throws RuntimeException
     */
    @Override
    public void deleteBaseByBid(Integer bid) throws RuntimeException {
        baseMapper.deleteByPrimaryKey(bid);
    }

    /**
     * 批量删除基本信息
     * @param bids
     * @throws RuntimeException
     */
    @Override
    public void batchDeletBase(Integer[] bids) throws RuntimeException {
        for (int i = 0; i < bids.length; i++) {
            baseMapper.deleteByPrimaryKey(bids[i]);
        }
    }

    @Override
    public List<BaseExtend> selectBaseByRid(Integer rid) throws RuntimeException {
        return baseExtendMapper.selectBaseByRid(rid);
    }


}

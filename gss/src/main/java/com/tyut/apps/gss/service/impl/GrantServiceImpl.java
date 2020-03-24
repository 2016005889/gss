package com.tyut.apps.gss.service.impl;

import com.tyut.apps.gss.bean.Grant;
import com.tyut.apps.gss.bean.GrantExample;
import com.tyut.apps.gss.mapper.GrantMapper;
import com.tyut.apps.gss.service.IGrantService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class GrantServiceImpl implements IGrantService {

    @Resource
    private GrantMapper grantMapper;
    @Resource
    private GrantExample grantExample;

    /**
     * 查询助学金申请的信息
     * @param baseId
     * @return
     * @throws RuntimeException
     */
    @Override
    public Grant selectGrantByBaseId(Integer baseId) throws RuntimeException {
        return grantMapper.selectGrantByBaseId(baseId);
    }

    /**
     * 保存或更新助学金的申请信息
     * @param grant
     * @throws RuntimeException
     */
    @Override
    public void saveOrUpdateGrant(Grant grant) throws RuntimeException {

        if(grant == null){
            throw new RuntimeException("该信息为空");
        }
        //根据gid查询是否存在该助学金的记录
        Grant g = grantMapper.selectByPrimaryKey(grant.getGid());
        //如果存在该记录，则依据gid来更新该记录的信息
        if(g != null){
            grantMapper.updateByPrimaryKey(grant);

        }else{
            //否则插入一条记录
            grantMapper.insert(grant);
        }

    }

    /**
     * 更新助学金申请的状态
     * @param gid
     * @throws RuntimeException
     */
    @Override
    public void updateGrantStatus(Integer gid) throws RuntimeException {
        grantMapper.updateGrantStatus(gid);
    }
}

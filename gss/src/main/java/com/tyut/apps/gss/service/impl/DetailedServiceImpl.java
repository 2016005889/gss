package com.tyut.apps.gss.service.impl;

import com.tyut.apps.gss.bean.Detailed;
import com.tyut.apps.gss.bean.extend.BaseExtend;
import com.tyut.apps.gss.mapper.DetailedMapper;
import com.tyut.apps.gss.service.IBaseService;
import com.tyut.apps.gss.service.IDetailedService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DetailedServiceImpl implements IDetailedService {

    @Resource
    private DetailedMapper detailedMapper;

    @Resource
    private IBaseService baseService;

    /**
     * 根据baseID查询出详细信息
     * @param baseId
     * @return
     * @throws RuntimeException
     */
    @Override
    public Detailed selectDetailedByBaseId(Integer baseId) throws RuntimeException {
        return detailedMapper.selectDetailedByBaseId(baseId);
    }

    /**
     * 保存或更新详细信息
     * @param detailed
     * @throws RuntimeException
     */
    @Override
    public void saveOrUpdateDetailed(Detailed detailed) throws RuntimeException {
        if(detailed == null){
            throw new RuntimeException("详细信息为空");
        }
        Detailed d = detailedMapper.selectByPrimaryKey(detailed.getStid());
        if(d != null){
            detailedMapper.updateByPrimaryKey(detailed);
        }else{
            detailedMapper.insert(detailed);
        }
    }

    @Override
    public Detailed selectDetailedBySno(String sno) throws RuntimeException {
        //先根据学号查出用户对象
        BaseExtend b = baseService.selectBaseBySno(sno);
        if(b == null){
            throw new RuntimeException("该用户不存在");
        }
        Integer bid = b.getBid();
        Detailed detailed = detailedMapper.selectDetailedByBaseId(bid);

        return detailed;
    }
}

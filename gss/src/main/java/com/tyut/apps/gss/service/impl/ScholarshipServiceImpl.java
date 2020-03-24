package com.tyut.apps.gss.service.impl;

import com.tyut.apps.gss.bean.Scholarship;
import com.tyut.apps.gss.mapper.ScholarshipMapper;
import com.tyut.apps.gss.service.IScholarshipService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ScholarshipServiceImpl implements IScholarshipService {

    @Resource
    private ScholarshipMapper scholarshipMapper;

    /**
     * 根据baseId查询住奖学金申请的信息
     * @param baseId
     * @return
     * @throws RuntimeException
     */
    @Override
    public Scholarship selectScholarshipByBaseId(Integer baseId) throws RuntimeException {
        return scholarshipMapper.selectScholarshipByBaseId(baseId);
    }

    @Override
    public void saveOrUpdateScholarship(Scholarship scholarship) throws RuntimeException {
        if(scholarship == null){
            throw new RuntimeException("该奖学金信息为空");
        }
        Scholarship s = scholarshipMapper.selectByPrimaryKey(scholarship.getScid());
        if(s != null){
            scholarshipMapper.updateByPrimaryKey(scholarship);
        }else {
            scholarshipMapper.insert(scholarship);
        }
    }

    @Override
    public void updateScholarshipStatus(Integer scid) throws RuntimeException {
        scholarshipMapper.updateScholarshipStatus(scid);
    }
}

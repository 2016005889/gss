package com.tyut.apps.gss.service.impl;

import com.tyut.apps.gss.bean.extend.CheckGrant;
import com.tyut.apps.gss.bean.extend.CheckScholarship;
import com.tyut.apps.gss.mapper.extend.CheckGrantMapper;
import com.tyut.apps.gss.mapper.extend.CheckScholarshipMapper;
import com.tyut.apps.gss.service.ICheckService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class CheckServiceImpl implements ICheckService {

    @Resource
    private CheckGrantMapper checkGrantMapper;
    @Resource
    private CheckScholarshipMapper checkScholarshipMapper;


    @Override
    public List<CheckGrant> selectAllGrant() throws RuntimeException {
        return checkGrantMapper.selectAll();
    }

    @Override
    public List<CheckScholarship> selectAllScholarship() throws RuntimeException {
        return checkScholarshipMapper.selectAll();
    }
}

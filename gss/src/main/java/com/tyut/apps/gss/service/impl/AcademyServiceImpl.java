package com.tyut.apps.gss.service.impl;

import com.tyut.apps.gss.bean.Academy;
import com.tyut.apps.gss.bean.AcademyExample;
import com.tyut.apps.gss.mapper.AcademyMapper;
import com.tyut.apps.gss.service.IAcademyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AcademyServiceImpl implements IAcademyService {

    @Resource
    private AcademyMapper academyMapper;
    @Resource
    private AcademyExample academyExample;

    /**
     * 查询所有学院
     * @return
     * @throws RuntimeException
     */
    @Override
    public List<Academy> selectAllAcademys() throws RuntimeException {
        return academyMapper.selectAllAcademy();
    }

    /**
     * 根据学院名称查询学院
     * @param aname
     * @return
     * @throws RuntimeException
     */
    @Override
    public Academy selectAcademyByAname(String aname) throws RuntimeException {
        return academyMapper.selectAcademyByAname(aname);
    }

    /**
     * 保存或更新学院信息
     * @param academy
     * @throws RuntimeException
     */
    @Override
    public void saveOrUpdateAcademy(Academy academy) throws RuntimeException {
        if(academy == null){
            throw new RuntimeException("学院信息为空");
        }
        if(academy.getAid() == null){
            Academy a = academyMapper.selectAcademyByAname(academy.getAname());
            if(a != null){
                throw new RuntimeException("该学院已经存在");
            }
            academyMapper.insert(academy);
        }
        academyMapper.updateByPrimaryKey(academy);
    }

    /**
     * 根据学院的名称删除学院
     * @param rid
     * @throws RuntimeException
     */
    @Override
    public void deleteAcademyByAid(Integer rid) throws RuntimeException {
        academyMapper.deleteByPrimaryKey(rid);
    }
}

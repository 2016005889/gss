package com.tyut.apps.gss.service.impl;

import com.tyut.apps.gss.bean.Cla;
import com.tyut.apps.gss.bean.ClaExample;
import com.tyut.apps.gss.mapper.ClaMapper;
import com.tyut.apps.gss.service.IClaService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClaServiceImpl implements IClaService {

    @Resource
    private ClaMapper claMapper;

    @Resource
    private ClaExample claExample;

    /**
     * 查询所有班级
     * @return
     * @throws RuntimeException
     */
    @Override
    public List<Cla> selectAllClas() throws RuntimeException{
        return claMapper.selectAllCla();
    }

    /**
     * 保存或更新班级
     * @param cla
     * @throws RuntimeException
     */
    @Override
    public void saveOrUpdateCla(Cla cla) throws RuntimeException{
       if(cla == null){
           throw new RuntimeException("班级为空");
       }
       if(cla.getCid() == null){
            //判断班级是否存在
           Cla c = claMapper.selectClaByCname(cla.getCname());
           if(c!= null){
               throw new RuntimeException("该班级已存在");
           }
           //班级不存在，插入班级
           claMapper.insert(cla);
       }
       //班级存在 更新班级信息
       claMapper.updateByPrimaryKey(cla);
    }

    /**
     * 根据班级名称查询班级
     */
    @Override
    public Cla selectClaByCname(String cname) throws RuntimeException {
        Cla cla = claMapper.selectClaByCname(cname);
        return cla;
    }

    /**
     * 根据班级id删除班级
     * @param cid
     * @throws RuntimeException
     */
    @Override
    public void deleteClaByCid(Integer cid) throws RuntimeException {
        if(cid == null){
            throw new RuntimeException("该班级不存在");
        }
        claMapper.deleteByPrimaryKey(cid);
    }


}

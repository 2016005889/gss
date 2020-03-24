package com.tyut.apps.gss.mapper.extend;

import com.tyut.apps.gss.bean.extend.BaseExtend;

import java.util.List;

public interface BaseExtendMapper {

    //根据rid来查询
    List<BaseExtend> selectBaseByRid(Integer rid);

    //查询所有
    List<BaseExtend> selectAllBase();

    //依据id来查找
    BaseExtend selectBaseByBid(Integer bid);

    //根据name来查找
    BaseExtend selectBaseByName(String name);

    //根据Sno来查找
    BaseExtend selectBaseBySno(String sno);
}

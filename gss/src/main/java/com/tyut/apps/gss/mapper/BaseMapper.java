package com.tyut.apps.gss.mapper;

import com.tyut.apps.gss.bean.Base;
import com.tyut.apps.gss.bean.BaseExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseMapper {

    /**
     * 根据rid查找基本信息
     */
    List<Base> selectBaseByRid(Integer rid);

    /**
     * 根据sno查找基本信息
     */
    Base selectBaseBySno(String sno);

    /**
     * 根据name查找基本信息
     */
    Base selectBaseByName(String name);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base
     *
     * @mbg.generated Mon Mar 16 20:41:55 CST 2020
     */
    long countByExample(BaseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base
     *
     * @mbg.generated Mon Mar 16 20:41:55 CST 2020
     */
    int deleteByExample(BaseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base
     *
     * @mbg.generated Mon Mar 16 20:41:55 CST 2020
     */
    int deleteByPrimaryKey(Integer bid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base
     *
     * @mbg.generated Mon Mar 16 20:41:55 CST 2020
     */
    int insert(Base record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base
     *
     * @mbg.generated Mon Mar 16 20:41:55 CST 2020
     */
    int insertSelective(Base record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base
     *
     * @mbg.generated Mon Mar 16 20:41:55 CST 2020
     */
    List<Base> selectByExample(BaseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base
     *
     * @mbg.generated Mon Mar 16 20:41:55 CST 2020
     */
    Base selectByPrimaryKey(Integer bid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base
     *
     * @mbg.generated Mon Mar 16 20:41:55 CST 2020
     */
    int updateByExampleSelective(@Param("record") Base record, @Param("example") BaseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base
     *
     * @mbg.generated Mon Mar 16 20:41:55 CST 2020
     */
    int updateByExample(@Param("record") Base record, @Param("example") BaseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base
     *
     * @mbg.generated Mon Mar 16 20:41:55 CST 2020
     */
    int updateByPrimaryKeySelective(Base record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base
     *
     * @mbg.generated Mon Mar 16 20:41:55 CST 2020
     */
    int updateByPrimaryKey(Base record);
}
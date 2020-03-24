package com.tyut.apps.gss.mapper;

import com.tyut.apps.gss.bean.Cla;
import com.tyut.apps.gss.bean.ClaExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClaMapper {
    /**
     * 查询所有
     */
    List<Cla> selectAllCla();

    /**
     * 根据cname查询班级
     */
    Cla selectClaByCname(String name);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cla
     *
     * @mbg.generated Mon Mar 16 20:41:55 CST 2020
     */
    long countByExample(ClaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cla
     *
     * @mbg.generated Mon Mar 16 20:41:55 CST 2020
     */
    int deleteByExample(ClaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cla
     *
     * @mbg.generated Mon Mar 16 20:41:55 CST 2020
     */
    int deleteByPrimaryKey(Integer cid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cla
     *
     * @mbg.generated Mon Mar 16 20:41:55 CST 2020
     */
    int insert(Cla record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cla
     *
     * @mbg.generated Mon Mar 16 20:41:55 CST 2020
     */
    int insertSelective(Cla record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cla
     *
     * @mbg.generated Mon Mar 16 20:41:55 CST 2020
     */
    List<Cla> selectByExample(ClaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cla
     *
     * @mbg.generated Mon Mar 16 20:41:55 CST 2020
     */
    Cla selectByPrimaryKey(Integer cid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cla
     *
     * @mbg.generated Mon Mar 16 20:41:55 CST 2020
     */
    int updateByExampleSelective(@Param("record") Cla record, @Param("example") ClaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cla
     *
     * @mbg.generated Mon Mar 16 20:41:55 CST 2020
     */
    int updateByExample(@Param("record") Cla record, @Param("example") ClaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cla
     *
     * @mbg.generated Mon Mar 16 20:41:55 CST 2020
     */
    int updateByPrimaryKeySelective(Cla record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cla
     *
     * @mbg.generated Mon Mar 16 20:41:55 CST 2020
     */
    int updateByPrimaryKey(Cla record);
}
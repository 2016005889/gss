package com.tyut.apps.gss.mapper;

import com.tyut.apps.gss.bean.Academy;
import com.tyut.apps.gss.bean.AcademyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AcademyMapper {

    /**
     * 查询所有
     */
    List<Academy> selectAllAcademy();

    /**
     * 根据学院名称查找学生
     */
    Academy selectAcademyByAname(String aname);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table academy
     *
     * @mbg.generated Mon Mar 16 20:41:55 CST 2020
     */
    long countByExample(AcademyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table academy
     *
     * @mbg.generated Mon Mar 16 20:41:55 CST 2020
     */
    int deleteByExample(AcademyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table academy
     *
     * @mbg.generated Mon Mar 16 20:41:55 CST 2020
     */
    int deleteByPrimaryKey(Integer aid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table academy
     *
     * @mbg.generated Mon Mar 16 20:41:55 CST 2020
     */
    int insert(Academy record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table academy
     *
     * @mbg.generated Mon Mar 16 20:41:55 CST 2020
     */
    int insertSelective(Academy record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table academy
     *
     * @mbg.generated Mon Mar 16 20:41:55 CST 2020
     */
    List<Academy> selectByExample(AcademyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table academy
     *
     * @mbg.generated Mon Mar 16 20:41:55 CST 2020
     */
    Academy selectByPrimaryKey(Integer aid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table academy
     *
     * @mbg.generated Mon Mar 16 20:41:55 CST 2020
     */
    int updateByExampleSelective(@Param("record") Academy record, @Param("example") AcademyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table academy
     *
     * @mbg.generated Mon Mar 16 20:41:55 CST 2020
     */
    int updateByExample(@Param("record") Academy record, @Param("example") AcademyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table academy
     *
     * @mbg.generated Mon Mar 16 20:41:55 CST 2020
     */
    int updateByPrimaryKeySelective(Academy record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table academy
     *
     * @mbg.generated Mon Mar 16 20:41:55 CST 2020
     */
    int updateByPrimaryKey(Academy record);
}
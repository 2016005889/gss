package com.tyut.apps.gss.web.controller;

import com.tyut.apps.gss.bean.Academy;
import com.tyut.apps.gss.service.IAcademyService;
import com.tyut.apps.gss.utils.Message;
import com.tyut.apps.gss.utils.MessageUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("gss")
public class AcademyController {

    @Resource
    private IAcademyService academyService;

    /**
     * 查询所有的学院
     * @return
     */
    @GetMapping("findAllAcademys")
    public Message findAllAcademys(){
        List<Academy> academies = academyService.selectAllAcademys();
        return MessageUtil.success(academies);
    }

    /**
     * 根据学院名称查询学院
     * @return
     */
    @GetMapping("findAcademyByAname")
    public Message findAcademyByAname(String aname){
        Academy academy = academyService.selectAcademyByAname(aname);
        return MessageUtil.success(academy);
    }

    /**
     * 保存或更新学院信息
     * @param aid
     * @param aname
     * @return
     */
    @PostMapping("saveOrUpdateAcademy")
    public Message saveOrUpdateAcademy(Integer aid,String aname){
        Academy academy = new Academy();
        academy.setAid(aid);
        academy.setAname(aname);
        academyService.saveOrUpdateAcademy(academy);
        return MessageUtil.success("保存或更新成功");
    }

    /**
     * 根据学院id删除学院
     * @param aid
     * @return
     */
    @GetMapping("deleteAcademyByAid")
    public Message deleteAcademyByAid(Integer aid){
        academyService.deleteAcademyByAid(aid);
        return MessageUtil.success("删除成功");
    }
}

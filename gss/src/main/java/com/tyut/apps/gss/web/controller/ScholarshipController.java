package com.tyut.apps.gss.web.controller;

import com.tyut.apps.gss.bean.Scholarship;
import com.tyut.apps.gss.bean.extend.BaseExtend;
import com.tyut.apps.gss.service.IBaseService;
import com.tyut.apps.gss.service.IScholarshipService;
import com.tyut.apps.gss.utils.Message;
import com.tyut.apps.gss.utils.MessageUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("gss")
public class ScholarshipController {

    @Resource
    private IScholarshipService scholarshipService;

    @Resource
    private IBaseService baseService;

    /**
     * 根据baseId查询奖学金的申请信息
     * @param baseId
     * @return
     */
    @GetMapping("findScholarship")
    public Message findScholarship(Integer baseId){
        Scholarship scholarship = scholarshipService.selectScholarshipByBaseId(baseId);
        return MessageUtil.success(scholarship);
    }

    /**
     * 保存或更新奖学金的申请信息
     */
    @PostMapping("saveOrUpdateScholarship")
    public Message saveOrUpdateScholarship(Integer scid,String sno,String grade){
        Scholarship scholarship = new Scholarship();
        if(sno == null){
            throw new RuntimeException("未填写学号");
        }
        BaseExtend b = baseService.selectBaseBySno(sno);
        if(b == null){
            throw new RuntimeException("该用户不存在");
        }
        scholarship.setBaseId(b.getBid());
        scholarship.setScid(scid);
        if(grade == null){
            throw new RuntimeException("未填写成绩");
        }
        scholarship.setGrade(grade);
        scholarship.setStatus(0);

        scholarshipService.saveOrUpdateScholarship(scholarship);
        return MessageUtil.success("保存或更新成功");
    }

    /**
     * 更新奖学金的申请状态
     */
    @GetMapping("updateScholarshipStatus")
    public Message updateScholarshipStatus(Integer scid){
        scholarshipService.updateScholarshipStatus(scid);
        return MessageUtil.success("更新成功");
    }

}

package com.tyut.apps.gss.web.controller;

import com.tyut.apps.gss.bean.Grant;
import com.tyut.apps.gss.bean.extend.BaseExtend;
import com.tyut.apps.gss.service.IBaseService;
import com.tyut.apps.gss.service.IGrantService;
import com.tyut.apps.gss.utils.Message;
import com.tyut.apps.gss.utils.MessageUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("gss")
public class GrantController {
    @Resource
    private IGrantService grantService;
    
    @Resource
    private IBaseService baseService;

    /**
     * 根据baseID查询助学金申请的信息
     */
    @GetMapping("findGrantByBaseId")
    public Message findGrantByBaseId(Integer baseId){
        Grant grant = grantService.selectGrantByBaseId(baseId);
        return MessageUtil.success(grant);
    }

    /**
     * 保存或更新助学金申请的信息
     */
    @PostMapping("saveOrUpdateGrant")
    public Message saveOrUpdateGrant(Integer gid,String name,String sno,String reason){

        Grant grant = new Grant();
        //判断是否输入了学号
        if(sno == null){
            throw new RuntimeException("未填写学号");
        }
        //根据学号找出对应的用户
        BaseExtend b = baseService.selectBaseBySno(sno);
        //判断是否存在该用户
        if(b == null){
            throw new RuntimeException("该用户不存在");
        }
        //依据baseID来查找助学金记录的ID
        grant.setBaseId(b.getBid());
        //查看该用户是否有申请助学金的记录
        Grant g = grantService.selectGrantByBaseId(b.getBid());
        //如果存在该记录则把gid给了grant对象
        if(g != null){
            grant.setGid(gid);
        }

        grant.setStatus(0);
        if(reason == null){
            throw new RuntimeException("未填写申请原因");
        }
        grant.setReason(reason);
        grantService.saveOrUpdateGrant(grant);
        return MessageUtil.success("保存或更新成功");
    }

    /**
     * 更新助学金的状态
     */
    @GetMapping("updateGrantStatusByGid")
    public Message updateGrantStatusByGid(Integer gid){
        System.out.println(gid);
        grantService.updateGrantStatus(gid);
        return MessageUtil.success("审核成功");
    }
}

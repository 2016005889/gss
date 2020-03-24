package com.tyut.apps.gss.web.controller;

import com.tyut.apps.gss.bean.Academy;
import com.tyut.apps.gss.bean.Base;
import com.tyut.apps.gss.bean.Cla;
import com.tyut.apps.gss.bean.Role;
import com.tyut.apps.gss.bean.extend.BaseExtend;
import com.tyut.apps.gss.service.IAcademyService;
import com.tyut.apps.gss.service.IBaseService;
import com.tyut.apps.gss.service.IClaService;
import com.tyut.apps.gss.service.IRoleService;
import com.tyut.apps.gss.utils.Message;
import com.tyut.apps.gss.utils.MessageUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("gss")
public class BaseController {

    @Resource
    private IBaseService baseService;

    @Resource
    private IRoleService roleService;

    @Resource
    private IClaService claService;

    @Resource
    private IAcademyService academyService;

    /**
     * 根据角色名称查找基本信息
     */
    @GetMapping("findBasesByRoleRname")
    public Message findBasesByRoleRname(String rname){
        List<BaseExtend> bases = baseService.selectBaseByRoleRname(rname);
        return MessageUtil.success(bases);
    }

    /**
     * 查找所有基本信息
     */
    @GetMapping("findAllBases")
    public Message findAllBases(){
        List<BaseExtend> bases = baseService.selectAllBases();
        return MessageUtil.success(bases);
    }

    /**
     * 根据bid查找基本信息
     */
    @GetMapping("findBaseByBid")
    public Message findBaseByBid(Integer bid){
        Base base = baseService.selectBaseByBid(bid);
        return MessageUtil.success(base);
    }

    /**
     * 根据name查找基本信息
     */
    @GetMapping("findBaseByName")
    public Message findBaseByName(String name){
        Base base = baseService.selectBaseByName(name);
        return MessageUtil.success(base);
    }

    /**
     * 根据son查找基本信息
     */
    @GetMapping("findBaseBySno")
    public Message findBaseBySno(String sno){
        Base base = baseService.selectBaseBySno(sno);
        return MessageUtil.success(base);
    }

    /**
     * 保存或更新基本信息
     */
    @PostMapping("saveOrUpdateBase")
    public Message saveOrUpdateBase(Integer bid,String name, String sno, String gender, String email, String phone, String qq,String rname,String cname,String aname){
        Base base = new Base();
        base.setBid(bid);
        base.setEmail(email);
        base.setGender(gender);
        base.setName(name);
        base.setPhone(phone);
        base.setQq(qq);
        base.setSno(sno);
        base.setCreatedate(new Date());
        base.setPassword("123456");

        Role role = roleService.selectRoleByRname(rname);
        base.setrId(role.getRid());

        //如果没有输入学院的名称，则将该角色设置为管理员
        if(aname == null){
            base.setcId(0);
            base.setaId(0);
        }
        //如果输入了学院名  但是没有输入班级名称，则表明该用户是一名教师
        if(cname == null){
            base.setcId(0);
            Academy academy = academyService.selectAcademyByAname(aname);
            if(academy != null){
                base.setaId(academy.getAid());
            }
        }else{
            Academy academy = academyService.selectAcademyByAname(aname);
            if(academy != null){
                base.setaId(academy.getAid());
            }
            Cla cla = claService.selectClaByCname(cname);
            if(cla != null){
                base.setcId(cla.getCid());
            }
        }





       // System.out.println(base);
        baseService.saveOrUpdateBase(base);
        return MessageUtil.success("保存或更新成功");
    }

    /**
     * 根据bid删除基本信息
     */
    @GetMapping("deleteBaseByBid")
    public Message deleteBaseByBid(Integer bid){

        baseService.deleteBaseByBid(bid);

        return MessageUtil.success("删除成功");
    }

    /**
     * 批量删除基本信息
     * @param
     * @return
     */
    @GetMapping("batchDeleteBase")
    public Message batchDeleteBase(Integer[] bids){
        System.out.println(bids);
        baseService.batchDeletBase(bids);
        return MessageUtil.success("删除成功");
    }

    @GetMapping("findBaseExtendByRid")
    public Message findBaseExtendByRid(Integer rid){
        List<BaseExtend> baseExtends = baseService.selectBaseByRid(rid);
        return MessageUtil.success(baseExtends);
    }
}

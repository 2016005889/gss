package com.tyut.apps.gss.web.controller;

import com.tyut.apps.gss.bean.Detailed;
import com.tyut.apps.gss.service.IDetailedService;
import com.tyut.apps.gss.utils.Message;
import com.tyut.apps.gss.utils.MessageUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("gss")
public class DetailedController {

    @Resource
    private IDetailedService detailedService;

    /**
     * 根据baseID查找详细信息
     * @param baseId
     * @return
     */
    @GetMapping("findDetailByBaseId")
    public Message findDetailByBaseId(Integer baseId){
        Detailed detailed = detailedService.selectDetailedByBaseId(baseId);
        return MessageUtil.success(detailed);
    }

    /**
     * 保存或更新详细信息
     */
    @GetMapping("saveOrUpdateDetailed")
    public Message saveOrUpdateDetailed(Integer stid,String address,String bankcard,String idcard,Integer baseId){
        Detailed detailed = new Detailed();
        detailed.setStid(stid);
        detailed.setAddress(address);
        detailed.setBankcard(bankcard);
        detailed.setIdcard(idcard);
        detailed.setBaseId(baseId);
        detailedService.saveOrUpdateDetailed(detailed);
        return MessageUtil.success("保存或更新成功");
    }

    /**
     * 根据学号查询详细信息
     */
    @GetMapping("findDetailedBySno")
    public Message findDetailedBySno(String sno){
        System.out.println(sno);
        Detailed detailed = detailedService.selectDetailedBySno(sno);
        System.out.println(detailed);
        return MessageUtil.success(detailed);
    }

}

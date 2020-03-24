package com.tyut.apps.gss.web.controller;

import com.tyut.apps.gss.bean.extend.CheckGrant;
import com.tyut.apps.gss.bean.extend.CheckScholarship;
import com.tyut.apps.gss.service.ICheckService;
import com.tyut.apps.gss.utils.Message;
import com.tyut.apps.gss.utils.MessageUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("gss")
public class CheckController {

    @Resource
    private ICheckService checkService;

    @GetMapping("findAllGrant")
    public Message findAllGrant(){
        List<CheckGrant> checks = checkService.selectAllGrant();
        return MessageUtil.success(checks);
    }

    @GetMapping("findAllScholarship")
    public Message findAllScholarship(){
        List<CheckScholarship> checkScholarships = checkService.selectAllScholarship();
        return MessageUtil.success(checkScholarships);
    }


}

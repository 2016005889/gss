package com.tyut.apps.gss.web.controller;

import com.tyut.apps.gss.bean.Cla;
import com.tyut.apps.gss.service.IClaService;
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
public class ClaController {
    @Resource
    private IClaService claService;

    /**
     * 查询所有班级
     * @return
     */
    @GetMapping("findAllClas")
    public Message findAllClas(){
        List<Cla> clas = claService.selectAllClas();
        return MessageUtil.success(clas);
    }

    /**
     * 保存或更新班级
     */
    @PostMapping("saveOrUpdateCla")
    public Message saveOrUpdateCla(Integer cid,String cname){
        Cla cla = new Cla();
        cla.setCid(cid);
        cla.setCname(cname);
        claService.saveOrUpdateCla(cla);
        return MessageUtil.success("保存或更新成功");
    }
    /**
     * 根据班级名称查询班级
     */
    @GetMapping("findClaByCname")
    public Message findClaByCname(String cname){
        Cla cla = claService.selectClaByCname(cname);
        return MessageUtil.success(cla);
    }

    /**
     * 根据班级id删除班级
     */
    @GetMapping("deleteClaByCid")
    public Message deleteClaByCid(Integer cid){
        claService.deleteClaByCid(cid);
        return MessageUtil.success("删除成功");
    }
}

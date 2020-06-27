package com.ruoyi.project.cms.type.controller;


import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.cms.type.commons.CMSTypeConst;
import com.ruoyi.project.cms.type.domain.CMSType;
import com.ruoyi.project.cms.type.service.CMSTypeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/cms/type")
public class CMSController extends BaseController {

    @Autowired
    private CMSTypeService cmsTypeService;


    @RequiresPermissions("cms:type:view")
    @GetMapping
    public String view(){
        return CMSTypeConst.PREFIX + "/type";
    }



    @RequiresPermissions("cms:type:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CMSType type){
        //分页查询
        startPage();
        //查询
        List<CMSType> list = cmsTypeService.selectCMSTypeList(type);

        return getDataTable(list);
    }
}

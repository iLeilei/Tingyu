package com.ruoyi.project.cms.type.controller;


import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.cms.type.commons.CMSTypeConst;
import com.ruoyi.project.cms.type.domain.CMSType;
import com.ruoyi.project.cms.type.service.CMSTypeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cms/type")
public class CMSController extends BaseController {

    @Autowired
    private CMSTypeService cmsTypeService;


    /**
     * 公告类型页面跳转
     * @return
     */
    @RequiresPermissions("cms:type:view")
    @GetMapping
    public String view(){
        return CMSTypeConst.PREFIX + "/type";
    }


    /**
     * 分页查询公告类型集合
     * @param type
     * @return
     */
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

    /**
     * 新增公告类型页面跳转
     * @return
     */
    @GetMapping("/add")
    public String addView(){
        return CMSTypeConst.PREFIX + "/add";
    }

    /**
     * 校验公告类型名称是否唯一
     * @return
     *  字符串 0 - 唯一可以使用
     *  字符串 1 - 不唯一 不能使用
     */
    @PostMapping("/checkTypeNameUnique")
    @ResponseBody
    public String checkTypeNameUnique(CMSType cmsType){
        return cmsTypeService.checkTypeNameUnique(cmsType);
    }

    /**
     * 新增公告类型 -要求必须要有权限才能访问该方法
     * @param cmsType
     * @return
     */
    @PostMapping("/add")
    @RequiresPermissions("cms:type:add")
    @ResponseBody
    public AjaxResult add(CMSType cmsType){
        if (CMSTypeConst.CMSType_NAME_NOT_UNIQUE.equals(cmsTypeService.checkTypeNameUnique(cmsType)))
        {
            return error("新增公告类型'" + cmsType.getTypeName() + "'失败，公告类型名称已存在");
        }
        return toAjax(cmsTypeService.addCMSType(cmsType));
    }

    /**
     * 删除公告类型 -要求必须要有权限才能访问该方法
     * @param ids 注意前台传过来的是字符串
     * @return
     */
    @PostMapping("/remove")
    @RequiresPermissions("cms:type:remove")
    @ResponseBody
    public AjaxResult remove(String ids){
        try
        {
            return toAjax(cmsTypeService.deleteTypeByIds(ids));
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
    }

    /**
     * 修改公告类型页面，先根据主键查询公告类型信息显示
     * @param typeId 公告类型编号
     * @param mmap 公告类型信息
     * @return
     */
    @GetMapping("/edit/{typeId}")
    public String editView(@PathVariable("typeId") Long typeId, ModelMap mmap){
        mmap.put("type",cmsTypeService.selectCMSTypeById(typeId));
        return CMSTypeConst.PREFIX + "/edit";
    }

    /**
     * 修改公告类型
     * @param cmsType
     * @return
     */
    @RequiresPermissions("cms:type:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult edit(@Validated CMSType cmsType){
        if (CMSTypeConst.CMSType_NAME_NOT_UNIQUE.equals(cmsTypeService.checkTypeNameUnique(cmsType)))
        {
            return error("修改公告类型'" + cmsType.getTypeName() + "'失败，公告类型名称已存在");
        }
        return toAjax(cmsTypeService.updateCMSType(cmsType));
    }

}

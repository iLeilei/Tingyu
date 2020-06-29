package com.ruoyi.project.cms.type.service.impl;


import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.cms.type.commons.CMSTypeConst;
import com.ruoyi.project.cms.type.domain.CMSType;
import com.ruoyi.project.cms.type.mapper.CMSTypeMapper;
import com.ruoyi.project.cms.type.service.CMSTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CMSTypeServiceImpl implements CMSTypeService {
    @Autowired
    private CMSTypeMapper cmsTypeMapper;

    @Override
    public List<CMSType> selectCMSTypeList(CMSType cmsType) {
        List<CMSType> cmsTypes = cmsTypeMapper.selectCMSTypeList(cmsType);
        return cmsTypes;
    }

    @Override
    public String checkTypeNameUnique(CMSType cmsType) {
        Long typeId = StringUtils.isNull(cmsType.getTypeId()) ? -1L : cmsType.getTypeId();
        CMSType info = cmsTypeMapper.checkTypeNameUnique(cmsType.getTypeName());
        if (StringUtils.isNotNull(info) && info.getTypeId().longValue() != typeId.longValue())
        {
            return CMSTypeConst.CMSType_NAME_NOT_UNIQUE;
        }
        return CMSTypeConst.CMSType_NAME_UNIQUE;
    }

    @Override
    public int addCMSType(CMSType cmsType) {
        //当前用户的登录名添加单createBy属性中，创建者姓名
        cmsType.setCreateBy(ShiroUtils.getLoginName());
        return cmsTypeMapper.insertCMSType(cmsType);
    }

    @Override
    public int deleteTypeByIds(String ids) {
        Long[] typeIds = Convert.toLongArray(ids);

        return cmsTypeMapper.deleteCMSTypeByIds(typeIds);
    }

    @Override
    public CMSType selectCMSTypeById(Long typeId) {
        return  cmsTypeMapper.selectCMSTypeById(typeId);
    }

    @Override
    public int updateCMSType(CMSType cmsType) {
        //当前用户的登录名添加到updateBy属性中，修改者姓名
        cmsType.setUpdateBy(ShiroUtils.getLoginName());
        return cmsTypeMapper.updateCMSType(cmsType);
    }
}

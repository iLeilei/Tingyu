package com.ruoyi.project.cms.type.service.impl;

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
}

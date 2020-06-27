package com.ruoyi.project.cms.type.service;

import com.ruoyi.project.cms.type.domain.CMSType;

import java.util.List;

public interface CMSTypeService {

    /**
     * 查询公告类型集合
     * @param cmsType 公告类型
     * @return 公告类型集合
     */
    List<CMSType> selectCMSTypeList(CMSType cmsType);
}

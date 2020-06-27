package com.ruoyi.project.cms.type.mapper;

import com.ruoyi.project.cms.type.domain.CMSType;

import java.util.List;

public interface CMSTypeMapper {
    /**
     * 查询公告类型集合
     * @return
     */
    List<CMSType> selectCMSTypeList(CMSType cmsType);

}

package com.ruoyi.project.cms.type.service;

import com.ruoyi.project.cms.type.domain.CMSType;

import java.util.List;

public interface CMSTypeService {
    /**
     * 查询所有的公告类型集合
     * @param cmsType
     * @return
     */
    List<CMSType> selectCMSTypeList(CMSType cmsType);

    /**
     * 校验公告类型名称是否唯一
     *  0-唯一可用   1-不唯一不可用
     * @param cmsType
     * @return
     */
    String checkTypeNameUnique(CMSType cmsType);

    /**
     * 新增公告类型名称
     * @param cmsType
     * @return
     */
    int addCMSType(CMSType cmsType);

    /**
     * 根据id删除公告类型
     * @param ids
     * @return
     */
    int deleteTypeByIds(String ids);

    /**
     * 根据主键id查询公告类型
     * @param typeId
     * @return
     */
    CMSType selectCMSTypeById(Long typeId);

    /**
     * 修改公告类型
     * @param cmsType 公告类型信息
     * @return
     */
    int updateCMSType(CMSType cmsType);
}

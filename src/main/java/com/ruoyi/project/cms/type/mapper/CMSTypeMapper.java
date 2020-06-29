package com.ruoyi.project.cms.type.mapper;

import com.ruoyi.project.cms.type.domain.CMSType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CMSTypeMapper {
    /**
     * 查询公告类型集合
     * @return
     */
    List<CMSType> selectCMSTypeList(CMSType cmsType);


    /**
     * 校验公告类型的名称是否唯一
     * @param typeName
     * @return
     */
    CMSType checkTypeNameUnique(String typeName);

    /**
     * 新增公告类型
     * @param cmsType
     * @return
     */
    int insertCMSType(CMSType cmsType);

    /**
     * 根据id查询公告类型信息
     * @param typeId 公告类型id
     * @return 公告类型对象
     */
    CMSType selectCMSTypeById(Long typeId);


    /**
     * 删除公告类型信息
     * @param typeIds
     * @return
     */
    int deleteCMSTypeByIds(@Param("ids") Long[] typeIds);

    /**
     * 修改公告类型信息
     * @param cmsType
     * @return
     */
    int updateCMSType(CMSType cmsType);
}

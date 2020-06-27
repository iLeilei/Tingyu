/***************
* 公告类型SQL脚本
***************/

-- 创建表格
create table `cms_type`(
  `type_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '公告类型ID',
  `type_name` varchar(50) NOT NULL COMMENT '公告类型名称',
  `type_desc` varchar(50) NOT NULL COMMENT '公告类型描述',
  `type_sort` varchar(50) NOT NULL COMMENT '显示排序',
  `status` char(1) NOT NULL COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  primary key (`type_id`)
)COMMENT='公告类型信息表';

insert into cms_type
 values
 (default ,'热销产品公告','热销产品','1','0','cms',now(),'cms',now(),''),
 (default ,'最近推荐产品公告','推荐产品','2','0','cms',now(),'cms',now(),''),
 (default ,'新晋产品公告','新品产品','3','0','cms',now(),'cms',now(),'');
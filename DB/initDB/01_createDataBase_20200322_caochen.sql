CREATE database ccwyz_frist;

DROP TABLE IF EXISTS `user_info`;

CREATE TABLE `user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
  `user_name` varchar(40) NOT NULL  COMMENT '用户名',
  `password` varchar(500) NOT NULL    COMMENT '密码',
  `age` int(4) NOT NULL  COMMENT '年龄',
  `is_valid` int(4) NOT NULL  COMMENT '数据有效性(1有效,0无效)',
  `version`  bigint NOT NULL  COMMENT '修改操作加锁',
  `created_by` varchar(40) NOT NULL  COMMENT '创建人',
  `updated_by` varchar(40) NOT NULL  COMMENT '修改人',
  `created_date` TIMESTAMP  NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_date` TIMESTAMP  NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8  COMMENT '用户信息表' ;
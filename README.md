建表语句：
CREATE TABLE `user_base_info` (

  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键id',

  `user_id` varchar(20) NOT NULL COMMENT '用户id',

  `mobile_no` varchar(12) NOT NULL DEFAULT '' COMMENT '用户手机号',

  `user_name` varchar(50) NOT NULL DEFAULT '' COMMENT '用户名',

  `sex` tinyint(1) unsigned NOT NULL COMMENT '性别',

  `address` varchar(100) NOT NULL DEFAULT '' COMMENT '地址',

  `gmt_create` datetime NOT NULL COMMENT '记录创建时间',

  `gmt_modified` datetime NOT NULL COMMENT '记录修改时间',

  PRIMARY KEY (`id`),

  UNIQUE KEY `idx_uniq_user_id` (`user_id`)

) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='用户基本信息表';
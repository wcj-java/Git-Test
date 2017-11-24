
DROP TABLE IF EXISTS `mp_emp`;
CREATE TABLE `mp_emp` (
  `emp_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '员工编号',
  `emp_num` varchar(20) NOT NULL COMMENT '员工工号',
  `name` varchar(20) NOT NULL DEFAULT '' COMMENT '姓名',
  `sex` tinyint(3) unsigned DEFAULT '0' COMMENT '员工性别 0男 1女',
  `birthday` datetime NOT NULL COMMENT '生日',
  `telphone` varchar(32) DEFAULT NULL COMMENT '座机',
  `mobilePhone` varchar(32) DEFAULT NULL COMMENT '手机号',
  `qq` varchar(20) DEFAULT NULL COMMENT 'qq',
  `email` varchar(20) DEFAULT '' COMMENT 'email',
  `organization_id` bigint(20) NOT NULL COMMENT '所属组织',
  `role_id` bigint(20) unsigned NOT NULL COMMENT '所属角色',
  `username` varchar(64) DEFAULT NULL COMMENT '登录帐号',
  `password` varchar(32) NOT NULL DEFAULT '' COMMENT '密码',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '员工状态\r\n0正常\r\n1注销\r\n2暂时冻结',
  `CreateTime` datetime NOT NULL COMMENT '创建时间',
  `UpdateTime` datetime NOT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`emp_id`),
  UNIQUE KEY `emp_id` (`emp_id`),
  UNIQUE KEY `emp_num` (`emp_num`)
) ENGINE=InnoDB AUTO_INCREMENT=1001 DEFAULT CHARSET=utf8 COMMENT='员工表';

DROP TABLE IF EXISTS `mp_menu`;
CREATE TABLE `mp_menu` (
  `menu_id` varchar(20) NOT NULL COMMENT '菜单编号',
  `menu_name` varchar(20) NOT NULL DEFAULT '' COMMENT '菜单名称',
  `menu_url` varchar(128) DEFAULT NULL COMMENT '菜单路径',
  `menu_level` tinyint(4) NOT NULL COMMENT '菜单级别',
  `parent_id` varchar(20) DEFAULT NULL COMMENT '父层菜单',
  `menu_order` int(11) NOT NULL DEFAULT '1' COMMENT '菜单排序',
  `menu_desc` varchar(128) DEFAULT NULL COMMENT '菜单描述',
  `menu_state` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '菜单状态\r\n0 正常  1 隐藏',
  PRIMARY KEY (`menu_id`),
  UNIQUE KEY `menu_id` (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单表';

DROP TABLE IF EXISTS `mp_organization`;
CREATE TABLE `mp_organization` (
  `organization_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '组织编号',
  `organization_name` varchar(20) NOT NULL DEFAULT '' COMMENT '组织名称',
  `principal_id` bigint(20) DEFAULT NULL COMMENT '负责人编号',
  `parent_id` bigint(20) unsigned DEFAULT NULL COMMENT '上级组织',
  `description` varchar(200) DEFAULT NULL COMMENT '组织描述',
  `CreateTime` datetime NOT NULL COMMENT '创建时间',
  `UpdateTime` datetime NOT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`organization_id`),
  UNIQUE KEY `organization_id` (`organization_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1002 DEFAULT CHARSET=utf8 COMMENT='组织表';

DROP TABLE IF EXISTS `mp_power`;
CREATE TABLE `mp_power` (
  `role_id` bigint(20) NOT NULL COMMENT '角色',
  `menu_id` bigint(20) NOT NULL COMMENT '菜单编号'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限表';

DROP TABLE IF EXISTS `mp_role`;
CREATE TABLE `mp_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色编号',
  `role_name` varchar(20) NOT NULL DEFAULT '' COMMENT '角色名称',
  `parent_id` bigint(20) unsigned DEFAULT NULL COMMENT '上级角色编号',
  `organization_id` bigint(20) unsigned NOT NULL COMMENT '所属组织',
  `description` varchar(200) DEFAULT '',
  `CreateTime` datetime NOT NULL COMMENT '创建时间',
  `UpdateTime` datetime NOT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`role_id`),
  UNIQUE KEY `role_id` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1232 DEFAULT CHARSET=utf8 COMMENT='角色表';


INSERT INTO `mp_emp` VALUES ('1000', 'CP141016003', 'wcj', '0', '1984-09-15 00:00:00', '13735474938', '', '799680118', '', '1000', '1000', 'admin', 'e10adc3949ba59abbe56e057f20f883e', '0', '2015-12-10 14:17:47', '2015-12-17 11:05:20');
INSERT INTO `mp_menu` VALUES ('100000', '权限管理', '', '1', '', '1', '', '0');
INSERT INTO `mp_menu` VALUES ('100100', '组织管理', 'jsp/org/OrgList.jsp', '2', '100000', '1', '', '0');
INSERT INTO `mp_menu` VALUES ('100101', '新增组织', '/org/insert', '3', '100100', '1', '', '0');
INSERT INTO `mp_menu` VALUES ('100102', '编辑组织', '/org/update', '3', '100100', '2', '', '0');
INSERT INTO `mp_menu` VALUES ('100103', '删除组织', '/org/delete', '3', '100100', '3', '', '0');
INSERT INTO `mp_menu` VALUES ('100200', '角色管理', 'jsp/role/RoleList.jsp', '2', '100000', '2', '', '0');
INSERT INTO `mp_menu` VALUES ('100201', '新增角色', '/role/insert', '3', '100200', '1', '', '0');
INSERT INTO `mp_menu` VALUES ('100202', '编辑角色', '/role/update', '3', '100200', '2', '', '0');
INSERT INTO `mp_menu` VALUES ('100203', '删除角色', '/role/delete', '3', '100200', '3', '', '0');
INSERT INTO `mp_menu` VALUES ('100204', '角色权限分配', '/role/power', '3', '100200', '4', '', '0');
INSERT INTO `mp_menu` VALUES ('100300', '员工管理', 'jsp/emp/EmpList.jsp', '2', '100000', '3', '', '0');
INSERT INTO `mp_menu` VALUES ('100301', '新增员工', '/emp/insert', '3', '100300', '1', '', '0');
INSERT INTO `mp_menu` VALUES ('100302', '编辑员工', '/emp/update', '3', '100300', '2', '', '0');
INSERT INTO `mp_menu` VALUES ('100303', '删除员工', '/emp/delete', '3', '100300', '3', '', '0');
INSERT INTO `mp_menu` VALUES ('100304', '重置密码', '/emp/resetPwd', '3', '100300', '4', '', '0');
INSERT INTO `mp_menu` VALUES ('200000', '修改密码', '/emp/modPwd', '-1', '', '0', '', '1');
INSERT INTO `mp_menu` VALUES ('200001', '修改个人资料', '/emp/operSet', '-1', '', '0', '', '1');
INSERT INTO `mp_organization` VALUES ('1000', '杭州酷鼎网络科技有限公司', '1000', '1000', '0', '2015-12-10 14:17:44', '2015-12-11 09:49:10');
INSERT INTO `mp_power` VALUES ('1000', '100000');
INSERT INTO `mp_power` VALUES ('1000', '100100');
INSERT INTO `mp_power` VALUES ('1000', '100101');
INSERT INTO `mp_power` VALUES ('1000', '100102');
INSERT INTO `mp_power` VALUES ('1000', '100103');
INSERT INTO `mp_power` VALUES ('1000', '100200');
INSERT INTO `mp_power` VALUES ('1000', '100201');
INSERT INTO `mp_power` VALUES ('1000', '100202');
INSERT INTO `mp_power` VALUES ('1000', '100203');
INSERT INTO `mp_power` VALUES ('1000', '100204');
INSERT INTO `mp_power` VALUES ('1000', '100300');
INSERT INTO `mp_power` VALUES ('1000', '100301');
INSERT INTO `mp_power` VALUES ('1000', '100302');
INSERT INTO `mp_power` VALUES ('1000', '100303');
INSERT INTO `mp_power` VALUES ('1000', '100304');
INSERT INTO `mp_power` VALUES ('1000', '200000');
INSERT INTO `mp_power` VALUES ('1000', '200001');
INSERT INTO `mp_role` VALUES ('1000', '系统管理员', '0', '1000', '系统超级管理员', '2015-12-10 14:17:45', '2015-12-10 14:17:45');



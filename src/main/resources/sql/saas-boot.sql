/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50724
Source Host           : localhost:3306
Source Database       : saas-boot

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2020-11-19 20:25:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `r_auth_tenant`
-- ----------------------------
DROP TABLE IF EXISTS `r_auth_tenant`;
CREATE TABLE `r_auth_tenant` (
  `relation_id` varchar(64) NOT NULL COMMENT '关系ID',
  `auth_id` varchar(64) DEFAULT NULL COMMENT '权限ID',
  `tenant_id` varchar(64) DEFAULT NULL COMMENT '租户ID',
  `status_cd` int(11) DEFAULT NULL COMMENT '数据状态（0：有效，1：无效）',
  PRIMARY KEY (`relation_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='权限租户关系表';

-- ----------------------------
-- Records of r_auth_tenant
-- ----------------------------

-- ----------------------------
-- Table structure for `r_role_auth`
-- ----------------------------
DROP TABLE IF EXISTS `r_role_auth`;
CREATE TABLE `r_role_auth` (
  `relation_id` varchar(64) NOT NULL COMMENT '关系ID',
  `tenant_id` varchar(64) DEFAULT NULL COMMENT '租户ID',
  `role_id` varchar(64) DEFAULT NULL COMMENT '角色ID',
  `auth_id` varchar(64) DEFAULT NULL COMMENT '权限ID',
  `status_cd` int(11) DEFAULT NULL COMMENT '数据状态（0：有效，1：无效）',
  PRIMARY KEY (`relation_id`),
  KEY `FK_Reference_1` (`role_id`),
  KEY `FK_Reference_2` (`auth_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色权限关系表';

-- ----------------------------
-- Records of r_role_auth
-- ----------------------------
INSERT INTO `r_role_auth` VALUES ('1', '1', '1', '1', '0');
INSERT INTO `r_role_auth` VALUES ('2', '1', '1', '2', '0');
INSERT INTO `r_role_auth` VALUES ('3', '1', '1', '3', '0');
INSERT INTO `r_role_auth` VALUES ('4', '1', '1', '4', '0');
INSERT INTO `r_role_auth` VALUES ('5', '1', '1', '5', '0');

-- ----------------------------
-- Table structure for `r_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `r_user_role`;
CREATE TABLE `r_user_role` (
  `relation_id` varchar(64) NOT NULL COMMENT '关系ID',
  `tenant_id` varchar(64) DEFAULT NULL COMMENT '租户ID',
  `user_id` varchar(64) DEFAULT NULL COMMENT '用户ID',
  `role_id` varchar(64) DEFAULT NULL COMMENT '角色ID',
  `status_cd` int(11) DEFAULT NULL COMMENT '数据状态（0：有效，1：无效）',
  PRIMARY KEY (`relation_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户角色关系表';

-- ----------------------------
-- Records of r_user_role
-- ----------------------------
INSERT INTO `r_user_role` VALUES ('1', '1', '1329257231245377536', '1', '0');

-- ----------------------------
-- Table structure for `t_auth`
-- ----------------------------
DROP TABLE IF EXISTS `t_auth`;
CREATE TABLE `t_auth` (
  `auth_id` varchar(64) NOT NULL COMMENT '权限ID',
  `tenant_id` varchar(64) DEFAULT NULL COMMENT '租户ID',
  `parent_id` varchar(64) DEFAULT NULL COMMENT '父级权限ID',
  `auth_code` varchar(11) DEFAULT NULL COMMENT '权限Code',
  `auth_name` varchar(64) DEFAULT NULL COMMENT '权限名称',
  `auth_type` int(1) DEFAULT NULL COMMENT '权限类型（0：静态资源，1：菜单，2：按钮/接口绑定权限）',
  `menu_id` varchar(64) DEFAULT NULL COMMENT '菜单ID',
  `page_element_id` varchar(64) DEFAULT NULL COMMENT '页面元素ID',
  `static_resource_id` varchar(64) DEFAULT NULL COMMENT '静态资源ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_staff` varchar(64) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_staff` varchar(64) DEFAULT NULL COMMENT '修改人',
  `status_cd` int(11) DEFAULT NULL COMMENT '数据状态（0：有效，1：无效）',
  PRIMARY KEY (`auth_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='权限表';

-- ----------------------------
-- Records of t_auth
-- ----------------------------
INSERT INTO `t_auth` VALUES ('1', '1', '0', 'manage:find', '允许访问系统管理', '1', '1', null, null, '2020-11-19 14:00:05', 'system', null, null, '0');
INSERT INTO `t_auth` VALUES ('2', '1', '1', 'user:find', '允许访问用户管理', '1', '2', null, null, '2020-11-19 14:09:20', 'system', null, null, '0');
INSERT INTO `t_auth` VALUES ('3', '1', '1', 'role:find', '允许访问角色管理', '1', '3', null, null, '2020-11-19 14:10:07', 'system', null, null, '0');
INSERT INTO `t_auth` VALUES ('4', '1', '1', 'menu:find', '允许访问菜单管理', '1', '4', null, null, '2020-11-19 14:12:32', 'system', null, null, '0');
INSERT INTO `t_auth` VALUES ('5', '1', '2', 'user:add', '允许用户新增', '2', '', '', null, '2020-11-19 14:14:40', 'system', null, null, '0');

-- ----------------------------
-- Table structure for `t_menu`
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu` (
  `menu_id` varchar(64) NOT NULL COMMENT '菜单ID',
  `tenant_id` varchar(64) DEFAULT NULL COMMENT '租户ID',
  `parent_menu_id` varchar(64) DEFAULT NULL COMMENT '父级菜单ID',
  `menu_name` varchar(64) DEFAULT NULL COMMENT '菜单名称',
  `menu_level` int(11) DEFAULT NULL COMMENT '菜单级别',
  `menu_url` varchar(64) DEFAULT NULL COMMENT '菜单URL',
  `menu_router` varchar(64) DEFAULT NULL COMMENT '菜单路由',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_staff` varchar(64) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_staff` varchar(64) DEFAULT NULL COMMENT '修改人',
  `status_cd` int(11) DEFAULT NULL COMMENT '数据状态（0：有效，1：无效）',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='菜单表';

-- ----------------------------
-- Records of t_menu
-- ----------------------------
INSERT INTO `t_menu` VALUES ('1', '1', '0', '系统管理', '1', '/sys/manage', '/sys/manage', '2020-11-19 14:03:51', 'system', null, null, '0');
INSERT INTO `t_menu` VALUES ('2', '1', '1', '用户管理', '2', '/sys/manage/user', '/sys/manage/user', '2020-11-19 14:04:39', 'system', null, null, '0');
INSERT INTO `t_menu` VALUES ('3', '1', '1', '角色管理', '2', '/sys/manage/role', '/sys/manage/role', '2020-11-19 14:05:14', 'system', null, null, '0');
INSERT INTO `t_menu` VALUES ('4', '1', '1', '菜单管理', '2', '/sys/manage/menu', '/sys/manage/menu', '2020-11-19 14:06:03', 'system', null, null, '0');

-- ----------------------------
-- Table structure for `t_page_element`
-- ----------------------------
DROP TABLE IF EXISTS `t_page_element`;
CREATE TABLE `t_page_element` (
  `page_element_id` varchar(64) NOT NULL COMMENT '页面元素ID',
  `tenant_id` varchar(64) DEFAULT NULL COMMENT '租户ID',
  `page_element_name` varchar(64) DEFAULT NULL COMMENT '页面元素名称',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_staff` varchar(64) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_staff` varchar(64) DEFAULT NULL COMMENT '修改人',
  `status_cd` int(11) DEFAULT NULL COMMENT '数据状态（0：有效，1：无效）',
  PRIMARY KEY (`page_element_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='页面元素表';

-- ----------------------------
-- Records of t_page_element
-- ----------------------------

-- ----------------------------
-- Table structure for `t_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `role_id` varchar(64) NOT NULL COMMENT '角色ID',
  `tenant_id` varchar(64) DEFAULT NULL COMMENT '租户ID',
  `role_code` varchar(11) DEFAULT NULL COMMENT '角色Code',
  `role_name` varchar(64) DEFAULT NULL COMMENT '角色名称',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_staff` varchar(64) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_staff` varchar(64) DEFAULT NULL COMMENT '修改人',
  `status_cd` int(11) DEFAULT NULL COMMENT '数据状态（0：有效，1：无效）',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色表';

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', '1', 'sys_manager', '系统管理员', '2020-11-19 13:58:25', 'system', null, null, '0');

-- ----------------------------
-- Table structure for `t_static_resource`
-- ----------------------------
DROP TABLE IF EXISTS `t_static_resource`;
CREATE TABLE `t_static_resource` (
  `static_resource_id` varchar(64) NOT NULL COMMENT '静态资源ID',
  `tenant_id` varchar(64) DEFAULT NULL COMMENT '租户ID',
  `static_resource_name` varchar(64) DEFAULT NULL COMMENT '静态资源名称',
  `static_resource_url` varchar(64) DEFAULT NULL COMMENT '静态资源URL',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_staff` varchar(64) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_staff` varchar(64) DEFAULT NULL COMMENT '修改人',
  `status_cd` int(11) DEFAULT NULL COMMENT '数据状态（0：有效，1：无效）',
  PRIMARY KEY (`static_resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='静态资源表';

-- ----------------------------
-- Records of t_static_resource
-- ----------------------------

-- ----------------------------
-- Table structure for `t_tenant`
-- ----------------------------
DROP TABLE IF EXISTS `t_tenant`;
CREATE TABLE `t_tenant` (
  `tenant_id` varchar(64) NOT NULL COMMENT '租户ID',
  `tenant_name` varchar(64) DEFAULT NULL COMMENT '租户名称',
  `system_account` varchar(64) DEFAULT NULL COMMENT '租户登录名',
  `system_password` varchar(64) DEFAULT NULL COMMENT '租户密码',
  `log_url` varchar(128) DEFAULT NULL COMMENT '租户Logo',
  `app_name` varchar(64) DEFAULT NULL COMMENT '应用名',
  `db_url` varchar(256) DEFAULT NULL COMMENT '数据库URL',
  `db_driver` varchar(64) DEFAULT NULL COMMENT '数据库驱动',
  `db_username` varchar(64) DEFAULT NULL COMMENT '数据库连接用户名',
  `db_password` varchar(64) DEFAULT NULL COMMENT '数据库连接密码',
  `tenant_mobile` varchar(32) DEFAULT NULL COMMENT '电话',
  `tenant_email` varchar(64) DEFAULT NULL COMMENT '邮箱',
  `description` varchar(256) DEFAULT NULL COMMENT '描述',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_staff` varchar(64) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_staff` varchar(64) DEFAULT NULL COMMENT '修改人',
  `status_cd` int(11) DEFAULT NULL COMMENT '数据状态（0：有效，1：无效）',
  PRIMARY KEY (`tenant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='租户表';

-- ----------------------------
-- Records of t_tenant
-- ----------------------------
INSERT INTO `t_tenant` VALUES ('1', '租户管理系统', 'admin', '123456', null, '租户管理系统', 'jdbc:mysql://127.0.0.1:3306/saas-boot?serverTimezone=Asia/Shanghai&allowMultiQueries=true&zeroDateTimeBehavior=convertToNull', 'com.mysql.cj.jdbc.Driver', 'root', '123456', '15317171343', '2524906142@qq.com', '租户管理系统超级管理员，管理各个租户', '2020-11-12 11:14:05', 'system', null, null, '1');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` varchar(64) NOT NULL COMMENT '用户ID',
  `tenant_id` varchar(64) DEFAULT NULL COMMENT '租户ID',
  `user_name` varchar(64) DEFAULT NULL COMMENT '用户名',
  `password` varchar(64) DEFAULT NULL COMMENT '用户密码',
  `salt` varchar(128) DEFAULT NULL COMMENT '加密盐',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_staff` varchar(64) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_staff` varchar(64) DEFAULT NULL COMMENT '修改人',
  `status_cd` int(11) DEFAULT NULL COMMENT '数据状态（0：有效，1：无效）',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1329257231245377536', '1', 'root', '9156518001f51b65b81ee4b9cc805008', '1329257231245377537', '2020-11-19 13:57:26', 'system', null, null, '0');

/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50724
Source Host           : localhost:3306
Source Database       : manage

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2020-11-15 17:28:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `r_auth_menu`
-- ----------------------------
DROP TABLE IF EXISTS `r_auth_menu`;
CREATE TABLE `r_auth_menu` (
  `relation_id` varchar(64) NOT NULL COMMENT '关系ID',
  `tenant_id` varchar(64) DEFAULT NULL COMMENT '租户ID',
  `auth_id` varchar(64) DEFAULT NULL COMMENT '权限ID',
  `menu_id` varchar(64) DEFAULT NULL COMMENT '菜单ID',
  `status_cd` int(11) DEFAULT NULL COMMENT '数据状态（0：有效，1：无效）',
  PRIMARY KEY (`relation_id`),
  KEY `FK_Reference_5` (`auth_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='权限菜单关系表';

-- ----------------------------
-- Records of r_auth_menu
-- ----------------------------

-- ----------------------------
-- Table structure for `r_auth_page_element`
-- ----------------------------
DROP TABLE IF EXISTS `r_auth_page_element`;
CREATE TABLE `r_auth_page_element` (
  `relation_id` varchar(64) NOT NULL COMMENT '关系ID',
  `tenant_id` varchar(64) DEFAULT NULL COMMENT '租户ID',
  `auth_id` varchar(64) DEFAULT NULL COMMENT '权限ID',
  `page_element_id` varchar(64) DEFAULT NULL COMMENT '页面元素ID',
  `status_cd` int(11) DEFAULT NULL COMMENT '数据状态（0：有效，1：无效）',
  PRIMARY KEY (`relation_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='权限页面元素关系表';

-- ----------------------------
-- Records of r_auth_page_element
-- ----------------------------

-- ----------------------------
-- Table structure for `r_auth_static_resource`
-- ----------------------------
DROP TABLE IF EXISTS `r_auth_static_resource`;
CREATE TABLE `r_auth_static_resource` (
  `relation_id` varchar(64) NOT NULL COMMENT '关系ID',
  `tenant_id` varchar(64) DEFAULT NULL COMMENT '租户ID',
  `auth_id` varchar(64) DEFAULT NULL COMMENT '权限ID',
  `static_resource_id` varchar(64) DEFAULT NULL COMMENT '静态资源ID',
  `status_cd` int(11) DEFAULT NULL COMMENT '数据状态（0：有效，1：无效）',
  PRIMARY KEY (`relation_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='权限静态资源关系表';

-- ----------------------------
-- Records of r_auth_static_resource
-- ----------------------------

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

-- ----------------------------
-- Table structure for `t_auth`
-- ----------------------------
DROP TABLE IF EXISTS `t_auth`;
CREATE TABLE `t_auth` (
  `auth_id` varchar(64) NOT NULL COMMENT '权限ID',
  `tenant_id` varchar(64) DEFAULT NULL COMMENT '租户ID',
  `parent_id` varchar(64) DEFAULT NULL COMMENT '父级权限ID',
  `auth_name` varchar(64) DEFAULT NULL COMMENT '权限名称',
  `auth_type` int(1) DEFAULT NULL COMMENT '权限类型（0：静态资源，1：菜单，2：按钮/接口绑定权限）',
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
INSERT INTO `t_tenant` VALUES ('1', '租户管理系统', 'admin', '123456', null, '租户管理系统', 'jdbc:mysql://127.0.0.1:3306/manage?serverTimezone=Asia/Shanghai&allowMultiQueries=true&zeroDateTimeBehavior=convertToNull', 'com.mysql.cj.jdbc.Driver', 'root', '123456', '15317171343', '2524906142@qq.com', '租户管理系统超级管理员，管理各个租户', '2020-11-12 11:14:05', 'system', null, null, '1');
INSERT INTO `t_tenant` VALUES ('82918d41eab345b7b5bfa109cf2c2087', '测试公司1', 'ceshi1', '123456', 'logUrl', '测试公司1的应用', 'jdbc:mysql://127.0.0.1:3306/saas-boot?serverTimezone=Asia/Shanghai&allowMultiQueries=true&zeroDateTimeBehavior=convertToNull', 'com.mysql.cj.jdbc.Driver', 'root', '123456', '14356789222', '252490614@qq.com', '测试公司1', null, '龚松', null, null, '0');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` varchar(64) NOT NULL COMMENT '用户ID',
  `tenant_id` varchar(64) DEFAULT NULL COMMENT '租户ID',
  `user_name` varchar(64) DEFAULT NULL COMMENT '用户名',
  `password` varchar(64) DEFAULT NULL COMMENT '用户密码',
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

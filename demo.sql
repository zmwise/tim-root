/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost:3306
 Source Schema         : demo

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : 65001

 Date: 21/04/2018 10:40:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `organization_id` bigint(20) UNSIGNED NULL DEFAULT NULL COMMENT '机构ID',
  `username` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `real_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `salt` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '盐',
  `role_ids` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色列表',
  `locked` tinyint(1) NULL DEFAULT 0 COMMENT '账户是否锁定',
  `email` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除',
  `partner_id` bigint(20) NULL DEFAULT NULL COMMENT '合作方主键',
  `upd_pwd_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '上次修改密码时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_sys_user_organization_id`(`organization_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 1, 'demo@163', 'demod', '538d3ef77b5c423308b7c0b2bef56a36', 'fa1efe8e004feacef51262e5bc524568', '1', 0, 'demo@163.com', '13800000000', '2018-04-21 10:39:34', 1, NULL, '2018-03-14 14:39:22');
INSERT INTO `sys_user` VALUES (2, 1, 'xxxx@163', 'xinlen', '538d3ef77b5c423308b7c0b2bef56a36', 'fa1efe8e004feacef51262e5bc524568', '1', 0, 'xxxx@163.com', '13800000001', '2018-04-21 10:39:23', 1, NULL, '2018-03-14 14:39:22');
INSERT INTO `sys_user` VALUES (3, 1, 'aaaa@163', 'allen', '538d3ef77b5c423308b7c0b2bef56a36', 'fa1efe8e004feacef51262e5bc524568', '1', 0, 'aaaa@163.com', '13800000002', '2018-04-21 10:39:18', 1, NULL, '2018-03-14 14:39:22');
INSERT INTO `sys_user` VALUES (4, 1, 'bbbb@163', 'belle', '538d3ef77b5c423308b7c0b2bef56a36', 'fa1efe8e004feacef51262e5bc524568', '1', 0, 'bbbb@163.com', '13800000003', '2016-06-14 14:42:13', 1, NULL, '2018-03-14 14:39:22');
INSERT INTO `sys_user` VALUES (5, 1, 'cccc@163', 'congale', '538d3ef77b5c423308b7c0b2bef56a36', 'fa1efe8e004feacef51262e5bc524568', '1', 0, 'cccc@163.com', '13800000004', '2016-06-14 14:42:13', 1, NULL, '2018-03-14 14:39:22');
INSERT INTO `sys_user` VALUES (6, 1, 'dddd@163', 'davil', '538d3ef77b5c423308b7c0b2bef56a36', 'fa1efe8e004feacef51262e5bc524568', '1', 0, 'dddd@163.com', '13800000005', '2016-06-14 14:42:13', 1, NULL, '2018-03-14 14:39:22');
INSERT INTO `sys_user` VALUES (7, 1, 'eeee@163', 'esem', '538d3ef77b5c423308b7c0b2bef56a36', 'fa1efe8e004feacef51262e5bc524568', '1', 0, 'eeee@163.com', '13800000006', '2016-06-14 14:42:13', 1, NULL, '2018-03-14 14:39:22');
INSERT INTO `sys_user` VALUES (8, 1, 'ffff@163', 'fegen', '538d3ef77b5c423308b7c0b2bef56a36', 'fa1efe8e004feacef51262e5bc524568', '1', 0, 'ffff@163.com', '13800000007', '2016-06-14 14:42:13', 1, NULL, '2018-03-14 14:39:22');
INSERT INTO `sys_user` VALUES (9, 1, 'gggg@163', 'Gareey', '538d3ef77b5c423308b7c0b2bef56a36', 'fa1efe8e004feacef51262e5bc524568', '1', 0, 'gggg@163.com', '13800000008', '2016-06-14 14:42:13', 1, NULL, '2018-03-14 14:39:22');
INSERT INTO `sys_user` VALUES (10, 1, 'hhhh@163', 'Hansen', '538d3ef77b5c423308b7c0b2bef56a36', 'fa1efe8e004feacef51262e5bc524568', '1', 0, 'hhhh@163.com', '13800000009', '2016-06-14 14:42:13', 1, NULL, '2018-03-14 14:39:22');
INSERT INTO `sys_user` VALUES (11, 1, 'jjjj@163', 'Jimmy', '538d3ef77b5c423308b7c0b2bef56a36', 'fa1efe8e004feacef51262e5bc524568', '1', 0, 'jjjj@163.com', '13800000010', '2016-06-14 14:42:13', 1, NULL, '2018-03-14 14:39:22');
INSERT INTO `sys_user` VALUES (12, 1, 'kkkk@163', 'Karrey', '538d3ef77b5c423308b7c0b2bef56a36', 'fa1efe8e004feacef51262e5bc524568', '1', 0, 'kkkk@163.com', '13800000011', '2016-06-14 14:42:13', 1, NULL, '2018-03-14 14:39:22');

SET FOREIGN_KEY_CHECKS = 1;

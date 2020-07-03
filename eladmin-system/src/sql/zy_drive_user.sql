/*
 Navicat MySQL Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 50562
 Source Host           : localhost:3306
 Source Schema         : admin

 Target Server Type    : MySQL
 Target Server Version : 50562
 File Encoding         : 65001

 Date: 25/06/2020 18:00:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for zy_drive_user
-- ----------------------------
DROP TABLE IF EXISTS `zy_drive_user`;
CREATE TABLE `zy_drive_user`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'id',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '照片',
  `age` int(6) NULL DEFAULT NULL COMMENT '年龄',
  `driving_years` int(6) NULL DEFAULT NULL COMMENT '驾龄',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '电话',
  `driving_type` int(1) NULL DEFAULT NULL COMMENT '驾驶证类型',
  `working_state` int(1) NULL DEFAULT NULL COMMENT '在职状态',
  `audit` int(1) NULL DEFAULT NULL COMMENT '审核状态',
  `status` bigint(1) NULL DEFAULT NULL COMMENT '禁用状态',
  `del` int(1) NULL DEFAULT NULL COMMENT '删除状态',
  `driver_positive` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '驾驶证正面',
  `driver_reverse` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '驾驶证反面',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

SET FOREIGN_KEY_CHECKS = 1;

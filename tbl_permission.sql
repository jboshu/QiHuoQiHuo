/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50151
Source Host           : localhost:3306
Source Database       : mydb

Target Server Type    : MYSQL
Target Server Version : 50151
File Encoding         : 65001

Date: 2019-05-25 18:00:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tbl_permission
-- ----------------------------
DROP TABLE IF EXISTS `tbl_permission`;
CREATE TABLE `tbl_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `className` varchar(255) NOT NULL,
  `permissionCode` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_permission
-- ----------------------------
INSERT INTO `tbl_permission` VALUES ('1', 'login.manager.login', '31');
INSERT INTO `tbl_permission` VALUES ('2', 'login.manager.loginAction', '31');
INSERT INTO `tbl_permission` VALUES ('3', 'login.manager.logoutAction', '31');
INSERT INTO `tbl_permission` VALUES ('4', 'user.manager.addAction', '24');
INSERT INTO `tbl_permission` VALUES ('5', 'user.manager.statisticAction', '24');
INSERT INTO `tbl_permission` VALUES ('6', 'user.manager.deleteAction', '24');
INSERT INTO `tbl_permission` VALUES ('7', 'user.manager.checkEmailAvailable', '31');
INSERT INTO `tbl_permission` VALUES ('8', 'user.manager.checkUsernameAvailable', '31');
INSERT INTO `tbl_permission` VALUES ('9', 'user.manager.editAction', '24');
INSERT INTO `tbl_permission` VALUES ('10', 'user.manager.enableAccountAction', '31');
INSERT INTO `tbl_permission` VALUES ('11', 'user.manager.forgetPasswordAction', '28');
INSERT INTO `tbl_permission` VALUES ('12', 'user.manager.queryAction', '24');
INSERT INTO `tbl_permission` VALUES ('13', 'user.manager.resetPasswordAction', '28');
INSERT INTO `tbl_permission` VALUES ('14', 'user.manager.userRegisterAction', '31');
INSERT INTO `tbl_permission` VALUES ('15', 'news.getNews.getNewsAction', '30');
INSERT INTO `tbl_permission` VALUES ('16', 'news.getNews.newsDeleteAction', '24');
INSERT INTO `tbl_permission` VALUES ('17', 'news.getNews.newsExportAction', '24');
INSERT INTO `tbl_permission` VALUES ('18', 'news.getNews.newsManagerAction', '24');
INSERT INTO `tbl_permission` VALUES ('19', 'news.getNews.newsModifyAction', '24');
INSERT INTO `tbl_permission` VALUES ('20', 'news.getNews.newsSearchAction', '24');
INSERT INTO `tbl_permission` VALUES ('21', 'news.getNews.newsStatisticsAction', '24');
INSERT INTO `tbl_permission` VALUES ('22', 'quotation.getXLdata.getDataToShowAction', '30');
INSERT INTO `tbl_permission` VALUES ('23', 'quotation.getXLdata.showUSDCNYdataAction', '28');
INSERT INTO `tbl_permission` VALUES ('24', 'quotation.getXLdata.showUSDCNYupdateAction', '28');

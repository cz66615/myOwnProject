/*
Navicat MySQL Data Transfer

Source Server         : name1
Source Server Version : 80028
Source Host           : localhost:3306
Source Database       : mytest

Target Server Type    : MYSQL
Target Server Version : 80028
File Encoding         : 65001

Date: 2022-05-30 18:19:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for consult
-- ----------------------------
DROP TABLE IF EXISTS `consult`;
CREATE TABLE `consult` (
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `age` int NOT NULL,
  `time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `contact` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`username`,`age`),
  CONSTRAINT `consult_ibfk_1` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of consult
-- ----------------------------
INSERT INTO `consult` VALUES ('admin', '20', '2022', 'study', '0111');
INSERT INTO `consult` VALUES ('cz', '21', '2021', 'life', '0425');
INSERT INTO `consult` VALUES ('tyq', '18', '2022', 'job', '0129');
INSERT INTO `consult` VALUES ('wcy', '21', '2021', 'sports', '0221');

-- ----------------------------
-- Table structure for meet
-- ----------------------------
DROP TABLE IF EXISTS `meet`;
CREATE TABLE `meet` (
  `username` varchar(255) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `stage` int DEFAULT NULL,
  `phenomenon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  KEY `username` (`username`),
  CONSTRAINT `meet_ibfk_1` FOREIGN KEY (`username`) REFERENCES `user` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of meet
-- ----------------------------
INSERT INTO `meet` VALUES (null, null, '1', '婴儿期\r\n\r\n(0~2岁)\r\n\r\n这个时候的你，还不会说话，不懂得如何正确的表达需要，正在学习怎么样和人沟通，逐渐认识到自己是一个独立的人，学着信任别人，学坐，站，走，跑和摆弄东西。\r\n\r\n你还在学着自己吃饭，虽然你总是笨拙的打翻饭碗，把米粒吃的满身都是，但是这个时候的你已经会表达愤怒和快乐。\r\n\r\n现在的你，最需要被爱和被关怀... ...');
INSERT INTO `meet` VALUES (null, null, '2', '儿童期\r\n\r\n(2~12岁)\r\n\r\n这个时候的你，语言和运动能力都有了显著的提高，你正在学习和别人一起玩耍，学会分享，发展同伴关系，开始认识到自己和周围所处的世界是相联系的。\r\n\r\n你开始学习阅读，写作，算术。你对性别，文化，民族有了更深入的认识。有了更好的共情能力，能够更好地接受别人的观点。\r\n\r\n现在的你，需要完成自我控制的任务，逐渐拓展自己对这个世界的了解和认识... ...');
INSERT INTO `meet` VALUES (null, null, '3', '青春期\r\n\r\n(12~14岁)\r\n\r\n这个时候的你，开始表达自己的见解，继续发展独立意识，加深对道德的理解能力，适应身体以及外形上的快速变化，学会与他人协作。\r\n\r\n你与同龄人，家庭和社区的关系进一步拓展。\r\n\r\n现在的你，偶尔会矛盾，可能会出现一些负面情绪... ...');
INSERT INTO `meet` VALUES (null, null, '4', '青少年期\r\n\r\n(14~20岁)\r\n\r\n这个时候的你，开始表达自己的见解，继续发展独立意识，加深对道德的理解能力，适应身体以及外形上的快速变化，学会与他人协作。\r\n\r\n你与同龄人，家庭和社区的关系进一步拓展。\r\n\r\n现在的你，偶尔会矛盾，可能会出现一些负面情绪... ...');

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `num` int NOT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `result` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`num`,`username`),
  KEY `username` (`username`),
  CONSTRAINT `test_ibfk_1` FOREIGN KEY (`username`) REFERENCES `topic` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of test
-- ----------------------------
INSERT INTO `test` VALUES ('1', 'admin', 'A');
INSERT INTO `test` VALUES ('2', 'cz', 'B');
INSERT INTO `test` VALUES ('3', 'tyq', 'B');
INSERT INTO `test` VALUES ('4', 'wcy', 'C');

-- ----------------------------
-- Table structure for topic
-- ----------------------------
DROP TABLE IF EXISTS `topic`;
CREATE TABLE `topic` (
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `num` int DEFAULT NULL,
  `topicname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`username`) USING BTREE,
  KEY `num` (`num`) USING BTREE,
  CONSTRAINT `topic_ibfk_2` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of topic
-- ----------------------------
INSERT INTO `topic` VALUES ('admin', '1', 'study');
INSERT INTO `topic` VALUES ('cz', '2', 'life');
INSERT INTO `topic` VALUES ('tyq', '3', 'job');
INSERT INTO `topic` VALUES ('wcy', '4', 'sports');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `age` int DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`userid`),
  KEY `username` (`username`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '123456', '26', '女');
INSERT INTO `user` VALUES ('2', 'tyq', '123456', '18', '女');
INSERT INTO `user` VALUES ('4', 'wcy', '123456', '21', '男');
INSERT INTO `user` VALUES ('425129221204', 'cz', '123456', '20', '男');
INSERT INTO `user` VALUES ('425129221205', 'cz2', '123', '20', '男');

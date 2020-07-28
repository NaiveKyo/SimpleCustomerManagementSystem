/*
 Navicat Premium Data Transfer

 Source Server         : root
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : bankcustomersystem

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 28/07/2020 09:47:06
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `BMS_ID` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名（主键）',
  `BMS_PSWD` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  PRIMARY KEY (`BMS_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('测试管理员1', '123456');
INSERT INTO `admin` VALUES ('测试管理员2', '123456');
INSERT INTO `admin` VALUES ('测试管理员3', '123456');
INSERT INTO `admin` VALUES ('测试管理员4', '123456');
INSERT INTO `admin` VALUES ('测试管理员5', '123456');
INSERT INTO `admin` VALUES ('测试管理员6', '123456');

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer`  (
  `c_ID` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号（主键）',
  `c_Name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '客户姓名',
  `c_PSWD` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '客户密码',
  `c_Identity` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '客户身份证',
  `c_Balance` decimal(8, 2) NOT NULL DEFAULT 0.00 COMMENT '余额',
  `c_status` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '现在状态',
  `c_Address` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户住址',
  `c_Date` date NOT NULL COMMENT '开户时间',
  PRIMARY KEY (`c_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('110220', '王五', '1', '411521199412121547', 81500.00, '正常', '河南省', '2020-06-12');
INSERT INTO `customer` VALUES ('123456', '测试账户4', '1', '411521199902021234', 0.00, '过期', '上海市', '2020-06-22');
INSERT INTO `customer` VALUES ('128548', '张三', '123456', '411521199905130325', 7500.00, '正常', '河南省', '2020-06-11');
INSERT INTO `customer` VALUES ('167821', '张三', '1', '411521199905130325', 27500.00, '正常', '河南省', '2020-06-11');
INSERT INTO `customer` VALUES ('176542', '王五', '123456', '411521199412121547', 17400.00, '正常', '河南省', '2020-06-11');
INSERT INTO `customer` VALUES ('245689', '测试账户2', '123456', '411521199611110258', 7300.00, '正常', '四川省', '2020-06-11');
INSERT INTO `customer` VALUES ('354126', '测试账户1', '123456', '411521200001010321', 7100.00, '正常', '河北省', '2020-06-11');
INSERT INTO `customer` VALUES ('512468', '李四', '123456', '411521200103250456', 6700.00, '正常', '山西省', '2020-06-11');
INSERT INTO `customer` VALUES ('654123', '测试账户3', '123456', '411521199807070654', 7500.00, '正常', '河南省', '2020-06-11');

-- ----------------------------
-- Table structure for deposit
-- ----------------------------
DROP TABLE IF EXISTS `deposit`;
CREATE TABLE `deposit`  (
  `BMS_ID` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '操作员ID号',
  `c_ID` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '客户账号',
  `d_Date` date NOT NULL COMMENT '存款时间',
  `d_Money` decimal(8, 2) NOT NULL COMMENT '存款金额',
  `c_Balance` decimal(8, 2) NOT NULL DEFAULT 0.00 COMMENT '余额',
  INDEX `BMS_ID`(`BMS_ID`) USING BTREE,
  INDEX `c_ID`(`c_ID`) USING BTREE,
  CONSTRAINT `deposit_ibfk_1` FOREIGN KEY (`BMS_ID`) REFERENCES `admin` (`BMS_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `deposit_ibfk_2` FOREIGN KEY (`c_ID`) REFERENCES `customer` (`c_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of deposit
-- ----------------------------
INSERT INTO `deposit` VALUES ('测试管理员1', '128548', '2020-06-11', 10000.00, 10000.00);
INSERT INTO `deposit` VALUES ('测试管理员1', '167821', '2020-06-11', 10000.00, 10000.00);
INSERT INTO `deposit` VALUES ('测试管理员1', '176542', '2020-06-11', 10000.00, 10000.00);
INSERT INTO `deposit` VALUES ('测试管理员1', '245689', '2020-06-11', 10000.00, 10000.00);
INSERT INTO `deposit` VALUES ('测试管理员1', '354126', '2020-06-11', 10000.00, 10000.00);
INSERT INTO `deposit` VALUES ('测试管理员1', '512468', '2020-06-11', 10000.00, 10000.00);
INSERT INTO `deposit` VALUES ('测试管理员1', '654123', '2020-06-11', 10000.00, 10000.00);
INSERT INTO `deposit` VALUES ('测试管理员1', '128548', '2020-06-12', 1000.00, 11000.00);
INSERT INTO `deposit` VALUES ('测试管理员1', '110220', '2020-06-20', 200.00, 6700.00);
INSERT INTO `deposit` VALUES ('测试管理员1', '110220', '2020-06-20', 5000.00, 11500.00);
INSERT INTO `deposit` VALUES ('测试管理员1', '110220', '2020-06-22', 200.00, 11700.00);
INSERT INTO `deposit` VALUES ('测试管理员1', '110220', '2020-06-22', 300000.00, 111700.00);
INSERT INTO `deposit` VALUES ('测试管理员1', '110220', '2020-06-22', 100.00, 111800.00);
INSERT INTO `deposit` VALUES ('测试管理员1', '167821', '2020-06-22', 30000.00, 27500.00);
INSERT INTO `deposit` VALUES ('测试管理员1', '110220', '2020-06-22', 200.00, 82000.00);

-- ----------------------------
-- Table structure for transfer
-- ----------------------------
DROP TABLE IF EXISTS `transfer`;
CREATE TABLE `transfer`  (
  `BMS_ID` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '操作员ID',
  `c_ID` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '客户账号',
  `t_ID` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '客户转账账户',
  `t_Date` date NOT NULL COMMENT '转账时间',
  `t_Money` decimal(8, 2) NOT NULL COMMENT '转账金额',
  `c_Balance` decimal(8, 2) NOT NULL DEFAULT 0.00 COMMENT '余额',
  INDEX `BMS_ID`(`BMS_ID`) USING BTREE,
  INDEX `c_ID`(`c_ID`) USING BTREE,
  CONSTRAINT `transfer_ibfk_1` FOREIGN KEY (`BMS_ID`) REFERENCES `admin` (`BMS_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `transfer_ibfk_2` FOREIGN KEY (`c_ID`) REFERENCES `customer` (`c_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of transfer
-- ----------------------------
INSERT INTO `transfer` VALUES ('测试管理员1', '176542', '110220', '2020-06-12', 2000.00, 4800.00);
INSERT INTO `transfer` VALUES ('测试管理员1', '354126', '512468', '2020-06-12', 100.00, 5900.00);
INSERT INTO `transfer` VALUES ('测试管理员1', '512468', '110220', '2020-06-12', 3000.00, 6700.00);
INSERT INTO `transfer` VALUES ('测试管理员1', '245689', '176542', '2020-06-12', 2300.00, 7300.00);
INSERT INTO `transfer` VALUES ('测试管理员1', '167821', '354126', '2020-06-12', 1200.00, 8000.00);
INSERT INTO `transfer` VALUES ('测试管理员1', '128548', '110220', '2020-06-12', 500.00, 7500.00);
INSERT INTO `transfer` VALUES ('测试管理员1', '167821', '110220', '2020-06-12', 500.00, 7500.00);
INSERT INTO `transfer` VALUES ('测试管理员1', '654123', '110220', '2020-06-12', 500.00, 7500.00);
INSERT INTO `transfer` VALUES ('测试管理员1', '110220', '176542', '2020-06-22', 10000.00, 81800.00);
INSERT INTO `transfer` VALUES ('测试管理员1', '110220', '176542', '2020-06-22', 300.00, 81500.00);

-- ----------------------------
-- Table structure for withdrawal
-- ----------------------------
DROP TABLE IF EXISTS `withdrawal`;
CREATE TABLE `withdrawal`  (
  `BMS_ID` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '操作员ID',
  `c_ID` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '客户账号',
  `w_Date` date NOT NULL COMMENT '取款时间',
  `w_Money` decimal(8, 2) NOT NULL COMMENT '取款金额',
  `c_Balance` decimal(8, 2) NOT NULL DEFAULT 0.00 COMMENT '余额',
  INDEX `BMS_ID`(`BMS_ID`) USING BTREE,
  INDEX `c_ID`(`c_ID`) USING BTREE,
  CONSTRAINT `withdrawal_ibfk_1` FOREIGN KEY (`BMS_ID`) REFERENCES `admin` (`BMS_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `withdrawal_ibfk_2` FOREIGN KEY (`c_ID`) REFERENCES `customer` (`c_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of withdrawal
-- ----------------------------
INSERT INTO `withdrawal` VALUES ('测试管理员1', '128548', '2020-06-12', 2000.00, 9000.00);
INSERT INTO `withdrawal` VALUES ('测试管理员1', '128548', '2020-06-12', 1000.00, 8000.00);
INSERT INTO `withdrawal` VALUES ('测试管理员1', '167821', '2020-06-12', 500.00, 9500.00);
INSERT INTO `withdrawal` VALUES ('测试管理员1', '167821', '2020-06-12', 300.00, 9200.00);
INSERT INTO `withdrawal` VALUES ('测试管理员1', '176542', '2020-06-12', 3000.00, 7000.00);
INSERT INTO `withdrawal` VALUES ('测试管理员1', '176542', '2020-06-12', 200.00, 6800.00);
INSERT INTO `withdrawal` VALUES ('测试管理员1', '245689', '2020-06-12', 100.00, 9900.00);
INSERT INTO `withdrawal` VALUES ('测试管理员1', '245689', '2020-06-12', 300.00, 9600.00);
INSERT INTO `withdrawal` VALUES ('测试管理员1', '354126', '2020-06-12', 1500.00, 8500.00);
INSERT INTO `withdrawal` VALUES ('测试管理员1', '354126', '2020-06-12', 2500.00, 6000.00);
INSERT INTO `withdrawal` VALUES ('测试管理员1', '512468', '2020-06-12', 300.00, 9700.00);
INSERT INTO `withdrawal` VALUES ('测试管理员1', '512468', '2020-06-12', 100.00, 9600.00);
INSERT INTO `withdrawal` VALUES ('测试管理员1', '654123', '2020-06-12', 2000.00, 8000.00);
INSERT INTO `withdrawal` VALUES ('测试管理员1', '110220', '2020-06-20', 200.00, 6500.00);
INSERT INTO `withdrawal` VALUES ('测试管理员1', '110220', '2020-06-22', 200000.00, -188300.00);
INSERT INTO `withdrawal` VALUES ('测试管理员1', '167821', '2020-06-22', 10000.00, -2500.00);
INSERT INTO `withdrawal` VALUES ('测试管理员1', '110220', '2020-06-22', 20000.00, 91800.00);
INSERT INTO `withdrawal` VALUES ('测试管理员1', '110220', '2020-06-22', 200.00, 81800.00);

-- ----------------------------
-- View structure for filternulladdress
-- ----------------------------
DROP VIEW IF EXISTS `filternulladdress`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `filternulladdress` AS select `customer`.`c_Name` AS `c_Name`,`customer`.`c_Identity` AS `c_Identity`,`customer`.`c_Address` AS `c_Address` from `customer` where (`customer`.`c_Address` is not null);

-- ----------------------------
-- Procedure structure for customerIDQuery
-- ----------------------------
DROP PROCEDURE IF EXISTS `customerIDQuery`;
delimiter ;;
CREATE PROCEDURE `customerIDQuery`(IN `id` varchar(20))
BEGIN
	SELECT * FROM customer
	WHERE id = customer.c_ID;
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table customer
-- ----------------------------
DROP TRIGGER IF EXISTS `showDate`;
delimiter ;;
CREATE TRIGGER `showDate` BEFORE INSERT ON `customer` FOR EACH ROW BEGIN
	SET NEW.c_Date = DATE_FORMAT(NOW(),'%y-%m-%d');
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table customer
-- ----------------------------
DROP TRIGGER IF EXISTS `delMessgae`;
delimiter ;;
CREATE TRIGGER `delMessgae` AFTER DELETE ON `customer` FOR EACH ROW BEGIN
	DELETE FROM deposit
	WHERE deposit.c_ID = OLD.c_ID;
	
	DELETE FROM withdrawal
	WHERE withdrawal.c_ID = OLD.c_ID;
	
	DELETE FROM transfer
	WHERE transfer.c_ID = OLD.c_ID;
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table deposit
-- ----------------------------
DROP TRIGGER IF EXISTS `showDateD`;
delimiter ;;
CREATE TRIGGER `showDateD` BEFORE INSERT ON `deposit` FOR EACH ROW BEGIN
	SET NEW.d_Date = DATE_FORMAT(NOW(),'%y-%m-%d');
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table deposit
-- ----------------------------
DROP TRIGGER IF EXISTS `showBalanceD`;
delimiter ;;
CREATE TRIGGER `showBalanceD` BEFORE INSERT ON `deposit` FOR EACH ROW BEGIN
	DECLARE money DECIMAL(8, 2);
	
	SELECT c_Balance
	FROM customer
	WHERE customer.c_ID = NEW.c_ID
	INTO money;
	
	SET NEW.c_Balance = NEW.d_Money + money;
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table deposit
-- ----------------------------
DROP TRIGGER IF EXISTS `addBalance`;
delimiter ;;
CREATE TRIGGER `addBalance` AFTER INSERT ON `deposit` FOR EACH ROW BEGIN
	UPDATE customer SET c_Balance = c_Balance + NEW.d_Money
  WHERE customer.c_ID = NEW.c_ID;
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table transfer
-- ----------------------------
DROP TRIGGER IF EXISTS `subBalanceT`;
delimiter ;;
CREATE TRIGGER `subBalanceT` AFTER INSERT ON `transfer` FOR EACH ROW BEGIN
	UPDATE customer SET c_Balance = c_Balance - NEW.t_Money
  WHERE customer.c_ID = NEW.c_ID;
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table transfer
-- ----------------------------
DROP TRIGGER IF EXISTS `showDateT`;
delimiter ;;
CREATE TRIGGER `showDateT` BEFORE INSERT ON `transfer` FOR EACH ROW BEGIN
	SET NEW.t_Date = DATE_FORMAT(NOW(),'%y-%m-%d');
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table transfer
-- ----------------------------
DROP TRIGGER IF EXISTS `showBalanceT`;
delimiter ;;
CREATE TRIGGER `showBalanceT` BEFORE INSERT ON `transfer` FOR EACH ROW BEGIN
	DECLARE money DECIMAL(8, 2);
	
	SELECT c_Balance
	FROM customer
	WHERE customer.c_ID = NEW.c_ID
	INTO money;
	
	SET NEW.c_Balance = money - NEW.t_Money;
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table transfer
-- ----------------------------
DROP TRIGGER IF EXISTS `addTransfer`;
delimiter ;;
CREATE TRIGGER `addTransfer` AFTER INSERT ON `transfer` FOR EACH ROW BEGIN
	UPDATE customer SET c_Balance = c_Balance + NEW.t_Money
  WHERE customer.c_ID = NEW.t_ID;
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table withdrawal
-- ----------------------------
DROP TRIGGER IF EXISTS `showDateW`;
delimiter ;;
CREATE TRIGGER `showDateW` BEFORE INSERT ON `withdrawal` FOR EACH ROW BEGIN
	SET NEW.w_Date = DATE_FORMAT(NOW(),'%y-%m-%d');
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table withdrawal
-- ----------------------------
DROP TRIGGER IF EXISTS `showBalanceW`;
delimiter ;;
CREATE TRIGGER `showBalanceW` BEFORE INSERT ON `withdrawal` FOR EACH ROW BEGIN
	DECLARE money DECIMAL(8, 2);
	
	SELECT c_Balance
	FROM customer
	WHERE customer.c_ID = NEW.c_ID
	INTO money;
	
	SET NEW.c_Balance = money - NEW.w_Money;
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table withdrawal
-- ----------------------------
DROP TRIGGER IF EXISTS `subBalance`;
delimiter ;;
CREATE TRIGGER `subBalance` AFTER INSERT ON `withdrawal` FOR EACH ROW BEGIN
	UPDATE customer SET c_Balance = c_Balance - NEW.w_Money
  WHERE customer.c_ID = NEW.c_ID;
END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;

-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.7.15-log - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.3.0.4999
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出 db_oa 的数据库结构
CREATE DATABASE IF NOT EXISTS `db_oa` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `db_oa`;


-- 导出  表 db_oa.address 结构
CREATE TABLE IF NOT EXISTS `address` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL DEFAULT '',
  `name` varchar(50) NOT NULL DEFAULT '',
  `sex` varchar(10) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `qq` varchar(20) DEFAULT NULL,
  `company` varchar(100) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `postcode` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID` (`ID`),
  KEY `ID_2` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=gb2312;

-- 正在导出表  db_oa.address 的数据：~6 rows (大约)
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
REPLACE INTO `address` (`ID`, `username`, `name`, `sex`, `mobile`, `email`, `qq`, `company`, `address`, `postcode`) VALUES
	(8, 'admin', '牛力', '女', '12345678911', '123@126.com', '654321', '北京地税局', '北京市昌平区', '010000'),
	(9, 'admin', '李霞', '女', '12345678911', '123@126.com', '123456', '北京地税局', '北京市昌平区', '010000'),
	(10, 'admin', '李华明', '男', '12345678911', '123@126.com', '123456', '北京地税局', '北京市昌平区', '010000'),
	(11, 'admin', '张明', '男', '12345678911', '123@126.com', '123456', '北京地税局', '北京市昌平区', '010000'),
	(12, 'admin', '陈丽', '女', '12345678911', '123@126.com', '123456', '北京地税局', '北京市昌平区', '010000'),
	(14, 'admin', '测试', '男', '13423231212', 'ege@yahoo.com.cn', '32423323', '中国电信', '北京市海淀区XXXX', '100000');
/*!40000 ALTER TABLE `address` ENABLE KEYS */;


-- 导出  表 db_oa.meeting 结构
CREATE TABLE IF NOT EXISTS `meeting` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `sender` varchar(50) NOT NULL DEFAULT '',
  `starttime` varchar(20) DEFAULT NULL,
  `endtime` varchar(20) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  `content` text,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID` (`ID`),
  KEY `ID_2` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=gb2312;

-- 正在导出表  db_oa.meeting 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `meeting` DISABLE KEYS */;
REPLACE INTO `meeting` (`ID`, `sender`, `starttime`, `endtime`, `address`, `title`, `content`) VALUES
	(1, 'admin', '2009-10-21', '2009-10-22', '公司G型办公室', '加强员工办公效率！', '加强员工办公效率！加强员工办公效率！加强员工办公效率！加强员工办公效率！');
/*!40000 ALTER TABLE `meeting` ENABLE KEYS */;


-- 导出  表 db_oa.notice 结构
CREATE TABLE IF NOT EXISTS `notice` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `sender` varchar(50) NOT NULL DEFAULT '',
  `title` varchar(100) DEFAULT NULL,
  `content` text,
  `sendtime` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID` (`ID`),
  KEY `ID_2` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=gb2312;

-- 正在导出表  db_oa.notice 的数据：~4 rows (大约)
/*!40000 ALTER TABLE `notice` DISABLE KEYS */;
REPLACE INTO `notice` (`ID`, `sender`, `title`, `content`, `sendtime`) VALUES
	(1, 'admin', '爱护公物人人有责！', '爱护公物人人有责！', '2009-12-20 20:06:39'),
	(2, 'admin', '局域网内有人中毒，请注册杀毒！', '局域网内有人中毒，请注册杀毒！', '2009-12-20 20:06:56'),
	(3, 'admin', '明后天放假通知！', '明后天放假通知！', '2009-12-20 20:07:22'),
	(4, 'sanqing', 'sanqing发公告', 'sanqing发公告sanqing发公告sanqing发公告', '2010-02-01 16:40:35');
/*!40000 ALTER TABLE `notice` ENABLE KEYS */;


-- 导出  表 db_oa.schedule 结构
CREATE TABLE IF NOT EXISTS `schedule` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL DEFAULT '',
  `year` int(4) DEFAULT NULL,
  `month` int(2) DEFAULT NULL,
  `day` int(2) DEFAULT NULL,
  `plan` text,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID` (`ID`),
  KEY `ID_2` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=gb2312;

-- 正在导出表  db_oa.schedule 的数据：~6 rows (大约)
/*!40000 ALTER TABLE `schedule` DISABLE KEYS */;
REPLACE INTO `schedule` (`ID`, `username`, `year`, `month`, `day`, `plan`) VALUES
	(1, 'admin', 2009, 10, 3, '出差！'),
	(3, 'admin', 2009, 10, 5, '项目需求分析！'),
	(4, 'admin', 2009, 10, 6, '和项目经理谈项目！'),
	(5, 'admin', 2009, 10, 7, '和客户谈项目需求！'),
	(6, 'admin', 2009, 10, 8, '项目功能分析！'),
	(7, 'admin', 2010, 1, 31, '买火车票！！！！');
/*!40000 ALTER TABLE `schedule` ENABLE KEYS */;


-- 导出  表 db_oa.sms 结构
CREATE TABLE IF NOT EXISTS `sms` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL DEFAULT '',
  `sender` varchar(50) NOT NULL DEFAULT '',
  `message` text,
  `sendtime` varchar(20) DEFAULT NULL,
  `isRead` varchar(1) DEFAULT '0',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID` (`ID`),
  KEY `ID_2` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=gb2312;

-- 正在导出表  db_oa.sms 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `sms` DISABLE KEYS */;
REPLACE INTO `sms` (`ID`, `username`, `sender`, `message`, `sendtime`, `isRead`) VALUES
	(6, 'admin', 'sanqing', '你收到了吗？？', '2010-02-01 16:41:18', '1'),
	(7, 'sanqing', 'admin', '收到了，你买火车票了吗？？', '2010-02-01 16:41:51', '1');
/*!40000 ALTER TABLE `sms` ENABLE KEYS */;


-- 导出  表 db_oa.user 结构
CREATE TABLE IF NOT EXISTS `user` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID` (`ID`),
  KEY `ID_2` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=gb2312;

-- 正在导出表  db_oa.user 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
REPLACE INTO `user` (`ID`, `username`, `password`, `email`) VALUES
	(1, 'admin', 'admin', 'abc@163.com'),
	(2, 'sanqing', 'sanqing', 'abc@163.com'),
	(3, 'zhangsan', '123456', '11111111@qq.com');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;


-- 导出  表 db_oa.worklog 结构
CREATE TABLE IF NOT EXISTS `worklog` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL DEFAULT '',
  `year` int(4) DEFAULT NULL,
  `month` int(2) DEFAULT NULL,
  `day` int(2) DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  `description` text,
  `logtime` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID` (`ID`),
  KEY `ID_2` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=gb2312;

-- 正在导出表  db_oa.worklog 的数据：~5 rows (大约)
/*!40000 ALTER TABLE `worklog` DISABLE KEYS */;
REPLACE INTO `worklog` (`ID`, `username`, `year`, `month`, `day`, `title`, `description`, `logtime`) VALUES
	(1, 'admin', 2009, 11, 1, '很高兴客户已经满意了！', '很高兴客户已经满意了！', '2009-12-20 19:54:37'),
	(2, 'admin', 2009, 11, 2, '今天好冷啊！', '今天好冷啊！', '2009-12-20 19:55:05'),
	(3, 'admin', 2009, 11, 3, '客户要求修改功能！', '客户要求修改功能！', '2009-12-20 19:55:31'),
	(4, 'admin', 2009, 11, 4, '客户是上帝，要求一定要达到！', '客户是上帝，要求一定要达到！', '2009-12-20 19:55:47'),
	(6, 'admin', 2010, 2, 2, '测试工作日志', '测试工作日志！！！', '2010-02-01 16:39:18');
/*!40000 ALTER TABLE `worklog` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

/*
SQLyog Ultimate v12.4.0 (64 bit)
MySQL - 5.7.26 : Database - employeemanager
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`employeemanager` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `employeemanager`;

/*Table structure for table `department` */

DROP TABLE IF EXISTS `department`;

CREATE TABLE `department` (
  `deptno` int(11) NOT NULL,
  `dname` varchar(50) DEFAULT NULL,
  `loc` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`deptno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `department` */

insert  into `department`(`deptno`,`dname`,`loc`) values 
(10,'教研部','北京'),
(20,'学工部','上海'),
(30,'销售部','广州'),
(40,'财务部','武汉');

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `empno` int(11) NOT NULL,
  `ename` varchar(50) DEFAULT NULL,
  `job` varchar(50) DEFAULT NULL,
  `hiredate` date DEFAULT NULL,
  `sal` decimal(7,2) DEFAULT NULL,
  `comm` decimal(7,2) DEFAULT NULL,
  `deptno` int(11) DEFAULT NULL,
  PRIMARY KEY (`empno`),
  KEY `fk_dept` (`deptno`),
  CONSTRAINT `fk_dept` FOREIGN KEY (`deptno`) REFERENCES `department` (`deptno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `employee` */

insert  into `employee`(`empno`,`ename`,`job`,`hiredate`,`sal`,`comm`,`deptno`) values 
(1002,'戴绮丝','销售员','2014-02-20',16000.00,3000.00,30),
(1003,'殷天正','销售员','2013-02-22',12500.00,5000.00,30),
(1004,'刘备','经理','2010-04-02',29750.00,NULL,20),
(1005,'谢逊','销售员','2011-09-28',12500.00,14000.00,30),
(1006,'关羽','经理','2012-05-01',28500.00,NULL,30),
(1007,'张飞','经理','2015-09-01',24500.00,NULL,10),
(1008,'诸葛亮','分析师','2009-04-19',30000.00,NULL,20),
(1009,'曾阿牛','董事长','2008-11-17',50000.00,NULL,10),
(1013,'庞统','分析师','2017-12-03',30000.00,NULL,20),
(1014,'黄盖','文员','2017-01-23',13000.00,NULL,10);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

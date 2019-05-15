/*
SQLyog Ultimate - MySQL GUI v8.2 
MySQL - 5.5.40 : Database - mybatisdemo
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mybatisdemo` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `mybatisdemo`;

/*Table structure for table `systemuser` */

DROP TABLE IF EXISTS `systemuser`;

CREATE TABLE `systemuser` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `password` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `userType` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `systemuser` */

insert  into `systemuser`(`id`,`username`,`password`,`userType`) values (1,'??','123456',13),(2,'??','123456',10),(3,'王军','123456',15),(4,'李四','123456',20);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

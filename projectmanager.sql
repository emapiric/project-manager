/*
SQLyog Ultimate v13.0.1 (64 bit)
MySQL - 5.7.30-log : Database - projectmanager
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`projectmanager` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `projectmanager`;

/*Table structure for table `project` */

DROP TABLE IF EXISTS `project`;

CREATE TABLE `project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `userId` (`userId`),
  CONSTRAINT `project_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

/*Data for the table `project` */

insert  into `project`(`id`,`name`,`description`,`userId`) values 
(6,'Project1','This is project1.',3),
(7,'Project2','This is project2. Update successfull.',3),
(9,'ProjectByUser1','This is project created by user.',2),
(10,'Project2ByUser','This is project 2 by user',2);

/*Table structure for table `project_task` */

DROP TABLE IF EXISTS `project_task`;

CREATE TABLE `project_task` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `projectId` int(11) NOT NULL,
  `createdOn` date DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `taskId` int(11) DEFAULT NULL,
  `assigneeProjectId` int(11) DEFAULT NULL,
  `assigneeId` int(11) DEFAULT NULL,
  `statusId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`,`projectId`),
  KEY `projectId` (`projectId`),
  KEY `assigneeProjectId` (`assigneeProjectId`,`assigneeId`),
  KEY `taskId` (`taskId`),
  KEY `statusId` (`statusId`),
  CONSTRAINT `project_task_ibfk_1` FOREIGN KEY (`projectId`) REFERENCES `project` (`id`),
  CONSTRAINT `project_task_ibfk_2` FOREIGN KEY (`assigneeProjectId`, `assigneeId`) REFERENCES `user_project` (`projectId`, `userId`),
  CONSTRAINT `project_task_ibfk_3` FOREIGN KEY (`taskId`) REFERENCES `task` (`id`),
  CONSTRAINT `project_task_ibfk_4` FOREIGN KEY (`statusId`) REFERENCES `status` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `project_task` */

/*Table structure for table `status` */

DROP TABLE IF EXISTS `status`;

CREATE TABLE `status` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `status` */

/*Table structure for table `task` */

DROP TABLE IF EXISTS `task`;

CREATE TABLE `task` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `authorId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `authorId` (`authorId`),
  CONSTRAINT `task_ibfk_1` FOREIGN KEY (`authorId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `task` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `firstname` varchar(20) DEFAULT NULL,
  `lastname` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`,`email`,`firstname`,`lastname`) values 
(1,'a','a','aaa@aaaa','aaa','aaa'),
(2,'user','user','user@user.com','User','User'),
(3,'admin','admin','admin@admin.com','Admin','Admin');

/*Table structure for table `user_project` */

DROP TABLE IF EXISTS `user_project`;

CREATE TABLE `user_project` (
  `projectId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `insertDate` date DEFAULT NULL,
  PRIMARY KEY (`projectId`,`userId`),
  KEY `userId` (`userId`),
  CONSTRAINT `user_project_ibfk_1` FOREIGN KEY (`projectId`) REFERENCES `project` (`id`),
  CONSTRAINT `user_project_ibfk_2` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `user_project` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

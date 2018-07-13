-- MySQL dump 10.13  Distrib 5.7.21, for Win64 (x86_64)
--
-- Host: localhost    Database: javaweb
-- ------------------------------------------------------
-- Server version	5.7.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tbl_admin`
--

DROP TABLE IF EXISTS `tbl_admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_admin` (
  `adminID` int(11) NOT NULL AUTO_INCREMENT,
  `adminName` varchar(20) NOT NULL,
  `aPassword` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`adminID`)
) ENGINE=InnoDB AUTO_INCREMENT=452 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_admin`
--

LOCK TABLES `tbl_admin` WRITE;
/*!40000 ALTER TABLE `tbl_admin` DISABLE KEYS */;
INSERT INTO `tbl_admin` VALUES (450,'麻瓜1','123456'),(451,'麻瓜2','123456');
/*!40000 ALTER TABLE `tbl_admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_class`
--

DROP TABLE IF EXISTS `tbl_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_class` (
  `classID` int(11) NOT NULL,
  `className` varchar(20) DEFAULT NULL,
  `majorID` int(11) NOT NULL COMMENT '所属学院',
  `teacherID` int(11) NOT NULL COMMENT '班主任',
  PRIMARY KEY (`classID`),
  KEY `majorID` (`majorID`),
  KEY `teacherID` (`teacherID`),
  CONSTRAINT `tbl_class_ibfk_1` FOREIGN KEY (`majorID`) REFERENCES `tbl_major` (`majorID`),
  CONSTRAINT `tbl_class_ibfk_2` FOREIGN KEY (`teacherID`) REFERENCES `tbl_teacher` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_class`
--

LOCK TABLES `tbl_class` WRITE;
/*!40000 ALTER TABLE `tbl_class` DISABLE KEYS */;
INSERT INTO `tbl_class` VALUES (1,'17机电一体化',1,1000),(2,'17工程造价',2,1001),(3,'17旅游管理',3,1002),(4,'17电子商务',4,1003),(5,'17会计专业',5,1004),(6,'17商务英语',6,1005),(7,'17软件技术',7,1006),(8,'17室内艺术设计',8,1007),(9,'17传播与策划',9,1008);
/*!40000 ALTER TABLE `tbl_class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_college`
--

DROP TABLE IF EXISTS `tbl_college`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_college` (
  `collegeID` int(11) NOT NULL,
  `collegeName` varchar(20) NOT NULL COMMENT '学院名',
  PRIMARY KEY (`collegeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_college`
--

LOCK TABLES `tbl_college` WRITE;
/*!40000 ALTER TABLE `tbl_college` DISABLE KEYS */;
INSERT INTO `tbl_college` VALUES (1,'机电工程学院'),(2,'建筑工程学院'),(3,'旅游学院'),(4,'商学院'),(5,'财经学院'),(6,'国际学院'),(7,'信息工程学院'),(8,'艺术工程学院'),(9,'公共管理学院');
/*!40000 ALTER TABLE `tbl_college` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_course`
--

DROP TABLE IF EXISTS `tbl_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_course` (
  `courseID` int(11) NOT NULL AUTO_INCREMENT,
  `courseName` varchar(20) NOT NULL COMMENT '课程名称',
  `teacherID` int(11) NOT NULL,
  `courseTime` varchar(20) DEFAULT NULL COMMENT '上课时间',
  `courseBegin` date DEFAULT NULL COMMENT '开课时间',
  `courseRoom` varchar(20) DEFAULT NULL COMMENT '上课地点',
  `courseWeek` int(20) DEFAULT NULL COMMENT '学时',
  `courseType` varchar(1) DEFAULT NULL COMMENT '课程类型',
  `collegeID` int(11) NOT NULL COMMENT '所属院系',
  `point` int(11) NOT NULL COMMENT '学分',
  PRIMARY KEY (`courseID`),
  KEY `collegeID` (`collegeID`),
  KEY `teacherID` (`teacherID`),
  CONSTRAINT `tbl_course_ibfk_1` FOREIGN KEY (`collegeID`) REFERENCES `tbl_college` (`collegeID`),
  CONSTRAINT `tbl_course_ibfk_2` FOREIGN KEY (`teacherID`) REFERENCES `tbl_teacher` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_course`
--

LOCK TABLES `tbl_course` WRITE;
/*!40000 ALTER TABLE `tbl_course` DISABLE KEYS */;
INSERT INTO `tbl_course` VALUES (1,'现代电气控制技术',1000,'周一8:00~12:00','2018-03-01','1号实训楼',18,'1',1,8),(2,'建筑构造',1001,'周二8:00~12:00','2018-03-02','2号实训楼',18,'0',1,6),(3,'导游基础知识',1002,'周三8:00~12:00','2018-03-03','3号教学楼',18,'1',3,8),(4,'网店交易管理',1003,'周四8:00~12:00','2018-03-04','4号教学楼',18,'0',4,6),(5,'实用会计基础',1004,'周五8:00~12:00','2018-03-05','5号教学楼',18,'1',5,8),(6,'商务英语翻译',1005,'周五14:40~17:00','2018-03-06','6号教学楼',18,'0',6,6),(7,'Java核心编程技术',1006,'周日8:00~12:00','2018-03-07','7号实训楼',18,'1',7,8),(8,'居住空间设计',1007,'周一9:40~12:00','2018-03-08','8号教学楼',18,'0',8,6),(9,'广告文案写作',1008,'周一8:00~12:00','2018-03-09','9号教学楼',18,'1',9,8),(10,'居住空间设计',1007,'周一9:40~12:00','2018-03-08','8号教学楼',18,'0',8,6),(11,'广告文案写作',1008,'周一8:00~12:00','2018-03-09','9号教学楼',18,'1',9,8),(12,'Javaweb',1006,'周日14:40~17:00','2018-03-07','7号实训楼',18,'1',7,8),(13,'mysql',1007,'周一19:00~21:20','2018-03-08','8号教学楼',18,'0',7,6),(14,'html5+css3',1008,'周二19:00~21:20','2018-03-09','9号教学楼',18,'1',7,8),(15,'安卓应用开发',1007,'周三19:00~21:20','2018-03-08','8号教学楼',18,'0',7,6),(16,'Python应用开发',1008,'周四19:00~21:20','2018-03-09','9号教学楼',18,'1',7,8),(17,'手冲练习',1005,'周日19:00~21:00','2018-01-01','八训宿舍',18,'0',2,6);
/*!40000 ALTER TABLE `tbl_course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_major`
--

DROP TABLE IF EXISTS `tbl_major`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_major` (
  `majorID` int(11) NOT NULL,
  `majorName` varchar(20) DEFAULT NULL,
  `collegeID` int(11) NOT NULL COMMENT '所属学院',
  PRIMARY KEY (`majorID`),
  KEY `collegeID` (`collegeID`),
  CONSTRAINT `tbl_major_ibfk_1` FOREIGN KEY (`collegeID`) REFERENCES `tbl_college` (`collegeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_major`
--

LOCK TABLES `tbl_major` WRITE;
/*!40000 ALTER TABLE `tbl_major` DISABLE KEYS */;
INSERT INTO `tbl_major` VALUES (1,'机电一体化技术专业',1),(2,'工程造价',2),(3,'旅游管理',3),(4,'电子商务',4),(5,'会计专业',5),(6,'商务英语',6),(7,'软件技术',7),(8,'室内艺术设计专业',8),(9,'传播与策划',9);
/*!40000 ALTER TABLE `tbl_major` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_selectedcourse`
--

DROP TABLE IF EXISTS `tbl_selectedcourse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_selectedcourse` (
  `courseID` int(11) NOT NULL,
  `studentID` int(11) NOT NULL,
  `mark` int(11) DEFAULT NULL COMMENT '成绩',
  KEY `courseID` (`courseID`),
  KEY `studentID` (`studentID`),
  CONSTRAINT `tbl_selectedcourse_ibfk_1` FOREIGN KEY (`courseID`) REFERENCES `tbl_course` (`courseID`),
  CONSTRAINT `tbl_selectedcourse_ibfk_2` FOREIGN KEY (`studentID`) REFERENCES `tbl_student` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_selectedcourse`
--

LOCK TABLES `tbl_selectedcourse` WRITE;
/*!40000 ALTER TABLE `tbl_selectedcourse` DISABLE KEYS */;
INSERT INTO `tbl_selectedcourse` VALUES (1,1702040000,NULL),(2,1702040000,NULL),(3,1702040000,NULL),(4,1702040000,NULL),(5,1702040000,NULL),(6,1702040000,NULL),(7,1702040000,NULL),(1,1702040001,NULL),(2,1702040001,NULL),(3,1702040001,NULL),(4,1702040001,NULL),(5,1702040001,98),(2,1702040001,NULL),(3,1702040002,NULL),(4,1702040003,NULL),(5,1702040004,NULL),(6,1702040005,NULL),(7,1702040006,NULL),(8,1702040007,NULL),(9,1702040008,NULL),(10,1702040009,NULL),(11,1702040010,NULL),(12,1702040011,NULL),(13,1702040012,NULL),(14,1702040013,NULL);
/*!40000 ALTER TABLE `tbl_selectedcourse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_student`
--

DROP TABLE IF EXISTS `tbl_student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_student` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `studentID` int(11) NOT NULL,
  `studentName` varchar(20) NOT NULL,
  `sex` varchar(1) DEFAULT NULL,
  `birthYear` date DEFAULT NULL COMMENT '出生日期',
  `grade` date DEFAULT NULL COMMENT '入学时间',
  `classID` int(11) NOT NULL COMMENT '班级id',
  `sPassword` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `classID` (`classID`),
  CONSTRAINT `tbl_student_ibfk_1` FOREIGN KEY (`classID`) REFERENCES `tbl_class` (`classID`)
) ENGINE=InnoDB AUTO_INCREMENT=1702040014 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_student`
--

LOCK TABLES `tbl_student` WRITE;
/*!40000 ALTER TABLE `tbl_student` DISABLE KEYS */;
INSERT INTO `tbl_student` VALUES (1702040000,1702040001,'张三','1','1999-01-02','2017-09-15',1,'123456'),(1702040001,1702040002,'李四','1','1999-01-01','2017-09-15',2,'123456'),(1702040002,1702040003,'王五','1','1999-01-03','2017-09-15',3,'123456'),(1702040003,1702040004,'赵四','1','1999-01-04','2017-09-15',4,'123456'),(1702040004,1702040005,'李明','0','1999-01-05','2017-09-15',5,'123456'),(1702040005,1702040006,'李华','0','1999-01-06','2017-09-15',6,'123456'),(1702040006,1702040007,'张学友','1','1999-01-07','2017-09-15',7,'123456'),(1702040007,1702040008,'刘德华','1','1999-01-08','2017-09-15',8,'123456'),(1702040008,1702040009,'黎明','1','1999-01-09','2017-09-15',9,'123456'),(1702040009,1702040010,'明','0','1999-01-05','2017-09-15',5,'123456'),(1702040010,1702040011,'华','0','1999-01-06','2017-09-15',6,'123456'),(1702040011,1702040012,'学友','1','1999-01-07','2018-09-15',7,'123456'),(1702040012,1702040013,'德华','1','1999-01-08','2010-04-15',8,'123456'),(1702040013,1702040014,'fvck','1','1999-01-09','2010-09-15',9,'123456');
/*!40000 ALTER TABLE `tbl_student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_teacher`
--

DROP TABLE IF EXISTS `tbl_teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_teacher` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `teacherID` int(11) NOT NULL,
  `teacherName` varchar(20) NOT NULL,
  `sex` varchar(1) DEFAULT NULL,
  `birthYear` date NOT NULL,
  `degree` varchar(20) DEFAULT NULL COMMENT '学历',
  `ptitle` varchar(25) DEFAULT NULL COMMENT '职称',
  `grade` date DEFAULT NULL COMMENT '入职时间',
  `collegeID` int(11) NOT NULL COMMENT '所属学院',
  `tPassword` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `collegeID` (`collegeID`),
  CONSTRAINT `tbl_teacher_ibfk_1` FOREIGN KEY (`collegeID`) REFERENCES `tbl_college` (`collegeID`)
) ENGINE=InnoDB AUTO_INCREMENT=1014 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_teacher`
--

LOCK TABLES `tbl_teacher` WRITE;
/*!40000 ALTER TABLE `tbl_teacher` DISABLE KEYS */;
INSERT INTO `tbl_teacher` VALUES (1000,12001,'杨志标','1','1980-01-02','研究生','教授','2017-01-02',1,'123456'),(1001,12002,'宇哥','1','1980-01-01','本科','教授','2017-01-01',2,'123456'),(1002,12003,'郑超凡','1','1980-01-03','本科','教授','2017-01-03',3,'123456'),(1003,12004,'雷应忠','1','1980-01-04','本科','教授','2017-01-04',4,'123456'),(1004,12005,'韦寿海','1','1980-01-05','本科','教授','2017-01-05',5,'123456'),(1005,12006,'李保龙','0','1980-01-06','初中','助教','2017-01-06',6,'123456'),(1006,12007,'杨德仁','0','1980-01-07','本科','讲师','2017-01-07',7,'123456'),(1007,12008,'李茗','0','1980-01-08','本科','副教授','2017-01-08',8,'123456'),(1008,12009,'李丽丽','0','1980-01-09','本科','教授','2017-01-09',9,'123456'),(1009,12010,'a123','1','1980-01-05','本科','教授','2017-01-05',5,'123456'),(1010,12011,'a456','0','1980-01-06','初中','助教','2017-01-06',6,'123456'),(1011,12012,'a789','0','1980-01-07','专科','讲师','2017-01-07',7,'123456'),(1012,12013,'b123','0','1980-01-08','专科','副教授','2017-01-08',8,'123456'),(1013,12014,'b456','0','1980-01-09','本科','教授','2017-01-09',9,'123456');
/*!40000 ALTER TABLE `tbl_teacher` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-12 22:05:07

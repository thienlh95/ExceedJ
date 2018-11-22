-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: library
-- ------------------------------------------------------
-- Server version	5.7.22-log

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
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `books` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `amount` varchar(255) DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  `genre` varchar(255) DEFAULT NULL,
  `isbn` varchar(255) DEFAULT NULL,
  `price` varchar(255) DEFAULT NULL,
  `publishing_year` varchar(255) DEFAULT NULL,
  `short_desc` varchar(255) DEFAULT NULL,
  `title_books` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES (1,'2','John CMaxwel','Education','0 512 52068 9','10','2018','Useful for brand','Math'),(2,'4','Marijn Haverbeke','A Modern Introduction to Programming','978-1-891830-75-4','24','2014','JavaScript lies at the heart of almost every modern that you can use to build full-scale applications.','Eloquent JavaScript Second Edition'),(3,'4','Addy Osmani','A JavaScript and jQuery Developer s Guide','978-1-891830-75-5','23','2012','With Learning JavaScript Design Patterns, you\'ll learn how to write beautiful','Learning JavaScript Design Patterns'),(4,'6','Axel Rauschmayer','An IDepth Guide for Programmers','978-1-891830-75-7','50','2014','ECMAScript 6 represents the biggest update to the core of JavaScript','Speaking JavaScript'),(5,'1','Eric Elliott','Robust Web Architecture with Node, HTML5, and Modern JS Libraries','978-1-891830-75-9','100','2014','ECMAScript 6 represents the biggest update to the core of JavaScript','Programming JavaScript Applications'),(6,'3','Nicholas C Zakas','The Definitive Guide for JavaScript Developers','978-1-891830-75-3','57','2016','ECMAScript 6 represents the biggest update to the core of JavaScript','Understanding ECMAScript 6'),(7,'3','Nicholas C Zakas','The Definitive Guide for JavaScript Developers','978-1-891830-75-3','57','2016','ECMAScript 6 represents the biggest update to the core of JavaScript','Understanding ECMAScript 6'),(8,'7','Kyle Simpson','ES6 & Beyond','978-1-891830-75-2','58','2012','No matter how much experience you have with JavaScript, odds are you don’t fully understand the language.','You Dont Know JS'),(9,'4','Richard E Silverman','A Working Introduction','978-1-60309-425-2','20','2013','This pocket guide is the perfect on-the-job companion to Git','Git Pocket Guide'),(10,'5','Glenn Block, et al','Harnessing the Power of the Web','978-1-60309-425-5','60','2014','Design and build Web APIs for a broad range ','Designing Evolvable Web APIs with ASPNET'),(11,'2','Glenn Block, et al.','Harnessing the Power of the Web','978-1-60309-425-3','100','2014','hands-on guide takes you through the theory and tools you need to build evolvable HTTP services with Microsoft’s ASP.NET Web API framework. In the process, you’ll learn how design and implement a real-world Web API.','Designing Evolvable Web APIs with Framwork'),(12,'4','Addy Osmani','A JavaScript and jQuery Developer\'s Guide','978-1-891830-75-5','23','2012','With Learning JavaScript Design Patterns, you\'ll learn how to write beautiful','Learning JavaScript Design Patterns');
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ticket` (
  `id_ticket` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_borrow` varchar(255) DEFAULT NULL,
  `date_return` varchar(255) DEFAULT NULL,
  `isbn` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_ticket`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
INSERT INTO `ticket` VALUES (1,'13/13/2018','10/10/2018','99921-58-10-7',NULL),(2,'13/13/2018','10/10/2018','99921-58-10-7',NULL),(3,'12/12/2018','10/10/2018','ISBN 0 93028 923 4',NULL),(4,'13/13/2018','10/10/2018','ISBN 0 93028 923 4',NULL),(5,'13/13/2018','10/10/2018','ISBN 0 93028 923 4',NULL),(6,'14/13/2018','10/10/2018','ISBN 0 93028 923','admin1234'),(7,'13/13/2018','10/10/2018','ISBN 0 93028 923 4',NULL),(8,'13/13/2018','10/10/2018','ISBN 0 93028 923 4','thien'),(9,'13/13/2018','10/10/2018','ISBN 0 93028 923 4','admin1234'),(10,'13/13/2018','10/10/2018','ISBN 0 93028 923','admin1234'),(11,'14/13/2018','10/10/2018','ISBN 0 93028 923','admin1234');
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_ticket` int(11) DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `is_admin` bit(1) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,0,'','','c93ccd78b2076528346216b3b2f701e6','phamphuc');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-22 18:13:28

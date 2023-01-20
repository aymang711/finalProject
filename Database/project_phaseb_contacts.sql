-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: project_phaseb
-- ------------------------------------------------------
-- Server version	8.0.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `contacts`
--

DROP TABLE IF EXISTS `contacts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contacts` (
  `idcontacts` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `number` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idcontacts`)
) ENGINE=InnoDB AUTO_INCREMENT=155 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contacts`
--

LOCK TABLES `contacts` WRITE;
/*!40000 ALTER TABLE `contacts` DISABLE KEYS */;
INSERT INTO `contacts` VALUES (1,'John Smith','555-555-1212'),(2,'Jane Doe','555-555-1213'),(3,'Bob Johnson','555-555-1214'),(4,'Emily Williams','555-555-1215'),(5,'William Thompson','555-555-1216'),(6,'Ashley Davis','555-555-1217'),(7,'Michael Brown','555-555-1218'),(8,'Samantha Jones','555-555-1219'),(9,'Christopher Taylor','555-555-1220'),(10,'Emily Rodriguez','555-555-1221'),(11,'Jacob Anderson','555-555-1222'),(12,'ay','0524848557'),(13,'James Smith','555-555-1224'),(14,'Olivia Williams','555-555-1225'),(15,'David Thompson','555-555-1226'),(16,'Jessica Davis','555-555-1227'),(17,'Robert Brown','555-555-1228'),(18,'Ashley Jones','555-555-1229'),(19,'Michael Taylor','555-555-1230'),(20,'Samantha Rodriguez','555-555-1231'),(145,'ayman','05474748832'),(146,'ayman','05474748832'),(147,'ayman','05474748832'),(148,'ayman','05474748832'),(149,'asdas','3213123'),(150,'asdas','3213123'),(151,'ayman','05474748832'),(152,'gdfgdf','563434534'),(153,'ranaa','76784567'),(154,'asdasdasd','234233333');
/*!40000 ALTER TABLE `contacts` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-20 20:31:04

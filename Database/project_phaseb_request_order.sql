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
-- Table structure for table `request_order`
--

DROP TABLE IF EXISTS `request_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `request_order` (
  `request_id` varchar(45) NOT NULL,
  `clientid` varchar(45) DEFAULT NULL,
  `catalogNum` varchar(45) NOT NULL,
  `qunatity` varchar(45) DEFAULT NULL,
  `description` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`request_id`,`catalogNum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `request_order`
--

LOCK TABLES `request_order` WRITE;
/*!40000 ALTER TABLE `request_order` DISABLE KEYS */;
INSERT INTO `request_order` VALUES ('MA2023-01-20','MA','21T02GP2BP000M0','1','-21T-G-P-BP-2W-24AC-NC-M; TRIO SOLENOID CONTROLLED VALVE BSP'),('MA2023-01-20','MA','22000-001300 ','10','ARROW ANG 2.30L/H 0.61GPH BLACK   '),('MA2023-01-20','MA','34020-001300','92','AQUANET PLUS 2 AC BSP GLOBE P.R.V.'),('MA2023-01-20','MA','40210-00003','100','Pipe 16mm (white), Netafim dripper 2l/h, perforation every 0.25 m, Tube 0.6m. line of 40 meters'),('MA2023-01-20','MA','63100-053500','2000','COOLPRO C 4X5.5 30CM W/STB PFC AD40');
/*!40000 ALTER TABLE `request_order` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-20 20:31:05

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
-- Table structure for table `offers`
--

DROP TABLE IF EXISTS `offers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `offers` (
  `requestid` varchar(45) NOT NULL,
  `catalogNum` varchar(45) NOT NULL,
  `clientid` varchar(45) DEFAULT NULL,
  `supplier` varchar(45) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `unit` varchar(45) DEFAULT NULL,
  `qunaitty` varchar(45) DEFAULT NULL,
  `unitprice` varchar(45) DEFAULT NULL,
  `PO` varchar(45) DEFAULT NULL,
  `factor` varchar(45) DEFAULT NULL,
  `unitcost` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`requestid`,`catalogNum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `offers`
--

LOCK TABLES `offers` WRITE;
/*!40000 ALTER TABLE `offers` DISABLE KEYS */;
INSERT INTO `offers` VALUES ('asem2023-01-19','123',NULL,'NETFAM','asdasda','UN','20','30.0','600.0','0.5','20'),('asem2023-01-19','32423dfg',NULL,'NETFAM','sdfdsgthcv','UN','100','22.0','2200.0','0.1','20'),('asem2023-01-19','34534',NULL,'NETFAM','sdfsdfsd','UN','15','30.0','450.0','1','15'),('aym2023-01-13','1233',NULL,'NAT','dfds','UN','10','10.0','100.0','0','10'),('aym2023-01-13','12344',NULL,'nat','fgdf','sd','12','189.0','2268.0','0','189'),('aym2023-01-13','124',NULL,'nene','hf','UN','15','12.0','180.0','0','12'),('aym2023-01-14','asdas',NULL,'aymn','sdfsdfds','UN','2','48.0','96.0','3','12'),('aym2023-01-14','fgdfkb',NULL,'aymn','dfgdf','un','5','21.0','105.0','2','7'),('aym2023-01-17','76540-001000',NULL,'NETFAM','SEAL KLANGRIT F/FLANGE ADAP.90MM','UN','100','15.0','1500.0','0.5','10'),('aym2023-01-17','77100-004310',NULL,'NETFAM','ZIPPER BLACK 550X8 BAG 100 UN.','UN','100','39.0','3900.0','0.3','30'),('ayman2023-01-13','asda',NULL,'nat','dasfdas','UN','5','125.0','625.0','1.5','50'),('MA2023-01-20','21T02GP2BP000M0',NULL,'NETFAM','-21T-G-P-BP-2W-24AC-NC-M; TRIO SOLENOID CONTROLLED VALVE BSP','UN','1','24.0','24.0','0.2','20'),('MA2023-01-20','22000-001300 ',NULL,'NETFAM','ARROW ANG 2.30L/H 0.61GPH BLACK   ','UN','10','24.0','240.0','0.2','20'),('MA2023-01-20','34020-001300',NULL,'NETFAM','AQUANET PLUS 2 AC BSP GLOBE P.R.V.','UN','92','55.0','5060.0','0.1','50'),('MA2023-01-20','40210-00003',NULL,'NETFAM','Pipe 16mm (white), Netafim dripper 2l/h, perforation every 0.25 m, Tube 0.6m. line of 40 meters','UN','100','35.1','3510.0','0.17','30'),('MA2023-01-20','63100-053500',NULL,'NETFAM','COOLPRO C 4X5.5 30CM W/STB PFC AD40','UN','2000','1.2','2400.0','0.2','1'),('mahmod2023-01-15','123',NULL,'NETFAM','asdfasdas','UN','10','30.0','300.0','0.5','20'),('mahmod2023-01-15','1234',NULL,'NETFAM','sdfsd','UN','20','270.0','5400.0','2','90'),('rana2023-01-19','213',NULL,'asdas','dfsd','UN','10','38.4','384.0','0.2','32'),('ranaa2023-01-17','71910',NULL,'NETFAM','ASFFDGDF','UN','20','75.0','1500.0','0.5','50'),('ranaa2023-01-17','71910-003337',NULL,'NETFAM','MT D 240504 S BST BFC DC SOLDC WG 8 SC1','UN','100','24.0','2400.0','0.2','20'),('ranaa2023-01-17','newCatalogNum',NULL,'GALCON','Test','UN','10','3000.0','30000.0','2','1000'),('sameer22023-01-19','2222',NULL,'NETFAM','sdfsd','UN','190','2.4','456.0','0.2','2'),('zaav2023-01-13','40210-00006',NULL,'NETFAM','PVC FLANGE ADAPTOR 110MM GLUE','UN','5','7.5','37.5','0.5','5'),('zaav2023-01-13','75090-011015',NULL,'NETFAM','SEAL KLANGRIT F/FLANGE ADAP.110MM','UN','7','300.0','2100.0','2','100'),('zaav2023-01-13','77400-002000',NULL,'NETFAM','PVC LOOSE FLANGE 110MM GLUE','UN','10','800.0','8000.0','3','200'),('zozo2023-01-19','12',NULL,'netfam','tdhgfhgdf','UN','20','22.0','440.0','0.1','20'),('zozo2023-01-19','123',NULL,'mroco','sdffgsd','UN','11','18.2','200.2','0.3','14');
/*!40000 ALTER TABLE `offers` ENABLE KEYS */;
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

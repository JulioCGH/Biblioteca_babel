CREATE DATABASE  IF NOT EXISTS `babel_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `babel_db`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: babel_db
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `estante`
--

DROP TABLE IF EXISTS `estante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estante` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `numero_estante` int DEFAULT NULL,
  `id_librero` int unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_librero` (`id_librero`),
  CONSTRAINT `fk_librero` FOREIGN KEY (`id_librero`) REFERENCES `librero` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estante`
--

LOCK TABLES `estante` WRITE;
/*!40000 ALTER TABLE `estante` DISABLE KEYS */;
INSERT INTO `estante` VALUES (1,1,1),(2,2,1),(3,1,2),(4,2,2),(5,1,3),(6,2,3),(7,1,4),(8,2,4),(9,1,5),(10,2,5),(11,1,6),(12,2,6),(13,1,7),(14,2,7),(15,1,8),(16,2,8),(17,1,9),(18,2,9),(19,1,10),(20,2,10),(21,1,11),(22,2,11),(23,1,12),(24,2,12);
/*!40000 ALTER TABLE `estante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `librero`
--

DROP TABLE IF EXISTS `librero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `librero` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `nombre_librero` varchar(10) DEFAULT NULL,
  `id_sala` int unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_sala` (`id_sala`),
  CONSTRAINT `fk_sala` FOREIGN KEY (`id_sala`) REFERENCES `sala` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `librero`
--

LOCK TABLES `librero` WRITE;
/*!40000 ALTER TABLE `librero` DISABLE KEYS */;
INSERT INTO `librero` VALUES (1,'A',1),(2,'B',1),(3,'C',2),(4,'D',2),(5,'E',3),(6,'F',3),(7,'G',4),(8,'H',4),(9,'I',5),(10,'J',5),(11,'K',6),(12,'L',6);
/*!40000 ALTER TABLE `librero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `libro`
--

DROP TABLE IF EXISTS `libro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `libro` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `titulo` varchar(400) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `libro`
--

LOCK TABLES `libro` WRITE;
/*!40000 ALTER TABLE `libro` DISABLE KEYS */;
INSERT INTO `libro` VALUES (1,'1984'),(2,'To Kill a Mockingbird'),(3,'The Great Gatsby'),(4,'One Hundred Years of Solitude'),(5,'Brave New World'),(6,'The Catcher in the Rye'),(7,'The Lord of the Rings'),(8,'The Hobbit'),(9,'The Da Vinci Code'),(10,'Harry Potter');
/*!40000 ALTER TABLE `libro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sala`
--

DROP TABLE IF EXISTS `sala`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sala` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `nombre_sala` varchar(400) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sala`
--

LOCK TABLES `sala` WRITE;
/*!40000 ALTER TABLE `sala` DISABLE KEYS */;
INSERT INTO `sala` VALUES (1,'Ciencia Ficcion'),(2,'Misterio'),(3,'Comedia'),(4,'Terror'),(5,'Distopia'),(6,'Fantasia');
/*!40000 ALTER TABLE `sala` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `volumen_libro`
--

DROP TABLE IF EXISTS `volumen_libro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `volumen_libro` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `id_libro` int unsigned DEFAULT NULL,
  `numero_volumen` int DEFAULT NULL,
  `id_estante` int unsigned DEFAULT NULL,
  `posicion` varchar(20) DEFAULT NULL,
  `estado` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_libro` (`id_libro`),
  KEY `fk_estante` (`id_estante`),
  CONSTRAINT `fk_estante` FOREIGN KEY (`id_estante`) REFERENCES `estante` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_libro` FOREIGN KEY (`id_libro`) REFERENCES `libro` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `volumen_libro`
--

LOCK TABLES `volumen_libro` WRITE;
/*!40000 ALTER TABLE `volumen_libro` DISABLE KEYS */;
INSERT INTO `volumen_libro` VALUES (1,8,2,24,'5',1),(2,2,3,2,'4',0),(3,3,1,1,'2',1),(4,4,1,2,'1',1),(5,5,2,16,'2',1),(6,6,1,2,'2',1),(7,7,2,21,'1',1),(8,8,1,21,'1',0),(9,9,1,5,'1',0),(10,10,4,22,'1',0),(13,1,2,1,'4',0),(16,6,4,12,'5',0),(17,4,5,16,'6',0),(20,1,4,11,'4',0),(21,5,3,12,'5',0),(22,1,3,7,'4',0),(23,9,2,16,'4',0),(24,7,3,24,'5',0),(25,1,4,16,'4',1);
/*!40000 ALTER TABLE `volumen_libro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'babel_db'
--

--
-- Dumping routines for database 'babel_db'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-01 11:14:33

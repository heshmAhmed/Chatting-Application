-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: chatting_application
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `user_blocks`
--

DROP TABLE IF EXISTS `user_blocks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_blocks` (
  `user_number` varchar(20) NOT NULL,
  `contact_number` varchar(20) NOT NULL,
  PRIMARY KEY (`user_number`,`contact_number`),
  KEY `contact_number` (`contact_number`),
  CONSTRAINT `user_blocks_ibfk_1` FOREIGN KEY (`user_number`) REFERENCES `users` (`phone_number`),
  CONSTRAINT `user_blocks_ibfk_2` FOREIGN KEY (`contact_number`) REFERENCES `users` (`phone_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_blocks`
--

LOCK TABLES `user_blocks` WRITE;
/*!40000 ALTER TABLE `user_blocks` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_blocks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_contacts`
--

DROP TABLE IF EXISTS `user_contacts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_contacts` (
  `user_number` varchar(20) NOT NULL,
  `contact_number` varchar(20) NOT NULL,
  PRIMARY KEY (`user_number`,`contact_number`),
  KEY `contact_number` (`contact_number`),
  CONSTRAINT `user_contacts_ibfk_1` FOREIGN KEY (`user_number`) REFERENCES `users` (`phone_number`),
  CONSTRAINT `user_contacts_ibfk_2` FOREIGN KEY (`contact_number`) REFERENCES `users` (`phone_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_contacts`
--

LOCK TABLES `user_contacts` WRITE;
/*!40000 ALTER TABLE `user_contacts` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_contacts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_invetations`
--

DROP TABLE IF EXISTS `user_invetations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_invetations` (
  `sender_number` varchar(20) NOT NULL,
  `reciever_number` varchar(20) NOT NULL,
  `date` datetime NOT NULL DEFAULT (sysdate()),
  `state` bit(1) DEFAULT NULL,
  KEY `sender_number` (`sender_number`),
  KEY `reciever_number` (`reciever_number`),
  CONSTRAINT `user_invetations_ibfk_1` FOREIGN KEY (`sender_number`) REFERENCES `users` (`phone_number`),
  CONSTRAINT `user_invetations_ibfk_2` FOREIGN KEY (`reciever_number`) REFERENCES `users` (`phone_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_invetations`
--

LOCK TABLES `user_invetations` WRITE;
/*!40000 ALTER TABLE `user_invetations` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_invetations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `phone_number` varchar(20) NOT NULL,
  `username` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `image` varchar(200) NOT NULL DEFAULT (_utf8mb4'/'),
  `gender` varchar(1) NOT NULL DEFAULT (_utf8mb4'm'),
  `country` varchar(20) NOT NULL,
  `date_of_birth` datetime NOT NULL,
  `bio` varchar(200) DEFAULT NULL,
  `user_status` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`phone_number`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
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

-- Dump completed on 2022-02-15 23:52:11

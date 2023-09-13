-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: football_game
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `coaches`
--

DROP TABLE IF EXISTS `coaches`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `coaches` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `age` int DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `team_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_7q1t6f2cctndixp79xyomayd0` (`team_id`),
  CONSTRAINT `FKcdq4rnavxgc1iff9jawneh758` FOREIGN KEY (`team_id`) REFERENCES `teams` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coaches`
--

LOCK TABLES `coaches` WRITE;
/*!40000 ALTER TABLE `coaches` DISABLE KEYS */;
INSERT INTO `coaches` VALUES (1,50,'Jurgen Klopp',5),(2,50,'Massimiliano Allegri',1),(3,64,'Luciano Spalletti',2),(4,57,'Stefano Pioli',3),(5,45,'Mikel Arteta',4),(6,51,'Mauricio Pochettino',6);
/*!40000 ALTER TABLE `coaches` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `leagues`
--

DROP TABLE IF EXISTS `leagues`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `leagues` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leagues`
--

LOCK TABLES `leagues` WRITE;
/*!40000 ALTER TABLE `leagues` DISABLE KEYS */;
INSERT INTO `leagues` VALUES (1,'Calcio A'),(2,'Premier League');
/*!40000 ALTER TABLE `leagues` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `matches`
--

DROP TABLE IF EXISTS `matches`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `matches` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `date` varchar(255) DEFAULT NULL,
  `result` varchar(255) DEFAULT NULL,
  `league_id` bigint DEFAULT NULL,
  `referee_id` bigint DEFAULT NULL,
  `home_id` bigint DEFAULT NULL,
  `away_id` bigint DEFAULT NULL,
  `winner_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK23dnop04r2pfj2wvo21vakpph` (`league_id`),
  KEY `FKe93f8jtxkaoyjrmhit15msgm5` (`referee_id`),
  KEY `FK455u7ietc8xi4f0kt14bn5n7w` (`home_id`),
  KEY `FKm513w5sj43xwgdxm94s4i7t2v` (`away_id`),
  KEY `FKbeel88lh2ksupphafotnqy7ry` (`winner_id`),
  CONSTRAINT `FK23dnop04r2pfj2wvo21vakpph` FOREIGN KEY (`league_id`) REFERENCES `leagues` (`id`),
  CONSTRAINT `FK455u7ietc8xi4f0kt14bn5n7w` FOREIGN KEY (`home_id`) REFERENCES `teams` (`id`),
  CONSTRAINT `FKbeel88lh2ksupphafotnqy7ry` FOREIGN KEY (`winner_id`) REFERENCES `teams` (`id`),
  CONSTRAINT `FKe93f8jtxkaoyjrmhit15msgm5` FOREIGN KEY (`referee_id`) REFERENCES `referees` (`id`),
  CONSTRAINT `FKm513w5sj43xwgdxm94s4i7t2v` FOREIGN KEY (`away_id`) REFERENCES `teams` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `matches`
--

LOCK TABLES `matches` WRITE;
/*!40000 ALTER TABLE `matches` DISABLE KEYS */;
INSERT INTO `matches` VALUES (1,'6/07/1945','7 - 4',1,4,2,1,2),(2,'10/07/1945','7 - 3',1,3,3,1,1),(7,'10/07/1945','4 - 2',1,3,3,2,2),(8,'10/07/1945','4 - 2',1,3,3,2,2),(9,'10/07/2004','0 - 0',2,2,4,6,4),(10,'10/07/2004','0 - 0',2,1,4,6,4),(11,'10/07/2004','2 - 1',2,1,4,6,4),(12,'10/07/2023','2 - 2',2,1,5,6,6),(13,'10/07/2023','7 - 0',2,1,5,6,5);
/*!40000 ALTER TABLE `matches` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `players`
--

DROP TABLE IF EXISTS `players`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `players` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `age` int DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `shirt_number` int DEFAULT NULL,
  `team_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5nglidr00c4dyybl171v6kask` (`team_id`),
  CONSTRAINT `FK5nglidr00c4dyybl171v6kask` FOREIGN KEY (`team_id`) REFERENCES `teams` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `players`
--

LOCK TABLES `players` WRITE;
/*!40000 ALTER TABLE `players` DISABLE KEYS */;
INSERT INTO `players` VALUES (1,23,'Dusan Vlahovic',9,1),(2,31,'Paul Pogba',6,1),(3,22,'Khvicha Kvaratshkelia',77,2),(4,23,'Victor Osimhen',9,2),(5,21,'Rafel Leao',7,3),(6,23,'Mike Maignan',1,3),(7,21,'Bukayo Saka',7,4),(8,22,'Emile Smith-Rowe',10,4),(9,31,'Mohammed Salah',7,5),(10,30,'Virgil Van Dijk',4,5),(11,30,'Raheem Sterling',7,6),(12,22,'Nicolas Jackson',9,6);
/*!40000 ALTER TABLE `players` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `referees`
--

DROP TABLE IF EXISTS `referees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `referees` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `age` int DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `league_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKryvrch4b23bx9evlvvhuomnqq` (`league_id`),
  CONSTRAINT `FKryvrch4b23bx9evlvvhuomnqq` FOREIGN KEY (`league_id`) REFERENCES `leagues` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `referees`
--

LOCK TABLES `referees` WRITE;
/*!40000 ALTER TABLE `referees` DISABLE KEYS */;
INSERT INTO `referees` VALUES (1,52,'Mike Dean',2),(2,46,'Anthony Taylor',2),(3,48,'Simone Palacio',1),(4,65,'Gamal El Ghandour',1);
/*!40000 ALTER TABLE `referees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teams`
--

DROP TABLE IF EXISTS `teams`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teams` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `league_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKcmnrlwu7alyse9s3x5tgvxyqj` (`league_id`),
  CONSTRAINT `FKcmnrlwu7alyse9s3x5tgvxyqj` FOREIGN KEY (`league_id`) REFERENCES `leagues` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teams`
--

LOCK TABLES `teams` WRITE;
/*!40000 ALTER TABLE `teams` DISABLE KEYS */;
INSERT INTO `teams` VALUES (1,'Juventus',1),(2,'Napoli',1),(3,'AC Milan',1),(4,'Arsenal FC',2),(5,'Liverpool FC',2),(6,'Chelsea',2);
/*!40000 ALTER TABLE `teams` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-13 11:59:43

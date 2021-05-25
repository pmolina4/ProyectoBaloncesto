-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: basket
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `equipo`
--

DROP TABLE IF EXISTS `equipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `equipo` (
  `nombre` varchar(45) NOT NULL,
  `nacionalidad` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='	';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipo`
--

LOCK TABLES `equipo` WRITE;
/*!40000 ALTER TABLE `equipo` DISABLE KEYS */;
INSERT INTO `equipo` VALUES ('Barcelona','España'),('Baskonia','España'),('Betis','España'),('Estudiantes','España'),('Lakers','Estadounidense'),('Real Madrid','España'),('Tenerife','España'),('UCAM Murcia','España'),('unicaja Málaga','España'),('Valencia','España');
/*!40000 ALTER TABLE `equipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jugador`
--

DROP TABLE IF EXISTS `jugador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jugador` (
  `nombre` varchar(35) NOT NULL,
  `posicion` varchar(45) NOT NULL,
  `manoDominante` varchar(45) NOT NULL,
  `fuerza` int NOT NULL,
  `velocidad` int NOT NULL,
  `inteligencia` int NOT NULL,
  `tecnica` int NOT NULL,
  `numero` int NOT NULL,
  `equipo` varchar(45) NOT NULL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jugador`
--

LOCK TABLES `jugador` WRITE;
/*!40000 ALTER TABLE `jugador` DISABLE KEYS */;
INSERT INTO `jugador` VALUES ('Alvaro Lopez','Alapivot','Zurdo',83,74,98,78,7,'Baskonia'),('Ander Heredia','Alapivot','Diestro',88,75,94,99,18,'Baskonia'),('Antonio Miranda','Alapivot','Diestro',67,82,82,82,9,'Baskonia'),('Antonio Torres','Alapivot','Zurdo',67,68,80,71,5,'Baskonia'),('Benito Kimpembe','Alapivot','Zurdo',97,85,99,71,10,'Baskonia'),('Cristiano Smith','Alapivot','Zurdo',95,97,97,67,4,'Baskonia'),('Davies Johnson','Alapivot','Zurdo',69,87,97,93,9,'Barcelona'),('Eduardo Wilson','Alapivot','Zurdo',66,84,83,72,12,'Barcelona'),('Eugenio Adams','Alapivot','Diestro',92,82,73,89,11,'Barcelona'),('Fernando Gonzalez','Alapivot','Zurdo',75,68,87,77,13,'Barcelona'),('Johan Parra','Alapivot','Zurdo',75,93,77,99,19,'Barcelona'),('John Salazar','Alapivot','Diestro',87,69,93,75,7,'Barcelona'),('José Curry','Alapivot','Diestro',95,68,97,83,6,'Betis'),('Jose Manuel Green','Alapivot','Diestro',75,93,97,88,5,'Betis'),('Joselito Perez','Alapivot','Diestro',85,90,96,79,6,'Betis'),('Juampi Maroto','Alapivot','Zurdo',91,72,80,96,12,'Betis'),('Juan Cortes','Alapivot','Zurdo',70,66,66,79,10,'Betis'),('Lebron Martin','Alapivot','Diestro',75,89,67,97,10,'Betis'),('Makelele William','Alapivot','Diestro',74,86,75,95,19,'Tenerife'),('Manolo King','Alapivot','Diestro',72,88,85,87,10,'Tenerife'),('Marcos William','Alapivot','Diestro',76,93,96,87,18,'Tenerife'),('Marcus Dembele','Alapivot','Diestro',99,97,92,74,8,'Tenerife'),('Mario Baker','Alapivot','Zurdo',99,95,80,73,2,'Tenerife'),('Miguel Flores','Alapivot','Zurdo',98,70,89,92,3,'Tenerife'),('Oscar Vargas','Alapivot','Diestro',68,84,76,90,6,'Estudiantes'),('Pablo Miller','Alapivot','Zurdo',71,73,92,92,15,'Estudiantes'),('Paco sales','Alapivot','Diestro',76,73,92,68,5,'Estudiantes'),('Pau cortes','Alapivot','Zurdo',87,81,92,95,11,'Estudiantes'),('Pau Duran','Alapivot','Zurdo',71,69,77,94,2,'Estudiantes'),('Rashe Simonl','Alapivot','Diestro',84,87,81,82,15,'Estudiantes'),('Rashford Robert','Alapivot','Diestro',69,96,89,66,2,'Estudiantes'),('Salvador Molina','Alapivot','Zurdo',69,74,72,68,6,'Betis'),('Sergio Llul','Alapivot','Diestro',88,85,98,79,17,'Tenerife'),('Stephen Lewis','Alapivot','Diestro',69,71,72,90,6,'Tenerife');
/*!40000 ALTER TABLE `jugador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `liga`
--

DROP TABLE IF EXISTS `liga`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `liga` (
  `nombre` varchar(45) NOT NULL,
  `temporada` int NOT NULL,
  PRIMARY KEY (`nombre`,`temporada`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `liga`
--

LOCK TABLES `liga` WRITE;
/*!40000 ALTER TABLE `liga` DISABLE KEYS */;
INSERT INTO `liga` VALUES ('acb',2020),('nba',2021);
/*!40000 ALTER TABLE `liga` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `liga_equipo`
--

DROP TABLE IF EXISTS `liga_equipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `liga_equipo` (
  `liga` varchar(45) NOT NULL,
  `temporada` int NOT NULL,
  `equipo` varchar(45) NOT NULL,
  PRIMARY KEY (`liga`,`temporada`,`equipo`),
  KEY `equipo` (`equipo`),
  CONSTRAINT `liga_equipo_ibfk_1` FOREIGN KEY (`equipo`) REFERENCES `equipo` (`nombre`),
  CONSTRAINT `liga_equipo_ibfk_2` FOREIGN KEY (`liga`, `temporada`) REFERENCES `liga` (`nombre`, `temporada`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `liga_equipo`
--

LOCK TABLES `liga_equipo` WRITE;
/*!40000 ALTER TABLE `liga_equipo` DISABLE KEYS */;
INSERT INTO `liga_equipo` VALUES ('acb',2020,'Barcelona'),('acb',2020,'Baskonia'),('acb',2020,'Betis'),('acb',2020,'Estudiantes'),('nba',2021,'Lakers'),('acb',2020,'Real Madrid'),('acb',2020,'Tenerife'),('acb',2020,'UCAM Murcia'),('acb',2020,'Unicaja Malaga'),('acb',2020,'Valencia');
/*!40000 ALTER TABLE `liga_equipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `nombre` varchar(30) NOT NULL,
  `apellidos` varchar(50) NOT NULL,
  `nickname` varchar(10) NOT NULL,
  `email` varchar(45) NOT NULL,
  `contrasena` varchar(10) NOT NULL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES ('a','a','a','a','a');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-25 12:01:15

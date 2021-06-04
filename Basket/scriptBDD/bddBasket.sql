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
INSERT INTO `equipo` VALUES ('Barcelona','España'),('Baskonia','España'),('Betis','España'),('Estudiantes','España'),('Real Madrid','España'),('Tenerife','España'),('UCAM Murcia','España'),('unicaja Málaga','España'),('Valencia','España');
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
  `mediaAtaque` int DEFAULT NULL,
  `mediaDefensa` int DEFAULT NULL,
  `equipo` varchar(45) NOT NULL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jugador`
--

LOCK TABLES `jugador` WRITE;
/*!40000 ALTER TABLE `jugador` DISABLE KEYS */;
INSERT INTO `jugador` VALUES ('Alvaro Lopez','Alapivot','Zurdo',83,74,98,78,7,78,88,'Baskonia'),('Ander Heredia','Alero','Diestro',88,75,94,99,18,81,96,'Baskonia'),('Antonio Miranda','Base','Diestro',67,82,82,82,9,74,82,'Baskonia'),('Antonio Torres','Escolta','Zurdo',67,68,80,71,5,67,75,'Baskonia'),('Benito Kimpembe','Pivot','Zurdo',97,85,99,71,10,86,67,'Baskonia'),('Conner Frankamp','Alapivot','Diestro',66,75,88,91,3,70,56,'UCAM Murcia'),('Cristiano Smith','Alapivot','Zurdo',95,97,97,67,4,96,99,'Baskonia'),('Davies Johnson','Alapivot','Zurdo',69,87,97,93,9,88,88,'Barcelona'),('DJ Strawberry','Pivot','Zurdo',90,95,93,66,10,89,77,'UCAM Murcia'),('Eduardo Wilson','Alero','Zurdo',66,84,83,72,12,98,66,'Barcelona'),('Eugenio Adams','Base','Diestro',92,82,73,89,11,78,49,'Barcelona'),('Fernando Gonzalez','Escolta','Zurdo',75,68,87,77,13,67,76,'Barcelona'),('Fernando San Emeterio','Alapivot','Diestro',95,69,78,88,8,87,99,'Valencia'),('Guillem Vives','Pivot','Zurdo',69,78,92,85,11,89,67,'Valencia'),('Guzman Cortes','Pivot','Zurdo',73,94,88,73,6,67,67,'Real Madrid'),('Johan Parra','Pivot','Zurdo',75,93,77,99,19,87,99,'Barcelona'),('John Salazar','Alapivot','Diestro',87,69,93,75,7,78,87,'Barcelona'),('Jordan Davis','Base','Diestro',72,68,79,90,9,76,76,'UCAM Murcia'),('Jose Collado','Pivot','Zurdo',95,86,92,75,9,98,45,'Unicaja Malaga'),('José Curry','Alapivot','Diestro',95,68,97,83,6,66,56,'Betis'),('Jose Fariña','Alapivot','Zurdo',88,70,84,70,8,74,76,'Unicaja Malaga'),('Jose Manuel Green','Alero','Diestro',75,93,97,88,5,93,98,'Betis'),('Jose Perez','Alapivot','Diestro',69,81,92,92,4,88,80,'Real Madrid'),('Joselito Perez','Base','Diestro',85,90,96,79,6,76,86,'Betis'),('Juampi Maroto','Escolta','Zurdo',91,72,80,96,12,88,67,'Betis'),('Juan Cortes','Pivot','Zurdo',70,66,66,79,10,98,98,'Betis'),('Klemen Prepelic','Base','Diestro',65,69,75,78,7,98,76,'Valencia'),('Lebron Martin','Pivot','Diestro',75,89,67,97,10,56,98,'Betis'),('Luis Balaguer','Pivot','Diestro',88,66,82,66,1,78,56,'Unicaja Malaga'),('Makelele William','Alapivot','Diestro',74,86,75,95,19,93,87,'Tenerife'),('Manolo King','Alero','Diestro',72,88,85,87,10,64,56,'Tenerife'),('Marcos William','Base','Diestro',76,93,96,87,18,56,76,'Tenerife'),('Marcus Dembele','Escolta','Diestro',99,97,92,74,8,56,60,'Tenerife'),('Mario Baker','Pivot','Zurdo',99,95,80,73,2,88,70,'Tenerife'),('Martin Hermannsson','Alapivot','Diestro',97,77,88,66,3,82,80,'Valencia'),('Miguel Flores','Base','Zurdo',98,70,89,92,3,93,90,'Tenerife'),('Mike Tobey','Alero','Zurdo',69,79,67,94,2,84,50,'Valencia'),('Oscar Vargas','Alapivot','Diestro',68,84,76,90,6,76,99,'Estudiantes'),('Pablo Miller','Alero','Zurdo',71,73,92,92,15,45,59,'Estudiantes'),('Pache Lopez','Alero','Zurdo',68,80,67,74,4,77,54,'Unicaja Malaga'),('Paco sales','Base','Diestro',76,73,92,68,5,78,75,'Estudiantes'),('Paco Terron','Escolta','Diestro',78,74,97,87,3,83,67,'Unicaja Malaga'),('Pau cortes','Pivot','Zurdo',87,81,92,95,11,56,87,'Estudiantes'),('Pau Duran','Alero','Zurdo',71,69,77,94,2,44,91,'Estudiantes'),('Peter Jok','Alapivot','Zurdo',86,93,96,88,15,87,34,'UCAM Murcia'),('Rashe Simonl','Alapivot','Diestro',84,87,81,82,15,56,67,'Estudiantes'),('Rashford Robert','Alapivot','Diestro',69,96,89,66,2,79,87,'Real Madrid'),('Sadiel Rojas','Alero','Diestro',85,86,75,86,12,87,99,'UCAM Murcia'),('Salmeron Collado','Base','Diestro',69,82,93,95,5,86,76,'Unicaja Malaga'),('Salvador Molina','Alero','Zurdo',69,74,72,68,6,67,76,'Real Madrid'),('Sergio Llul','Base','Diestro',88,85,98,79,17,81,88,'Real Madrid'),('Stephen Lewis','Pivot','Diestro',69,71,72,90,6,29,65,'Real Madrid'),('Tomás Bellas','Alero','Zurdo',90,69,85,88,6,99,77,'UCAM Murcia'),('Vanja Marinkovic','Alero','Zurdo',88,93,69,68,19,55,76,'Valencia');
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
INSERT INTO `liga` VALUES ('acb',2020);
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
INSERT INTO `liga_equipo` VALUES ('acb',2020,'Barcelona'),('acb',2020,'Baskonia'),('acb',2020,'Betis'),('acb',2020,'Estudiantes'),('acb',2020,'Real Madrid'),('acb',2020,'Tenerife'),('acb',2020,'UCAM Murcia'),('acb',2020,'Unicaja Malaga'),('acb',2020,'Valencia');
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
  `contrasena` varchar(16) NOT NULL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES ('Pablo','Molina','pablo','pablomollinaconde4@gmail.com','Pablo123');
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

-- Dump completed on 2021-06-04 13:29:07

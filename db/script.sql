-- MySQL dump 10.13  Distrib 5.7.12, for Linux (x86_64)
--
-- Host: localhost    Database: clubmatdb
-- ------------------------------------------------------
-- Server version	5.7.12

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
-- Table structure for table `clubmatematicas`
--
create database clubmatdb;
USE clubmatdb;

DROP TABLE IF EXISTS `clubmatematicas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clubmatematicas` (
  `idclub` int(11) NOT NULL AUTO_INCREMENT,
  `foto` longblob,
  `lema` varchar(200) DEFAULT NULL,
  `nombreclub` varchar(50) DEFAULT NULL,
  `porcentajereglas` varchar(30) DEFAULT NULL,
  `idinstitucion` int(11) DEFAULT NULL,
  PRIMARY KEY (`idclub`),
  KEY `FKm250e60bfw09cgfrx8g5fl7at` (`idinstitucion`),
  CONSTRAINT `FKm250e60bfw09cgfrx8g5fl7at` FOREIGN KEY (`idinstitucion`) REFERENCES `institucion` (`idinstitucion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clubmatematicas`
--

LOCK TABLES `clubmatematicas` WRITE;
/*!40000 ALTER TABLE `clubmatematicas` DISABLE KEYS */;
/*!40000 ALTER TABLE `clubmatematicas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `guia`
--

DROP TABLE IF EXISTS `guia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `guia` (
  `idguia` int(11) NOT NULL AUTO_INCREMENT,
  `comentarios` varchar(500) DEFAULT NULL,
  `documento` longblob,
  `grado` int(11) DEFAULT NULL,
  PRIMARY KEY (`idguia`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `guia`
--

LOCK TABLES `guia` WRITE;
/*!40000 ALTER TABLE `guia` DISABLE KEYS */;
/*!40000 ALTER TABLE `guia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `institucion`
--

DROP TABLE IF EXISTS `institucion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `institucion` (
  `idinstitucion` int(11) NOT NULL AUTO_INCREMENT,
  `ciudad` varchar(30) DEFAULT NULL,
  `direccion` varchar(50) DEFAULT NULL,
  `localidad` varchar(15) DEFAULT NULL,
  `nombre` varchar(30) DEFAULT NULL,
  `rector` varchar(50) DEFAULT NULL,
  `telefono` int(11) DEFAULT NULL,
  `tipo` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`idinstitucion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `institucion`
--

LOCK TABLES `institucion` WRITE;
/*!40000 ALTER TABLE `institucion` DISABLE KEYS */;
/*!40000 ALTER TABLE `institucion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `noticia`
--

DROP TABLE IF EXISTS `noticia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `noticia` (
  `idnoticia` int(11) NOT NULL AUTO_INCREMENT,
  `contenido` varchar(700) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `foto` longblob,
  `tipo` varchar(50) DEFAULT NULL,
  `titulo` varchar(200) DEFAULT NULL,
  `idclub` int(11) DEFAULT NULL,
  PRIMARY KEY (`idnoticia`),
  KEY `FKjdgbmhyhogf89a6t15dlyts4c` (`idclub`),
  CONSTRAINT `FKjdgbmhyhogf89a6t15dlyts4c` FOREIGN KEY (`idclub`) REFERENCES `clubmatematicas` (`idclub`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `noticia`
--

LOCK TABLES `noticia` WRITE;
/*!40000 ALTER TABLE `noticia` DISABLE KEYS */;
/*!40000 ALTER TABLE `noticia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `olimpiada`
--

DROP TABLE IF EXISTS `olimpiada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `olimpiada` (
  `idolimpiada` int(11) NOT NULL AUTO_INCREMENT,
  `activacion` varchar(30) DEFAULT NULL,
  `ciudad` varchar(30) DEFAULT NULL,
  `direccion` varchar(50) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `hora` varchar(15) DEFAULT NULL,
  `lugar` varchar(50) DEFAULT NULL,
  `nombre` varchar(30) DEFAULT NULL,
  `telefono` int(11) DEFAULT NULL,
  `idclub` int(11) DEFAULT NULL,
  `idprueba` int(11) DEFAULT NULL,
  `organizador` int(11) DEFAULT NULL,
  PRIMARY KEY (`idolimpiada`),
  KEY `FKg7ogvg0b2o5pt7xgqmefognpj` (`idclub`),
  KEY `FKd28hg7vd828kg3v1nycggmjyi` (`idprueba`),
  KEY `FKgexeriuk2upb1d3jduwkquws5` (`organizador`),
  CONSTRAINT `FKd28hg7vd828kg3v1nycggmjyi` FOREIGN KEY (`idprueba`) REFERENCES `prueba` (`idprueba`),
  CONSTRAINT `FKg7ogvg0b2o5pt7xgqmefognpj` FOREIGN KEY (`idclub`) REFERENCES `clubmatematicas` (`idclub`),
  CONSTRAINT `FKgexeriuk2upb1d3jduwkquws5` FOREIGN KEY (`organizador`) REFERENCES `usuario` (`idusuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `olimpiada`
--

LOCK TABLES `olimpiada` WRITE;
/*!40000 ALTER TABLE `olimpiada` DISABLE KEYS */;
/*!40000 ALTER TABLE `olimpiada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `opcionpregunta`
--

DROP TABLE IF EXISTS `opcionpregunta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `opcionpregunta` (
  `idopcionpregunta` int(11) NOT NULL AUTO_INCREMENT,
  `correcta` bit(1) DEFAULT NULL,
  `opcion` varchar(500) DEFAULT NULL,
  `idpregunta` int(11) DEFAULT NULL,
  PRIMARY KEY (`idopcionpregunta`),
  KEY `FK34jrlsus6qc1o2756233kpv5e` (`idpregunta`),
  CONSTRAINT `FK34jrlsus6qc1o2756233kpv5e` FOREIGN KEY (`idpregunta`) REFERENCES `pregunta` (`idpregunta`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `opcionpregunta`
--

LOCK TABLES `opcionpregunta` WRITE;
/*!40000 ALTER TABLE `opcionpregunta` DISABLE KEYS */;
/*!40000 ALTER TABLE `opcionpregunta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pregunta`
--

DROP TABLE IF EXISTS `pregunta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pregunta` (
  `idpregunta` int(11) NOT NULL AUTO_INCREMENT,
  `aprobado` varchar(255) DEFAULT NULL,
  `clasificacion` varchar(30) DEFAULT NULL,
  `dificultad` varchar(20) DEFAULT NULL,
  `enunciado` varchar(700) DEFAULT NULL,
  `nivelacademico` varchar(15) DEFAULT NULL,
  `resultado` varchar(255) DEFAULT NULL,
  `tematica` varchar(50) DEFAULT NULL,
  `titulo` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idpregunta`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pregunta`
--

LOCK TABLES `pregunta` WRITE;
/*!40000 ALTER TABLE `pregunta` DISABLE KEYS */;
/*!40000 ALTER TABLE `pregunta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prueba`
--

DROP TABLE IF EXISTS `prueba`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prueba` (
  `idprueba` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT NULL,
  `numcorrectas` int(11) DEFAULT NULL,
  `numpreguntas` int(11) DEFAULT NULL,
  `tema` varchar(70) DEFAULT NULL,
  `tipoprueba` varchar(30) DEFAULT NULL,
  `idusuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`idprueba`),
  KEY `FK9d5l7w8ihpm7xeohicjpet4m8` (`idusuario`),
  CONSTRAINT `FK9d5l7w8ihpm7xeohicjpet4m8` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idusuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prueba`
--

LOCK TABLES `prueba` WRITE;
/*!40000 ALTER TABLE `prueba` DISABLE KEYS */;
/*!40000 ALTER TABLE `prueba` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prueba_pregunta`
--

DROP TABLE IF EXISTS `prueba_pregunta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prueba_pregunta` (
  `pregunta_idpregunta` int(11) NOT NULL,
  `prueba_idprueba` int(11) NOT NULL,
  KEY `FK3badf75brrupalhsxo3149pm0` (`prueba_idprueba`),
  KEY `FKhet90jviwk3relejm7wpb20n3` (`pregunta_idpregunta`),
  CONSTRAINT `FK3badf75brrupalhsxo3149pm0` FOREIGN KEY (`prueba_idprueba`) REFERENCES `prueba` (`idprueba`),
  CONSTRAINT `FKhet90jviwk3relejm7wpb20n3` FOREIGN KEY (`pregunta_idpregunta`) REFERENCES `pregunta` (`idpregunta`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prueba_pregunta`
--

LOCK TABLES `prueba_pregunta` WRITE;
/*!40000 ALTER TABLE `prueba_pregunta` DISABLE KEYS */;
/*!40000 ALTER TABLE `prueba_pregunta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reglacreacion`
--

DROP TABLE IF EXISTS `reglacreacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reglacreacion` (
  `idregla` int(11) NOT NULL AUTO_INCREMENT,
  `documento` longblob,
  `estado` varchar(30) DEFAULT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `idclub` int(11) DEFAULT NULL,
  PRIMARY KEY (`idregla`),
  KEY `FKecjqw1kk151xynk1pmqtdasyh` (`idclub`),
  CONSTRAINT `FKecjqw1kk151xynk1pmqtdasyh` FOREIGN KEY (`idclub`) REFERENCES `clubmatematicas` (`idclub`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reglacreacion`
--

LOCK TABLES `reglacreacion` WRITE;
/*!40000 ALTER TABLE `reglacreacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `reglacreacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `idusuario` int(11) NOT NULL AUTO_INCREMENT,
  `apellido` varchar(50) DEFAULT NULL,
  `ciudad` varchar(30) DEFAULT NULL,
  `contrasena` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `puntaje` int(11) DEFAULT NULL,
  `rol` varchar(255) DEFAULT NULL,
  `telefono` int(11) DEFAULT NULL,
  `usuario` varchar(50) DEFAULT NULL,
  `idclub` int(11) DEFAULT NULL,
  `idinstitucion` int(11) DEFAULT NULL,
  PRIMARY KEY (`idusuario`),
  KEY `FKipoc3l0qs0j5sxx3y34isdp7m` (`idclub`),
  KEY `FKq07x6tn4w2um9pd2a884rpg1c` (`idinstitucion`),
  CONSTRAINT `FKipoc3l0qs0j5sxx3y34isdp7m` FOREIGN KEY (`idclub`) REFERENCES `clubmatematicas` (`idclub`),
  CONSTRAINT `FKq07x6tn4w2um9pd2a884rpg1c` FOREIGN KEY (`idinstitucion`) REFERENCES `institucion` (`idinstitucion`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Hernndez','Bogot','esteban','muti@mail.com','Esteban',NULL,'Administrador',1234,'esteban',NULL,NULL),(2,'Calle','Bogot','david','david@mail.com','David',NULL,'Administrador',1234,'david',NULL,NULL);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario_olimpiada`
--

DROP TABLE IF EXISTS `usuario_olimpiada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario_olimpiada` (
  `olimpiada_idolimpiada` int(11) NOT NULL,
  `usuario_idusuario` int(11) NOT NULL,
  KEY `FKsa14dnobia9nlfyqlxa2u0000` (`usuario_idusuario`),
  KEY `FK6sjcwl8lp878aqhhsg57fvv0s` (`olimpiada_idolimpiada`),
  CONSTRAINT `FK6sjcwl8lp878aqhhsg57fvv0s` FOREIGN KEY (`olimpiada_idolimpiada`) REFERENCES `olimpiada` (`idolimpiada`),
  CONSTRAINT `FKsa14dnobia9nlfyqlxa2u0000` FOREIGN KEY (`usuario_idusuario`) REFERENCES `usuario` (`idusuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_olimpiada`
--

LOCK TABLES `usuario_olimpiada` WRITE;
/*!40000 ALTER TABLE `usuario_olimpiada` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario_olimpiada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuariolimpiada`
--

DROP TABLE IF EXISTS `usuariolimpiada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuariolimpiada` (
  `idusuariolimpiada` int(11) NOT NULL AUTO_INCREMENT,
  `idolimpiada` int(11) DEFAULT NULL,
  `idusuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`idusuariolimpiada`),
  KEY `FKh5lbdy4oepamjax8kkf58chco` (`idolimpiada`),
  KEY `FK1wwk0nsrbhbc69ccd3j70qy4e` (`idusuario`),
  CONSTRAINT `FK1wwk0nsrbhbc69ccd3j70qy4e` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idusuario`),
  CONSTRAINT `FKh5lbdy4oepamjax8kkf58chco` FOREIGN KEY (`idolimpiada`) REFERENCES `olimpiada` (`idolimpiada`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuariolimpiada`
--

LOCK TABLES `usuariolimpiada` WRITE;
/*!40000 ALTER TABLE `usuariolimpiada` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuariolimpiada` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-10-23  3:12:37

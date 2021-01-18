-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: mydb
-- ------------------------------------------------------
-- Server version	5.7.31

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
-- Table structure for table `Operatorzy`
--

DROP TABLE IF EXISTS `Operatorzy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Operatorzy` (
  `idOperatora` int(11) NOT NULL,
  `czyOperatorUkladarki` tinyint(4) DEFAULT NULL,
  `czyOperatorWalca` tinyint(4) DEFAULT NULL,
  `czyOperatorKoparki` tinyint(4) DEFAULT NULL,
  `czyOperatorKoparkoLadowarki` tinyint(4) DEFAULT NULL,
  `czyOperatorRowniarki` tinyint(4) DEFAULT NULL,
  `czyOperatorFrezarki` tinyint(4) DEFAULT NULL,
  `czyOperatorLadowarki` tinyint(4) DEFAULT NULL,
  `czyOperatorSpycharki` tinyint(4) DEFAULT NULL,
  `czyOperatorZurawia` tinyint(4) DEFAULT NULL,
  `Pracownicy_idPracownika` int(11) NOT NULL,
  PRIMARY KEY (`idOperatora`),
  KEY `fk_Operatorzy_Pracownicy1_idx` (`Pracownicy_idPracownika`),
  CONSTRAINT `fk_Operatorzy_Pracownicy1` FOREIGN KEY (`Pracownicy_idPracownika`) REFERENCES `pracownicy` (`id_pracownika`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Operatorzy`
--

LOCK TABLES `Operatorzy` WRITE;
/*!40000 ALTER TABLE `Operatorzy` DISABLE KEYS */;
/*!40000 ALTER TABLE `Operatorzy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `brygadzisci`
--

DROP TABLE IF EXISTS `brygadzisci`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `brygadzisci` (
  `id_brygadzisty` int(11) NOT NULL AUTO_INCREMENT,
  `dodatek` float DEFAULT NULL,
  PRIMARY KEY (`id_brygadzisty`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brygadzisci`
--

LOCK TABLES `brygadzisci` WRITE;
/*!40000 ALTER TABLE `brygadzisci` DISABLE KEYS */;
INSERT INTO `brygadzisci` VALUES (1,5),(2,5);
/*!40000 ALTER TABLE `brygadzisci` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `budowa`
--

DROP TABLE IF EXISTS `budowa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `budowa` (
  `id_budowy` int(11) NOT NULL AUTO_INCREMENT,
  `nazwa` varchar(45) DEFAULT NULL,
  `opis` text,
  `wspolrzedne` varchar(45) DEFAULT NULL,
  `planowana_data_rozpoczecia` date DEFAULT NULL,
  `planowana_data_zakonczenia` date DEFAULT NULL,
  `uzytkownicy_id_uzytkownika` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_budowy`),
  KEY `fk_Budowa_Uzytkownicy1_idx` (`uzytkownicy_id_uzytkownika`),
  CONSTRAINT `fk_Budowa_Uzytkownicy1` FOREIGN KEY (`uzytkownicy_id_uzytkownika`) REFERENCES `uzytkownicy` (`id_uzytkownika`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `budowa`
--

LOCK TABLES `budowa` WRITE;
/*!40000 ALTER TABLE `budowa` DISABLE KEYS */;
INSERT INTO `budowa` VALUES (1,'Kurów','Budowa węzła Kurów','51.389167, 22.186667','2010-04-15','2012-06-22',1),(2,'Kurów','Budowa węzła Kurów','51.389167, 22.186667','2010-04-15','2012-06-22',1);
/*!40000 ALTER TABLE `budowa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `karty_pracy`
--

DROP TABLE IF EXISTS `karty_pracy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `karty_pracy` (
  `id_karty_pracy` int(11) NOT NULL AUTO_INCREMENT,
  `raport_dzienny_brygady_id_raport_dzienny_brygady` int(11) DEFAULT NULL,
  `pracownicy_id_pracownika` int(11) DEFAULT NULL,
  `data_karty_pracy` date DEFAULT NULL,
  `szkodliwe_godziny` int(11) DEFAULT NULL,
  `godzina_rozpoczecia` time DEFAULT NULL,
  `godzina_zakonczenia` time DEFAULT NULL,
  PRIMARY KEY (`id_karty_pracy`),
  UNIQUE KEY `id_karty_pracy_UNIQUE` (`id_karty_pracy`),
  KEY `fk_RaportDziennyBrygady_has_Pracownicy_Pracownicy1_idx` (`pracownicy_id_pracownika`),
  KEY `fk_RaportDziennyBrygady_has_Pracownicy_RaportDziennyBrygady_idx` (`raport_dzienny_brygady_id_raport_dzienny_brygady`),
  CONSTRAINT `fk_RaportDziennyBrygady_has_Pracownicy_Pracownicy1` FOREIGN KEY (`pracownicy_id_pracownika`) REFERENCES `pracownicy` (`id_pracownika`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_RaportDziennyBrygady_has_Pracownicy_RaportDziennyBrygady1` FOREIGN KEY (`raport_dzienny_brygady_id_raport_dzienny_brygady`) REFERENCES `raport_dzienny_brygady` (`id_raport_dzienny_brygady`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `karty_pracy`
--

LOCK TABLES `karty_pracy` WRITE;
/*!40000 ALTER TABLE `karty_pracy` DISABLE KEYS */;
INSERT INTO `karty_pracy` VALUES (1,1,2,'2012-05-22',0,'16:00:00','22:00:00'),(2,1,2,'2012-05-22',0,'08:00:00','14:00:00'),(3,1,2,'2012-06-22',0,'08:00:00','14:00:00'),(4,1,3,'2012-06-22',0,'08:00:00','14:00:00'),(5,1,3,'2012-05-22',1,'08:00:00','14:00:00'),(6,1,2,'2020-12-22',1,'08:00:00','14:00:00'),(7,1,2,'2020-12-21',0,'08:00:00','14:00:00'),(8,1,3,'2020-12-20',1,'22:00:00','06:00:00'),(9,1,2,'2020-12-20',5,'22:00:00','06:00:00');
/*!40000 ALTER TABLE `karty_pracy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `konto`
--

DROP TABLE IF EXISTS `konto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `konto` (
  `id_konto` int(11) NOT NULL AUTO_INCREMENT,
  `imie` varchar(45) DEFAULT NULL,
  `nazwisko` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `login` varchar(45) DEFAULT NULL,
  `haslo` varchar(60) DEFAULT NULL,
  `numer_telefonu` varchar(45) DEFAULT NULL,
  `czy_kierownik` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_konto`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `konto`
--

LOCK TABLES `konto` WRITE;
/*!40000 ALTER TABLE `konto` DISABLE KEYS */;
INSERT INTO `konto` VALUES (1,'ftj','gjddjh','hdhdf','dhfdfh','dhfdfh','455345345','1');
/*!40000 ALTER TABLE `konto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `maszyny`
--

DROP TABLE IF EXISTS `maszyny`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `maszyny` (
  `id_maszyny` int(11) NOT NULL AUTO_INCREMENT,
  `nazwa` varchar(45) DEFAULT NULL,
  `numer_inwentarzowy` varchar(45) DEFAULT NULL,
  `moc_km` int(3) DEFAULT NULL,
  `zuzycie_paliwa` float DEFAULT NULL,
  `pojemnosc_zbiornika_paliwa` int(4) DEFAULT NULL,
  `rok_produkcji` year(4) DEFAULT NULL,
  `uwagi` text,
  PRIMARY KEY (`id_maszyny`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `maszyny`
--

LOCK TABLES `maszyny` WRITE;
/*!40000 ALTER TABLE `maszyny` DISABLE KEYS */;
INSERT INTO `maszyny` VALUES (1,'JCB','874547',100,30,100,2017,'Bardzo dobra maszyna, bardzo dobrze robi'),(2,'JCB','874547',100,30,100,2017,'Bardzo dobra maszyna, bardzo dobrze robi');
/*!40000 ALTER TABLE `maszyny` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materialy`
--

DROP TABLE IF EXISTS `materialy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `materialy` (
  `id_materialu` int(11) NOT NULL AUTO_INCREMENT,
  `nazwa` varchar(45) DEFAULT NULL,
  `jednostka` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_materialu`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materialy`
--

LOCK TABLES `materialy` WRITE;
/*!40000 ALTER TABLE `materialy` DISABLE KEYS */;
INSERT INTO `materialy` VALUES (1,'cement','kg'),(2,'cement','kg');
/*!40000 ALTER TABLE `materialy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `normy_pracy`
--

DROP TABLE IF EXISTS `normy_pracy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `normy_pracy` (
  `id_normy_pracy` int(11) NOT NULL AUTO_INCREMENT,
  `numer_katalogu` int(11) DEFAULT NULL,
  `numer_tablicy` int(11) DEFAULT NULL,
  `numer_kolumny` int(11) DEFAULT NULL,
  `numer_wiersza` int(11) DEFAULT NULL,
  `nazwa_roboty` varchar(45) DEFAULT NULL,
  `jednostka_miary_liczba` float DEFAULT NULL,
  `jednostka_miary_wartosc` varchar(45) DEFAULT NULL,
  `norma_pracy` float DEFAULT NULL,
  PRIMARY KEY (`id_normy_pracy`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `normy_pracy`
--

LOCK TABLES `normy_pracy` WRITE;
/*!40000 ALTER TABLE `normy_pracy` DISABLE KEYS */;
INSERT INTO `normy_pracy` VALUES (1,11,22,33,44,'Ułożenie kostki',5,'m2',10.5),(2,11,22,33,44,'Ułożenie kostki',5,'m2',10.5);
/*!40000 ALTER TABLE `normy_pracy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ocena_jakosci`
--

DROP TABLE IF EXISTS `ocena_jakosci`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ocena_jakosci` (
  `id_ocena_jakosci` int(11) NOT NULL AUTO_INCREMENT,
  `wartosc` smallint(1) DEFAULT NULL,
  `nazwa` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_ocena_jakosci`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ocena_jakosci`
--

LOCK TABLES `ocena_jakosci` WRITE;
/*!40000 ALTER TABLE `ocena_jakosci` DISABLE KEYS */;
INSERT INTO `ocena_jakosci` VALUES (1,1,'test'),(2,1,'test');
/*!40000 ALTER TABLE `ocena_jakosci` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pracownicy`
--

DROP TABLE IF EXISTS `pracownicy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pracownicy` (
  `id_pracownika` int(11) NOT NULL AUTO_INCREMENT,
  `imie` varchar(45) DEFAULT NULL,
  `nazwisko` varchar(45) DEFAULT NULL,
  `stawka_godzinowa` float DEFAULT NULL,
  `brygadzisci_id_brygadzisty` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_pracownika`),
  KEY `fk_pracownicy_brygadzisci1_idx` (`brygadzisci_id_brygadzisty`),
  CONSTRAINT `fk_pracownicy_brygadzisci1` FOREIGN KEY (`brygadzisci_id_brygadzisty`) REFERENCES `brygadzisci` (`id_brygadzisty`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pracownicy`
--

LOCK TABLES `pracownicy` WRITE;
/*!40000 ALTER TABLE `pracownicy` DISABLE KEYS */;
INSERT INTO `pracownicy` VALUES (2,'Patryk','Bąk',20,1),(3,'Patryk','Bąk',20,1);
/*!40000 ALTER TABLE `pracownicy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `raport_dzienny_brygady`
--

DROP TABLE IF EXISTS `raport_dzienny_brygady`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `raport_dzienny_brygady` (
  `id_raport_dzienny_brygady` int(11) NOT NULL AUTO_INCREMENT,
  `uzytkownicy_id_uzytkownika` int(11) DEFAULT NULL,
  `budowa_id_budowy` int(11) DEFAULT NULL,
  `data` date DEFAULT NULL,
  `warunki_pogodowe` varchar(45) DEFAULT NULL,
  `brygadzisci_id_brygadzisty` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_raport_dzienny_brygady`),
  KEY `fk_RaportDziennyBrygady_Uzytkownicy1_idx` (`uzytkownicy_id_uzytkownika`),
  KEY `fk_RaportDziennyBrygady_Budowa1_idx` (`budowa_id_budowy`),
  KEY `fk_RaportDziennyBrygady_Brygadzisci1_idx` (`brygadzisci_id_brygadzisty`),
  CONSTRAINT `fk_RaportDziennyBrygady_Brygadzisci1` FOREIGN KEY (`brygadzisci_id_brygadzisty`) REFERENCES `brygadzisci` (`id_brygadzisty`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_RaportDziennyBrygady_Budowa1` FOREIGN KEY (`budowa_id_budowy`) REFERENCES `budowa` (`id_budowy`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_RaportDziennyBrygady_Uzytkownicy1` FOREIGN KEY (`uzytkownicy_id_uzytkownika`) REFERENCES `uzytkownicy` (`id_uzytkownika`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `raport_dzienny_brygady`
--

LOCK TABLES `raport_dzienny_brygady` WRITE;
/*!40000 ALTER TABLE `raport_dzienny_brygady` DISABLE KEYS */;
INSERT INTO `raport_dzienny_brygady` VALUES (1,1,1,'2012-05-22','deszcz',1),(2,1,1,'2012-05-22','deszcz',1),(3,1,1,'2012-06-22','słonecznie',1);
/*!40000 ALTER TABLE `raport_dzienny_brygady` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `raport_dzienny_pracy_sprzetu`
--

DROP TABLE IF EXISTS `raport_dzienny_pracy_sprzetu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `raport_dzienny_pracy_sprzetu` (
  `id_raportu_dziennego_pracy_sprzetu` int(11) NOT NULL AUTO_INCREMENT,
  `numer_raportu` int(7) DEFAULT NULL,
  `data` date DEFAULT NULL,
  `zadanie` text,
  `warunki_pogodowe` varchar(45) DEFAULT NULL,
  `uwagi` text,
  `maszyny_id_maszyny` int(11) DEFAULT NULL,
  `pracownicy_id_pracownika` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_raportu_dziennego_pracy_sprzetu`),
  KEY `fk_RaportDziennyPracySprzetu_Maszyny1_idx` (`maszyny_id_maszyny`),
  KEY `fk_RaportDziennyPracySprzetu_Pracownicy1_idx` (`pracownicy_id_pracownika`),
  CONSTRAINT `fk_RaportDziennyPracySprzetu_Maszyny1` FOREIGN KEY (`maszyny_id_maszyny`) REFERENCES `maszyny` (`id_maszyny`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_RaportDziennyPracySprzetu_Pracownicy1` FOREIGN KEY (`pracownicy_id_pracownika`) REFERENCES `pracownicy` (`id_pracownika`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `raport_dzienny_pracy_sprzetu`
--

LOCK TABLES `raport_dzienny_pracy_sprzetu` WRITE;
/*!40000 ALTER TABLE `raport_dzienny_pracy_sprzetu` DISABLE KEYS */;
INSERT INTO `raport_dzienny_pracy_sprzetu` VALUES (1,1234567,'2012-05-22','Wykop','deszcz','Zimno, wieje, pada',1,2),(2,1234567,'2012-05-22','Wykop','deszcz','Zimno, wieje, pada',1,2);
/*!40000 ALTER TABLE `raport_dzienny_pracy_sprzetu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reset_token`
--

DROP TABLE IF EXISTS `reset_token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reset_token` (
  `token` varchar(100) NOT NULL,
  `username` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `expiry_date` date DEFAULT NULL,
  PRIMARY KEY (`token`),
  UNIQUE KEY `token_UNIQUE` (`token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reset_token`
--

LOCK TABLES `reset_token` WRITE;
/*!40000 ALTER TABLE `reset_token` DISABLE KEYS */;
INSERT INTO `reset_token` VALUES ('8ac19a10-d4a0-4fd0-bbb5-613a51133cfd','fafqw','grupabrainiac@gmail.com','2020-12-20'),('a5f7a0bc-520f-4d88-95a8-c70144e7e30d','fafqw','grupabrainiac@gmail.com','2020-12-20');
/*!40000 ALTER TABLE `reset_token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roboty`
--

DROP TABLE IF EXISTS `roboty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roboty` (
  `id_roboty` int(11) NOT NULL AUTO_INCREMENT,
  `nazwa_roboty` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_roboty`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roboty`
--

LOCK TABLES `roboty` WRITE;
/*!40000 ALTER TABLE `roboty` DISABLE KEYS */;
INSERT INTO `roboty` VALUES (1,'Ułożenie obrzeży'),(2,'Położenie kostki'),(3,'Ułożenie obrzeży'),(4,'Położenie kostki');
/*!40000 ALTER TABLE `roboty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id_role` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_role`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'ADMIN'),(2,'SUPERVISOR'),(3,'ENGIENEER');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `uprawnienia`
--

DROP TABLE IF EXISTS `uprawnienia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `uprawnienia` (
  `id_uprawnienia` int(11) NOT NULL AUTO_INCREMENT,
  `nazwa` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_uprawnienia`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uprawnienia`
--

LOCK TABLES `uprawnienia` WRITE;
/*!40000 ALTER TABLE `uprawnienia` DISABLE KEYS */;
INSERT INTO `uprawnienia` VALUES (1,'Operator koparki'),(2,'Operator koparki');
/*!40000 ALTER TABLE `uprawnienia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `uprawnienia_pracownikow`
--

DROP TABLE IF EXISTS `uprawnienia_pracownikow`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `uprawnienia_pracownikow` (
  `id_uprawnienia_pracownikow` int(11) NOT NULL AUTO_INCREMENT,
  `pracownicy_id_pracownika` int(11) DEFAULT NULL,
  `uprawnienia_id_uprawnienia` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_uprawnienia_pracownikow`),
  KEY `fk_Pracownicy_has_Uprawnienia_Uprawnienia1_idx` (`uprawnienia_id_uprawnienia`),
  KEY `fk_Pracownicy_has_Uprawnienia_Pracownicy1_idx` (`pracownicy_id_pracownika`),
  CONSTRAINT `fk_Pracownicy_has_Uprawnienia_Pracownicy1` FOREIGN KEY (`pracownicy_id_pracownika`) REFERENCES `pracownicy` (`id_pracownika`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pracownicy_has_Uprawnienia_Uprawnienia1` FOREIGN KEY (`uprawnienia_id_uprawnienia`) REFERENCES `uprawnienia` (`id_uprawnienia`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uprawnienia_pracownikow`
--

LOCK TABLES `uprawnienia_pracownikow` WRITE;
/*!40000 ALTER TABLE `uprawnienia_pracownikow` DISABLE KEYS */;
INSERT INTO `uprawnienia_pracownikow` VALUES (1,2,1),(2,2,1);
/*!40000 ALTER TABLE `uprawnienia_pracownikow` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_role`
--

DROP TABLE IF EXISTS `users_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users_role` (
  `user_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  KEY `user_fk_idx` (`user_id`),
  KEY `role_fk_idx` (`role_id`),
  CONSTRAINT `role_fk` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id_role`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `user_fk` FOREIGN KEY (`user_id`) REFERENCES `uzytkownicy` (`id_uzytkownika`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_role`
--

LOCK TABLES `users_role` WRITE;
/*!40000 ALTER TABLE `users_role` DISABLE KEYS */;
INSERT INTO `users_role` VALUES (10,1),(4,3),(6,2);
/*!40000 ALTER TABLE `users_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `uzytkownicy`
--

DROP TABLE IF EXISTS `uzytkownicy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `uzytkownicy` (
  `id_uzytkownika` int(11) NOT NULL AUTO_INCREMENT,
  `imie` varchar(45) DEFAULT NULL,
  `nazwisko` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `login` varchar(45) DEFAULT NULL,
  `haslo` varchar(60) DEFAULT NULL,
  `numer_telefonu` varchar(45) DEFAULT NULL,
  `czy_kierownik` tinyint(2) DEFAULT NULL,
  PRIMARY KEY (`id_uzytkownika`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uzytkownicy`
--

LOCK TABLES `uzytkownicy` WRITE;
/*!40000 ALTER TABLE `uzytkownicy` DISABLE KEYS */;
INSERT INTO `uzytkownicy` VALUES (1,'Patryk','Bak','pffasfas@gmail.com','patbak','7548454','8124758456',1),(4,'Papryk','Bak','papryk@gmail.com','szpakbak','$2a$10$AMdsgKBIe7YBWt0un2LRvOcBq1Tj3uNv2mg/Z/WpLFyPjvj0gKAVq','87854874',1),(6,'Cezary','Czwórnóg','cezary@gmail.com','CC','$2a$10$7YBNlpNvDLK/c2CzfsXB/umrsxp3TI/8bEysg/Rw7A1JbhFrRf1Ea','785412369',1),(7,'Adrian','Kubiś','adrian@gmail.com','AK','$2a$10$7zySLBnr/Q6ZYuuRb.SCz.C3xZiIiV1eNIMHaKvrl1uiL3AjpYKvS','854712369',1),(10,'Papryk','Bak','grupabrainiac@gmail.com','fafqw','$2a$10$HGTsfAGKNBoJNbH3TfZ2yeVtwF0ipd8EGOyEeyIS6IqJeqg1.Mi1S','87854874',1);
/*!40000 ALTER TABLE `uzytkownicy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `verification_token`
--

DROP TABLE IF EXISTS `verification_token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `verification_token` (
  `token` varchar(100) NOT NULL,
  `username` varchar(45) DEFAULT NULL,
  `expiry_date` date DEFAULT NULL,
  PRIMARY KEY (`token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `verification_token`
--

LOCK TABLES `verification_token` WRITE;
/*!40000 ALTER TABLE `verification_token` DISABLE KEYS */;
INSERT INTO `verification_token` VALUES ('a3e5e769-69b7-4e1e-8852-bdd85b3dc3e2','fafqw','2020-12-20');
/*!40000 ALTER TABLE `verification_token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wykonane_roboty`
--

DROP TABLE IF EXISTS `wykonane_roboty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wykonane_roboty` (
  `id_wykonanej_roboty` int(11) NOT NULL AUTO_INCREMENT,
  `nazwa_wykonanej_roboty` varchar(45) DEFAULT NULL,
  `ilosc_robot` float DEFAULT NULL,
  `raport_dzienny_brygady_id_raport_dzienny_brygady` int(11) DEFAULT NULL,
  `normy_pracy_id_normy_pracy` int(11) DEFAULT NULL,
  `ocena_jakosci_id_ocena_jakosci` int(11) DEFAULT NULL,
  `roboty_id_roboty` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_wykonanej_roboty`),
  KEY `fk_RaportDziennyBrygady_has_NormyPracy_NormyPracy1_idx` (`normy_pracy_id_normy_pracy`),
  KEY `fk_RaportDziennyBrygady_has_NormyPracy_RaportDziennyBrygady_idx` (`raport_dzienny_brygady_id_raport_dzienny_brygady`),
  KEY `fk_Roboty_OcenaJakosci1_idx` (`ocena_jakosci_id_ocena_jakosci`),
  KEY `fk_wykonane_roboty_roboty1_idx` (`roboty_id_roboty`),
  CONSTRAINT `fk_RaportDziennyBrygady_has_NormyPracy_NormyPracy1` FOREIGN KEY (`normy_pracy_id_normy_pracy`) REFERENCES `normy_pracy` (`id_normy_pracy`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_RaportDziennyBrygady_has_NormyPracy_RaportDziennyBrygady1` FOREIGN KEY (`raport_dzienny_brygady_id_raport_dzienny_brygady`) REFERENCES `raport_dzienny_brygady` (`id_raport_dzienny_brygady`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Roboty_OcenaJakosci1` FOREIGN KEY (`ocena_jakosci_id_ocena_jakosci`) REFERENCES `ocena_jakosci` (`id_ocena_jakosci`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_wykonane_roboty_roboty1` FOREIGN KEY (`roboty_id_roboty`) REFERENCES `roboty` (`id_roboty`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wykonane_roboty`
--

LOCK TABLES `wykonane_roboty` WRITE;
/*!40000 ALTER TABLE `wykonane_roboty` DISABLE KEYS */;
INSERT INTO `wykonane_roboty` VALUES (1,'Ułożenie kostki',10,1,1,1,1),(2,'Ułożenie kostki',10,1,1,1,1);
/*!40000 ALTER TABLE `wykonane_roboty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zuzyte_materialy`
--

DROP TABLE IF EXISTS `zuzyte_materialy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `zuzyte_materialy` (
  `id_zuzytego_materialu` int(11) NOT NULL AUTO_INCREMENT,
  `raport_dzienny_brygady_id_raport_dzienny_brygady` int(11) DEFAULT NULL,
  `materialy_id_materialu` int(11) DEFAULT NULL,
  `ilosc` float DEFAULT NULL,
  PRIMARY KEY (`id_zuzytego_materialu`),
  KEY `fk_RaportDziennyBrygady_has_Materialy_Materialy1_idx` (`materialy_id_materialu`),
  KEY `fk_RaportDziennyBrygady_has_Materialy_RaportDziennyBrygady1_idx` (`raport_dzienny_brygady_id_raport_dzienny_brygady`),
  CONSTRAINT `fk_RaportDziennyBrygady_has_Materialy_Materialy1` FOREIGN KEY (`materialy_id_materialu`) REFERENCES `materialy` (`id_materialu`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_RaportDziennyBrygady_has_Materialy_RaportDziennyBrygady1` FOREIGN KEY (`raport_dzienny_brygady_id_raport_dzienny_brygady`) REFERENCES `raport_dzienny_brygady` (`id_raport_dzienny_brygady`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zuzyte_materialy`
--

LOCK TABLES `zuzyte_materialy` WRITE;
/*!40000 ALTER TABLE `zuzyte_materialy` DISABLE KEYS */;
INSERT INTO `zuzyte_materialy` VALUES (1,1,1,50),(2,1,1,50);
/*!40000 ALTER TABLE `zuzyte_materialy` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-18 11:13:35

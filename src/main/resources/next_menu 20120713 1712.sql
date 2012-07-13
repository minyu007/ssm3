-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.25


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema next_menu
--

CREATE DATABASE IF NOT EXISTS next_menu;
USE next_menu;

--
-- Definition of table `ac`
--

DROP TABLE IF EXISTS `ac`;
CREATE TABLE `ac` (
  `ac001` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `ac002` varchar(16) NOT NULL COMMENT 'username',
  `ac003` varchar(16) NOT NULL COMMENT 'password',
  `ac004` varchar(3) NOT NULL COMMENT 'role',
  `ac005` varchar(3) NOT NULL COMMENT 'status',
  `ac100` varchar(45) NOT NULL COMMENT 'sysdate',
  `ac200` varchar(45) NOT NULL COMMENT 'sysuser',
  PRIMARY KEY (`ac001`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='account';

--
-- Dumping data for table `ac`
--

/*!40000 ALTER TABLE `ac` DISABLE KEYS */;
/*!40000 ALTER TABLE `ac` ENABLE KEYS */;


--
-- Definition of table `cd`
--

DROP TABLE IF EXISTS `cd`;
CREATE TABLE `cd` (
  `cd001` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `cd002` varchar(45) NOT NULL COMMENT 'code',
  `cd003` varchar(45) NOT NULL COMMENT 'codename',
  `cd004` varchar(45) NOT NULL COMMENT 'codetext',
  `cd100` varchar(45) NOT NULL COMMENT 'sysdate',
  `cd200` varchar(45) NOT NULL COMMENT 'sysuser',
  PRIMARY KEY (`cd001`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='code';

--
-- Dumping data for table `cd`
--

/*!40000 ALTER TABLE `cd` DISABLE KEYS */;
/*!40000 ALTER TABLE `cd` ENABLE KEYS */;


--
-- Definition of table `dh`
--

DROP TABLE IF EXISTS `dh`;
CREATE TABLE `dh` (
  `dh001` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `dh002` varchar(100) NOT NULL COMMENT 'name',
  `dh003` varchar(45) NOT NULL COMMENT 'taste',
  `dh004` varchar(45) NOT NULL COMMENT 'type',
  `dh005` varchar(260) NOT NULL COMMENT 'image_icon',
  `dh006` varchar(260) NOT NULL COMMENT 'image_small',
  `dh007` varchar(260) NOT NULL COMMENT 'image_big',
  `dh008` varchar(45) NOT NULL COMMENT 'price',
  `dh009` varchar(45) NOT NULL COMMENT 'star',
  `dh010` varchar(45) NOT NULL COMMENT 'special_flg',
  `dh100` varchar(45) NOT NULL COMMENT 'sysdate',
  `dh200` varchar(45) NOT NULL COMMENT 'sysuser',
  `dh011` varchar(3) NOT NULL COMMENT 'isSale',
  `dh012` varchar(45) NOT NULL COMMENT 'sale',
  `dh013` varchar(45) NOT NULL COMMENT 'number',
  `dh014` varchar(45) NOT NULL COMMENT 'cost_price',
  PRIMARY KEY (`dh001`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='dish';

--
-- Dumping data for table `dh`
--

/*!40000 ALTER TABLE `dh` DISABLE KEYS */;
/*!40000 ALTER TABLE `dh` ENABLE KEYS */;


--
-- Definition of table `od`
--

DROP TABLE IF EXISTS `od`;
CREATE TABLE `od` (
  `od001` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `od002` varchar(45) NOT NULL COMMENT 'oder_no',
  `od003` varchar(45) NOT NULL COMMENT 'start_time',
  `od004` varchar(45) NOT NULL COMMENT 'end_time',
  `od005` varchar(10) NOT NULL COMMENT 'status',
  `od006` varchar(10) NOT NULL COMMENT 'table_id',
  `od007` varchar(300) NOT NULL COMMENT 'note',
  `od008` varchar(11) NOT NULL COMMENT 'client_count',
  `od009` varchar(45) NOT NULL COMMENT 'actual_price',
  `od010` varchar(500) NOT NULL COMMENT 'dish_ids',
  `od100` varchar(45) NOT NULL COMMENT 'sysdate',
  `od200` varchar(45) NOT NULL COMMENT 'sysuser',
  PRIMARY KEY (`od001`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='order';

--
-- Dumping data for table `od`
--

/*!40000 ALTER TABLE `od` DISABLE KEYS */;
/*!40000 ALTER TABLE `od` ENABLE KEYS */;


--
-- Definition of table `tb`
--

DROP TABLE IF EXISTS `tb`;
CREATE TABLE `tb` (
  `tb001` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `tb002` varchar(45) NOT NULL COMMENT 'name',
  `tb003` varchar(45) NOT NULL COMMENT 'type',
  `tb100` varchar(45) NOT NULL COMMENT 'sysdate',
  `tb200` varchar(45) NOT NULL COMMENT 'sysuser',
  `tb004` varchar(3) NOT NULL COMMENT 'status',
  PRIMARY KEY (`tb001`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='table';

--
-- Dumping data for table `tb`
--

/*!40000 ALTER TABLE `tb` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb` ENABLE KEYS */;


--
-- Definition of table `ur`
--

DROP TABLE IF EXISTS `ur`;
CREATE TABLE `ur` (
  `ur001` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `ur002` varchar(50) DEFAULT NULL COMMENT 'card_id',
  `ur003` varchar(20) NOT NULL COMMENT 'username',
  `ur004` varchar(20) NOT NULL COMMENT 'password',
  `ur005` varchar(20) DEFAULT NULL COMMENT 'phone',
  `ur006` varchar(100) DEFAULT NULL COMMENT 'email',
  `ur007` varchar(10) DEFAULT NULL COMMENT 'birthday',
  `ur008` varchar(200) DEFAULT NULL COMMENT 'address',
  `ur009` varchar(3) NOT NULL COMMENT 'role',
  `ur100` varchar(45) NOT NULL COMMENT 'sysdate',
  `ur200` varchar(45) NOT NULL COMMENT 'sysuser',
  PRIMARY KEY (`ur001`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户';

--
-- Dumping data for table `ur`
--

/*!40000 ALTER TABLE `ur` DISABLE KEYS */;
/*!40000 ALTER TABLE `ur` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

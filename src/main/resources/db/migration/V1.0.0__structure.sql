
CREATE DATABASE daoormcqrs;
USE daoormcqrs;


DROP TABLE IF EXISTS `editor`;
CREATE TABLE IF NOT EXISTS `editor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `book`;
CREATE TABLE IF NOT EXISTS `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(25) NOT NULL,
  `id_Editor` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Book_id_Editor` (`id_Editor`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `bookitem`;
CREATE TABLE IF NOT EXISTS `bookitem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `itemCode` varchar(25) NOT NULL,
  `id_Book` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_BookItem_id_Book` (`id_Book`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `borrow`;
CREATE TABLE IF NOT EXISTS `borrow` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `borrowerName` varchar(25) NOT NULL,
  `borrowStart` datetime NOT NULL,
  `borrowEnd` datetime DEFAULT NULL,
  `borrowed` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Borrow_borrowed` (`borrowed`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;




ALTER TABLE `book`
  ADD CONSTRAINT `FK_Book_id_Editor` FOREIGN KEY (`id_Editor`) REFERENCES `editor` (`id`);

ALTER TABLE `bookitem`
  ADD CONSTRAINT `FK_BookItem_id_Book` FOREIGN KEY (`id_Book`) REFERENCES `book` (`id`);


ALTER TABLE `borrow`
  ADD CONSTRAINT `FK_Borrow_borrowed` FOREIGN KEY (`borrowed`) REFERENCES `bookitem` (`id`);


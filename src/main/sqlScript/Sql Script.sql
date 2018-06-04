DROP DATABASE IF EXISTS `car_catalog`;
CREATE DATABASE IF NOT EXISTS `car_catalog`;
USE `car_catalog`;

DROP TABLE IF EXISTS `brands_car`;
CREATE TABLE IF NOT EXISTS `brands_car` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `brand` varchar(50) NOT NULL,
  `image` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `brand_UNIQUE` (`brand`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `cars`;
CREATE TABLE IF NOT EXISTS `cars` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `modelID` int(11) NOT NULL DEFAULT '0',
  `year` int(11) DEFAULT NULL,
  `bodyType` varchar(50) DEFAULT NULL,
  `length` int(11) DEFAULT NULL,
  `width` int(11) DEFAULT NULL,
  `height` int(11) DEFAULT NULL,
  `base` int(11) DEFAULT NULL,
  `numberOfDoors` int(11) DEFAULT NULL,
  `clearance` int(11) DEFAULT NULL,
  `trunk` int(11) DEFAULT NULL,
  `volumeOfTheTank` int(11) DEFAULT NULL,
  `numberOfPlaces` int(11) DEFAULT NULL,
  `price` int(11) DEFAULT '0',
  `image` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`,`modelID`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `modelID` (`modelID`),
  KEY `fk_cars_brand_idx` (`modelID`),
  CONSTRAINT `fk_cars_model` FOREIGN KEY (`modelID`) REFERENCES `models_car` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `favorites`;
CREATE TABLE IF NOT EXISTS `favorites` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userID` int(11) NOT NULL DEFAULT '0',
  `carID` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`,`userID`,`carID`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_favorites_user` (`userID`),
  KEY `fk_favorites_car` (`carID`),
  CONSTRAINT `fk_favorites_car` FOREIGN KEY (`carID`) REFERENCES `cars` (`id`),
  CONSTRAINT `fk_favorites_user` FOREIGN KEY (`userID`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `models_car`;
CREATE TABLE IF NOT EXISTS `models_car` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `brandID` int(11) NOT NULL DEFAULT '0',
  `model` varchar(50) NOT NULL,
  `image` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`,`brandID`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_models_brands` (`brandID`),
  CONSTRAINT `fk_models_brands` FOREIGN KEY (`brandID`) REFERENCES `brands_car` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `roles`;
CREATE TABLE IF NOT EXISTS `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `role_UNIQUE` (`role`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(128) NOT NULL,
  `salt` varchar(128) NOT NULL,
  `roleID` int(11) NOT NULL,
  PRIMARY KEY (`id`,`roleID`),
  UNIQUE KEY `login` (`login`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_users_roles_idx` (`roleID`),
  CONSTRAINT `fk_users_roles` FOREIGN KEY (`roleID`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
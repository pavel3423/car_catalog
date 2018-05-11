-- Дамп структуры базы данных car_catalog
DROP DATABASE IF EXISTS `car_catalog`;
CREATE DATABASE IF NOT EXISTS `car_catalog` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `car_catalog`;

-- Дамп структуры для таблица car_catalog.brands_car
DROP TABLE IF EXISTS `brands_car`;
CREATE TABLE IF NOT EXISTS `brands_car` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `brand` varchar(50) NOT NULL,
  `image` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `brand_UNIQUE` (`brand`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- Дамп структуры для таблица car_catalog.cars
DROP TABLE IF EXISTS `cars`;
CREATE TABLE IF NOT EXISTS `cars` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `brandID` int(11) NOT NULL DEFAULT '0',
  `modelID` int(11) NOT NULL DEFAULT '0',
  `carClass` varchar(50) NOT NULL DEFAULT '0',
  `equipment` varchar(50) NOT NULL,
  `price` int(11) NOT NULL DEFAULT '0',
  `image` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`,`modelID`,`brandID`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_cars_brand_idx` (`modelID`),
  KEY `fk_cars_brand` (`brandID`),
  CONSTRAINT `fk_cars_brand` FOREIGN KEY (`brandID`) REFERENCES `models_car` (`brandID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_cars_model` FOREIGN KEY (`modelID`) REFERENCES `models_car` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Дамп структуры для таблица car_catalog.favorites
DROP TABLE IF EXISTS `favorites`;
CREATE TABLE IF NOT EXISTS `favorites` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userID` int(11) NOT NULL DEFAULT '0',
  `carID` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`,`userID`,`carID`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_favorites_user` (`userID`),
  KEY `fk_favorites_car` (`carID`),
  CONSTRAINT `fk_favorites_car` FOREIGN KEY (`carID`) REFERENCES `cars` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_favorites_user` FOREIGN KEY (`userID`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп структуры для таблица car_catalog.models_car
DROP TABLE IF EXISTS `models_car`;
CREATE TABLE IF NOT EXISTS `models_car` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `brandID` int(11) NOT NULL DEFAULT '0',
  `model` varchar(50) NOT NULL,
  `image` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`,`brandID`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `model_UNIQUE` (`model`),
  KEY `fk_models_brands` (`brandID`),
  CONSTRAINT `fk_models_brands` FOREIGN KEY (`brandID`) REFERENCES `brands_car` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- Дамп структуры для таблица car_catalog.roles
DROP TABLE IF EXISTS `roles`;
CREATE TABLE IF NOT EXISTS `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `role_UNIQUE` (`role`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Дамп структуры для таблица car_catalog.users
DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `roleID` int(11) NOT NULL,
  PRIMARY KEY (`id`,`roleID`),
  UNIQUE KEY `login` (`login`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_users_roles_idx` (`roleID`),
  CONSTRAINT `fk_users_roles` FOREIGN KEY (`roleID`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

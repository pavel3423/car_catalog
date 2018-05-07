-- Дамп данных таблицы car_catalog.brands_car: ~9 rows (приблизительно)
DELETE FROM `brands_car`;
/*!40000 ALTER TABLE `brands_car` DISABLE KEYS */;
INSERT INTO `brands_car` (`id`, `brand`) VALUES
	(1, 'Audi'),
	(2, 'BMW'),
	(3, 'Chevrolet'),
	(4, 'Citroen'),
	(5, 'Ford'),
	(6, 'Geely'),
	(7, 'Honda\r\n'),
	(8, 'Hyundai'),
	(9, 'KIA');
/*!40000 ALTER TABLE `brands_car` ENABLE KEYS */;

-- Дамп данных таблицы car_catalog.cars: ~0 rows (приблизительно)
DELETE FROM `cars`;
/*!40000 ALTER TABLE `cars` DISABLE KEYS */;
/*!40000 ALTER TABLE `cars` ENABLE KEYS */;

-- Дамп данных таблицы car_catalog.favorites: ~0 rows (приблизительно)
DELETE FROM `favorites`;
/*!40000 ALTER TABLE `favorites` DISABLE KEYS */;
/*!40000 ALTER TABLE `favorites` ENABLE KEYS */;

-- Дамп данных таблицы car_catalog.models_car: ~9 rows (приблизительно)
DELETE FROM `models_car`;
/*!40000 ALTER TABLE `models_car` DISABLE KEYS */;
INSERT INTO `models_car` (`id`, `brandID`, `model`) VALUES
	(1, 1, 'A3 Sportback'),
	(2, 1, 'A4 седан'),
	(3, 1, 'A4 универсал'),
	(4, 2, '3 серия седан'),
	(5, 2, '5 серия седан'),
	(6, 2, 'M5 седан'),
	(7, 3, 'Cruze седан'),
	(8, 3, 'Captiva'),
	(9, 3, 'Orlando');
/*!40000 ALTER TABLE `models_car` ENABLE KEYS */;

-- Дамп данных таблицы car_catalog.roles: ~2 rows (приблизительно)
DELETE FROM `roles`;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` (`id`, `role`) VALUES
	(1, 'admin'),
	(2, 'user');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;

-- Дамп данных таблицы car_catalog.users: ~3 rows (приблизительно)
DELETE FROM `users`;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `login`, `email`, `password`, `roleID`) VALUES
	(1, 'admin', 'admin@gmail.com', 'admin', 1),
	(2, 'user', 'user@gmail.com', 'user', 2);
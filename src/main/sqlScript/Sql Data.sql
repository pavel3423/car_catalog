-- ���� ������ ������� car_catalog.brands_car
DELETE FROM `brands_car`;

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

-- ���� ������ ������� car_catalog.cars
DELETE FROM `cars`;

-- ���� ������ ������� car_catalog.favorites
DELETE FROM `favorites`;

-- ���� ������ ������� car_catalog.models_car
DELETE FROM `models_car`;

INSERT INTO `models_car` (`id`, `brandID`, `model`) VALUES
	(1, 1, 'A3 Sportback'),
	(2, 1, 'A4 �����'),
	(3, 1, 'A4 ���������'),
	(4, 2, '3 ����� �����'),
	(5, 2, '5 ����� �����'),
	(6, 2, 'M5 �����'),
	(7, 3, 'Cruze �����'),
	(8, 3, 'Captiva'),
	(9, 3, 'Orlando');


-- ���� ������ ������� car_catalog.roles
DELETE FROM `roles`;

INSERT INTO `roles` (`id`, `role`) VALUES
	(1, 'admin'),
	(2, 'user');


-- ���� ������ ������� car_catalog.users
DELETE FROM `users`;

INSERT INTO `users` (`id`, `login`, `email`, `password`, `roleID`) VALUES
	(1, 'admin', 'admin@gmail.com', 'admin', 1),
	(2, 'user', 'user@gmail.com', 'user', 2);
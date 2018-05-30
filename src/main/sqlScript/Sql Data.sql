DELETE FROM `brands_car`;
INSERT INTO `brands_car` (`id`, `brand`, `image`) VALUES
	(1, 'Audi', '4605727978081008796.png'),
	(2, 'BMW', '4604992479699423426.png'),
	(3, 'Chevrolet', '4593332895308837144.png'),
	(4, 'Citroen', '4606281305435845505.png'),
	(5, 'Ford', '4607097710140788652.png'),
	(6, 'Geely', '4606728059635531577.png'),
	(7, 'Honda', '4604633438716823481.png'),
	(8, 'Hyundai', '4606707737298982482.png'),
	(9, 'KIA', '4604806751984005397.png');

DELETE FROM `cars`;
INSERT INTO `cars` (`id`, `brandID`, `modelID`, `year`, `bodyType`, `length`, `width`, `height`, `base`, `numberOfDoors`, `clearance`, `trunk`, `volumeOfTheTank`, `numberOfPlaces`, `price`, `image`) VALUES
	(1, 1, 1, 2018, 'Cabriolet', 4423, 1960, 1409, 2595, 2, 143, 320, 50, 4, 38350, '4604146090555141186.webp'),
	(2, 1, 2, 2018, 'Sedan', 4458, 1960, 1416, 2637, 4, 143, 425, 50, 5, 31950, '4604486121083579146.webp'),
	(3, 1, 3, 2018, 'Sedan', 4479, 1960, 1399, 2631, 4, 143, 315, 55, 5, 54900, '4603040000795831356.webp'),
	(4, 1, 4, 2018, 'SUV', 5052, 2212, 1741, 2994, 5, 235, 1062, 85, 5, 49900, '4605448444242340233.webp'),
	(5, 2, 5, 2018, 'Sedan', 4624, 1811, 1429, 2810, 4, 140, 480, 60, 5, 38350, '4576812483198628096.jpg'),
	(6, 2, 6, 2018, 'Сrossover', 4886, 1938, 1762, 2933, 5, 209, 650, 85, 5, 63750, '4596659161498602028.jpg');

DELETE FROM `favorites`;

DELETE FROM `models_car`;
INSERT INTO `models_car` (`id`, `brandID`, `model`, `image`) VALUES
	(1, 1, 'A3 Cabriolet', '4605488776050949507.png'),
	(2, 1, 'A3 Sedan', '4603494030815561109.png'),
	(3, 1, 'RS 3 Sedan', '4589127598135334832.png'),
	(4, 1, 'Q7', '4604334834274865651.png'),
	(5, 2, '3 series', '4600559156716143948.png'),
	(6, 2, 'X5', '4604290594292120066.png');


DELETE FROM `roles`;
INSERT INTO `roles` (`id`, `role`) VALUES
	(1, 'admin'),
	(3, 'moderator'),
	(2, 'user');

DELETE FROM `users`;
INSERT INTO `users` (`id`, `login`, `email`, `password`, `roleID`) VALUES
	(1, 'admin', 'admin@gmail.com', 'admin', 1),
	(2, 'user', 'user@gmail.comm', '', 2),
	(3, 'moderator', 'moderator', 'moderator', 3);
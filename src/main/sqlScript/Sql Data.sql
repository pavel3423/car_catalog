DELETE FROM `brands_car`;
INSERT INTO `brands_car` (`id`, `brand`, `image`) VALUES
	(1, 'Audi', '4605727978081008796.png'),
	(2, 'BMW', '4604992479699423426.png'),
	(3, 'Chevrolet', '4604277868982602791.png'),
	(4, 'Citroen', '4606281305435845505.png'),
	(5, 'Ford', '4607097710140788652.png'),
	(6, 'Geely', '4606728059635531577.png'),
	(7, 'Honda', '4604633438716823481.png'),
	(8, 'Hyundai', '4606707737298982482.png'),
	(9, 'KIA', '4604806751984005397.png');
	
DELETE FROM `cars`;
INSERT INTO `cars` (`id`, `modelID`, `year`, `bodyType`, `length`, `width`, `height`, `base`, `numberOfDoors`, `clearance`, `trunk`, `volumeOfTheTank`, `numberOfPlaces`, `price`, `image`) VALUES
	(1, 1, 2018, 'Cabriolet', 4423, 1960, 1409, 2595, 2, 143, 320, 50, 4, 38350, '4604146090555141186.webp'),
	(2, 2, 2018, 'Sedan', 4458, 1960, 1416, 2637, 4, 143, 425, 50, 5, 31950, '4604486121083579146.webp'),
	(3, 3, 2018, 'Sedan', 4479, 1960, 1399, 2631, 4, 143, 315, 55, 5, 54900, '4603040000795831356.webp'),
	(4, 4, 2018, 'SUV', 5052, 2212, 1741, 2994, 5, 235, 1062, 85, 5, 49900, '4605448444242340233.webp'),
	(5, 5, 2018, 'Sedan', 4624, 1811, 1429, 2810, 4, 140, 480, 60, 5, 38350, '4576812483198628096.jpg'),
	(6, 6, 2018, 'Сrossover', 4886, 1938, 1762, 2933, 5, 209, 650, 85, 5, 63750, '4596659161498602028.jpg');

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
INSERT INTO `users` (`id`, `login`, `email`, `password`, `salt`, `roleID`) VALUES
	(1, 'admin', 'admin@admin.com', 'afGE+NeY5CckOwPuZRQkdCDeNalTCuUQXBy5YgdiZWB60RV80ze8sea/do88FWuM8ifQrDVW14cFJ7DOkSAHvtmDlw0UrGmENDQkPE9fudo=', 'c15ac68b4cf1ba92d0aeb18b67f2da46e49ee1f64daee65f13050e05f69933b648c099190e905af719ff258ef2d356d0878d9e2bdedf8e7b047036fe9df196f2', 1),
	(2, 'moderator', 'moderator@moderator.com', 'DQe+6/wpQIZXeZi2WjoJXm+Lw5D+CNrH2Yp8oxBYnoH6n5cjLwzkr2LYKOfIlPM3aiuBszQeYkHNsr60mSWD0T+Kh1T3AK1OVXfY1+TcbLY=', 'dbeb038d2b1afc8b6a1dfbfa78d8f398112e6793d04d93124af1fb78c1f3a94d721642069bc8766dc0c895e0d6f4b5cf648214effb63b0a02ad1eb311274e8f8', 3),
	(3, 'user', 'user@user.com', '+173gHgReQXV/k2CGkMv2754pEV6+IEP0irjM+ZiJ+801gg6mxiL28sOMU/LoxUVqGcdoSmVYYORtGuPER1t/V6EfBH55MuMX09mPhthw+A=', '791cf3cd17e855b63c2a3a10a1decd96e5861f038544e28e154c3d00ba534ffb8bd22f6ca2cabca8f4df1e765c311775546df1705761bbd260fbf089182ca8d2', 2);
-- Дамп данных таблицы car_catalog.brands_car: ~9 rows (приблизительно)
DELETE FROM `brands_car`;
INSERT INTO `brands_car` (`id`, `brand`, `image`) VALUES
	(1, 'Audi', 'https://downloader.disk.yandex.ru/disk/53be5c05c7a4946dc539b8c7997057653a8b556885b73f6965be3833d73368fb/5af5f2db/sE0R_869eXTIGkZ6mn7t6Q89QgFVXR_UtQNoz-1Ed46wSHCULiEfhpPHId0aiqVEB4pdZQeEEFGPFhlkIsTetg%3D%3D?uid=0&filename=Audi_logo.png&disposition=inline&hash=&limit=0&content_type=image%2Fpng&fsize=36429&hid=73a3c980cba7dbcbfa93a190155cb712&media_type=image&tknv=v2&etag=76bdaca0377b70d0034f5f250ebc195d'),
	(2, 'BMW', 'https://downloader.disk.yandex.ru/disk/119f5e13e4e042c87c806497eea0268c393e2a38a1ab67d29ea4a7ae40bf4c4e/5af5f4a2/sE0R_869eXTIGkZ6mn7t6bDJFrqFbtgf6dVxNYJq8ulKJVKXcFVo4N7boQjYqGI4kh2KLrBtJFq1AaidX_yoBw%3D%3D?uid=0&filename=BMW_logo.png&disposition=inline&hash=&limit=0&content_type=image%2Fpng&fsize=56564&hid=1ffc4d13c1125b0812fca7b7bc1a4f51&media_type=image&tknv=v2&etag=00e415ae70d98aaf0d46b86457f95747'),
	(3, 'Chevrolet', 'https://downloader.disk.yandex.ru/disk/7c191067e4f4cc252f019f016bfcf1ec46a998403db58df8eafc040df22ea3ca/5af5f4c7/sE0R_869eXTIGkZ6mn7t6SbO1o9PjebXW6DVOOopMxJirbkUhWEsmnYKhdqjKnwWg-5BrlfMbEp4DCaWPl-7wQ%3D%3D?uid=0&filename=Chevrolet_logo.png&disposition=inline&hash=&limit=0&content_type=image%2Fpng&fsize=38679&hid=7c2e77461942c6ac9c2a755b3a635cb2&media_type=image&tknv=v2&etag=ea8a3029818690006452529457420c02'),
	(4, 'Citroen', 'https://downloader.disk.yandex.ru/disk/12ed5b682d1e7dfa9220d54ce94cca381bf9129a1e480767125111a971c9c1fc/5af5f4fa/sE0R_869eXTIGkZ6mn7t6aZ2ozIhm09lO1nJqLCiwKUkVhP7kA6gtbQ3Hf-Lu5xcQrXxZ69apk6SBKYzxEwfPQ%3D%3D?uid=0&filename=Citroen_logo.png&disposition=inline&hash=&limit=0&content_type=image%2Fpng&fsize=36613&hid=c9d5b96d86f2ed5341ca145eb77a22d9&media_type=image&tknv=v2&etag=d467806e46bd0bcad6176cbad993ef64'),
	(5, 'Ford', 'https://downloader.disk.yandex.ru/disk/f91a961ef2401b44644765fe9394e48ea4eeedb2386a8a004c2b05e3a21c50c6/5af5f534/sE0R_869eXTIGkZ6mn7t6eslYC2ugrdaPYuLbIEcKKuajUN8wQ9mTOGcSyky1L0qivBmhSUFj7REnskejuZLoQ%3D%3D?uid=0&filename=Ford_logo.png&disposition=inline&hash=&limit=0&content_type=image%2Fpng&fsize=38266&hid=d19d4e9edbd16dbf961e491c5dd856a2&media_type=image&tknv=v2&etag=01e978c4a35bc82ae5c7c94c3da3f352'),
	(6, 'Geely', 'https://downloader.disk.yandex.ru/disk/ca423f947e8c265143f63da45d17b207232fa0d74b676036d9b3b400bf22be53/5af5f53a/sE0R_869eXTIGkZ6mn7t6Q_Mid1BE8x_ZLpYfa0XS_vwt1yP2qEItnmHQ0qr3dxDO_s5W-ZxBhb-YOs1WNkXpg%3D%3D?uid=0&filename=Geely_logo.png&disposition=inline&hash=&limit=0&content_type=image%2Fpng&fsize=74724&hid=3c23a3dcdf43a34b2c2f49bab917fba6&media_type=image&tknv=v2&etag=5f1cb7770114acaf18a4069512219ab1'),
	(7, 'Honda\r\n', 'https://downloader.disk.yandex.ru/disk/d94b2ca50736f23a6ae10f30ee2acf9d98538c96caec58f1527c99ff02078dde/5af5f55b/sE0R_869eXTIGkZ6mn7t6TID4GY4EAeD9-5cwH4asLvvh0H2Nd10erIKWYbRpkJcxgQ7kO_WF7t1rWpR7lG3wA%3D%3D?uid=0&filename=Honda_logo.png&disposition=inline&hash=&limit=0&content_type=image%2Fpng&fsize=21832&hid=697a8397f9cb09a029f91a7d9741722a&media_type=image&tknv=v2&etag=284609f54eee40082dad7974c0f342bf'),
	(8, 'Hyundai', 'https://downloader.disk.yandex.ru/disk/593c464765380658bc41210faa09d2688897df8dafdbc8150c0f36d21a28f65c/5af5f550/sE0R_869eXTIGkZ6mn7t6Sceo-prBxUwb1DFi7xp34gTEEy3O8_rSK30hIvCJcLXL-3V1hSq5nIjgA1c87ABYg%3D%3D?uid=0&filename=Hyundai_logo.png&disposition=inline&hash=&limit=0&content_type=image%2Fpng&fsize=19693&hid=a915d65907d4493a227eea1e53968a96&media_type=image&tknv=v2&etag=3a7fe40e75c165262628856320ace412'),
	(9, 'KIA', 'https://downloader.disk.yandex.ru/disk/991d61c70bd9c3c90bd94e3cb070245117861d66c83b47576deefc7654439272/5af5f565/sE0R_869eXTIGkZ6mn7t6Sza1Hu5LaY_tCvCQn323vrOU-zYPbs3E41GQ9YfgYqoLoBLz2_2y-3PcIvx6G9e7w%3D%3D?uid=0&filename=KIA_logo.png&disposition=inline&hash=&limit=0&content_type=image%2Fpng&fsize=32953&hid=3d712ea50fafcbe0809e4de96b788b4f&media_type=image&tknv=v2&etag=b91609dd84902325c9869f10824b322e');

-- Дамп данных таблицы car_catalog.cars: ~1 rows (приблизительно)
DELETE FROM `cars`;
INSERT INTO `cars` (`id`, `brandID`, `modelID`, `carClass`, `equipment`, `price`, `image`) VALUES
	(1, 1, 1, 'Седан', 'Lux', 2525, NULL);

-- Дамп данных таблицы car_catalog.favorites: ~0 rows (приблизительно)
DELETE FROM `favorites`;

-- Дамп данных таблицы car_catalog.models_car: ~7 rows (приблизительно)
DELETE FROM `models_car`;
INSERT INTO `models_car` (`id`, `brandID`, `model`, `image`) VALUES
	(1, 1, 'A3 Sportback', 'https://downloader.disk.yandex.ru/disk/53be5c05c7a4946dc539b8c7997057653a8b556885b73f6965be3833d73368fb/5af5f2db/sE0R_869eXTIGkZ6mn7t6Q89QgFVXR_UtQNoz-1Ed46wSHCULiEfhpPHId0aiqVEB4pdZQeEEFGPFhlkIsTetg%3D%3D?uid=0&filename=Audi_logo.png&disposition=inline&hash=&limit=0&content_type=image%2Fpng&fsize=36429&hid=73a3c980cba7dbcbfa93a190155cb712&media_type=image&tknv=v2&etag=76bdaca0377b70d0034f5f250ebc195d'),
	(2, 1, 'A4 седан', NULL),
	(3, 1, 'A4 универсал', NULL),
	(4, 2, '3 серия седан', NULL),
	(5, 2, '5 серия седан', NULL),
	(6, 2, 'M5 седан', NULL),
	(7, 3, 'Cruze седан', NULL),
	(8, 3, 'Captiva', NULL),
	(9, 3, 'Orlando', NULL);

-- Дамп данных таблицы car_catalog.roles: ~2 rows (приблизительно)
DELETE FROM `roles`;
INSERT INTO `roles` (`id`, `role`) VALUES
	(1, 'admin'),
	(2, 'user');

-- Дамп данных таблицы car_catalog.users: ~2 rows (приблизительно)
DELETE FROM `users`;
INSERT INTO `users` (`id`, `login`, `email`, `password`, `roleID`) VALUES
	(1, 'admin', 'admin@gmail.com', 'admin', 1),
	(2, 'user', 'user@gmail.com', 'user', 2);

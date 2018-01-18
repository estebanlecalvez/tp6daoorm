INSERT INTO `editor` (`id`, `name`) VALUES
(1, 'Jk Rowling'),
(2, 'Tolkien');

INSERT INTO book (`id`, `title`, `id_Editor`) VALUES
(1, 'Naruto volume 1', 2),
(2, 'Naruto volume 2', 2),
(3, 'Harry potter 3', 1),
(4, 'Harry potter 5', 1),
(5, 'Harry potter 6', 1);

INSERT INTO `bookitem` (`id`, `itemCode`, `id_Book`) VALUES
(1, 'NA 1', 1),
(2, 'NA 2', 2),
(3, 'HP3', 3),
(4, 'HP5', 4),
(5, 'HP6', 5);


INSERT INTO `borrow` (`id`, `borrowerName`, `borrowStart`, `borrowEnd`, `borrowed`) VALUES
(1, 'Pol Waste', '2017-12-27 10:00:00', '2018-01-01 16:00:00', 3),
(2, 'Pol Waste', '2017-12-27 07:00:00', '2018-02-22 10:00:00', 4),
(3, 'Benjamin Gates', '2019-08-21 11:00:00', NULL, 4),
(4, 'Sarah Crauche', '2017-10-27 09:00:00', NULL, 4),
(5, 'Homer Simpson', '2017-12-27 10:00:00', NULL, 1);



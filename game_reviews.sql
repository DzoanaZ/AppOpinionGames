-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 19 Cze 2020, 14:23
-- Wersja serwera: 10.1.29-MariaDB
-- Wersja PHP: 7.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `game_reviews`
--
DROP DATABASE IF EXISTS `game_reviews`;
CREATE DATABASE IF NOT EXISTS `game_reviews` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `game_reviews`;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `category`
--

DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `category`
--

INSERT INTO `category` (`id`, `name`) VALUES
(2, 'Zręcznościowe'),
(3, 'Symulacyjne'),
(4, 'Science fiction');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `post`
--

DROP TABLE IF EXISTS `post`;
CREATE TABLE `post` (
  `id` bigint(20) NOT NULL,
  `description` longtext,
  `editorial_rate` double DEFAULT NULL,
  `publication_date` date DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `users_rate` double DEFAULT NULL,
  `category_id` bigint(20) DEFAULT NULL,
  `img_path` varchar(255) DEFAULT NULL,
  `short_description` varchar(255) DEFAULT NULL,
  `author_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `post`
--

INSERT INTO `post` (`id`, `description`, `editorial_rate`, `publication_date`, `title`, `users_rate`, `category_id`, `img_path`, `short_description`, `author_id`) VALUES
(1, '<p><span data-contrast=\"auto\" style=\"color: rgb(34, 34, 34); font-family: &quot;Open sans&quot;, Arial; font-size: 15px;\">Uniwersytet to ósmy duży dodatek do&nbsp;<em><strong>The&nbsp;</strong></em></span><em style=\"color: rgb(34, 34, 34); font-family: &quot;Open sans&quot;, Arial; font-size: 15px;\"><strong>Sims</strong></em><span data-contrast=\"auto\" style=\"color: rgb(34, 34, 34); font-family: &quot;Open sans&quot;, Arial; font-size: 15px;\"><em><strong>&nbsp;4</strong></em>&nbsp;oraz trzydziesty pierwszy spośród wszystkich dostępnych rozszerzeń gry. Jak nietrudno zgadnąć, rozszerza ścieżkę edukacji simów i pozwala im wybrać się na studia w miasteczku&nbsp;</span><span data-contrast=\"auto\" style=\"color: rgb(34, 34, 34); font-family: &quot;Open sans&quot;, Arial; font-size: 15px;\">Birtchester</span><span data-contrast=\"auto\" style=\"color: rgb(34, 34, 34); font-family: &quot;Open sans&quot;, Arial; font-size: 15px;\">. Już sama nazwa nowej okolicy wskazuje jakim stylem kierowali się twórcy.</span><br></p>', 4.5, '2020-06-11', 'The Sims 4 Uniwersytet', 4.5, 2, '/upload_d0259ac3-f323-4260-a090-15e760e60067.jpg', NULL, 1),
(2, '<p>Drugi polski tytuł w naszym zestawieniu premier gier 2020. Polska \r\nprodukcja od studia Farm 51, które ma na swoim koncie World War 3 oraz \r\nświetne Get Even. Tym razem gliwicka ekipa zabierze nas <b>do Strefy \r\nWykluczenia wokół elektrowni jądrowej w Czarnobylu</b>. Nie będzie to jednak\r\n gra dokumentalna, lecz klimatyczny survival horror.</p><p>Podczas \r\nrozgrywki gracze nie tylko będą musieli radzić sobie z licznymi \r\nniebezpieczeństwami, ale również rozwiązywać zagadki logiczne. Gra \r\nbędzie dostępna na PC, PS4 i XONE.</p>', 4.5, '2020-06-19', 'Chernobylite', 4.666666666666667, 4, '/upload_eed01a5e-79f7-4e31-903c-374550c5148f.jpg', NULL, 1),
(3, '<p>Little Nightmares II to kontynuacja klimatycznej platformówki autorstwa Tarsier Studios, wydanej w 2017 roku. Podobnie jak oryginał, gra ukazała się na komputerach osobistych i konsolach PlayStation 4, Xbox One oraz Nintendo Switch.<br></p>', 3, '2020-06-19', 'Little Nightmares II ', 2, 2, '/upload_a43b86a9-bc70-4122-b457-11db042faa31.jpg', NULL, 1),
(4, 'Drug Dealer Simulator to gra symulacyjna, w której wcielamy się w osobę handlująca narkotykami. Za stworzenie omawianej produkcji odpowiada polski deweloper Byterunners Game Studio. Wydawcą jest firma Movie Games, wspomagana przez PlayWay.<br><br>', 4.5, '2020-06-19', 'Drug Dealer Simulator', 3.5, 3, '/upload_f594b175-7f21-427d-b406-d185cd698799.jpg', NULL, 1);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `rating`
--

DROP TABLE IF EXISTS `rating`;
CREATE TABLE `rating` (
  `id` bigint(20) NOT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `rating` double DEFAULT NULL,
  `rating_date` datetime DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `post_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `rating`
--

INSERT INTO `rating` (`id`, `comment`, `rating`, `rating_date`, `type`, `post_id`, `user_id`) VALUES
(1, NULL, 4, '2020-06-11 08:54:52', 'EDITORIAL', 1, 1),
(2, 'Fajna gra! :)', 5, '2020-06-18 12:34:14', 'EDITORIAL', 1, 1),
(3, 'Spoczko :D', 4, '2020-06-18 12:36:43', 'USER', 1, 2),
(4, NULL, 4, '2020-06-19 07:48:46', 'EDITORIAL', 2, 1),
(5, NULL, 3, '2020-06-19 07:54:39', 'EDITORIAL', 3, 1),
(6, NULL, 5, '2020-06-19 07:59:47', 'EDITORIAL', 4, 1),
(7, 'Gra świetna i do tego dopracowana grafika. Polska produkcja - jestem pod wrażeniem! :)', 5, '2020-06-19 11:38:38', 'USER', 2, 2),
(8, 'Nie ma się czym szczycić. Taka sobie, trochę szkoda czasu.', 2, '2020-06-19 11:39:44', 'USER', 4, 2),
(9, 'Moja ulubiona! <3', 5, '2020-06-19 11:44:23', 'USER', 1, 3),
(10, 'Sztoos gra! Wciągająca i oparta na faktach.', 5, '2020-06-19 11:45:42', 'USER', 2, 3),
(11, 'Fajna.', 5, '2020-06-19 11:48:01', 'USER', 4, 4),
(12, 'Co to jest? ', 2, '2020-06-19 11:48:38', 'USER', 3, 4),
(13, 'Ogólnie spoko, ale warto dopracować kilka kwestii. Grafika nie jest zła :)', 4, '2020-06-19 11:50:57', 'USER', 2, 4),
(14, 'Jedna z najlepszych premier ostatniego kwartału 2019 roku. Polecamy wszystkim fanom serialu \"Czarnobyl\".  \r\nGrajcie i zostawiajcie opinie! \r\n~redaktor ', 5, '2020-06-19 12:06:36', 'EDITORIAL', 2, 1),
(15, 'Średnia.', 4, '2020-06-19 12:07:51', 'EDITORIAL', 4, 1);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL,
  `role` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `role`
--

INSERT INTO `role` (`id`, `role`) VALUES
(1, 'ROLE_USER'),
(2, 'ROLE_ADMIN');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `active` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `user`
--

INSERT INTO `user` (`id`, `active`, `email`, `name`, `password`) VALUES
(1, 1, 'zubeljoanna@gmail.com', 'Joanna', '$2a$11$JbxASv0uBThQpwzKue0sr.7g3.q3jaKPeBdAvkVWHSwcrkRtQhoIC'),
(2, 1, 'gamer123@gmail.com', 'Gamer123', '$2a$11$.CRj2yECS41JHDdNt0dPv.TGvNIejOuT4uzS3yp5CU.7v/GsKJAsO'),
(3, 1, 'gamerka1995@op.pl', 'Gmerka1995', '$2a$11$ZmxvjjrC3T7K2OEOT.Mk0uIhfyHoKxiC2R2suJ5mV6H4dVdtlKErG'),
(4, 1, 'pablito@gmail.com', 'Pablito', '$2a$11$7HKRXr.BAzR6psKC050lW.dzpYbI9RRyVtZdIl4MxRjj.PooVrQ0S');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `users_roles`
--

DROP TABLE IF EXISTS `users_roles`;
CREATE TABLE `users_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `users_roles`
--

INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES
(1, 1),
(1, 2),
(2, 1),
(3, 1),
(4, 1);

--
-- Indeksy dla zrzutów tabel
--

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `post`
--
ALTER TABLE `post`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKg6l1ydp1pwkmyj166teiuov1b` (`category_id`),
  ADD KEY `FK12njtf8e0jmyb45lqfpt6ad89` (`author_id`);

--
-- Indexes for table `rating`
--
ALTER TABLE `rating`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKq23oorcfn21b1owhgcqle69oq` (`post_id`),
  ADD KEY `FKpn05vbx6usw0c65tcyuce4dw5` (`user_id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users_roles`
--
ALTER TABLE `users_roles`
  ADD PRIMARY KEY (`user_id`,`role_id`),
  ADD KEY `FKt4v0rrweyk393bdgt107vdx0x` (`role_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `category`
--
ALTER TABLE `category`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT dla tabeli `post`
--
ALTER TABLE `post`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT dla tabeli `rating`
--
ALTER TABLE `rating`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT dla tabeli `role`
--
ALTER TABLE `role`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT dla tabeli `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `post`
--
ALTER TABLE `post`
  ADD CONSTRAINT `FK12njtf8e0jmyb45lqfpt6ad89` FOREIGN KEY (`author_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKg6l1ydp1pwkmyj166teiuov1b` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`);

--
-- Ograniczenia dla tabeli `rating`
--
ALTER TABLE `rating`
  ADD CONSTRAINT `FKpn05vbx6usw0c65tcyuce4dw5` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKq23oorcfn21b1owhgcqle69oq` FOREIGN KEY (`post_id`) REFERENCES `post` (`id`);

--
-- Ograniczenia dla tabeli `users_roles`
--
ALTER TABLE `users_roles`
  ADD CONSTRAINT `FKgd3iendaoyh04b95ykqise6qh` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKt4v0rrweyk393bdgt107vdx0x` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

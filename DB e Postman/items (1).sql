-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Mag 21, 2025 alle 09:44
-- Versione del server: 10.4.32-MariaDB
-- Versione PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `items`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `lost_items`
--

CREATE TABLE `lost_items` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` text NOT NULL,
  `lost_date` date NOT NULL,
  `lost_location` text NOT NULL,
  `found` tinyint(1) NOT NULL,
  `found_date` date DEFAULT NULL,
  `found_location` text DEFAULT NULL,
  `note` text DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `lost_items`
--

INSERT INTO `lost_items` (`id`, `name`, `description`, `lost_date`, `lost_location`, `found`, `found_date`, `found_location`, `note`, `created_at`, `updated_at`) VALUES
(1, 'Iphone 15', 'Telefono della Apple costoso', '2025-05-08', '', 0, NULL, NULL, NULL, '2025-05-13 14:00:27', '2025-05-13 14:00:27'),
(3, 'Ciaociao2', 'Telefono della Apple costoso2', '2025-05-07', '', 1, '2025-05-08', 'ITS Prodigi del cazzo', NULL, '2025-05-14 07:23:41', '2025-05-14 07:25:52'),
(6, 'Telefono brutto', 'stocazzo', '2025-05-03', 'Parco di Canonica', 1, '2001-12-30', 'Parco di Canonica', NULL, '2025-05-14 08:51:25', '2025-05-16 14:58:53');

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `lost_items`
--
ALTER TABLE `lost_items`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `lost_items`
--
ALTER TABLE `lost_items`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 17, 2025 at 06:33 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_kafe`
--

-- --------------------------------------------------------

--
-- Table structure for table `menu_kafe`
--

CREATE TABLE `menu_kafe` (
  `id` varchar(10) NOT NULL,
  `nama` varchar(100) DEFAULT NULL,
  `harga` double DEFAULT NULL,
  `kategori` varchar(50) DEFAULT NULL,
  `merek` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `menu_kafe`
--

INSERT INTO `menu_kafe` (`id`, `nama`, `harga`, `kategori`, `merek`) VALUES
('K001', 'Kopi Latte', 25000, 'Minuman', 'Starbrew'),
('K002', 'Cappuccino', 27000, 'Minuman', 'BeanCraft'),
('K003', 'Matcha Latte', 30000, 'Minuman', 'GreenBrew'),
('K004', 'Croissant Coklat', 22000, 'Makanan', 'Bakehouse'),
('K005', 'Nasi Goreng Special', 35000, 'Makanan', 'Dapur Kita'),
('K006', 'Cheesecake', 28000, 'Dessert', 'SweetHouse'),
('K007', 'Brownies Kukus', 25000, 'Dessert', 'Coklats'),
('K008', 'Iced Americano', 23000, 'Minuman', 'KopiKita'),
('K009', 'Iced Kopi Susu', 27000, 'Minuman', 'Starbrew'),
('K010', 'Tiramisu', 32000, 'Dessert', 'SweetHouse'),
('K011', 'Puding Coklat', 28000, 'Minuman', 'Starbrew');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `menu_kafe`
--
ALTER TABLE `menu_kafe`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

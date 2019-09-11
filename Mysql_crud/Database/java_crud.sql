-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 11, 2019 at 12:12 PM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.3.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `java_crud`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_user`
--

CREATE TABLE `tbl_user` (
  `user_id` int(255) NOT NULL,
  `fname` varchar(255) NOT NULL,
  `lname` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `pw` varchar(255) NOT NULL,
  `pw2` varchar(255) NOT NULL,
  `gender` enum('male','female') NOT NULL,
  `image` varchar(255) NOT NULL,
  `status` enum('active','inactive') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_user`
--

INSERT INTO `tbl_user` (`user_id`, `fname`, `lname`, `email`, `username`, `pw`, `pw2`, `gender`, `image`, `status`) VALUES
(1, 'Jervy', 'Umandap', 'jervygu@gmail.com', 'jervygu', 'pppppppp', 'pppppppp', 'male', 'jervy.jpg', 'active'),
(2, 'Natasha', 'Romanoff', 'nat@gmail.com', 'blackwidow', 'natasha', 'natasha', 'female', 'nat.jpg', 'active'),
(9, 'Monette', 'Janson', 'monette@gmail.com', 'monette123', 'monette123', 'monette123', 'female', 'monette.jpg', 'active'),
(11, 'Charlene', 'San_Pedro', 'charlene@yahoo.com', 'charlene123', 'charlene123', 'charlene123', 'female', 'charlene123.jpg', 'active'),
(12, 'Miles', 'Ocampo', 'miles@gmail.com', 'miles123', 'mile123', 'miles123', 'female', 'miles.jpg', 'active'),
(13, 'Sophia', 'Andres', 'sophia@gmail.com', 'sophia123', 'sophia123', 'sophia123', 'female', 'sophia123.jpg', 'active'),
(14, 'Kobe', 'Bryant', 'blackmamba@gmail.com', 'blackmamba', 'mamba123', 'mamb123', 'male', 'mamba24.jpg', 'active'),
(15, 'Lebron', 'James', 'theking@gmail.com', 'theking', 'theking123', 'theking123', 'male', 'theking.jpg', 'active');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_user`
--
ALTER TABLE `tbl_user`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_user`
--
ALTER TABLE `tbl_user`
  MODIFY `user_id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

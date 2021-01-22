-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 22, 2021 at 05:31 PM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbtest`
--

-- --------------------------------------------------------

--
-- Table structure for table `departmenttb`
--

CREATE TABLE `departmenttb` (
  `Id` int(11) NOT NULL,
  `Name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `departmenttb`
--

INSERT INTO `departmenttb` (`Id`, `Name`) VALUES
(1, 'Sales'),
(2, 'IT');

-- --------------------------------------------------------

--
-- Table structure for table `employeetb`
--

CREATE TABLE `employeetb` (
  `Id` int(11) NOT NULL,
  `departmentId` int(11) NOT NULL,
  `Name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employeetb`
--

INSERT INTO `employeetb` (`Id`, `departmentId`, `Name`) VALUES
(1, 2, 'Mohit'),
(2, 1, 'Rakesh'),
(3, 1, 'Suresh');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `departmenttb`
--
ALTER TABLE `departmenttb`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `employeetb`
--
ALTER TABLE `employeetb`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `fk_department` (`departmentId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `departmenttb`
--
ALTER TABLE `departmenttb`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `employeetb`
--
ALTER TABLE `employeetb`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `employeetb`
--
ALTER TABLE `employeetb`
  ADD CONSTRAINT `fk_department` FOREIGN KEY (`departmentId`) REFERENCES `departmenttb` (`Id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

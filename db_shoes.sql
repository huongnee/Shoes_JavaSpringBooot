-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1:8888
-- Thời gian đã tạo: Th4 01, 2025 lúc 08:52 AM
-- Phiên bản máy phục vụ: 10.4.27-MariaDB
-- Phiên bản PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `db_shoes`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `category`
--

CREATE TABLE `category` (
  `ID` bigint(20) NOT NULL,
  `NAME` varchar(500) DEFAULT NULL,
  `NOTES` text DEFAULT NULL,
  `ICON` varchar(250) DEFAULT NULL,
  `IDPARENT` bigint(20) DEFAULT NULL,
  `SLUG` varchar(160) DEFAULT NULL,
  `META_TITLE` varchar(100) DEFAULT NULL,
  `META_KEYWORD` varchar(500) DEFAULT NULL,
  `META_DESCRIPTION` varchar(300) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT current_timestamp(),
  `UPDATED_DATE` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `CREATED_BY` bigint(20) DEFAULT NULL,
  `UPDATED_BY` bigint(20) DEFAULT NULL,
  `ISDELETE` tinyint(4) DEFAULT 0,
  `ISACTIVE` tinyint(4) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `configurations`
--

CREATE TABLE `configurations` (
  `ID` bigint(20) NOT NULL,
  `NAME` varchar(500) DEFAULT NULL,
  `NOTES` text DEFAULT NULL,
  `ISDELETE` tinyint(4) DEFAULT 0,
  `ISACTIVE` tinyint(4) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `customer`
--

CREATE TABLE `customer` (
  `ID` bigint(20) NOT NULL,
  `NAME` varchar(250) DEFAULT NULL,
  `USERNAME` varchar(50) NOT NULL,
  `PASSWORD` varchar(32) NOT NULL,
  `ADDRESS` varchar(500) DEFAULT NULL,
  `EMAIL` varchar(150) DEFAULT NULL,
  `PHONE` varchar(50) DEFAULT NULL,
  `AVATAR` varchar(250) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT current_timestamp(),
  `UPDATED_DATE` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `CREATED_BY` bigint(20) DEFAULT NULL,
  `UPDATED_BY` bigint(20) DEFAULT NULL,
  `ISDELETE` tinyint(4) DEFAULT 0,
  `ISACTIVE` tinyint(4) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `news`
--

CREATE TABLE `news` (
  `ID` bigint(20) NOT NULL,
  `NAME` varchar(500) DEFAULT NULL,
  `DESCRIPTION` text DEFAULT NULL,
  `IMAGE` varchar(550) DEFAULT NULL,
  `IDNEWSCATEGORY` bigint(20) NOT NULL,
  `CONTENTS` text DEFAULT NULL,
  `SLUG` varchar(160) DEFAULT NULL,
  `META_TITLE` varchar(100) DEFAULT NULL,
  `META_KEYWORD` varchar(500) DEFAULT NULL,
  `META_DESCRIPTION` varchar(500) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT current_timestamp(),
  `UPDATED_DATE` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `CREATED_BY` bigint(20) DEFAULT NULL,
  `UPDATED_BY` bigint(20) DEFAULT NULL,
  `ISDELETE` tinyint(4) DEFAULT 0,
  `ISACTIVE` tinyint(4) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `news_category`
--

CREATE TABLE `news_category` (
  `ID` bigint(20) NOT NULL,
  `NAME` varchar(500) DEFAULT NULL,
  `NOTES` text DEFAULT NULL,
  `ICON` varchar(250) DEFAULT NULL,
  `IDPARENT` bigint(20) DEFAULT NULL,
  `SLUG` varchar(160) DEFAULT NULL,
  `META_TITLE` varchar(100) DEFAULT NULL,
  `META_KEYWORD` varchar(500) DEFAULT NULL,
  `META_DESCRIPTION` varchar(300) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT current_timestamp(),
  `UPDATED_DATE` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `CREATED_BY` bigint(20) DEFAULT NULL,
  `UPDATED_BY` bigint(20) DEFAULT NULL,
  `ISDELETE` tinyint(4) DEFAULT 0,
  `ISACTIVE` tinyint(4) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `orders`
--

CREATE TABLE `orders` (
  `ID` bigint(20) NOT NULL,
  `IORDERS` char(10) NOT NULL,
  `ORDERS_DATE` datetime NOT NULL,
  `IDCUSTOMER` bigint(20) NOT NULL,
  `IDPAYMENT` bigint(20) NOT NULL,
  `IDTRANSPORT` bigint(20) NOT NULL,
  `TOTAL_MONEY` decimal(10,0) NOT NULL,
  `NOTES` text DEFAULT NULL,
  `NAME_RECEIVER` varchar(250) DEFAULT NULL,
  `ADDRESS` varchar(500) DEFAULT NULL,
  `EMAIL` varchar(150) DEFAULT NULL,
  `PHONE` varchar(50) DEFAULT NULL,
  `ISDELETE` tinyint(4) DEFAULT 0,
  `ISACTIVE` tinyint(4) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `orders_details`
--

CREATE TABLE `orders_details` (
  `ID` bigint(20) NOT NULL,
  `IDORD` bigint(20) NOT NULL,
  `IDPRODUCT` bigint(20) NOT NULL,
  `PRICE` decimal(10,0) NOT NULL,
  `QTY` int(11) NOT NULL CHECK (`QTY` >= 0),
  `TOTAL` decimal(10,0) NOT NULL CHECK (`TOTAL` >= 0),
  `RETURN_QTY` int(11) DEFAULT NULL CHECK (`RETURN_QTY` >= 0)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `product`
--

CREATE TABLE `product` (
  `ID` bigint(20) NOT NULL,
  `NAME` varchar(500) DEFAULT NULL,
  `DESCRIPTION` text DEFAULT NULL,
  `NOTES` text DEFAULT NULL,
  `IMAGE` varchar(550) DEFAULT NULL,
  `IDCATEGORY` bigint(20) NOT NULL,
  `CONTENTS` text DEFAULT NULL,
  `PRICE` decimal(10,0) DEFAULT 0,
  `QUANTITY` int(11) DEFAULT 0,
  `SLUG` varchar(160) DEFAULT NULL,
  `META_TITLE` varchar(100) DEFAULT NULL,
  `META_KEYWORD` varchar(500) DEFAULT NULL,
  `META_DESCRIPTION` varchar(500) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT current_timestamp(),
  `UPDATED_DATE` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `CREATED_BY` bigint(20) DEFAULT NULL,
  `UPDATED_BY` bigint(20) DEFAULT NULL,
  `ISDELETE` tinyint(4) DEFAULT 0,
  `ISACTIVE` tinyint(4) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `product_config`
--

CREATE TABLE `product_config` (
  `ID` bigint(20) NOT NULL,
  `IDPRODUCT` bigint(20) NOT NULL,
  `IDCONFIG` bigint(20) NOT NULL,
  `VALUE` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `product_images`
--

CREATE TABLE `product_images` (
  `ID` bigint(20) NOT NULL,
  `NAME` varchar(250) DEFAULT NULL,
  `URLIMG` varchar(250) DEFAULT NULL,
  `IDPRODUCT` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `transport_method`
--

CREATE TABLE `transport_method` (
  `ID` bigint(20) NOT NULL,
  `NAME` varchar(250) DEFAULT NULL,
  `NOTES` text DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT current_timestamp(),
  `UPDATED_DATE` datetime DEFAULT NULL ON UPDATE current_timestamp(),
  `ISDELETE` tinyint(4) DEFAULT 0,
  `ISACTIVE` tinyint(4) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `configurations`
--
ALTER TABLE `configurations`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `USERNAME` (`USERNAME`);

--
-- Chỉ mục cho bảng `news`
--
ALTER TABLE `news`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `IDNEWSCATEGORY` (`IDNEWSCATEGORY`);

--
-- Chỉ mục cho bảng `news_category`
--
ALTER TABLE `news_category`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `IORDERS` (`IORDERS`),
  ADD KEY `IDCUSTOMER` (`IDCUSTOMER`),
  ADD KEY `IDTRANSPORT` (`IDTRANSPORT`);

--
-- Chỉ mục cho bảng `orders_details`
--
ALTER TABLE `orders_details`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `IDORD` (`IDORD`),
  ADD KEY `IDPRODUCT` (`IDPRODUCT`);

--
-- Chỉ mục cho bảng `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `IDCATEGORY` (`IDCATEGORY`);

--
-- Chỉ mục cho bảng `product_config`
--
ALTER TABLE `product_config`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `IDPRODUCT` (`IDPRODUCT`),
  ADD KEY `IDCONFIG` (`IDCONFIG`);

--
-- Chỉ mục cho bảng `product_images`
--
ALTER TABLE `product_images`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `IDPRODUCT` (`IDPRODUCT`);

--
-- Chỉ mục cho bảng `transport_method`
--
ALTER TABLE `transport_method`
  ADD PRIMARY KEY (`ID`);

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `news`
--
ALTER TABLE `news`
  ADD CONSTRAINT `news_ibfk_1` FOREIGN KEY (`IDNEWSCATEGORY`) REFERENCES `news_category` (`ID`);

--
-- Các ràng buộc cho bảng `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`IDCUSTOMER`) REFERENCES `customer` (`ID`),
  ADD CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`IDTRANSPORT`) REFERENCES `transport_method` (`ID`);

--
-- Các ràng buộc cho bảng `orders_details`
--
ALTER TABLE `orders_details`
  ADD CONSTRAINT `orders_details_ibfk_1` FOREIGN KEY (`IDORD`) REFERENCES `orders` (`ID`),
  ADD CONSTRAINT `orders_details_ibfk_2` FOREIGN KEY (`IDPRODUCT`) REFERENCES `product` (`ID`);

--
-- Các ràng buộc cho bảng `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `product_ibfk_1` FOREIGN KEY (`IDCATEGORY`) REFERENCES `category` (`ID`);

--
-- Các ràng buộc cho bảng `product_config`
--
ALTER TABLE `product_config`
  ADD CONSTRAINT `product_config_ibfk_1` FOREIGN KEY (`IDPRODUCT`) REFERENCES `product` (`ID`),
  ADD CONSTRAINT `product_config_ibfk_2` FOREIGN KEY (`IDCONFIG`) REFERENCES `configurations` (`ID`);

--
-- Các ràng buộc cho bảng `product_images`
--
ALTER TABLE `product_images`
  ADD CONSTRAINT `product_images_ibfk_1` FOREIGN KEY (`IDPRODUCT`) REFERENCES `product` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

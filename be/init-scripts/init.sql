CREATE DATABASE IF NOT EXISTS account_service;
CREATE DATABASE IF NOT EXISTS product_service;
CREATE DATABASE IF NOT EXISTS received_service;
CREATE DATABASE IF NOT EXISTS order_service;


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `product_id` int NOT NULL AUTO_INCREMENT,
  `is_deleted` bit(1) DEFAULT NULL,
  `product_description` text,
  `product_image` varchar(255) DEFAULT NULL,
  `product_inprice` int DEFAULT NULL,
  `product_inventory` int DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `product_saleprice` int DEFAULT NULL,
  `type_id` int DEFAULT NULL,
  `product_warranty` date DEFAULT NULL,
  `supplier_id` int DEFAULT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `product_type`;
CREATE TABLE `product_type` (
  `type_id` int NOT NULL AUTO_INCREMENT,
  `type_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier` (
  `supplier_id` int NOT NULL AUTO_INCREMENT,
  `supplier_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`supplier_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `product` (`product_id`, `is_deleted`, `product_description`, `product_image`, `product_inprice`, `product_inventory`, `product_name`, `product_saleprice`, `type_id`, `product_warranty`, `supplier_id`) VALUES
(1, 0, 'san pham rolex1', NULL, 100, 100, 'Rolex01', 80, 3, NULL, 1);
INSERT INTO `product` (`product_id`, `is_deleted`, `product_description`, `product_image`, `product_inprice`, `product_inventory`, `product_name`, `product_saleprice`, `type_id`, `product_warranty`, `supplier_id`) VALUES
(2, 0, 'San Pham casio1', NULL, 20, 120, 'Casio01', 15, 1, NULL, 1);
INSERT INTO `product_type` (`type_id`, `type_name`) VALUES
(1, 'Casio');
INSERT INTO `product_type` (`type_id`, `type_name`) VALUES
(2, 'Cartier');
INSERT INTO `product_type` (`type_id`, `type_name`) VALUES
(3, 'Rolex');
INSERT INTO `supplier` (`supplier_id`, `supplier_name`) VALUES
(1, 'Supplier1');
INSERT INTO `supplier` (`supplier_id`, `supplier_name`) VALUES
(2, 'Supplier2');


/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `account_id` int NOT NULL AUTO_INCREMENT,
  `customer_address` varchar(255) DEFAULT NULL,
  `customer_email` varchar(255) DEFAULT NULL,
  `customer_name` varchar(255) DEFAULT NULL,
  `customer_phone` varchar(255) DEFAULT NULL,
  `is_deleted` bit(1) NOT NULL,
  `account_password` varchar(255) NOT NULL,
  `role` tinyint DEFAULT NULL,
  `account_name` varchar(255) NOT NULL,
  PRIMARY KEY (`account_id`),
  UNIQUE KEY `UKjfarbv64d68y4tm9c9ms5fh7b` (`account_name`),
  CONSTRAINT `account_chk_1` CHECK ((`role` between 0 and 1))
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `account` (`account_id`, `customer_address`, `customer_email`, `customer_name`, `customer_phone`, `is_deleted`, `account_password`, `role`, `account_name`) VALUES
(1, NULL, 'string', NULL, 'string', 0, '$2a$10$1mWW5Tofli0TVqI/hl2/ZeSk5IJT6tZrb6Ojq7/J.PbFhDh4iHvj.', 1, 'string');
INSERT INTO `account` (`account_id`, `customer_address`, `customer_email`, `customer_name`, `customer_phone`, `is_deleted`, `account_password`, `role`, `account_name`) VALUES
(2, NULL, 'tranhieu123@gmail.com', 'Trần Trọng Hiếu', '0989572831', 0, '$2a$10$1mWW5Tofli0TVqI/hl2/ZeSk5IJT6tZrb6Ojq7/J.PbFhDh4iHvj.', 0, 'tranhieu123');
INSERT INTO `account` (`account_id`, `customer_address`, `customer_email`, `customer_name`, `customer_phone`, `is_deleted`, `account_password`, `role`, `account_name`) VALUES
(3, NULL, 'vanphutung06@gmail.com', 'Văn Phú Tùng', '0923849423', 0, '$2a$10$1mWW5Tofli0TVqI/hl2/ZeSk5IJT6tZrb6Ojq7/J.PbFhDh4iHvj.', 0, 'phutung06');
INSERT INTO `account` (`account_id`, `customer_address`, `customer_email`, `customer_name`, `customer_phone`, `is_deleted`, `account_password`, `role`, `account_name`) VALUES
(4, NULL, 'phamanh123@gmail.com', 'Phạm Ngọc Ánh', '0983289472', 0, '$2a$10$1mWW5Tofli0TVqI/hl2/ZeSk5IJT6tZrb6Ojq7/J.PbFhDh4iHvj.', 0, 'phamanh123');


/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
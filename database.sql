-- MySQL dump 10.13  Distrib 8.0.46, for Win64 (x86_64)
--
-- Host: localhost    Database: fashion_store
-- ------------------------------------------------------
-- Server version	8.0.46

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cart_items`
--

DROP TABLE IF EXISTS `cart_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart_items` (
  `cart_item_id` int NOT NULL AUTO_INCREMENT,
  `cart_id` int NOT NULL,
  `product_id` int NOT NULL,
  `quantity` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`cart_item_id`),
  KEY `fk_cartitem_cart` (`cart_id`),
  KEY `fk_cartitem_product` (`product_id`),
  CONSTRAINT `fk_cartitem_cart` FOREIGN KEY (`cart_id`) REFERENCES `carts` (`cart_id`),
  CONSTRAINT `fk_cartitem_product` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart_items`
--

LOCK TABLES `cart_items` WRITE;
/*!40000 ALTER TABLE `cart_items` DISABLE KEYS */;
INSERT INTO `cart_items` VALUES (1,1,1,2),(2,1,2,1),(3,1,18,1),(4,2,6,1),(5,2,14,1),(6,3,7,2),(7,3,20,1),(8,4,3,1),(9,4,15,2),(10,5,5,1),(11,5,19,1);
/*!40000 ALTER TABLE `cart_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carts`
--

DROP TABLE IF EXISTS `carts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carts` (
  `cart_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `product_id` int NOT NULL,
  `quantity` int NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`cart_id`),
  KEY `fk_cart_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carts`
--

LOCK TABLES `carts` WRITE;
/*!40000 ALTER TABLE `carts` DISABLE KEYS */;
INSERT INTO `carts` VALUES (1,1,1,2,'2026-06-14 07:16:16'),(2,2,1,1,'2026-06-14 07:16:16'),(3,3,3,1,'2026-06-14 07:16:16'),(4,4,5,1,'2026-06-14 07:16:16'),(5,5,2,1,'2026-06-14 07:16:16'),(6,1,1,1,'2026-06-21 18:11:06'),(20,0,4,1,'2026-06-22 16:00:40');
/*!40000 ALTER TABLE `carts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categories` (
  `category_id` int NOT NULL AUTO_INCREMENT,
  `category_name` varchar(50) NOT NULL,
  `description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`category_id`),
  UNIQUE KEY `category_name` (`category_name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,'Men','Mens Fashion Collection'),(2,'Women','Womens Fashion Collection'),(3,'Kids','Kids Fashion Collection'),(4,'Footwear','Shoes and Sandals'),(5,'Accessories','Fashion Accessories');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_items`
--

DROP TABLE IF EXISTS `order_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_items` (
  `order_item_id` int NOT NULL AUTO_INCREMENT,
  `order_id` int NOT NULL,
  `product_id` int NOT NULL,
  `quantity` int NOT NULL,
  `price` decimal(10,2) NOT NULL,
  PRIMARY KEY (`order_item_id`),
  KEY `fk_orderitem_order` (`order_id`),
  KEY `fk_orderitem_product` (`product_id`),
  CONSTRAINT `fk_orderitem_order` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`),
  CONSTRAINT `fk_orderitem_product` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_items`
--

LOCK TABLES `order_items` WRITE;
/*!40000 ALTER TABLE `order_items` DISABLE KEYS */;
INSERT INTO `order_items` VALUES (1,1,1,2,1999.00),(2,1,2,1,2499.00),(3,1,18,1,1499.00),(4,2,6,1,2999.00),(5,2,14,1,3499.00),(6,3,7,2,999.00),(7,3,20,1,1899.00),(8,4,3,1,1799.00),(9,4,15,2,2999.00),(10,5,5,1,1499.00),(11,5,19,1,2499.00);
/*!40000 ALTER TABLE `order_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `total_amount` decimal(10,2) NOT NULL,
  `payment_mode` varchar(20) NOT NULL,
  `status` varchar(20) NOT NULL,
  `order_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`order_id`),
  KEY `fk_order_user` (`user_id`),
  CONSTRAINT `fk_order_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,1,7996.00,'UPI','DELIVERED','2026-06-14 07:16:35'),(2,2,6498.00,'CARD','SHIPPED','2026-06-14 07:16:35'),(3,3,3897.00,'COD','PENDING','2026-06-14 07:16:35'),(4,4,7797.00,'UPI','DELIVERED','2026-06-14 07:16:35'),(5,5,3998.00,'CARD','CONFIRMED','2026-06-14 07:16:35'),(25,9,899.00,'Cash On Delivery','PLACED','2026-06-22 16:48:58'),(26,9,1999.00,'Cash On Delivery','PLACED','2026-06-22 17:07:30'),(27,12,499.00,'Cash On Delivery','PLACED','2026-06-29 15:47:23'),(28,12,699.00,'Cash On Delivery','PLACED','2026-06-29 15:52:27'),(29,12,2499.00,'Cash On Delivery','PLACED','2026-06-29 16:01:10'),(30,11,2999.00,'Cash On Delivery','PLACED','2026-06-29 16:08:44'),(36,10,3499.00,'Cash On Delivery','PLACED','2026-06-29 16:30:47'),(38,12,1799.00,'Cash On Delivery','PLACED','2026-06-29 16:34:56'),(39,12,1999.00,'Cash On Delivery','PLACED','2026-06-29 16:35:53'),(40,12,1499.00,'Cash On Delivery','PLACED','2026-06-29 16:36:53'),(41,12,0.00,'Cash On Delivery','PLACED','2026-06-29 16:36:56'),(42,12,899.00,'Cash On Delivery','PLACED','2026-06-29 16:38:01');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_variants`
--

DROP TABLE IF EXISTS `product_variants`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_variants` (
  `variant_id` int NOT NULL AUTO_INCREMENT,
  `product_id` int NOT NULL,
  `size` varchar(20) NOT NULL,
  `stock` int NOT NULL,
  PRIMARY KEY (`variant_id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `product_variants_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_variants`
--

LOCK TABLES `product_variants` WRITE;
/*!40000 ALTER TABLE `product_variants` DISABLE KEYS */;
INSERT INTO `product_variants` VALUES (1,1,'S',15),(2,1,'M',20),(3,1,'L',15),(4,2,'30',10),(5,2,'32',15),(6,2,'34',15),(7,3,'M',10),(8,3,'L',15),(9,3,'XL',10),(10,4,'S',20),(11,4,'M',25),(12,4,'L',15),(13,5,'40',15),(14,5,'42',15),(15,5,'44',15),(16,6,'S',8),(17,6,'M',10),(18,6,'L',7),(19,7,'S',10),(20,7,'M',15),(21,7,'L',10),(22,8,'S',8),(23,8,'M',7),(24,8,'L',5),(25,9,'M',10),(26,9,'L',10),(27,9,'XL',10),(28,10,'S',5),(29,10,'M',5),(30,10,'L',5),(31,14,'8',7),(32,14,'9',8),(33,14,'10',5),(34,15,'7',8),(35,15,'8',9),(36,15,'9',8),(37,16,'8',6),(38,16,'9',8),(39,16,'10',8),(40,17,'8',5),(41,17,'9',5),(42,17,'10',5);
/*!40000 ALTER TABLE `product_variants` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `product_id` int NOT NULL AUTO_INCREMENT,
  `category_id` int NOT NULL,
  `name` varchar(150) NOT NULL,
  `description` text NOT NULL,
  `brand` varchar(100) NOT NULL,
  `size` varchar(20) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `stock` int NOT NULL,
  `image_path` varchar(255) NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`product_id`),
  KEY `fk_product_category` (`category_id`),
  CONSTRAINT `fk_product_category` FOREIGN KEY (`category_id`) REFERENCES `categories` (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,1,'Nike Hoodie Black','Premium Cotton Hoodie','Nike','M',1999.00,50,'/fashionStore/assets/images/product-1.png','2026-06-14 07:15:05'),(2,1,'Levis Jeans Blue','Slim Fit Denim Jeans','Levis','32',2499.00,40,'/fashionStore/assets/images/product-2.png','2026-06-14 07:15:05'),(3,1,'Puma Sweatshirt','Winter Sweatshirt','Puma','L',1799.00,35,'/fashionStore/assets/images/product-3.png','2026-06-14 07:15:05'),(4,1,'US Polo T-Shirt','Round Neck T-Shirt','US Polo','M',899.00,60,'/fashionStore/assets/images/product-4.png','2026-06-14 07:15:05'),(5,1,'Allen Solly Shirt','Formal Shirt','Allen Solly','42',1499.00,45,'/fashionStore/assets/images/product-5.png','2026-06-14 07:15:05'),(6,2,'Zara Women Dress','Casual Summer Dress','Zara','S',2999.00,25,'/fashionStore/assets/images/product-6.png','2026-06-14 07:15:05'),(7,2,'H&M Women Top','Comfort Fit Top','H&M','M',999.00,35,'/fashionStore/assets/images/product-7.png','2026-06-14 07:15:05'),(8,2,'Forever21 Skirt','Stylish Mini Skirt','Forever21','S',1299.00,20,'/fashionStore/assets/images/product-8.png','2026-06-14 07:15:05'),(9,2,'Biba Kurti','Printed Kurti','Biba','L',1599.00,30,'/fashionStore/assets/images/product-9.png','2026-06-14 07:15:05'),(10,2,'ONLY Jacket','Winter Jacket','ONLY','M',3499.00,15,'/fashionStore/assets/images/product-10.png','2026-06-14 07:15:05'),(11,3,'Kids T-Shirt','Printed Cotton T-Shirt','Puma','XS',499.00,60,'/fashionStore/assets/images/product-11.png','2026-06-14 07:15:05'),(12,3,'Kids Shorts','Comfort Shorts','Nike','XS',699.00,45,'/fashionStore/assets/images/product-12.png','2026-06-14 07:15:05'),(13,3,'Kids Hoodie','Warm Hoodie','Adidas','S',999.00,25,'/fashionStore/assets/images/product-13.png','2026-06-14 07:15:05'),(14,4,'Adidas Running Shoes','Lightweight Running Shoes','Adidas','9',3499.00,20,'/fashionStore/assets/images/product-14.png','2026-06-14 07:15:05'),(15,4,'Nike Sneakers','Daily Wear Sneakers','Nike','8',2999.00,25,'/fashionStore/assets/images/product-15.png','2026-06-14 07:15:05'),(16,4,'Puma Sports Shoes','Sports Shoes','Puma','10',2799.00,22,'/fashionStore/assets/images/product-16.png','2026-06-14 07:15:05'),(17,4,'Woodland Boots','Leather Boots','Woodland','9',4499.00,15,'/fashionStore/assets/images/product-17.png','2026-06-14 07:15:05'),(18,5,'Fastrack Watch','Analog Watch','Fastrack','FREE',1499.00,30,'/fashionStore/assets/images/product-18.png','2026-06-14 07:15:05'),(19,5,'RayBan Sunglasses','UV Protected Sunglasses','RayBan','FREE',2499.00,18,'/fashionStore/assets/images/product-19.png','2026-06-14 07:15:05'),(20,5,'Wildcraft Backpack','Travel Backpack','Wildcraft','FREE',1899.00,27,'/fashionStore/assets/images/product-20.png','2026-06-14 07:15:05');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `password` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `city` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `pincode` varchar(45) DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `phone` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Rahul Sharma','rahul@gmail.com','9876543210','rahul123','12 MG Road','Bangalore','Karnataka','560001','India','2026-06-14 07:14:37'),(2,'Priya Verma','priya@gmail.com','9876543211','priya123','45 Brigade Road','Bangalore','Karnataka','560025','India','2026-06-14 07:14:37'),(3,'Arjun Reddy','arjun@gmail.com','9876543212','arjun123','8 Banjara Hills','Hyderabad','Telangana','500034','India','2026-06-14 07:14:37'),(4,'Sneha Gupta','sneha@gmail.com','9876543213','sneha123','22 Park Street','Kolkata','West Bengal','700016','India','2026-06-14 07:14:37'),(5,'Karan Mehta','karan@gmail.com','9876543214','karan123','15 Marine Drive','Mumbai','Maharashtra','400001','India','2026-06-14 07:14:37'),(6,'Anjali Singh','anjali@gmail.com','9876543215','anjali123','10 Civil Lines','Delhi','Delhi','110054','India','2026-06-14 07:14:37'),(7,'Vikram Rao','vikram@gmail.com','9876543216','vikram123','7 Residency Road','Chennai','Tamil Nadu','600002','India','2026-06-14 07:14:37'),(8,'Pooja Patel','pooja@gmail.com','9876543217','pooja123','18 Ashram Road','Ahmedabad','Gujarat','380009','India','2026-06-14 07:14:37'),(9,'Chennuru Yashwanth','chennuruyashwanth@gmail.com','09652492586','asdf123','6-22, Singaraya Kandriga (vill), Veerakanellore Post, GD Nellore (m), Chittoor Dist.','Chittoor','Andhra Pradesh','517167','India','2026-06-20 15:59:44'),(10,'C Rajendra Reddy','rajendra@gmail.com','9618655818','1234','6-22, Singaraya Kandriga (vill), Veerakanellore Post, GD Nellore (m), Chittoor Dist.','Chittoor','Andhra Pradesh','517167','India','2026-06-20 16:01:45'),(11,'Chaithu','chaithu@gmail.com','9695748563','asdf123','BTM Layout 1st Stage, jai bheema nagar, 5th cross','Bengaluru','Karnataka','560068','India','2026-06-20 16:46:50'),(12,'Viswa','viswa@gmail.com','8079795779','qwer1234','1st stage BTM Layout, Jai Bheem Nagar','Bengaluru','Karnataka','560068','India','2026-06-21 06:57:36'),(13,'Tim','tim@gamil.com','6849373940','tim786','BTM Layout','Bengaluru','Karnataka','560068','India','2026-06-21 07:23:38'),(14,'Mic','mic@gmail.com','7849385973','mic123','Silk Board','Bengaluru','Karnataka','560067','India','2026-06-21 07:27:23');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-06-30 15:50:03

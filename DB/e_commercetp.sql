/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : e_commercetp

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2019-09-23 19:34:18
*/



CREATE DATABASE `e_commercetp`;



SET FOREIGN_KEY_CHECKS=0;

USE e_commercetp;

-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', 'Romans Policiers');
INSERT INTO `category` VALUES ('2', 'Science-Fiction et Fantastique');
INSERT INTO `category` VALUES ('3', 'Cuisine - Vin');
INSERT INTO `category` VALUES ('4', 'Humour');
INSERT INTO `category` VALUES ('5', 'Sport - Loisirs');
INSERT INTO `category` VALUES ('6', 'Informatique');

-- ----------------------------
-- Table structure for `commande`
-- ----------------------------
DROP TABLE IF EXISTS `commande`;
CREATE TABLE `commande` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idUser` int(11) NOT NULL,
  `date` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_idUser_Commande_idx` (`idUser`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of commande
-- ----------------------------
INSERT INTO `commande` VALUES ('4', '9', 'Mon Sep 23 19:28:12 CST 2019');
INSERT INTO `commande` VALUES ('5', '9', 'Mon Sep 23 19:30:58 CST 2019');

-- ----------------------------
-- Table structure for `commandelist`
-- ----------------------------
DROP TABLE IF EXISTS `commandelist`;
CREATE TABLE `commandelist` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idCommande` int(11) NOT NULL,
  `idLivre` int(11) NOT NULL,
  `qty` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_idCommande_Commande_idx` (`idCommande`),
  KEY `FK_idLivre_CommandeList_idx` (`idLivre`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of commandelist
-- ----------------------------
INSERT INTO `commandelist` VALUES ('5', '4', '4', '1');
INSERT INTO `commandelist` VALUES ('6', '4', '5', '1');
INSERT INTO `commandelist` VALUES ('7', '5', '4', '1');
INSERT INTO `commandelist` VALUES ('8', '5', '16', '3');

-- ----------------------------
-- Table structure for `livre`
-- ----------------------------
DROP TABLE IF EXISTS `livre`;
CREATE TABLE `livre` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(100) NOT NULL,
  `page` int(11) NOT NULL,
  `prix` double NOT NULL,
  `imageUrl` varchar(100) DEFAULT NULL,
  `idCategory` int(11) NOT NULL,
  `description` varchar(255),
  PRIMARY KEY (`id`),
  KEY `FK_IDCategory_ID_idx` (`idCategory`),
  CONSTRAINT `FK_IDCategory` FOREIGN KEY (`idCategory`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of livre
-- ----------------------------
INSERT INTO `livre` VALUES ('3', 'Le Club des mal cités', '300', '26.95', '2605297-gf.jpg', '4', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit');
INSERT INTO `livre` VALUES ('4', 'Burger veggie', '35', '29.95', '2304755-gf.jpg', '3', 'Vivamus id volutpat mi, eu sollicitudin turpis. Aliquam scelerisque metus eu finibus auctor. Nulla facilisi');
INSERT INTO `livre` VALUES ('5', 'Aliss', '554', '16.95', '4314-gf.jpg', '2', 'Nulla et nisi purus. Etiam ac sapien suscipit risus luctus pulvinar. Aliquam fringilla ornare urna sit amet laoreet');
INSERT INTO `livre` VALUES ('6', 'Les Fantômes de Manhattan', '544', '14.95', '2884273-gf.jpg', '1', 'Sed vitae lectus faucibus, aliquam diam a, hendrerit quam. Nunc a sapien nisl. Praesent feugiat massa sit amet metus volutpat tincidunt. Suspendisse pulvinar');
INSERT INTO `livre` VALUES ('7', 'Yoga sur chaise', '256', '29.95', '1707721-gf.jpg', '5', 'nec felis ac suscipit. Praesent nec dui quis odio fermentum euismod. Duis sagittis tortor euismod cursus consectetur');
INSERT INTO `livre` VALUES ('8', 'Excel 2019 pour les nuls : pas à pas', '252', '28.95', '2856942-gf.jpg', '6', 'Nam viverra luctus nisi, at placerat purus ullamcorper at. Vestibulum at hendrerit nulla. Nunc ac enim auctor, fringilla nunc a, auctor ipsum');
INSERT INTO `livre` VALUES ('9', 'Facebook pour les nuls', '320', '32.95', '2775629-gf.jpg', '6', 'Aenean nisi mauris, auctor nec ultricies vel, sollicitudin quis orci. Morbi scelerisque urna nec est tristique, eu laoreet lectus venenatis');
INSERT INTO `livre` VALUES ('10', 'Le Président a disparu', '589', '14.95', '2881872-gf.jpg', '1', 'Cras a scelerisque eros, id tempus nibh. Sed dictum, dolor in varius gravida, elit velit maximus augue, quis ornare quam ex vitae lacus. Ut turpis ex, auctor id venenatis nec, bibendum in purus');
INSERT INTO `livre` VALUES ('11', 'Le Tailleur de pierre', '653', '39.95', '1031014-gf.jpg', '1', 'tortor molestie hendrerit malesuada. Etiam vitae mi vitae diam mollis condimentum id et odio. Vestibulum non bibendum ante');
INSERT INTO `livre` VALUES ('12', 'Le Trône de fer T.01 L\'intégrale', '785', '32.95', '1055475-gf.jpg', '2', 'Fusce maximus posuere diam ut euismod. Nulla facilisi. Donec hendrerit posuere ex, in porttitor tellus dignissim rhoncus. Morbi cursus cursus ante et convallis');
INSERT INTO `livre` VALUES ('13', 'Possession', '543', '34.95', '2420918-gf.jpg', '2', 'Aenean aliquam id lacus a sagittis. Sed condimentum pharetra dui. Duis fermentum semper massa ac pulvinar.');
INSERT INTO `livre` VALUES ('14', 'Eat Happy', '145', '29.95', '2605664-gf.jpg', '3', 'fermentum euismod. Duis sagittis tortor euismod cursus consectetur. Cras vitae ultrices erat. Sed condimentum, arcu et congue mattis');
INSERT INTO `livre` VALUES ('15', 'La Mini-encyclopédie des aliments', '123', '9.95', '974010-gf.jpg', '3', 'ac mollis elit cursus non. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed congue ipsum eget nunc gravida luctus.');
INSERT INTO `livre` VALUES ('16', 'Le Manuel du parfait tannant', '101', '19.95', '2272629-gf.jpg', '4', 'Sed condimentum pharetra dui. Duis fermentum semper massa ac pulvinar.');
INSERT INTO `livre` VALUES ('17', 'Tragédie à l\'Everest', '205', '14.95', '1101599-gf.jpg', '5', 'Nam lacinia urna justo, ut condimentum sapien scelerisque nec');
INSERT INTO `livre` VALUES ('18', 'La Soif', '343', '18.25', '2900047-gf.jpg', '1', 'Etiam sit amet sem nec lorem feugiat laoreet. Suspendisse consectetur sollicitudin mauris, id egestas nibh ultrices vel. Quisque accumsan at magna nec dictum. Donec venenatis');
INSERT INTO `livre` VALUES ('19', 'La Forêt sombre', '532', '44.95', '2343678-gf.jpg', '2', 'drerit quam. Nunc a sapien nisl. Praesent feugiat massa sit amet metus volutpat tincidunt. Suspendisse pulvinar nec felis ac suscipit. Praesent nec dui');

-- ----------------------------
-- Table structure for `panier`
-- ----------------------------
DROP TABLE IF EXISTS `panier`;
CREATE TABLE `panier` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idUser` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_idUser_idx` (`idUser`),
  CONSTRAINT `FK_idUser_Panier` FOREIGN KEY (`idUser`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of panier
-- ----------------------------

-- ----------------------------
-- Table structure for `panierlist`
-- ----------------------------
DROP TABLE IF EXISTS `panierlist`;
CREATE TABLE `panierlist` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idPanier` int(11) NOT NULL,
  `idLivre` int(11) DEFAULT NULL,
  `nombreLivre` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_idPanier_Panier_idx` (`idPanier`),
  KEY `FK_idLivre_PanierList_idx` (`idLivre`),
  CONSTRAINT `FK_idLivre_PanierList` FOREIGN KEY (`idLivre`) REFERENCES `livre` (`id`),
  CONSTRAINT `FK_idPanier_PanierList` FOREIGN KEY (`idPanier`) REFERENCES `panier` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of panierlist
-- ----------------------------

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of role
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `prenom` varchar(45) NOT NULL,
  `nom` varchar(45) NOT NULL,
  `idRole` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `FK_idRole_user_idx` (`idRole`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('9', 'asd7459179@163.com', '111', 'djw', '123', '2');

create database mvc;
use mvc;
create table employees(
 `id` int NOT NULL AUTO_INCREMENT,
  `first_name`varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `salary` numeric,
  PRIMARY KEY (`id`)

);


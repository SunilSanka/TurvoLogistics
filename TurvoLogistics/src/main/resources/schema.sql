-- Dumping database structure for concretepage
CREATE DATABASE IF NOT EXISTS TURVOLOGISTICS;
USE TURVOLOGISTICS; 
-- Dumping structure for table concretepage.articles
-- CREATE TABLE IF NOT EXISTS SHIPMENT(

CREATE  TABLE IF NOT EXISTS SHIPMENT(
  shipment_id DOUBLE NOT NULL AUTO_INCREMENT,
  shipment_code DOUBLE NOT NULL UNIQUE, 
  title varchar(200) NOT NULL,
  shipment_method varchar(100) NOT NULL,
  from_address varchar(300) NOT NULL,
  to_address varchar(300) NOT NULL,
  expected_delivery_date varchar(100) NOT NULL,
  status varchar(200) NOT NULL,
  message varchar(500) NOT NULL,
  PRIMARY KEY(shipment_id)
  );
--) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS USERS(
  user_id DOUBLE NOT NULL AUTO_INCREMENT,
  name varchar(100),
  email varchar(100),	
  number varchar(30),
  aadhar varchar(12) NOT NULL UNIQUE,
  Shipment_Created boolean,
  Shipment_Packed boolean,
  Shipment_Shipped boolean,
  Shipment_Delivered boolean,
  Shipment_Running_Late boolean,
  by_Web boolean,
  by_Email boolean,
  by_SMS boolean,
  PRIMARY KEY(user_id)
  );

CREATE TABLE IF NOT EXISTS EVENT(
  Id Integer(5) NOT NULL AUTO_INCREMENT,
  event_name varchar(200),
  PRIMARY KEY(Id)
  );
 

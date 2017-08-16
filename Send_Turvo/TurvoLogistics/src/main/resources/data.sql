-- Dumping data for table concretepage.articles: ~4 rows (approximately)
TRUNCATE TABLE SHIPMENT;
INSERT INTO SHIPMENT(shipment_id,shipment_code, title, shipment_method,from_address,to_address,expected_delivery_date,status,message) VALUES
	(101, 10010, 'Angular 2 Tutorial using CLI', 'Air','address1','address2','2017-08-11','Created','Order Placed'),
	(102, 10011, 'Spring Boot Getting Started', 'Water','address1','address2','2017-08-11','Created','Order yet to placed'),
	(103, 10012, 'Lambda Expressions Java 8 Example','Rail','address1','address2','2017-08-11','Packed',''),
	(104, 10013, 'Android AsyncTask Example', 'Road','address1','address2','2017-08-11','Shipped','Reached XXX warehouse');
	
TRUNCATE TABLE USERS;	
INSERT INTO USERS(user_id,name,aadhar,email,number,Shipment_Created,Shipment_Packed,Shipment_Shipped,Shipment_Delivered,Shipment_Running_Late,by_Web,by_Email,by_SMS) VALUES
	(101,'Sunil','123456784321','sunil.grt@gmail.com','+919505823652',true,false,true,false,true,true,false,false),
	(102,'Sanka','432187651234','','+919505823652',false,true,false,true,false,true,false,false),
	(103,'SunilSanka','121234345656','sunil-bitsian@live.com','9505823652',true,false,false,true,false,true,false,false);
	
TRUNCATE TABLE EVENT;	
INSERT INTO EVENT(Id,event_name) VALUES
 	(101,'Shipment_Created'),
 	(102,'Shipment_Packed'),
 	(103,'Shipment_Shipped'),
 	(104,'Shipment_Delivered'),
 	(105,'Shipment_RunningLate');


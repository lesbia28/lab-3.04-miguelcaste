-- 1. Normalize the following blog database and write the DDL scripts
-- to create the database tables.

DROP TABLE IF EXISTS author;

CREATE TABLE author(
id INT NOT NULL AUTO_INCREMENT,
name VARCHAR(255),
PRIMARY KEY (id)
);

DROP TABLE IF EXISTS post;

CREATE TABLE post(
id INT NOT NULL AUTO_INCREMENT,
title VARCHAR(255),
word_counts INT,
views INT, 
author_id INT,
PRIMARY KEY (id),
FOREIGN KEY (author_id) REFERENCES author(id)
);

INSERT INTO author(name) VALUES
("Maria Charlotte"),
("Juan Perez"),
("Gemma Alcocer");

INSERT INTO post(title, word_counts,views,author_id) VALUES
("Best Paint Colors",814,14,1),
("Small Space Decorating Tips",1146,221,2),
("Hot Accesories",986,105,1),
("Mixing Textures",765,22,1),
("Kitchen Refresh",1242,307,2),
("Homemade Art Hacks",1002,193,1),
("Refinishing Wood Floors", 1571,7542,3);

-- 2. Normalize the following airline database and write the DDL scripts to create the database tables

 DROP TABLE IF EXISTS customer;
 
CREATE TABLE customer(
id INT NOT NULL AUTO_INCREMENT,
name VARCHAR(255),
status VARCHAR(255),
mileage INT,
PRIMARY KEY(id)
);


DROP TABLE IF EXISTS aircraft;

CREATE TABLE aircraft(
id INT NOT NULL AUTO_INCREMENT,
model VARCHAR(255),
seats INT,
PRIMARY KEY(id)
);

DROP TABLE IF EXISTS flight;

CREATE TABLE flight(
flight_number VARCHAR(255) NOT NULL, 
mileage INT,
aircraft_id INT,
PRIMARY KEY(flight_number),
FOREIGN KEY (aircraft_id) REFERENCES aircraft(id)
);  

DROP TABLE IF EXISTS trip_information;

CREATE TABLE trip_information(
id INT NOT NULL AUTO_INCREMENT,
customer_id INT,
flight_number_id VARCHAR(255),
PRIMARY KEY (id),
FOREIGN KEY (customer_id) REFERENCES customer(id), 
FOREIGN KEY (flight_number_id) REFERENCES flight(flight_number)    
);

INSERT INTO customer(name, status, mileage) VALUES
('Agustine Riviera', 'Silver', 115235),
('Alaina Sepulvida', 'None', 6008),
('Tom Jones', 'Gold', 205767),
('Sam Rio', 'None', 2653),
('Jessica James', 'Silver', 127656),
('Ana Janco', 'Silver', 136773),
('Jennifer Cortez', 'Gold', 300582),
('Christian Janco', 'Silver', 14642);

INSERT INTO	aircraft(model, seats) VALUES
('Boeing 747', 400),
('Airbus A330', 236),
('Boeing 777', 264);

INSERT INTO flight(flight_number, mileage, aircraft_id) VALUES
('DL143', 135, 1),
('DL122', 4370, 2),
('DL53', 2078, 3),
('DL222', 1765, 3),
('DL37', 531, 1);

INSERT INTO	trip_information(customer_id, flight_number_id) VALUES
(1, 'DL143'),
(1, 'DL122'),
(2, 'DL122'),
(1, 'DL143'),
(3, 'DL122'),
(3, 'DL53'),
(1, 'DL143'),
(4, 'DL143'),
(1, 'DL143'),
(3, 'DL222'),
(5, 'DL143'),
(4, 'DL143'),
(6, 'DL222'),
(7, 'DL222'),
(5, 'DL122'),
(4, 'DL37'),
(8, 'DL222');


-- 3. Get the total number of flights in the database.
SELECT COUNT(flight_number) FROM flight;
-- 4. Get the average flight distance.
SELECT AVG (mileage) FROM flight;
-- 5. Get the average number of seats.
SELECT AVG (seats) FROM aircraft;
-- 6. Get the average number of miles flown by customers grouped by status. 
SELECT AVG(mileage), status FROM customer GROUP BY status; 
-- 7. Get the maximum number of miles flown by customers grouped by status.
SELECT MAX(mileage), status FROM customer GROUP BY status; 
-- 8. Get the total number of aircraft with a name containing Boeing.
SELECT COUNT(model) FROM aircraft WHERE model LIKE '%Boeing%';
-- 9. Find all flights with a distance between 300 and 2000 miles.
SELECT (flight_number) FROM flight WHERE mileage BETWEEN 300 AND 2000;
-- 10. Find the average flight distance booked grouped by customer status (this should require a join).
SELECT AVG (f.mileage),c.status FROM trip_information t JOIN (customer c, flight f) ON (t.customer_id=c.id AND t.flight_number_id=f.flight_number) GROUP BY c.status ;
-- 11. Find the most often booked aircraft by gold status members (this should require a join).
SELECT MAX(a.model) FROM trip_information t JOIN (customer c, flight f, aircraft a) ON (t.customer_id= c.id AND t.flight_number_id=f.flight_number AND f.aircraft_id=a.id) WHERE c.status="Gold";


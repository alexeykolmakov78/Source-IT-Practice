DROP TABLE IF EXISTS address;
CREATE TABLE address (
  id      INT NOT NULL PRIMARY KEY,
  code    INT,
  country VARCHAR(50),
  city    VARCHAR(50),
  street  VARCHAR(50),
);

DROP TABLE IF EXISTS passport;
CREATE TABLE passport (
  id            INT NOT NULL PRIMARY KEY,
  first_name    VARCHAR(50),
  middle_name   VARCHAR(50),
  last_name     VARCHAR(50),
  date_of_birth DATE,
  serial_id     VARCHAR(50),
  reg_date      DATE,
  reg_by        VARCHAR(200)
);

DROP TABLE IF EXISTS licence;
CREATE TABLE licence (
  id        INT NOT NULL PRIMARY KEY,
  reg_date  DATE,
  serial_id VARCHAR(50),
  reg_by    VARCHAR(200),
  category  VARCHAR(20)
);

DROP TABLE IF EXISTS autoowner;
CREATE TABLE autoowner (
  id          INT NOT NULL PRIMARY KEY,
  address_id  INT NOT NULL REFERENCES address (id) ON DELETE CASCADE ON UPDATE CASCADE,
  passport_id INT NOT NULL REFERENCES passport (id) ON DELETE CASCADE ON UPDATE CASCADE,
  licence_id  INT REFERENCES licence (id)
);

DROP TABLE IF EXISTS vehicle;
CREATE TABLE vehicle (
  id                INT NOT NULL PRIMARY KEY,
  brand             VARCHAR(50),
  model             VARCHAR(50),
  reg_number        VARCHAR(50),
  autoowner_id      INT NOT NULL REFERENCES autoowner (id) ON DELETE CASCADE ON UPDATE CASCADE,
  production_date   DATE,
  last_service_date DATE,
);

DROP TABLE IF EXISTS offence;
CREATE TABLE offence (
  id           INT NOT NULL PRIMARY KEY,
  date         DATETIME,
  type         VARCHAR(20),
  autoowner_id INT NOT NULL REFERENCES autoowner (id) ON DELETE CASCADE ON UPDATE CASCADE
);

DROP TABLE IF EXISTS rta;
CREATE TABLE rta (
  id         INT NOT NULL PRIMARY KEY,
  date       DATETIME,
  code       INT,
  vehicle_id INT NOT NULL  REFERENCES vehicle (id) ON DELETE CASCADE ON UPDATE CASCADE
);
//1****************************************************************************

INSERT INTO address
VALUES (1, 56892, 'USA', 'New York', 'Park ave 42');

INSERT INTO passport
VALUES (1, 'John', 'Michel', 'Smith', '1978-09-08', 'p12345678', '1994-09-08', 'police department #34355');

INSERT INTO licence
VALUES (1, '1996-09-08', '888888', 'licence department #2', 'C');

INSERT INTO autoowner
VALUES (1, 1, 1, 1);

INSERT INTO vehicle
VALUES (1, 'mazda', 'mx7', 'ax3456bt', 1, '2008-01-08', '2013-01-08');

INSERT INTO offence
VALUES (1, '2014-05-09', 'DRUNK', 1);

//2****************************************************************************

INSERT INTO address
VALUES (2, 45545, 'USA', 'New York', 'Grand st 4546');

INSERT INTO passport
VALUES (2, 'Samantha', 'Robin', 'Roberts', '1995-04-11', 'p4578166', '2011-05-04', 'police department #145877');

INSERT INTO licence
VALUES (2, '2010-11-11', '9988456', 'licence department #2', 'B');

INSERT INTO autoowner
VALUES (2, 2, 2, 2);

INSERT INTO vehicle
VALUES (2, 'Toyota', 'Corolla', '4445888', 2, '2010-05-13', '2012-03-02');

INSERT INTO offence
VALUES (2, '2012-06-19', 'DRUNK', 2);

//3****************************************************************************
INSERT INTO address
VALUES (3, 23452, 'USA', 'Las Vegas', 'Paris road 23');

INSERT INTO passport
VALUES (3, 'Smith', 'Smith', 'Stuart', '1988-01-11', 'p3578956', '2012-11-12', 'police department #178888');

INSERT INTO licence
VALUES (3, '2011-07-05', '5598866', 'licence department #3', 'C');

INSERT INTO autoowner
VALUES (3, 3, 3, 3);

INSERT INTO vehicle
VALUES (3, 'Ford', 'Cuga', 'sdc1256', 3, '2004-06-16', '2012-03-02');

//4****************************************************************************
INSERT INTO address
VALUES (4, 23889, 'USA', 'San Francisco', 'Mission st 458');

INSERT INTO passport
VALUES (4, 'Ted', 'Lee', 'Poo', '1995-04-11', 'p4578166', '2011-05-04', 'police department #141111');

INSERT INTO licence
VALUES (4, '2012-11-11', '25498', 'licence department #2', 'B');

INSERT INTO autoowner
VALUES (4, 4, 4, 4);

INSERT INTO vehicle
VALUES (4, 'Toyota', 'Rav 4', 'we3999ww', 4, '2010-11-21', '2013-02-22');

//5****************************************************************************
INSERT INTO address
VALUES (5, 25894, 'USA', 'Las Vegas', 'Paris road 23');

INSERT INTO passport
VALUES (5, 'Ted', 'Lee', 'Brown', '1995-04-11', 'p4578166', '2011-05-04', 'police department #145877');

INSERT INTO licence
VALUES (5, '2009-02-01', '3650932', 'licence department #3', 'B');

INSERT INTO autoowner
VALUES (5, 5, 5, 5);

INSERT INTO vehicle
VALUES (5, 'Toyota', 'Land Cruiser 200', 'as4345de', 5, '2009-09-09', '2014-07-08');

//6****************************************************************************
INSERT INTO address
VALUES (6, 98008, 'USA', 'Los Angeles', 'Broadway');

INSERT INTO passport
VALUES (6, 'Jack', 'Roberts', 'Brown', '1998-10-10', 'p486636', '2010-07-08', 'police department #145877');

INSERT INTO licence
VALUES (6, '2012-11-22', '3097357', 'licence department #3', 'B');

INSERT INTO autoowner
VALUES (6, 6, 6, 6);

INSERT INTO vehicle
VALUES (6, 'Audi', 'tt', 'ax2221fr', 6, '2004-04-11', '2012-03-02');

//7****************************************************************************
INSERT INTO address
VALUES (7, 67854, 'USA', 'San Francisco', 'Mission st 111');

INSERT INTO passport
VALUES (7, 'William', 'Grady', 'Smith', '1978-11-11', 'p4578166', '2011-05-04', 'police department #145877');

INSERT INTO licence
VALUES (7, '2008-08-07', '7662554', 'licence department #7', 'B');

INSERT INTO autoowner
VALUES (7, 7, 7, 7);

INSERT INTO vehicle
VALUES (7, 'Toyota', 'Cruiser Prado', 'aw86869', 7, '2011-02-01', '2013-08-08');

//8****************************************************************************
INSERT INTO address
VALUES (8, 45289, 'USA', 'Las Vegas', '122 street 567');

INSERT INTO passport
VALUES (8, 'Ted', 'Lee', 'Poo', '1989-05-12', 'p4695666', '2012-09-07', 'police department #145677');

INSERT INTO licence
VALUES (8, '2014-11-11', '46356tt', 'licence department #2', 'C');

INSERT INTO autoowner
VALUES (8, 8, 8, 8);

INSERT INTO vehicle
VALUES (8, 'BMW', 'M520', 'ax8988de', 2, '2011-01-30', '2013-03-11');

//9****************************************************************************
INSERT INTO address
VALUES (9, 78965, 'USA', 'Los Angeles', '3 ave 23');

INSERT INTO passport
VALUES (9, 'john', 'D', 'Francklin', '1977-09-15', 'p442569', '2011-05-04', 'police department #153466');

INSERT INTO licence
VALUES (9, '2012-11-20', '546121', 'licence department #5', 'B');

INSERT INTO autoowner
VALUES (9, 9, 9, 9);

INSERT INTO vehicle
VALUES (9, 'BMW', 'X6', 'ww000www', 9, '2010-08-16', '2013-09-22');

//10****************************************************************************
INSERT INTO address
VALUES (10, 12584, 'USA', 'New York', 'Park ave 1');

INSERT INTO passport
VALUES (10, 'Bill', 'Mark', 'Gates', '1967-01-23', 'p662252', '2012-11-20', 'police department #875236');

INSERT INTO licence
VALUES (10, '2013-10-12', '7444454', 'licence department #3', 'B');

INSERT INTO autoowner
VALUES (10, 10, 10, 10);

INSERT INTO vehicle
VALUES (10, 'Mercedes', 'SLR 500', '500', 10, '2004-04-11', '2012-03-02');

//4 cars more ********************************************************************
INSERT INTO vehicle
VALUES (11, 'Toyota', 'Camry', 'rt5678uy', 2, '2011-02-23', '2013-08-04');

INSERT INTO vehicle
VALUES (12, 'Toyota', 'Corolla', 'qw435222', 2, '2009-01-15', '2012-11-05');

INSERT INTO vehicle
VALUES (13, 'Mercedes', 'SLK 700', 'aa0001aa', 9, '2007-06-21', '2011-10-01');

INSERT INTO vehicle
VALUES (14, 'Audi', 'R8', '888888', 9, '2008-10-22', '2014-03-05');

//rta ****************************************************************************

INSERT INTO rta
VALUES (1, '2012-12-21', 111111, 5);
INSERT INTO rta
VALUES (2, '2014-11-12', 555555, 1);
INSERT INTO rta
VALUES (3, '2012-06-05', 333333, 1);
INSERT INTO rta
VALUES (4, '2013-08-22', 222222, 9);
INSERT INTO rta
VALUES (5, '2008-05-13', 444444, 14);

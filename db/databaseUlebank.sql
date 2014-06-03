drop database databaseUlebank;

CREATE DATABASE databaseUlebank;

GRANT ALL ON databaseUlebank.* TO springappuser@'%' IDENTIFIED BY 'pspringappuser';
GRANT ALL ON databaseUlebank.* TO springappuser@localhost IDENTIFIED BY 'pspringappuser';

USE databaseUlebank;

CREATE TABLE office (
	id INTEGER PRIMARY KEY,
	idOffice varchar(4),
	address varchar(50),
 	balance decimal(15,2),
 	utilitiesCost decimal(15,2),
	localCost decimal(15,2),
	employeeCost decimal(15,2)
);
CREATE INDEX office_idOffice ON office(idOffice);
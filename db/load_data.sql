INSERT INTO Bank(bankID) values ('2104');
INSERT INTO Offices (officeID, bankID, account, address, balance, utilitiesCost, localCost, employeeCost, city, postCode, telephone) values('7654', '2104', '0001','Quevedo', 57821.26, 3034.58, 15500.00, 25078.08, 'Leon','24567','987222222');
INSERT INTO Offices (officeID, bankID, account, address, balance, utilitiesCost, localCost, employeeCost, city, postCode, telephone) values('5678', '2104', '0002','Gran via', 2450.71, 1060.56, 10000.00, 14321.97, 'Madrid','28004','912444444');
INSERT INTO Offices (officeID, bankID, account, address, balance, utilitiesCost, localCost, employeeCost, city, postCode, telephone) values('8910', '2104', '0003','Eras', 12060.16, 2351.77, 12900.00, 17098.00, 'Leon','24010','987888888');
INSERT INTO Accounts(accountID, officeID, balance, lastLiquidationTime, liquidationFrequency, maxOverdraft) values ('0001','7654', 5.4,'2014-04-22 16:00:00', 4, 5.3);
INSERT INTO Accounts(accountID, officeID, balance, lastLiquidationTime, liquidationFrequency, maxOverdraft) values ('0002','7654', 4.3,'2014-03-23 17:00:00', 4, 4.2);
INSERT INTO Accounts(accountID, officeID, balance, lastLiquidationTime, liquidationFrequency, maxOverdraft) values ('0003','5678', 3.2,'2014-03-22 18:00:00', 4, 3.1);

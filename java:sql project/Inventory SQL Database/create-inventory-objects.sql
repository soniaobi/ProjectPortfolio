DROP DATABASE IF EXISTS InventoryDB;
CREATE DATABASE InventoryDB; 
USE InventoryDB;

DROP TABLE IF EXISTS SUPPLIER;
CREATE TABLE SUPPLIER(
SupplierID	INTEGER NOT NULL AUTO_INCREMENT,
SName		varchar(50), 
SType 		varchar(13),
Address		varchar(50),
CName 		varchar(20),
Phone		varchar(12),
primary key (SupplierID)
);

DROP TABLE IF EXISTS INTERNATIONAL;
CREATE TABLE INTERNATIONAL(
SupplierID		INTEGER NOT NULL,
ImportTax		DOUBLE(5,2),
primary key (SupplierID),
foreign key (SupplierID) references SUPPLIER(SupplierID)
ON DELETE CASCADE
ON UPDATE CASCADE
);

DROP TABLE IF EXISTS TOOL;
CREATE TABLE TOOL(
ToolID		INTEGER NOT NULL AUTO_INCREMENT,
TName		varchar(20),
TType 		varchar(20),
Quantity 	integer,
Price		DOUBLE(5,2),
SupplierID	INTEGER NOT NULL,
primary key (toolID),
foreign key (SupplierID) references SUPPLIER(SupplierID)
ON DELETE CASCADE
ON UPDATE CASCADE
);

DROP TABLE IF EXISTS ELECTRICAL;
CREATE TABLE ELECTRICAL(
ToolID		INTEGER NOT NULL,
PowerType	varchar(25),
primary key (ToolID),
foreign key (ToolID) references TOOL(ToolID)
ON DELETE CASCADE
ON UPDATE CASCADE
);

DROP TABLE IF EXISTS TOOLORDER;
CREATE TABLE TOOLORDER(
OrderID		INTEGER NOT NULL AUTO_INCREMENT,
OrderDate	Date,
primary key (OrderID)
);

DROP TABLE IF EXISTS ORDERLINE;
CREATE TABLE ORDERLINE(
OrderID		INTEGER NOT NULL,
ToolID		INTEGER NOT NULL,
SupplierID	INTEGER NOT NULL,
Quantity 	integer not null,
primary key (OrderID, ToolID),
foreign key (OrderID) references TOOLORDER(OrderID) ON DELETE CASCADE ON UPDATE CASCADE,
foreign key (ToolID) references TOOL(ToolID)ON DELETE CASCADE ON UPDATE CASCADE,
foreign key (SupplierID) references SUPPLIER(SupplierID) ON DELETE CASCADE ON UPDATE CASCADE
);

DROP TABLE IF EXISTS CLIENT;
CREATE TABLE CLIENT(
ClientID	INTEGER NOT NULL AUTO_INCREMENT, 
LName		varchar(20), #max length of 20
FName		varchar(20), #max length of 20
CType 		varchar(1), #R for residential or C for commercial
PhoneNum	varchar (12), #max length of 12
Address 	varchar(50), #max length of 50
PostalCode	varchar(7), #max length 7
primary key (ClientID)
);

DROP TABLE IF EXISTS PURCHASES;
CREATE TABLE PURCHASES(
ClientID		INTEGER NOT NULL,
ToolID			INTEGER NOT NULL,
PurchaseDate	Date not null,
primary key (ClientID, ToolID, PurchaseDate),
foreign key (ClientID) references CLIENT(ClientID) ON DELETE CASCADE ON UPDATE CASCADE,
foreign key (ToolID) references TOOL(ToolID) ON DELETE CASCADE ON UPDATE CASCADE
);

use master
go

drop database if exists ArtSuppliesShop 
go

create database ArtSuppliesShop
go

use ArtSuppliesShop
go

CREATE TABLE [User] (
  [id] int PRIMARY KEY NOT NULL IDENTITY(1, 1),
  [role] varchar(15) NOT NULL,
  [firstName] nvarchar(50),
  [lastName] nvarchar(50),
  [street] varchar(50),
  [city] varchar(30),
  [province] varchar(30),
  [country] varchar(30),
  [email] varchar(50),
  [password] varchar(20),
  [phone] varchar(15)
)
GO

CREATE TABLE [UserPayment] (
  [userId] int NOT NULL,
  [paymentId] int NOT NULL,
  [paymentInfo] varchar(1000) NOT NULL,
  PRIMARY KEY ([userId], [paymentId])
)
GO

CREATE TABLE [Payment] (
  [id] int PRIMARY KEY NOT NULL IDENTITY(1, 1),
  [paymentType] varchar(50) NOT NULL
)
GO

CREATE TABLE [Product] (
  [id] int PRIMARY KEY NOT NULL IDENTITY(1, 1),
  [categoryId] int NOT NULL,
  [brandId] int NOT NULL,
  [name] nvarchar(200),
  [description] nvarchar(4000),
  [price] float NOT NULL,
  [discount] float DEFAULT (0),
  [quantity] int NOT NULL DEFAULT (0)
)
GO

CREATE TABLE [Category] (
  [id] int PRIMARY KEY NOT NULL IDENTITY(1, 1),
  [name] nvarchar(20) NOT NULL
)
GO

CREATE TABLE [Brand] (
  [id] int PRIMARY KEY NOT NULL IDENTITY(1, 1),
  [name] nvarchar(20) NOT NULL
)
GO

CREATE TABLE [Order] (
  [id] int PRIMARY KEY NOT NULL IDENTITY(1, 1),
  [userId] int NOT NULL,
  [shipTo] nvarchar(50),
  [shipStreet] varchar(50),
  [shipCity] varchar(30),
  [shipProvince] varchar(30),
  [shipCountry] varchar(30),
  [shipEmail] varchar(50),
  [shipPhone] varchar(15),
  [status] nvarchar(255) NOT NULL,
  [createdTime] datetime
)
GO

CREATE TABLE [OrderDetail] (
  [id] int PRIMARY KEY NOT NULL IDENTITY(1, 1),
  [orderId] int NOT NULL,
  [productId] int NOT NULL,
  [productName] nvarchar(200) NOT NULL,
  [price] float NOT NULL,
  [quantity] int NOT NULL DEFAULT (1)
)
GO

CREATE TABLE [Cart] (
  [id] int PRIMARY KEY NOT NULL,
  [sessionId] varchar(32),
  [userId] int
)
GO

CREATE TABLE [CartItem] (
  [id] int NOT NULL,
  [cartId] int NOT NULL,
  [productId] int NOT NULL,
  [productName] nvarchar(200) NOT NULL,
  [price] float NOT NULL,
  [quantity] int NOT NULL DEFAULT (1),
  PRIMARY KEY ([id], [cartId])
)
GO

ALTER TABLE [UserPayment] ADD FOREIGN KEY ([userId]) REFERENCES [User] ([id])
GO

ALTER TABLE [UserPayment] ADD FOREIGN KEY ([paymentId]) REFERENCES [Payment] ([id])
GO

ALTER TABLE [Product] ADD FOREIGN KEY ([categoryId]) REFERENCES [Category] ([id])
GO

ALTER TABLE [Product] ADD FOREIGN KEY ([brandId]) REFERENCES [Brand] ([id])
GO

ALTER TABLE [Order] ADD FOREIGN KEY ([userId]) REFERENCES [User] ([id])
GO

ALTER TABLE [OrderDetail] ADD FOREIGN KEY ([orderId]) REFERENCES [Order] ([id])
GO

ALTER TABLE [OrderDetail] ADD FOREIGN KEY ([productId]) REFERENCES [Product] ([id])
GO

ALTER TABLE [Cart] ADD FOREIGN KEY ([userId]) REFERENCES [User] ([id])
GO

ALTER TABLE [CartItem] ADD FOREIGN KEY ([cartId]) REFERENCES [Cart] ([id])
GO

ALTER TABLE [CartItem] ADD FOREIGN KEY ([productId]) REFERENCES [Product] ([id])
GO

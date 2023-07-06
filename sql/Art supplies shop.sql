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
  [price] float NOT NULL DEFAULT (0),
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

CREATE TABLE [ProductReview] (
  [userId] int NOT NULL,
  [productId] int NOT NULL,
  [content] nvarchar(2000),
  PRIMARY KEY ([userId], [productId])
)
GO

CREATE TABLE [Favorite] (
  [userId] int NOT NULL,
  [productId] int NOT NULL,
  PRIMARY KEY ([userId], [productId])
)
GO

CREATE TABLE [Order] (
  [id] int PRIMARY KEY NOT NULL IDENTITY(1, 1),
  [userId] int NOT NULL,
  [status] nvarchar(255) NOT NULL,
  [createdTime] datetime
)
GO

CREATE TABLE [OrderDetail] (
  [id] int PRIMARY KEY NOT NULL IDENTITY(1, 1),
  [orderId] int NOT NULL,
  [productId] int NOT NULL,
  [quantity] int NOT NULL DEFAULT (1)
)
GO

CREATE TABLE [Cart] (
  [id] int PRIMARY KEY NOT NULL,
  [sessionId] varchar(32) NOT NULL,
  [userId] int NOT NULL
)
GO

CREATE TABLE [CartItem] (
  [id] int PRIMARY KEY NOT NULL,
  [cartId] int NOT NULL,
  [productId] int NOT NULL,
  [quantity] int NOT NULL DEFAULT (1)
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

ALTER TABLE [ProductReview] ADD FOREIGN KEY ([userId]) REFERENCES [User] ([id])
GO

ALTER TABLE [ProductReview] ADD FOREIGN KEY ([productId]) REFERENCES [Product] ([id])
GO

ALTER TABLE [Favorite] ADD FOREIGN KEY ([userId]) REFERENCES [User] ([id])
GO

ALTER TABLE [Favorite] ADD FOREIGN KEY ([productId]) REFERENCES [Product] ([id])
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

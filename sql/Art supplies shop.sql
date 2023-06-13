CREATE TABLE [User] (
  [id] int PRIMARY KEY NOT NULL IDENTITY(1, 1),
  [roleId] int NOT NULL,
  [firstName] nvarchar(50),
  [lastName] nvarchar(50),
  [email] varchar(50),
  [phone] varchar(15)
)
GO

CREATE TABLE [Payment] (
  [id] int PRIMARY KEY NOT NULL IDENTITY(1, 1),
  [userId] int NOT NULL,
  [paymentType] varchar(50) NOT NULL,
  [paymentInfo] varchar(100) NOT NULL
)
GO

CREATE TABLE [Product] (
  [id] int PRIMARY KEY NOT NULL IDENTITY(1, 1),
  [categoryId] int NOT NULL,
  [name] nvarchar(200),
  [description] nvarchar(10000),
  [price] float NOT NULL DEFAULT (0),
  [discount] int DEFAULT (0),
  [quantity] int NOT NULL DEFAULT (0)
)
GO

CREATE TABLE [InCategory] (
  [productId] int NOT NULL,
  [categoryId] int NOT NULL,
  PRIMARY KEY ([productId], [categoryId])
)
GO

CREATE TABLE [Category] (
  [id] int PRIMARY KEY NOT NULL IDENTITY(1, 1),
  [name] nvarchar(20) NOT NULL
)
GO

CREATE TABLE [ProductReview] (
  [id] int PRIMARY KEY NOT NULL IDENTITY(1, 1),
  [userId] int NOT NULL,
  [productId] int NOT NULL,
  [content] nvarchar(2000)
)
GO

CREATE TABLE [Order] (
  [id] int PRIMARY KEY NOT NULL IDENTITY(1, 1),
  [userId] int NOT NULL,
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

CREATE TABLE [Role] (
  [id] int PRIMARY KEY NOT NULL IDENTITY(1, 1),
  [roleName] varchar(15) NOT NULL
)
GO

CREATE TABLE [RolePermission] (
  [roleId] int NOT NULL,
  [permissionId] int NOT NULL,
  PRIMARY KEY ([roleId], [permissionId])
)
GO

CREATE TABLE [Permission] (
  [id] int PRIMARY KEY NOT NULL IDENTITY(1, 1),
  [permissionName] varchar(20) NOT NULL
)
GO

ALTER TABLE [User] ADD FOREIGN KEY ([roleId]) REFERENCES [Role] ([id])
GO

ALTER TABLE [Payment] ADD FOREIGN KEY ([userId]) REFERENCES [User] ([id])
GO

ALTER TABLE [InCategory] ADD FOREIGN KEY ([productId]) REFERENCES [Product] ([id])
GO

ALTER TABLE [InCategory] ADD FOREIGN KEY ([categoryId]) REFERENCES [Category] ([id])
GO

ALTER TABLE [ProductReview] ADD FOREIGN KEY ([userId]) REFERENCES [User] ([id])
GO

ALTER TABLE [ProductReview] ADD FOREIGN KEY ([productId]) REFERENCES [Product] ([id])
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

ALTER TABLE [RolePermission] ADD FOREIGN KEY ([roleId]) REFERENCES [Role] ([id])
GO

ALTER TABLE [RolePermission] ADD FOREIGN KEY ([permissionId]) REFERENCES [Permission] ([id])
GO

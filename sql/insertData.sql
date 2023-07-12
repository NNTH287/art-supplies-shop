use master

use ArtSuppliesShop
go

INSERT INTO [User]
VALUES ('Admin', 'Huy', 'Nguyen', '288, thon 3, xa Thach Hoa, huyen Thach That', 'Ha Noi', 'Hanoi', 'Vietnam', 'huyhol287@gmail.com', '123456', '0911362307'),
	('Customer', 'Thu', 'Le', 'National Highway 1A', 'Vinh Tan Ward', 'Binh Thuan', 'Vietnam', 'lethu@hotmail.com', '123456', '0292827403'),
	('Customer', 'Giang', 'Dao', '10 Quang Trung St.', 'Binh Dinh Townlet', 'Binh Dinh', 'Vietnam', 'giang@mail.com', '123456', '0493891233'),
	('Customer', 'Long', 'Pham', '266B Nguyen Tieu La St., Ward 8, Dist. 10', 'Ho Chi Minh City', 'Ho Chi Minh City', 'Vietnam', 'long@mail.com', '123456', '(171) 555-9199'),
	('Customer', 'Nam', 'Nguyen', '30 Pho Duc Chinh Street, Truc Bach Ward', 'Ba Dinh District', 'Hanoi', 'Vietnam', 'nam@mail.com', '123456', '0241-059428'),
	('Customer', 'Hung', 'Thai', '9 Duong Thanh Street', 'Hoan Kiem District', 'Hanoi', 'Vietnam', 'hung@mail.com', '123456', '(91) 555 55 93'),
	('Customer', 'Kien', 'Dinh', '101 Le Loi Street, Ward 1', 'My Tho City', 'Tien Giang', 'Vietnam', 'kien@mail.com', '123456', '(2) 354-2535'),
	('Customer', 'Ngan', 'Nguyen', '279 Nguyen Van Luong, District 6', 'Ho Chi Minh City', 'Ho Chi Minh City', 'Vietnam', 'ngan@mail.com', '123456', '(93) 203 4561'),
	('Customer', 'Khanh', 'Pham', '14A Trung Trac Street, Le Hong Phong Ward', 'Le Hong Phong Ward', 'Thai Binh', 'Vietnam', 'khanh@mail.com', '123456', '(2) 283-3397'),
	('Customer', 'Cuong', 'Ngo', 'nha B15, Do thi moi Dai Kim, Hoang Mai', 'Ha Noi', 'Hanoi', 'Vietnam', 'cuong@mail.com', '123456', '(5) 555-1340')

INSERT INTO [Payment]
VALUES ('Credit Card'),
	('Cash on delivery')

INSERT INTO [UserPayment]
VALUES (1, 1, '2237102713301732|12|2025|636'),
	(2, 1, '2516222582636471|08|2028|737'),
	(3, 1, '2432547657447540|03|2026|613'),
	(5, 1, '4175707766525506|11|2027|886'),
	(7, 1, '578723287801764|09|2027|264'),
	(8, 1, '326246871035818|04|2026|374'),
	(1, 2, 'Street: 37/49B, C1 Street, Ward 13|City: Tan Binh District|State/province/area: Ho Chi Minh City'),
	(2, 2, 'Street: National Highway 1A|City:   Vinh Tan Ward|State/province/area: Binh Thuan'),
	(3, 2, 'Street: 10 Quang Trung St.|City: Binh Dinh Townlet|State/province/area: Binh Dinh'),
	(4, 2, 'Street: 266B Nguyen Tieu La St., Ward 8, Dist. 10|City: Ho Chi Minh City|State/province/area: Ho Chi Minh City'),
	(5, 2, 'Street: 30 Pho Duc Chinh Street, Truc Bach Ward|City: Ba Dinh District|State/province/area: Hanoi'),
	(6, 2, 'Street: 9 Duong Thanh Street|City: Hoan Kiem District|State/province/area: Hanoi'),
	(7, 2, 'Street: 101 Le Loi Street, Ward 1|City: My Tho City|State/province/area: Tien Giang'),
	(8, 2, 'Street: 279 Nguyen Van Luong, District 6|City: Ho Chi Minh City|State/province/area: Ho Chi Minh City'),
	(9, 2, 'Street: 14A Trung Trac Street, Le Hong Phong Ward|City: Le Hong Phong Ward|State/province/area: Thai Binh'),
	(10, 2, 'Street: 19/9 Tan Ky Tan Quy, Tan Son Nhi Ward|City: Tan Phu Dist.|State/province/area: Ho Chi Minh City')

INSERT INTO [Category]
VALUES ('Others'),
	('Combo'),
	('Pen'),
	('Brush'),
	('Paint'),
	('Paper')

INSERT INTO [Brand]
VALUES ('Nobrand'),
	('Van Gogh'),
	('Holbein'),
	('White Nights'),
	('Mono'),
	('Nabii')

INSERT INTO [Product]
VALUES (6, 6, 'Sketchbook Nabii Ima 160gsm', 'Paper weight: 160gsm. Quantity: 32 sheets/book. Size: A5, A4 size. Color: Cream. Paper grain: Light grain', 75000, 0.05, 5),
	(5, 2, 'Van Gogh Watercolor (tin box)', 'Specification: Color in half pan. Empty tin box in the middle can hold a brush', 1160000, 0.1, 3),
	(5, 3, 'Gansai Japanese Holbein Watercolor', 'Gansai Japanese Holbein watercolor belongs to the segment of high-class students from Japan. The color is produced based on the traditional Japanese color formula (semi-transparent color). Some hot tones are quite clear and fresh, the rest of the color palette is semi-transparent, some colors have pretty good coverage. Luxurious design color is very suitable for gifts or collectibles. The color is also suitable for those of you who want to try a new material. Color suitable for many types of paintings such as landscape, illustration, anime, still life, ...', 496000, 0, 10),
	(6, 3, 'Maxon drawing paper', 'Maxon comic paper is a specialized line of paper for drawing manga. Smooth paper, pre-lined with a picture frame at the edge to draw stories. Paper suitable for drawing iron pens, needle pens. The surface of the paper makes the drawing process smoother, and the nib lasts longer. Paper tough, anti-fraying', 68000, 0, 5),
	(4, 3, 'Maxon drawing brushes set', 'Holbein Maxon comic pen and brush set includes a full set of pens and brushes that Japanese artists specialize in drawing comics, bringing', 340000, 0, 20),
	(5, 4, 'White Nights pellets watercolor', 'White Nights watercolor is similar to Leningrad color, the color is flexible and moist when coming to Vietnam due to the different climate. The color is clear, the color spread is relatively good. White Nights color is suitable for those who are new to watercolor painting or artists who need to practice a lot.', 305000, 0.05, 18),
	(6, 4, 'White Nights drawing paper', 'Cold press paper pattern, 200gsm quantification. A4 and A5 page format has 20 sheets. Product of Nevskaya Palitra - Russia.', 62000, 0.15, 32),
	(3, 4, 'White Nights drawing pensset', 'Paper box. Available in set format of 12 colors. Watercolor is durable and beautiful, stable like watercolor. Genuine imported product Nevskaya Palitra.', 150000, 0, 24),
	(1, 5, 'Mono Dust catch', 'When cleaning, the bleach will stick together, avoiding many small pieces. Clean and sanitize.', 25000, 0, 47),
	(1, 5, 'Mono Graph dusty color limited mechanical pencil', 'Pencil with 0.5mm tip. The tip of the pen is made of metal, the body of the pen is made of plastic. When using, gently shake the pen, the lead will be automatically ejected. There is an eraser at the end of the pen, slightly turning the eraser head will be pushed up', 85000, 0.1, 56),
	(1, 1, 'Paper cutting table', 'Support cutting pictures, photos quickly, straight 1 line. The product can cut 300gsm . thick paper', 145000, 0, 14),
	(1, 1, 'Mini paper cutting knife', 'Support cutting pictures, photos quickly, straight 1 line. The product can cut 300gsm . thick paper', 12000, 0, 51),
	(1, 1, 'Professional geometric drawing ruler', 'Professional geometric drawing rulers support drawing, drawing advanced molds on request with a variety of designs and sizes. The product is suitable for drawing technical drawings, geometry or application in DIY, crafts, collage, ...', 40000, 0, 54),
	(2, 2, 'Combo Van Gogh Watercolor', 'Gansai Japanese Holbein watercolor belongs to the segment of high-class students from Japan. The color is produced based on the traditional Japanese color formula (semi-transparent color). Some hot tones are quite clear and fresh, the rest of the color palette is semi-transparent, some colors have pretty good coverage. Luxurious design color is very suitable for gifts or collectibles. The color is also suitable for those of you who want to try a new material. Color suitable for many types of paintings such as landscape, illustration, anime, still life, ...', 1250000, 0.2, 3),
	(2, 3, 'Combo Holbein Watercolor', 'Gansai Japanese Holbein watercolor belongs to the segment of high-class students from Japan. The color is produced based on the traditional Japanese color formula (semi-transparent color). Some hot tones are quite clear and fresh, the rest of the color palette is semi-transparent, some colors have pretty good coverage. Luxurious design color is very suitable for gifts or collectibles. The color is also suitable for those of you who want to try a new material. Color suitable for many types of paintings such as landscape, illustration, anime, still life, ...', 250000, 0.06, 12),
	(2, 4, 'Combo White Nights Watercolor', 'Gansai Japanese Holbein watercolor belongs to the segment of high-class students from Japan. The color is produced based on the traditional Japanese color formula (semi-transparent color). Some hot tones are quite clear and fresh, the rest of the color palette is semi-transparent, some colors have pretty good coverage. Luxurious design color is very suitable for gifts or collectibles. The color is also suitable for those of you who want to try a new material. Color suitable for many types of paintings such as landscape, illustration, anime, still life, ...', 1000000, 0.1, 5),
	(2, 6, 'Combo Nabii Sketchbook', 'Gansai Japanese Holbein watercolor belongs to the segment of high-class students from Japan. The color is produced based on the traditional Japanese color formula (semi-transparent color). Some hot tones are quite clear and fresh, the rest of the color palette is semi-transparent, some colors have pretty good coverage. Luxurious design color is very suitable for gifts or collectibles. The color is also suitable for those of you who want to try a new material. Color suitable for many types of paintings such as landscape, illustration, anime, still life, ...', 2000000, 0.25, 7)



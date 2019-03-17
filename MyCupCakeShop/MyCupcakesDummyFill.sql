USE MyCupCakes;


INSERT INTO Users(adminId, username, pass, email, balance)
VALUES(1, 'Dennis','1234','test@test.dk', 100.00),
(0, 'Customer', '1234', 'cus@test.dk', 100.00);

INSERT INTO Toppings(flavour, price)
VALUES('Chocolate', 5.00),
('Blueberry', 5.00),
('Rasberry', 5.00),
('Crispy', 6.00),
('Strawberry', 6.00),
('Rum/Raisin', 7.00),
('Orange', 8.00),
('Lemon', 8.00),
('Blue cheese', 9.00);

INSERT INTO Bottoms(flavour, price)
VALUES('Chocolate', 5.00),
('Vanilla', 5.00),
('Nutmeg', 5.00),
('Pistacio', 6.00),
('Almond', 7.00);


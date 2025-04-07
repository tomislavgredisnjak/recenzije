INSERT INTO product (id, code, name, price_eur, price_usd, description)
VALUES (100, '0000000001aaaaa', 'Samsung Galaxy S23', 1000.0, 1000.0, 'Samsung Galaxy S23 mobitel');
INSERT INTO product (id, code, name, price_eur, price_usd, description)
VALUES (101, '0000000002aaaaa', 'Samsung Galaxy S24', 1100.0, 1100.0, 'Samsung Galaxy S24 mobitel');
INSERT INTO product (id, code, name, price_eur, price_usd, description)
VALUES (102, '0000000002aaaab', 'Samsung Galaxy S25', 1200.0, 1200.0, 'Samsung Galaxy S25 mobitel');
INSERT INTO product (id, code, name, price_eur, price_usd, description)
VALUES (103, '0000000003aaaaa', 'Iphone 15', 1300.0, 1300.0, 'Iphone 15 mobitel');
INSERT INTO product (id, code, name, price_eur, price_usd, description)
VALUES (104, '0000000003aaaab', 'Iphone 16', 1400.0, 1400.0, 'Iphone 16 mobitel');

INSERT INTO review (product_id, reviewer, text, rating) VALUES (100, 'Tomislav', 'Odličan mob!', 5);
INSERT INTO review (product_id, reviewer, text, rating) VALUES (100, 'Ivan', 'Jako dobar mob!', 4);
INSERT INTO review (product_id, reviewer, text, rating) VALUES (101, 'Martin', 'OK mob!', 3);
INSERT INTO review (product_id, reviewer, text, rating) VALUES (101, 'Petar', 'Vrlo dobar stvarno mob!', 4);
INSERT INTO review (product_id, reviewer, text, rating) VALUES (102, 'Šestar', 'Paaa okej je ajde!', 3);
INSERT INTO review (product_id, reviewer, text, rating) VALUES (102, 'Marta', 'Savršenstvo!', 5);
INSERT INTO review (product_id, reviewer, text, rating) VALUES (103, 'Mihael', 'Tak tak', 2);
INSERT INTO review (product_id, reviewer, text, rating) VALUES (103, 'Leonardo', 'Očajno', 1);
INSERT INTO review (product_id, reviewer, text, rating) VALUES (104, 'Ana', 'Supač!', 5);
INSERT INTO review (product_id, reviewer, text, rating) VALUES (104, 'Karla', 'Ma baš za moje potrebe!', 5);

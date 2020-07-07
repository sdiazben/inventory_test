DROP TABLE IF EXISTS INVENTORY;
 
CREATE TABLE INVENTORY (
  sku INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  count INT NOT NULL
);
 
INSERT INTO INVENTORY (name, count) VALUES
  ('Pear', 40),
  ('Golden apple', 60),
  ('Banana', 80),
  ('Orange', 55),
  ('Lemon', 30),
  ('Onion', 43),
  ('Carrot', 33),
  ('Potato', 148),
  ('Avocado', 17),
  ('Eggplant', 44);
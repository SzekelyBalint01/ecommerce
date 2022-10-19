/*DROP TABLE IF EXISTS cart;

DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS users;

CREATE TABLE users(id serial PRIMARY KEY, name VARCHAR(255), password VARCHAR(255), email VARCHAR(255), address varchar(255));
CREATE TABLE products(id serial PRIMARY KEY, name VARCHAR(255), price integer, type varchar(250), description VARCHAR(1000), image VARCHAR(150), onstock boolean, location varchar(500));


CREATE TABLE cart (
  user_id    int REFERENCES users (id)
, product_id int REFERENCES products (id)
, CONSTRAINT cart_pkey PRIMARY KEY (user_id , product_id)  -- explicit pk
);


*/
DROP TABLE IF EXISTS user_db;
CREATE TABLE user_db(id serial PRIMARY KEY, name VARCHAR(255), password VARCHAR(255), email VARCHAR(255), address varchar(255));

DROP TABLE IF EXISTS product_db;
CREATE TABLE product_db(id serial PRIMARY KEY, name VARCHAR(255), price integer, type varchar(250), description VARCHAR(1000), image VARCHAR(150), onstock boolean, location varchar(500));

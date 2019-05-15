-- 创建users表
CREATE TABLE users(
id INT PRIMARY KEY AUTO_INCREMENT,
username VARCHAR(100) NOT NULL UNIQUE,
PASSWORD VARCHAR(100) NOT NULL,
email VARCHAR(100)
)

-- 创建books表
CREATE TABLE books(
id INT PRIMARY KEY AUTO_INCREMENT,
title VARCHAR(100) NOT NULL,
author VARCHAR(100) NOT NULL,
price DOUBLE(11,2) NOT NULL,
sales INT NOT NULL,
stock INT NOT NULL,
img_path VARCHAR(100) NOT NULL
)
--创建orders表
CREATE TABLE orders(id VARCHAR(100) PRIMARY KEY,
order_time DATETIME NOT NULL,
total_count INT NOT NULL,
total_amount DOUBLE(11,2) NOT NULL,
state INT NOT NULL,
user_id INT NOT NULL,
FOREIGN KEY(user_id) REFERENCES users(id)
)
--创建order_items 表
create table order_items(
id int primary key auto_increment,
count int not null,
amount double(11,2) not null,
title varchar(100) not null,
author varchar(100) not null,
price double(11,2) not null,
ima_path varchar(100) not null,
order_id varchar(100) not null,
foreign key(order_id) references orders(id)
)
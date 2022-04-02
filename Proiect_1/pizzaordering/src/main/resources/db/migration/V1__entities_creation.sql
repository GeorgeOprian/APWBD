create table app_user
(
  user_id int NOT NULL auto_increment,
  user_name varchar(100) not null,
  first_name varchar (100) not null,
  last_name varchar (100) not null,
  phone_number char(10) not null,
  email varchar(50) not null,
  primary key (user_id)
);

create table product
(
  product_id int NOT NULL auto_increment,
  name varchar(100) not null,
  quantity decimal(10, 3) not null,
  unit_price decimal(10, 3) not null,
  ingredients varchar(200) not null,
  primary key (product_id)
);

create table user_order
(
  order_id int NOT NULL auto_increment,
  user_id int not null,
  primary key (order_id),
  foreign key (user_id) references app_user(user_id)
);

create table order_product
(
  product_id int NOT NULL,
  order_id int not null,
  quantity decimal(10, 3) not null,
  price decimal(10, 3) not null,
  primary key (product_id, order_id),
  foreign key (product_id) references product(product_id),
  foreign key (order_id) references user_order(order_id)
);

create table payment
(
  order_id int not null,
  payment_method varchar(20) not null,
  amount decimal(10, 3) not null,
  primary key (order_id),
  foreign key (order_id) references user_order(order_id)
);

create table order_address
(
  order_id int not null,
  city varchar(50) not null,
  street varchar(100) not null,
  number int not null,
  primary key (order_id),
  foreign key (order_id) references user_order(order_id)
);
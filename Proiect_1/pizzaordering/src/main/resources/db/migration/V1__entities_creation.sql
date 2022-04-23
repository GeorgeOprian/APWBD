create table app_user
(
  user_id int NOT NULL auto_increment,
  user_name varchar(100) not null unique,
  password varchar(100) not null,
  first_name varchar (100) not null,
  last_name varchar (100) not null,
  phone_number char(10) not null,
  email varchar(50) not null unique,
  account_not_expired bit(1) DEFAULT NULL,
  account_not_locked bit(1) DEFAULT NULL,
  credentials_not_expired bit(1) DEFAULT NULL,
  enabled bit(1) DEFAULT NULL,
  authority_id int NOT NULL,
  primary key (user_id)
);

CREATE TABLE authority (
 id int NOT NULL,
 role varchar(255) DEFAULT NULL,
 PRIMARY KEY (id)
);

CREATE TABLE user_authority
(
    user_id      int NOT NULL,
    authority_id int NOT NULL,
    PRIMARY KEY (user_id, authority_id),
    KEY            FKgvxjs381k6f48d5d2yi11uh89 (authority_id),
    CONSTRAINT authority_fk FOREIGN KEY (authority_id) REFERENCES authority (id),
    CONSTRAINT user_fk FOREIGN KEY (user_id) REFERENCES app_user (user_id)
);
                                      

create table product
(
  product_id int NOT NULL auto_increment,
  name varchar(100) not null unique,
  quantity decimal(10, 3) not null,
  unit_price decimal(10, 3) not null,
  ingredients varchar(200) default '',
  product_type varchar(20) not null,
  primary key (product_id)
);

create table product_image
(
    id int NOT NULL auto_increment,
    product_id int NOT NULL,
    image mediumblob,
    primary key (id),
    foreign key (product_id) references product(product_id)
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
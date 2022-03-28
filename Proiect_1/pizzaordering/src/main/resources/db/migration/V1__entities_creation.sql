CREATE TABLE APP_USER
(
  USER_ID INT NOT NULL,
  USER_NAME VARCHAR(100) NOT NULL,
  PHONE_NUMBER CHAR(10) NOT NULL,
  EMAIL VARCHAR(50) NOT NULL,
  PRIMARY KEY (USER_ID)
);

CREATE TABLE PRODUCT
(
  PRODUCT_ID INT NOT NULL,
  NAME VARCHAR(100) NOT NULL,
  QUANTITY decimal(10, 3) NOT NULL,
  UNIT_PRICE decimal(10, 3) NOT NULL,
  INGREDIENTS VARCHAR(200) NOT NULL,
  PRIMARY KEY (PRODUCT_ID)
);

CREATE TABLE USER_ORDER
(
  ORDER_ID INT NOT NULL,
  USER_ID INT NOT NULL,
  PRIMARY KEY (ORDER_ID),
  FOREIGN KEY (USER_ID) REFERENCES APP_USER(USER_ID)
);

CREATE TABLE ORDER_PRODUCT
(
  PRODUCT_ID INT NOT NULL,
  ORDER_ID INT NOT NULL,
  QUANTITY decimal(10, 3) NOT NULL,
  PRICE decimal(10, 3) NOT NULL,
  PRIMARY KEY (PRODUCT_ID, ORDER_ID),
  FOREIGN KEY (PRODUCT_ID) REFERENCES PRODUCT(PRODUCT_ID),
  FOREIGN KEY (ORDER_ID) REFERENCES USER_ORDER(ORDER_ID)
);

CREATE TABLE PAYMENT
(
  PRIMARY KEY (PAYMENT_ID),
  PAYMENT_METHOD VARCHAR(20) NOT NULL,
  TOTAL decimal(10, 3) NOT NULL,
  PAYMENT_ID INT NOT NULL,
  ORDER_ID INT NOT NULL,
  FOREIGN KEY (ORDER_ID) REFERENCES USER_ORDER(ORDER_ID)
);

CREATE TABLE ORDER_ADDRESS
(
  ORDER_ID INT NOT NULL,
  CITY VARCHAR(50) NOT NULL,
  STREET VARCHAR(100) NOT NULL,
  NUMBER INT NOT NULL,
  PRIMARY KEY (ORDER_ID),
  FOREIGN KEY (ORDER_ID) REFERENCES USER_ORDER(ORDER_ID)
);
-- this file is used only by h2 profile

insert into app_user  values (1, 'georgeOprian@gmail.com', 'George', 'Oprian', '12345', 'georgeOprian');
insert into app_user  values (2, 'georgeOprian@gmail.com','George', 'Oprian', '12345', 'georgeOprian');

insert into user_order values(1, 1);
insert into user_order values(2, 1);
insert into user_order values(3, 2);

insert into product values (1, 'fadfa', 'beer', 1, 12);
insert into product values (2, 'flour', 'bread', 1, 12);

insert into order_product values (1, 1, 1, 10)

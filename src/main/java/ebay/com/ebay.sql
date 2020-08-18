create database ebay;
use ebay;
create table customer(
  customer_id int not null primary key auto_increment,
  customer_name varchar(150) not null,
  customer_address varchar(150) not null,
  customer_email varchar(150) not null unique,
  customer_pass varchar(150) not null,
  customer_phone varchar(150) not null unique
);


create table address_details(
  address_id int null primary key auto_increment,
  customer_id int not null,
  address_name varchar(150) not null,
  foreign key(customer_id) references customer(customer_id)

);


create table AdminDashboard(
    admin_id int not null primary key,
    admin_email varchar(150) not null,
    admin_password varchar(150) not null,
    admin_name varchar(150) not null

);
 create table Suppiler(
   suppiler_id int not null primary key auto_increment,
   suppiler_name varchar(150) not null,
   suppiler_address varchar(150) not null,
   suppiler_email varchar(150) not null unique,
   suppiler_pass varchar(150) not null,
   suppiler_phone varchar(150) not null unique


 );

 create table category(
   category_id int not null primary key auto_increment,
   category_name varchar(150) not null unique,
   category_date varchar(150) not null

 );


 create table brand(

    brand_id int not null primary key auto_increment,
    category_id int not null,
    brand_name varchar(150) not null unique,
    brand_date varchar(150) not null,
    foreign key(category_id) references category(category_id)
 );

 create table product(
     product_id int not null primary key auto_increment,
     product_code varchar(50) not null unique,
     product_name varchar(150) not null,
     supplier_id int not null,
     category_id int not null,
     brand_id int not null,
     product_price double not null,
     promotion_price double not null,
     product_desc varchar(150) not null,
     product_amount int not null,
     product_status varchar(150) not null,
     product_date varchar(150) not null,

     foreign key(supplier_id) references suppiler(suppiler_id),
     foreign key(category_id) references category(category_id),
     foreign key(brand_id) references brand(brand_id)


 );

 create table tbl_options(
    tbl_options_id int not null primary key auto_increment,
    tbl_options_name varchar(150) not null,
    tbl_options_date varchar(150) not null
 );

 create table product_options(
     options_id int not null primary key auto_increment,
     product_id int not null,
	 tbl_options_id int not null,
     options_name varchar(150) not null,
     foreign key(product_id) references product(product_id),
	 foreign key(tbl_options_id) references tbl_options(tbl_options_id)


 );

select product.product_id, product.product_code,product.product_name,tbl_options.tbl_options_name,product_options.options_name from product
 inner join product_options on product.product_id=product_options.options_id
 inner join tbl_options on product_options.tbl_options_id = tbl_options.tbl_options_id
 where product.supplier_id =1 ;

drop procedure select_options_details;

delimiter //
create procedure select_options_details(in supplier_id int)
 begin
 select product.product_id, product.product_code,product.product_name,tbl_options.tbl_options_name,product_options.options_name from product
 inner join product_options on product.product_id=product_options.options_id
 inner join tbl_options on product_options.tbl_options_id = tbl_options.tbl_options_id
 where product.supplier_id = supplier_id ;
 end //
 delimiter ;
 call select_options_details(1);

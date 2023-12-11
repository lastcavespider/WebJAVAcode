create database bookstore;

use bookstore;

create table book (
    id int auto_increment,
    name varchar(50),
    author varchar(50),
    price float,
    content varchar(200),
    picture varchar(255),
    primary key (id)
);

insert into book(name, author, price, content) values ('山河枕', '墨书白', 54, '卫韫十四岁那年，满门男丁战死沙场，家破人亡');
insert into book(name, author, price, content) values ('中国国家地理精华', '梦想之旅', 75, '本书以地理位置为纲，以地区、国家为基本单元');
insert into book(name, author, price, content) values ('户外生存图鉴', '威尔登·欧文出版', 64, '远离城市，我们是大地上的行者，在艰苦的自然环境中');
insert into book(name, author, price, content) values ('中国古镇游', '知路图书 ', 77, '带着大家走进白墙青瓦，古朴宅院，体验更风情，更魅力，更纯粹的古镇村落');




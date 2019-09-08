create table languages (
    ID int unsigned primary key auto_increment,
    welcomeMessage varchar2(100 CHAR) not null,
    code varchar(3 CHAR) not null
);
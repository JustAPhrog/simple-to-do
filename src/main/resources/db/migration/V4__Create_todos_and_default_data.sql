create table todos (
    ID int unsigned primary key auto_increment,
    text varchar2(100 CHAR) not null,
    done boolean not null
);

insert into todos (text, done)
values ('Uruchomic aplikacje', false);
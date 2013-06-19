# --- !Ups
create table USER (
  name varchar(128) not null,
  age int,
  id int not null primary key auto_increment
);

# --- !Downs
drop table USER;
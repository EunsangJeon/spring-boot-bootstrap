create table person
(
   id integer not null,
   name varchar(255) not null,
   location varchar(255),
   last_seen timestamp,
   primary key(id)
);
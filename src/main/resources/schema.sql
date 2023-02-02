drop table if exists book;
create table book (
    id bigint not null auto_increment,
    isbn varchar(255),
    publisher varchar(255),
    title varchar(255),
    author_id bigint,
    primary key (id)
) engine=InnoDB;

-- drop table if exists hibernate_sequence;
-- create table hibernate_sequence (
--    next_val bigint
-- ) engine=InnoDB;
-- insert into hibernate_sequence values ( 1 );

drop table if exists author;
create table author (
    id bigint not null auto_increment,
    first_name varchar(255),
    last_name varchar(255),
    primary key (id)
) engine=InnoDB;


drop table if exists author_uuid;
create table author_uuid (
    id varchar(36) not null,
    first_name varchar(255),
    last_name varchar(255),
    primary key (id)
) engine=InnoDB;

drop table if exists book_uuid;
create table book_uuid (
    id binary(16) not null,
    isbn varchar(255),
    publisher varchar(255),
    title varchar(255),
    primary key (id)
) engine=InnoDB;

drop table if exists author_composite;
create table author_composite (
    first_name varchar(255),
    last_name varchar(255),
    country varchar(255),
    primary key (first_name, last_name)
) engine=InnoDB;

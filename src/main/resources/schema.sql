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


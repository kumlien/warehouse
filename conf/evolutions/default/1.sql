# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table product (
  ean                       bigint not null,
  name                      varchar(255),
  description               varchar(255),
  constraint pk_product primary key (ean))
;

create table user (
  username                  varchar(255) not null,
  first_name                varchar(255),
  last_name                 varchar(255),
  joined                    timestamp,
  password                  varchar(255),
  constraint pk_user primary key (username))
;

create sequence product_seq;

create sequence user_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists product;

drop table if exists user;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists product_seq;

drop sequence if exists user_seq;


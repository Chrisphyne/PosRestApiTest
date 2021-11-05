drop database posrestapidb;
drop user posrestapi;
create user posrestapi with password 'posrestapi';
create database posrestapidb with template=template0 owner=posrestapi;
\connect posrestapidb;
alter default privileges grant all on tables to posrestapi;
alter default privileges grant all on sequences to posrestapi;

create table pos_client(
    client_id integer primary key not null,
    client_name varchar(20) not null 
);

create table pos_device(
    device_id integer primary key not null,
    device_name varchar(20) not null,
    serial_number integer not null,
    model_type varchar(20) not null,
    client_id integer not null
);

alter table pos_device add constraint device_client_fk
foreign key (client_id) references pos_client(client_id);

create table pos_country(
    country_id integer primary key not null,
    country_name varchar(20) not null,
    client_id integer not null 
);

alter table pos_country add constraint country_client_fk
foreign key (client_id) references pos_client(client_id);

create table pos_branch(
    branch_id integer primary key not null,
    branch_name varchar(20) not null,
    client_id integer not null,
    country_id integer not null 
);

alter table pos_branch add constraint branch_country_fk
foreign key (country_id) references pos_country(country_id);
alter table pos_branch add constraint branch_client_fk
foreign key (client_id) references pos_client(client_id);

create table pos_transaction(
    transaction_id integer primary key not null,
    device_id integer not null,
    client_id integer not null,
    amount numeric(10, 2) not null,
    note varchar(50) not null,
    transaction_date bigint not null
);

alter table pos_transaction add constraint transaction_device_fk
foreign key (device_id) references pos_device(device_id);
alter table pos_transaction add constraint transaction_client_fk
foreign key (client_id) references pos_client(client_id);

create sequence pos_client_sequence increment 1 start 1;
create sequence pos_device_sequence increment 1 start 1;
create sequence pos_country_sequence increment 1 start 1;
create sequence pos_branch_sequence increment 1 start 1;
create sequence pos_transaction_sequence increment 1 start 1000;

CREATE TABLE [IF NOT EXISTS] doctors(

    id serial PRIMARY KEY,
    name varchar(100) not null,
    email varchar(100) not null unique,
    crm varchar(6) not null unique,
    specialization varchar(100) not null,
    address varchar(100) not null,
    complement varchar(100),
    city varchar(100) not null,
    state varchar(2) not null,
    zipcode varchar(9) not null,
    country varchar(100) not null,

);
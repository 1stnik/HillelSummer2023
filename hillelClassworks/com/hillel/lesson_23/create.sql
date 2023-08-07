create table student (
     id int auto_increment primary key
     first_name VARCHAR(50),
     last_name VARCHAR(50),
     date_of_birth TIMESTAMP,
     email VARCHAR(50),
     study_group VARCHAR(50),
     country VARCHAR(50)
);


create table homework (
    id int auto_increment primary key
    name VARCHAR(50),
    description VARCHAR(50),
);

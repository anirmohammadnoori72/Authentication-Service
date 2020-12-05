# Authentication-Service
Simple Authentication Service Java Test

How to deploy step by step 

1 DB configuration

CREATE USER 'admin'@'localhost' IDENTIFIED BY 'admin';

CREATE DATABASE aatest;

GRANT ALL PRIVILEGES ON aatest. * TO 'admin'@'localhost';

use aatest;

in resource/aplication.perperties ->
    set spring.jpa.hibernate.ddl-auto to update for auto creation tables
    
run project !!!

--> then

INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_MODERATOR');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');



api doc files : swagger
_____________________________________________________________

url : http://localhost:8081/swagger-ui.html

please check resource/aplication.perperties for checking apllication port !!!!

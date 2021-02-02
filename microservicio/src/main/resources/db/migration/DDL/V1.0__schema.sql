create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion datetime null,
 primary key (id)
);

create table producto (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 descripcion varchar(100) null,
 precio decimal(11,2) not null,
 primary key (id)
);
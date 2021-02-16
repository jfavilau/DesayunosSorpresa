create table producto (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 descripcion varchar(100) null,
 imagen varchar(100) null,
 precio decimal(11,2) not null,
 cantidad int(11) null,
 primary key (id)
);

create table pedido (
 id int(11) not null auto_increment,
 email varchar(100) not null,
 nombres_apellidos varchar(200) not null,
 envia varchar(100) null,
 recibe varchar(100) not null,
 direccion varchar(200) not null,
 barrio varchar(100) null,
 celular varchar(20) not null,
 mensaje varchar(300) null,
 domicilio_zona decimal(11,2) not null,
 subtotal_productos decimal(11,2) not null,
 total decimal(11,2) not null,
 fecha_pedido datetime not null,
 fecha_entrega datetime not null,
 estado varchar(20) not null,
 primary key (id)
);

create table pedido_productos(
id int(11) not null auto_increment,
pedido_id int(11) not null,
producto_id int(11) not null,
cantidad int(11) not null,
foreign key (pedido_id) references pedido(id),
foreign key (producto_id) references producto(id),
primary key (id)
);
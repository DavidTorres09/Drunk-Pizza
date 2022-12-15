/*Las líneas 2 y 3 están en comentarios, para usarse así la primera vez... luego de eso se quitan los comentarios para que todo funcione bien, en las siguientes ejecuciones */
drop schema Drunk_Pizza_2 ;
drop user Drunk_Pizza_2;

/*Se crea la base de datos */
CREATE SCHEMA Drunk_Pizza_2 ;
USE Drunk_Pizza_2 ;

/*CLIENTE*/
CREATE TABLE IF NOT EXISTS cliente (
  id_cliente 		    INT NOT NULL AUTO_INCREMENT,
  nombre 				VARCHAR(100) NULL ,
  apellido1 			VARCHAR(100) NULL ,
  apellido2 			VARCHAR(100) NULL ,
  direccion 			VARCHAR(600) NULL ,
  email 				VARCHAR(100) NULL ,
  telefono 				VARCHAR(100) NULL ,
  password		    	VARCHAR(225) DEFAULT NULL,
  permissions		    VARCHAR(45) DEFAULT NULL,
  roles					VARCHAR(45) DEFAULT  NULL,
  active				INT DEFAULT  0,
PRIMARY KEY (id_cliente))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_eo_0900_ai_ci;


/*CATEGORIA*/
CREATE TABLE categoria (
  id_categoria 		INT NOT NULL AUTO_INCREMENT,
  descripcion		VARCHAR(30) NOT NULL,  
  PRIMARY KEY (id_categoria))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_eo_0900_ai_ci;

/*PRODUCTO*/
CREATE TABLE IF NOT EXISTS producto (
  id_producto 			INT NOT NULL AUTO_INCREMENT,
  id_categoria 			INT NOT NULL,
  nombre 				VARCHAR(100) NOT NULL,
  descripcion			VARCHAR(250) NULL,
  precio 				INT(45) NOT NULL,
  ruta_imagen			VARCHAR(200),
  PRIMARY KEY 			(id_producto),
 foreign key fk_articulo_caregoria (id_categoria) references categoria(id_categoria))  
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_eo_0900_ai_ci;

/*FACTURA*/
create table factura (
  id_factura 		INT NOT NULL AUTO_INCREMENT,
  id_cliente 		INT NOT NULL,
  fecha 		    date,  
  total 			double,
  estado 			int,
  PRIMARY KEY (id_factura),
  foreign key fk_factura_cliente (id_cliente) references cliente(id_cliente)  
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_eo_0900_ai_ci;

/*VENTA*/
create table venta (
  id_venta INT NOT NULL AUTO_INCREMENT,
  id_factura INT NOT NULL,
  id_producto INT NOT NULL,
  precio double, 
  cantidad int,
  PRIMARY KEY (id_venta),
  foreign key fk_ventas_factura (id_factura) references factura(id_factura),
  foreign key fk_ventas_articulo (id_producto) references producto(id_producto) 
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_eo_0900_ai_ci;

/*OPINIONES*/
CREATE TABLE opinion(
  id 					INT NOT NULL,
  id_cliente 			INT NOT NULL,
  opinion				VARCHAR(500) NOT NULL,
  PRIMARY KEY 			(id),
  CONSTRAINT `fk_opiniones` FOREIGN KEY (id_cliente) REFERENCES cliente (id_cliente) ON DELETE NO ACTION ON UPDATE NO ACTION)
  ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_eo_0900_ai_ci;

/*USUARIOS*/
CREATE TABLE usuario(
	id_usuario 		INT NOT NULL AUTO_INCREMENT,
    username 		VARCHAR(30),
    password 		VARCHAR(200),
    PRIMARY 		KEY (id_usuario)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE rol (
	id_rol 			INT NOT NULL AUTO_INCREMENT,
    nombre 			VARCHAR(30),
    id_usuario 		INT,
    PRIMARY KEY(id_rol),
    FOREIGN KEY fk_rol_usuario (id_usuario) REFERENCES usuario(id_usuario)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


  
  
/*Se insertan 3 registros en la tabla cliente como ejemplo */
INSERT INTO cliente (id_cliente,nombre,apellido1,apellido2,direccion,email,telefono,password)VALUES 
(1,'Angel','Torres','Mora','Cartago','atorres20160@udife.ac.cr','6024-6578','$2a$12$CCUrq5O.XH77PlsFj9wod.jf8FYkmppJBcnNBLv4AO0mSfBEIuNSG'),
(2,'Alonso','Hernandez','Bonilla','San Jose','ahernandez50587@ufide.ac.cr','8341-1159','$2a$12$CCUrq5O.XH77PlsFj9wod.jf8FYkmppJBcnNBLv4AO0mSfBEIuNSG'),
(3,'Laura','Madrigal','Arroyo','Heredia','lmadrigal40423@ufide.ac.cr','7019-9142','$2a$12$CCUrq5O.XH77PlsFj9wod.jf8FYkmppJBcnNBLv4AO0mSfBEIuNSG');
SELECT * FROM Cliente;

/*Se insertan 3 categorias de categoria como ejemplo */
INSERT INTO categoria (id_categoria,descripcion) VALUES 
('1','Pizza'), 
('2','Bebidas'),
('3','Panes'),
('4','Otros');
SELECT * FROM Categoria;

/*Se insertan 4 productos por producto */
INSERT INTO producto (id_producto,id_categoria,nombre ,descripcion,precio,ruta_imagen) VALUES
(1,1,'Pizza de jamon y queso', 'pizza mediana de jamon y queso con pasta delgada', 5000, 'https://firebasestorage.googleapis.com/v0/b/drunkpizza-60b6c.appspot.com/o/imagenes%2Fpizza-de-jamon-queso-y-tocino.jpg?alt=media&token=7968469f-77b3-4128-9a9e-c49ab03df422'),
(2,1,'Pizza suprema', 'pizza mediana suprema con pasta delgada', 7000,'https://firebasestorage.googleapis.com/v0/b/drunkpizza-60b6c.appspot.com/o/imagenes%2FPizza-suprema.jpeg?alt=media&token=05e4d8b0-34b1-4619-9156-6490ea2d9ee7' ),
(3,4,'Pasta', 'Pasta a la carbonara', 5000,'https://firebasestorage.googleapis.com/v0/b/drunkpizza-60b6c.appspot.com/o/imagenes%2Fpasta-carbonara.jpg?alt=media&token=adec42f4-611a-4b69-af7c-15f92f72fc69'),
(4,3,'Tostadas', 'Tostadas con pan de ajo y queso', 3000,'https://firebasestorage.googleapis.com/v0/b/drunkpizza-60b6c.appspot.com/o/imagenes%2FPan-de-ajo.jpg?alt=media&token=1d24f5c7-cdf8-420e-ae29-2f72a78e8612');
INSERT INTO producto (id_producto,id_categoria,nombre ,descripcion,precio,ruta_imagen) VALUES
 (5,2,'Moscow mule', 'Costel Moscow Mule hecho con vodka, cerveza', 3500,'https://firebasestorage.googleapis.com/v0/b/drunkpizza-60b6c.appspot.com/o/imagenes%2FMoscow-Mule.png?alt=media&token=e3ab6402-dd1b-4831-a5ee-2d29b60452be');
INSERT INTO producto (id_producto,id_categoria,nombre ,descripcion,precio,ruta_imagen) VALUES
(6,1,'Pizza hawaina', 'pizza mediana hawaiana con pasta delgada', 6500,'https://firebasestorage.googleapis.com/v0/b/drunkpizza-60b6c.appspot.com/o/imagenes%2FLa-Pizza-Hawaiana-de-Canada.png?alt=media&token=ad1da164-96b1-446a-a84e-28ca871b910a');
INSERT INTO producto (id_producto,id_categoria,nombre ,descripcion,precio,ruta_imagen) VALUES
(7,2,'Manhattan', 'Whisky y vermut rojo', 4000,'https://firebasestorage.googleapis.com/v0/b/drunkpizza-60b6c.appspot.com/o/imagenes%2FManhatan.png?alt=media&token=580d6daa-3c13-4862-ab02-8775c6351dbf');
INSERT INTO producto (id_producto,id_categoria,nombre ,descripcion,precio,ruta_imagen) VALUES
(8,1,'Pizza Margarita', 'pizza mediana Margarita con pasta delgada', 6000,'https://firebasestorage.googleapis.com/v0/b/drunkpizza-60b6c.appspot.com/o/imagenes%2Fpizza-Margarita-640x480.png?alt=media&token=776e559d-c0c7-4736-bca2-c0e6f57cb99a');
INSERT INTO producto (id_producto,id_categoria,nombre ,descripcion,precio,ruta_imagen) VALUES
(9,2,'cucaracha flameada', 'tequila flameado', 5000,'https://firebasestorage.googleapis.com/v0/b/drunkpizza-60b6c.appspot.com/o/imagenes%2FCucaracha.png?alt=media&token=21c293fb-e558-4ba0-afe4-934d9a7f4d8e');
INSERT INTO producto (id_producto,id_categoria,nombre ,descripcion,precio,ruta_imagen) VALUES
(10,2,'pina colada', 'pina crema de coco y ron', 3000,'https://firebasestorage.googleapis.com/v0/b/drunkpizza-60b6c.appspot.com/o/imagenes%2FPina-colada-6.png?alt=media&token=e402355a-52e4-45f4-93cd-db8d01c49ba9');
INSERT INTO producto (id_producto,id_categoria,nombre ,descripcion,precio,ruta_imagen) VALUES
(11,4,'Cheesecake', 'Postre de queso con fresas', 4500,'https://firebasestorage.googleapis.com/v0/b/drunkpizza-60b6c.appspot.com/o/imagenes%2Fcheesecake-facil-con-leche-condensada-2000.png?alt=media&token=719e19a5-ee1b-424b-8f05-1178f0567ce3');
INSERT INTO producto (id_producto,id_categoria,nombre ,descripcion,precio,ruta_imagen) VALUES
(12,4,'Mega Choco Chip', 'galleta gigante con chocolate', 6000,'https://firebasestorage.googleapis.com/v0/b/drunkpizza-60b6c.appspot.com/o/imagenes%2Fgalleta.png?alt=media&token=8fae752a-7086-4656-ad10-49b10019d269');
INSERT INTO producto (id_producto,id_categoria,nombre ,descripcion,precio,ruta_imagen) VALUES
(13,4,'Torta Chilena', 'Capas de torta con dulce de leche', 4000,'https://firebasestorage.googleapis.com/v0/b/drunkpizza-60b6c.appspot.com/o/imagenes%2Ftorta.png?alt=media&token=3aa2b816-da13-40db-9c2b-5e47fc92c4d8');
delete from producto  where id_producto = 5; 


/*Se crean 6 facturas */   /*'Activa','Pagada','Anulada')*/
INSERT INTO factura (id_factura,id_cliente,fecha,total,estado) VALUES
(1,1,'2022-01-05',211560,2),
(2,2,'2022-01-07',554340,2),
(3,3,'2022-01-07',871000,2),
(4,1,'2022-01-15',244140,1),
(5,2,'2022-01-17',414800,1),
(6,3,'2022-01-21',420000,1);
SELECT * FROM Factura;

/*Se crean ventas en sus respectivas facturas*/
INSERT INTO venta (id_venta,id_factura,id_producto,precio,cantidad) values
(1,1,4,45000,3),
(2,1,3,15780,2),
(3,1,2,15000,3),
(4,2,1,45000,1),
(5,2,1,154000,3),
(6,2,2,15780,3),
(7,3,3,154000,1),
(8,3,4,57000,1),
(9,3,4,330000,2),
(10,1,3,57000,2),
(11,1,3,27600,3),
(12,1,2,15780,3),
(13,2,1,27600,3),
(14,2,1,154000,2),
(15,2,3,24000,1),
(16,3,1,330000,1),
(17,3,2,45000,1),
(18,3,1,15000,3);
SELECT * FROM venta;

/*Se insertan unas cuantas opiniones*/
INSERT INTO opinion (id,id_cliente,opinion)VALUES 
(1,1,'Ta wena la pizza...'),
(2,2,'Sabia toda "wacala" la tostada...'),
(3,3,'Me gusta la pasta...');
SELECT * FROM Opinion;

/*Se insertan los usuaior y las contrasenas de cada cliente*/
INSERT INTO usuario (id_usuario, username, password) VALUES
(1,'angel','$2a$10$TzIpUDWm/0wXieiabxbBRed1z/FeTv0/bsxbvkaw0iZzzRsGnj30a'),
(2,'alonso','$2a$10$f8OiMRRs693exmY5R4gjpOkV1FTACBsaw2ZzHeq3CB1NYa9r1PPiy'),
(3,'laura','$2a$10$e0ViO.dzjIqExWizcJr2Ku9Qe6WgjwTPCZNejgkkukA98ouDMeYjm');
SELECT * FROM usuario;

/*Se insertan los roles de cada usuario*/
INSERT INTO rol (id_rol, nombre, id_usuario) VALUES
(1, 'ROLE_ADMIN', 1),
(2, 'ROLE_VENDEDOR',1),
(3, 'ROLE_USER', 1),
(4,'ROLE_VENDEDOR',2),
(5, 'ROLE_USER',2),
(6, 'ROLE_USER',3);
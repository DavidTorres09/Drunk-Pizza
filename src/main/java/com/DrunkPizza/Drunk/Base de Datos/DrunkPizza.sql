CREATE SCHEMA IF NOT EXISTS `Drunk_Pizza` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `Drunk_Pizza` ;


-- TABLA DE PRODUCTOS
CREATE TABLE IF NOT EXISTS `producto` (
  `id_producto` 		INT NOT NULL,
  `nombre` 				VARCHAR(100) NOT NULL,
  `descripcion` 		VARCHAR(250) NULL,
  `precio` 				INT(45) NOT NULL,
  PRIMARY KEY 			(`id_producto`));
INSERT INTO `producto` VALUES (1,'Pizza de jamon y queso', 'pizza mediana de jamon y queso con pasta delgada', 5000),
								(2,'Pizza suprema', 'pizza mediana suprema con pasta delgada', 7000);
INSERT INTO `producto` VALUES (3,'Pasta', 'Pasta a la carbonara', 5000);
INSERT INTO `producto` VALUES (4,'Tostadas', 'Tostadas con pan de ajo y queso', 3000);

SELECT * FROM producto;
DROP TABLE producto;

-- TABLA DE METODO DE PAGO
CREATE TABLE IF NOT EXISTS `metodo_pago` (
  `id` 					INT NOT NULL,
  `metodo` 				VARCHAR(100) NOT NULL,
  PRIMARY KEY 			(`id`));
INSERT INTO `metodo_pago` VALUES (1,'Tarjeta'),
								   (2,'Efectivo');
SELECT * FROM metodo_pago;

-- TABLA DE PRODUCTOS POR PEDIDO
CREATE TABLE IF NOT EXISTS `productos_pedido` (
  `id` 					INT NOT NULL,
  `id_producto` 		INT NOT NULL,
  PRIMARY KEY 			(`id`),
CONSTRAINT `fk_producto_pedido` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id_producto`) ON DELETE NO ACTION ON UPDATE NO ACTION);
INSERT INTO `productos_pedido` VALUES (1,1),
									  (2,2);
SELECT * FROM productos_pedido;
DROP TABLE productos_pedido;


-- TABLA DE PEDIDOS
CREATE TABLE IF NOT EXISTS `pedido` (
  `id_pedido` 			INT NOT NULL,
  `orden_cliente`		INT NOT NULL,
  `id_producto_pedido` 	INT NOT NULL,
  `precio_total` 		VARCHAR(45) NOT NULL,
  `id_metodo_pago`		INT NOT NULL,
  PRIMARY KEY 			(`id_pedido`),
CONSTRAINT `fk_pedido` FOREIGN KEY (`id_producto_pedido`) REFERENCES `productos_pedido` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
CONSTRAINT `fk_pago` FOREIGN KEY (`id_metodo_pago`) REFERENCES `metodo_pago` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION);
INSERT INTO `pedido` VALUES (1,1,1,0,1),
						    (2,2,2,0,2);
SELECT * FROM pedido;
DROP TABLE pedido;

-- TABLA DE CLIENTES
CREATE TABLE IF NOT EXISTS `clientes` (
`id` INT NOT NULL ,
`Nombre` VARCHAR(45) NULL ,
`Direccion` VARCHAR(600) NULL ,
`Telefono` VARCHAR(100) NULL ,
`id_Pedido` INT NOT NULL ,
PRIMARY KEY (`id`),
CONSTRAINT `fk_pedido_cliente` FOREIGN KEY (`id_Pedido`) REFERENCES `pedido` (`id_pedido`) ON DELETE NO ACTION ON UPDATE NO ACTION);
DROP TABLE clientes;
INSERT INTO `clientes` VALUES (1,'Arturito','Cartago','2552-2552',1),
							  (2,'Juan','San Jose','8899-2380',2);
SELECT * FROM clientes;
DROP TABLE CLIENTES;
                              
-- CREDENCIALES CLIENTE
CREATE TABLE IF NOT EXISTS `usuario` (
  `id` 					INT NOT NULL,
  `usuario` 			VARCHAR(100) NOT NULL,
  `password`			VARCHAR(100) NOT NULL,
  `id_user`				INT NOT NULL,
  PRIMARY KEY 			(`id`),
  CONSTRAINT `fk_usuario_cliente` FOREIGN KEY (`id_user`) REFERENCES `clientes` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION);

INSERT INTO `usuario` VALUES (1,'art_123','12345',1),
							  (2,'juan_987','207580',2);
SELECT * FROM usuario;
DESCRIBE USUARIO;
DROP TABLE USUARIO;  

-- TABLA DE OPINIONES
CREATE TABLE `opiniones`(
  `id` 					INT NOT NULL,
  `id_cliente` 			INT NOT NULL,
  `opinion`				VARCHAR(100) NOT NULL,
  PRIMARY KEY 			(`id`),
  CONSTRAINT `fk_opiniones` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION);
INSERT INTO `opiniones` VALUES (1,1,'Ta wena la pizza...');
DROP TABLE opiniones;
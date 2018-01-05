CREATE TABLE `Usuarios` (
 `IdUsuario` int(10) NOT NULL AUTO_INCREMENT,
 `User` varchar(100) NOT NULL,
 `Password` varchar(100) NOT NULL,
 `Roles` varchar(30) NOT NULL,
 `Nombre` text NOT NULL,
 `Email` varchar(100) NOT NULL,
 PRIMARY KEY (`IdUsuario`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

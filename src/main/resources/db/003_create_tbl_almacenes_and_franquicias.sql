CREATE TABLE `Almacenes` (
  `Id_Almacenes` int(11) NOT NULL,
  `Latitud` varchar(45) DEFAULT NULL,
  `Longitud` varchar(45) DEFAULT NULL,
  `Nombre` varchar(45) DEFAULT NULL,
  `Direccion` varchar(45) DEFAULT NULL,
  `Pais` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Id_Almacenes`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `Franquicias` (
  `Id_franquicia` int(11) NOT NULL,
  `Latitud` varchar(45) DEFAULT NULL,
  `Longitud` varchar(45) DEFAULT NULL,
  `Nombre` varchar(45) DEFAULT NULL,
  `Direccion` varchar(45) DEFAULT NULL,
  `Pais` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Id_franquicia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

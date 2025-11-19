-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 19-11-2025 a las 02:19:51
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `cinemacentro`
--
CREATE DATABASE IF NOT EXISTS `cinemacentro` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `cinemacentro`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asiento`
--

CREATE TABLE `asiento` (
  `codAsiento` int(11) NOT NULL,
  `fila` varchar(1) NOT NULL,
  `numero` int(2) NOT NULL,
  `estado` tinyint(4) NOT NULL,
  `codProyeccion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `asiento`
--

INSERT INTO `asiento` (`codAsiento`, `fila`, `numero`, `estado`, `codProyeccion`) VALUES
(68, 'A', 3, 0, 18),
(69, 'A', 4, 0, 18),
(70, 'A', 3, 0, 19),
(71, 'B', 3, 1, 18),
(72, 'A', 3, 1, 22),
(73, 'A', 4, 1, 19),
(74, 'A', 5, 1, 19),
(75, 'A', 1, 1, 19),
(76, 'A', 2, 1, 19),
(77, 'B', 3, 1, 19),
(78, 'B', 4, 1, 19),
(79, 'C', 3, 1, 19),
(80, 'C', 4, 1, 19);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comprador`
--

CREATE TABLE `comprador` (
  `dni` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `fechaNac` date NOT NULL,
  `password` varchar(30) NOT NULL,
  `medioDePago` varchar(30) NOT NULL,
  `estado` tinyint(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `comprador`
--

INSERT INTO `comprador` (`dni`, `nombre`, `fechaNac`, `password`, `medioDePago`, `estado`) VALUES
(38751080, 'Jeremias Sirur Flores', '1995-03-13', '38751080', 'Tarjeta Credito', 1),
(42238525, 'Agustin Mazza', '1999-12-11', '42238525', 'Tarjeta Credito', 1),
(42357107, 'Juan Rodriguez', '2000-01-23', 'juan', 'Efectivo', 1),
(42778631, 'Facundo Lopez Cozzella', '2000-08-13', 'facundo', 'Efectivo', 1),
(44752772, 'Mauricio Reta', '2003-04-13', '44752772', 'Efectivo', 1),
(46807350, 'Jeremias Hoyo', '2005-11-21', 'jerechikito', 'Tarjeta Credito', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalleticket`
--

CREATE TABLE `detalleticket` (
  `codD` int(11) NOT NULL,
  `codProyeccion` int(11) NOT NULL,
  `total` double NOT NULL,
  `codTicket` int(11) NOT NULL,
  `codAsiento` int(11) NOT NULL,
  `codAsiento2` int(11) DEFAULT NULL,
  `estado` tinyint(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `detalleticket`
--

INSERT INTO `detalleticket` (`codD`, `codProyeccion`, `total`, `codTicket`, `codAsiento`, `codAsiento2`, `estado`) VALUES
(18, 18, 20000, 37, 68, 69, 1),
(19, 19, 15000, 38, 70, NULL, 1),
(20, 18, 10000, 39, 71, NULL, 0),
(21, 22, 10000, 40, 72, NULL, 0),
(22, 19, 30000, 42, 73, 74, 0),
(23, 19, 30000, 44, 75, 76, 0),
(24, 19, 30000, 46, 77, 78, 0),
(25, 19, 30000, 48, 79, 80, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pelicula`
--

CREATE TABLE `pelicula` (
  `titulo` varchar(30) NOT NULL,
  `director` varchar(30) NOT NULL,
  `actores` varchar(30) NOT NULL,
  `origen` varchar(30) NOT NULL,
  `genero` varchar(30) NOT NULL,
  `estreno` date NOT NULL,
  `enCartelera` tinyint(2) NOT NULL,
  `idPelicula` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `pelicula`
--

INSERT INTO `pelicula` (`titulo`, `director`, `actores`, `origen`, `genero`, `estreno`, `enCartelera`, `idPelicula`) VALUES
('Jurassic Park', 'Yo', 'Vos', 'EEUU', 'Acción', '2025-11-13', 1, 3),
('Oppenheimer', 'Christopher Nolan', 'Cillian Murphy, Emily Blunt, M', 'EE.UU.', 'Drama', '2023-07-21', 1, 4),
('Parasite', 'Bong Joon-ho', 'Song Kang-ho, Choi Woo-shik, P', 'Corea del Sur', 'Acción', '2019-05-30', 1, 5),
('Dune: Part Two', 'Denis Villeneuve', 'Timothée Chalamet, Zendaya, Re', 'EE.UU.', 'Ciencia ficción', '2024-03-01', 1, 6),
('El secreto de sus ojos', 'Juan José Campanella', 'Ricardo Darín, Soledad Villami', 'Argentina', 'Drama', '2009-08-13', 1, 7),
('Barbie', 'Greta Gerwig', 'Margot Robbie, Ryan Gosling, A', 'EE.UU.', 'Comedia', '2023-07-21', 1, 8),
('Roma', 'Alfonso Cuarón', 'Yalitza Aparicio, Marina de Ta', 'México', 'Drama', '2018-08-30', 1, 9),
('Spider-Man: No Way Home', 'Jon Watts', 'Tom Holland, Zendaya, Benedict', 'EE.UU.', 'Acción', '2021-12-17', 1, 10),
('Relatos salvajes', 'Damián Szifron', 'Ricardo Darín, Érica Rivas, Le', 'Argentina', 'Drama', '2014-08-21', 1, 11),
('Laboratorio', 'Juan Saez', 'Juan Rodriguez, Agus Mazza', 'Argentina', 'Suspenso', '2025-11-18', 1, 12);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proyeccion`
--

CREATE TABLE `proyeccion` (
  `idioma` varchar(30) NOT NULL,
  `es3D` tinyint(4) NOT NULL,
  `subtitulada` tinyint(4) NOT NULL,
  `horaInicio` varchar(6) NOT NULL,
  `horaFin` varchar(6) NOT NULL,
  `lugaresDisponibles` int(11) NOT NULL,
  `precioDelLugar` double NOT NULL,
  `nroSala` int(11) NOT NULL,
  `codProyeccion` int(11) NOT NULL,
  `idPelicula` int(11) NOT NULL,
  `estado` tinyint(2) NOT NULL,
  `fechaFuncion` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `proyeccion`
--

INSERT INTO `proyeccion` (`idioma`, `es3D`, `subtitulada`, `horaInicio`, `horaFin`, `lugaresDisponibles`, `precioDelLugar`, `nroSala`, `codProyeccion`, `idPelicula`, `estado`, `fechaFuncion`) VALUES
('Español', 0, 0, '16:00', '19:00', 15, 12000, 1, 17, 4, 1, '2025-11-19'),
('Ingles', 1, 1, '16:00', '18:00', 15, 10000, 2, 18, 8, 1, '2025-11-19'),
('Español', 1, 0, '17:30', '19:00', 15, 15000, 3, 19, 10, 1, '2025-11-19'),
('Español', 0, 0, '16:30', '20:00', 15, 10000, 2, 20, 12, 127, '0000-00-00'),
('Ingles', 1, 1, '16:30', '19:00', 15, 15000, 3, 21, 12, 127, '0000-00-00'),
('Español', 0, 0, '16:00', '19:30', 15, 10000, 2, 22, 12, 1, '2025-11-19');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sala`
--

CREATE TABLE `sala` (
  `nroSala` int(11) NOT NULL,
  `apta3D` tinyint(4) NOT NULL,
  `capacidad` int(11) NOT NULL,
  `estado` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `sala`
--

INSERT INTO `sala` (`nroSala`, `apta3D`, `capacidad`, `estado`) VALUES
(1, 0, 15, 1),
(2, 0, 15, 1),
(3, 1, 15, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ticketcompra`
--

CREATE TABLE `ticketcompra` (
  `fechaCompra` date NOT NULL,
  `codProyeccion` tinyint(2) NOT NULL,
  `monto` double NOT NULL,
  `dni` int(11) NOT NULL,
  `codTicket` int(11) NOT NULL,
  `estado` tinyint(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `ticketcompra`
--

INSERT INTO `ticketcompra` (`fechaCompra`, `codProyeccion`, `monto`, `dni`, `codTicket`, `estado`) VALUES
('2025-11-17', 18, 10000, 42357107, 36, 1),
('2025-11-17', 18, 10000, 42357107, 37, 1),
('2025-11-21', 19, 15000, 42357107, 38, 1),
('2025-11-18', 18, 10000, 38751080, 39, 1),
('2025-11-18', 22, 10000, 42357107, 40, 1),
('2025-11-18', 19, 15000, 42357107, 41, 1),
('2025-11-18', 19, 15000, 42357107, 42, 1),
('2025-11-18', 19, 15000, 42357107, 43, 1),
('2025-11-18', 19, 15000, 42357107, 44, 1),
('2025-11-18', 19, 15000, 42357107, 45, 1),
('2025-11-18', 19, 15000, 42357107, 46, 1),
('2025-11-18', 19, 15000, 42357107, 47, 1),
('2025-11-18', 19, 15000, 42357107, 48, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `asiento`
--
ALTER TABLE `asiento`
  ADD PRIMARY KEY (`codAsiento`),
  ADD KEY `codProyeccion` (`codProyeccion`);

--
-- Indices de la tabla `comprador`
--
ALTER TABLE `comprador`
  ADD PRIMARY KEY (`dni`);

--
-- Indices de la tabla `detalleticket`
--
ALTER TABLE `detalleticket`
  ADD PRIMARY KEY (`codD`),
  ADD KEY `codTicket` (`codTicket`,`codAsiento`),
  ADD KEY `codAsiento` (`codAsiento`),
  ADD KEY `codProyeccion` (`codProyeccion`),
  ADD KEY `codAsiento2` (`codAsiento2`);

--
-- Indices de la tabla `pelicula`
--
ALTER TABLE `pelicula`
  ADD PRIMARY KEY (`idPelicula`);

--
-- Indices de la tabla `proyeccion`
--
ALTER TABLE `proyeccion`
  ADD PRIMARY KEY (`codProyeccion`),
  ADD KEY `nroSala` (`nroSala`),
  ADD KEY `idPelicula` (`idPelicula`);

--
-- Indices de la tabla `sala`
--
ALTER TABLE `sala`
  ADD PRIMARY KEY (`nroSala`);

--
-- Indices de la tabla `ticketcompra`
--
ALTER TABLE `ticketcompra`
  ADD PRIMARY KEY (`codTicket`),
  ADD KEY `dni` (`dni`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `asiento`
--
ALTER TABLE `asiento`
  MODIFY `codAsiento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=81;

--
-- AUTO_INCREMENT de la tabla `detalleticket`
--
ALTER TABLE `detalleticket`
  MODIFY `codD` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT de la tabla `pelicula`
--
ALTER TABLE `pelicula`
  MODIFY `idPelicula` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `proyeccion`
--
ALTER TABLE `proyeccion`
  MODIFY `codProyeccion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT de la tabla `sala`
--
ALTER TABLE `sala`
  MODIFY `nroSala` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `ticketcompra`
--
ALTER TABLE `ticketcompra`
  MODIFY `codTicket` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `asiento`
--
ALTER TABLE `asiento`
  ADD CONSTRAINT `asiento_ibfk_1` FOREIGN KEY (`codProyeccion`) REFERENCES `proyeccion` (`codProyeccion`);

--
-- Filtros para la tabla `detalleticket`
--
ALTER TABLE `detalleticket`
  ADD CONSTRAINT `detalleticket_ibfk_1` FOREIGN KEY (`codAsiento`) REFERENCES `asiento` (`codAsiento`),
  ADD CONSTRAINT `detalleticket_ibfk_2` FOREIGN KEY (`codTicket`) REFERENCES `ticketcompra` (`codTicket`),
  ADD CONSTRAINT `detalleticket_ibfk_3` FOREIGN KEY (`codAsiento2`) REFERENCES `asiento` (`codAsiento`);

--
-- Filtros para la tabla `proyeccion`
--
ALTER TABLE `proyeccion`
  ADD CONSTRAINT `proyeccion_ibfk_2` FOREIGN KEY (`nroSala`) REFERENCES `sala` (`nroSala`),
  ADD CONSTRAINT `proyeccion_ibfk_3` FOREIGN KEY (`idPelicula`) REFERENCES `pelicula` (`idPelicula`);

--
-- Filtros para la tabla `ticketcompra`
--
ALTER TABLE `ticketcompra`
  ADD CONSTRAINT `ticketcompra_ibfk_1` FOREIGN KEY (`dni`) REFERENCES `comprador` (`dni`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

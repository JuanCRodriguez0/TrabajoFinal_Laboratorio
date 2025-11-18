-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 18-11-2025 a las 02:12:47
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
(41, 'A', 3, 0, 16),
(42, 'A', 4, 0, 16),
(43, 'A', 5, 0, 16),
(44, 'A', 1, 0, 5),
(45, 'C', 2, 0, 16),
(46, 'A', 3, 0, 5),
(47, 'A', 4, 0, 5),
(48, 'A', 2, 0, 5),
(49, 'A', 5, 0, 5),
(50, 'B', 3, 0, 16),
(51, 'C', 3, 0, 16),
(52, 'C', 4, 0, 16),
(53, 'B', 3, 0, 5),
(54, 'B', 4, 0, 16),
(55, 'B', 5, 0, 16),
(56, 'B', 2, 0, 16),
(57, 'C', 5, 0, 16),
(58, 'A', 2, 0, 16),
(59, 'A', 1, 0, 16);

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
(22222222, 'Facundo Lopez Cozzella', '2000-11-17', 'facundo', 'Efectivo', 0),
(38751080, 'Jeremias Sirur Flores', '1995-03-13', '38751080', 'Tarjeta Credito', 0),
(42238525, 'Agustin Mazza', '2000-04-20', '42238525', 'Tarjeta Credito', 1),
(42357107, 'Juan Rodriguez', '2000-01-23', 'chester', 'Efectivo', 0),
(44444222, 'Jeremias Hoyo', '2004-08-05', 'jerechikito', 'Tarjeta Credito', 0),
(44752772, 'Mauricio Reta', '2003-04-13', '44752772', 'Efectivo', 1);

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
(1, 16, 246, 16, 51, 52, 1),
(9, 16, 123, 16, 58, NULL, 1),
(10, 16, 123, 16, 59, NULL, 1);

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
('Jurassic Park', 'Yo', 'Vos', 'EEUU', 'Acción', '2025-11-13', 1, 3);

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
  `estado` tinyint(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `proyeccion`
--

INSERT INTO `proyeccion` (`idioma`, `es3D`, `subtitulada`, `horaInicio`, `horaFin`, `lugaresDisponibles`, `precioDelLugar`, `nroSala`, `codProyeccion`, `idPelicula`, `estado`) VALUES
('Español', 1, 1, '19:00', '19:00', 25, 1200, 2, 1, 3, 0),
('Español', 1, 1, '19:00', '19:00', 25, 1200, 2, 2, 3, 0),
('Español', 1, 1, '19:00', '19:00', 25, 1200, 2, 3, 3, 0),
('Español', 1, 1, '19:00', '19:00', 25, 1200, 2, 4, 3, 0),
('Español', 1, 1, '19:00', '20:00', 15, 1200, 2, 5, 3, 1),
('Español', 1, 1, '19:00', '19:00', 25, 1200, 2, 6, 3, 0),
('Español', 1, 1, '19:00', '19:00', 25, 1200, 2, 7, 3, 0),
('Español', 1, 1, '19:00', '19:00', 25, 1200, 2, 8, 3, 0),
('Español', 1, 1, '19:00', '19:00', 25, 1200, 2, 9, 3, 0),
('Español', 1, 1, '19:30', '19:30', 25, 1200, 3, 10, 3, 0),
('Español', 1, 1, '19:30', '19:30', 25, 1200, 3, 11, 3, 0),
('Español', 1, 1, '19:30', '19:30', 25, 1200, 3, 12, 3, 0),
('Español', 1, 1, '19:30', '19:30', 25, 1200, 3, 13, 3, 0),
('Español', 1, 0, '19:00', '19:00', 25, 2000, 3, 14, 3, 0),
('Español', 1, 1, '19:30', '19:30', 25, 20000, 3, 15, 3, 0),
('Ingles', 1, 0, '20:30', '21:00', 15, 123, 3, 16, 3, 1);

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
('2025-11-17', 16, 123, 42357107, 9, 1),
('2025-11-17', 16, 123, 42357107, 10, 1),
('2025-11-17', 16, 123, 42357107, 11, 1),
('2025-11-17', 5, 1200, 42357107, 12, 1),
('2025-11-17', 16, 123, 42357107, 13, 1),
('2025-11-17', 5, 1200, 42357107, 14, 1),
('2025-11-17', 5, 1200, 42357107, 15, 1),
('2025-11-17', 5, 1200, 42357107, 16, 1),
('2025-11-17', 5, 1200, 42357107, 17, 1),
('2025-11-17', 16, 123, 42357107, 18, 1),
('2025-11-17', 16, 123, 42357107, 19, 1),
('2025-11-17', 16, 123, 42357107, 20, 1),
('2025-11-17', 5, 1200, 42357107, 21, 1),
('2025-11-17', 16, 123, 42357107, 22, 1),
('2025-11-17', 16, 123, 42357107, 23, 1),
('2025-11-17', 16, 123, 42357107, 24, 1),
('2025-11-17', 16, 123, 42357107, 25, 1),
('2025-11-17', 16, 123, 42357107, 26, 1),
('2025-11-17', 16, 123, 42357107, 27, 1);

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
  MODIFY `codAsiento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=60;

--
-- AUTO_INCREMENT de la tabla `detalleticket`
--
ALTER TABLE `detalleticket`
  MODIFY `codD` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `pelicula`
--
ALTER TABLE `pelicula`
  MODIFY `idPelicula` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `proyeccion`
--
ALTER TABLE `proyeccion`
  MODIFY `codProyeccion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT de la tabla `sala`
--
ALTER TABLE `sala`
  MODIFY `nroSala` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `ticketcompra`
--
ALTER TABLE `ticketcompra`
  MODIFY `codTicket` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

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

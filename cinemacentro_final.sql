-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 14-11-2025 a las 04:03:05
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
CREATE DATABASE IF NOT EXISTS `cinemacentro` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci;
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
(40400400, 'Jeremias Sirur Flores', '1995-07-14', 'jeremias', 'Tarjeta Credito', 0),
(42357107, 'Juan Rodriguez', '2000-01-23', 'juancruz', 'Efectivo', 0),
(44444222, 'Jeremias Hoyo', '2004-08-05', 'jeremias2', 'Tarjeta Credito', 0),
(55555555, 'Agustino Mazza', '2000-04-20', 'agustin', 'Tarjeta Credito', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalleticket`
--

CREATE TABLE `detalleticket` (
  `codD` int(11) NOT NULL,
  `funcion` varchar(30) NOT NULL,
  `cant` int(11) NOT NULL,
  `subtotal` double NOT NULL,
  `codTicket` int(11) NOT NULL,
  `codAsiento` int(11) NOT NULL,
  `codAsiento2` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

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
  `idPelicula` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `proyeccion`
--

INSERT INTO `proyeccion` (`idioma`, `es3D`, `subtitulada`, `horaInicio`, `horaFin`, `lugaresDisponibles`, `precioDelLugar`, `nroSala`, `codProyeccion`, `idPelicula`) VALUES
('Español', 1, 1, '19:00', '19:00', 25, 1200, 2, 1, 3),
('Español', 1, 1, '19:00', '19:00', 25, 1200, 2, 2, 3),
('Español', 1, 1, '19:00', '19:00', 25, 1200, 2, 3, 3),
('Español', 1, 1, '19:00', '19:00', 25, 1200, 2, 4, 3),
('Español', 1, 1, '19:00', '19:00', 25, 1200, 2, 5, 3),
('Español', 1, 1, '19:00', '19:00', 25, 1200, 2, 6, 3),
('Español', 1, 1, '19:00', '19:00', 25, 1200, 2, 7, 3),
('Español', 1, 1, '19:00', '19:00', 25, 1200, 2, 8, 3),
('Español', 1, 1, '19:00', '19:00', 25, 1200, 2, 9, 3),
('Español', 1, 1, '19:30', '19:30', 25, 1200, 3, 10, 3),
('Español', 1, 1, '19:30', '19:30', 25, 1200, 3, 11, 3),
('Español', 1, 1, '19:30', '19:30', 25, 1200, 3, 12, 3),
('Español', 1, 1, '19:30', '19:30', 25, 1200, 3, 13, 3);

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
(1, 1, 120, 1),
(2, 0, 230, 1),
(3, 1, 30, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ticketcompra`
--

CREATE TABLE `ticketcompra` (
  `fechaCompra` date NOT NULL,
  `fechaFuncion` text NOT NULL,
  `monto` double NOT NULL,
  `dni` int(11) NOT NULL,
  `codTicket` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

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
  MODIFY `codAsiento` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `detalleticket`
--
ALTER TABLE `detalleticket`
  MODIFY `codD` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `pelicula`
--
ALTER TABLE `pelicula`
  MODIFY `idPelicula` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `proyeccion`
--
ALTER TABLE `proyeccion`
  MODIFY `codProyeccion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `sala`
--
ALTER TABLE `sala`
  MODIFY `nroSala` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `ticketcompra`
--
ALTER TABLE `ticketcompra`
  MODIFY `codTicket` int(11) NOT NULL AUTO_INCREMENT;

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

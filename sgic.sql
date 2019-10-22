-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 22-10-2019 a las 07:37:38
-- Versión del servidor: 10.1.37-MariaDB
-- Versión de PHP: 7.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sgic`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `citas`
--

CREATE TABLE `citas` (
  `id` int(11) NOT NULL,
  `nombres` varchar(25) COLLATE utf8_spanish_ci NOT NULL,
  `apellidos` varchar(25) COLLATE utf8_spanish_ci NOT NULL,
  `servicio` varchar(25) COLLATE utf8_spanish_ci NOT NULL,
  `fecha` date NOT NULL,
  `hora` time NOT NULL,
  `descripcion` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `estado` varchar(25) COLLATE utf8_spanish_ci NOT NULL,
  `cFecha` date NOT NULL,
  `mFecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `idUser` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `descargo`
--

CREATE TABLE `descargo` (
  `id` int(11) NOT NULL,
  `idP` int(11) NOT NULL,
  `cod` varchar(14) COLLATE utf8_spanish_ci NOT NULL,
  `fDescargo` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `cant` int(11) NOT NULL,
  `pUnitario` float NOT NULL,
  `tipo` varchar(25) COLLATE utf8_spanish_ci NOT NULL,
  `idUser` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `descargo`
--

INSERT INTO `descargo` (`id`, `idP`, `cod`, `fDescargo`, `cant`, `pUnitario`, `tipo`, `idUser`) VALUES
(1, 9, '5', '2019-10-20 19:47:35', 2, 2, 'Shampoo', 1),
(2, 6, '2', '2019-10-21 04:11:31', 2, 2, 'Shampoo', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `modificaciones`
--

CREATE TABLE `modificaciones` (
  `id` int(11) NOT NULL,
  `idP` int(11) NOT NULL,
  `cod` varchar(14) COLLATE utf8_spanish_ci NOT NULL,
  `mFecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `idUser` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `id` int(11) NOT NULL,
  `cod` varchar(14) COLLATE utf8_spanish_ci NOT NULL,
  `marca` varchar(25) COLLATE utf8_spanish_ci NOT NULL,
  `tipo` varchar(25) COLLATE utf8_spanish_ci NOT NULL,
  `cant` int(11) NOT NULL,
  `descripcion` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `pUnitario` float NOT NULL,
  `Estado` varchar(25) COLLATE utf8_spanish_ci NOT NULL,
  `cFecha` date DEFAULT NULL,
  `mFecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `idUser` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`id`, `cod`, `marca`, `tipo`, `cant`, `descripcion`, `pUnitario`, `Estado`, `cFecha`, `mFecha`, `idUser`) VALUES
(5, '1234567891234', 'Head & Soulders', 'Shampoo', 7, 'Shampoo Anticaspa con  olor limon fresco', 2, 'Activo', '2019-10-19', '2019-10-20 17:37:43', 1),
(6, '2', '2', 'Shampoo', 7, '2', 2, 'Descargo', '2019-10-19', '2019-10-19 20:36:46', 1),
(7, '3', 'Sedal', 'Shampoo', 32, 'frd', 34, 'Descargo', '2019-10-20', '2019-10-20 17:44:32', 1),
(8, '4', 's', 'Shampoo', 1, 's', 1, 'Activo', '2019-10-20', '2019-10-20 17:46:00', 1),
(9, '5', '2', 'Shampoo', 2, '2', 2, 'Descargo', '2019-10-20', '2019-10-20 17:46:55', 1),
(10, '23', '2', 'Shampoo', 2, '2', 2, 'Activo', '2019-10-20', '2019-10-20 19:16:43', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `user` varchar(25) COLLATE utf8_spanish_ci NOT NULL,
  `passwd` varchar(64) COLLATE utf8_spanish_ci NOT NULL,
  `cFecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `nombre` varchar(25) COLLATE utf8_spanish_ci NOT NULL,
  `tipo` varchar(14) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `user`, `passwd`, `cFecha`, `nombre`, `tipo`) VALUES
(1, 'pMontero', '123456', '2019-10-21 21:53:03', 'Pablo Montero', 'Administrador'),
(2, 'jAlvares', '123456', '2019-10-22 04:57:40', 'Josue Alvares', 'Limitado');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `citas`
--
ALTER TABLE `citas`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `descargo`
--
ALTER TABLE `descargo`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `idP` (`idP`);

--
-- Indices de la tabla `modificaciones`
--
ALTER TABLE `modificaciones`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `idP` (`idP`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `citas`
--
ALTER TABLE `citas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `descargo`
--
ALTER TABLE `descargo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `modificaciones`
--
ALTER TABLE `modificaciones`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `descargo`
--
ALTER TABLE `descargo`
  ADD CONSTRAINT `descargo_ibfk_1` FOREIGN KEY (`idP`) REFERENCES `productos` (`id`);

--
-- Filtros para la tabla `modificaciones`
--
ALTER TABLE `modificaciones`
  ADD CONSTRAINT `modificaciones_ibfk_1` FOREIGN KEY (`idP`) REFERENCES `productos` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

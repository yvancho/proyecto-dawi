-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 14-07-2012 a las 06:26:44
-- Versión del servidor: 5.5.24
-- Versión de PHP: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `bd_proydawi` ------------------

DROP SCHEMA IF EXISTS `bd_proydawi` ;
CREATE SCHEMA IF NOT EXISTS `bd_proydawi` DEFAULT CHARACTER SET latin1 COLLATE latin1_spanish_ci ;
USE `bd_proydawi` ;

--------------------------------------------------

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_registraProy`(
    IN p_descProy VARCHAR(45),
    IN p_obsProy LONGTEXT,
    IN p_idSol INT(10)
)
BEGIN

DECLARE q int;
declare cod char(6);

select count(*) into q from tb_proyecto;

-- select substring(idproy,2) from tb_proyecto;
IF q=0 then
    insert into tb_proyecto(idProy,descProy,obsProy,idSol) values
    ('PROY01', p_descProy, p_obsProy, p_idSol);
END IF;

IF q>=1 then
    set q=q+1;
    set cod= concat('PROY',lpad(concat(q,''),2,0));
    insert into tb_proyecto(idProy,descProy,obsProy,idSol) values
    (cod, p_descProy,p_obsProy,p_idSol);
END IF;

END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_area`
--

CREATE TABLE IF NOT EXISTS `tb_area` (
  `idArea` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `descArea` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`idArea`),
  UNIQUE KEY `descArea_UNIQUE` (`descArea`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=6 ;

--
-- Volcado de datos para la tabla `tb_area`
--

INSERT INTO `tb_area` (`idArea`, `descArea`) VALUES
(2, 'Administración'),
(3, 'Contabilidad'),
(5, 'Logística'),
(4, 'RR.HH.'),
(1, 'TI');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_detalleproyecto`
--

CREATE TABLE IF NOT EXISTS `tb_detalleproyecto` (
  `idNumUsu` int(10) NOT NULL,
  `idProy` char(6) COLLATE latin1_spanish_ci NOT NULL,
  `idMoneda` int(10) unsigned NOT NULL,
  `costoProy` decimal(8,2) unsigned zerofill NOT NULL,
  `fecIniProy` date NOT NULL,
  `fecFinProy` date NOT NULL,
  PRIMARY KEY (`idNumUsu`,`idProy`),
  KEY `fk_tb_usuario_has_tb_proyecto_tb_proyecto1` (`idProy`),
  KEY `fk_tb_usuario_has_tb_proyecto_tb_usuario1` (`idNumUsu`),
  KEY `fk_tb_detalleproyecto_tb_moneda1` (`idMoneda`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `tb_detalleproyecto`
--

INSERT INTO `tb_detalleproyecto` (`idNumUsu`, `idProy`, `idMoneda`, `costoProy`, `fecIniProy`, `fecFinProy`) VALUES
(2, 'PROY01', 1, '010000.00', '2012-07-12', '2012-10-12'),
(4, 'PROY01', 1, '010000.00', '2012-07-12', '2012-10-12'),
(7, 'PROY01', 1, '010000.00', '2012-07-12', '2012-10-12'),
(9, 'PROY01', 1, '010000.00', '2012-07-12', '2012-10-12'),
(10, 'PROY01', 1, '010000.00', '2012-07-12', '2012-10-12'),
(11, 'PROY01', 1, '010000.00', '2012-07-12', '2012-10-12');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_distrito`
--

CREATE TABLE IF NOT EXISTS `tb_distrito` (
  `idDist` int(2) NOT NULL AUTO_INCREMENT,
  `descDist` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`idDist`),
  UNIQUE KEY `desc_dist_UNIQUE` (`descDist`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=43 ;

--
-- Volcado de datos para la tabla `tb_distrito`
--

INSERT INTO `tb_distrito` (`idDist`, `descDist`) VALUES
(32, 'Ancón'),
(2, 'ATE'),
(3, 'Barranco'),
(4, 'Breña'),
(33, 'Carabayllo'),
(1, 'Cercado de Lima'),
(34, 'Chaclacayo'),
(6, 'Chorrillos'),
(36, 'Chosica'),
(35, 'Cieneguilla'),
(5, 'Comas'),
(7, 'El Agustino'),
(18, 'Independencia'),
(8, 'Jesús Maria'),
(9, 'La Molina'),
(10, 'La Victoria'),
(11, 'Lince'),
(28, 'Los Olivos'),
(12, 'Magdalena del Mar'),
(13, 'Miraflores'),
(37, 'Pachacámac'),
(38, 'Pucusana'),
(14, 'Pueblo Libre'),
(15, 'Puente Piedra'),
(39, 'Punta Hermosa'),
(40, 'Punta Negra'),
(16, 'Rímac'),
(41, 'San Bartolo'),
(29, 'San Borja'),
(17, 'San Isidro'),
(26, 'San Juan de Lurigancho'),
(19, 'San Juan de Miraflores'),
(20, 'San Luis'),
(21, 'San Martín de Porres'),
(22, 'San Miguel'),
(31, 'Santa Anita'),
(42, 'Santa María del Mar'),
(27, 'Santa Rosa'),
(23, 'Santiago de Surco'),
(24, 'Surquillo'),
(30, 'Villa El Salvador'),
(25, 'Villa María del Triunfo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_estadocivil`
--

CREATE TABLE IF NOT EXISTS `tb_estadocivil` (
  `idEstCivil` char(1) COLLATE latin1_spanish_ci NOT NULL,
  `descEstCivil` varchar(20) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`idEstCivil`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `tb_estadocivil`
--

INSERT INTO `tb_estadocivil` (`idEstCivil`, `descEstCivil`) VALUES
('C', 'Casado'),
('S', 'Soltero');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_estadoinforme`
--

CREATE TABLE IF NOT EXISTS `tb_estadoinforme` (
  `idEstInfo` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `descEstInfo` varchar(15) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`idEstInfo`),
  UNIQUE KEY `descEstDoc_UNIQUE` (`descEstInfo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_estadoproyecto`
--

CREATE TABLE IF NOT EXISTS `tb_estadoproyecto` (
  `idEstProy` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `descEstProy` varchar(15) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`idEstProy`),
  UNIQUE KEY `descEstDoc_UNIQUE` (`descEstProy`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `tb_estadoproyecto`
--

INSERT INTO `tb_estadoproyecto` (`idEstProy`, `descEstProy`) VALUES
(3, 'Cancelado'),
(1, 'En curso'),
(2, 'Finalizado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_estadosolicitud`
--

CREATE TABLE IF NOT EXISTS `tb_estadosolicitud` (
  `idEstSol` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `descEstSol` varchar(20) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`idEstSol`),
  UNIQUE KEY `descEstDoc_UNIQUE` (`descEstSol`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `tb_estadosolicitud`
--

INSERT INTO `tb_estadosolicitud` (`idEstSol`, `descEstSol`) VALUES
(1, 'Aprobada'),
(2, 'Desaprobada'),
(3, 'Finalizada'),
(0, 'Por aprobar');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_estadousuario`
--

CREATE TABLE IF NOT EXISTS `tb_estadousuario` (
  `idEstUsu` int(11) NOT NULL,
  `descEstUsu` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`idEstUsu`),
  UNIQUE KEY `descEstUsu_UNIQUE` (`descEstUsu`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `tb_estadousuario`
--

INSERT INTO `tb_estadousuario` (`idEstUsu`, `descEstUsu`) VALUES
(1, 'ACTIVO'),
(0, 'INACTIVO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_expediente`
--

CREATE TABLE IF NOT EXISTS `tb_expediente` (
  `idExp` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `descExp` varchar(100) COLLATE latin1_spanish_ci NOT NULL,
  `urlExp` varchar(255) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`idExp`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_genero`
--

CREATE TABLE IF NOT EXISTS `tb_genero` (
  `idGen` char(1) COLLATE latin1_spanish_ci NOT NULL,
  `descGen` varchar(10) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`idGen`),
  UNIQUE KEY `desc_UNIQUE` (`descGen`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `tb_genero`
--

INSERT INTO `tb_genero` (`idGen`, `descGen`) VALUES
('F', 'Femenino'),
('M', 'Masculino');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_informe`
--

CREATE TABLE IF NOT EXISTS `tb_informe` (
  `idInfo` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `descInfo` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  `urlInfo` varchar(255) COLLATE latin1_spanish_ci NOT NULL,
  `fecInfo` date NOT NULL,
  `idTipoInfo` int(10) unsigned NOT NULL,
  `idProy` char(6) COLLATE latin1_spanish_ci NOT NULL,
  `idExp` int(10) unsigned NOT NULL,
  `idEstInfo` int(10) unsigned NOT NULL,
  PRIMARY KEY (`idInfo`),
  KEY `fk_tb_informe_tb_tipoInforme1` (`idTipoInfo`),
  KEY `fk_tb_informe_tb_proyecto1` (`idProy`),
  KEY `fk_tb_informe_tb_expediente1` (`idExp`),
  KEY `fk_tb_informe_tb_estadoInforme1` (`idEstInfo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_moneda`
--

CREATE TABLE IF NOT EXISTS `tb_moneda` (
  `idMoneda` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `descMoneda` varchar(30) COLLATE latin1_spanish_ci NOT NULL,
  `simbMoneda` char(3) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`idMoneda`),
  UNIQUE KEY `descMoneda_UNIQUE` (`descMoneda`),
  UNIQUE KEY `simbMoneda_UNIQUE` (`simbMoneda`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci COMMENT='tipos de moneda' AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `tb_moneda`
--

INSERT INTO `tb_moneda` (`idMoneda`, `descMoneda`, `simbMoneda`) VALUES
(1, 'Nuevos Soles', 'S/.'),
(2, 'Dólares Americanos', '$');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_pais`
--

CREATE TABLE IF NOT EXISTS `tb_pais` (
  `idPais` varchar(4) COLLATE latin1_spanish_ci NOT NULL,
  `descPais` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`idPais`),
  UNIQUE KEY `desc_pais_UNIQUE` (`descPais`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `tb_pais`
--

INSERT INTO `tb_pais` (`idPais`, `descPais`) VALUES
('AF', 'Afganistán'),
('AL', 'Albania'),
('DE', 'Alemania'),
('AD', 'Andorra'),
('AO', 'Angola'),
('AI', 'Anguilla'),
('AQ', 'Antartida'),
('AG', 'Antigua y Barbuda'),
('AN', 'Antillas Holandesas'),
('SA', 'Arabia Saudí'),
('DZ', 'Argelia'),
('AR', 'Argentina'),
('AM', 'Armenia'),
('AW', 'Aruba'),
('AU', 'Australia'),
('AT', 'Austria'),
('AZ', 'Azerbaiyán'),
('BS', 'Bahamas'),
('BH', 'Bahrein'),
('BD', 'Bangladesh'),
('BB', 'Barbados'),
('BE', 'Bélgica'),
('BZ', 'Belice'),
('BJ', 'Benin'),
('BM', 'Bermuda'),
('BT', 'Bhutan'),
('BY', 'Bielorrusia'),
('BO', 'Bolivia'),
('BA', 'Bosnia y Herzegovina'),
('BW', 'Botswana'),
('BR', 'Brasil'),
('BN', 'Brunei'),
('BG', 'Bulgaria'),
('BF', 'Burkina Faso'),
('BI', 'Burundi'),
('CV', 'Cabo Verde'),
('KH', 'Camboya'),
('CM', 'Camerún'),
('CA', 'Canadá'),
('TD', 'Chad'),
('CZ', 'Chequia'),
('CL', 'Chile'),
('CN', 'China continental'),
('CY', 'Chipre'),
('VA', 'Ciudad del Vaticano'),
('CO', 'Colombia'),
('KM', 'Comoros'),
('CG', 'Congo'),
('KP', 'Corea del Norte'),
('KR', 'Corea del Sur'),
('CI', 'Costa de Marfil'),
('CR', 'Costa Rica'),
('HR', 'Croacia'),
('CU', 'Cuba'),
('DK', 'Dinamarca'),
('DJ', 'Djibouti'),
('DM', 'Dominica'),
('EC', 'Ecuador'),
('EG', 'Egipto'),
('SV', 'El Salvador'),
('AE', 'Emiratos Árabes Unidos'),
('ER', 'Eritrea'),
('SK', 'Eslovaquia'),
('SI', 'Eslovenia'),
('ES', 'España'),
('US', 'Estados Unidos'),
('EE', 'Estonia'),
('ET', 'Etiopía'),
('FJ', 'Fiji'),
('PH', 'Filipinas'),
('FI', 'Finlandia'),
('FR', 'Francia'),
('GA', 'Gabón'),
('GM', 'Gambia'),
('GE', 'Georgia'),
('GS', 'Georgia del Sur e Islas Sandwich del Sur'),
('GH', 'Ghana'),
('GI', 'Gibraltar'),
('GD', 'Granada'),
('GR', 'Grecia'),
('GL', 'Groenlandia'),
('GP', 'Guadalupe'),
('GU', 'Guam'),
('GT', 'Guatemala'),
('GN', 'Guinea'),
('GQ', 'Guinea Ecuatorial'),
('GW', 'Guinea-Bissau'),
('GY', 'Guyana'),
('GF', 'Guyana Francesa'),
('HT', 'Haití'),
('NL', 'Holanda'),
('HN', 'Honduras'),
('HK', 'Hong Kong'),
('HU', 'Hungría'),
('IN', 'India'),
('ID', 'Indonesia'),
('IQ', 'Irak'),
('IR', 'Irán'),
('IE', 'Irlanda'),
('BV', 'Isla Bouvet'),
('CX', 'Isla Christmas'),
('IS', 'Islandia'),
('AX', 'Islas Åland'),
('KY', 'Islas Caimán'),
('CC', 'Islas Cocos'),
('CK', 'Islas Cook'),
('FO', 'Islas Faroe'),
('HM', 'Islas Heard y McDonald'),
('FK', 'Islas Malvinas'),
('MP', 'Islas Marianas'),
('MH', 'Islas Marshall'),
('NF', 'Islas Norfolk'),
('SB', 'Islas Salomón'),
('SJ', 'Islas Svalbard y Jan Mayen'),
('TC', 'Islas Turcas y Caicos'),
('UM', 'Islas Ultramarinas de Estados Unidos'),
('VG', 'Islas Vírgenes Británicas'),
('VI', 'Islas Vírgenes de los Estados Unidos'),
('IL', 'Israel'),
('IT', 'Italia'),
('JM', 'Jamaica'),
('JP', 'Japón'),
('JO', 'Jordania'),
('KZ', 'Kazajstán'),
('KE', 'Kenia'),
('KG', 'Kirguistán'),
('KI', 'Kiribati'),
('KW', 'Kuwait'),
('LA', 'Laos'),
('LS', 'Lesoto'),
('LV', 'Letonia'),
('LB', 'Líbano'),
('LR', 'Liberia'),
('LY', 'Libia'),
('LI', 'Liechtenstein'),
('LT', 'Lituania'),
('LU', 'Luxemburgo'),
('MO', 'Macao'),
('MK', 'Macedonia'),
('MG', 'Madagascar'),
('MY', 'Malasia'),
('MW', 'Malawi'),
('MV', 'Maldivas'),
('ML', 'Mali'),
('MT', 'Malta'),
('MA', 'Marruecos'),
('MQ', 'Martinica'),
('MU', 'Mauricio'),
('MR', 'Mauritania'),
('YT', 'Mayotte'),
('MX', 'México'),
('FM', 'Micronesia'),
('MD', 'Moldavia'),
('MC', 'Mónaco'),
('MN', 'Mongolia'),
('MS', 'Montserrat'),
('MZ', 'Mozambique'),
('MM', 'Myanmar'),
('NA', 'Namibia'),
('NR', 'Nauru'),
('NP', 'Nepal'),
('NI', 'Nicaragua'),
('NE', 'Níger'),
('NG', 'Nigeria'),
('NU', 'Niue'),
('NO', 'Noruega'),
('NC', 'Nueva Caledonia'),
('NZ', 'Nueva Zelanda'),
('OM', 'Omán'),
('PK', 'Pakistán'),
('PW', 'Palau'),
('PS', 'Palestina'),
('PA', 'Panamá'),
('PG', 'Papúa Nueva Guinea'),
('PY', 'Paraguay'),
('PE', 'Perú'),
('PN', 'Pitcairn'),
('PF', 'Polinesia Francesa'),
('PL', 'Polonia'),
('PT', 'Portugal'),
('PR', 'Puerto Rico'),
('QA', 'Qatar'),
('GB', 'Reino Unido'),
('CF', 'República Centroafricana'),
('DO', 'República Dominicana'),
('RE', 'Reunión'),
('RW', 'Ruanda'),
('RO', 'Rumanía'),
('RU', 'Rusia'),
('EH', 'Sáhara Occidental'),
('KN', 'Saint Kitts y Nevis'),
('WS', 'Samoa'),
('AS', 'Samoa Americana'),
('SM', 'San Marino'),
('VC', 'San Vicente y las Granadinas'),
('SH', 'Santa Helena'),
('LC', 'Santa Lucía'),
('ST', 'Santo Tomé y Príncipe'),
('SN', 'Senegal'),
('CS', 'Serbia y Montenegro'),
('SC', 'Seychelles'),
('SL', 'Sierra Leona'),
('SG', 'Singapur'),
('SY', 'Siria'),
('SO', 'Somalia'),
('LK', 'Sri Lanka'),
('PM', 'St. Pierre y Miquelon'),
('SZ', 'Suazilandia'),
('ZA', 'Sudáfrica'),
('SD', 'Sudán'),
('SE', 'Suecia'),
('CH', 'Suiza'),
('SR', 'Surinam'),
('TH', 'Tailandia'),
('TW', 'Taiwán'),
('TZ', 'Tanzania'),
('TJ', 'Tayikistán'),
('IO', 'Territorio Británico del Océano Índico'),
('TF', 'Territorios Franceses del Sur'),
('TL', 'Timor Oriental'),
('TG', 'Togo'),
('TK', 'Tokelau'),
('TO', 'Tonga'),
('TT', 'Trinidad y Tobago'),
('TN', 'Túnez'),
('TM', 'Turkmenistán'),
('TR', 'Turquía'),
('TV', 'Tuvalu'),
('UA', 'Ucrania'),
('UG', 'Uganda'),
('UY', 'Uruguay'),
('UZ', 'Uzbekistán'),
('VU', 'Vanuatu'),
('VE', 'Venezuela'),
('VN', 'Vietnam'),
('WF', 'Wallis y Futuna'),
('YE', 'Yemen'),
('ZM', 'Zambia'),
('ZW', 'Zimbabue');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_prioridadproy`
--

CREATE TABLE IF NOT EXISTS `tb_prioridadproy` (
  `idPrioProy` int(10) NOT NULL AUTO_INCREMENT,
  `descPrioProy` varchar(10) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`idPrioProy`),
  UNIQUE KEY `descPrioProy_UNIQUE` (`descPrioProy`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `tb_prioridadproy`
--

INSERT INTO `tb_prioridadproy` (`idPrioProy`, `descPrioProy`) VALUES
(1, 'Alta'),
(0, 'Baja');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_proyecto`
--

CREATE TABLE IF NOT EXISTS `tb_proyecto` (
  `idProy` char(6) COLLATE latin1_spanish_ci NOT NULL,
  `descProy` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  `obsProy` longtext COLLATE latin1_spanish_ci,
  `idSol` int(10) unsigned NOT NULL,
  `idPrioProy` int(10) NOT NULL DEFAULT '0',
  `idEstProy` int(10) unsigned NOT NULL DEFAULT '1',
  PRIMARY KEY (`idProy`),
  UNIQUE KEY `descProy_UNIQUE` (`descProy`),
  KEY `fk_tb_proyecto_tb_prioridadProy1` (`idPrioProy`),
  KEY `fk_tb_proyecto_tb_solicitud1` (`idSol`),
  KEY `fk_tb_proyecto_tb_estadoProyecto1` (`idEstProy`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `tb_proyecto`
--

INSERT INTO `tb_proyecto` (`idProy`, `descProy`, `obsProy`, `idSol`, `idPrioProy`, `idEstProy`) VALUES
('PROY01', 'Proyecto Films', 'proyecto de peliculas', 11, 0, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_solicitud`
--

CREATE TABLE IF NOT EXISTS `tb_solicitud` (
  `idSol` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `descSol` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  `obsSol` longtext COLLATE latin1_spanish_ci,
  `susDes` longtext COLLATE latin1_spanish_ci,
  `urlSol` varchar(255) COLLATE latin1_spanish_ci NOT NULL,
  `idArea` int(10) unsigned NOT NULL,
  `idUsu` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  `fecRegSol` date NOT NULL,
  `idEstSol` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`idSol`),
  KEY `fk_tb_solicitud_tb_area1` (`idArea`),
  KEY `fk_tb_solicitud_tb_estadoSolicitud1` (`idEstSol`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=18 ;

--
-- Volcado de datos para la tabla `tb_solicitud`
--

INSERT INTO `tb_solicitud` (`idSol`, `descSol`, `obsSol`, `susDes`, `urlSol`, `idArea`, `idUsu`, `fecRegSol`, `idEstSol`) VALUES
(1, 'Sistema de Gestion de Recursos', 'Recursos en general', 'No procede el valor agregado en Euros. Corregir a Nuevos Soles ó Dolares Americanos.', 'C:\\TEMP\\SRQ_05-07-12_21_16.pdf', 5, 'jefe2', '2012-07-05', 2),
(2, 'Sistema de Responsabilidad y Control Juridico', 'El sistema debe estar listo lo mas pronto posible.', NULL, 'C:\\TEMP\\SRQ_05-07-12_18_00.pdf', 3, 'jefe', '2012-07-05', 0),
(3, 'Sistema de reconocimiento calculado', 'para reconocimiento de monedas', NULL, 'C:\\TEMP\\SRQ_05-07-12_21_13.pdf', 5, 'jefe2', '2012-07-05', 0),
(11, 'Sistema de creacion tablas', 'para crear tablas dinamicas', NULL, 'C:\\TEMP\\SRQ_08-07-12_03_43.pdf', 3, 'jefe', '2012-07-08', 0),
(12, 'Sistema de Gestion de Documentos MPS', 'Se necesita urgentemente atender a esta solicitud.', NULL, 'C:\\TEMP\\SRQ_08-07-12_03_44.pdf', 3, 'jefe', '2012-07-08', 0),
(13, 'Sistema de Productividad Limitada', NULL, NULL, 'C:\\TEMP\\SRQ_08-07-12_03_46.pdf', 5, 'jefe2', '2012-07-08', 0),
(17, 'Sistema de Informes Digitales', 'Variaciones ', NULL, 'C:\\TEMP\\SRQ_08-07-12_09_50.pdf', 3, 'jefe', '2012-07-08', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_tipodocid`
--

CREATE TABLE IF NOT EXISTS `tb_tipodocid` (
  `idTipoDocId` int(10) NOT NULL AUTO_INCREMENT,
  `descTipoDocId` varchar(20) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`idTipoDocId`),
  UNIQUE KEY `desc_tipoDoc_UNIQUE` (`descTipoDocId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `tb_tipodocid`
--

INSERT INTO `tb_tipodocid` (`idTipoDocId`, `descTipoDocId`) VALUES
(1, 'DNI'),
(2, 'Doc. Extranjería'),
(3, 'Otro');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_tipoinforme`
--

CREATE TABLE IF NOT EXISTS `tb_tipoinforme` (
  `idTipoInfo` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `descTipoInfo` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`idTipoInfo`),
  UNIQUE KEY `descTipoInfo_UNIQUE` (`descTipoInfo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_tipousuario`
--

CREATE TABLE IF NOT EXISTS `tb_tipousuario` (
  `idTipoUsu` varchar(3) COLLATE latin1_spanish_ci NOT NULL,
  `descTipoUsu` varchar(30) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`idTipoUsu`),
  UNIQUE KEY `desc_UNIQUE` (`descTipoUsu`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `tb_tipousuario`
--

INSERT INTO `tb_tipousuario` (`idTipoUsu`, `descTipoUsu`) VALUES
('ADM', 'Administrador del Sistema'),
('ANS', 'Analista de Sistemas'),
('DES', 'Desarrollador'),
('GPR', 'Gerente de Proyecto'),
('JFA', 'Jefe de Área'),
('USU', 'Usuario');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_usuario`
--

CREATE TABLE IF NOT EXISTS `tb_usuario` (
  `idNumUsu` int(10) NOT NULL AUTO_INCREMENT,
  `idUsu` varchar(20) COLLATE latin1_spanish_ci NOT NULL,
  `clave` varchar(15) COLLATE latin1_spanish_ci NOT NULL,
  `email` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `idTipoDocId` int(10) NOT NULL,
  `nroDocId` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  `nomUsu` varchar(30) COLLATE latin1_spanish_ci NOT NULL,
  `apeUsu` varchar(30) COLLATE latin1_spanish_ci NOT NULL,
  `idGen` char(1) COLLATE latin1_spanish_ci NOT NULL,
  `idPais` varchar(4) COLLATE latin1_spanish_ci NOT NULL,
  `idDist` int(2) NOT NULL,
  `direccion` varchar(100) COLLATE latin1_spanish_ci NOT NULL,
  `fecNac` date NOT NULL,
  `idEstCivil` char(1) COLLATE latin1_spanish_ci NOT NULL,
  `telefono` varchar(30) COLLATE latin1_spanish_ci DEFAULT NULL,
  `idArea` int(10) unsigned NOT NULL DEFAULT '1',
  `idTipoUsu` varchar(3) COLLATE latin1_spanish_ci NOT NULL,
  `fecContrato` date NOT NULL,
  `esResponsable` int(1) unsigned DEFAULT '0',
  `idEstUsu` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`idNumUsu`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `nroDocId_UNIQUE` (`nroDocId`),
  UNIQUE KEY `id_usu_UNIQUE` (`idUsu`),
  KEY `fk_tb_usuario_tb_tipousuario` (`idTipoUsu`),
  KEY `fk_tb_usuario_tb_genero` (`idGen`),
  KEY `fk_tb_usuario_tb_estadoCivil` (`idEstCivil`),
  KEY `fk_tb_usuario_tb_tipoDocId` (`idTipoDocId`),
  KEY `fk_tb_usuario_tb_pais` (`idPais`),
  KEY `fk_tb_usuario_tb_distrito` (`idDist`),
  KEY `fk_tb_usuario_tb_estadousu` (`idEstUsu`),
  KEY `fk_tb_usuario_tb_area1` (`idArea`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=17 ;

--
-- Volcado de datos para la tabla `tb_usuario`
--

INSERT INTO `tb_usuario` (`idNumUsu`, `idUsu`, `clave`, `email`, `idTipoDocId`, `nroDocId`, `nomUsu`, `apeUsu`, `idGen`, `idPais`, `idDist`, `direccion`, `fecNac`, `idEstCivil`, `telefono`, `idArea`, `idTipoUsu`, `fecContrato`, `esResponsable`, `idEstUsu`) VALUES
(1, 'adm', '123', 'admin@mail.com', 1, '12345678', 'Yvan', 'Lopez', 'M', 'PE', 11, 'Jr. Echenique 111', '1983-04-11', 'S', '987999631', 1, 'ADM', '2000-10-10', 0, 1),
(2, 'des02', 'des02', 'des02@mail.com', 1, '82645319', 'Charly', 'Alberti', 'M', 'SA', 35, 'Jr. Caraman 651', '1981-09-08', 'S', '978005541', 1, 'DES', '2011-07-06', 1, 1),
(3, 'jefe', 'jefe', 'des02@proy.com', 1, '32495112', 'Julio', 'Bonilla', 'M', 'AW', 32, 'Jr. Clemencia 932', '1990-07-11', 'C', '977665123', 3, 'JFA', '1960-07-31', 0, 1),
(4, 'des01', 'des01', 'des01@mail.com', 1, '98714532', 'Carlos', 'Ramos', 'M', 'GA', 10, 'Jr Arcio 923', '1990-04-09', 'C', '998225102', 1, 'DES', '2001-03-08', 0, 1),
(5, 'jefe2', 'jefe2', 'jefe2@hotmail.com', 1, '36324058', 'Miguel', 'Saantos', 'M', 'SY', 16, 'Jr. Tomas Tello 126', '1967-07-27', 'C', '963124685', 5, 'JFA', '2003-02-05', 0, 1),
(6, 'gpro', '111', 'gerente@mail.com', 1, '94135756', 'Gustavo', 'Cerati', 'M', 'AR', 13, 'Av. Larco 987', '1959-08-11', 'S', '987102345', 1, 'GPR', '2011-07-31', 0, 1),
(7, 'des03', 'des03', 'des03@gmail.com', 2, '98740005', 'Green', 'Rows', 'F', 'IN', 38, 'Jr. Laos 541', '1989-02-13', 'S', '4120568', 1, 'DES', '2012-07-03', 0, 1),
(9, 'des04', 'des04', 'des04@yahoo.com', 1, '21003366', 'Oscar', 'Rojas', 'M', 'MO', 9, 'Av. Alameda 311', '1974-05-05', 'S', '95461357', 1, 'DES', '2010-07-02', 0, 1),
(10, 'ans01', 'ans01', 'ans1@mail.com', 1, '36277458', 'Luis', 'Gadea', 'M', 'KG', 11, 'Jr Camana 845', '1962-06-14', 'C', '4120000', 1, 'ANS', '2005-07-25', 0, 1),
(11, 'ans02', 'ans02', 'ans02@mail.net', 1, '65240014', 'Juan', 'Chimcho', 'M', 'LV', 14, 'Jr Velos 752', '1986-12-20', 'S', '954301000', 1, 'ANS', '2011-07-05', 0, 1),
(12, 'ans03', 'ans03', 'ans03@hotmail.com', 1, '32019846', 'Ricardo', 'Lestios', 'M', 'GE', 8, 'Jr. Polad 933', '1978-08-23', 'S', '654321001', 1, 'ANS', '2000-09-09', 0, 1),
(13, 'des05', 'des05', 'des05@imail.com', 1, '23659874', 'Pamela', 'Vertiz', 'F', 'CO', 13, 'Av. Surcos 133', '1963-01-03', 'S', '999555111', 1, 'DES', '2009-07-06', 0, 1),
(14, 'ans04', 'ans04', 'ans04@hotmail.com', 1, '99554432', 'John', 'Capurro', 'M', 'PE', 18, 'Jr Keil 987', '1980-12-20', 'S', '987021369', 1, 'ANS', '2010-07-02', 0, 1),
(15, 'ans05', 'ans05', 'ans05@hotmail.com', 1, '22115564', 'Hanibal', 'Lecter', 'M', 'PL', 17, 'Jr. Rep. de Panama 845', '1956-07-31', 'C', '965412001', 1, 'ANS', '2011-07-17', 0, 1),
(16, 'des06', 'des06', 'des06@hotmail.com', 1, '55447920', 'Jeny', 'Polares', 'F', 'PR', 25, 'Jr. Meiggs 333', '1990-03-06', 'S', '996125012', 1, 'DES', '2010-07-30', 0, 1);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `tb_detalleproyecto`
--
ALTER TABLE `tb_detalleproyecto`
  ADD CONSTRAINT `fk_tb_detalleproyecto_tb_moneda1` FOREIGN KEY (`idMoneda`) REFERENCES `tb_moneda` (`idMoneda`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_tb_usuario_has_tb_proyecto_tb_proyecto1` FOREIGN KEY (`idProy`) REFERENCES `tb_proyecto` (`idProy`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_tb_usuario_has_tb_proyecto_tb_usuario1` FOREIGN KEY (`idNumUsu`) REFERENCES `tb_usuario` (`idNumUsu`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `tb_informe`
--
ALTER TABLE `tb_informe`
  ADD CONSTRAINT `fk_tb_informe_tb_estadoInforme1` FOREIGN KEY (`idEstInfo`) REFERENCES `tb_estadoinforme` (`idEstInfo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_tb_informe_tb_expediente1` FOREIGN KEY (`idExp`) REFERENCES `tb_expediente` (`idExp`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_tb_informe_tb_proyecto1` FOREIGN KEY (`idProy`) REFERENCES `tb_proyecto` (`idProy`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_tb_informe_tb_tipoInforme1` FOREIGN KEY (`idTipoInfo`) REFERENCES `tb_tipoinforme` (`idTipoInfo`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `tb_proyecto`
--
ALTER TABLE `tb_proyecto`
  ADD CONSTRAINT `fk_tb_proyecto_tb_estadoProyecto1` FOREIGN KEY (`idEstProy`) REFERENCES `tb_estadoproyecto` (`idEstProy`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_tb_proyecto_tb_prioridadProy1` FOREIGN KEY (`idPrioProy`) REFERENCES `tb_prioridadproy` (`idPrioProy`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_tb_proyecto_tb_solicitud1` FOREIGN KEY (`idSol`) REFERENCES `tb_solicitud` (`idSol`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `tb_solicitud`
--
ALTER TABLE `tb_solicitud`
  ADD CONSTRAINT `fk_tb_solicitud_tb_area1` FOREIGN KEY (`idArea`) REFERENCES `tb_area` (`idArea`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_tb_solicitud_tb_estadoSolicitud1` FOREIGN KEY (`idEstSol`) REFERENCES `tb_estadosolicitud` (`idEstSol`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `tb_usuario`
--
ALTER TABLE `tb_usuario`
  ADD CONSTRAINT `fk_tb_usuario_tb_area1` FOREIGN KEY (`idArea`) REFERENCES `tb_area` (`idArea`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_tb_usuario_tb_distrito` FOREIGN KEY (`idDist`) REFERENCES `tb_distrito` (`idDist`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_tb_usuario_tb_estadoCivil` FOREIGN KEY (`idEstCivil`) REFERENCES `tb_estadocivil` (`idEstCivil`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_tb_usuario_tb_estadousuario` FOREIGN KEY (`idEstUsu`) REFERENCES `tb_estadousuario` (`idEstUsu`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_tb_usuario_tb_genero` FOREIGN KEY (`idGen`) REFERENCES `tb_genero` (`idGen`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_tb_usuario_tb_pais` FOREIGN KEY (`idPais`) REFERENCES `tb_pais` (`idPais`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_tb_usuario_tb_tipoDocId` FOREIGN KEY (`idTipoDocId`) REFERENCES `tb_tipodocid` (`idTipoDocId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_tb_usuario_tb_tipousuario` FOREIGN KEY (`idTipoUsu`) REFERENCES `tb_tipousuario` (`idTipoUsu`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

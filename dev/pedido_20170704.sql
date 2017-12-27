-- phpMyAdmin SQL Dump
-- version 4.0.10.12
-- http://www.phpmyadmin.net
--
-- Servidor: 127.2.28.130:3306
-- Tempo de Geração: 04/07/2017 às 17:56
-- Versão do servidor: 5.5.52
-- Versão do PHP: 5.3.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Banco de dados: `pedido`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `Address`
--

CREATE TABLE IF NOT EXISTS `Address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL,
  `cep` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `neighborhood` varchar(255) DEFAULT NULL,
  `number` int(11) NOT NULL,
  `publicPlace` varchar(255) DEFAULT NULL,
  `people_id` bigint(20) DEFAULT NULL,
  `state_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_hgt049robvg8uqrw0h9vygqp6` (`people_id`),
  KEY `FK_7vw93tc74xvk2lolc2f8fc9pu` (`state_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=37 ;

--
-- Fazendo dump de dados para tabela `Address`
--

INSERT INTO `Address` (`id`, `active`, `cep`, `city`, `neighborhood`, `number`, `publicPlace`, `people_id`, `state_id`) VALUES
(3, b'1', '08312000', 'SAO PAULO', 'VILA LEOPOLDINA', 200, 'RUA HASSIB MOFFARREJ', 2, 1),
(4, b'1', '08500400', 'FERRAZ DE VASCONCELOS', 'CENTRO', 740, 'AVENIDA DOM PEDRO I I', 1, 1),
(6, b'0', '30190.062', 'BELO HORIZONTE', 'BARRO PRETO', 1277, 'RUA TUPIS', 4, 2),
(7, b'1', '30190.062', 'BELO HORIZONTE', 'BARRO PRETO', 1277, 'RUA TUPIS', 5, 2),
(8, b'0', '15080-080', 'SÃ?O JOSE DO RIO PRETO', 'JARDIM SANTA LUZIA', 71, 'AV COMENDADOR MANCOR DAUD,', 6, 1),
(10, b'1', '15042-102', 'Sao Jose Do Rio Preto', 'Vl Ercilia', 559, 'R M. Goncalves', 8, 1),
(11, b'1', '60823-012', 'FORTALEZA', 'CIDADE DOS FUNCIONARIOS', 1840, 'RUA DESEMBARGADOR GONZAGA,', 9, 10),
(13, b'0', '15080-080', 'SAO JOSE DO RIO PRETO', 'JARDIM SANTA LUZIA', 71, 'AV COMENDADOR MANCOR DAUD,', 7, 1),
(15, b'0', '74934-300', 'APARECIDA DE GOIANIA', 'CARDOSO CONTINUACAO', 0, 'RUA 42, SN - QUADRA 64 LT 24', 10, 27),
(16, b'1', '74934-300', 'APARECIDA DE GOIANIA', 'CARDOSO CONTINUACAO', 0, 'RUA 42, SN - QUADRA 64 LT 24', 11, 27),
(17, b'1', '07.190-010', 'Guarulho', 'Jardim Flor do Campo', 346, 'R Guilherme Lino dos Santos  SALA 03', 12, 1),
(18, b'1', '05.093-040', 'Sao Paulo', 'Vl Anastacio', 184, 'R Conselheiro Olegario,', 13, 1),
(19, b'1', '02.162-030', 'SÃ?O PAULO', 'Jardim Julieta', 49, 'TERMINAL DE CARGAS FERNÃ?O DIAS  Q 05', 14, 1),
(20, b'1', '07.223-180', 'GUARULHOS', 'CUMBICA', 112, 'AVENIDA DIORAMA', 15, 1),
(21, b'1', '55642-210', 'Gravata', 'PRADO', 572, 'RUA GOVERNADOR AGAMENON MAGALHAES,', 16, 18),
(22, b'1', '02.117-02', 'SÃ?O PAULO', 'Vila Maria', 1071, 'R Professora Maria Jose Barone Fernandes', 17, 1),
(23, b'0', '15080-080', 'SAO JOSE DO RIO PRETO', 'JARDIM SANTA LUZIA', 71, 'AV COMENDADOR MANCOR DAUD,', 18, 1),
(24, b'1', '15080-080', 'SAO JOSE DO RIO PRETO', 'JARDIM SANTA LUZIA', 71, 'AV COMENDADOR MANCOR DAUD,', 19, 1),
(25, b'0', '08500400', 'ferraz', 'tranquilo e favoravael', 71, 'rua zÃ© do nunca', 20, 1),
(28, b'0', '07232078', 'GUARULHOS', 'CUMBICA', 231, 'RUA ICO', 21, 1),
(30, b'1', '07232078', 'GUARULHOS', 'CUMBICA', 231, 'RUA ICO', 22, 1),
(33, b'0', '03107001', 'Sao Paulo', 'Mooca', 1297, 'Av. Presidente Wilson -1297 - Armazem -03', 23, 1),
(34, b'0', '03107001', 'Sao Paulo', 'Mooca', 1297, 'Av. Presidente Wilson -1297 - Armazem -03', 24, 1),
(35, b'1', '03107001', 'Sao Paulo', 'Mooca', 1297, 'Av. Presidente Wilson -1297 - Armazem -03', 25, 1),
(36, b'1', '89935000', 'Princesa', 'PARQUE INDUSTRIAL', 364, 'anna rifel 364', 26, 24);

-- --------------------------------------------------------

--
-- Estrutura para tabela `Customer`
--

CREATE TABLE IF NOT EXISTS `Customer` (
  `signUpState` varchar(255) DEFAULT NULL,
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Fazendo dump de dados para tabela `Customer`
--

INSERT INTO `Customer` (`signUpState`, `id`) VALUES
('305058506115', 1),
('115285275112', 2),
('0620149800028', 3),
('0620149800028', 4),
('0620149800028', 5),
('647496736112', 6),
('647496736112', 7),
('00000000000', 8),
('062923528', 9),
('104768690', 10),
('104768690', 11),
('147647057110', 12),
('114899767115', 13),
('116602450110', 14),
('isento', 15),
('020644213', 16),
('149271514117', 17),
('647496736112', 18),
('647496736112', 19),
('1111111111', 20),
('336445724119', 21),
('336445724119', 22),
('117106191110', 23),
('117106191110', 24),
('117106191110', 25),
('62108476920', 26);

-- --------------------------------------------------------

--
-- Estrutura para tabela `OrdersProducts`
--

CREATE TABLE IF NOT EXISTS `OrdersProducts` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `amount` double NOT NULL,
  `valueUnit` double NOT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  `purchaseOrder_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_94iwqwqukbi4yp41s7njmmy64` (`product_id`),
  KEY `FK_gf53yry9uakfls7tyygeakowp` (`purchaseOrder_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=180 ;

--
-- Fazendo dump de dados para tabela `OrdersProducts`
--

INSERT INTO `OrdersProducts` (`id`, `amount`, `valueUnit`, `product_id`, `purchaseOrder_id`) VALUES
(1, 100, 5.3, 1, 1),
(2, 12, 33.5, 29, 2),
(3, 36, 12.3, 10, 2),
(4, 72, 10.7, 9, 2),
(5, 80, 18.9, 13, 2),
(6, 48, 7.5, 18, 2),
(13, 12, 33.5, 29, 5),
(14, 36, 12.3, 10, 5),
(15, 72, 10.7, 9, 5),
(16, 80, 18.9, 13, 5),
(17, 48, 7.5, 18, 5),
(18, 1, 5.3, 1, 6),
(19, 2, 6.55, 2, 6),
(20, 1, 5.3, 1, 7),
(21, 2, 6.55, 2, 7),
(22, 2, 5.3, 1, 8),
(23, 2, 6.55, 2, 8),
(24, 2, 5.3, 1, 9),
(25, 2, 6.55, 2, 9),
(26, 36, 7.95, 7, 10),
(27, 36, 6.6, 6, 10),
(28, 48, 12.3, 10, 10),
(29, 24, 18.9, 13, 10),
(30, 48, 16.9, 12, 10),
(31, 312, 5.3, 1, 11),
(32, 240, 6.9, 3, 11),
(33, 24, 12.3, 10, 12),
(34, 48, 10.7, 9, 12),
(35, 24, 18.9, 13, 12),
(36, 24, 16.9, 12, 12),
(37, 96, 7.5, 18, 12),
(38, 504, 5.3, 1, 13),
(39, 72, 6.55, 2, 13),
(40, 36, 7.95, 7, 14),
(41, 48, 18.9, 13, 14),
(42, 64, 16.9, 12, 14),
(43, 72, 14.5, 24, 14),
(44, 24, 18.9, 37, 14),
(45, 36, 7.95, 7, 15),
(46, 48, 18.9, 13, 15),
(47, 64, 16.9, 12, 15),
(49, 72, 11.9, 41, 15),
(50, 24, 15.9, 40, 15),
(51, 264, 6.55, 2, 16),
(53, 240, 5.3, 1, 16),
(54, 80, 18.9, 13, 17),
(55, 40, 16.9, 12, 17),
(56, 36, 7.95, 7, 17),
(57, 40, 16.9, 12, 18),
(58, 40, 19.9, 14, 18),
(59, 60, 13.95, 11, 18),
(60, 180, 7.95, 7, 19),
(61, 72, 4.4, 5, 20),
(62, 36, 6.6, 6, 20),
(63, 72, 12.3, 10, 20),
(64, 48, 10.7, 9, 20),
(66, 16, 32, 43, 20),
(67, 24, 18.9, 13, 20),
(68, 312, 5.3, 1, 21),
(69, 80, 18.9, 13, 22),
(70, 40, 16.9, 12, 22),
(71, 80, 18.9, 13, 23),
(72, 36, 7.95, 7, 24),
(73, 36, 12.3, 10, 24),
(74, 36, 10.7, 9, 24),
(75, 40, 18.9, 13, 24),
(76, 24, 16.9, 12, 24),
(77, 192, 5.3, 1, 25),
(78, 96, 6.55, 2, 25),
(79, 312, 5.3, 1, 26),
(80, 60, 10.7, 9, 27),
(81, 40, 16.9, 12, 27),
(82, 36, 7.95, 7, 28),
(83, 36, 6.6, 6, 28),
(84, 60, 12.3, 10, 28),
(85, 36, 10.7, 9, 28),
(86, 36, 7.95, 7, 29),
(87, 48, 12.3, 10, 29),
(88, 24, 10.7, 9, 29),
(89, 48, 18.9, 13, 29),
(90, 24, 16.9, 12, 29),
(91, 72, 7.5, 18, 29),
(92, 96, 18.9, 13, 30),
(93, 360, 5.3, 1, 31),
(94, 216, 6.55, 2, 31),
(95, 36, 4.4, 5, 32),
(96, 96, 12.3, 10, 32),
(97, 24, 10.7, 9, 32),
(98, 24, 18.9, 13, 32),
(99, 40, 16.9, 12, 32),
(101, 64, 19.9, 14, 33),
(102, 60, 12.3, 10, 34),
(103, 40, 16.9, 12, 34),
(104, 80, 18.9, 13, 34),
(105, 36, 6.6, 6, 35),
(106, 36, 12.3, 10, 35),
(107, 96, 10.7, 9, 35),
(108, 48, 18.9, 13, 35),
(109, 40, 16.9, 12, 35),
(110, 72, 7.5, 18, 35),
(111, 216, 5.3, 1, 36),
(112, 30, 13.75, 4, 36),
(113, 216, 5.3, 1, 37),
(114, 33, 13.75, 4, 37),
(115, 36, 7.95, 7, 38),
(116, 24, 12.3, 10, 38),
(117, 72, 18.9, 13, 38),
(118, 48, 16.9, 12, 38),
(119, 72, 10.9, 20, 38),
(120, 24, 7.5, 18, 38),
(121, 36, 7.95, 7, 39),
(122, 24, 12.3, 10, 39),
(123, 72, 18.9, 13, 39),
(124, 48, 16.9, 12, 39),
(125, 72, 10.9, 20, 39),
(126, 24, 7.5, 18, 39),
(127, 216, 5.3, 1, 40),
(128, 80, 18.9, 13, 41),
(129, 60, 12.3, 10, 41),
(130, 60, 12.3, 10, 42),
(131, 36, 10.7, 9, 42),
(132, 80, 18.9, 13, 42),
(133, 40, 16.9, 12, 42),
(134, 36, 4.4, 5, 43),
(136, 36, 12.3, 10, 43),
(137, 48, 10.7, 9, 43),
(138, 24, 18.9, 13, 43),
(139, 48, 7.5, 18, 43),
(140, 432, 6.3, 48, 44),
(141, 168, 8.9, 49, 44),
(142, 36, 7.95, 7, 45),
(143, 36, 12.3, 10, 45),
(144, 48, 10.7, 9, 45),
(145, 24, 18.9, 13, 45),
(146, 40, 16.9, 12, 45),
(147, 36, 9.5, 8, 46),
(148, 48, 13.95, 11, 46),
(149, 36, 7.95, 7, 46),
(150, 48, 12.3, 10, 46),
(151, 40, 18.9, 13, 46),
(152, 312, 6.3, 48, 47),
(153, 216, 7.9, 50, 47),
(154, 36, 7.95, 7, 48),
(155, 72, 6.6, 6, 48),
(156, 24, 12.3, 10, 48),
(157, 48, 10.7, 9, 48),
(158, 16, 18.9, 13, 48),
(159, 24, 16.9, 12, 48),
(160, 36, 7.95, 7, 49),
(161, 60, 12.3, 10, 49),
(162, 64, 18.9, 13, 49),
(163, 40, 55, 52, 50),
(164, 108, 4.9, 51, 51),
(165, 24, 14.2, 57, 51),
(166, 48, 12.4, 56, 51),
(167, 24, 21.95, 58, 51),
(168, 24, 19.9, 59, 51),
(169, 48, 8.75, 60, 51),
(170, 2, 40, 62, 52),
(171, 40, 5.5, 69, 54),
(172, 40, 12.55, 67, 54),
(173, 36, 8.95, 53, 54),
(174, 24, 14.2, 57, 54),
(175, 24, 12.4, 56, 54),
(176, 48, 21.95, 58, 54),
(177, 48, 19.9, 59, 54),
(178, 264, 6.3, 48, 55),
(179, 168, 7.9, 50, 55);

-- --------------------------------------------------------

--
-- Estrutura para tabela `People`
--

CREATE TABLE IF NOT EXISTS `People` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL,
  `cpfCnpj` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=27 ;

--
-- Fazendo dump de dados para tabela `People`
--

INSERT INTO `People` (`id`, `active`, `cpfCnpj`, `email`, `name`) VALUES
(1, b'1', '15180657000155', 'carlosvendas@hotmail.com', 'C.A.FERREIRA VIDROS ME'),
(2, b'1', '02926572000121', 'carlosvendas@hotmail.com', 'FLORES ONLINE S/A'),
(3, b'0', '17185679000133', 'amilton@othondecarvalho.com.br', 'OTHON DE CARVALHO E CIA LTDA'),
(4, b'0', '17185679000133', 'amilton@othondecarvalho.com.br', 'OTHON DE CARVALHO E CIA LTDA'),
(5, b'1', '17185679000133', 'amilton@othondecarvalho.com.br', 'OTHON DE CARVALHO E CIA LTDA'),
(6, b'0', '08652441000180', 'jose_carlos@ataluz.com.br', 'BIANCOLUCE ILUMINACAO IMPORTACAO E EXPORTACAO LTDA'),
(7, b'0', '08652441000180', 'jose_carlos@ataluz.com.br', 'BIANCOLUCE ILUMINACAO IMPORTACAO E EXPORTACAO LTDA'),
(8, b'1', '59796961000105', 'jose_carlos@ataluz.com.br', 'Ataluz Materiais Eletricos Ltda - Epp'),
(9, b'1', '03646340000182', 'duarteiluminacao@yahoo.com.br', 'JOAO BERONISIO DUARTE DE SOUZA ME'),
(10, b'0', '12322853000129', 'sirlenemariano@gmail.com', 'SIRLENE MARIANO DE SOUZA ME'),
(11, b'1', '12322853000129', 'sirlenemariano@gmail.com', 'SIRLENE MARIANO DE SOUZA ME'),
(12, b'1', '12082122000234', 'transmaisexpresssp@transmaisexpress.com.br', 'TRANS EXPRESS TRANSPORTES LTDA'),
(13, b'1', '00418557000228', 'jose_carlos@ataluz.com.br', 'Transportadora Almeida Fante LTDA(TAF)'),
(14, b'1', '05543757000226', 'sirlenemariano@gmail.com', 'CAIAPO CARGAS LTDA'),
(15, b'1', '04974172000206', 'juridico@uniaoorganizacao.com.br', 'MULTICARGAS LTDA'),
(16, b'1', '00262666000118', 'compras@caroatahomecenter.com.br', 'CAROATA HOME CENTER LTDA'),
(17, b'1', '62877345000509', 'lasil@lasil.com', 'LASIL COMERCIO E TRANSPORTES'),
(18, b'0', '08652441000180', 'jose_carlos@ataluz.com.br', 'BIANCOLUCE ILUMINACAO IMPORTACAO E EXPORT. LTDA'),
(19, b'1', '08652441000180', 'jose_carlos@ataluz.com.br', 'BIANCOLUCE ILUMINACAO IMPORT. E EXPORT. LTDA'),
(20, b'0', '0000000000', 'diegolirio.dl@gmail.com', 'diego ltda'),
(21, b'0', '00738833000235', 'undefined', 'CFB MORAES REPRESENTAÃ?Ã?O REDESPACHO TRANSROTA'),
(22, b'1', '00738833000235', 'undefined', 'CFB MORAES REPRESENTACAO  REDESPACHO TRANSROTA'),
(23, b'0', '71154462000373', 'coletaspo@powerlogistica.com.br', 'Power Express'),
(24, b'0', '71154462000373', 'coletaspo@powerlogistica.com.br', 'Power Express'),
(25, b'1', '71154462000373', 'coletaspo@powerlogistica.com.br', 'Power Express'),
(26, b'1', '62108476920', 'ssollos.70j0xp 2-ogeztiojrgiytcobq@mail.mercadolivre.com', 'SOLLOS / MARCO KITCH');

-- --------------------------------------------------------

--
-- Estrutura para tabela `Product`
--

CREATE TABLE IF NOT EXISTS `Product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `valueUnit` double NOT NULL,
  `productType_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_tl2frskf9y9xrpfit4dg8sr0q` (`productType_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=70 ;

--
-- Fazendo dump de dados para tabela `Product`
--

INSERT INTO `Product` (`id`, `active`, `code`, `description`, `valueUnit`, `productType_id`) VALUES
(1, b'0', '001', 'COPO VELA 5X10', 5.3, 3),
(2, b'0', '002', 'COPO VELA 8X10', 6.55, 3),
(3, b'0', '003', 'COPO VELA 8X18', 6.9, 3),
(4, b'1', '004', 'AQUARIO TERRARIO PEQUENO', 13.75, 3),
(5, b'0', '100', 'ESFERA 10X15 BICO DE JACA TR', 4.4, 3),
(6, b'0', '101', 'ESFERA 10X15 TRANSPARENTE', 6.6, 3),
(7, b'0', '102', 'ESFERA 10X15 LEITOSA', 7.95, 3),
(8, b'0', '103', 'ESFERA 10X15 FOSCA', 9.5, 3),
(9, b'0', '104', 'ESFERA 10X20 TRANSPARENTE', 10.7, 3),
(10, b'0', '105', 'ESFERA 10X20 LEITOSA', 12.3, 3),
(11, b'0', '106', 'ESFERA 10X20 FOSCA', 13.95, 3),
(12, b'0', '107', 'ESFERA 15X28 TRANSPARENTE', 16.9, 3),
(13, b'0', '108', 'ESFERA 15X28 LEITOSA', 18.9, 3),
(14, b'0', '109', 'ESFERA 15X28 FOSCA', 19.9, 3),
(18, b'0', '113', 'SINALEIRO FECHADO TR', 7.5, 3),
(19, b'1', '114', 'MANGA BAIXA TRANSPARENTE', 10.9, 3),
(20, b'1', '115', 'MANGA PEQUENA TRANSPARENTE', 10.9, 3),
(21, b'1', '116', 'MANGA MEDIA TRANSPARENTE', 12, 3),
(22, b'1', '117', 'MANGA KENNEDY TRANSPARENTE', 12, 3),
(23, b'1', '118', 'MANGA BAIXA FOSCA', 13.9, 3),
(24, b'1', '119', 'MANGA PEQUENA FOSCA', 14.5, 3),
(25, b'1', '120', 'MANGA MEDIA FOSCA', 14.9, 3),
(26, b'1', '121', 'MANGA KENNEDY FOSCA', 14.9, 3),
(27, b'1', '122', 'TULIPA ROMA', 23.9, 3),
(28, b'1', '123', 'TULIPA RIZO', 23.9, 3),
(29, b'1', '124', 'BOLA DE FUTEBOL 10X20', 33.5, 3),
(31, b'1', '125', 'BOLA DE FUTEBOL 15X28', 45.9, 3),
(32, b'1', '126', 'BACIA SP LEITOSA 15CM', 31.5, 3),
(33, b'1', '127', 'BACIA SP LEITOSA 19 CM', 39.5, 3),
(34, b'1', '128', 'PERA TRANSPARENTE', 9.9, 3),
(36, b'1', '129', 'PERA LEITOSA', 12, 3),
(37, b'1', '130', 'TULIPA CARACOL FOSCA', 18.9, 3),
(38, b'1', '131', 'TULIPA REI FOSCA', 18.9, 3),
(40, b'1', '151', 'TULIPA CARACOL FOSCA', 15.9, 3),
(41, b'1', '152', 'MANGA PEQUENA FOSCA', 11.9, 3),
(43, b'1', '175', 'ESFERA 15X28 LETIOSA FOSCA S/C', 32, 3),
(44, b'1', '150', 'MANGA PEQ.FOSCA', 11.9, 3),
(47, b'1', '153', 'ESFERA 15X28 S/C LEITOSA FOSCA', 32, 3),
(48, b'1', '001', 'COPO VELA 5X10', 6.3, 3),
(49, b'1', '003', 'COPO VELA 8X18', 8.9, 3),
(50, b'1', '002', 'COPO VELA 8X10', 7.9, 3),
(51, b'1', '100', 'ESFERA 10X15 BICO DE JACA TR', 4.9, 3),
(52, b'1', '132', 'DROPS B.15 LEITOSO', 55, 3),
(53, b'1', '102', 'ESFERA 10X15 LEITOSA', 8.95, 3),
(54, b'1', '101', 'ESFERA 10X15 TRANSPARENTE', 7.55, 3),
(55, b'1', '103', 'ESFERA 10X15 FOSCA', 10.5, 3),
(56, b'1', '104', 'ESFERA 10X20 TRANSPARENTE', 12.4, 3),
(57, b'1', '105', 'ESFERA 10X20 LEITOSA', 14.2, 3),
(58, b'1', '108', 'ESFERA 15X28 LEITOSA', 21.95, 3),
(59, b'1', '107', 'ESFERA 15X28 TRANSPARENTE', 19.9, 3),
(60, b'1', '113', 'SINALEIRO FECHADO TR', 8.75, 3),
(62, b'1', '176', 'ESFERA 15X28 LEITOSA', 40, 3),
(63, b'1', '106', 'ESFERA 10X20 FOSCA', 16, 3),
(64, b'1', '109', 'ESFERA 15X28 FOSCA', 22.9, 3),
(65, b'1', '110', 'ESFERA 15X28 S/C FOSCA', 36.8, 3),
(67, b'1', '112', 'DROPS B.10 LEITOSA', 12.55, 3),
(68, b'1', '111', 'DROPS B.10 TRANSPARENTE', 11.4, 3),
(69, b'1', '154', 'DROPS B.10 TR BICO DE JACA', 5.5, 3);

-- --------------------------------------------------------

--
-- Estrutura para tabela `ProductType`
--

CREATE TABLE IF NOT EXISTS `ProductType` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Fazendo dump de dados para tabela `ProductType`
--

INSERT INTO `ProductType` (`id`, `description`) VALUES
(1, 'Caixa'),
(2, 'Unidade'),
(3, 'Peça');

-- --------------------------------------------------------

--
-- Estrutura para tabela `PurchaseOrder`
--

CREATE TABLE IF NOT EXISTS `PurchaseOrder` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `condicaoPagamento` varchar(255) DEFAULT NULL,
  `contactRecipient` varchar(255) DEFAULT NULL,
  `emissionDate` datetime NOT NULL,
  `phoneRecipient` varchar(255) DEFAULT NULL,
  `phoneSender` varchar(255) DEFAULT NULL,
  `phoneShippingCompany` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `representative` varchar(255) DEFAULT NULL,
  `status` varchar(20) DEFAULT 'pending',
  `typeFreight` char(1) NOT NULL,
  `customerAddressRecipient_id` bigint(20) DEFAULT NULL,
  `customerAddressSender_id` bigint(20) DEFAULT NULL,
  `customerAddressShippingCompany_id` bigint(20) DEFAULT NULL,
  `userCreated_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_6in0wv7vnpt03nnu4afqi15jx` (`customerAddressRecipient_id`),
  KEY `FK_rjhtpx6jnnkn8q0vokpgx3syk` (`customerAddressSender_id`),
  KEY `FK_7vj8ynvf2xrd6hwjmo55d3v1x` (`customerAddressShippingCompany_id`),
  KEY `FK_d0tcbs1tptxjh4rpntolsc73r` (`userCreated_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=56 ;

--
-- Fazendo dump de dados para tabela `PurchaseOrder`
--

INSERT INTO `PurchaseOrder` (`id`, `condicaoPagamento`, `contactRecipient`, `emissionDate`, `phoneRecipient`, `phoneSender`, `phoneShippingCompany`, `remark`, `representative`, `status`, `typeFreight`, `customerAddressRecipient_id`, `customerAddressSender_id`, `customerAddressShippingCompany_id`, `userCreated_id`) VALUES
(1, '30 dias', 'alison', '2016-03-21 12:57:42', '(11) 2226-0000', '(11) 4676-6551', '(11) 4676-6551', 'frete pago', 'Carlos', 'completed', 'R', 3, 4, 4, 2),
(2, '30 dias', 'Amilton', '2016-04-01 12:25:09', '(11) 4676-6551', '(11) 94037-8472', '(11) 2207-1707', '', 'Carlos', 'completed', 'D', 4, 4, 17, 2),
(5, '30 dias', 'Amilton', '2016-04-04 12:57:06', '(31) 2103-3000', '(11) 94037-8472', '(11) 2207-1707', '', 'Carlos', 'completed', 'D', 7, 4, 17, 2),
(6, '20', 'undefined', '2016-04-04 13:45:50', '(11) 4676-6551', '(11) 4676-6551', '(11) 4676-6551', 'undefined', 'undefined', 'completed', 'R', 4, 4, 4, 2),
(7, '30 dias', 'Diego', '2016-04-10 13:41:51', '11.46766551', '(11) 4676-6551', '(11) 2193-4510', '', 'carlos', 'canceled', 'D', 25, 4, 19, 2),
(8, '30 dias', 'carlos', '2016-04-10 13:58:37', '(11) 4676-6551', '11.46766551', '(11) 2193-4510', 'undefined', 'diego', 'canceled', 'R', 4, 25, 19, 2),
(9, '30 dias', 'diego', '2016-04-10 14:54:10', '11.46766551', '(11) 4676-6551', '(11) 2193-4510', 'undefined', 'maradona', 'canceled', 'D', 25, 4, 19, 2),
(10, '30 Dias', 'Amilton', '2016-05-10 09:01:11', '(31) 2103-3000', '(11) 94037-8472', '(11) 2207-1707', 'Reposicao de 36 pcs  de 10x15 leitosa  Autorizado pelo Sr. Carlos', 'Carlos', 'completed', 'D', 7, 4, 17, 2),
(11, '30/45 Dias', 'Alison', '2016-05-10 10:47:33', '(11) 95124-2750', '(11) 94037-8472', '(11) 94037-8472', 'undefined', 'undefined', 'completed', 'R', 3, 4, 4, 2),
(12, '30 Dias', 'Amilton', '2016-05-30 10:49:28', '(31) 2103-3000', '(11) 94037-8472', '(11) 2207-1707', 'undefined', 'CARLOS', 'completed', 'D', 7, 4, 17, 2),
(13, '30/45 dias', 'Alison', '2016-05-31 14:51:20', '(11) 95124-2750', '(11) 94037-8472', '(11) 94037-8472', 'undefined', 'CARLOS', 'completed', 'R', 3, 4, 4, 2),
(14, '30/45/60 DIAS', 'KELLY MEDEIROS', '2016-06-03 14:32:44', '(81) 3533-6761', '(11) 94037-8472', '(11) 2954-4062', '', 'CARLOS', 'completed', 'D', 21, 4, 22, 2),
(15, '30/45/60 DIAS', 'KELLY', '2016-06-08 09:46:51', '(81) 3533-6761', '(11) 94037-8472', '(11) 2954-4062', '', 'CARLOS', 'completed', 'D', 21, 4, 22, 2),
(16, '30/45 DIAS', 'ALISON', '2016-06-08 13:00:07', '(11) 95124-2750', '(11) 94037-8472', '(11) 94037-8472', 'undefined', 'CARLOS', 'completed', 'R', 3, 4, 4, 2),
(17, 'A VISTA', 'JOSE CARLOS', '2016-06-09 16:40:53', '(17) 3363-5666', '(11) 94037-8472', '(11) 3799-3131', 'undefined', 'CARLOS', 'completed', 'D', 24, 4, 18, 2),
(18, 'A VISTA', 'JOSE CARLOS', '2016-07-04 10:35:29', '(17) 2136-5666', '(11) 4676-6551', '(11) 3799-3131', 'undefined', 'CARLOS', 'completed', 'D', 10, 4, 18, 2),
(19, '30 DIAS', 'AMILTON', '2016-07-08 10:11:33', '(31) 2103-3000', '(11) 94037-8472', '(11) 2207-1707', 'URGENTE 10X15 LEITOSA', 'CARLOS', 'completed', 'D', 7, 4, 17, 2),
(20, '30 DIAS', 'AMILTON', '2016-07-08 10:24:45', '(31) 2103-3000', '(11) 94037-8472', '(11) 2207-1707', 'RESTANTE DO PEDIDO', 'CARLOS', 'completed', 'D', 7, 4, 17, 2),
(21, '30 dias', 'Alison', '2016-07-11 12:05:28', '(11) 95124-2750', '(11) 94037-8472', '(11) 94037-8472', 'undefined', 'CARLOS', 'completed', 'R', 3, 4, 4, 2),
(22, 'A VISTA', 'JOSE CARLOS', '2016-08-02 13:44:13', '(17) 2136-5666', '(11) 4676-6551', '(11) 3799-3131', 'DEPOSITO EM CONTA/ BRADESCO', 'CARLOS', 'completed', 'D', 10, 4, 18, 2),
(23, 'A VISTA', 'JOSE CARLOS', '2016-08-02 13:50:07', '(17) 3363-5666', '(11) 4676-6551', '(11) 3799-3131', 'A VISTA/ BRADESCO', 'CARLOS', 'completed', 'D', 24, 4, 18, 2),
(24, '30 Dias', 'Amilton', '2016-08-10 12:37:03', '(31) 2103-3000', '(11) 94037-8472', '(11) 2207-1707', '', 'CARLOS', 'completed', 'D', 7, 4, 17, 2),
(25, '30 Dias', 'Alison', '2016-08-11 09:22:48', '(11) 95124-2750', '(11) 94037-8472', '(11) 94037-8472', '', 'Carlos', 'completed', 'R', 3, 4, 4, 2),
(26, '30 DIAS', 'ALISON', '2016-09-08 10:25:15', '(11) 95124-2750', '(11) 94037-8472', '(11) 94037-8472', 'undefined', 'CARLOS', 'completed', 'R', 3, 4, 4, 2),
(27, 'A VISTA', 'JOSE CARLOS', '2016-09-16 10:12:51', '(17) 2136-5666', '(11) 4676-6551', '(11) 3799-3131', '', 'CARLOS', 'completed', 'D', 10, 4, 18, 2),
(28, 'A VISTA', 'JOSE CARLOS', '2016-09-16 10:20:28', '(17) 3363-5666', '(11) 4676-6551', '(11) 3799-3131', '', 'CARLOS', 'completed', 'D', 24, 4, 18, 2),
(29, '30 DIAS', 'AMILTON', '2016-09-19 18:07:59', '(31) 2103-3000', '(11) 94037-8472', '(11) 2207-1707', '', 'CARLOS', 'completed', 'D', 7, 4, 17, 2),
(30, '30 DIAS', 'AMILTON', '2016-09-30 11:28:26', '(31) 2103-3000', '(11) 94037-8472', '(11) 2207-1707', 'URGENTE', 'CARLOS', 'completed', 'D', 7, 4, 17, 2),
(31, '30/45 DIAS', 'ALISON', '2016-10-20 13:18:23', '(11) 95124-2750', '(11) 4676-6551', '(11) 94037-8472', 'URGENTE', 'CARLOS', 'completed', 'R', 3, 4, 4, 2),
(32, '30 DIAS', 'AMILTON', '2016-11-01 10:32:56', '(31) 2103-3000', '(11) 94037-8472', '(11) 2207-1707', '', 'CARLOS', 'completed', 'D', 7, 4, 17, 2),
(33, 'A VISTA', 'JOSE CARLOS', '2016-11-08 07:12:36', '(17) 2136-5666', '(11) 94037-8472', '(11) 3799-3131', '', 'CARLOS', 'completed', 'D', 10, 4, 18, 2),
(34, 'A VISTA', 'JOSE CARLOS', '2016-11-08 07:17:06', '(17) 3363-5666', '(11) 94037-8472', '(11) 3799-3131', 'DEPOSITO EM CONTA (BRADESCO)', 'CARLOS', 'completed', 'D', 24, 4, 18, 2),
(35, '30 DIAS', 'AMILTON', '2016-12-02 06:57:39', '(31) 2103-3000', '(11) 94037-8472', '(11) 2207-1707', '', 'CARLOS', 'completed', 'D', 7, 4, 17, 2),
(36, '30', 'Alison (tranquilo e FavorÃ?Â¡vel)', '2016-12-06 12:40:22', '(11) 95124-2750', '(11) 94037-8472', '(11) 94037-8472', 'URGENTE', 'Carlos', 'completed', 'R', 3, 4, 4, 2),
(37, '30 Dias', 'Alison', '2016-12-08 06:26:43', '(11) 95124-2750', '(11) 94037-8472', '(11) 94037-8472', 'urgente', 'Carlos', 'completed', 'R', 3, 4, 4, 2),
(38, '30/45/60 DIAS', 'Kelly Medeiros', '2016-12-13 13:34:21', '(81) 3533-6761', '(11) 94037-8472', '(11) 2954-4062', 'AGUARDAR A CONFIRMAÃ?Ã?O..', 'CARLOS', 'completed', 'D', 21, 4, 22, 2),
(39, '30/45/60 DIAS', 'KELLY MEDEIROS', '2016-12-14 14:23:03', '(81) 3533-6761', '(11) 4676-6551', '1124121459', 'AUTORIZADO/ KELLY', 'CARLOS', 'completed', 'D', 21, 4, 30, 2),
(40, '30 DIAS', 'ALISON', '2016-12-16 07:56:52', '(11) 95124-2750', '(11) 94037-8472', '(11) 94037-8472', 'COPO PITOCO 5X10', 'CARLOS', 'completed', 'R', 3, 4, 4, 2),
(41, 'A VISTA', 'Jose Carlos', '2016-12-21 08:41:06', '(17) 3363-5666', '(11) 4676-6551', '(11) 3799-3131', 'AGUARDO DEPOSITO EM CONTA BRADESCO', 'CARLOS', 'completed', 'D', 24, 4, 18, 2),
(42, 'A VISTA', 'JosÃ© Carlos', '2017-01-23 11:01:50', '(17) 3363-5666', '(11) 4676-6551', '(11) 3799-3131', 'DEPOSITO EM CONTA (BRADESCO)', 'CARLOS', 'completed', 'D', 24, 4, 18, 2),
(43, '30 DIAS', 'AMILTON', '2017-02-03 08:17:48', '(31) 2103-3000', '(11) 94037-8472', '(11) 2207-1707', 'PEDIDO URGENTE', 'SR. CARLOS', 'completed', 'D', 7, 4, 17, 2),
(44, '30/45 DIAS', 'ELIENE', '2017-02-23 08:09:04', '(11) 95124-2750', '(11) 94037-8472', '(11) 94037-8472', 'URGENTE', 'CARLOS', 'completed', 'R', 3, 4, 4, 2),
(45, '30 DIAS', 'AMILTON', '2017-02-23 14:37:25', '(31) 2103-3000', '(11) 94037-8472', '(11) 2207-1707', 'URGENTE', 'CARLOS', 'completed', 'D', 7, 4, 17, 2),
(46, 'A VISTA', 'JOSE CARLOS', '2017-04-24 16:40:07', '(17) 2136-5666', '(11) 4676-6551', '(11) 3799-3131', 'URGENTE', 'SR. CARLOS', 'completed', 'D', 10, 4, 18, 2),
(47, '30/45 DIAS', 'ELIENE', '2017-04-26 12:46:16', '(11) 95124-2750', '(11) 94037-8472', '(11) 4676-6551', 'ENTREGA PREVISTA PARA 04/05/2017', 'CARLOS', 'completed', 'R', 3, 4, 4, 2),
(48, '30 dias', 'Amilton', '2017-05-02 14:56:31', '(31) 2103-3000', '(11) 94037-8472', '(11) 2119-6060', 'Novo transporte do cliente', 'Sr. Carlos', 'completed', 'D', 7, 4, 35, 2),
(49, 'A vista', 'JosÃ© Carlos', '2017-05-10 10:33:19', '(17) 3363-5666', '(11) 94037-8472', '(11) 3799-3131', 'PEDIDO DEPOSITO EM CONTA (BRADESCO)', 'SR. CARLOS', 'completed', 'D', 24, 4, 18, 2),
(50, 'A VISTA', 'MARCO KITCH', '2017-05-12 16:07:19', '4936410014', '(11) 94037-8472', '4936410014', 'TROCA /', 'CARLOS', 'completed', 'D', 36, 4, 36, 2),
(51, '30 dias', 'Amilton', '2017-05-23 15:43:35', '(31) 2103-3000', '(11) 94037-8472', '(11) 2119-6060', 'AUMENTO DE TABELA EM MARCO DE 2017 - ATUALIZADO  PARA ESTE MES DE MAIO DE  2017 - AUTORIZACAO DO SR. CARLOS', 'SR. CARLOS', 'completed', 'D', 7, 4, 35, 2),
(52, 'a vista', 'undefined', '2017-06-05 11:56:11', '(11) 94037-8472', '(11) 94037-8472', '(11) 94037-8472', 'PEDIDO PELA INTERNET JOSE LUIZ BARBOSA', 'Carlos', 'pending', 'D', 4, 4, 4, 2),
(53, '50', 'undefined', '2017-06-05 16:32:05', '(62) 3575-7139', '(11) 95124-2750', 'undefined', 'undefined', 'undefined', 'pending', 'R', 16, 3, 19, 1),
(54, '30 dias', 'Amilton', '2017-06-20 18:50:52', '(31) 2103-3000', '(11) 4676-6551', '(11) 2119-6060', 'urgente', 'Carlos', 'completed', 'D', 7, 4, 35, 2),
(55, '30/45 DIAS', 'Eliene', '2017-06-23 11:28:51', '(11) 95124-2750', '(11) 94037-8472', '(11) 94037-8472', 'COPO PITOCO', 'CARLOS', 'completed', 'R', 3, 4, 4, 2);

-- --------------------------------------------------------

--
-- Estrutura para tabela `State`
--

CREATE TABLE IF NOT EXISTS `State` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `abbreviation` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=28 ;

--
-- Fazendo dump de dados para tabela `State`
--

INSERT INTO `State` (`id`, `abbreviation`, `name`) VALUES
(1, 'SP', 'Sao Paulo'),
(2, 'MG', 'Minas Gerais'),
(3, 'RJ', 'Rio de Janeiro'),
(4, 'ES', 'Espirito Santo'),
(5, 'AC', 'Acre'),
(6, 'AL', 'Alagoas'),
(7, 'AP', 'Amap'),
(8, 'AM', 'Amazonas'),
(9, 'BA', 'Bahia'),
(10, 'CE', 'Cear'),
(11, 'DF', 'Distrito Federal'),
(12, 'MA', 'Maranho'),
(13, 'MT', 'Mato Grosso'),
(14, 'MT', 'Mato Grosso do Sul'),
(15, 'PA', 'Par'),
(16, 'PB', 'Paraba'),
(17, 'PR', 'Paran'),
(18, 'PE', 'Pernambuco'),
(19, 'PI', 'Piau'),
(20, 'RN', 'Rio Grande do Norte'),
(21, 'RS', 'Rio Grande do Sul'),
(22, 'RO', 'Rondnia'),
(23, 'RR', 'Roraima'),
(24, 'SC', 'Santa Catarina'),
(25, 'SE', 'Sergipe'),
(26, 'TO', 'Tocantins'),
(27, 'GO', 'Goias');

-- --------------------------------------------------------

--
-- Estrutura para tabela `Telephone`
--

CREATE TABLE IF NOT EXISTS `Telephone` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL,
  `contactType` varchar(255) DEFAULT NULL,
  `number` varchar(255) DEFAULT NULL,
  `people_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_nhoocw95tom8y49hjhwmpxmn0` (`people_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=30 ;

--
-- Fazendo dump de dados para tabela `Telephone`
--

INSERT INTO `Telephone` (`id`, `active`, `contactType`, `number`, `people_id`) VALUES
(1, b'1', 'COMERCIAL', '(11) 4676-6551', 1),
(2, b'1', 'CELULAR', '(11) 94037-8472', 1),
(4, b'0', 'COMERCIAL', '(31) 2103-3000', 3),
(5, b'0', 'COMERCIAL', '(31) 2103-3000', 4),
(6, b'1', 'COMERCIAL', '(31) 2103-3000', 5),
(7, b'0', 'COMERCIAL', '1733635666', 6),
(9, b'1', 'CELULAR', '(11) 95124-2750', 2),
(10, b'1', 'COMERCIAL', '(17) 2136-5666', 8),
(11, b'1', 'COMERCIAL', '(85) 3275-7643', 9),
(12, b'0', 'COMERCIAL', '(62) 3575-7139', 10),
(13, b'1', 'COMERCIAL', '(62) 3575-7139', 11),
(14, b'0', 'COMERCIAL', '(17) 3363-5666', 7),
(15, b'1', 'COMERCIAL', '(11) 2207-1707', 12),
(16, b'1', 'COMERCIAL', '(11) 3799-3131', 13),
(17, b'1', 'COMERCIAL', '(11) 2193-4510', 14),
(18, b'1', 'COMERCIAL', '(11) 2085-5270', 15),
(19, b'1', 'COMERCIAL', '(81) 3533-6761', 16),
(20, b'1', 'COMERCIAL', '(11) 2954-4062', 17),
(21, b'0', 'COMERCIAL', '(17) 3363-5666', 18),
(22, b'1', 'COMERCIAL', '(17) 3363-5666', 19),
(23, b'0', 'residencial', '11.46766551', 20),
(24, b'0', 'COMERCIAL', '1124121459', 21),
(25, b'1', 'COMERCIAL', '1124121459', 22),
(26, b'0', 'COMERCIAL', '(11) 2119-6060', 23),
(27, b'0', 'COMERCIAL', '(11) 2119-6060', 24),
(28, b'1', 'COMERCIAL', '(11) 2119-6060', 25),
(29, b'1', 'COMERCIAL', '4936410014', 26);

-- --------------------------------------------------------

--
-- Estrutura para tabela `User`
--

CREATE TABLE IF NOT EXISTS `User` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL,
  `cnpj` varchar(255) DEFAULT NULL,
  `createdDate` datetime NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `login` varchar(10) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_e6gkqunxajvyxl5uctpl2vl2p` (`email`),
  UNIQUE KEY `UK_587tdsv8u5cvheyo9i261xhry` (`login`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Fazendo dump de dados para tabela `User`
--

INSERT INTO `User` (`id`, `active`, `cnpj`, `createdDate`, `email`, `login`, `name`, `password`) VALUES
(1, b'1', NULL, '2016-03-21 12:13:26', 'admin@admin.com', 'admin', 'Admin', 'admin@2016'),
(2, b'1', '15180657000155', '2016-03-21 12:13:26', 'carlosvendas@hotmail.com', 'carlos', 'Carlos', 'carlos@1620');

--
-- Restrições para dumps de tabelas
--

--
-- Restrições para tabelas `Address`
--
ALTER TABLE `Address`
  ADD CONSTRAINT `FK_7vw93tc74xvk2lolc2f8fc9pu` FOREIGN KEY (`state_id`) REFERENCES `State` (`id`),
  ADD CONSTRAINT `FK_hgt049robvg8uqrw0h9vygqp6` FOREIGN KEY (`people_id`) REFERENCES `People` (`id`);

--
-- Restrições para tabelas `Customer`
--
ALTER TABLE `Customer`
  ADD CONSTRAINT `FK_ncsqu0mq8fmfoi1wuh7wxs0jx` FOREIGN KEY (`id`) REFERENCES `People` (`id`);

--
-- Restrições para tabelas `OrdersProducts`
--
ALTER TABLE `OrdersProducts`
  ADD CONSTRAINT `FK_94iwqwqukbi4yp41s7njmmy64` FOREIGN KEY (`product_id`) REFERENCES `Product` (`id`),
  ADD CONSTRAINT `FK_gf53yry9uakfls7tyygeakowp` FOREIGN KEY (`purchaseOrder_id`) REFERENCES `PurchaseOrder` (`id`);

--
-- Restrições para tabelas `Product`
--
ALTER TABLE `Product`
  ADD CONSTRAINT `FK_tl2frskf9y9xrpfit4dg8sr0q` FOREIGN KEY (`productType_id`) REFERENCES `ProductType` (`id`);

--
-- Restrições para tabelas `PurchaseOrder`
--
ALTER TABLE `PurchaseOrder`
  ADD CONSTRAINT `FK_6in0wv7vnpt03nnu4afqi15jx` FOREIGN KEY (`customerAddressRecipient_id`) REFERENCES `Address` (`id`),
  ADD CONSTRAINT `FK_7vj8ynvf2xrd6hwjmo55d3v1x` FOREIGN KEY (`customerAddressShippingCompany_id`) REFERENCES `Address` (`id`),
  ADD CONSTRAINT `FK_d0tcbs1tptxjh4rpntolsc73r` FOREIGN KEY (`userCreated_id`) REFERENCES `User` (`id`),
  ADD CONSTRAINT `FK_rjhtpx6jnnkn8q0vokpgx3syk` FOREIGN KEY (`customerAddressSender_id`) REFERENCES `Address` (`id`);

--
-- Restrições para tabelas `Telephone`
--
ALTER TABLE `Telephone`
  ADD CONSTRAINT `FK_nhoocw95tom8y49hjhwmpxmn0` FOREIGN KEY (`people_id`) REFERENCES `People` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
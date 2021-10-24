-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : sam. 23 oct. 2021 à 21:01
-- Version du serveur :  5.7.31
-- Version de PHP : 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `gestion_rv_consul_ana`
--

-- --------------------------------------------------------

--
-- Structure de la table `consultation`
--

DROP TABLE IF EXISTS `consultation`;
CREATE TABLE IF NOT EXISTS `consultation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `temperature` varchar(255) NOT NULL,
  `tension` varchar(255) NOT NULL,
  `prestation_a_faire` varchar(255) NOT NULL,
  `id_medecin` int(11) NOT NULL,
  `id_ordonnance` int(11) NOT NULL,
  `id_patient` int(11) NOT NULL,
  `id_rv` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `consultation`
--

INSERT INTO `consultation` (`id`, `temperature`, `tension`, `prestation_a_faire`, `id_medecin`, `id_ordonnance`, `id_patient`, `id_rv`) VALUES
(1, '37°', '125', 'scanner complet du corps', 5, 1, 1, 1),
(2, '37.9°', '130', '', 6, 2, 3, 3);

-- --------------------------------------------------------

--
-- Structure de la table `dossier_medical`
--

DROP TABLE IF EXISTS `dossier_medical`;
CREATE TABLE IF NOT EXISTS `dossier_medical` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_consultation` int(11) DEFAULT NULL,
  `id_prestation` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `dossier_medical`
--

INSERT INTO `dossier_medical` (`id`, `id_consultation`, `id_prestation`) VALUES
(1, 1, NULL),
(2, NULL, 2);

-- --------------------------------------------------------

--
-- Structure de la table `medicament`
--

DROP TABLE IF EXISTS `medicament`;
CREATE TABLE IF NOT EXISTS `medicament` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `poslogie` varchar(255) NOT NULL,
  `id_ordonnance` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `medicament`
--

INSERT INTO `medicament` (`id`, `code`, `nom`, `poslogie`, `id_ordonnance`) VALUES
(1, 'ABC', 'paracétamol', 'à prendre après chaque repas', 1),
(2, 'DFR', 'doliprane', '2 fois par jour', 1),
(3, 'FDS', 'CA5000', '1 fois par jour avant le petit dej', 2);

-- --------------------------------------------------------

--
-- Structure de la table `ordonnance`
--

DROP TABLE IF EXISTS `ordonnance`;
CREATE TABLE IF NOT EXISTS `ordonnance` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `ordonnance`
--

INSERT INTO `ordonnance` (`id`) VALUES
(1),
(2);

-- --------------------------------------------------------

--
-- Structure de la table `prestation`
--

DROP TABLE IF EXISTS `prestation`;
CREATE TABLE IF NOT EXISTS `prestation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(255) NOT NULL,
  `id_patient` int(11) NOT NULL,
  `id_rp` int(11) NOT NULL,
  `id_rv` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `prestation`
--

INSERT INTO `prestation` (`id`, `libelle`, `id_patient`, `id_rp`, `id_rv`) VALUES
(1, 'radio', 2, 7, 2),
(2, 'analyse', 4, 8, 4);

-- --------------------------------------------------------

--
-- Structure de la table `rendez_vous`
--

DROP TABLE IF EXISTS `rendez_vous`;
CREATE TABLE IF NOT EXISTS `rendez_vous` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` datetime NOT NULL,
  `type` varchar(255) NOT NULL,
  `etat` varchar(255) NOT NULL,
  `id_patient` int(11) NOT NULL,
  `id_secretaire` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `rendez_vous`
--

INSERT INTO `rendez_vous` (`id`, `date`, `type`, `etat`, `id_patient`, `id_secretaire`) VALUES
(1, '2021-10-01 10:00:00', 'CONSULTATION', 'validé', 1, 9),
(2, '2021-09-09 16:30:00', 'PRESTATION', 'validé', 2, 10),
(3, '2021-10-08 12:00:00', 'CONSULTATION', 'validé', 3, 9),
(4, '2021-07-05 13:30:00', 'PRESTATION', 'validé', 4, 10);

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL,
  `statut` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `antecedants_medicaux` varchar(255) DEFAULT NULL,
  `id_dossier_medical` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `login`, `password`, `role`, `statut`, `code`, `nom`, `prenom`, `antecedants_medicaux`, `id_dossier_medical`) VALUES
(1, 'patient1', '123', 'ROLE_PATIENT', NULL, 'HYD', 'DIOP', 'Modou', 'hypertension', 1),
(2, 'patient2', '123', 'ROLE_PATIENT', NULL, 'ZDF', 'NDIAYE', 'Malick', 'diabete', 2),
(3, 'patient3', '123', 'ROLE_PATIENT', NULL, 'BMA', 'FALL', 'Jules', 'hepatite', 3),
(4, 'patient4', '123', 'ROLE_PATIENT', NULL, 'KJD', 'GIRAK', 'Jaque', 'diabete', 4),
(5, 'medecin1', '123', 'ROLE_MEDECIN', 'dentiste', NULL, NULL, NULL, NULL, NULL),
(6, 'medecin2', '123', 'ROLE_MEDECIN', 'GENERALISTE', NULL, NULL, NULL, NULL, NULL),
(7, 'rp1', '123', 'ROLE_PRESTATAIRE', NULL, NULL, NULL, NULL, NULL, NULL),
(8, 'rp2', '123', 'ROLE_PRESTATAIRE', NULL, NULL, NULL, NULL, NULL, NULL),
(9, 'secretaire1', '123', 'ROLE_SECRETAIRE', NULL, NULL, NULL, NULL, NULL, NULL),
(10, 'secretaire2', '123', 'ROLE_SECRETAIRE', NULL, NULL, NULL, NULL, NULL, NULL);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

CREATE TABLE `localizacao` (
  `localizacao_id` int unsigned NOT NULL AUTO_INCREMENT,
  `estado` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `cidade` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`localizacao_id`)
) ENGINE=InnoDB AUTO_INCREMENT=149 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;

CREATE TABLE `plano_internet` (
  `plano_id` int unsigned NOT NULL AUTO_INCREMENT,
  `velocidade` int unsigned NOT NULL,
  `preco` decimal(10,0) NOT NULL,
  `desconto` decimal(10,0) NOT NULL,
  PRIMARY KEY (`plano_id`)
) ENGINE=InnoDB AUTO_INCREMENT=149 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;

CREATE TABLE `cliente` (
  `cliente_id` int unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `sobrenome` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `data_de_nascimento` date NOT NULL,
  `localizacao_id` int unsigned DEFAULT NULL,
  `plano_internet_id` int unsigned DEFAULT NULL,
  PRIMARY KEY (`cliente_id`),
  KEY `localizacao_localizacao_id_foreign` (`localizacao_id`),
  KEY `plano_internet_plano_id_foreign` (`plano_internet_id`),
  CONSTRAINT `localizacao_localizacao_id_foreign` FOREIGN KEY (`localizacao_id`) REFERENCES `localizacao` (`localizacao_id`),
  CONSTRAINT `plano_internet_plano_id_foreign` FOREIGN KEY (`plano_internet_id`) REFERENCES `plano_internet` (`plano_id`)
) ENGINE=InnoDB AUTO_INCREMENT=149 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
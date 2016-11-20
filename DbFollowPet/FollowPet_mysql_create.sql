CREATE TABLE `User` (
	`_id` smallint(11) NOT NULL,
	`Nome` varchar(60),
	`Endereco` varchar(60),
	`Telefone_Residencial` varchar(13),
	`Telefone_Celular` varchar(14),
	`Email` varchar(60),
	`Senha` varchar(34),
	`nivel` smallint(1),
	`Data_Criacao` DATE,
	`Data_Inscrucao` DATE,
	`pet_id` smallint(11),
	PRIMARY KEY (`_id`)
);

CREATE TABLE `Pets` (
	`_id` smallint(11) NOT NULL,
	`nome` varchar(60),
	`data_nacimento` DATE,
	`raca` varchar(60),
	`sexo` varchar(60),
	`tamanho` varchar(60),
	`peso` varchar(60),
	`vacina_id` smallint(11) NOT NULL,
	`medicamento_id` smallint(11) NOT NULL,
	PRIMARY KEY (`_id`)
);

CREATE TABLE `Vacinas` (
	`_id` smallint(11) NOT NULL,
	`nome` varchar(60),
	`descricao` varchar(60),
	`data_primeira` DATE,
	`data_proxima` DATE,
	PRIMARY KEY (`_id`)
);

CREATE TABLE `Medicamentos` (
	`_id` smallint(11) NOT NULL,
	`nome` varchar(60),
	`descricao` varchar(60),
	`data_primeira` DATE,
	`data_proxima` DATE NOT NULL,
	PRIMARY KEY (`_id`)
);

CREATE TABLE `Banho` (
	`_id` smallint(11) NOT NULL,
	`user_id` smallint(11) NOT NULL,
	`pet_id` smallint(11) NOT NULL,
	`data_banho` DATE,
	`tipo_banho` varchar(25) NOT NULL,
	`tipo_tosa` varchar(25) NOT NULL,
	PRIMARY KEY (`_id`)
);

ALTER TABLE `User` ADD CONSTRAINT `User_fk0` FOREIGN KEY (`pet_id`) REFERENCES `Pets`(`_id`);

ALTER TABLE `Pets` ADD CONSTRAINT `Pets_fk0` FOREIGN KEY (`vacina_id`) REFERENCES `Vacinas`(`_id`);

ALTER TABLE `Pets` ADD CONSTRAINT `Pets_fk1` FOREIGN KEY (`medicamento_id`) REFERENCES `Medicamentos`(`_id`);

ALTER TABLE `Banho` ADD CONSTRAINT `Banho_fk0` FOREIGN KEY (`user_id`) REFERENCES `User`(`_id`);

ALTER TABLE `Banho` ADD CONSTRAINT `Banho_fk1` FOREIGN KEY (`pet_id`) REFERENCES `Pets`(`_id`);


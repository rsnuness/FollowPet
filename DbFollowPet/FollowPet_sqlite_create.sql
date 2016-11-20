CREATE TABLE user (
	_id integer PRIMARY KEY AUTOINCREMENT,
	nome varchar,
	endereco varchar,
	telefone_r varchar,
	telefone_c varchar,
	email varchar,
	senha varchar,
	nivel integer,
	data_criacao varchar,
	data_inscrucao varchar,
	pet_id integer
);

CREATE TABLE pet (
	_id integer PRIMARY KEY AUTOINCREMENT,
	nome varchar,
	data_nascimento varchar,
	raca varchar,
	sexo varchar,
	tamanho varchar,
	peso varchar,
	vacina_id integer,
	medicamento_id integer
);

CREATE TABLE banho (
	_id integer PRIMARY KEY AUTOINCREMENT,
	data_banho varchar,
	tipo_banho varchar,
	tipo_tosa varchar,
	user_id integer,
	pet_id integer
);

CREATE TABLE vacina (
	_id integer PRIMARY KEY AUTOINCREMENT,
	nome varchar,
	descricao text,
	data_primeira varchar,
	data_proxima varchar
);

CREATE TABLE medicamento (
	_id integer PRIMARY KEY AUTOINCREMENT,
	nome varchar,
	descricao text,
	data_primeira varchar,
	data_proxima varchar
);


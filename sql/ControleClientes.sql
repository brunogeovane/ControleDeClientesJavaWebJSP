CREATE DATABASE ControleClientes;
USE ControleClientes;

CREATE TABLE ClienteFisico (
	idCliente INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    tipoCliente INT(1) NOT NULL,
	nome VARCHAR(50) NOT NULL,
    endereco VARCHAR(50) NOT NULL,
    telefone VARCHAR(50) NOT NULL,
    cpf VARCHAR(50),
	nomeMae VARCHAR(50) ,
    nomePai VARCHAR(50)
);

CREATE TABLE ClienteJuridico (
    idCliente INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    tipoCliente INT(1) NOT NULL,
    nome VARCHAR(50) NOT NULL,
    endereco VARCHAR(50) NOT NULL,
    telefone VARCHAR(50) NOT NULL,
    cnpj VARCHAR(50),
    nomeFantasia VARCHAR(50)
);

CREATE TABLE Conta (
	idConta INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	tipoConta int(1),
	numero INT NOT NULL,
	saldo DOUBLE,
    	situacao BOOLEAN NOT NULL,
    	IdCliente int,
    	tipoCliente int(1)
);

CREATE TABLE Seguro (
    idSeguro INT PRIMARY KEY NOT NULL,
    numero INT NOT NULL,
    tipoConta int(1),
    valor DOUBLE,
    situacao BOOLEAN NOT NULL,
    IdCliente INT,
    tipoCliente int(1)
);


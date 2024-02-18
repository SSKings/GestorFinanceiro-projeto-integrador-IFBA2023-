CREATE DATABASE db;

USE db;

CREATE TABLE usuario (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    email VARCHAR(35) UNIQUE NOT NULL,
    login VARCHAR(20) NOT NULL,
    senha VARCHAR(100) NOT NULL,
    data_criacao DATE NOT NULL
);

CREATE TABLE banco (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(30) NOT NULL,
    codigo INT UNIQUE NOT NULL
);

INSERT INTO banco (nome, codigo) VALUES ('BB', 001);
INSERT INTO banco (nome, codigo) VALUES ('BRADESCO', 002);
INSERT INTO banco (nome, codigo) VALUES ('CAIXA', 003);
INSERT INTO banco (nome, codigo) VALUES ('DIGIO', 004);
INSERT INTO banco (nome, codigo) VALUES ('ITAU', 005);
INSERT INTO banco (nome, codigo) VALUES ('INTER', 006);
INSERT INTO banco (nome, codigo) VALUES ('PAN', 007);
INSERT INTO banco (nome, codigo) VALUES ('NEXT', 008);
INSERT INTO banco (nome, codigo) VALUES ('NEON', 009);
INSERT INTO banco (nome, codigo) VALUES ('NUBANK', 010);
INSERT INTO banco (nome, codigo) VALUES ('PICPAY', 011);
INSERT INTO banco (nome, codigo) VALUES ('SANTANDER', 012);
INSERT INTO banco (nome, codigo) VALUES ('WILL', 013);

CREATE TABLE cartao_credito (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    numero BIGINT UNIQUE NOT NULL,
    usuario_id INT NOT NULL,
    banco_id INT NOT NULL,
    vencimento DATE NOT NULL,
    limite DECIMAL(10, 2) NOT NULL,
    limite_disponivel DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES usuario(id) ON DELETE CASCADE,
    FOREIGN KEY (banco_id) REFERENCES banco(id)
);

CREATE TABLE agencia (
    id INT PRIMARY KEY AUTO_INCREMENT,
    codigo INT NOT NULL,
    banco_id INT NOT NULL,
    FOREIGN KEY (banco_id) REFERENCES banco(id)
);

CREATE TABLE conta (
    id INT PRIMARY KEY AUTO_INCREMENT,
    numero VARCHAR(20) UNIQUE NOT NULL,
    saldo DECIMAL(10, 2) NOT NULL,
    usuario_id INT NOT NULL,
    agencia_id INT NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES usuario(id) ON DELETE CASCADE,
    FOREIGN KEY (agencia_id) REFERENCES agencia(id)
);

CREATE TABLE tipo_lancamento (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(20) NOT NULL
);

INSERT INTO tipo_lancamento (nome) VALUES ('RECEITA');
INSERT INTO tipo_lancamento (nome) VALUES ('DESPESA');

CREATE TABLE fonte (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(20) NOT NULL
);

INSERT INTO fonte (nome) VALUES ('CARTAO_DE_CREDITO');
INSERT INTO fonte (nome) VALUES ('CONTA_BANCARIA');

CREATE TABLE lancamento (
    id INT PRIMARY KEY AUTO_INCREMENT,
    valor DECIMAL NOT NULL,
    tipo_id INT NOT NULL,
    usuario_id INT NOT NULL,
    fonte_id INT NOT NULL,
    cartao_conta_id INT NOT NULL,
    data_lancamento DATE NOT NULL,
    FOREIGN KEY (tipo_id) REFERENCES tipo_lancamento(id),
    FOREIGN KEY (usuario_id) REFERENCES usuario(id) ON DELETE CASCADE,
    FOREIGN KEY (fonte_id) REFERENCES fonte(id)
);

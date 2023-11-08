create database lumieredb;

use lumieredb;

/* Modelo_Fisico_Lumiere: */

CREATE TABLE Icone_Residencia (
	cd_icone INT PRIMARY KEY IDENTITY(1, 1),
	url_icone varchar(255) not null
);

CREATE TABLE Residencia (
    id INT PRIMARY KEY IDENTITY(1, 1),
    registro_residencia VARCHAR(20),
    nome_residencia VARCHAR(60),
    cep_residencia CHAR(8),
	fk_Icone_Residencia_cd_icone INT,
    fk_Estado_cd_estado INT,
    fk_Usuario_cd_usuario INT
	FOREIGN KEY (fk_Icone_Residencia_cd_icone) REFERENCES Icone_Residencia(cd_icone)
); 

CREATE TABLE Dispositivo (
    cd_dispositivo INT PRIMARY KEY IDENTITY(1, 1),
    KWh_dispositivo FLOAT,
    fk_tipo_dispositivo_tipo_dispositivo_PK VARCHAR,
    nome_dispositivo VARCHAR(60),
    fk_Residencia_cd_residencia INT
);

CREATE TABLE Estado (
    cd_estado INT PRIMARY KEY IDENTITY(1, 1),
    nome_estado VARCHAR(40),
    UF_estado VARCHAR(2),
    preco_KWH FLOAT
);

CREATE TABLE Consumo (
    cd_consumo INT PRIMARY KEY IDENTITY(1, 1),
    preco_consumo FLOAT,
    data_consumo DATE,
    tempo_de_consumo_diario INT,
    fk_Dispositivo_cd_dispositivo INT
);

CREATE TABLE Usuario (
    cd_usuario INT PRIMARY KEY IDENTITY(1, 1),
    nome_usuario VARCHAR(60),
    email_usuario VARCHAR(60),
    senha_usuario VARCHAR(255),
    data_de_cadastro DATE
);

CREATE TABLE tipo_dispositivo (
    tipo_dispositivo_PK VARCHAR NOT NULL PRIMARY KEY,
    tipo_dispositivo VARCHAR
);
 
ALTER TABLE Residencia ADD CONSTRAINT FK_Residencia_2
    FOREIGN KEY (fk_Estado_cd_estado)
    REFERENCES Estado (cd_estado)
    ON DELETE CASCADE;
 
ALTER TABLE Residencia ADD CONSTRAINT FK_Residencia_3
    FOREIGN KEY (fk_Usuario_cd_usuario)
    REFERENCES Usuario (cd_usuario)
    ON DELETE SET NULL;
 
ALTER TABLE Dispositivo ADD CONSTRAINT FK_Dispositivo_2
    FOREIGN KEY (fk_tipo_dispositivo_tipo_dispositivo_PK)
    REFERENCES tipo_dispositivo (tipo_dispositivo_PK)
    ON DELETE NO ACTION;
 
ALTER TABLE Dispositivo ADD CONSTRAINT FK_Dispositivo_3
    FOREIGN KEY (fk_Residencia_cd_residencia)
    REFERENCES Residencia (id)
    ON DELETE CASCADE;
 
ALTER TABLE Consumo ADD CONSTRAINT FK_Consumo_2
    FOREIGN KEY (fk_Dispositivo_cd_dispositivo)
    REFERENCES Dispositivo (cd_dispositivo)
    ON DELETE CASCADE;
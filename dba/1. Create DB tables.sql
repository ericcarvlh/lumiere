create database lumieredb;

use lumieredb;

/* Modelo_Fisico_Lumiere: */

CREATE TABLE Icone_Residencia (
	cd_icone INT PRIMARY KEY IDENTITY(1, 1),
	url_icone varchar(255) not null
);

CREATE TABLE Residencia (
    cd_residencia INT PRIMARY KEY IDENTITY(1, 1),
    registro_residencia VARCHAR(20),
    nome_residencia VARCHAR(60),
    cep_residencia CHAR(8),
	fk_Icone_Residencia_cd_icone INT,
    fk_Estado_cd_estado INT,
    fk_Usuario_cd_usuario INT,
	FOREIGN KEY (fk_Icone_Residencia_cd_icone) REFERENCES Icone_Residencia(cd_icone)
); 

CREATE TABLE tipo_dispositivo (
    cd_tipo_dispositivo INT PRIMARY KEY IDENTITY(1, 1),
    tipo_dispositivo VARCHAR(60)
);

CREATE TABLE Dispositivo (
    cd_dispositivo INT PRIMARY KEY IDENTITY(1, 1),
    watts_dispositivo DECIMAL(8, 2),
    nome_dispositivo VARCHAR(60),
	tempo_de_uso_diario INT,
    fk_Residencia_cd_residencia INT,
	fk_tipo_dispositivo_cd_tipo_dispositivo INT,
	FOREIGN KEY (fk_tipo_dispositivo_cd_tipo_dispositivo) REFERENCES tipo_dispositivo (cd_tipo_dispositivo),
	FOREIGN KEY (fk_Residencia_cd_residencia) REFERENCES Residencia (cd_residencia)
);

CREATE TABLE Estado (
    cd_estado INT PRIMARY KEY IDENTITY(1, 1),
    nome_estado VARCHAR(40),
    UF_estado VARCHAR(2),
    preco_KWH DECIMAL(5, 3)
);

CREATE TABLE Consumo (
    cd_consumo INT PRIMARY KEY IDENTITY(1, 1),
    preco_consumo DECIMAL(10, 2),
	kwh_consumo DECIMAL(8, 2),
    data_consumo DATE,
    fk_Dispositivo_cd_dispositivo INT
);

CREATE TABLE Usuario (
    cd_usuario INT PRIMARY KEY IDENTITY(1, 1),
    nome_usuario VARCHAR(60),
    email_usuario VARCHAR(60),
    senha_usuario VARCHAR(255),
    data_de_cadastro DATE
);
 
ALTER TABLE Residencia ADD CONSTRAINT FK_Residencia_2
    FOREIGN KEY (fk_Estado_cd_estado)
    REFERENCES Estado (cd_estado)
    ON DELETE CASCADE;
 
ALTER TABLE Residencia ADD CONSTRAINT FK_Residencia_3
    FOREIGN KEY (fk_Usuario_cd_usuario)
    REFERENCES Usuario (cd_usuario)
    ON DELETE SET NULL;
 
ALTER TABLE Consumo ADD CONSTRAINT FK_Consumo_2
    FOREIGN KEY (fk_Dispositivo_cd_dispositivo)
    REFERENCES Dispositivo (cd_dispositivo)
    ON DELETE CASCADE;
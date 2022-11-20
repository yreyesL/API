
--CREATE DATABASE YDRL
USE YDRL

CREATE TABLE ESTUDIANTE (

[id] [int] IDENTITY(1,1) NOT NULL,
[nombres] [varchar](30) NOT NULL,
[apellidos] [varchar] (30) NOT NULL,
[cedula] [varchar] (16) NOT NULL,
[activo] [bit] NOT NULL,
PRIMARY KEY ([id])
)

CREATE TABLE CURSO (
[id] [int] IDENTITY(1,1) NOT NULL,
[descripcion] [varchar](80) NOT NULL,
[matriculados] [int] NOT NULL,
[vacantes] [int] NOT NULL,
PRIMARY KEY ([id])
)


CREATE TABLE MATRICULA (
[idest] [int] NOT NULL,
[curid] [int] NOT NULL,
[precio] [numeric](10, 2) NOT NULL,
[fecha] [datetime] NOT NULL,
CONSTRAINT pk_matricula PRIMARY KEY ([idest], [curid]),

CONSTRAINT fk_idEst FOREIGN KEY([idest]) REFERENCES ESTUDIANTE ([id]),
CONSTRAINT fk_curId FOREIGN KEY([curId]) REFERENCES CURSO ([id])
);

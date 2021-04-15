DROP DATABASE IF EXISTS gerenciador_de_cursos;

CREATE DATABASE IF NOT EXISTS gerenciador_de_cursos;

USE gerenciador_de_cursos;

CREATE TABLE IF NOT EXISTS curso (
id SERIAL NOT NULL,
nome VARCHAR(255) NOT NULL,
duracao_horas INT NOT NULL,
data_criacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP);


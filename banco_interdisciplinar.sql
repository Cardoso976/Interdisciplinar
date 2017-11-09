CREATE DATABASE fatec_shop;

USE fatec_shop;

CREATE TABLE clientes(
	codigo int PRIMARY KEY AUTO_INCREMENT NOT NULL,
	nome varchar(100) NOT NULL,
	endereco varchar(100),
	cidade varchar(30),
	estado char(2),
	email varchar(30),
	senha varchar(15)
);

CREATE TABLE produtos(
	codigo int PRIMARY KEY AUTO_INCREMENT NOT NULL,
	descricao varchar(100),
	preco decimal(7,2),
	quantidade_estoque int	
);

CREATE TABLE pedidos(
	codigo int PRIMARY KEY AUTO_INCREMENT NOT NULL,
	codigo_do_cliente int,
	codigo_do_produto int, 
	CONSTRAINT FOREIGN KEY FK_clientes(codigo_do_cliente)
		REFERENCES clientes(codigo),
	CONSTRAINT FOREIGN KEY FK_produtos(codigo_do_produto)
		REFERENCES produtos(codigo)
);

INSERT INTO clientes(nome,endereco,cidade,estado,email,senha) VALUES ('Rodrigo','Rua Maceió 407','Garça','SP','rodrigo_cardoso97@hotmail.com','1234');
INSERT INTO clientes(nome,endereco,cidade,estado,email,senha) VALUES ('Valmir','Rua Maceió 407','Garça','SP','cardosovalmir@hotmail.com','1234');
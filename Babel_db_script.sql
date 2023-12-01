#DROP DATABASE IF EXISTS babel_db;

CREATE DATABASE IF NOT EXISTS babel_db;
USE babel_db;

CREATE TABLE IF NOT EXISTS libro (
	id INT UNSIGNED AUTO_INCREMENT NOT NULL PRIMARY KEY,
    titulo VARCHAR(400)
);    

CREATE TABLE IF NOT EXISTS sala (
	id INT UNSIGNED AUTO_INCREMENT NOT NULL PRIMARY KEY,
    nombre_sala VARCHAR(400)
);  

CREATE TABLE IF NOT EXISTS librero (
	id INT UNSIGNED AUTO_INCREMENT NOT NULL PRIMARY KEY,
    nombre_librero VARCHAR(10),
    id_sala INT UNSIGNED,
    CONSTRAINT fk_sala FOREIGN KEY (id_sala)
    REFERENCES sala(id)
    ON UPDATE CASCADE
);  

CREATE TABLE IF NOT EXISTS estante (
	id INT UNSIGNED AUTO_INCREMENT NOT NULL PRIMARY KEY,
    numero_estante INT,
    id_librero INT UNSIGNED,
    CONSTRAINT fk_librero FOREIGN KEY (id_librero)
    REFERENCES librero(id)
    ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS volumen_libro (
	id INT UNSIGNED AUTO_INCREMENT NOT NULL PRIMARY KEY,
    id_libro INT UNSIGNED,
    numero_volumen INT,
    id_estante INT UNSIGNED,
    posicion VARCHAR(20),
    estado BOOLEAN,
    CONSTRAINT fk_libro FOREIGN KEY (id_libro)
    REFERENCES libro(id)
    ON UPDATE CASCADE,
    
    CONSTRAINT fk_estante FOREIGN KEY (id_estante)
    REFERENCES estante(id)
    ON UPDATE CASCADE
);

INSERT INTO libro (titulo) VALUES
    ('1984'),
    ('To Kill a Mockingbird'),
    ('The Great Gatsby'),
    ('One Hundred Years of Solitude'),
    ('Brave New World'),
    ('The Catcher in the Rye'),
    ('The Lord of the Rings'),
    ('The Hobbit'),
    ('The Da Vinci Code'),
    ('Harry Potter');
    
INSERT INTO sala (nombre_sala) VALUES
    ('Ciencia Ficcion'),
    ('Misterio'),
    ('Comedia'),
    ('Terror'),
    ('Distopia'),
    ('Fantasia');
    
INSERT INTO librero (nombre_librero, id_sala) VALUES
	('A',1),
    ('B',1),
    ('C',2),
    ('D',2),
    ('E',3),
    ('F',3),
    ('G',4),
    ('H',4),
    ('I',5),
    ('J',5),
    ('K',6),
    ('L',6);
INSERT INTO estante (numero_estante, id_librero) VALUES
	(1,1),
    (2,1),
    (1,2),
    (2,2),
    (1,3),
    (2,3),
    (1,4),
    (2,4),
 	(1,5),
    (2,5),
    (1,6),
    (2,6),
    (1,7),
    (2,7),
    (1,8),
    (2,8),   
    (1,9),
    (2,9),
    (1,10),
    (2,10),
	(1,11),
    (2,11),
    (1,12),
    (2,12);  

INSERT INTO volumen_libro (id_libro, numero_volumen, id_estante, posicion,estado) VALUES  
    (1,1,17,1,true),
    (2,1,1,1,true),
    (3,1,1,2,true),
    (4,1,2,1,true),
    (5,1,17,2,true),
    (6,1,2,2,true),
    (7,2,21,1,true),
    (8,1,21,1,true),
    (9,1,5,1,true),
    (10,4,22,1,true);
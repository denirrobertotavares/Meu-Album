/* -----------------------------------------------------------------------------------
	PARA COMPILAÇÃO DESTE SCRIPT FOI UTILIZADO O ADMINISTRADOR de SGBD PGADMIN 4
*/ -----------------------------------------------------------------------------------


-- 1º CRIAR A BASE DE DADOS
/* --------------------------------------------------------------
	DESCRIPTION CODE: ON CREATE DATA BASE OF SYSTEM
*/ --------------------------------------------------------------
CREATE DATABASE db01_col_albuns
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Portuguese_Brazil.1252'
    LC_CTYPE = 'Portuguese_Brazil.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

-- 2º ATUALIZE A BASE DE DADOS DO SGBD E EXECUTE TODO O SCRIPT ABAIXO NA BASE DE DADOS db01_col_albuns
/* --------------------------------------------------------------
	DESCRIPTION CODE: ON ATRIB COMMENT FOR DATA BASE
*/ --------------------------------------------------------------
COMMENT ON DATABASE db01_col_albuns
    IS 'Base de Dados que rege/controla e armazena os dados responsáveis pela coleção de álbuns.';


/* --------------------------------------------------------------
	DELETE SCHEMAS NOT USED
*/ --------------------------------------------------------------
DROP SCHEMA public;

/* --------------------------------------------------------------
	DESCRIPTION CODE: ON CREATE SCHEMAS FOR DATA BASE
*/ --------------------------------------------------------------
CREATE SCHEMA sc01_col_musica
    AUTHORIZATION postgres;

COMMENT ON SCHEMA sc01_col_musica
    IS 'Esquema de banco de dados organizacional/relacional que permite o armazenamento/cadastro das coleções de álbuns musicais.';

/* --------------------------------------------------------------
	DESCRIPTION CODE: ON CREATE TABLES FOR SCHEMAS
*/ --------------------------------------------------------------
/* --------------------------------------------------------------
	DESCRIPTION CODE: TABLES ON SCHEMA sc01_col_musica
*/ --------------------------------------------------------------
CREATE TABLE sc01_col_musica.tb01_artistas
(
    cod_artista bigserial NOT NULL,
    descricao character varying(255) NOT NULL,
    CONSTRAINT pk_tb01_artistas_cod_artista PRIMARY KEY (cod_artista)
)
WITH (
    OIDS = FALSE
);

ALTER TABLE sc01_col_musica.tb01_artistas
    OWNER to postgres;
COMMENT ON TABLE sc01_col_musica.tb01_artistas
    IS 'Entidade que armazena as informações dos artistas/bandas da coleção de álbuns.';

CREATE TABLE sc01_col_musica.tb02_albuns
(
    cod_album bigserial NOT NULL,
    descricao character varying(255) NOT NULL,
    fk_cod_artista smallint NOT NULL,
    CONSTRAINT pk_tb02_albuns_cod_album PRIMARY KEY (cod_album),
	CONSTRAINT fk_tb02_albuns_cod_artista FOREIGN KEY (fk_cod_artista)
		REFERENCES sc01_col_musica.tb01_artistas (cod_artista) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
)
WITH (
    OIDS = FALSE
);

ALTER TABLE sc01_col_musica.tb02_albuns
    OWNER to postgres;
COMMENT ON TABLE sc01_col_musica.tb02_albuns
    IS 'Entidade que armazena as informações dos álbuns dos artistas/bandas.';

/* --------------------------------------------------------------
	DESCRIPTION CODE: INITIAL LOAD
*/ --------------------------------------------------------------
INSERT INTO sc01_col_musica.tb01_artistas(descricao)
								  VALUES ('SERJ TANKIAN'),
								         ('MIKE SHINODA'),
								         ('MICHEL TELÓ'),
								         ('GUN N'' ROSES');

INSERT INTO sc01_col_musica.tb02_albuns(descricao, fk_cod_artista)
								VALUES ('HARAKIRI', 1),
									   ('BLACK BLOOMS', 1),
									   ('THE ROUGH DOG', 1),
									   ('THE RISING TIED', 2),
									   ('POST TRAUMATIC', 2),
									   ('POST TRAUMATIC EP', 2),
									   ('WHERE''D YOU GO', 2),
									   ('BEM SERTANEJO', 3),
									   ('BEM SERTANEJO - O SHOW (AO VIVO)', 3),
									   ('BEM SERTANEJO - (1ª TEMPORADA) - EP', 3),
									   ('USE YOUR ILLUSION I', 4),
									   ('USE YOUR ILLUSION II', 4),
									   ('GREATEST HITS', 4);
-- Database: 	opw 
-- System:	PostgreSQL
-- Type:	DDL
-- Version: 	2015.05.08
-- Author:	Adam Kowalewski / EclipseLink export

CREATE TABLE opw.opw_user (id  SERIAL NOT NULL, active BOOLEAN, dateCreated TIMESTAMP, email VARCHAR(64), firstname VARCHAR(64), lastname VARCHAR(64), origin VARCHAR(64), password VARCHAR(64), phone VARCHAR(32), salt VARCHAR(32), token VARCHAR(32), type VARCHAR(64), PRIMARY KEY (id));
CREATE TABLE opw.opw_wynik (id  SERIAL NOT NULL, active BOOLEAN, cardsValid SMALLINT, dateCreated TIMESTAMP, fileOriginal VARCHAR(128), k1 SMALLINT, k10 SMALLINT, k11 SMALLINT, k2 SMALLINT, k3 SMALLINT, k4 SMALLINT, k5 SMALLINT, k6 SMALLINT, k7 SMALLINT, k8 SMALLINT, k9 SMALLINT, ratedNegativ INTEGER, ratedPositiv INTEGER, status INTEGER, votersAmount SMALLINT, votersValid SMALLINT, votesInvalid SMALLINT, votesValid SMALLINT, opw_obwodowa_komisja_id INTEGER NOT NULL, opw_user_id INTEGER NOT NULL, parentId INTEGER, PRIMARY KEY (id));
CREATE TABLE opw.opw_session (id  SERIAL NOT NULL, active BOOLEAN, dateValidTo TIMESTAMP, token VARCHAR(64), opw_user_id INTEGER NOT NULL, PRIMARY KEY (id));
CREATE TABLE opw.opw_wojewodztwo (id  SERIAL NOT NULL, name VARCHAR(64), teryt VARCHAR(2), PRIMARY KEY (id));
CREATE TABLE opw.opw_obwodowa_komisja (id  SERIAL NOT NULL, address VARCHAR(256), allowedToVote INTEGER, name VARCHAR(256), obwodNr INTEGER, pkwId VARCHAR(64), status INTEGER, type VARCHAR(4), opw_wojewodztwo_id INTEGER NOT NULL, PRIMARY KEY (id));
CREATE TABLE opw.opw_okregowa_komisja (id  SERIAL NOT NULL, address VARCHAR(128), miasta VARCHAR(128), name VARCHAR(128), pkwId INTEGER, powiaty VARCHAR(128), opw_wojewodztwo_id INTEGER NOT NULL, PRIMARY KEY (id));
CREATE TABLE opw.opw_kandydat (id  SERIAL NOT NULL, firstname VARCHAR(128), lastname VARCHAR(64), pkwId INTEGER, PRIMARY KEY (id));
CREATE TABLE opw.opw_config (id  SERIAL NOT NULL, cfg_key VARCHAR(64), cfg_value VARCHAR(256), PRIMARY KEY (id));
CREATE TABLE opw_user_has_opw_obwodowa_komisja (opw_user_id INTEGER NOT NULL, opw_obwodowa_komisja_id INTEGER NOT NULL, PRIMARY KEY (opw_user_id, opw_obwodowa_komisja_id));
ALTER TABLE opw.opw_user ADD CONSTRAINT UNQ_opw_user_0 UNIQUE (email);
ALTER TABLE opw.opw_obwodowa_komisja ADD CONSTRAINT UNQ_opw_obwodowa_komisja_0 UNIQUE (pkwId);
ALTER TABLE opw.opw_okregowa_komisja ADD CONSTRAINT UNQ_opw_okregowa_komisja_0 UNIQUE (pkwId);
ALTER TABLE opw.opw_wynik ADD CONSTRAINT FK_opw_wynik_parentId FOREIGN KEY (parentId) REFERENCES opw.opw_wynik (id);
ALTER TABLE opw.opw_wynik ADD CONSTRAINT FK_opw_wynik_opw_user_id FOREIGN KEY (opw_user_id) REFERENCES opw.opw_user (id);
ALTER TABLE opw.opw_wynik ADD CONSTRAINT FK_opw_wynik_opw_obwodowa_komisja_id FOREIGN KEY (opw_obwodowa_komisja_id) REFERENCES opw.opw_obwodowa_komisja (id);
ALTER TABLE opw.opw_session ADD CONSTRAINT FK_opw_session_opw_user_id FOREIGN KEY (opw_user_id) REFERENCES opw.opw_user (id);
ALTER TABLE opw.opw_obwodowa_komisja ADD CONSTRAINT FK_opw_obwodowa_komisja_opw_wojewodztwo_id FOREIGN KEY (opw_wojewodztwo_id) REFERENCES opw.opw_wojewodztwo (id);
ALTER TABLE opw.opw_okregowa_komisja ADD CONSTRAINT FK_opw_okregowa_komisja_opw_wojewodztwo_id FOREIGN KEY (opw_wojewodztwo_id) REFERENCES opw.opw_wojewodztwo (id);
ALTER TABLE opw_user_has_opw_obwodowa_komisja ADD CONSTRAINT FK_opw_user_has_opw_obwodowa_komisja_opw_obwodowa_komisja_id FOREIGN KEY (opw_obwodowa_komisja_id) REFERENCES opw.opw_obwodowa_komisja (id);
ALTER TABLE opw_user_has_opw_obwodowa_komisja ADD CONSTRAINT FK_opw_user_has_opw_obwodowa_komisja_opw_user_id FOREIGN KEY (opw_user_id) REFERENCES opw.opw_user (id);

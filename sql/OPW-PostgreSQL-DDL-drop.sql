-- Database: 	opw 
-- System:	PostgreSQL
-- Type:	DDL
-- Version: 	2015.05.08
-- Author:	Adam Kowalewski / EclipseLink export

ALTER TABLE opw.opw_wynik DROP CONSTRAINT FK_opw_wynik_parentId
ALTER TABLE opw.opw_wynik DROP CONSTRAINT FK_opw_wynik_opw_user_id
ALTER TABLE opw.opw_wynik DROP CONSTRAINT FK_opw_wynik_opw_obwodowa_komisja_id
ALTER TABLE opw.opw_obwodowa_komisja DROP CONSTRAINT FK_opw_obwodowa_komisja_opw_wojewodztwo_id
ALTER TABLE opw.opw_obwodowa_komisja DROP CONSTRAINT UNQ_opw_obwodowa_komisja_0
ALTER TABLE opw.opw_user DROP CONSTRAINT UNQ_opw_user_0
ALTER TABLE opw.opw_session DROP CONSTRAINT FK_opw_session_opw_user_id
ALTER TABLE opw.opw_link DROP CONSTRAINT FK_opw_link_opw_wynik_id
ALTER TABLE opw.opw_okregowa_komisja DROP CONSTRAINT FK_opw_okregowa_komisja_opw_wojewodztwo_id
ALTER TABLE opw.opw_okregowa_komisja DROP CONSTRAINT UNQ_opw_okregowa_komisja_0
ALTER TABLE opw_group_has_opw_permission DROP CONSTRAINT FK_opw_group_has_opw_permission_opw_group_id
ALTER TABLE opw_group_has_opw_permission DROP CONSTRAINT FK_opw_group_has_opw_permission_opw_permission_id
ALTER TABLE opw_user_has_opw_obwodowa_komisja DROP CONSTRAINT FK_opw_user_has_opw_obwodowa_komisja_opw_obwodowa_komisja_id
ALTER TABLE opw_user_has_opw_obwodowa_komisja DROP CONSTRAINT FK_opw_user_has_opw_obwodowa_komisja_opw_user_id
ALTER TABLE opw_user_has_opw_group DROP CONSTRAINT FK_opw_user_has_opw_group_opw_user_id
ALTER TABLE opw_user_has_opw_group DROP CONSTRAINT FK_opw_user_has_opw_group_opw_group_id
DROP TABLE opw.opw_permission CASCADE
DROP TABLE opw.opw_wynik CASCADE
DROP TABLE opw.opw_wojewodztwo CASCADE
DROP TABLE opw.opw_obwodowa_komisja CASCADE
DROP TABLE opw.opw_user CASCADE
DROP TABLE opw.opw_session CASCADE
DROP TABLE opw.opw_link CASCADE
DROP TABLE opw.opw_group CASCADE
DROP TABLE opw.opw_okregowa_komisja CASCADE
DROP TABLE opw.opw_kandydat CASCADE
DROP TABLE opw.opw_config CASCADE
DROP TABLE opw_group_has_opw_permission CASCADE
DROP TABLE opw_user_has_opw_obwodowa_komisja CASCADE
DROP TABLE opw_user_has_opw_group CASCADE

INSERT INTO opw.opw_wojewodztwo (id, name, teryt) VALUES (2, 'kujawsko-pomorskie', '04');
INSERT INTO opw.opw_wojewodztwo (id, name, teryt) VALUES (1, 'dolnośląskie', '02');
INSERT INTO opw.opw_wojewodztwo (id, name, teryt) VALUES (3, 'lubelskie', '06');
INSERT INTO opw.opw_wojewodztwo (id, name, teryt) VALUES (4, 'lubuskie', '08');
INSERT INTO opw.opw_wojewodztwo (id, name, teryt) VALUES (5, 'łódzkie', '10');
INSERT INTO opw.opw_wojewodztwo (id, name, teryt) VALUES (6, 'małopolskie', '12');
INSERT INTO opw.opw_wojewodztwo (id, name, teryt) VALUES (7, 'mazowieckie', '14');
INSERT INTO opw.opw_wojewodztwo (id, name, teryt) VALUES (8, 'opolskie', '16');
INSERT INTO opw.opw_wojewodztwo (id, name, teryt) VALUES (9, 'podkarpackie', '18');
INSERT INTO opw.opw_wojewodztwo (id, name, teryt) VALUES (10, 'podlaskie', '20');
INSERT INTO opw.opw_wojewodztwo (id, name, teryt) VALUES (11, 'pomorskie', '22');
INSERT INTO opw.opw_wojewodztwo (id, name, teryt) VALUES (12, 'śląskie', '24');
INSERT INTO opw.opw_wojewodztwo (id, name, teryt) VALUES (13, 'świętokrzyskie', '26');
INSERT INTO opw.opw_wojewodztwo (id, name, teryt) VALUES (14, 'warmińsko-mazurskie', '28');
INSERT INTO opw.opw_wojewodztwo (id, name, teryt) VALUES (15, 'wielkopolskie', '30');
INSERT INTO opw.opw_wojewodztwo (id, name, teryt) VALUES (16, 'zachodniopomorskie', '32');


INSERT INTO opw.opw_user (id, firstname, lastname, email, password, type, salt, active, token, phone, origin, dateCreated) VALUES (1, 'Administrator', NULL, 'admin', 'b8a6e4b1a53a860e470cf9bcb584cb4f362a6ffd0c0ce5d88811fe645e16', 'A', 'affsmmn1bbala9kg', true, NULL, NULL, 'SQL', '2015-01-01');
INSERT INTO opw.opw_user (id, firstname, lastname, email, password, type, salt, active, token, phone, origin, dateCreated) VALUES (2, 'Adam', 'Kowalewski', 'adam', '6eba6f4114d74ed0935355d2169cd33376c0aca87de819bc9c3fb9cf3da96c', 'U', 'a12smmn1bbala9kg', true, NULL, NULL, 'SQL', '2015-01-01');
INSERT INTO opw.opw_user (id, firstname, lastname, email, password, type, salt, active, token, phone, origin, dateCreated) VALUES (3, 'Marcin', 'Marcin', 'marcin', 'fa5819cdbb4354a57ddf60bf1d4e108d81f7a6bfd84b19613348915c25e5345', 'U', 'am2smmn1bbala9kg', true, NULL, NULL, 'SQL', '2015-01-01');
INSERT INTO opw.opw_user (id, firstname, lastname, email, password, type, salt, active, token, phone, origin, dateCreated) VALUES (4, 'Przemek', 'Jodkowski', 'przemek', '96fcdfeee84a04bec18ae69c97921e7fdad13fe9a9abf556b932ced7794bd7', 'U', 'q019u1a4', true, NULL, NULL, 'SQL', '2015-01-01');
INSERT INTO opw.opw_user (id, firstname, lastname, email, password, type, salt, active, token, phone, origin, dateCreated) VALUES (5, 'Jacek', 'Placek', 'angularjs', 'c76135017216b93a1619e4b922a2dfe75ae1d647d33c0174d79e084614bf7', 'U', 'e353uotk', true, NULL, NULL, 'SQL', '2015-01-01');
INSERT INTO opw.opw_user (id, firstname, lastname, email, password, type, salt, active, token, phone, origin, dateCreated) VALUES (6, 'Diego', 'Małysz', 'openpkw', 'ba588b17ff6d3ba09bb851f549a4132fc42c5f73b66295ee8d54e79d6f2cb', 'U', 'ksp018t4', true, NULL, NULL, 'SQL', '2015-01-01');


INSERT INTO opw.opw_kandydat (id, pkwId, firstname, lastname) VALUES (1, 1, 'Janusz Ryszard', 'Korwin-Mikke');
INSERT INTO opw.opw_kandydat (id, pkwId, firstname, lastname) VALUES (2, 2, 'Bronisław Maria', 'Komorowski');
INSERT INTO opw.opw_kandydat (id, pkwId, firstname, lastname) VALUES (3, 3, 'Adam Sebastian', 'Jarubas');
INSERT INTO opw.opw_kandydat (id, pkwId, firstname, lastname) VALUES (4, 4, 'Paweł Piotr', 'Kukiz');
INSERT INTO opw.opw_kandydat (id, pkwId, firstname, lastname) VALUES (5, 5, 'Marian Janusz', 'Kowalski');
INSERT INTO opw.opw_kandydat (id, pkwId, firstname, lastname) VALUES (6, 6, 'Jacek', 'Wilk');
INSERT INTO opw.opw_kandydat (id, pkwId, firstname, lastname) VALUES (7, 7, 'Andrzej Sebastian', 'Duda');
INSERT INTO opw.opw_kandydat (id, pkwId, firstname, lastname) VALUES (8, 8, 'Janusz Marian', 'Palikot');
INSERT INTO opw.opw_kandydat (id, pkwId, firstname, lastname) VALUES (9, 9, 'Magdalena Agnieszka', 'Ogórek');
INSERT INTO opw.opw_kandydat (id, pkwId, firstname, lastname) VALUES (10, 10, 'Paweł Jan', 'Tanajno');
INSERT INTO opw.opw_kandydat (id, pkwId, firstname, lastname) VALUES (11, 11, 'Grzegorz Michał', 'Braun');


INSERT INTO opw.opw_config (id, cfg_key, cfg_value) VALUES (1, 'CLIENT_REG_ID', 'client.register.php');
INSERT INTO opw.opw_config (id, cfg_key, cfg_value) VALUES (2, 'CLIENT_REG_TOKEN', 'b516f01b18cc4144ef39d5c1b039a250fd318cdd15aff4fd746bde9ac9aacd51');
INSERT INTO opw.opw_config (id, cfg_key, cfg_value) VALUES (3, 'CLIENT_DASH_ID', 'client.dashboard.jquery');
INSERT INTO opw.opw_config (id, cfg_key, cfg_value) VALUES (4, 'CLIENT_DASH_TOKEN', 'd171794c5c1f7a50aeb8f7056ab84a4fbcd6fbd594b1999bddaefdd03efc0591');
INSERT INTO opw.opw_config (id, cfg_key, cfg_value) VALUES (5, 'EMAIL_OUTBOUND', 'true');
INSERT INTO opw.opw_config (id, cfg_key, cfg_value) VALUES (6, 'CLIENT_REGISTRATION', 'true');
INSERT INTO opw.opw_config (id, cfg_key, cfg_value) VALUES (7, 'OPW_BASE_URL', 'http://91.250.114.134:8080/opw');
INSERT INTO opw.opw_config (id, cfg_key, cfg_value) VALUES (8, 'REST_SESSION_TIMEOUT', '300');

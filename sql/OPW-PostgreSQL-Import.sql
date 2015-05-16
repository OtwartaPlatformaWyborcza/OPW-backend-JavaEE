INSERT INTO opw.opw_wojewodztwo (name, teryt) VALUES ('dolnośląskie', '02');
INSERT INTO opw.opw_wojewodztwo (name, teryt) VALUES ('kujawsko-pomorskie', '04');
INSERT INTO opw.opw_wojewodztwo (name, teryt) VALUES ('lubelskie', '06');
INSERT INTO opw.opw_wojewodztwo (name, teryt) VALUES ('lubuskie', '08');
INSERT INTO opw.opw_wojewodztwo (name, teryt) VALUES ('łódzkie', '10');
INSERT INTO opw.opw_wojewodztwo (name, teryt) VALUES ('małopolskie', '12');
INSERT INTO opw.opw_wojewodztwo (name, teryt) VALUES ('mazowieckie', '14');
INSERT INTO opw.opw_wojewodztwo (name, teryt) VALUES ('opolskie', '16');
INSERT INTO opw.opw_wojewodztwo (name, teryt) VALUES ('podkarpackie', '18');
INSERT INTO opw.opw_wojewodztwo (name, teryt) VALUES ('podlaskie', '20');
INSERT INTO opw.opw_wojewodztwo (name, teryt) VALUES ('pomorskie', '22');
INSERT INTO opw.opw_wojewodztwo (name, teryt) VALUES ('śląskie', '24');
INSERT INTO opw.opw_wojewodztwo (name, teryt) VALUES ('świętokrzyskie', '26');
INSERT INTO opw.opw_wojewodztwo (name, teryt) VALUES ('warmińsko-mazurskie', '28');
INSERT INTO opw.opw_wojewodztwo (name, teryt) VALUES ('wielkopolskie', '30');
INSERT INTO opw.opw_wojewodztwo (name, teryt) VALUES ('zachodniopomorskie', '32');


INSERT INTO opw.opw_user (firstname, lastname, email, password, type, salt, active, token, phone, origin, dateCreated) VALUES ('Administrator', NULL, 'admin', 'b8a6e4b1a53a860e470cf9bcb584cb4f362a6ffd0c0ce5d88811fe645e16', 'A', 'affsmmn1bbala9kg', true, NULL, NULL, 'SQL', '2015-01-01');
INSERT INTO opw.opw_user (firstname, lastname, email, password, type, salt, active, token, phone, origin, dateCreated) VALUES ('Adam', 'Kowalewski', 'adam', '6eba6f4114d74ed0935355d2169cd33376c0aca87de819bc9c3fb9cf3da96c', 'U', 'a12smmn1bbala9kg', true, NULL, NULL, 'SQL', '2015-01-01');
INSERT INTO opw.opw_user (firstname, lastname, email, password, type, salt, active, token, phone, origin, dateCreated) VALUES ('Marcin', 'Marcin', 'marcin', 'fa5819cdbb4354a57ddf60bf1d4e108d81f7a6bfd84b19613348915c25e5345', 'U', 'am2smmn1bbala9kg', true, NULL, NULL, 'SQL', '2015-01-01');
INSERT INTO opw.opw_user (firstname, lastname, email, password, type, salt, active, token, phone, origin, dateCreated) VALUES ('Przemek', 'Jodkowski', 'przemek', '96fcdfeee84a04bec18ae69c97921e7fdad13fe9a9abf556b932ced7794bd7', 'U', 'q019u1a4', true, NULL, NULL, 'SQL', '2015-01-01');
INSERT INTO opw.opw_user (firstname, lastname, email, password, type, salt, active, token, phone, origin, dateCreated) VALUES ('Jacek', 'Placek', 'angularjs', 'c76135017216b93a1619e4b922a2dfe75ae1d647d33c0174d79e084614bf7', 'U', 'e353uotk', true, NULL, NULL, 'SQL', '2015-01-01');
INSERT INTO opw.opw_user (firstname, lastname, email, password, type, salt, active, token, phone, origin, dateCreated) VALUES ('Diego', 'Małysz', 'openpkw', 'ba588b17ff6d3ba09bb851f549a4132fc42c5f73b66295ee8d54e79d6f2cb', 'U', 'ksp018t4', true, NULL, NULL, 'SQL', '2015-01-01');
INSERT INTO opw.opw_user (firstname, lastname, email, password, type, salt, active, token, phone, origin, dateCreated) VALUES ('Jan', 'Kowalski FMD', 'fmd', 'fe3995745ca2e83bf9d8472c5a9a3b2ac58a1889155a8ef534ae7dba26ed9e', 'U', '9ipnlffl', true, NULL, NULL, 'SQL', '2015-01-01');


INSERT INTO opw.opw_kandydat (pkwId, firstname, lastname) VALUES (1, 'Andrzej Sebastian', 'Duda');
INSERT INTO opw.opw_kandydat (pkwId, firstname, lastname) VALUES (2, 'Bronisław Maria', 'Komorowski');


INSERT INTO opw.opw_config (cfg_key, cfg_value) VALUES ('CLIENT_REG_ID', 'client.register.php');
INSERT INTO opw.opw_config (cfg_key, cfg_value) VALUES ('CLIENT_REG_TOKEN', 'b516f01b18cc4144ef39d5c1b039a250fd318cdd15aff4fd746bde9ac9aacd51');
INSERT INTO opw.opw_config (cfg_key, cfg_value) VALUES ('CLIENT_DASH_ID', 'client.dashboard.jquery');
INSERT INTO opw.opw_config (cfg_key, cfg_value) VALUES ('CLIENT_DASH_TOKEN', 'd171794c5c1f7a50aeb8f7056ab84a4fbcd6fbd594b1999bddaefdd03efc0591');
INSERT INTO opw.opw_config (cfg_key, cfg_value) VALUES ('CLIENT_REGISTER', 'true');
INSERT INTO opw.opw_config (cfg_key, cfg_value) VALUES ('EMAIL_OUTBOUND', 'true');
INSERT INTO opw.opw_config (cfg_key, cfg_value) VALUES ('EMAIL_OUTBOUND_FROM', 'kontakt@otwartapw.pl');
INSERT INTO opw.opw_config (cfg_key, cfg_value) VALUES ('EMAIL_OUTBOUND_FROM_LABEL', 'Otwarta Platforma Wyborcza');
INSERT INTO opw.opw_config (cfg_key, cfg_value) VALUES ('OPW_BASE_URL', 'https://otwartapw.pl/opw');
INSERT INTO opw.opw_config (cfg_key, cfg_value) VALUES ('REST_SESSION_TIMEOUT', '3600');
INSERT INTO opw.opw_config (cfg_key, cfg_value) VALUES ('CISZA_WYBORCZA', 'true');





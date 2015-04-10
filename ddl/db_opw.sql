-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema opw
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `opw` ;

-- -----------------------------------------------------
-- Schema opw
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `opw` DEFAULT CHARACTER SET utf8 ;
USE `opw` ;

-- -----------------------------------------------------
-- Table `opw`.`opw_user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `opw`.`opw_user` ;

CREATE TABLE IF NOT EXISTS `opw`.`opw_user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `firstname` VARCHAR(64) NULL,
  `lastname` VARCHAR(64) NULL,
  `email` VARCHAR(64) NULL,
  `password` VARCHAR(64) NULL,
  `type` VARCHAR(64) NULL,
  `salt` VARCHAR(32) NULL,
  `active` TINYINT(1) NULL,
  `token` VARCHAR(32) NULL,
  `phone` VARCHAR(32) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `opw`.`opw_kandydat`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `opw`.`opw_kandydat` ;

CREATE TABLE IF NOT EXISTS `opw`.`opw_kandydat` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `pkwId` INT NULL,
  `firstname` VARCHAR(128) NULL,
  `lastname` VARCHAR(64) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `opw`.`opw_okregowa_komisja`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `opw`.`opw_okregowa_komisja` ;

CREATE TABLE IF NOT EXISTS `opw`.`opw_okregowa_komisja` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `pkwId` INT NULL,
  `name` VARCHAR(128) NULL,
  `address` VARCHAR(128) NULL,
  `powiaty` VARCHAR(128) NULL,
  `miasta` VARCHAR(128) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `pkwId_UNIQUE` (`pkwId` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `opw`.`opw_obwodowa_komisja`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `opw`.`opw_obwodowa_komisja` ;

CREATE TABLE IF NOT EXISTS `opw`.`opw_obwodowa_komisja` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `pkwId` VARCHAR(64) NULL,
  `name` VARCHAR(128) NULL,
  `address` VARCHAR(128) NULL,
  `type` VARCHAR(4) NULL,
  `allowedToVote` INT NULL,
  `opw_okregowa_komisja_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_opw_obwodowa_komisja_opw_okregowa_komisja_idx` (`opw_okregowa_komisja_id` ASC),
  UNIQUE INDEX `pkwId_UNIQUE` (`pkwId` ASC),
  CONSTRAINT `fk_opw_obwodowa_komisja_opw_okregowa_komisja`
    FOREIGN KEY (`opw_okregowa_komisja_id`)
    REFERENCES `opw`.`opw_okregowa_komisja` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `opw`.`opw_wynik`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `opw`.`opw_wynik` ;

CREATE TABLE IF NOT EXISTS `opw`.`opw_wynik` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `votersValid` INT NULL,
  `votersAmount` INT NULL,
  `cardsValid` INT NULL,
  `votesInvalid` INT NULL,
  `votesValid` INT NULL,
  `fileOriginal` VARCHAR(128) NULL,
  `opw_obwodowa_komisja_id` INT NOT NULL,
  `active` TINYINT(1) NULL,
  `parentId` INT NULL,
  `opw_user_id` INT NOT NULL,
  `k1` SMALLINT NULL,
  `k2` SMALLINT NULL,
  `k3` SMALLINT NULL,
  `k4` SMALLINT NULL,
  `k5` SMALLINT NULL,
  `k6` SMALLINT NULL,
  `k7` SMALLINT NULL,
  `k8` SMALLINT NULL,
  `k9` SMALLINT NULL,
  `k10` SMALLINT NULL,
  `k11` SMALLINT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_opw_wynik_opw_obwodowa_komisja1_idx` (`opw_obwodowa_komisja_id` ASC),
  INDEX `fk_opw_wynik_opw_wynik1_idx` (`parentId` ASC),
  INDEX `fk_opw_wynik_opw_user1_idx` (`opw_user_id` ASC),
  CONSTRAINT `fk_opw_wynik_opw_obwodowa_komisja1`
    FOREIGN KEY (`opw_obwodowa_komisja_id`)
    REFERENCES `opw`.`opw_obwodowa_komisja` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_opw_wynik_opw_wynik1`
    FOREIGN KEY (`parentId`)
    REFERENCES `opw`.`opw_wynik` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_opw_wynik_opw_user1`
    FOREIGN KEY (`opw_user_id`)
    REFERENCES `opw`.`opw_user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `opw`.`opw_user_has_opw_obwodowa_komisja`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `opw`.`opw_user_has_opw_obwodowa_komisja` ;

CREATE TABLE IF NOT EXISTS `opw`.`opw_user_has_opw_obwodowa_komisja` (
  `opw_user_id` INT NOT NULL,
  `opw_obwodowa_komisja_id` INT NOT NULL,
  PRIMARY KEY (`opw_user_id`, `opw_obwodowa_komisja_id`),
  INDEX `fk_opw_user_has_opw_obwodowa_komisja_opw_obwodowa_komisja1_idx` (`opw_obwodowa_komisja_id` ASC),
  INDEX `fk_opw_user_has_opw_obwodowa_komisja_opw_user1_idx` (`opw_user_id` ASC),
  CONSTRAINT `fk_opw_user_has_opw_obwodowa_komisja_opw_user1`
    FOREIGN KEY (`opw_user_id`)
    REFERENCES `opw`.`opw_user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_opw_user_has_opw_obwodowa_komisja_opw_obwodowa_komisja1`
    FOREIGN KEY (`opw_obwodowa_komisja_id`)
    REFERENCES `opw`.`opw_obwodowa_komisja` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `opw`.`opw_kandydat`
-- -----------------------------------------------------
START TRANSACTION;
USE `opw`;
INSERT INTO `opw`.`opw_kandydat` (`id`, `pkwId`, `firstname`, `lastname`) VALUES (1, 1, 'Janusz Ryszard', 'Korwin-Mikke');
INSERT INTO `opw`.`opw_kandydat` (`id`, `pkwId`, `firstname`, `lastname`) VALUES (2, 2, 'Bronisław Maria', 'Komorowski');
INSERT INTO `opw`.`opw_kandydat` (`id`, `pkwId`, `firstname`, `lastname`) VALUES (3, 3, 'Adam Sebastian', 'Jarubas');
INSERT INTO `opw`.`opw_kandydat` (`id`, `pkwId`, `firstname`, `lastname`) VALUES (4, 4, 'Paweł Piotr', 'Kukiz');
INSERT INTO `opw`.`opw_kandydat` (`id`, `pkwId`, `firstname`, `lastname`) VALUES (5, 5, 'Marian Janusz', 'Kowalski');
INSERT INTO `opw`.`opw_kandydat` (`id`, `pkwId`, `firstname`, `lastname`) VALUES (6, 6, 'Jacek', 'Wilk');
INSERT INTO `opw`.`opw_kandydat` (`id`, `pkwId`, `firstname`, `lastname`) VALUES (7, 7, 'Andrzej Sebastian', 'Duda');
INSERT INTO `opw`.`opw_kandydat` (`id`, `pkwId`, `firstname`, `lastname`) VALUES (8, 8, 'Janusz Marian', 'Palikot');
INSERT INTO `opw`.`opw_kandydat` (`id`, `pkwId`, `firstname`, `lastname`) VALUES (9, 9, 'Magdalena Agnieszka', 'Ogórek');
INSERT INTO `opw`.`opw_kandydat` (`id`, `pkwId`, `firstname`, `lastname`) VALUES (10, 10, 'Paweł Jan', 'Tanajno');
INSERT INTO `opw`.`opw_kandydat` (`id`, `pkwId`, `firstname`, `lastname`) VALUES (11, 11, 'Grzegorz Michał', 'Braun');

COMMIT;



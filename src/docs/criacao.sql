-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema vacinas
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `vacinas` ;

-- -----------------------------------------------------
-- Schema vacinas
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `vacinas` DEFAULT CHARACTER SET utf8 ;
USE `vacinas` ;

-- -----------------------------------------------------
-- Table `vacinas`.`raca`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `vacinas`.`raca` ;

CREATE TABLE IF NOT EXISTS `vacinas`.`raca` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `vacinas`.`animal`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `vacinas`.`animal` ;

CREATE TABLE IF NOT EXISTS `vacinas`.`animal` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `dono` VARCHAR(100) NOT NULL,
  `telefone` VARCHAR(9) NOT NULL,
  `tipo` CHAR NOT NULL COMMENT 'G - Gato\nC - Cachorro',
  `nascimento` DATE NULL,
  `raca` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_animal_raca1_idx` (`raca` ASC),
  CONSTRAINT `fk_animal_raca1`
    FOREIGN KEY (`raca`)
    REFERENCES `vacinas`.`raca` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `vacinas`.`vacina`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `vacinas`.`vacina` ;

CREATE TABLE IF NOT EXISTS `vacinas`.`vacina` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `data` DATE NOT NULL,
  `animal` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_vacina_animal_idx` (`animal` ASC),
  CONSTRAINT `fk_vacina_animal`
    FOREIGN KEY (`animal`)
    REFERENCES `vacinas`.`animal` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

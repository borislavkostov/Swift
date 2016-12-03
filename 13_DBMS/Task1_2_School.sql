-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema School
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema School
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `School` DEFAULT CHARACTER SET latin1 ;
USE `School` ;

-- -----------------------------------------------------
-- Table `School`.`addresses`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `School`.`addresses` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `country` VARCHAR(45) NULL DEFAULT NULL,
  `city` VARCHAR(45) NULL DEFAULT NULL,
  `street` VARCHAR(45) NULL DEFAULT NULL,
  `number` INT(11) NULL DEFAULT NULL,
  `floor` INT(11) NULL DEFAULT NULL,
  `apartment_no` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `address_idx` (`country` ASC, `city` ASC, `number` ASC, `street` ASC, `floor` ASC, `apartment_no` ASC, `id` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `School`.`Students`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `School`.`Students` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NULL DEFAULT NULL,
  `enrollment_date` DATE NULL DEFAULT NULL,
  `id_address` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Students_Addresses_idx` (`id_address` ASC),
  CONSTRAINT `fk_Students_Addresses`
    FOREIGN KEY (`id_address`)
    REFERENCES `School`.`addresses` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `School`.`disciplines`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `School`.`disciplines` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `School`.`disciplines_studied`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `School`.`disciplines_studied` (
  `student_id` INT(11) NOT NULL,
  `discipline_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`student_id`),
  INDEX `fk_disciplines_studied_disciplines_idx` (`discipline_id` ASC),
  CONSTRAINT `fk_disciplines_studied_Student`
    FOREIGN KEY (`student_id`)
    REFERENCES `School`.`Students` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_disciplines_studied_disciplines`
    FOREIGN KEY (`discipline_id`)
    REFERENCES `School`.`disciplines` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `School`.`teachers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `School`.`teachers` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NULL DEFAULT NULL,
  `email` VARCHAR(100) NULL DEFAULT NULL,
  `salary` DECIMAL(10,2) NULL DEFAULT NULL,
  `id_addresses` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_teachers_Addresses_idx` (`id_addresses` ASC),
  CONSTRAINT `fk_teachers_Addresses`
    FOREIGN KEY (`id_addresses`)
    REFERENCES `School`.`addresses` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `School`.`disciplines_taught`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `School`.`disciplines_taught` (
  `teacher_id` INT(11) NOT NULL,
  `disciplines_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`teacher_id`),
  INDEX `fk_disciplines_taught_disciplines_idx` (`disciplines_id` ASC),
  CONSTRAINT `fk_disciplines_taught_disciplines`
    FOREIGN KEY (`disciplines_id`)
    REFERENCES `School`.`disciplines` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_disciplines_taught_teachers`
    FOREIGN KEY (`teacher_id`)
    REFERENCES `School`.`teachers` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

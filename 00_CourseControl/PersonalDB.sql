-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema PersonCharacteristicsDB
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema PersonCharacteristicsDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `PersonCharacteristicsDB` DEFAULT CHARACTER SET cp1251 ;
USE `PersonCharacteristicsDB` ;

-- -----------------------------------------------------
-- Table `PersonCharacteristicsDB`.`Address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PersonCharacteristicsDB`.`Address` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `country` VARCHAR(45) CHARACTER SET 'cp1251' NULL DEFAULT NULL,
  `city` VARCHAR(45) CHARACTER SET 'cp1251' NULL DEFAULT NULL,
  `municipality` VARCHAR(45) CHARACTER SET 'cp1251' NULL DEFAULT NULL,
  `postalcode` VARCHAR(45) CHARACTER SET 'cp1251' NULL DEFAULT NULL,
  `street` VARCHAR(45) CHARACTER SET 'cp1251' NULL DEFAULT NULL,
  `number` VARCHAR(45) CHARACTER SET 'cp1251' NULL DEFAULT NULL,
  `flor` INT(11) NULL DEFAULT NULL,
  `apartment_no` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1007
DEFAULT CHARACTER SET = cp1251
COLLATE = cp1251_bulgarian_ci;


-- -----------------------------------------------------
-- Table `PersonCharacteristicsDB`.`Person`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PersonCharacteristicsDB`.`Person` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) CHARACTER SET 'cp1251' NULL DEFAULT NULL,
  `middle_name` VARCHAR(45) CHARACTER SET 'cp1251' NULL DEFAULT NULL,
  `last_name` VARCHAR(45) CHARACTER SET 'cp1251' NULL DEFAULT NULL,
  `gender` VARCHAR(6) CHARACTER SET 'cp1251' NULL DEFAULT NULL,
  `height` INT(11) NULL DEFAULT NULL,
  `date_of_birth` DATE NULL DEFAULT NULL,
  `address_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Person_address_idx` (`address_id` ASC),
  CONSTRAINT `fk_Person_address`
    FOREIGN KEY (`address_id`)
    REFERENCES `PersonCharacteristicsDB`.`Address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1008
DEFAULT CHARACTER SET = cp1251
COLLATE = cp1251_bulgarian_ci;


-- -----------------------------------------------------
-- Table `PersonCharacteristicsDB`.`Education`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PersonCharacteristicsDB`.`Education` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `graduated` TINYINT(1) NULL DEFAULT NULL,
  `enrollment_date` DATE NULL DEFAULT NULL,
  `graduation_date` DATE NULL DEFAULT NULL,
  `institution_name` VARCHAR(80) CHARACTER SET 'cp1251' NULL DEFAULT NULL,
  `person_id` INT(11) NULL DEFAULT NULL,
  `education_code` VARCHAR(1) CHARACTER SET 'cp1251' NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Education_person_idx` (`person_id` ASC),
  CONSTRAINT `fk_Education_person`
    FOREIGN KEY (`person_id`)
    REFERENCES `PersonCharacteristicsDB`.`Person` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2157
DEFAULT CHARACTER SET = cp1251
COLLATE = cp1251_bulgarian_ci;


-- -----------------------------------------------------
-- Table `PersonCharacteristicsDB`.`social_insurance`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PersonCharacteristicsDB`.`social_insurance` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `year` INT(11) NULL DEFAULT NULL,
  `month` INT(11) NULL DEFAULT NULL,
  `amount` DOUBLE NULL DEFAULT NULL,
  `person_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_social_insurance_person_idx` (`person_id` ASC),
  CONSTRAINT `fk_social_insurance_person`
    FOREIGN KEY (`person_id`)
    REFERENCES `PersonCharacteristicsDB`.`Person` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 18145
DEFAULT CHARACTER SET = cp1251
COLLATE = cp1251_bulgarian_ci;

USE `PersonCharacteristicsDB` ;

-- -----------------------------------------------------
-- procedure enter_country
-- -----------------------------------------------------

DELIMITER $$
USE `PersonCharacteristicsDB`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `enter_country`(
in new_country varchar(45),
out new_id int)
BEGIN
INSERT INTO Address (country)
VALUES (new_country);

SET new_id = LAST_INSERT_ID();
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure enter_person
-- -----------------------------------------------------

DELIMITER $$
USE `PersonCharacteristicsDB`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `enter_person`(
in new_first_name varchar(45),
in new_middle_name varchar(45),
in new_last_name varchar(45),
in new_gender varchar(6),
in new_height int(11),
in new_date_ofbirt DATE,
out new_id int
)
BEGIN
Insert into Person (first_name,middle_name,last_name,gender,height,date_of_birth)
Values(new_first_name,new_middle_name,new_last_name,new_gender,new_height,new_date_ofbirt);
SET new_id = LAST_INSERT_ID();
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure enter_social_insurance
-- -----------------------------------------------------

DELIMITER $$
USE `PersonCharacteristicsDB`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `enter_social_insurance`(
in new_year INT,
in new_month INT,
in new_amount DOUBLE,
in new_person_id INT
)
BEGIN
INSERT INTO social_insurance (`year`,`month`,`amount`,`person_id`)
VALUES(new_year,new_month,new_amount, new_person_id);
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure insert_education
-- -----------------------------------------------------

DELIMITER $$
USE `PersonCharacteristicsDB`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_education`(
in new_graduated tinyint(1),
in new_enrollment_date DATE,
in new_graduation_date DATE,
in new_institution_name varchar(80),
in new_person_id int(11),
in new_education_code varchar(1)
)
BEGIN
INSERT INTO Education(`graduated`,`enrollment_date`,`graduation_date`,`institution_name`,`person_id`,`education_code`)
VALUES(new_graduated,new_enrollment_date,new_graduation_date,new_institution_name,new_person_id,new_education_code);
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure insert_small_address
-- -----------------------------------------------------

DELIMITER $$
USE `PersonCharacteristicsDB`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_small_address`(
in new_country varchar(45),
in new_city varchar(45),
in new_municipality varchar(45),
in new_postalcode varchar(45),
in new_street varchar(45),
in new_number varchar(45)
)
BEGIN
INSERT INTO Address (country,city,municipality,postalcode,street,number)
VALUES (new_country,new_city,new_municipality,new_postalcode,new_street,new_number);
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure pull_address
-- -----------------------------------------------------

DELIMITER $$
USE `PersonCharacteristicsDB`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `pull_address`(
out new_country varchar(45),
out new_city varchar(45),
out new_municipality varchar(45),
out new_postalcode varchar(45),
out new_street varchar(45),
out new_number varchar(45),
out new_floor int(11),
out new_apartment_no int(11),
in new_id int
)
BEGIN
SELECT country,city,municipality,postalcode,street,number,flor,apartment_no
INTO new_country,new_city,new_municipality,new_postalcode,new_street,new_number,new_floor,new_apartment_no
FROM Address,Person
WHERE Person.id=new_id AND Address.id=Person.address_id;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure pull_education
-- -----------------------------------------------------

DELIMITER $$
USE `PersonCharacteristicsDB`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `pull_education`(
out new_graduated tinyint(1),
out new_enrollment_date DATE,
out new_graduation_date DATE,
out new_institution_name varchar(80),
in new_person_id int(11)
)
BEGIN
SELECT Education.graduated AS new_graduated,Education.enrollment_date AS new_enrollment_date,Education.graduation_date AS new_graduation_date,Education.institution_name AS new_institution_name
FROM Education 
INNER JOIN Education AS EDU
WHERE Education.person_id = new_person_id;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure pull_person
-- -----------------------------------------------------

DELIMITER $$
USE `PersonCharacteristicsDB`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `pull_person`(
in new_id int,
out new_first_name varchar(45),
out new_middle_name varchar(45),
out new_last_name varchar(45),
out new_gender varchar(6),
out new_height int(11),
out new_date_of_birth DATE
)
BEGIN
Select first_name,middle_name,last_name,gender,height,date_of_birth 
INTO new_first_name,new_middle_name,new_last_name,new_gender,new_height,new_date_of_birth
FROM Person
Where id=new_id;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure set_address
-- -----------------------------------------------------

DELIMITER $$
USE `PersonCharacteristicsDB`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `set_address`(
in new_country varchar(45),
in new_city varchar(45),
in new_municipality varchar(45),
in new_postalcode varchar(45),
in new_street varchar(45),
in new_number varchar(45),
in new_floor int(11),
in new_apartment_no int(11),
out new_id int
)
BEGIN
INSERT INTO Address (country,city,municipality,postalcode,street,number,flor,apartment_no)
VALUES (new_country,new_city,new_municipality,new_postalcode,new_street,new_number,new_floor,new_apartment_no);
SET new_id = LAST_INSERT_ID();
END$$

DELIMITER ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema tms
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema tms
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `tms` DEFAULT CHARACTER SET utf8 ;
USE `tms` ;

-- -----------------------------------------------------
-- Table `tms`.`episodes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tms`.`episodes` (
  `episode_id` INT(11) NOT NULL AUTO_INCREMENT,
  `number` INT(11) NULL DEFAULT NULL,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `plot` VARCHAR(45) NULL DEFAULT NULL,
  `airingDate` DATE NULL DEFAULT NULL,
  `isWached` TINYINT(4) NULL DEFAULT NULL,
  PRIMARY KEY (`episode_id`),
  UNIQUE INDEX `episode_id_UNIQUE` (`episode_id` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tms`.`seasons`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tms`.`seasons` (
  `season_id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `number` INT(11) NULL DEFAULT NULL,
  `episodes_episode_id` INT(11) NOT NULL,
  PRIMARY KEY (`season_id`, `episodes_episode_id`),
  INDEX `fk_seasons_episodes1_idx` (`episodes_episode_id` ASC),
  CONSTRAINT `fk_seasons_episodes1`
    FOREIGN KEY (`episodes_episode_id`)
    REFERENCES `tms`.`episodes` (`episode_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tms`.`shows`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tms`.`shows` (
  `show_id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `plot` VARCHAR(45) NULL DEFAULT NULL,
  `voteCount` INT(11) NULL DEFAULT NULL,
  `voters` INT(11) NULL DEFAULT NULL,
  `seasons_season_id` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`show_id`, `seasons_season_id`),
  UNIQUE INDEX `show_id_UNIQUE` (`show_id` ASC),
  INDEX `fk_shows_seasons1_idx` (`seasons_season_id` ASC),
  CONSTRAINT `fk_shows_seasons1`
    FOREIGN KEY (`seasons_season_id`)
    REFERENCES `tms`.`seasons` (`season_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tms`.`comments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tms`.`comments` (
  `comment_id` INT(11) NOT NULL AUTO_INCREMENT,
  `user` VARCHAR(45) NULL DEFAULT NULL,
  `date` DATE NULL DEFAULT NULL,
  `content` VARCHAR(45) NULL DEFAULT NULL,
  `shows_show_id` INT(11) NOT NULL,
  `episodes_episode_id` INT(11) NOT NULL,
  PRIMARY KEY (`comment_id`),
  UNIQUE INDEX `comment_id_UNIQUE` (`comment_id` ASC),
  INDEX `fk_comments_shows1_idx` (`shows_show_id` ASC),
  INDEX `fk_comments_episodes1_idx` (`episodes_episode_id` ASC),
  CONSTRAINT `fk_comments_episodes1`
    FOREIGN KEY (`episodes_episode_id`)
    REFERENCES `tms`.`episodes` (`episode_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_comments_shows1`
    FOREIGN KEY (`shows_show_id`)
    REFERENCES `tms`.`shows` (`show_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tms`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tms`.`users` (
  `user_id` INT(11) NOT NULL AUTO_INCREMENT,
  `userName` VARCHAR(45) NULL DEFAULT NULL,
  `age` INT(11) NULL DEFAULT NULL,
  `userscol` VARCHAR(45) NULL DEFAULT NULL,
  `country` VARCHAR(45) NULL DEFAULT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `password` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `userName_UNIQUE` (`userName` ASC),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tms`.`users_has_shows`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tms`.`users_has_shows` (
  `users_user_id` INT(11) NOT NULL,
  `shows_show_id` INT(11) NOT NULL,
  PRIMARY KEY (`users_user_id`, `shows_show_id`),
  INDEX `fk_users_has_shows_shows1_idx` (`shows_show_id` ASC),
  INDEX `fk_users_has_shows_users_idx` (`users_user_id` ASC),
  CONSTRAINT `fk_users_has_shows_shows1`
    FOREIGN KEY (`shows_show_id`)
    REFERENCES `tms`.`shows` (`show_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_users_has_shows_users`
    FOREIGN KEY (`users_user_id`)
    REFERENCES `tms`.`users` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
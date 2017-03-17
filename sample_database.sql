-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema sample_schema
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema sample_schema
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sample_schema` DEFAULT CHARACTER SET utf8 ;
USE `sample_schema` ;

-- -----------------------------------------------------
-- Table `sample_schema`.`comments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sample_schema`.`comments` (
  `comment_id` INT(11) NOT NULL AUTO_INCREMENT,
  `user` VARCHAR(45) NOT NULL,
  `date` DATETIME NOT NULL,
  `content` VARCHAR(100) NOT NULL,
  `episodes_episode_id` INT(11) NOT NULL,
  `shows_show_id` INT(11) NOT NULL,
  PRIMARY KEY (`comment_id`),
  UNIQUE INDEX `comment_id_UNIQUE` (`comment_id` ASC),
  UNIQUE INDEX `user_UNIQUE` (`user` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sample_schema`.`episodes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sample_schema`.`episodes` (
  `episode_id` INT(11) NOT NULL AUTO_INCREMENT,
  `number` INT(11) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `plot` VARCHAR(100) NOT NULL,
  `air_date` DATE NOT NULL,
  `is_watched` TINYINT(4) NOT NULL,
  PRIMARY KEY (`episode_id`),
  UNIQUE INDEX `episode_id_UNIQUE` (`episode_id` ASC),
  UNIQUE INDEX `number_UNIQUE` (`number` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sample_schema`.`seasons`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sample_schema`.`seasons` (
  `season_id` INT(11) NOT NULL AUTO_INCREMENT,
  `number` INT(11) NOT NULL,
  `episodes_episode_id` INT(11) NOT NULL,
  PRIMARY KEY (`season_id`),
  UNIQUE INDEX `season_id_UNIQUE` (`season_id` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sample_schema`.`shows`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sample_schema`.`shows` (
  `show_id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(60) NOT NULL,
  `plot` VARCHAR(100) NOT NULL,
  `vote_count` INT(11) NULL DEFAULT NULL,
  `voters` INT(11) NULL DEFAULT NULL,
  `season_seasons_id` INT(11) NOT NULL,
  `season_seasons_episode_id` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`show_id`),
  UNIQUE INDEX `show_id_UNIQUE` (`show_id` ASC),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC),
  UNIQUE INDEX `season_seasons_id_UNIQUE` (`season_seasons_id` ASC),
  UNIQUE INDEX `season_seasons_episode_id_UNIQUE` (`season_seasons_episode_id` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sample_schema`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sample_schema`.`users` (
  `user_id` INT(11) NOT NULL AUTO_INCREMENT,
  `user_name` VARCHAR(45) NOT NULL,
  `age` INT(11) NULL DEFAULT NULL,
  `country` VARCHAR(45) NULL DEFAULT NULL,
  `email` VARCHAR(50) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `user_id_UNIQUE` (`user_id` ASC),
  UNIQUE INDEX `user_name_UNIQUE` (`user_name` ASC),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sample_schema`.`users_shows`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sample_schema`.`users_shows` (
  `users_shows` INT(11) NOT NULL,
  `shows_show_id` INT(11) NOT NULL,
  PRIMARY KEY (`users_shows`, `shows_show_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- MySQL Script generated by MySQL Workbench
-- Thu May 16 20:46:03 2024
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`music`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`music` ;

CREATE TABLE IF NOT EXISTS `mydb`.`music` (
                                              `id` BIGINT(32) NOT NULL AUTO_INCREMENT,
    `music_name` VARCHAR(45) NOT NULL,
    `length_by_seconds` INT NOT NULL,
    `path_to_file` VARCHAR(100) NOT NULL,
    `category` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_music_UNIQUE` (`id` ASC) VISIBLE)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`playlist`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`playlist` ;

CREATE TABLE IF NOT EXISTS `mydb`.`playlist` (
                                                 `id` BIGINT(32) NOT NULL AUTO_INCREMENT,
    `user_id` BIGINT(32) NOT NULL,
    `playlist_name` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `fk_playlist_user1_idx` (`user_id` ASC) VISIBLE,
    CONSTRAINT `fk_playlist_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `mydb`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`playlist_has_music`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`playlist_has_music` ;

CREATE TABLE IF NOT EXISTS `mydb`.`playlist_has_music` (
                                                           `playlist_id` BIGINT(32) NOT NULL,
    `music_id` BIGINT(32) NOT NULL,
    PRIMARY KEY (`playlist_id`, `music_id`),
    INDEX `fk_playlist_has_music_music1_idx` (`music_id` ASC) VISIBLE,
    INDEX `fk_playlist_has_music_playlist1_idx` (`playlist_id` ASC) VISIBLE,
    CONSTRAINT `fk_playlist_has_music_playlist1`
    FOREIGN KEY (`playlist_id`)
    REFERENCES `mydb`.`playlist` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_playlist_has_music_music1`
    FOREIGN KEY (`music_id`)
    REFERENCES `mydb`.`music` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`user` ;

CREATE TABLE IF NOT EXISTS `mydb`.`user` (
                                             `id` BIGINT(32) NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(16) NOT NULL,
    `password` VARCHAR(32) NOT NULL,
    `role` VARCHAR(45) NOT NULL,
    UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);


-- -----------------------------------------------------
-- Table `mydb`.`view_manager`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`view_manager` ;

CREATE TABLE IF NOT EXISTS `mydb`.`view_manager` (
                                                     `view_count` INT NOT NULL,
                                                     `music_id` BIGINT(32) NOT NULL,
    `user_id` BIGINT(32) NOT NULL,
    PRIMARY KEY (`music_id`, `user_id`),
    INDEX `fk_view_manager_music1_idx` (`music_id` ASC) VISIBLE,
    INDEX `fk_view_manager_user1_idx` (`user_id` ASC) VISIBLE,
    CONSTRAINT `fk_view_manager_music1`
    FOREIGN KEY (`music_id`)
    REFERENCES `mydb`.`music` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_view_manager_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `mydb`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

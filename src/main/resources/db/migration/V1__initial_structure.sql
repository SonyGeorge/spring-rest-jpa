CREATE TABLE `transactions` (
	`id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
	`coin_name` VARCHAR(64) NOT NULL,
	`amount` DECIMAL(20,6) NOT NULL DEFAULT 0,
	`date_time` TIMESTAMP NOT NULL,
	PRIMARY KEY (`id`)
)COLLATE='utf8mb4_unicode_ci' ;

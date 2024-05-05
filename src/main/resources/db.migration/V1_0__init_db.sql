CREATE TABLE IF NOT EXISTS `games` (
    `id` bigint AUTO_INCREMENT PRIMARY KEY,
    `created_at` TIMESTAMP NOT NULL,
    `updated_at` TIMESTAMP,
    `game_id` VARCHAR(36) UNIQUE,
    `name` varchar(100) NOT NULL,
    `description` varchar(500) NOT NULL,
    `first_player_name` VARCHAR(100),
    `first_player_score` int,
    `second_player_name` VARCHAR(100),
    `second_player_score` int,
    `game_status` varchar(20) NOT NULL
);






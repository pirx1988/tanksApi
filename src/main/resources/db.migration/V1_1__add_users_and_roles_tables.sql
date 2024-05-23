CREATE TABLE IF NOT EXISTS `roles` (
    `id` bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `role_name` varchar(500) NOT NULL,
    `created_at` TIMESTAMP NOT NULL,
    `updated_at` TIMESTAMP
);

CREATE TABLE IF NOT EXISTS `users` (
    `id` bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `username` varchar(500) NOT NULL,
    `password` varchar(500) NOT NULL,
    `role_id` bigint NOT NULL,
    `created_at` TIMESTAMP NOT NULL,
    `updated_at` TIMESTAMP,
     FOREIGN KEY (role_id) REFERENCES roles(id)
);

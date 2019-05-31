CREATE TABLE `user`
(
    `id`       int(10)     NOT NULL AUTO_INCREMENT,
    `username` varchar(50) NOT NULL DEFAULT '',
    `password` varchar(50) NOT NULL DEFAULT '',
    `role`     varchar(50) NOT NULL DEFAULT '',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;
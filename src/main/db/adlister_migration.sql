USE adlister_db;

DROP TABLE IF EXISTS users;
# Users sign up for the site with an email and password
# Each ad is associated with the user that created it.
CREATE TABLE IF NOT EXISTS users
(
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    username VARCHAR(100),
    email VARCHAR(100) NOT NULL,
    password VARCHAR(50)  NOT NULL,
    PRIMARY KEY (id)
);


DROP TABLE IF EXISTS ads;
# Users create ads with a title and description and category.
CREATE TABLE IF NOT EXISTS ads
(
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    description VARCHAR(1000) NOT NULL,
    user_id INT UNSIGNED,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users (id)
);



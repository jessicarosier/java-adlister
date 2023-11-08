USE adlister_db;


# Users sign up for the site with an email and password
# Each ad is associated with the user that created it.
CREATE TABLE IF NOT EXISTS users
(
    id       INT UNSIGNED NOT NULL AUTO_INCREMENT,
    username VARCHAR(100) UNIQUE,
    email    VARCHAR(100) NOT NULL,
    password VARCHAR(50)  NOT NULL,
    PRIMARY KEY (id)
);



# Users create ads with a title and description and category.
CREATE TABLE IF NOT EXISTS ads
(
    id          INT UNSIGNED  NOT NULL AUTO_INCREMENT,
    title       VARCHAR(100)  NOT NULL,
    description VARCHAR(1000) NOT NULL,
    user_id     INT UNSIGNED,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users (id)
);


CREATE TABLE IF NOT EXISTS category
(
    id        INT UNSIGNED NOT NULL AUTO_INCREMENT,
    cat_title VARCHAR(100),
    PRIMARY KEY (id)

);


# An ad can be in one or more categories (for example, "help wanted", "giveaway", or "furniture")
CREATE TABLE IF NOT EXISTS ads_category
(
    ad_id  INT UNSIGNED,
    cat_id INT UNSIGNED,
    FOREIGN KEY (ad_id) REFERENCES ads (id),
    FOREIGN KEY (cat_id) REFERENCES category (id)
);


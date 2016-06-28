CREATE SCHEMA IF NOT EXISTS HANKS;
SET SCHEMA HANKS;

CREATE TABLE `HANKS_MASTER_USER` (
  `master_user_id` varchar(60) NOT NULL,
  `msisdn` varchar(60) NOT NULL,
  `paid_type` tinyint(2) DEFAULT '0',
  `sub_type` tinyint(2) DEFAULT '0',
  `token` varchar(60) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  PRIMARY KEY (`master_user_id`,`msisdn`)
) 
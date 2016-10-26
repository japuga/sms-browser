CREATE TABLE sms_contact
(
contact_id INT auto_increment NOT NULL PRIMARY KEY,
first_name VARCHAR2(100),
last_name VARCHAR2(100)
);

CREATE TABLE phone_number
(
contact_id INT NOT NULL,
phone_number VARCHAR(15) NOT NULL,
phone_type VARCHAR(20)  --Home, Mobile
);

ALTER TABLE phone_number ADD CONSTRAINT pk_phone_number PRIMARY KEY(contact_id, phone_number);

CREATE TABLE sms_message
( 
message_id INT auto_increment not null PRIMARY KEY,
contact_id INT,
phone_number VARCHAR(100),
sender_name VARCHAR(200),
date_sent DATE,
folder VARCHAR2(100),
content VARCHAR2(500)
);

ALTER TABLE sms_message ADD CONSTRAINT fk_contact FOREIGN KEY (contact_id) REFERENCES sms_contact(contact_id);

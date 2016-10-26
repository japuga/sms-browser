INSERT INTO sms_contact(first_name, last_name) VALUES('Javier', 'Puente');
INSERT INTO sms_contact(first_name, last_name) VALUES('Teresa', 'Arroyo');

INSERT INTO phone_number(contact_id, phone_number, phone_type) SELECT contact_id, '2147942866','Mobile'
FROM sms_contact WHERE first_name='Javier';


/*
INSERT INTO sms_message (message_id, contact_id, phone)
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
*/
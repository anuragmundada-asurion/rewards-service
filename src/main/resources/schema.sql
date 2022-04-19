DROP TABLE IF EXISTS purchase_details;
CREATE TABLE purchase_details (
purchase_id INT AUTO_INCREMENT  PRIMARY KEY,
purchase_amount DECIMAL DEFAULT 0,
customer_name varchar(50) NOT NULL,
purchase_date datetime
);
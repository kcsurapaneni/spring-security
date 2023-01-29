CREATE TABLE customer_role (
    customer_id INT NOT NULL,
    role_id INT NULL,
    is_active BOOL DEFAULT TRUE,
    CONSTRAINT customer_role_customer_id FOREIGN KEY (customer_id) REFERENCES customer (id),
    CONSTRAINT customer_role_role_id FOREIGN KEY (role_id) REFERENCES role (id)
);
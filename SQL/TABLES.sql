CREATE TABLE staff(
    staff_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(60) UNIQUE,
    password VARCHAR(20) NOT NULL,
    balance DECIMAL(15,2),
    fullName VARCHAR(60),
    role VARCHAR(30)
);


CREATE TABLE customers(
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    firstName VARCHAR(50),
    lastName VARCHAR(50),
    idNumber VARCHAR(20) UNIQUE,
    username VARCHAR(60) UNIQUE,
    password VARCHAR(20) NOT NULL,
    balance DECIMAL(15,2)
);

CREATE TABLE accounts(
    account_id INT AUTO_INCREMENT PRIMARY KEY,
    accountNumber VARCHAR(20) NOT NULL UNIQUE,
    customer_id INT NOT NULL,
    balance DECIMAL(15,2) DEFAULT 0.00,
    account_type VARCHAR(30) NOT NULL DEFAULT 'Cheque',
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);

CREATE TABLE bankVault (
    vault_id INT AUTO_INCREMENT PRIMARY KEY,
    balance DECIMAL(20,2) NOT NULL DEFAULT 200000000.00,
    last_updated DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE transactions(
    transaction_id INT AUTO_INCREMENT PRIMARY KEY,
    account_id INT NOT NULL,
    transaction_type VARCHAR(30) NOT NULL,
    transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    sender_id INT NOT NULL,
    receiver_id INT,
    amount DECIMAL(15,2) NOT NULL,
    FOREIGN KEY (sender_id) REFERENCES customers(customer_id),
    FOREIGN KEY (receiver_id) REFERENCES customers(customer_id)
);


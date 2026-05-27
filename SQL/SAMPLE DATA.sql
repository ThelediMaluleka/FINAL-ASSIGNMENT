INSERT INTO staff (username, password, balance, fullName, role) 
VALUES
('admin.root', 'Admin@1234', 0.00, 'System Administrator', 'Admin'),
('john.mthembu', 'Staff@5678', 52000.00, 'John Mthembu', 'Branch Manager'),
('priya.naidoo', 'Teller@2023', 38500.00,  'Priya Naidoo', 'Teller'),
('david.osei', 'Teller@4455', 36200.00,  'David Osei', 'Teller'),
('sarah.botha', 'Loan@7891', 61000.00,  'Sarah Botha', 'Loans Officer');


INSERT INTO customers (firstName, lastName, idNumber, username, password, balance) 
VALUES
('Thabo', 'Dlamini', '9203155478083', 'thabo.dlamini','Pass@1234', 15420.50),
('Amara',   'Khumalo', '8811220347081', 'amara.khumalo', 'Pass@5678', 82300.00),
('Sipho',   'Zulu', '9507087654082', 'sipho.zulu', 'Pass@9012', 4750.75),
('Naledi',  'Mokoena', '0001040189085', 'naledi.mokoena', 'Pass@3456', 210500.00),
('Reza',    'Patel', '8706123456087', 'reza.patel', 'Pass@7890', 33100.25),
('Lindiwe', 'Sithole', '9102285543086', 'lindiwe.sithole', 'Pass@1122', 9875.00);


INSERT INTO accounts (accountNumber, customer_id, balance, account_type) 
VALUES
('ACC-0001-2024', 1, 15420.50, 'Cheque'),
('ACC-0002-2024', 2, 42300.00, 'Cheque'),
('SAV-0002-2024', 2, 40000.00, 'Savings'),
('ACC-0003-2024', 3,  4750.75, 'Cheque'),
('ACC-0004-2024', 4, 110500.00,'Cheque'),
('SAV-0004-2024', 4, 100000.00, 'Savings'),
('ACC-0005-2024', 5, 33100.25, 'Cheque'),
('ACC-0006-2024', 6,  9875.00, 'Cheque');


INSERT INTO bankVault (balance) 
VALUES 
(199644453.50);


INSERT INTO transactions (account_id, transaction_type, transaction_date, sender_id, receiver_id, amount) 
VALUES
(1, 'Deposit', '2024-10-01 08:15:00', 1, NULL, 5000.00),
(2, 'Deposit', '2024-10-03 10:00:00', 2, NULL, 20000.00),
(1, 'Transfer', '2024-10-10 14:22:00', 1, 3, 2500.00),
(4, 'Deposit', '2024-10-12 09:05:00', 3, NULL, 1000.00),
(5, 'Deposit', '2024-10-15 11:30:00', 4, NULL, 50000.00),
(2, 'Withdrawal', '2024-10-18 13:45:00', 2, NULL, 5000.00),
(7, 'Deposit', '2024-10-20 08:00:00', 5, NULL, 10000.00),
(2, 'Transfer', '2024-10-22 15:10:00', 2, 6, 3500.00),
(8, 'Deposit', '2024-10-25 10:20:00', 6, NULL, 4000.00),
(1, 'Withdrawal', '2024-11-01 09:00:00', 1, NULL, 800.00),
(5, 'Transfer', '2024-11-05 14:00:00', 4, 5,    15000.00),
(7, 'Withdrawal', '2024-11-10 11:30:00', 5, NULL, 2500.00);
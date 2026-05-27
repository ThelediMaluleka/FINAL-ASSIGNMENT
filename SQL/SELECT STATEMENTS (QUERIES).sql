SELECT firstName, lastName, balance FROM customers WHERE balance > 10000.00;

SELECT accountNumber, customer_id, balance FROM accounts WHERE account_type = 'Savings';

SELECT transaction_id, account_id, amount, transaction_date FROM transactions WHERE transaction_type = 'Withdrawal';

SELECT fullName, username, role FROM staff WHERE role = 'Teller';

SELECT transaction_id, transaction_type, amount, transaction_date FROM transactions WHERE amount > 5000.00 AND transaction_date BETWEEN '2024-10-01' AND '2024-10-31';
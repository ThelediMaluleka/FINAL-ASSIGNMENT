package banking.system;

import java.util.ArrayList;
import java.util.Scanner;


public class BANKINGSYSTEM {
    static class Customer {
        String firstName, lastName, IDNumber, email, phone;
        String username, password;
        int accNo;
        double balance;

        Customer(String firstName, String lastName, String IDNumber, String email, String phone, String username, String password, int accNo, double balance) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.IDNumber = IDNumber;
            this.email = email;
            this.phone = phone;
            this.username = username;
            this.password = password;
            this.accNo = accNo;
            this.balance = balance;
        }
    }

    static ArrayList<Customer> customers = new ArrayList<>();
    static Customer loggedInCustomer = null;

    static String username;
    static String password;
    static int option;
    static int updateOption;

    static double Sbalance = 200000000.00;

    static double DAmount;
    static double WAmount;
    static double TAmount;

    static int AccNo;
    static Scanner S = new Scanner(System.in);

    private static void loadCustomers() {
        customers.add(new Customer("Thabo",   "Dlamini",  "9203155478083", "thabo@email.com",   "0711234567", "thabo.dlamini",   "Pass@1234", 100001, 15420.50));
        customers.add(new Customer("Amara",   "Khumalo",  "8811220347081", "amara@email.com",   "0722345678", "amara.khumalo",   "Pass@5678", 100002, 82300.00));
        customers.add(new Customer("Sipho",   "Zulu",     "9507087654082", "sipho@email.com",   "0733456789", "sipho.zulu",      "Pass@9012", 100003, 4750.75));
        customers.add(new Customer("Naledi",  "Mokoena",  "0001040189085", "naledi@email.com",  "0744567890", "naledi.mokoena",  "Pass@3456", 100004, 210500.00));
        customers.add(new Customer("Reza",    "Patel",    "8706123456087", "reza@email.com",    "0755678901", "reza.patel",      "Pass@7890", 100005, 33100.25));
        customers.add(new Customer("Lindiwe", "Sithole",  "9102285543086", "lindiwe@email.com", "0766789012", "lindiwe.sithole", "Pass@1122", 100006, 9875.00));
    }

    static void MainMenu() {
        boolean running = true;
        while (running) {
            System.out.println("\n**************************************");
            System.out.println("     WELCOME TO THE BANK");
            System.out.println("***************************************");
            System.out.println("Enter 1 if you are a staff member");
            System.out.println("Enter 2 if you are a customer");
            System.out.println("Enter 0 to exit");
            option = S.nextInt();
            S.nextLine();

            switch (option) {
                case 1 -> StaffLogin();
                case 2 -> CustomerLogin();
                case 0 -> {
                    System.out.println("Thank you for banking with us. Goodbye!");
                    running = false;
                }
                default -> System.out.println("INVALID INFORMATION, TRY AGAIN");
            }
        }
    }

    static void StaffLogin() {
        System.out.println("\n**********STAFF LOGIN**********");
        System.out.println("Enter your username");
        username = S.nextLine();
        System.out.println("Enter your password");
        password = S.nextLine();

        if (username.equals("staff.ledi") && password.equals("staff778")) {
            System.out.println("LOGIN SUCCESSFUL");
            StaffMenu();
        } else {
            System.out.println("INVALID DETAILS, TRY AGAIN");
        }
    }

    static void StaffMenu() {
        boolean inStaffMenu = true;
        while (inStaffMenu) {
            System.out.println("\n----------STAFF MENU----------");
            System.out.println("Enter 1 to Deposit");
            System.out.println("Enter 2 to Withdraw");
            System.out.println("Enter 3 to Transfer");
            System.out.println("Enter 4 to Check Bank Balance");
            System.out.println("Enter 5 to View All Customers");
            System.out.println("Enter 0 to return to Main Menu");
            option = S.nextInt();
            S.nextLine();

            switch (option) {
                case 1 -> deposit();
                case 2 -> withdraw();
                case 3 -> transfer();
                case 4 -> {
                    System.out.println("-----BANK BALANCE-----");
                    System.out.println("Bank Balance: R" + Sbalance);
                }
                case 5 -> viewAllCustomers();
                case 0 -> inStaffMenu = false;
                default -> System.out.println("INVALID OPTION, TRY AGAIN");
            }
        }
    }

    static void viewAllCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customers registered yet.");
        } else {
            System.out.println("\n----------ALL CUSTOMERS----------");
            for (Customer c : customers) {
                System.out.println("Name          : " + c.firstName + " " + c.lastName);
                System.out.println("ID Number     : " + c.IDNumber);
                System.out.println("Account Number: " + c.accNo);
                System.out.println("Balance       : R" + c.balance);
                System.out.println("Email         : " + c.email);
                System.out.println("Phone         : " + c.phone);
                System.out.println("----------------------------------");
            }
        }
    }

    static void CustomerLogin() {
        System.out.println("\n**********CUSTOMER LOGIN**********");
        System.out.println("Enter your username");
        username = S.nextLine();
        System.out.println("Enter your password");
        password = S.nextLine();

        loggedInCustomer = null;
        for (Customer c : customers) {
            if (c.username.equals(username) && c.password.equals(password)) {
                loggedInCustomer = c;
                break;
            }
        }

        if (loggedInCustomer != null) {
            System.out.println("LOGIN SUCCESSFUL. Welcome, " + loggedInCustomer.firstName + "!");
            CustomerMenu();
        } else {
            System.out.println("INVALID DETAILS, TRY AGAIN");
        }
    }

    static void deposit() {
        System.out.println("\n----------DEPOSIT----------");
        System.out.println("Enter the account number");
        AccNo = S.nextInt();
        S.nextLine();
        System.out.println("Enter the amount you want to deposit");
        DAmount = S.nextDouble();
        S.nextLine();

        if (DAmount <= 0) {
            System.out.println("INVALID AMOUNT, TRY AGAIN");
        } else if (loggedInCustomer != null) {
            loggedInCustomer.balance += DAmount;
            System.out.println("Deposit successful.");
            System.out.println("Account Number  : " + AccNo);
            System.out.println("Amount Deposited: R" + DAmount);
            System.out.println("New Balance     : R" + loggedInCustomer.balance);
        } else {
            System.out.println("No customer logged in.");
        }
    }

    static void withdraw() {
        System.out.println("\n----------WITHDRAWAL----------");
        System.out.println("Enter the account number");
        AccNo = S.nextInt();
        S.nextLine();
        System.out.println("Enter the amount you want to withdraw");
        WAmount = S.nextDouble();
        S.nextLine();

        if (WAmount <= 0) {
            System.out.println("INVALID AMOUNT, TRY AGAIN");
        } else if (loggedInCustomer == null) {
            System.out.println("No customer logged in.");
        } else if (WAmount > loggedInCustomer.balance) {
            System.out.println("INSUFFICIENT FUNDS");
            System.out.println("Available Balance: R" + loggedInCustomer.balance);
        } else {
            loggedInCustomer.balance -= WAmount;
            System.out.println("----------------------------------");
            System.out.println("Withdrawal successful.");
            System.out.println("Account Number   : " + AccNo);
            System.out.println("Amount Withdrawn : R" + WAmount);
            System.out.println("Remaining Balance: R" + loggedInCustomer.balance);
        }
    }

    static void transfer() {
        System.out.println("\n----------TRANSFER----------");
        System.out.println("Enter the account you want to transfer to");
        AccNo = S.nextInt();
        S.nextLine();
        System.out.println("Enter the amount you want to transfer");
        TAmount = S.nextDouble();
        S.nextLine();

        if (TAmount <= 0) {
            System.out.println("INVALID AMOUNT, TRY AGAIN");
        } else if (loggedInCustomer == null) {
            System.out.println("No customer logged in.");
        } else if (TAmount > loggedInCustomer.balance) {
            System.out.println("INSUFFICIENT FUNDS");
            System.out.println("Available Balance: R" + loggedInCustomer.balance);
        } else {
            loggedInCustomer.balance -= TAmount;
            System.out.println("Transfer successful.");
            System.out.println("To Account Number : " + AccNo);
            System.out.println("Amount Transferred: R" + TAmount);
            System.out.println("Remaining Balance : R" + loggedInCustomer.balance);
        }
    }

    static void CheckBalance() {
        System.out.println("-----BALANCE CHECK-----");
        if (loggedInCustomer != null) {
            System.out.println("Your balance is: R" + loggedInCustomer.balance);
        } else {
            System.out.println("Your balance is: R0.00");
        }
    }

    static void CustomerMenu() {
        boolean inCustomerMenu = true;
        while (inCustomerMenu) {
            System.out.println("\n----------CUSTOMER MENU----------");
            System.out.println("Enter 1 to register");
            System.out.println("Enter 2 to view your details");
            System.out.println("Enter 3 to update your details");
            System.out.println("Enter 4 to deposit money");
            System.out.println("Enter 5 to withdraw money");
            System.out.println("Enter 6 to transfer money");
            System.out.println("Enter 7 to check your balance");
            System.out.println("Enter 0 to return to the main menu");
            option = S.nextInt();
            S.nextLine();

            switch (option) {
                case 1:
                    System.out.println("----------REGISTER----------");
                    System.out.println("Enter your first name");
                    String fn = S.nextLine();
                    System.out.println("Enter your last name");
                    String ln = S.nextLine();
                    System.out.println("Enter your ID number");
                    String id = S.nextLine();
                    System.out.println("Enter your email address");
                    String em = S.nextLine();
                    System.out.println("Enter your phone number");
                    String ph = S.nextLine();
                    System.out.println("Enter your username");
                    String nu = S.nextLine();
                    System.out.println("Enter your password");
                    String np = S.nextLine();
                    int generatedAccNo = (int)(Math.random() * 900000) + 100000;

                    Customer newCustomer = new Customer(fn, ln, id, em, ph, nu, np, generatedAccNo, 0.00);
                    customers.add(newCustomer);
                    System.out.println("REGISTRATION SUCCESSFUL");
                    System.out.println("Name          : " + fn + " " + ln);
                    System.out.println("ID Number     : " + id);
                    System.out.println("Email         : " + em);
                    System.out.println("Phone         : " + ph);
                    System.out.println("Username      : " + nu);
                    System.out.println("Account Number: " + generatedAccNo);
                    System.out.println("Password      : ********");
                    break;

                case 2:
                    System.out.println("----------VIEW DETAILS----------");
                    if (loggedInCustomer != null) {
                        System.out.println("Name           : " + loggedInCustomer.firstName + " " + loggedInCustomer.lastName);
                        System.out.println("Username       : " + loggedInCustomer.username);
                        System.out.println("Account Number : " + loggedInCustomer.accNo);
                        System.out.println("Balance        : R" + loggedInCustomer.balance);
                        System.out.println("Email          : " + loggedInCustomer.email);
                        System.out.println("Phone          : " + loggedInCustomer.phone);
                    } else {
                        System.out.println("No customer logged in.");
                    }
                    break;

                case 3:
                    System.out.println("----------UPDATE DETAILS----------");
                    System.out.println("Enter 1 to update username");
                    System.out.println("Enter 2 to update password");
                    System.out.println("Enter 3 to update phone number");
                    System.out.println("Enter 4 to update email");
                    updateOption = S.nextInt();
                    S.nextLine();

                    if (loggedInCustomer == null) {
                        System.out.println("No customer logged in.");
                        break;
                    }

                    switch (updateOption) {
                        case 1:
                            System.out.println("Enter your new username");
                            loggedInCustomer.username = S.nextLine();
                            System.out.println("Username updated to: " + loggedInCustomer.username);
                            break;
                        case 2:
                            System.out.println("Enter your new password");
                            loggedInCustomer.password = S.nextLine();
                            System.out.println("Password updated successfully.");
                            break;
                        case 3:
                            System.out.println("Enter your new phone number");
                            loggedInCustomer.phone = S.nextLine();
                            System.out.println("Phone updated to: " + loggedInCustomer.phone);
                            break;
                        case 4:
                            System.out.println("Enter your new email");
                            loggedInCustomer.email = S.nextLine();
                            System.out.println("Email updated to: " + loggedInCustomer.email);
                            break;
                        default:
                            System.out.println("INVALID OPTION, TRY AGAIN");
                    }
                    break;

                case 4:
                    deposit();
                    break;
                case 5:
                    withdraw();
                    break;
                case 6:
                    transfer();
                    break;
                case 7:
                    CheckBalance();
                    break;
                case 0:
                    inCustomerMenu = false;
                    break;
                default:
                    System.out.println("INVALID OPTION, TRY AGAIN");
            }
        }
    }

    
    public static void main(String[] args) {
         loadCustomers();
        MainMenu();
    }
}
    

import java.util.Scanner;

public class BankAccount {
    // a. Create a BankAccount class with private instance variables:
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    // a. Create a static variable totalAccounts (int) to count all accounts created
    private static int totalAccounts = 0;

    // d. Create static method: generateAccountNumber()
    public static String generateAccountNumber() {
        totalAccounts++;
        return String.format("ACC%03d", totalAccounts);
    }
    
    // b. Create a constructor that takes account holder name and initial deposit
    public BankAccount(String accountHolderName, double initialDeposit) {
        this.accountNumber = generateAccountNumber();
        this.accountHolderName = accountHolderName;
        this.balance = (initialDeposit > 0) ? initialDeposit : 0;
        System.out.println("New account created for " + this.accountHolderName + " with Account Number " + this.accountNumber);
    }

    // c. Create instance method: deposit(double amount)
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("Deposited %.2f. New balance for %s: %.2f%n", amount, accountNumber, balance);
        } else {
            System.out.println("Invalid deposit amount. Amount must be positive.");
        }
    }

    // c. Create instance method: withdraw(double amount)
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.printf("Withdrew %.2f. New balance for %s: %.2f%n", amount, accountNumber, balance);
        } else if (amount > balance) {
            System.out.println("Insufficient funds for withdrawal.");
        } else {
            System.out.println("Invalid withdrawal amount. Amount must be positive.");
        }
    }

    // c. Create instance method: checkBalance()
    public double checkBalance() {
        return balance;
    }

    // d. Create static method: getTotalAccounts()
    public static int getTotalAccounts() {
        return totalAccounts;
    }

    // e. Create a method displayAccountInfo()
    public void displayAccountInfo() {
        System.out.println("----------------------------------------");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.printf("Balance: %.2f%n", balance);
        System.out.println("----------------------------------------");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // f. Create an array of BankAccount objects (without collection classes)
        int maxAccounts = 5; // A fixed-size array
        BankAccount[] accounts = new BankAccount[maxAccounts];
        int accountCount = 0; // To track the number of accounts in the array

        // Demonstrate creating multiple accounts
        System.out.println("--- Creating New Bank Accounts ---");
        if (accountCount < maxAccounts) {
            System.out.print("Enter name for account 1: ");
            String name1 = scanner.nextLine();
            BankAccount acc1 = new BankAccount(name1, 500.0);
            accounts[accountCount++] = acc1;
        }

        if (accountCount < maxAccounts) {
            System.out.print("Enter name for account 2: ");
            String name2 = scanner.nextLine();
            BankAccount acc2 = new BankAccount(name2, 1200.0);
            accounts[accountCount++] = acc2;
        }
        System.out.println();

        // Demonstrate transactions
        System.out.println("--- Performing Transactions ---");
        accounts[0].deposit(150.0);
        accounts[1].withdraw(250.0);
        accounts[0].withdraw(700.0); // Insufficient funds scenario
        accounts[1].deposit(50.0);
        System.out.println();

        // Show account details
        System.out.println("--- All Account Information ---");
        for (int i = 0; i < accountCount; i++) {
            accounts[i].displayAccountInfo();
        }
        System.out.println();

        // Showing the difference between static and instance variables
        System.out.println("--- Demonstrating Static vs. Instance Variables ---");
        System.out.println("Total accounts created (static): " + BankAccount.getTotalAccounts());
        
        System.out.println("\nCreating a third account...");
        if (accountCount < maxAccounts) {
            System.out.print("Enter name for account 3: ");
            String name3 = scanner.nextLine();
            BankAccount acc3 = new BankAccount(name3, 800.0);
            accounts[accountCount++] = acc3;
        }

        System.out.println("\nAfter creating a new account:");
        System.out.println("Total accounts created (static): " + BankAccount.getTotalAccounts());
        System.out.println("Total accounts via an object (not recommended): " + accounts[0].getTotalAccounts());
        
        System.out.println("\nCheck balance for account 1 (instance variable): " + accounts[0].checkBalance());
        System.out.println("Check balance for account 2 (instance variable): " + accounts[1].checkBalance());
        
        scanner.close();
    }
}

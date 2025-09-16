import java.util.Random;

public class BankAccount {
    String accountHolder;
    int accountNumber;
    double balance;

    // Default constructor → balance = 0.
    public BankAccount() {
        this.accountHolder = "Unknown";
        this.accountNumber = generateRandomAccountNumber();
        this.balance = 0.0;
    }

    // Constructor with name → assigns random account number.
    public BankAccount(String accountHolder) {
        this.accountHolder = accountHolder;
        this.accountNumber = generateRandomAccountNumber();
        this.balance = 0.0; // Default balance
    }

    // Constructor with name and initial balance → assigns both.
    public BankAccount(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.accountNumber = generateRandomAccountNumber();
        this.balance = initialBalance;
    }

    // Helper method to generate a random 6-digit account number
    private int generateRandomAccountNumber() {
        Random random = new Random();
        return 100000 + random.nextInt(900000); // Generates a number between 100000 and 999999
    }

    // deposit(double amount)
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: ₹" + String.format("%.2f", amount));
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // withdraw(double amount)
    public void withdraw(double amount) {
        if (amount > 0) {
            if (balance >= amount) {
                balance -= amount;
                System.out.println("Withdrew: ₹" + String.format("%.2f", amount));
            } else {
                System.out.println("Insufficient balance for withdrawal.");
            }
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }

    // displayAccount()
    public void displayAccount() {
        System.out.println("--- Bank Account Details ---");
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: ₹" + String.format("%.2f", balance));
        System.out.println("----------------------------\n");
    }

    public static void main(String[] args) {
        // Create accounts
        BankAccount account1 = new BankAccount(); // Default constructor
        BankAccount account2 = new BankAccount("Garv Rahut"); // Constructor with name
        BankAccount account3 = new BankAccount("Alice Smith", 1500.75); // Constructor with name and initial balance

        // Display initial account details
        System.out.println("--- Initial Account States ---");
        account1.displayAccount();
        account2.displayAccount();
        account3.displayAccount();

        // Perform operations on account2
        System.out.println("--- Operations on Garv Rahut's Account ---");
        account2.deposit(500.00);
        account2.displayAccount();
        account2.withdraw(100.50);
        account2.displayAccount();
        account2.withdraw(1000.00); // Attempt to withdraw more than balance
        account2.displayAccount();

        // Perform operations on account3
        System.out.println("--- Operations on Alice Smith's Account ---");
        account3.deposit(250.25);
        account3.displayAccount();
        account3.withdraw(2000.00); // Attempt to withdraw more than balance
        account3.displayAccount();
        account3.withdraw(500.00);
        account3.displayAccount();
    }
}

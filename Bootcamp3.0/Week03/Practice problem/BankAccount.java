public class BankAccount {
    // TODO: Create static variables:
    // - bankName (String) - same for all accounts
    // - totalAccounts (int) - count of all accounts created
    // - interestRate (double) - same rate for all accounts
    private static String bankName;
    private static int totalAccounts = 0; // Initialize to 0
    private static double interestRate;

    // TODO: Create instance variables:
    // - accountNumber (String) - unique for each account
    // - accountHolder (String) - unique for each account
    // - balance (double) - unique for each account
    private String accountNumber;
    private String accountHolder;
    private double balance;

    // TODO: Create constructor that:
    // - Initializes instance variables
    // - Increments totalAccounts counter
    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        totalAccounts++; // Increment the static counter for each new object
    }

    // TODO: Create static methods:
    public static void setBankName(String name) {
        bankName = name;
    }

    public static void setInterestRate(double rate) {
        interestRate = rate;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public static void displayBankInfo() {
        System.out.println("Bank Name: " + bankName);
        System.out.println("Total Accounts: " + totalAccounts);
        System.out.println("Current Interest Rate: " + interestRate + "%");
    }

    // TODO: Create instance methods:
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited " + amount + " into account " + accountNumber);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Withdrew " + amount + " from account " + accountNumber);
        } else {
            System.out.println("Insufficient funds or invalid amount for account " + accountNumber);
        }
    }

    public double calculateInterest() {
        // Uses the static interestRate
        return balance * (interestRate / 100);
    }

    public void displayAccountInfo() {
        System.out.println("---------------------------------");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Current Balance: " + balance);
        System.out.println("Interest Rate: " + interestRate + "% (shared)");
    }

    public static void main(String[] args) {
        // TODO: Set bank name and interest rate using static methods
        BankAccount.setBankName("My Awesome Bank");
        BankAccount.setInterestRate(2.5);

        // TODO: Show initial bank info (static) before creating any accounts
        System.out.println("--- Initial Bank Information ---");
        BankAccount.displayBankInfo();
        System.out.println();

        // TODO: Create multiple BankAccount objects
        BankAccount account1 = new BankAccount("A101", "Alice", 1000.0);
        BankAccount account2 = new BankAccount("A102", "Bob", 500.0);

        // TODO: Demonstrate that instance members are unique to each object
        System.out.println("--- Demonstrating Instance Members (Unique) ---");
        account1.displayAccountInfo();
        account2.displayAccountInfo();
        System.out.println();

        // Perform some transactions
        account1.deposit(200.0);
        account2.withdraw(50.0);
        System.out.println();

        // Display updated info
        System.out.println("--- Updated Account Information ---");
        account1.displayAccountInfo();
        account2.displayAccountInfo();
        System.out.println();

        // TODO: Show that static members are shared across all objects
        System.out.println("--- Demonstrating Shared Static Members ---");
        System.out.println("Changing interest rate using account1...");
        BankAccount.setInterestRate(3.0);
        System.out.println("Displaying updated info through account2:");
        account2.displayAccountInfo();
        System.out.println();
        
        System.out.println("Interest for account1 is now: " + account1.calculateInterest());
        System.out.println();

        // TODO: Demonstrate calling static methods with and without objects
        System.out.println("--- Calling static methods ---");
        // Using the class name (preferred and best practice)
        BankAccount.displayBankInfo();

        // Can also be called through an object, but this is discouraged
        System.out.println("--- Total accounts via an object (discouraged) ---");
        System.out.println("Total Accounts: " + account1.getTotalAccounts());
    }
}

import java.util.UUID;


public class PersonalAccount {
    // Instance variables: unique to each account object
    private String accountHolderName;
    private String accountNumber;
    private double currentBalance;
    private double totalIncome;
    private double totalExpenses;

    // Static variables: shared across all PersonalAccount objects
    private static int totalAccounts = 0;
    public static String bankName;


    public PersonalAccount(String accountHolderName, double initialBalance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = generateAccountNumber();
        this.currentBalance = initialBalance;
        this.totalIncome = 0.0;
        this.totalExpenses = 0.0;
        
        // Increment the static counter for every new account
        totalAccounts++;
    }


    public static void setBankName(String name) {
        bankName = name;
    }

    
    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public static String generateAccountNumber() {
        return "ACC-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    
    public void addIncome(double amount, String description) {
        if (amount > 0) {
            this.currentBalance += amount;
            this.totalIncome += amount;
            System.out.printf("Added income of $%.2f for '%s'. New balance: $%.2f%n", amount, description, this.currentBalance);
        } else {
            System.out.println("Income amount must be positive.");
        }
    }


    public void addExpense(double amount, String description) {
        if (amount > 0) {
            this.currentBalance -= amount;
            this.totalExpenses += amount;
            System.out.printf("Added expense of $%.2f for '%s'. New balance: $%.2f%n", amount, description, this.currentBalance);
        } else {
            System.out.println("Expense amount must be positive.");
        }
    }

 
    public double calculateSavings() {
        return this.totalIncome - this.totalExpenses;
    }

   
    public void displayAccountSummary() {
        System.out.println("--------------------------------------------------");
        System.out.println("Bank Name: " + bankName); // Uses the static variable
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.printf("Current Balance: $%.2f%n", currentBalance);
        System.out.printf("Total Income: $%.2f%n", totalIncome);
        System.out.printf("Total Expenses: $%.2f%n", totalExpenses);
        System.out.printf("Total Savings: $%.2f%n", calculateSavings());
        System.out.println("--------------------------------------------------");
    }
}

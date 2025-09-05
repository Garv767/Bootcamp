public class FinanceManager {
    public static void main(String[] args) {
        // Set the bank name using the static method
        PersonalAccount.setBankName("Secure Finance Bank");

        // Create at least 3 different personal accounts
        PersonalAccount account1 = new PersonalAccount("Alice", 1500.0);
        PersonalAccount account2 = new PersonalAccount("Bob", 800.0);
        PersonalAccount account3 = new PersonalAccount("Charlie", 2500.0);

        // Perform various transactions
        System.out.println("--- Performing Transactions ---");
        account1.addIncome(500.0, "Monthly Salary");
        account1.addExpense(150.0, "Groceries");
        
        account2.addIncome(200.0, "Freelance Work");
        account2.addExpense(500.0, "Rent");
        
        account3.addIncome(1000.0, "Bonus");
        account3.addExpense(300.0, "Shopping");

        // Display account summaries
        System.out.println("\n--- Account Summaries ---");
        account1.displayAccountSummary();
        account2.displayAccountSummary();
        account3.displayAccountSummary();

        // Demonstrate the difference between static and instance variables
        System.out.println("\n--- Demonstrating Static vs. Instance Variables ---");
        
        // Static variable: totalAccounts is shared and correctly reflects all accounts
        System.out.println("Total Accounts Created (static): " + PersonalAccount.getTotalAccounts());
        
        // Static variable: bankName is shared across all objects
        System.out.println("Bank Name is: " + PersonalAccount.bankName);
        System.out.println("Changing bank name via a static method...");
        PersonalAccount.setBankName("New Secure Finance Bank");
        System.out.println("New Bank Name (accessed via class): " + PersonalAccount.bankName);
        
        System.out.println("\n--- Re-displaying Account Summaries to show new bank name ---");
        account1.displayAccountSummary();
        
        // Instance variables: individual balances are unique
        System.out.println("\nIndividual balances are unique to each object:");
        System.out.printf("Alice's current balance: $%.2f%n", account1.calculateSavings());
        System.out.printf("Bob's current balance: $%.2f%n", account2.calculateSavings());
        System.out.printf("Charlie's current balance: $%.2f%n", account3.calculateSavings());
    }
}

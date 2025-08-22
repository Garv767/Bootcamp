import java.util.Scanner; // Import Scanner class for user input
public class Q5 {
public static void main(String[] args) {
// Create a Scanner object to take user input
Scanner scanner = new Scanner(System.in);
// Prompt the user to enter the unit price
System.out.print("Enter the unit price of the item in INR: ");
float unitPrice = scanner.nextFloat();


System.out.print("Enter the quantity to be bought: ");
int quantity = scanner.nextInt();
// Calculate the total price
float totalPrice = unitPrice * quantity;
// Display the result
System.out.println("The total purchase price is INR " + totalPrice + " if the quantity is " + quantity + " and the unit price is INR " + unitPrice + ".");


}

}
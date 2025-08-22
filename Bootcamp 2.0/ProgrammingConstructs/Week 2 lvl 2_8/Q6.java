import java.util.Scanner; // Import Scanner class for user input
public class Q6 {
public static void main(String[] args) {
// Create a Scanner object to take user input
Scanner scanner = new Scanner(System.in);
// Prompt the user to enter two numbers
System.out.print("Enter the first number: ");
int number1 = scanner.nextInt();
System.out.print("Enter the second number: ");
int number2 = scanner.nextInt();
// Calculate quotient and remainder
int quotient = number1 / number2;
int remainder = number1 % number2;
// Display the result
System.out.println("The Quotient is " + quotient + " and Remainder is " + remainder
+ " of two numbers " + number1 + " and " + number2 + ".");

}
}
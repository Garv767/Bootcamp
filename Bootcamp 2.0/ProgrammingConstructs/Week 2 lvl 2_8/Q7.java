import java.util.Scanner; // Import Scanner class for user input
public class Q7 {
public static void main(String[] args) {
// Create a Scanner object to take user input
Scanner scanner = new Scanner(System.in);
// Prompt the user to enter three integers
System.out.print("Enter the first number (a): ");

int a = scanner.nextInt();
System.out.print("Enter the second number (b): ");
int b = scanner.nextInt();
System.out.print("Enter the third number (c): ");
int c = scanner.nextInt();
// Perform integer operations considering operator precedence
int result1 = a + b * c; // Multiplication has higher precedence than addition
int result2 = a * b + c; // Multiplication first, then addition
int result3 = c + a / b; // Division first, then addition
int result4 = a % b + c; // Modulus first, then addition
// Display the results
System.out.println("The results of Int Operations are " + result1 + ", " + result2 + ", "+ result3 + " and " + result4 + ".");
}
}

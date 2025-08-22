import java.util.Scanner; // Import Scanner class for user input
public class Q8{
public static void main(String[] args) {
// Create a Scanner object to take user input
Scanner scanner = new Scanner(System.in);
// Prompt the user to enter three double values
System.out.print("Enter the first number (a): ");
double a = scanner.nextDouble();
System.out.print("Enter the second number (b): ");
double b = scanner.nextDouble();
System.out.print("Enter the third number (c): ");
double c = scanner.nextDouble();
// Perform double precision operations considering operator precedence
double result1 = a + b * c; // Multiplication has higher precedence than addition
double result2 = a * b + c; // Multiplication first, then addition
double result3 = c + a / b; // Division first, then addition
double result4 = a % b + c; // Modulus first, then addition
// Display the results
System.out.println("The results of Double Operations are " + result1 + ", " + result2
+ ", " + result3 + " and " + result4 + ".");
}
}

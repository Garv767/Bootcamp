import java.util.Scanner;

public class Q10_Calculator {

    public static void main(String[] args)

    {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        if (!input.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid number.");
            input.close();
            return;
        }
        double first = input.nextDouble();

        System.out.print("Enter the second number: ");
        if (!input.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid number.");
            input.close();
            return;
        }
        double second = input.nextDouble();

        System.out.print("Enter the operator (+, -, *, /): ");
        String op = input.next();

        double result;

        switch (op) {
            case "+":
                result = first + second;
                break;
            case "-":
                result = first - second;
                break;
            case "*":
                result = first * second;
                break;
            case "/":
                if (second == 0) {
                    System.out.println("Cannot divide by zero.");
                    input.close();
                    return;
                }
                result = first / second;
                break;
            default:
                System.out.println("Invalid operator.");
                input.close();
                return; // Exit the program if the operator is invalid
        }

        System.out.println("Result: " + result);

        input.close();
    }
}
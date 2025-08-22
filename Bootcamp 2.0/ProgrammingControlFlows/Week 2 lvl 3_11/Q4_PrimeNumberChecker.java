import java.util.Scanner;

public class Q4_PrimeNumberChecker {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number to check for primality: ");

        if (!input.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            input.close();
            return;
        }


        int number = input.nextInt();

        if (number <= 1) {
            System.out.println("A number must be greater than 1 to be prime.");
            input.close();
            return;
        }

        boolean isPrime = true; // Assume it's prime initially

        for (int i = 2; i <= Math.sqrt(number); i++) { // Optimized loop: Check up to sqrt(n)
            if (number % i == 0) {
                isPrime = false; // Found a divisor, so it's not prime
                break; // Exit the loop – no need to check further
            }
        }

        if (isPrime) {
            System.out.println(number + " is a prime number.");
        } else {
            System.out.println(number + " is not a prime number.");
        }

        input.close();
    }
}
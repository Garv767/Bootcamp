import java.util.Scanner;

public class Q10_MultiplesBelow100 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");

        if (!input.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            input.close();
            return;
        }

        int number = input.nextInt();

        if (number <= 0) {
            System.out.println("Please enter a positive integer.");
            input.close();
            return;
        }

        System.out.println("Multiples of " + number + " below 100 are:");

        for (int i = 1; i < 100; i++) {
            if (i % number == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println(); // New line for better formatting

        input.close();
    }
}
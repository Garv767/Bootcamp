import java.util.Scanner;

public class Q4_ArraySum {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double[] numbers = new double[10];
        double total = 0.0;
        int index = 0;

        while (true) {
            System.out.print("Enter a number (0 or negative to stop): ");

            if (!input.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a number.");
                input.next(); // Clear invalid input
                continue;
            }

            double number = input.nextDouble();

            if (number <= 0 || index == 10) {
                break;
            }

            numbers[index] = number;
            index++;
        }

        System.out.println("\nEntered numbers:");
        for (int i = 0; i < index; i++) {
            System.out.print(numbers[i] + " ");
            total += numbers[i];
        }

        System.out.println("\nTotal: " + total);

        input.close();
    }
}
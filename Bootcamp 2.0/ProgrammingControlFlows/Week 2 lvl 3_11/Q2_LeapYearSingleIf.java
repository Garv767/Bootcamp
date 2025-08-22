import java.util.Scanner;

public class Q2_LeapYearSingleIf {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a year (>= 1582): ");

        if (!input.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            input.close();
            return;
        }

        int year = input.nextInt();

        if (year < 1582) {
            System.out.println("Leap year calculation only applies to years >= 1582.");
            input.close();
            return;
        }

        // Single if statement with logical operators
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            System.out.println(year + " is a Leap Year.");
        } else {
            System.out.println(year + " is not a Leap Year.");
        }

        input.close();
    }
}
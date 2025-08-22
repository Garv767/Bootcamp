import java.util.Scanner;

public class Q1_LeapYear {

    public static void main(String[] args)
    {
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

        // Part 1: Multiple if-else statements
        //System.out.println("\nUsing multiple if-else statements:");
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    System.out.println(year + " is a Leap Year.");
                } else {
                    System.out.println(year + " is not a Leap Year.");
                }
            } else {
                System.out.println(year + " is a Leap Year.");
            }
        } else {
            System.out.println(year + " is not a Leap Year.");
        }

        /* Part 2: Single if statement with logical operators
        System.out.println("\nUsing a single if statement with logical operators:");
        if ((year % 4 == 0 && year % 100!= 0) || (year % 400 == 0)) {
            System.out.println(year + */

            input.close();
    }
}

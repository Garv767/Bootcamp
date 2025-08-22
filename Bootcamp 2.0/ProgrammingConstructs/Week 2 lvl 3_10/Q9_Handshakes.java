import java.util.Scanner;

public class Q9_Handshakes {

    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numberOfStudents = input.nextInt();

        // Calculate the maximum number of handshakes using the formula
        int maxHandshakes = (numberOfStudents * (numberOfStudents - 1)) / 2;

        // Display the result
        System.out.println("The maximum number of possible handshakes is: " + maxHandshakes);

        input.close(); // Close the scanner
    }
}
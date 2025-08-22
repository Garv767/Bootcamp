import java.util.Scanner;

public class Q1_VotingEligibility {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] studentAges = new int[10]; // Array to store ages of 10 students

        System.out.println("Enter the ages of 10 students:");

        // Input ages for 10 students
        for (int i = 0; i < studentAges.length; i++) {
            System.out.print("Student " + (i + 1) + " age: ");
            if (!input.hasNextInt()) {
                System.out.println("Invalid input. Please enter an integer.");
                input.next(); // Clear the invalid input
                i--; // Decrement i to re-enter the age for the same student
                continue; // Skip to the next iteration
            }
            studentAges[i] = input.nextInt();
        }

        System.out.println("\nVoting Eligibility:");

        // Check voting eligibility for each student
        for (int i = 0; i < studentAges.length; i++) {
            int age = studentAges[i];

            if (age < 0) {
                System.out.println("Student " + (i + 1) + ": Invalid age.");
            } else if (age >= 18) {
                System.out.println("Student " + (i + 1) + " with age " + age + " can vote.");
            } else {
                System.out.println("Student " + (i + 1) + " with age " + age + " cannot vote.");
            }
        }

        input.close();
    }
}
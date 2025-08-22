import java.util.Scanner;

public class StudentVoteEligibility {

    public static boolean canStudentVote(int age) {
        if (age < 0) {
            return false; // Cannot vote if age is negative
        }
        return age >= 18; // Can vote if age is 18 or above
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] studentAges = new int[10];

        System.out.println("Enter the ages of 10 students:");

        for (int i = 0; i < 10; i++) {
            boolean validInput = false;
            while (!validInput) {
                System.out.print("Enter age of student " + (i + 1) + ": ");
                if (input.hasNextInt()) {
                    studentAges[i] = input.nextInt();
                    validInput = true;
                } else {
                    System.out.println("Invalid input. Please enter an integer.");
                    input.next(); // Clear invalid input
                }
            }
        }

        System.out.println("\nVoting Eligibility:");
        for (int i = 0; i < 10; i++) {
            System.out.println("Student " + (i + 1) + ": " + (canStudentVote(studentAges[i]) ? "Can vote" : "Cannot vote"));
        }

        input.close();
    }
}
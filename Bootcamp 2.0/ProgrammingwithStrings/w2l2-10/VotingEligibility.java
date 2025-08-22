import java.util.InputMismatchException;
import java.util.Scanner;

public class VotingEligibility {

    /**
     * Creates an array of random 2-digit ages for a specified number of students.
     *
     * @param numStudents The number of students.
     * @return A 1D array of integers representing the ages of the students.
     * Returns null if numStudents is not positive.
     */
    public static int[] generateRandomAges(int numStudents) {
        if (numStudents <= 0) {
            return null;
        }
        int[] ages = new int[numStudents];
        for (int i = 0; i < numStudents; i++) {
            ages[i] = (int) (Math.random() * 90 + 10); // Generate age between 10 and 99
        }
        return ages;
    }

    /**
     * Determines voting eligibility based on age and returns a 2D array.
     *
     * @param ages An array of student ages.
     * @return A 2D String array where each row contains the age and a boolean
     * ("true" or "false") indicating voting eligibility.
     * Returns null if the input array is null.
     */
    public static String[][] checkVotingEligibility(int[] ages) {
        if (ages == null) {
            return null;
        }
        String[][] eligibility = new String[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            if (ages[i] < 0) {
                eligibility[i][0] = String.valueOf(ages[i]);
                eligibility[i][1] = "false"; // Cannot vote if age is negative
            } else {
                eligibility[i][0] = String.valueOf(ages[i]);
                eligibility[i][1] = (ages[i] >= 18) ? "true" : "false";
            }
        }
        return eligibility;
    }

    /**
     * Displays the voting eligibility information in a tabular format.
     *
     * @param eligibility A 2D String array containing age and eligibility.
     */
    public static void displayEligibility(String[][] eligibility) {
        if (eligibility == null) {
            System.out.println("No eligibility data to display.");
            return;
        }
        System.out.println("Age\tCan Vote");
        System.out.println("------------");
        for (String[] row : eligibility) {
            System.out.println(row[0] + "\t" + row[1]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numStudents = 10;
        int[] studentAges = new int[numStudents];

        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter age for student " + (i + 1) + ": ");
            try {
                studentAges[i] = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer for age.");
                scanner.next(); // Consume the invalid input
                i--; // Repeat the current iteration to get the correct input
            }
        }
        scanner.close();

        String[][] eligibilityList = checkVotingEligibility(studentAges);
        displayEligibility(eligibilityList);
    }
}


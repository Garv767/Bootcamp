import java.util.Scanner;

public class gradeCalculator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of students: ");

        if (!input.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            input.close();
            return;
        }

        int numStudents = input.nextInt();

        if (numStudents <= 0) {
            System.out.println("Please enter a positive integer for the number of students.");
            input.close();
            return;
        }

        int[][] marks = new int[numStudents][3]; // [students][physics, chemistry, maths]
        double[] percentages = new double[numStudents];
        String[] grades = new String[numStudents];

        // Input marks for each student
        for (int i = 0; i < numStudents; i++) {
            boolean validInput = false;
            while (!validInput) {
                System.out.print("Enter Physics marks for student " + (i + 1) + ": ");
                if (!input.hasNextInt()) {
                    System.out.println("Invalid input. Please enter an integer.");
                    input.next();
                    continue;
                }
                int physics = input.nextInt();
                if (physics < 0) {
                    System.out.println("Marks must be non-negative. Please re-enter.");
                    continue;
                }
                marks[i][0] = physics;

                System.out.print("Enter Chemistry marks for student " + (i + 1) + ": ");
                if (!input.hasNextInt()) {
                    System.out.println("Invalid input. Please enter an integer.");
                    input.next();
                    continue;
                }
                int chemistry = input.nextInt();
                if (chemistry < 0) {
                    System.out.println("Marks must be non-negative. Please re-enter.");
                    continue;
                }
                marks[i][1] = chemistry;

                System.out.print("Enter Maths marks for student " + (i + 1) + ": ");
                if (!input.hasNextInt()) {
                    System.out.println("Invalid input. Please enter an integer.");
                    input.next();
                    continue;
                }
                int maths = input.nextInt();
                if (maths < 0) {
                    System.out.println("Marks must be non-negative. Please re-enter.");
                    continue;
                }
                marks[i][2] = maths;

                validInput = true;
            }
        }

        // Calculate percentage and grade
        for (int i = 0; i < numStudents; i++) {
            int totalMarks = marks[i][0] + marks[i][1] + marks[i][2];
            percentages[i] = (double) totalMarks / 3;
            grades[i] = calculateGrade(percentages[i]);
        }

        // Display results
        System.out.println("\nStudent Grades:");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.printf("%-10s %-10s %-10s %-15s %-10s %-40s\n", "Student", "Physics", "Chemistry", "Maths", "Percentage", "Grade and Remarks");
        System.out.println("----------------------------------------------------------------------------------");

        for (int i = 0; i < numStudents; i++) {
            System.out.printf("%-10d %-10d %-10d %-15d %-10.2f %-40s\n", (i + 1), marks[i][0], marks[i][1], marks[i][2], percentages[i], grades[i] + getRemarks(grades[i]));
        }

        input.close();
    }

    public static String calculateGrade(double percentage) {
        if (percentage >= 80) {
            return "A";
        } else if (percentage >= 70) {
            return "B";
        } else if (percentage >= 60) {
            return "C";
        } else if (percentage >= 50) {
            return "D";
        } else if (percentage >= 40) {
            return "E";
        } else {
            return "R";
        }
    }

    public static String getRemarks(String grade) {
        switch (grade) {
            case "A":
                return " (Level 4, above agency-normalized standards)";
            case "B":
                return " (Level 3, at agency-normalized standards)";
            case "C":
                return " (Level 2, below, but approaching agency-normalized standards)";
            case "D":
                return " (Level 1, well below agency-normalized standards)";
            case "E":
                return " (Level 1-, too below agency-normalized standards)";
            case "R":
                return " (Remedial standards)";
            default:
                return "";
        }
    }
}
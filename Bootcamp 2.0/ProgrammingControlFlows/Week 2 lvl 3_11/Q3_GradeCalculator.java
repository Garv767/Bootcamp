import java.util.Scanner;

public class Q3_GradeCalculator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter marks for Physics: ");
        int physicsMarks = input.nextInt();

        System.out.print("Enter marks for Chemistry: ");
        int chemistryMarks = input.nextInt();

        System.out.print("Enter marks for Maths: ");
        int mathsMarks = input.nextInt();

        int totalMarks = physicsMarks + chemistryMarks + mathsMarks;
        double percentage = (double) totalMarks / 3;

        System.out.println("\nTotal Marks: " + totalMarks);
        System.out.println("Average Marks: " + percentage + "%");

        String grade;
        String remarks;

        if (percentage >= 80) {
            grade = "A";
            remarks = "(Level 4, above agency-normalized standards)";
        } else if (percentage >= 70) {
            grade = "B";
            remarks = "(Level 3, at agency-normalized standards)";
        } else if (percentage >= 60) {
            grade = "C";
            remarks = "(Level 2, below, but approaching agency-normalized standards)";
        } else if (percentage >= 50) {
            grade = "D";
            remarks = "(Level 1, well below agency-normalized standards)";
        } else if (percentage >= 40) {
            grade = "E";
            remarks = "(Level 1-, too below agency-normalized standards)";
        } else {
            grade = "R";
            remarks = "(Remedial standards)";
        }

        System.out.println("Grade: " + grade);
        System.out.println("Remarks: " + remarks);

        input.close();
    }
}
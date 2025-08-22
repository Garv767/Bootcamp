import java.util.Scanner;

public class StudentGradeCalculator {

    public static int[][] generateRandomScores(int numStudents) {
        if (numStudents <= 0) {
            return null;
        }
        int[][] scores = new int[numStudents][3];
        for (int i = 0; i < numStudents; i++) {
            scores[i][0] = (int) (Math.random() * 90 + 10);
            scores[i][1] = (int) (Math.random() * 90 + 10);
            scores[i][2] = (int) (Math.random() * 90 + 10);
        }
        return scores;
    }

    public static double[][] calculateStats(int[][] scores) {
        if (scores == null) {
            return null;
        }
        int numStudents = scores.length;
        double[][] stats = new double[numStudents][3];
        for (int i = 0; i < numStudents; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = (double) total / 3;
            double percentage = (average / 100) * 100;

            stats[i][0] = total;
            stats[i][1] = Math.round(average * 100.0) / 100.0;
            stats[i][2] = Math.round(percentage * 100.0) / 100.0;
        }
        return stats;
    }

    public static String[] calculateGrades(double[][] stats) {
        if (stats == null) {
            return null;
        }
        int numStudents = stats.length;
        String[] grades = new String[numStudents];
        for (int i = 0; i < numStudents; i++) {
            double percentage = stats[i][2];
            if (percentage >= 90) {
                grades[i] = "A+";
            } else if (percentage >= 80) {
                grades[i] = "A";
            } else if (percentage >= 70) {
                grades[i] = "B+";
            } else if (percentage >= 60) {
                grades[i] = "B";
            } else if (percentage >= 50) {
                grades[i] = "C";
            } else {
                grades[i] = "Fail";
            }
        }
        return grades;
    }

    public static void displayScorecard(int[][] scores, double[][] stats, String[] grades) {
        if (scores == null || stats == null || grades == null) {
            System.out.println("No data to display.");
            return;
        }
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("Student\tPhysics\tChemistry\tMaths\tTotal\tAverage\tPercentage\tGrade");
        System.out.println("-----------------------------------------------------------------------------------");
        for (int i = 0; i < scores.length; i++) {
            System.out.println((i + 1) + "\t" + scores[i][0] + "\t\t" + scores[i][1] + "\t\t" + scores[i][2] + "\t\t"
                    + (int) stats[i][0] + "\t\t" + stats[i][1] + "\t\t" + stats[i][2] + "\t\t" + grades[i]);
        }
        System.out.println("-----------------------------------------------------------------------------------");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        scanner.close();

        int[][] studentScores = generateRandomScores(numStudents);
        double[][] studentStats = calculateStats(studentScores);
        String[] studentGrades = calculateGrades(studentStats);

        displayScorecard(studentScores, studentStats, studentGrades);
    }
}


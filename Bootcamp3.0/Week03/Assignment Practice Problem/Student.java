import java.util.Arrays;
import java.util.UUID;

public class Student {
    // Instance variables: Unique to each student
    private String studentId;
    private String studentName;
    private String className;
    private Subject[] subjects;
    private double[][] marks; // 2D array: marks[subjectIndex][0]=score, marks[subjectIndex][1]=credit
    private double gpa;
    private int subjectCount;

    // Static variables: Shared across all Student objects
    private static int totalStudents = 0;
    private static String schoolName;
    private static String[] gradingScale; // e.g., {"A", "B", "C", "D", "F"}
    private static double passPercentage;

    public Student(String studentName, String className, Subject[] allSubjects) {
        this.studentId = "ST-" + UUID.randomUUID().toString().substring(0, 4).toUpperCase();
        this.studentName = studentName;
        this.className = className;
        this.subjects = allSubjects;
        this.marks = new double[allSubjects.length][2];
        this.gpa = 0.0;
        this.subjectCount = 0;
        totalStudents++;
    }

    // Static methods
    public static void setSchoolName(String name) {
        schoolName = name;
    }
    
    public static void setGradingScale(String[] scale, double passPct) {
        gradingScale = scale;
        passPercentage = passPct;
    }

    public static double calculateClassAverage(Student[] students, String className) {
        double totalMarks = 0;
        int studentCount = 0;
        for (Student s : students) {
            if (s != null && s.className.equalsIgnoreCase(className)) {
                totalMarks += s.calculateAverageMarks();
                studentCount++;
            }
        }
        return studentCount == 0 ? 0 : totalMarks / studentCount;
    }
    
    public static Student[] getTopPerformers(Student[] students, int count) {
        Student[] sortedStudents = students.clone();
        Arrays.sort(sortedStudents, (s1, s2) -> Double.compare(s2.gpa, s1.gpa));
        return Arrays.copyOf(sortedStudents, Math.min(count, totalStudents));
    }

    // Instance methods
    public void addMarks(String subjectCode, double score) {
        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i] != null && subjects[i].getSubjectCode().equals(subjectCode)) {
                marks[i][0] = score;
                marks[i][1] = subjects[i].getCredits();
                return;
            }
        }
        System.out.println("Subject not found: " + subjectCode);
    }

    public void calculateGPA() {
        double totalPoints = 0;
        int totalCredits = 0;
        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i] != null) {
                totalPoints += getGradePoint(marks[i][0]) * marks[i][1];
                totalCredits += marks[i][1];
            }
        }
        this.gpa = totalCredits == 0 ? 0 : totalPoints / totalCredits;
    }
    
    public String getLetterGrade(double score) {
        if (score >= 90) return "A";
        if (score >= 80) return "B";
        if (score >= 70) return "C";
        if (score >= 60) return "D";
        return "F";
    }

    private double getGradePoint(double score) {
        if (score >= 90) return 4.0;
        if (score >= 80) return 3.0;
        if (score >= 70) return 2.0;
        if (score >= 60) return 1.0;
        return 0.0;
    }
    
    private double calculateAverageMarks() {
        double sum = 0;
        int count = 0;
        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i] != null) {
                sum += marks[i][0];
                count++;
            }
        }
        return count == 0 ? 0 : sum / count;
    }

    public void generateReportCard() {
        System.out.println("--- Report Card ---");
        System.out.println("School: " + schoolName);
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + studentName);
        System.out.println("Class: " + className);
        System.out.println("--------------------");
        System.out.printf("%-20s %-10s %-10s%n", "Subject", "Marks", "Grade");
        System.out.println("----------------------------------------");
        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i] != null) {
                System.out.printf("%-20s %-10.2f %-10s%n",
                    subjects[i].getSubjectName(), marks[i][0], getLetterGrade(marks[i][0]));
            }
        }
        System.out.println("----------------------------------------");
        System.out.printf("Final GPA: %.2f%n", gpa);
        System.out.println("Promotion Status: " + (checkPromotionEligibility() ? "Eligible" : "Not Eligible"));
        System.out.println("-----------------------------------");
    }
    
    public boolean checkPromotionEligibility() {
        double totalScore = 0;
        int totalSubjects = 0;
        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i] != null) {
                totalScore += marks[i][0];
                totalSubjects++;
            }
        }
        return (totalScore / totalSubjects) >= passPercentage;
    }
}

import java.util.UUID;
import java.util.Scanner;

public class SchoolSystem {
    private static Student[] allStudents;
    private static int studentCount = 0;
    private static Subject[] allSubjects;
    
    public static void main(String[] args) {
        // Setup initial static data
        Student.setSchoolName("Springfield High School");
        Student.setGradingScale(new String, 60.0);
        
        // Initialize subjects
        allSubjects = new Subject;
        allSubjects = new Subject("Math", 4, "Ms. Davis");
        allSubjects = new Subject("Physics", 4, "Mr. Smith");
        allSubjects = new Subject("English", 3, "Ms. Johnson");
        allSubjects = new Subject("History", 3, "Mr. Brown");
        
        // Initialize students
        allStudents = new Student;
        
        addStudent("Alice", "10A");
        addStudent("Bob", "10A");
        addStudent("Charlie", "10B");
        addStudent("Diana", "10B");

        // Add marks for students
        allStudents.addMarks(allSubjects.getSubjectCode(), 85.0);
        allStudents.addMarks(allSubjects.getSubjectCode(), 92.0);
        allStudents.addMarks(allSubjects.getSubjectCode(), 78.0);
        allStudents.addMarks(allSubjects.getSubjectCode(), 88.0);
        
        allStudents.addMarks(allSubjects.getSubjectCode(), 75.0);
        allStudents.addMarks(allSubjects.getSubjectCode(), 80.0);
        allStudents.addMarks(allSubjects.getSubjectCode(), 65.0);
        allStudents.addMarks(allSubjects.getSubjectCode(), 72.0);
        
        allStudents.addMarks(allSubjects.getSubjectCode(), 95.0);
        allStudents.addMarks(allSubjects.getSubjectCode(), 88.0);
        allStudents.addMarks(allSubjects.getSubjectCode(), 80.0);
        allStudents.addMarks(allSubjects.getSubjectCode(), 85.0);

        // Calculate GPA for all students
        for(Student student : allStudents) {
            if (student != null) {
                student.calculateGPA();
            }
        }

        System.out.println("--- Individual Student Reports ---");
        for(Student student : allStudents) {
            if (student != null) {
                student.generateReportCard();
            }
        }
        
        System.out.println("--- School-wide Reports ---");
        generateSchoolReport();
    }
    
    private static void addStudent(String name, String className) {
        if (studentCount < allStudents.length) {
            allStudents[studentCount++] = new Student(name, className, allSubjects);
        }
    }

    private static void generateSchoolReport() {
        System.out.println("--- " + Student.schoolName + " School Report ---");
        System.out.println("Total Students: " + Student.totalStudents);
        System.out.printf("Average for Class 10A: %.2f%n", Student.calculateClassAverage(allStudents, "10A"));
        System.out.printf("Average for Class 10B: %.2f%n", Student.calculateClassAverage(allStudents, "10B"));
        
        System.out.println("\n--- Top Performers ---");
        Student[] topPerformers = Student.getTopPerformers(allStudents, 2);
        for(Student s : topPerformers) {
            s.generateReportCard();
        }
    }
}

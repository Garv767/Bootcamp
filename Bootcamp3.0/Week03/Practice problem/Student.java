public class Student {
    // TODO: Define private instance variables:
    private String studentId;
    private String name;
    private double grade;
    private String course;

    // TODO: Create a default constructor (no parameters)
    public Student() {
        // Initializes with default or empty values
        this.studentId = "";
        this.name = "";
        this.grade = 0.0;
        this.course = "";
    }

    // TODO: Create a parameterized constructor that accepts all attributes
    public Student(String studentId, String name, double grade, String course) {
        this.studentId = studentId;
        this.name = name;
        this.grade = grade;
        this.course = course;
    }

    // TODO: Create getter and setter methods for all attributes
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    // TODO: Create a method calculateLetterGrade() that returns:
    // A (90-100), B (80-89), C (70-79), D (60-69), F (below 60)
    public char calculateLetterGrade() {
        if (grade >= 90) {
            return 'A';
        } else if (grade >= 80) {
            return 'B';
        } else if (grade >= 70) {
            return 'C';
        } else if (grade >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }

    // TODO: Create a method displayStudent() that shows all information
    public void displayStudent() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Course: " + course);
        System.out.println("Grade: " + grade + " (" + calculateLetterGrade() + ")");
    }

    public static void main(String[] args) {
        // TODO: Create one student using default constructor, then set values
        Student student1 = new Student();
        student1.setStudentId("S101");
        student1.setName("Alice");
        student1.setCourse("Computer Science");
        student1.setGrade(95.5);

        // TODO: Create another student using parameterized constructor
        Student student2 = new Student("S102", "Bob", 82.0, "Electrical Engineering");

        System.out.println("--- Student 1 Details ---");
        student1.displayStudent();
        System.out.println();

        System.out.println("--- Student 2 Details ---");
        student2.displayStudent();
        System.out.println();

        // TODO: Demonstrate all getter/setter methods
        System.out.println("--- Demonstrating Getters and Setters ---");
        System.out.println("Before update, Student 1's grade is: " + student1.getGrade());
        student1.setGrade(88.0);
        System.out.println("After update, Student 1's grade is: " + student1.getGrade());
        System.out.println("Student 1's new letter grade: " + student1.calculateLetterGrade());
        System.out.println();

        // Show both students' information and letter grades after the changes
        System.out.println("--- All Students' Information (Updated) ---");
        student1.displayStudent();
        System.out.println();
        student2.displayStudent();
    }
}

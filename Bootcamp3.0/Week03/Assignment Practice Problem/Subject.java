import java.util.UUID;

public class Subject {
    private String subjectCode;
    private String subjectName;
    private int credits;
    private String instructor;
    
    public Subject(String subjectName, int credits, String instructor) {
        this.subjectCode = UUID.randomUUID().toString().substring(0, 4).toUpperCase();
        this.subjectName = subjectName;
        this.credits = credits;
        this.instructor = instructor;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public int getCredits() {
        return credits;
    }
    
    public String getInstructor() {
        return instructor;
    }
}

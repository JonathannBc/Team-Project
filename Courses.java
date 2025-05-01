/*
 * 
 * This class represents a course with a code and a grade.
 * It is used in the Student class to store the courses taken by a student.
 */
public class Courses {
    private String code;
    private double grade;

    // Constructor
    // The constructor initializes the course code and grade.
    public Courses(String code, double grade) {
        this.code = code;
        this.grade = grade;
    }
    
    public String getCode() {
        return code;
    }
    public double getGrade() {
        return grade;
    }
}

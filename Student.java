
import java.util.List;

public abstract class Student implements Comparable<Student> {
    

    protected String name;
    protected int id;
    protected List<Courses> courses;


    public Student(String name, int id, List<Courses> courses) {
        this.name = name;
        this.id = id;
        this.courses = courses;
    }
    public abstract String getType();

    public double getGPA() {
        double totalPoints = 0;
    
        // Sum up all grades for the student
        for (Courses c : courses) {
            totalPoints += c.getGrade();  
        }
        if (courses.size() == 0) {
            return 0;
        } else {
            return totalPoints / courses.size();
        }    }
    public void display(){
        System.out.println(getType() + " Student: " + name + " (ID: " + id + ")");
        System.out.println("Courses & Grades:");
        for (Courses c : courses) {
            System.out.println(" - " + c.getCode() + ": " + c.getGrade());
        }
        System.out.printf("GPA: %.2f\n", getGPA());
    }   

    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }
    public int compareTo(Student other) {
        // Compare by name alphabetically
        return this.name.compareToIgnoreCase(other.name);
    }
}

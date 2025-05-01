
import java.util.List;

public abstract class Student{
    

    protected String name;
    protected int id;
    protected List<Courses> courses;


    public Student(String name, int id, List<Courses> courses) {
        this.name = name;
        this.id = id;
        this.courses = courses;
    }
    public abstract String getType();

    public double getGPA(){
        double totalPoints = 0;
        int totalCredits =0;
        
        for (Courses c : courses){
            totalPoints += c.getGrade()*4;
            totalCredits += 4;
        }
        return totalCredits == 0 ? 0 : totalPoints / totalCredits;
    }
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
}

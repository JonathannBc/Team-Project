import java.util.List;

/*  This class represents an undergraduate student
 It extends the Student class and 
 provides a specific implementation for the getType method
 getType method returns the string "Undergraduate" to indicate the type of student
 */
public class Undergrad extends Student {
    public Undergrad(String name, int id, List<Courses> courses) {
        super(name, id, courses);
    }
    @Override
    public String getType() {
        return "Undergraduate";
    }
}


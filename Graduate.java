import java.util.List;

/*
 * 
 * This class represents a Graduate student and
 * It extends the Student class  
 * getType method returns "Graduate" as the type of student.
 */
public class Graduate extends Student{

    public Graduate(String name, int id, List<Courses> courses) {
        super(name, id, courses);
    }
    @Override
    public String getType() {
        return "Graduate";
    }
    
}

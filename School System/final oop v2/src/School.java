
import java.util.ArrayList;


/**
 *
 * @author ahmed
 */
public class School {
private String Name ;
    private ArrayList<Student>student=new ArrayList<>();
    private ArrayList<Employee>employee=new ArrayList<>();
        private ArrayList<Course>course=new ArrayList<>();

            private ArrayList<Teacher>teacher=new ArrayList<>();
                private ArrayList<Classes>classes=new ArrayList<>();

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = Name;
    }

    public ArrayList<Student> getStudent() {
        return student;
    }

    public void setStudent(ArrayList<Student> student) {
        this.student = student;
    }

    public ArrayList<Employee> getEmplyee() {
        return emplyee;
    }

    public void setEmplyee(ArrayList<Employee> emplyee) {
        this.emplyee = emplyee;
    }

    public ArrayList<Course> getCourse() {
        return course;
    }

    public void setCourse(ArrayList<Course> course) {
        this.course = course;
    }

    public ArrayList<Teacher> getTeacher() {
        return teacher;
    }

    public void setTeacher(ArrayList<Teacher> teacher) {
        this.teacher = teacher;
    }

    public ArrayList<Classes> getClasses() {
        return classes;
    }

    public void setClasses(ArrayList<Classes> classes) {
        this.classes = classes;
    }
@Override
    public String toString(){
     return "name of the school"+this.getName()+"/n"+
            "number of student "+student.size()+"/n"+
            "number of classes "+classes.size()+"/n"+
            "number of teacher"+teacher.size()+"/n"+
            "number of employee"+employee.size()+"/n";
    
    
    
}

    
    
}

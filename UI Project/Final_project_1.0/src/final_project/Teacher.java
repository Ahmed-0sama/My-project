package final_project;
import java.util.*;

public class Teacher extends Person {
    private static int teachersCount = 0;
    private int teacherID;
    ArrayList<Course> courses = new ArrayList<>();
    
    // Constructor
    public Teacher(String name) {
        super(name);
        teachersCount++;
        this.teacherID = teachersCount;
    }

    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }

    public void addCourse(Course course){
        courses.add(course);
    }
    
    public ArrayList<Course> getCourses(){
        return courses;
    }
    
    @Override
   public String toString() {
        return ("\r\n" +"-----------------------" + "\r\n" +
                    "Teacher name: "+ super.getName()+
                    " - Teacher ID: "+ this.getTeacherID() );
   }
    
    }

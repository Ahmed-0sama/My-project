package final_project;
import java.util.*;
public class Student extends Person {
    
    private int studentID;
    private static int studentsCount = 0;
    private ArrayList<Course> courses = new ArrayList<>();

    // Constructor
    public Student(String name) {
        super(name);
        studentsCount++;
        this.studentID = studentsCount;
    }
    
    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }


    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public static int getStudentsCount() {
        return studentsCount;
    }

    public static void setStudentsCount(int studentsCount) {
        Student.studentsCount = studentsCount;
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
                    "Student name: "+ super.getName() + "\r\n" +
                    "Student ID: "+ this.getStudentID());
   }
    
}

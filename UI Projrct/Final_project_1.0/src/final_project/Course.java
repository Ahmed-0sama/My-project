package final_project;
public class Course {
    
    private String courseName;
    private int courseID;
    private static int coursesCount = 0;

    // Constructor
    public Course(String courseName) {
        this.courseName = courseName;
        coursesCount++;
        this.courseID = coursesCount;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }
    
    @Override
   public String toString() {
        return ("\r\n" +"-----------------------" + "\r\n" +
                    "Course name: "+this.getCourseName()+
                    " - Course ID: "+ this.getCourseID() );
   }
    
}

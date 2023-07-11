package final_project;
import java.util.*;
public class School {
    
    private String name;
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Course> courses = new ArrayList<>();
    private ArrayList<Teacher> teachers = new ArrayList<>();
    private ArrayList<Employee> employees = new ArrayList<>();
    private ArrayList<Class> classes = new ArrayList<>();
    
    // Constructor
    public School(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(ArrayList<Teacher> teachers) {
        this.teachers = teachers;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public ArrayList<Class> getClasses() {
        return classes;
    }

    public void setClasses(ArrayList<Class> classes) {
        this.classes = classes;
    }
    
    // Add a course
    public void addNewCourse(Scanner sc, School school){
        System.out.println("Please enter the course name");
        String courseName = sc.nextLine();
        school.courses.add( new Course( courseName));
        System.out.println("Course has been added!");
    }
    
    // Add a student
    public void addNewStudent(Scanner sc, School school){
        System.out.println("Please enter the student name");
        String studentName = sc.nextLine();
        school.students.add( new Student( studentName));
        System.out.println("Student has been added!");
    }

    // Add a teacher
    public void addNewTeacher(Scanner sc, School school){
        System.out.println("Please enter the teacher name");
        String teacherName = sc.nextLine();
        school.teachers.add( new Teacher( teacherName));
        System.out.println("Teacher has been added!");
    }
    
    // Add a employee
    public void addNewEmployee(Scanner sc, School school){
        System.out.println("Please enter the employee name");
        String employeeName = sc.nextLine();
        System.out.println("Please enter the amount of weekly working hours");
        int workHours = sc.nextInt();
        sc.nextLine();
        school.employees.add( new Employee( workHours, employeeName));
        System.out.println("Employee has been added!");
    }
    
    // Add a class
    public void addNewClass(Scanner sc, School school){
        System.out.println("Please enter the class name");
        String className = sc.nextLine();
        System.out.println("Please enter the max capacity for this class");
        int maxCapacity = sc.nextInt();
        sc.nextLine();
        school.classes.add( new Class( maxCapacity, className));
        System.out.println("Class has been added!");
    }

    // Register a course to a certain student
    public void registerCourseToStudent(Scanner sc, School school){
        System.out.println(school.students.toString());
        System.out.println("Please enter the ID for the student that you want");
        int chosenStudentID = sc.nextInt();
        sc.nextLine();
        if(chosenStudentID <= school.students.size()){
           System.out.println("Student found and selected!");
           System.out.println(school.courses.toString());
           System.out.println("Please enter the ID for the course that you want");
           int chosenCourseID = sc.nextInt();
           sc.nextLine();
           if(chosenCourseID <= school.courses.size()){
              System.out.println("Course found and added!");
              school.students.get(chosenStudentID - 1).addCourse(school.courses.get(chosenCourseID -1));}
              else System.out.println("Course not founded");}
            else System.out.println("Student not founded");
    }
    
    // Register a course to a certain teacher
    public void registerCourseToTeacher(Scanner sc, School school){
        System.out.println(school.teachers.toString());
        System.out.println("Please enter the ID for the teacher that you want");
        int chosenTeacherID = sc.nextInt();
        sc.nextLine();
        if(chosenTeacherID <= school.teachers.size()){
           System.out.println("Teacher found and selected!");
           System.out.println(school.courses.toString());
           System.out.println("Please enter the ID for the course that you want");
           int chosenCourseID = sc.nextInt();
           sc.nextLine();
           if(chosenCourseID <= school.courses.size()){
              System.out.println("Course found and added!");
              school.teachers.get(chosenTeacherID - 1).addCourse(school.courses.get(chosenCourseID -1));}
              else System.out.println("Course not found");}
            else System.out.println("Teacher not found");
    }
    
    // Display complete list of courses registered by a certain student
    public void studentListOfCourses(Scanner sc, School school){
        System.out.println(school.students.toString());
        System.out.println("Please enter the ID for the student that you want");
        int chosenStudentID = sc.nextInt();
        sc.nextLine();
        if(chosenStudentID <= school.students.size()){
            System.out.println(school.students.get(chosenStudentID - 1).getCourses());}
        else System.out.println("Student not found!");
    }
    
    // Display complete list of courses currently taught by a certain teacher
    public void teacherListOfCourses(Scanner sc, School school){
        System.out.println(school.teachers.toString());
        System.out.println("Please enter the ID for the teacher that you want");
        int chosenTeacherID = sc.nextInt();
        sc.nextLine();
        if(chosenTeacherID <= school.teachers.size()){
           System.out.println(school.teachers.get(chosenTeacherID - 1).getCourses());}
           else System.out.println("Teacher not found!");
    }
    
    
    @Override
   public String toString() {
        return ("School name: " + this.getName()+ "\r\n" +
                    "Number of students: " + students.size() + "\r\n" +
                    "Number of teachers: " + teachers.size() + "\r\n" +
                    "Number of courses: " + courses.size() + "\r\n" +
                    "Number of classes: " + classes.size() + "\r\n" +
                    "Number of employees: " + employees.size()
                );
   }
    
    
    
}

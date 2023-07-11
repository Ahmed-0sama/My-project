package final_project;
import java.util.*;
public class Final_project {
    public static void main(String[] args) {
        
        int Exit = 1;
        
        String[] Options = {
                  " 1- Add a course", // done
                  " 2- Add a student", // done
                  " 3- Add a teacher", // done
                  " 4- Add an employee", // done
                  " 5- Add a class", // done
                  " 6- Register a course for a student", // done
                  " 7- Register a course for a teacher", // done
                  " 8- Display school information", // done
                  " 9- Display complete list of courses", // done
                  "10- Display complete list of classes", // done
                  "11- Display complete list of employees", // done
                  "12- Display complete list of students", // done
                  "13- Display complete list of teachers", // done
                  "14- Display complete list of courses registered by a certain student", // done
                  "15- Display complete list of courses currently taught by a certain teacher", // done
                  "16- Exit" // done
        };
            
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a name for your school");
        String schoolName = sc.nextLine();
        School school = new School(schoolName);
        
        
        
        
        while(Exit == 1){
            
            try {Thread.sleep(1000);} 
            catch (InterruptedException e) {Thread.currentThread().interrupt();}
            
            
            for (String option : Options ){
                  System.out.println(option);
                  }
             
             System.out.println("Please enter the number for the action you want to perform");
             int choice = sc.nextInt();
             sc.nextLine();
             
             switch(choice){
                 
                 case 1: // Add a course
                     school.addNewCourse(sc, school);
                     break;
                 
                 
                 case 2: // Add a student
                     school.addNewStudent(sc, school);
                     break;
                     
                     
                 case 3: // Add a teacher
                     school.addNewTeacher(sc, school);
                     break;
                     
                     
                 case 4: // Add an employee
                     school.addNewEmployee(sc, school);
                     break;   
                 
                     
                 case 5: // Add a class
                     school.addNewClass(sc, school);
                     break;      
                     
                     
                 case 6: // Register a course for a student
                     school.registerCourseToStudent(sc, school);
                     break;    
                  
                      
                 case 7: // Register a course for a teacher
                     school.registerCourseToTeacher(sc, school);
                     break;        
                      
                  
                 case 8: // Display school information
                     System.out.println(school.toString());
                     break;
                     
                     
                 case 9: // Display complete list of courses
                     System.out.println(school.getCourses().toString());
                     break;
                     
                     
                 case 10: // Display complete list of classes
                     System.out.println(school.getClasses().toString());
                     break;
                     
                     
                 case 11: // Display complete list of employees
                     System.out.println(school.getEmployees().toString());
                     break;   
                     
                     
                 case 12: // Display complete list of students
                     System.out.println(school.getStudents().toString());
                     break;
                 
                  
                 case 13: // Display complete list of teachers
                     System.out.println(school.getTeachers().toString());
                     break;    
                  
                     
                 case 14: // Display complete list of courses registered by a certain student
                     school.studentListOfCourses(sc, school);
                      break;
                     
                     
                 case 15: // Display complete list of courses currently taught by a certain teacher
                     school.teacherListOfCourses(sc, school);
                      break;   
                     
                      
                 case 16: // Exit
                     System.out.println("Program has been terminated!");
                     Exit = 0;
                     break;
        }
            
        }
        
    }
    
}

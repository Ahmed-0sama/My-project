package final_project;
public class Employee extends Person {
    
    private int workHours;

    // Constructor
    public Employee(int workHours, String name) {
        super(name);
        this.workHours = workHours;
    }

    public int getWorkHours() {
        return workHours;
    }

    public void setWorkHours(int workHours) {
        this.workHours = workHours;
    }
    
    
    
    @Override
   public String toString() {
        return ("\r\n" +"-----------------------" + "\r\n" +
                    "Employee name: "+ super.getName()+
                    " - Work hours: "+ this.getWorkHours() );
   }
    
}

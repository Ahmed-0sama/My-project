package final_project;
public class Class {
    
    private String className;
    private int maxCapacity;

    // Constructor
    public Class(int maxCapacity, String className) {
        this.className = className;
        this.maxCapacity = maxCapacity;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }
    
    @Override
   public String toString() {
        return ("\r\n" +"-----------------------" + "\r\n" +
                    "Class name: "+ this.getClassName()+
                    " - Max class capacity: "+ this.getMaxCapacity() );
   }
    
}

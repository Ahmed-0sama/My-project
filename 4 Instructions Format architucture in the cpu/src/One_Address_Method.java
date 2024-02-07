import java.util.Stack;

public class One_Address_Method {
    public static void one_address(String postfix) {
        System.out.println("-----------------------------------------------------------------------------------------------------");
        String[] arr = postfix.split(" ");
        Stack<String> s = new Stack<>();
        String Temp = "T";
        int count =0;
        for(int i=0; i< arr.length;i++){
            if(arr[i].equals("+")){
                String s1=s.pop();
                String s2=s.pop();
                count++;
                if(!(s1.equals("T"))&&!(s2.equals("T"))){
                    System.out.println("LOAD "+s2);
                    System.out.println("ADD "+s1);
                    if(count==1){
                        System.out.println("Store Temp");
                    }
                    s.push("T");
                }
                else if((s1.equals("T"))&&!(s2.equals("T"))){
                    System.out.println("LOAD "+s2);
                    System.out.println("ADD "+s1);
                    System.out.println("Store Temp");
                    s.push("T");
                }
                else if(!(s1.equals("T"))&&(s2.equals("T"))){
                    System.out.println("LOAD "+s1);
                    System.out.println("ADD " +s2);
                    System.out.println("Store Temp");
                    s.push("T");
                }
                else{
                    System.out.println("ADD Temp");
                    s.push("T");
                }
            }
            else if(arr[i].equals("-")){
                String s1=s.pop();
                String s2=s.pop();
                count++;
                if(!(s1.equals("T"))&&!(s2.equals("T"))){
                    System.out.println("LOAD "+s2);
                    System.out.println("SUBT "+s1);
                    if(count==1){
                        System.out.println("Store Temp");
                    }
                    s.push("T");
                }
                else if((s1.equals("T"))&&!(s2.equals("T"))){
                    System.out.println("LOAD "+s2);
                    System.out.println("SUBT "+s1);
                    System.out.println("Store Temp");
                    s.push("T");
                }
                else if(!(s1.equals("T"))&&(s2.equals("T"))){
                    System.out.println("LOAD "+s1);
                    System.out.println("SUBT " +s2);
                    System.out.println("Store Temp");
                    s.push("T");
                }
                else{
                    System.out.println("SUBT Temp");
                    s.push("T");
                }
            }
            else if(arr[i].equals("*")){
                String s1=s.pop();
                String s2=s.pop();
                count++;
                if(!(s1.equals("T"))&&!(s2.equals("T"))){
                    System.out.println("LOAD "+s2);
                    System.out.println("MULT"+s1);
                    s.push("T");
                    if(count==1){
                        System.out.println("Store Temp");
                    }
                }
                else if((s1.equals("T"))&&!(s2.equals("T"))){
                    System.out.println("LOAD "+s2);
                    System.out.println("MULT "+s1);
                    System.out.println("Store Temp");
                    s.push("T");
                }
                else if(!(s1.equals("T"))&&(s2.equals("T"))){
                    System.out.println("LOAD "+s1);
                    System.out.println("MULT " +s2);
                    System.out.println("Store Temp");
                    s.push("T");
                }
                else{
                    System.out.println("MULT Temp");
                    s.push("T");
                }
            }
            else if(arr[i].equals("/")){
                String s1=s.pop();
                String s2=s.pop();
                count++;
                if(!(s1.equals("T"))&&!(s2.equals("T"))){
                    System.out.println("LOAD "+s2);
                    System.out.println("DIVIDE "+s1);
                    if(count==1){
                        System.out.println("Store Temp");
                    }
                    s.push("T");
                }
                else if((s1.equals("T"))&&!(s2.equals("T"))){
                    System.out.println("LOAD "+s2);
                    System.out.println("DIVIDE "+s1);
                    System.out.println("Store Temp");
                    s.push("T");
                }
                else if(!(s1.equals("T"))&& (s2.equals("T"))){
                    System.out.println("LOAD "+s1);
                    System.out.println("DIVIDE" +s2);

                    System.out.println("Store Temp");
                    s.push("T");
                }
                else{
                    System.out.println("DIVIDE Temp");
                    s.push("T");
                }
            }
            else{
                s.push(arr[i]);
            }

        }
        System.out.println("Store z");
        System.out.println("------------------------------------------------------------------------------------------------------");
    }
}

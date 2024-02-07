import java.util.ArrayList;
import java.util.Stack;

public class two_Address_Method {
    public static void twoAddresses(String postfix) {
        System.out.println("----------------------------------------------------------------------------------------------------------");
        int count = 0;
        String[] arr = postfix.split(" ");
        Stack<String> operands = new Stack<>();
        ArrayList<String> check=new ArrayList<>();

        for (String arr1 : arr) {
            if (!"+".equals(arr1) && !"-".equals(arr1) && !"*".equals(arr1) && !"/".equals(arr1)) {
                operands.push(arr1);
            } else {
                String operat = arr1;
                count++;
                String s1=operands.pop();
                String s2=operands.pop();
                String micOperator= helper_method.checkOperator(operat);
                String reg="R"+count;
                check.add(reg);
                if(!check.contains(s1)&&!check.contains(s2)){
                    System.out.println("Load"+"      "+reg+" , "+s2);
                    System.out.println(micOperator+"      "+reg+" , "+s1);
                    operands.push(reg);
                }
                else if(!check.contains(s1)&&check.contains(s2)){
                    System.out.println("Load"+"      "+reg+" , "+s1);
                    System.out.println(micOperator+"      "+s2+" , "+reg);
                    operands.push(s2);
                }
                else if(!check.contains(s2)&&check.contains(s1)){
                    System.out.println("Load"+"      "+reg+" , "+s2);
                    System.out.println(micOperator+"      "+reg+" , "+s1);
                    operands.push(reg);
                }
                else{
                    System.out.println(micOperator+"      "+s2+" , "+s1);
                    operands.push(s2);
                }
            }
        }
        String result=operands.pop();
        System.out.println("store"+"      "+"z"+" , "+result);
        System.out.println("-----------------------------------------------------------------------------------------------------");
    }
}

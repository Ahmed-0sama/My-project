
package evaluate_postfix;

import java.util.Scanner;


public class Evaluate_Postfix {


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Please Enter the Postfix Expression to Evaluate");
        String x=sc.nextLine();
        String expression =x;
        Evaluate k=new Evaluate();
        int result = k.evaluate(expression);
        System.out.println(expression + " = " + result);
      
    }
    
}

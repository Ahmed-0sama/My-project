package evaluate_postfix;

import static java.lang.System.exit;



/**
 *
 * @author ahmed osama
 */
public class Evaluate {
    public  int evaluate(String exp){
        //my implemented stack 
   stack stack=new stack(100);
   String [] tokens =exp.split("\\s+");
        for(String token:tokens) {
            
            if (token.matches("\\d+")){
               
                stack.push(Integer.parseInt(token));
        }
        else{
            int operator2=stack.pop();
            int operator1=stack.pop();
            int result=0;
            switch(token){
                case("+"):
                   result= operator1+operator2;
                   break;
                case("-"):
                       result=operator1-operator2;
                       break;
                case("*"):
                        result=operator1*operator2;
                        break;
                case("/"):

                   try{
                        result=operator1/operator2;
                         break;
                    }
                   catch(ArithmeticException e ){
                       System.out.println(""+ e.toString());
                       exit(0);
                   }
                       
                    case("^"):
                        result=(int) Math.pow(operator1, operator2);
                    break;
                
            }
            stack.push(result);
           
        }
      
    }
    return stack.pop();
    
}
}

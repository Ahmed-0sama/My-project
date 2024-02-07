import java.util.Stack;

public class Three_Address_Method{

public static void threeAddresses(String infix){
        System.out.println("the three Adresses output");
        int count =0;
        Stack<String> operands=new Stack<>();
        Stack<Character> operator =new Stack<>();
        char[] arr=infix.toCharArray();
        for (int i = 0; i < arr.length; i++) {
        if(arr[i]==' '){
        continue;
        }
        else if(Character.isDigit(arr[i])){
        StringBuilder str1=new StringBuilder();
        while(i<arr.length &&Character.isDigit(arr[i])){
        str1.append(arr[i]);
        i++;
        }
        i--;
        operands.push(str1.toString());
        }
        else if(arr[i]!='+'&&arr[i]!='-'&&arr[i]!='*'&arr[i]!='/'&&arr[i]!='('&&arr[i]!=')'){
        operands.push(String.valueOf(arr[i]));
        }
        else if(arr[i]==')'){
        while(operator.peek() !='('){
        char operat=operator.pop();
        count++;
        String s1=operands.pop();
        String s2=operands.pop();
        String micOperator= helper_method.checkOperatorx(operat);
        String reg="R"+count;
        operands.push(reg);
        System.out.println(micOperator+"        "+reg+" , "+s2+" , "+s1);

        }
        operator.pop();

        }
        else{
        while(!operator.isEmpty()&& helper_method.Priority(arr[i])<= helper_method.Priority(operator.peek())&&operator.peek()!='('){
        char operat=operator.pop();
        count++;
        String s1=operands.pop();
        String s2=operands.pop();
        String micOperator= helper_method.checkOperatorx(operat);
        String reg ="R"+count;
        operands.push(reg);
        System.out.println(micOperator+"        "+reg+" , "+s2+" , "+s1);
        }
        operator.push(arr[i]);
        }
        }
        while(!operator.isEmpty()){
        if(operands.size()>2){
        char operat=operator.pop();
        count++;
        String s1=operands.pop();
        String s2=operands.pop();
        String reg="R"+count;
        String micOperator= helper_method.checkOperatorx(operat);
        operands.push(reg);
        System.out.println(micOperator+"        "+reg+" , "+s2+" , "+s1);
        }
        else if(operands.size()==2){
        char operat=operator.pop();
        String s1=operands.pop();
        String s2=operands.pop();
        String micOperator= helper_method.checkOperatorx(operat);
        System.out.println(micOperator+"         "+"z"+" , "+s2+" , "+s1);
        }
        else{

        }
        }
        System.out.println("----------------------------------------------------------------------------------------------------------");
        }


}
import java.util.Stack;

public class Zero_Address_Method {
    public static void stackway(String postfix){
        System.out.println("------------------------------------------------------------------------------------------------------");
        String[] splited = postfix.split(" ");
        Stack<String> schar = new Stack<>();
        Stack<Integer> sint = new Stack<>();
        char[] arr = splited[0].toCharArray();

        if (Character.isDigit(arr[0])) {
            for (int i = 0; i < splited.length ; i++) {
                if (splited[i].equals("*")) {
                    System.out.println("MULT");
                    int one = sint.pop();
                    int two = sint.pop();
                    int mult = two * one;
                    sint.push(mult);
                } else if (splited[i].equals("/")) {
                    System.out.println("DIVIDE");
                    int one = sint.pop();
                    int two = sint.pop();
                    if (one != 0) {
                        int division = two / one;
                        sint.push(division);
                    } else {
                        System.out.println("Can't divide by zero");
                    }
                } else if (splited[i].equals("+")) {
                    System.out.println("ADD");
                    int one = sint.pop();
                    int two = sint.pop();
                    int sum = two + one;
                    sint.push(sum);
                } else if (splited[i].equals("-")) {
                    System.out.println("SUBT");
                    int one = sint.pop();
                    int two = sint.pop();
                    int diff = two - one;
                    sint.push(diff);
                } else {
                    int pk = Integer.parseInt(splited[i]);
                    System.out.println("PUSH " + pk);
                    sint.push(pk);
                }
                if(i==splited.length-1){
                    System.out.println("STORE "+sint.peek());
                }
            }
        } else {
            for (int i = 0; i < splited.length ; i++) {
                if (splited[i].equals("*")) {
                    System.out.println("MULT");
                    String my = schar.pop();
                    String myy = schar.pop();
                    schar.push(myy + "*" + my);
                } else if (splited[i].equals("+")) {
                    System.out.println("ADD");
                    String my = schar.pop();
                    String myy = schar.pop();
                    schar.push(myy + "+" + my);
                } else if (splited[i].equals("-")) {
                    System.out.println("SUBT");
                    String my = schar.pop();
                    String myy = schar.pop();
                    schar.push(myy + "-" + my);
                } else if (splited[i].equals("/")) {
                    System.out.println("DIVIDE");
                    String my = schar.pop();
                    String myy = schar.pop();
                    schar.push(myy + "/" + my);
                } else {
                    System.out.println("PUSH " + splited[i]);
                    schar.push(splited[i]);
                }

            }
        }
    }
}

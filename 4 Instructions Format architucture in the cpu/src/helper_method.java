import java.util.Stack;

public class  helper_method {
    public static String checkOperator(String s) {
        switch (s) {
            case "+":
                return "Add";
            case "-":
                return "Subt";
            case "*":
                return "Mult";
            case "/":
                return "Divid";
            default:
                break;
        }
        return null;
    }
    public static String checkOperatorx(char s) {
        switch (s) {
            case '+':
                return "Add";
            case '-':
                return "Subt";
            case '*':
                return "Mult";
            case '/':
                return "Divid";
            default:
                break;
        }
        return null;
    }

    public static int Priority(char c){
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '(':
                return 3;
            default:
                return 0;
        }
    }

    private static boolean isOperator(char ch) {
        return (ch == '+' || ch == '-' || ch == '*' || ch == '/');
    }

    private static int getPrecedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return -1;
    }

    public static String infixToPostfix(String infixExpression) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < infixExpression.length(); i++) {
            char ch = infixExpression.charAt(i);

            if (Character.isDigit(ch)) {
                // Handle multi-digit integers
                int start = i;
                while (i < infixExpression.length() && Character.isDigit(infixExpression.charAt(i))) {
                    i++;
                }
                postfix.append(infixExpression.substring(start, i)).append(' ');
                i--; // Adjust i to the last digit of the integer
            } else if (Character.isLetter(ch)) {
                postfix.append(ch).append(' ');
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop()).append(' ');
                }
                stack.pop(); // Pop the '(' from the stack
            } else if (isOperator(ch)) {
                while (!stack.isEmpty() && getPrecedence(ch) <= getPrecedence(stack.peek())) {
                    postfix.append(stack.pop()).append(' ');
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop()).append(' ');
        }

        return postfix.toString().trim(); // Trim to remove trailing space
    }
}
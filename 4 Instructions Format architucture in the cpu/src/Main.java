import java.util.Scanner;

public class Main {

public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("please enter the infix string");
        String infix=sc.nextLine();
        String postfix= helper_method.infixToPostfix(infix);
        System.out.println(postfix);
        System.out.println("the three adresses is");
        Three_Address_Method.threeAddresses(infix);
        System.out.println("the two adresses is");
        two_Address_Method.twoAddresses(postfix);
        System.out.println("theone adresses is");
        One_Address_Method.one_address(postfix);
        System.out.println("the stack or zero adresses is");
        Zero_Address_Method.stackway(postfix);
        }
        }


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package convert_infix_postfix;

import static convert_infix_postfix.Stack.infix_to_postfix;
import java.util.Scanner;


/**
 *
 * @author Eslam
 */
public class main {
    public static void main(String[] args){
       Scanner sc=new Scanner(System.in);
       System.out.println("enter your infix string");
       String st=sc.next();
       int size=100;
      String a= infix_to_postfix(st,size);
       System.out.println("postfix string "+a);

    }


}

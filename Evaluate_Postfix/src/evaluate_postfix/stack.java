/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package evaluate_postfix;

/**
 *
 * @author ahmed
 */
public class stack {
        int arr[];
        int top;
        int size;
        public boolean isEmpty(){
            return top==-1;
        }
        public boolean isFull(){
            return top==size-1;
        }
        public stack(int s){
            size=s;
            top=-1;
            arr=new int [s];
        }
public boolean push(int data){
    if(!isFull()){
        arr[++top]=data;
        return true;
    }
    return false;
}
public int pop(){
    if(!isEmpty()){
        
        return arr[top--];
        
    }
    return -1;
    
}
public int peek(){
    return top;
}
public void printstack(){
    if (!isEmpty()){
        stack temp=new stack(100);
        while (!isEmpty()){
            System.out.println(""+arr[top]);
            temp.push(pop());
         
       }
        while(!temp.isEmpty()){
            push(temp.pop());
        }
    }
}

}

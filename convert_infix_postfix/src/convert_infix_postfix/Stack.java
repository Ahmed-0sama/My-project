package convert_infix_postfix;





/**
 *
 * @author Eslam
 */

public class Stack {
    char [] arr;
    int size;
    int top;
    public Stack(int s){
        size=s;
        arr = new char[s];
        top=-1;
       
    }
    public boolean isEmpty(){
        return top==-1;
    }
    public boolean isFull(){
        return top==size-1;
    }
    public char peek(){
        return arr[top];
    }

    
    public char pop(){
        if(!isEmpty()){
            return arr[top--];
        }
        return (char) -1;
    }
    public boolean push(char data){
        if(!isFull()){
            arr[++top]=data;
            return true;
        }
        return false;
    }
    public  static int priority(char v){
        
      if(v =='+' ||v =='-'){
          return 1;
      }
        else if(v=='*' ||v=='/'){
            return 2;
        }
         else if(v =='^'){
            return 3;
        }
        
        else{
            return 0;
        }
        
    }
    public static String infix_to_postfix(String exp ,int s){
        Stack tmp=new Stack(s);
        String output=" ";
        char ch[]=exp.toCharArray();
        for(char c: ch){
          if(c !='+' && c !='-' && c !='*' && c !='/' && c !='^' && c!='(' && c !=')'){
              output =output+c;

          }
          else if(c =='('){
              tmp.push(c);
          }
          else if(c ==')'){
              while(!tmp.isEmpty()){
                  char x=tmp.peek();
                  if(x!='('){
                      output = output + x;
                      tmp.pop();   
                  }
                  else{
                      tmp.pop();
                  }
              }
          }
          else if(c =='+' || c =='-' || c =='*' || c =='/' || c =='^'){
              if(tmp.isEmpty()){
                  tmp.push(c);
                  
              }
              else {
                  while(!tmp.isEmpty()){
                  char x=tmp.pop();
                  if(x=='('){
                      tmp.push(x);
                      break;

                  }
                  else if(x =='+' || x =='-' || x =='*' || x =='/' || x=='^'){
                      if(priority(x) < priority(c)){
                          tmp.push(x);
                          break;
                      }
                      else{
                         output = output +x;
                        
                      }
                  }
              }
                  tmp.push(c);
          }  
        }
    }
        while(!tmp.isEmpty()){
            char x=tmp.pop();
            output = output + x;
        }
    
        return output;
    }
   
}
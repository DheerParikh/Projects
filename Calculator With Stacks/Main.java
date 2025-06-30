// Main.java
import java.util.Scanner;
import java.util.Arrays;

class Main {
   
   public static int calculator (Stack numbers ){
      
    
     
     
     
     while (numbers.isEmpty()==false){
      System.out.println ("Input a number or operator:"); 
      Scanner in = new Scanner(System.in);
      String operations =in.nextLine();
      String [] strings= operations.split(" ");
      System.out.println(Arrays.toString(strings)); 
      System.out.println(numbers.peek());
      int firstNumber=0;
      int secondNumber=0;
      int q=0;
      
      if(strings[q].equals("!")){
            System.out.println("hi");
            break;
      }
      
      
      for(;q<strings.length; q++){
     
      try {
        //System.out.println("1");
        firstNumber= Integer.parseInt(strings[q]);
        numbers.push(firstNumber);

      } 
       catch(NumberFormatException ex){
        
    
        
        
        if(!(strings[q].equals("?"))){
          
          
          
          
          if(numbers.peek()!=0){
            firstNumber=numbers.peek();
            numbers.pop();
          }
          if(numbers.peek()!=0){
            secondNumber=numbers.peek();
            numbers.pop();
          }
          
          if(strings[q].equals("+")){
            numbers.push(firstNumber+secondNumber);
          }   
          
          else if(strings[q].equals("-")){
            numbers.push(firstNumber-secondNumber);
          }
          
          else if (strings[q].equals(".")){
              if(secondNumber!=0){
                numbers.push(secondNumber);
              }
              System.out.println("hi");
          }
          
          
          else if (firstNumber!=0){
              if(strings[q].equals("*")){
                numbers.push(firstNumber*secondNumber);
              }
              
              else if(strings[q].equals("/")){
                if(firstNumber ==0){
                  System.out.println("no");
                  
                  numbers.push(secondNumber);
                  
                }
                else{
                  System.out.println("hi");
                  numbers.push(secondNumber/firstNumber);
                }
              }
            
              else if(strings[q].equals("%")){
                numbers.push(secondNumber%firstNumber);
                System.out.println(numbers.peek());
                
              }

          }
          
          else{
            System.out.println("no");
            //numbers.push(secondNumber);
          }
          
        }
        
        
          else if(strings[q].equals("?")){
            System.out.println(numbers.toString());
          }
          
          
        
        
        
       }
      }
      //System.out.println(numbers.peek());
    }
     return numbers.peek();
   } 
  
  
  
  
  
    public static void main(String[] args) {
      
      Stack numbers= new Stack();
      numbers.push(0);
      System.out.println(numbers.toString());
    	System.out.println(calculator(numbers));
    	
    	
    }
}

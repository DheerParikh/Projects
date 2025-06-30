public class Stack { 

  static final int MAX = 1000; 
  private int top; // Index of the topmost element
  private int stack[]; // Maximum size of Stack 
  private int length;


  public Stack(){ 
    this.top=0;
    this.stack= new int [MAX];
    this.length=0;
  } 

  /** Returns true if the stack is empty **/
  public boolean isEmpty(){ 
    if(top==0){
      return true;
    }
    else{
      return false;
    }
    
  } 

  /** Pushes data onto the stack **/
  public void push(int data){ 
    if(top<1000){
    stack[top]=data;
    top++;
    }
    else{
      System.out.println("Too many elements");
      throw new OverflowException ();
    }
  } 
  
  

  /** Removes topmost item from the stack & returns its value **/
  public int pop(){
    if(top>0){
      int oldTopData= stack[top-1];
      top--;
      return oldTopData;
      
    }
    else{
      System.out.println("Not enough elements");
      throw new UnderflowException ();      
    }
  } 

  /** Returns value of topmost item on the stack **/
  public int peek(){ 
    if(top>0){
      return stack[top-1];
    }
    else{
      System.out.println("No elements");
      throw new OverflowException();
      
    }
  } 

  @Override
  public String toString(){
    
    String Final=" ";
    for(int q=0; q<top; q++){
      
      Final=Final+stack[q]+" ";
      
    }
    
    
    return Final;
  }
} 

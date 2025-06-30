public class DoublyLinkedList<T> implements List<T> {
  
  private node head;
  private int length;
  private node tail;
  
  public DoublyLinkedList(){
    this.head= new node <> ();
    this.length=0;
    this.tail=new node<> ();
    head.dataPointerForward=tail;
    tail.dataPointerBackward=head;
    
  }
  
 public int getLength(){
   return this.length;
 }

  //returns true if the is empty
  public boolean isEmpty(){
    if(length==0){
      return true;
    }
    else{
      return false;
    }
  }

  //inserts a new node at the front
  public void insertFront(T t){
    node value=new node<> (t);
    
    value.dataPointerForward=head.dataPointerForward;
    head.dataPointerForward=value;
    value.dataPointerBackward=head;
    value.dataPointerForward.dataPointerBackward=value;
    length++;
  }

  //inserts a new node at the back
  public void insertBack(T t){
    node value=new node<> (t);
    
    value.dataPointerBackward=tail.dataPointerBackward;
    System.out.println(" asdsa");
    value.dataPointerBackward.dataPointerForward=value;
    System.out.println("line 2");
    tail.dataPointerBackward=value;
    System.out.println("line 3");
    value.dataPointerForward=tail;
    System.out.println("line 4");
    length++;
    
    
  }

  //removes the first node
  public void removeFront(){
    if(length>0){
     node <T> value=head.dataPointerForward;
     head.dataPointerForward=value.dataPointerForward;
     value.dataPointerForward.dataPointerBackward=head;
     length--;
    }
    
  }

  //removes the last node
  public void removeBack(){
    if(length>0){
      node <T> value=tail.dataPointerBackward;
      tail.dataPointerBackward=value.dataPointerBackward;
      value.dataPointerBackward.dataPointerForward=tail;
      length--;
    }
    
  }

  //returns the data (of type "T") at the given index. Throws an IndexOutOfBounds exception if the index isn't in the list
  public T get(int index){
    node <T> value= head;
    if(index>length){
      throw new IndexOutOfBoundsException() ;
      
    }
    
    else{
      
      for(int q=0; q<index; q++){
        value=value.dataPointerForward;
      }
    }
    
    return value.data;
  }

  //deletes everything in the list
  public boolean clearAll(){
    if(length==0){
      return true;
    }
    
    else{
      this.removeFront();
      return this.clearAll();
    }
    
    
    
  }
  
  
  public void insertAt(int index, T t){
    node <T> value=head;
    node New =new node<> (t);
    
    for(int q=0; q<index; q++){
      value=value.dataPointerForward;
    }
    New.dataPointerForward= value.dataPointerForward;
    value.dataPointerForward= New;
    New.dataPointerBackward= value;
    length++;
  }
  
  
  
  
  public String toString(){
    String Final= " ";
    node <T> value=head.dataPointerForward;
    for(int q=0; q<length; q++){
      Final= Final+value.data+ " ";
      System.out.println(value.data);
      value=value.dataPointerForward;
      
    }
    return Final;
    
  }
  
  
  
 
  private class node<T>{
    
    private T data;
    private node dataPointerForward;
    private node dataPointerBackward;
    
    public node ( T data){
      this.data=data;
      
    }
    
    public node (){
      
    }
    
    
   
   
   
   
    
  }
 
}

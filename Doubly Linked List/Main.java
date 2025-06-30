class Main {
  public static void main(String[] args) {
    //TODO: test the DoublyLinkedList here!
    
    DoublyLinkedList <Integer> test = new  DoublyLinkedList <> ();
    
    test.insertFront( 3);
    test.insertFront(7);
    test.insertFront(2);
    test.insertBack(5);
    System.out.println(test);
    test.insertAt(2, 15);
   
    
    System.out.println(test);
    System.out.println(test.clearAll());
    
  }
}

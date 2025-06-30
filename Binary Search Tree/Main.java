class Main {
  public static void main(String[] args) {
    
    BST test1= new BST();
    
    
    test1.insert(7);
    test1.insert(3);
    test1.insert(17);
    test1.insert(6);
    test1.insert(2);
    test1.insert(10);
    test1.insert(22);
    test1.insert(15);
    //System.out.println(test1.isEmpty());
    //System.out.println(test1.size());
    //System.out.println(test1.has(17));
    //System.out.println(test1.preorderReturn());
    //System.out.println(test1.inOrderReturn());
    //System.out.println(test1.postOrderReturn());
    //test1.clear();
    //System.out.println("\n");
    System.out.println(test1.preorderReturn());
    //System.out.println(test1.size());
    test1.remove(10);
    System.out.println(test1.preorderReturn());
  }
}

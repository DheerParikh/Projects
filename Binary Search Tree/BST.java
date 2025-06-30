public class BST implements BSTInterface{
  
  node root;
  int size=0;
  
  public BST(){
  }
  
  public boolean isEmpty(){
    if (size==0){
      return true;
    }
    else{
      return false;
    }
  }
  
  public int size(){
    return size;
  }
  
  public boolean has(int value){
    return find (value,root);
    
  }
  
  private boolean find(int value, node root){
    
    node temporary= root;
    
    if(size==0){
      return false;
    }
    
    
    else if(temporary.getleftNode()==null&&temporary.getrightNode()==null){
      if(temporary.getValue()!=value){
        return false;
      }
      else{
        return true;
      }
    }
    
    else if (value>root.getValue()){
      if(temporary.getrightNode()!=null){
        temporary= temporary.getrightNode();
        return find(value,temporary);
      }
      else {
        return false;
      }
    }
    
    else if(value<root.getValue()){
      if(temporary.getleftNode()!=null){
        temporary=temporary.getleftNode();
        return find (value,temporary);
      }
      else{
        return false;
      }
    }
    
    else {
      return true;
    }
  }
  
  public void insert(int value){
    
    if(size==0){
      this.root = new node (value);
        
    }
    else{
      locater(value,root);
      System.out.println(root.getrightNode());
      System.out.println(root.getleftNode());
    }
    size++;
  }
  
  private node locater(int value, node root){
    
    node temporary= root;
    
    if(size==0){
      temporary.setValue(value);
      return temporary;
    }
    
    
    else if(value<temporary.getValue()){
      if(temporary.getleftNode()==null){
        temporary.setleftNode( new node (value));
        return temporary;
      }
      else{
        temporary=root.getleftNode();
        return locater (value,temporary);
      }
    }
    
    else if(value>temporary.getValue()){
      if(temporary.getrightNode()==null){
        temporary.setrightNode(new node (value));
        return temporary;
      }
      else{
        temporary=root.getrightNode();
        return locater(value,temporary);
      }
    }
    
    
    else if(value==temporary.getValue()){
      throw new IllegalArgumentException("Already exsisting node");
    }
    
    else{
      return temporary;
      
    }
    
  }
  
  
  
  public String preorderReturn (){
    return preorder(this.root);
  }
  
  
  private String preorder(node root){
    
    node temporary= root;
    String preorderString=" ";
    
    if(temporary==null){
      return preorderString;
    }
    
    else{
      preorderString= preorderString + temporary.getValue();
      preorderString= preorderString+ preorder(temporary.getleftNode());
      preorderString=preorderString +preorder(temporary.getrightNode());
      return preorderString;
    }
    
  }
  
  public String inOrderReturn(){
    return inOrder(this.root);
  }
  
  private String inOrder (node root){
    
    node temporary = root;
    String inOrderString =" ";
    
    if(temporary==null){
      return inOrderString;
    }
    
    else{
      inOrderString=inOrderString+ inOrder(temporary.getleftNode());
      inOrderString= inOrderString + temporary.getValue();
      inOrderString = inOrderString + inOrder(temporary.getrightNode());
      return inOrderString;
    }
    
  }
  
  
  public String postOrderReturn(){
    return postOrder(this.root);
  }
  
  private String postOrder(node root){
    
    node temporary = root;
    String postOrderString =" ";
    
    if (temporary==null){
      return postOrderString;
    }
    
    else{
      postOrderString = postOrderString+ postOrder(temporary.getleftNode());
      postOrderString= postOrderString + postOrder(temporary.getrightNode());
      postOrderString = postOrderString + " "+ temporary.getValue();
      return postOrderString;
    }
  }
  
  public void clear (){
    this.root=clearTraversial(this.root);
    size--;
    System.out.println(size);
  }
  
  
  private node clearTraversial (node root){
    
    node temporary=root;
    System.out.println(temporary.getValue()+ "start");

    if (temporary.getrightNode() == null && temporary.getleftNode()==null){
      //size--;
      
      return null;
    }
    
    else {
      if(temporary.getleftNode()!=null){
        System.out.println(temporary.getValue());
        temporary.setleftNode(clearTraversial (temporary.getleftNode()));
        System.out.println(temporary.getValue());
        size--;
      }
      
      if(temporary.getrightNode()!=null){
        temporary.setrightNode(clearTraversial (temporary.getrightNode()));
        System.out.println(temporary.getValue());
        size--;
      }
      
        return null;
      
    }
    
  }
  
  public void remove(int value){
    if (size==0){
      throw new IllegalArgumentException ("Tree is empty");
    }
    
    else {
      
      this.root= removeTraversial (this.root, value);
    }

  }
  
  public node removeTraversial(node root,int value){
    
    
    node temporary=root;
     
    if (temporary==null){
      throw new IllegalArgumentException ("Node does not exsist");
    } 
    
    
    else if (temporary.getValue()==value){
      if(temporary.getleftNode()==null && temporary.getrightNode()==null){
        return null;
      }
      
      else if (temporary.getleftNode()!=null && temporary.getrightNode()==null){
          return temporary.getleftNode();
      }
      
      else if (temporary.getleftNode()==null && temporary.getrightNode()!=null){
        return temporary.getrightNode();
      }
      
      else{
        node tracker=temporary;
        
        tracker=tracker.getleftNode();
        node parentNode=tracker;
        if(tracker.getrightNode()==null){
          temporary.setleftNode(null);
        }
        else{
        while (tracker.getrightNode()!=null){
          tracker=tracker.getrightNode();
          if (parentNode.getrightNode().getrightNode()!=null){
            parentNode=tracker;
          }
        } 
          System.out.println(tracker.getValue());
          System.out.println(temporary.getValue());
          System.out.println(parentNode.getValue());
          
          parentNode.setrightNode(null);
        }
        tracker.setrightNode(temporary.getrightNode());
        tracker.setleftNode(temporary.getleftNode());
        System.out.println(tracker.getrightNode().getValue());
        System.out.println(tracker.getValue());
        return tracker;
        
      }
      
    }
    
   
      
      else {
        
        if (temporary.getValue()>value){
          temporary.setleftNode(removeTraversial(temporary.getleftNode(),value));
        }
        
        else{
          temporary.setrightNode(removeTraversial(temporary.getrightNode(),value));
        }
        return temporary;
      }  
  }
    
    
    
  
  
  
  
  
  
  
  
  private class node {
    
    int value;
    node leftNode;
    node rightNode;
    
    public node (int value){
      
      this.value= value;
      
      
    }
    
    public int getValue(){
      return value;
    }
    
    public node getrightNode() {
      return rightNode;
    }
    
    public node getleftNode(){
      return leftNode;
    }
    
    public void setrightNode(node child){
      this.rightNode= child;
    }
    
    public void setleftNode(node child){
      this.leftNode=child;
    }
    
    public void setValue (int value){
      this.value=value;
    }
    
   
  }
  
  
  
  
  
  
}

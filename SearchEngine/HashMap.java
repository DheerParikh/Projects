import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;


public class HashMap<K extends Comparable<K>, V> implements Map<K, V> {

  private int numNodes;
  private int tableSize;
  private Object[] hashTable;
  
  private static final int[] PRIMES = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,97,193,389,769,1543,3079,6151,12289,24593,49157,98317,139291,196613,259537,299993,350213,393241,444863,499979,550279,599999,652153,700001,786433,851359,900001,950473,999983,1572869,3145739,6291469,12582917,25165843,50331653,100663319,201326611,402653189,805306457,1610612741};

  private class Node {
    private K key;  
    private V value;
    private boolean tombStone; //marks the node as deleted
    public Node(K k, V v) {
      this.key = k;
      this.value = v;
      this.tombStone = false;
    }
    
    public void setTombstone (){
      this.tombStone=true;
    }
    
    public boolean getTombstone (){
      return this.tombStone;
    }
    
    public K getKey(){
      return this.key;
    }
    
    public V getValue (){
      return this.value;
    }
    
    public void setValue (V x){
      this.value=x;
    }
    
    
    
    @Override
    public String toString() {
      return this.key + ": " + this.value;
    }
  }

  //CONSTRUCTOR -----------------------------------------------
  public HashMap() {
    numNodes=0;
    tableSize=11;
    hashTable = new Object [11];
    
  }

  //HASH FUNCTION ---------------------------------------------
  private int hash(K key) {
    int x=key.hashCode();
    int index=Math.abs(x%tableSize);
    return index;
  }

  //LOAD FACTOR
  private double loadFactor(){
    double load=  (double)(numNodes)/tableSize;
    return load;
  }

  //GET INDEX METHOD ------------------------------------------
  private int getIndex(K key, boolean inserting) {
    
    int index= this.hash(key);
    //System.out.println(index);
    //System.out.println(index);
    //System.out.println(key);

    if (inserting==true){
      
      while (this.getNode(index,hashTable)!=null && this.getNode(index,hashTable)!=key){
        if(this.getNode(index,hashTable).tombStone==true){
          return index;
        }
        else if(index+1<tableSize){
          index++;
        }
        else {
         index=0;
        }
      }
      return index;      
    }
    
    
    else {
      //System.out.println("works");
      if(this.getNode(index,hashTable)!=null){
        //System.out.println(getNode(index,hashTable).getKey());
        //System.out.println(key);
      }
      if (this.getNode(index,hashTable)!=null && this.getNode(index,hashTable).getKey().equals(key)){
        //System.out.println("checked");
        return index;
      }
      
      else if (this.getNode(index,hashTable)!=null && !this.getNode(index,hashTable).getKey().equals(key)){
        int tracker=0;
          while (!this.getNode(index,hashTable).getKey().equals(key)){
            //System.out.println("workes");
            if(index+1<tableSize){
              index++;
            }
            else {
             index=0;
             
            }
            if (this.getNode(index,hashTable)==null){
              return -1;
              
            }
          }
        return index;
      }
      else{
        return -1;
      }
    }
  }

  // MAP METHODS -----------------------------------------------
  //inserts a key-value pair
  @Override
  public void insert(K key, V value) {
    int index=this.getIndex(key,true);
    Node n = new Node (key, value);
    hashTable [index] =n;
    numNodes++;
    
    if (loadFactor()>0.5){
      //System.out.println("hello");
      rehash();
    }
  }
  
  //removes a key-value pair
  @Override
  public V remove(K key) {
    int index=getIndex(key,false);
    if (index<0){
      throw new IllegalArgumentException ("Key does not exsist");
    }
    else{
      this.getNode(index,hashTable).setTombstone();
      numNodes--;
      return this.getNode(index,hashTable).getValue();
    }
  }

  //updates value associated with key
  @Override
  public void put(K key, V value) {
    int index=getIndex(key,false);
    if(this.getNode(index,hashTable)!=null){
       Node n=this.getNode(index,hashTable);
      n.setValue(value);
    }
    else{
      throw new IllegalArgumentException ("The key does not exsist, no key to be updated");
    }
  }

  //get value associated with key
  @Override
  public V get(K key) {
    int index=getIndex(key,false);
    if(this.getNode(index,hashTable)!=null){
      V value = this.getNode(index,hashTable).getValue();
      return value;
    }
    else{
      throw new IllegalArgumentException("key does not exsist");
    }
  }
  
  private Node getNode (int index, Object [] hashTable ){
    Node n =(Node)hashTable [index];
    return n;
  }
  
  
  

  //returns whether the hash map has the value or not
  @Override
  public boolean has(K key) {
    //System.out.println(Arrays.toString(this.hashTable));
    int index=getIndex(key,false);
    //System.out.println(key+" "+index);
    
    if(index==-1){
      return false;
    }
    
    else{
      return true;
    }
  }

  //returns the number of nodes that have been added
  @Override
  public int size() {
    return numNodes;
  }

  //REHASH METHOD -------------------------------------------
  //rehashes the hashtable into a bigger hashtable
  private void rehash() {
    //System.out.println("here");
    int newSize=tableSize*2;
    int tracker=0;
    for(int q=0;q<PRIMES.length;q++){
      if(newSize>PRIMES [tracker]){
        //System.out.println("worked");
        tracker++;
      }
      
      if (newSize<PRIMES[tracker]){
        break;
      }
    }
      tableSize= PRIMES [tracker];
      
      Object [] oldHashTable= hashTable;
      
      hashTable= new Object [tableSize];
      
      for(int z=0; z<newSize/2; z++){
        //System.out.println("hello");
        Node keyvaluepair= this.getNode(z,oldHashTable);
        if(keyvaluepair!=null && keyvaluepair.getTombstone()==false){
          this.insert(keyvaluepair.getKey(), keyvaluepair.getValue());
          numNodes--;
        }
      
      
      
      
      
      
    }
    
  //System.out.println("rehash");
}
  
  
  
  
  
  
  //---------------------------------------------------------
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("{");
    for (int i = 0; i < tableSize; i++) {
      Node node = (Node)hashTable[i];
      if (node != null && !node.tombStone) {
        stringBuilder.append(node.toString());
        if(i < tableSize-1){
          stringBuilder.append(", ");
        }
      }
    }
    stringBuilder.append("\b\b}");
    return stringBuilder.toString();
  }
}

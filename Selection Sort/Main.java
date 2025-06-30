// Main.java
import java.util.ArrayList;
import java.util.Arrays;
class Main {
  
    public static void selectionSort (ArrayList<Integer> same){
      ArrayList <Integer> sorted= new ArrayList <>();
      System.out.println(same);
      int p=same.size();
      for (int q=0; q<p;q++){
        
        int smallestIndex=q;
        
        int smallest=same.get(smallestIndex);
        
        int index=q;
        
        
        
        for (int z=0; z<same.size()-q;z++){
          
          if (smallest<same.get(index)){
            index ++;
          }
          
          else{
            smallest = same.get(index);
            smallestIndex=index;
            index++;
          }
        
          
        }
        
        int oldNumber=same.get(q);
        same.set(q,smallest);
        same.set(smallestIndex,oldNumber);
        
        System.out.println(same);
      }
        System.out.println(same);
      
      
      
    }
  
  
  
  
  
  
  
  
    public static void main(String[] args) {
    	ArrayList<Integer> unsorted = new ArrayList<>();
    	for (int q=0; q<10; q++){
    	  int y= (int)(Math.random()*30);
    	  unsorted.add(q,y);
    	  
    	}
    	
    	ArrayList <Integer> same= new ArrayList <Integer> (Arrays.asList(5,7,10,15,32,1,0,5));
    	
    	selectionSort(unsorted);
    }
}

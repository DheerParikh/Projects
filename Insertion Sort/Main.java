// Main.java
import java.util.Arrays;
import java.util.ArrayList;
class Main {
  
public static ArrayList<Integer> insertion (ArrayList<Integer> unsorted){

  
    for (int z=1; z<unsorted.size(); z++){
      System.out.println(" ");
      int index=z-1;
      int less= unsorted.get(z);
      if (index>-1){
        while (less<unsorted.get(index)){
            
              int smaller=unsorted.get(index);
              int larger = unsorted.get(index+1);
              unsorted.set(index+1,smaller);
              unsorted.set(index,larger);
              System.out.println(unsorted);
              if (index>0){
                index--;
              }
            
        }
      }  
    }
   
  return unsorted;
  
  
  
  
}  

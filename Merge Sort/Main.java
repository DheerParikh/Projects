// Main.java
import java.util.Arrays;
import java.util.ArrayList;
class Main {
  
  
     public static ArrayList <Integer> merge (ArrayList<Integer> one, ArrayList<Integer> two){
      ArrayList <Integer> sorted = new ArrayList<>();
      int smaller=0;
      
      if (one.size()<two.size()){
        smaller=one.size();
      }
      
      else{
        smaller=two.size();
      }
      int tracker1=0;
      int tracker2=0;
      int q=0;
      while(true){
      System.out.println(" ");
      System.out.println(sorted);
      if(tracker1 >=one.size()|| tracker2>=two.size()){
        break;
      }
      if (one.get(tracker1)<two.get(tracker2)){
        sorted.add(q,one.get(tracker1));
        tracker1++;
      }
      else {
        sorted.add(q,two.get(tracker2));
        tracker2++;
      }
      q++;
      }
      int loopTracker1=tracker1;
      int loopTracker2=tracker2;
      if (tracker1==one.size()){
        for(int l=0; l<two.size()-loopTracker2; l++){
          
          sorted.add(q,two.get(tracker2));
          tracker2++;
          q++;
        }  
      }
      else{
        
        for(int l=0; l<one.size()-loopTracker1; l++){
          
          sorted.add(q,one.get(tracker1));
          tracker1++;
          q++;
        }  
        
      }
      
      
       return sorted;
    }
  
  public static ArrayList <Integer> split (ArrayList<Integer> numbers){
      
      if(numbers.size()==1){
        System.out.println(numbers);
        return numbers;
        
         
      }
      else {
       
        return (merge(split(new ArrayList<>(numbers.subList(0,numbers.size()/2))),split(new ArrayList<>(numbers.subList((numbers.size()/2),numbers.size())))));
      }
    }
  

  
    public static void main(String[] args) {
    	ArrayList<Integer> numbers = new ArrayList<>();
    	for (int q=0; q<10; q++){
    	  int y= (int)(Math.random()*30);
    	  numbers.add(q,y);
    	}
    	System.out.println(numbers);
    	split(numbers);
    	System.out.println(split(numbers));
    	
    }
}

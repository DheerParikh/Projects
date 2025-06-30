// Main.java
import java.util.*;

class Main {
    public static void main(String[] args) {
    	
    	Scanner in = new Scanner(System.in);
    	System.out.println("Input a sentence:");
    	String input= in.nextLine();
    	Map< Character, Integer> letterTracker = new TreeMap<>();
    	
    	int tracker=0;
    	
    	for(int q=0; q<input.length();q++){
    	  if(letterTracker.containsKey(input.charAt(q))){
    	    letterTracker.put(input.charAt(q),letterTracker.get(input.charAt(q))+1);
    	    
    	  }
    	  else{
    	    letterTracker.put(input.charAt(q),1 );  
    	  }
    	  System.out.print(input.charAt(q));
    	  System.out.println(letterTracker.get(input.charAt(q)));
    	}
    	
    	for(Map.Entry<Character, Integer> entry : letterTracker.entrySet()){
    	  System.out.println("Key=" + entry.getKey()+ ",Value="+entry.getValue());
    	  
    	}
    	
    	tracker=0;
      for(int q=0; q<letterTracker.size(); q++){
        if(letterTracker.get(input.charAt(tracker))<letterTracker.get(input.charAt(q+1))){
          tracker=q+1;
        }
      }
      
      
      System.out.println(input.charAt(tracker));
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    }
}

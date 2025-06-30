import java.util.*;
import java.io.*;
class Main {
  
  
  public static ArrayList <String> alphabetSort (ArrayList<String> words){
    int lessen=1;
    for (int q=0; q<words.size();q++){
      //System.out.println(" ");
      //System.out.println(words);
      for(int z=0;z<words.size()-lessen;z++){
        String first= words.get(z);
        String second = words.get(z+1);
        if(first.compareTo(second)>0){
          words.set(z,second);
          words.set(z+1,first);
        }
        
      }
      lessen++;
    }
    return words;
  }
  
  
  
  
  
  public static void main(String[] args) throws FileNotFoundException{
    File file = new File("words.txt");
    Scanner scanner = new Scanner(file);
    ArrayList<String> words = new ArrayList<>();
    while(scanner.hasNext()){
      words.add(scanner.next());
    }
    System.out.println("\nBEFORE:\n"+words);
    System.out.println(" ");
    System.out.println(alphabetSort(words));
  }
  
  
  
  
  
  
  
  
  
  
  
}

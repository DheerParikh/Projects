import java.io.File;
import java.io.FileNotFoundException;
import java.security.KeyException;
import java.util.Scanner;
import java.util.ArrayList;

/*A simplified search engine that takes in keywords from standard input and finds the corresponding url(s). The search results are then printed to the console.*/

public final class SearchEngine {

  public static void main(String[] args) {
    
    HashMap <String , ArrayList <String> > internet = new HashMap <> () ;
    
    
    Scanner in = new Scanner(System.in);
    System.out.println("Enter a file:");
    String fileName = in.nextLine();
    
    File words = new File(fileName);
    try {
    Scanner fileScanner = new Scanner(words);
    int q=0;
    while (fileScanner.hasNextLine()==true){
      //System.out.println(internet);
      
      
      String link = fileScanner.nextLine();
      String keyword = fileScanner.nextLine();
      String [] keywords = keyword.split(" ");
     // System.out.println(link+keyword);
      for(String specificWord : keywords){
        if(internet.has(specificWord)==false){
          ArrayList <String> links = new ArrayList <> ();
          links.add(link);
          internet.insert(specificWord,links);
        }

        else {
          //System.out.println("-------------------------------------------------------------");
          internet.get(specificWord).add(link);
          internet.put(specificWord,internet.get(specificWord));
        }
      
     }
     q++;
      //System.out.println("dones");      
    }
    
    
    System.out.println("done, loaded "+internet.size()+" keys, loaded "+ q +" URL's");
    
      
    }
    
    catch (FileNotFoundException ex){
      System.out.println("File not found");
    }
    
    while(true){
        
        System.out.println("Enter Keyword:");
        String search = in.nextLine();
        
        if (internet.has(search)==true){
            //System.out.println(internet.get(search));
            ArrayList <String> results = internet.get(search);

            for (int q=0; q<results.size();q++){
                System.out.println(q+1 +". "+ results.get(q));
                
            }
            System.out.println(results.size()+" search results");
        }
        else{
            System.out.println("Keyword not found");
        }

    }
  }
}

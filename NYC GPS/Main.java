import java.io.*;
import java.util.*;

class Main {
  
  public static WeightedGraph<String, Double> graph;
  public static HashMap<String, Location> locations;
  public static Scanner scanner;

  public static void main(String[] args) {
    
    graph= new WeightedGraph<> ();
    locations = new HashMap <> ();
    
    
    scanner = new Scanner (System.in);
    System.out.println("Input a file name");
    String fileName=scanner.nextLine();
    
    File information= new File (fileName);
    
    try {
      Scanner fileScanner = new Scanner (information);
      int q=0;
      while (fileScanner.hasNextLine()){
        String unfilteredInformation = fileScanner.nextLine();
        String [] informationArray = unfilteredInformation.split(" ");
        String names = informationArray [3];
        String [] startAndEnd = names.split("--");
        String startingLocation = startAndEnd[0];
        //System.out.println(startingLocation);
        String endingLocation = startAndEnd [1];
        double distance = Double.parseDouble(informationArray [2]);
        String [] startLatLongArray = informationArray[0].split(",");
        double startLat= Double.parseDouble(startLatLongArray[0]);
        double startLon= Double.parseDouble(startLatLongArray[1]);
        
        Location infoStart = new Location (startingLocation, startLat, startLon);
        //System.out.println(startingLocation);
        locations.put(startingLocation, infoStart);
        String [] endLatLongArray = informationArray [1].split(",");
        double endLat = Double.parseDouble(endLatLongArray[0]);
        double endLon = Double.parseDouble(endLatLongArray[1]);
        Location infoEnd = new Location (endingLocation, endLat, endLon );
        locations.put(endingLocation,infoEnd);
        graph.addVertex(startingLocation);
        graph.addVertex (endingLocation);
        graph.addEdge(startingLocation, endingLocation, distance);
        //System.out.println(unfilteredInformation);
        //System.out.println(endingLocation);
      }
    }
    
    
    catch(FileNotFoundException ex){
      
    }
    for (String q:locations.keySet()){
      System.out.println(q);
    }
    
    
    //System.out.println(graph);
    //System.out.println ("\n");
    //System.out.println(locations);
    
    
  
  
  
  
  
  while (true){
    System.out.println("\n");
    System.out.println("Starting location?:");
    String starting_location = scanner.nextLine();
    System.out.println("Ending location:?");
    String ending_location= scanner.nextLine();
    try{
    ShortestPath GPS = new ShortestPath (locations.get(starting_location), locations.get(ending_location), graph, locations);
    
    System.out.println("From: "+starting_location +" to: "+ ending_location+" is: "+GPS.calculations());
    }
    
    catch(NullPointerException ex){
      System.out.println("Location not found");
    }
    
   
    
    
    
    
  }
  
}
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}

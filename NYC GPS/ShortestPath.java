import java.util.*; 

public class ShortestPath {
  
  Location startingLocation;
  Location endingLocation;
  
  WeightedGraph <String,Double> graph;
  HashMap <String,Location> locations;
  
  
  ShortestPath(Location startingLocation, Location endingLocation, WeightedGraph graph, HashMap locations){
    this.startingLocation = startingLocation;
    this.endingLocation = endingLocation;
    this.graph = graph;
    this.locations=locations;
  }
  
  public Double calculations(){
   PriorityQueue<Location> unvisited= new PriorityQueue();
  
   startingLocation.setDistance(0);  
   for (Location point:locations.values()){
     if(!point.equals(startingLocation)){
      point.setDistance(Double.MAX_VALUE);
     }
     unvisited.add(point);
   }
  
  Stack<String> order = new Stack <>();
   
   
   
   while (unvisited.size()!=1){
     Location visiting = unvisited.poll();
     //Location point = locations.get(point);
     //System.out.println(startingLocation);
     //System.out.println(startingLocation.getDistance());
     //System.out.println(visiting.getDistance());
     
     //System.out.println(visiting);
     //System.out.println(graph.getEdges(visiting.getName()));
     
     for (String pointPreLocation: graph.getEdges(visiting.getName()).keySet()){
       Location point = locations.get(pointPreLocation);
       //System.out.println(point);
       //System.out.println(point.getDistance());
       //System.out.println(visiting.getDistance());
       //System.out.println(graph.getEdges(visiting.getName()));
        if(graph.getEdges(visiting.getName()).get(pointPreLocation) + visiting.getDistance()< point.getDistance()  ){
          unvisited.remove(point);
          point.setDistance(graph.getEdges(visiting.getName()).get(pointPreLocation)+visiting.getDistance());
          unvisited.add(point);
          point.setPrevious(visiting);
           
         }
        if (point.equals(endingLocation)){
          while(true){
            order.push(point.getName());
            
            if(point.equals(startingLocation)){
              break;
            }
            point=point.getPrevious();
         
          }
          System.out.println("\n");
          while(!order.empty()){
            System.out.println(order.pop());
          }
          unvisited.clear();
          System.out.println("\n");
          return endingLocation.getDistance();
        } 
      }
      
   }
   
    return 0.0;
   
    
    
    
    
    
  }
  
  
  
  
  
  
  
  
  
}

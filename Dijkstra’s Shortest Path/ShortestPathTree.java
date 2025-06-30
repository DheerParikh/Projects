import java.util.*; 
import java.lang.*; 
import java.io.*; 
  
public class ShortestPathTree{ 

  int[][] graph;
  ArrayList<Vertex<Integer>> vertices;
  PriorityQueue<Vertex<Integer>> unvisited;

  public void dijkstra(int[][] graph, int source) {
  vertices= new ArrayList <> ();
  unvisited= new PriorityQueue <> ();
  for (int q=0; q<graph.length; q++){
    Vertex <Integer> v = new Vertex (q);
    vertices.add(v);
  }
  vertices.get(source).setDistance(0);
  
  for (int q=0; q<vertices.size(); q++){
    if(!vertices.get(q).equals(vertices.get(source))){
      vertices.get(q).setDistance(Integer.MAX_VALUE);
    }
    unvisited.add(vertices.get(q));
  }
  
 
  while (unvisited.size()!=1){
    Vertex <Integer> memory = unvisited.poll();
    for (int q=0; q< graph.length; q++){
      if(graph [q] [memory.getLabel()]>0){
        if (vertices.get(q).getDistance()>graph [q] [memory.getLabel()]+memory.getDistance()){
          unvisited.remove(vertices.get(q));
          vertices.get(q).setDistance(graph [q] [memory.getLabel()]+memory.getDistance());
          unvisited.add(vertices.get(q));
          vertices.get(q).setPrevious(memory);  
        }
        
      }
        
      }
      
    }
  
   for (int q=0; q< vertices.size(); q++){
    System.out.println(vertices.get(q));
  }
  
  
  
  
  
  
  
  
    
  }
  
 
   
  
  
    
  
  
   
   
}

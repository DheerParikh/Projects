import java.util.*; 
  
public class WeightedGraph<T,W> implements Network<T, W>{ 
  
  private Map<T, HashMap<T, W>> map = new HashMap<>(); 
  private int numEdges = 0;
  
  
  public int getVertexCount(){
    return this.map.size();
  }
  
  public int getEdgesCount(){
    return this.numEdges;
  }
  
  public boolean hasVertex(T vertex){
    return map.containsKey(vertex);
  }
  
  public boolean hasEdge(T source, T destination){
    if(map.get(source)==null){
      return false;
    }
    else if(map.get(source).containsKey(destination)==true){
      return true;
    }
    return false;
  }
  
  public void addVertex(T vertex){
    map.putIfAbsent(vertex, new HashMap < T, W> () );
    
    
    
  }
  
  public void addEdge(T source, T destination, W weight){
    
    if(map.get(source)==null || map.get(destination)==null){
      System.out.println("Vertex does not exsist");
    }
    else{
     map.get(source).putIfAbsent(destination, weight);
     numEdges++;
    }
  }
    
  public HashMap<T,W> getEdges(T vertex){
    return map.get(vertex);
    
  }
    
  
  
  public void removeVertex (T vertex){
    map.remove(vertex);
  }
  
  public void removeEdge(T source, T destination){
    int q=0;
    while(map.get(source).get(q)!=destination){
      q++;
    }
    map.get(source).remove(q);
    

  }
  
  
  
  
  public String toString(){
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Graph:");
    for (T q:map.keySet()){
      stringBuilder.append("\n"+q+ ": ");
      for(T z:map.get(q).keySet()){
        stringBuilder.append(z + " ("+ map.get(q).get(z)+") ");
      }
    }
  
    return stringBuilder.toString();
  }
} 

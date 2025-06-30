// Main.java

class Main {
    
  
    public static int search (int [] x, int y){
      
      for (int q=0;q<x.length;q++){
        if (x [q]==y){
        return q;
        }
      }
       
      return -1;
    
      
      
    }
    
    
    
    public static int recursionSearch (int [] x,int y,int z){
      
      if (z>x.length-1){
        return -1;
      }
      
      else if (x [z]==y){
        return z;
        
        
      }
      
      else {
        return recursionSearch(x,y,z+1);
        
        
      }
      
      
    }
    
    
  
  
  
    public static void main(String[] args) {
    	int [] x = {1,2,3,4,5,6};
    	System.out.println(recursionSearch(x,1,0));
    }
}

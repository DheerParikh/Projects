// Main.java

class Main {
    
    public static boolean divisibleBy7 (int n){
      
      if(n==7||n==0){
        return true;
      }
      
      else if(n<10){
        return false;
      }
      
      else{
        int z=n%10;
        int everythingelse=(int)(n/10);
        int result=everythingelse-2*z;
        result=Math.abs(result);
        return divisibleBy7(result);
      }
      
      
      
      
      
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /*public static boolean divisibleBy7 (int n){
      
      if (n==7||n==0){
        return true;
      }
      else if(n<10){
        return false;
      }
      
      else {
        int z=n%10;
        int everythingelse=(int)(n/10);
        int result=everythingelse-2*z;
        result=Math.abs(result);
        
        return divisibleBy7(result);
        
      }
      
      
      
      
      
      
      
    }*/
      
  
    public static void main(String[] args) {
    	System.out.println(divisibleBy7(21));
    }
}

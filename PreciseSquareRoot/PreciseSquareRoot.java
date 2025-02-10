class Main {
    
    public static double preciseSquareRoots(int x, double upperboundry, double lowerboundry){
      
      double theSquare=(upperboundry-lowerboundry)/2+lowerboundry;
      if (theSquare*theSquare==x){
        return theSquare;
      }
      
      else if (upperboundry-lowerboundry<=1e-6){
        return theSquare;
      }
      else {
        
        if (theSquare*theSquare>x){
          upperboundry=theSquare;
          theSquare=(upperboundry-lowerboundry)/2+lowerboundry;
          
        }
        
        else{
          lowerboundry=theSquare;
          theSquare=(upperboundry-lowerboundry)/2+lowerboundry;
          
          
        }

        return (preciseSquareRoots(x,upperboundry,lowerboundry));
      }
      
      
      
      
      
    }
  
  
  
  
  
    public static void main(String[] args) {
      int x=150;
      double upperboundry=x;
      double lowerboundry=0;
      double theSquare=0;
      System.out.println(preciseSquareRoots(x,upperboundry,lowerboundry));	
    }
}

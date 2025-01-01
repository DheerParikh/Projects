 // Main.java
import java.util.Arrays;
import java.util.Scanner;
class Main {
  
  public static void grid(String [] [] dashes){
    System.out.print (" ");
    for (int q = 0; q<10; q++){
      System.out.print (q + " ");
    } 
    
    System.out.println (" ");
    for (int q=0; q<10; q++){
      System.out.print (q);
      for (int z=0; z<10; z++){
        System.out.print (dashes [q] [z]+ " ");
      }
      System.out.println(" ");
    }
      
    
  }
  
  public static String [] [] battleShipPlaces (){
    String [] [] battleShipArray = new String [10] [10];
    for (int q=0; q<10; q++){
      for (int z=0; z<10; z++){
        battleShipArray [q] [z] = "-";
      }
    }
    // One battleship, three long
    int e= (int)(Math.random()*10);
    int w = (int)(Math.random()*10);
    int y = (int)(Math.random()*4);
    int p =(int)(Math.random()*2);
    int t= (int)(Math.random()*3);
    battleShipArray [e] [w] = "b";
    if (w > 7) {
        if (p==1){
          battleShipArray [e] [w-1]="b";
          battleShipArray [e] [w-2]="b";
        }
        else if (e>7) {
          battleShipArray [e-1] [w]= "b";
          battleShipArray [e-2] [w]= "b";
        }
        else {
          battleShipArray [e+1] [w] = "b";
          battleShipArray [e+2] [w] = "b";
        }
    }
    else if (w<2){
      if (p==1){
        battleShipArray [e] [w+1] = "b";
        battleShipArray [e] [w+2] = "b";
      }
      else if (e>7){
        battleShipArray [e-1] [w] = "b";
        battleShipArray [e-2] [w] = "b";
      }
      else {
        battleShipArray [e+1] [w] = "b";
        battleShipArray [e+2] [w] = "b";
      }
    }
    else if (e > 7) {
      if (t==1) {
        battleShipArray [e-1] [w] = "b";
        battleShipArray [e-2] [w] = "b";
      }
      else if (t==2){
        battleShipArray [e] [w+1] = "b";
        battleShipArray [e] [w+2] = "b";
      }
      else {
        battleShipArray [e] [w-1] = "b";
        battleShipArray [e] [w-2] = "b";
      }
    }
    else if (e<2) {
      if (t==1){
        battleShipArray [e+1] [w] = "b";
        battleShipArray [e+2] [w] = "b";
      }
      else if (t==2){
        battleShipArray [e] [w+1] = "b";
        battleShipArray [e] [w+2] = "b";
      }
      else {
        battleShipArray [e] [w-1] = "b";
        battleShipArray [e] [w-2] = "b";
      }
    }
    else {
      if (y==1){
        battleShipArray [e] [w+1] = "b";
        battleShipArray [e] [w+2] = "b";
      }
      else if (y==2){
        battleShipArray [e] [w-1] = "b";
        battleShipArray [e] [w-2] = "b";
      }
      else if (y==3){
        battleShipArray [e+1] [w] = "b";
        battleShipArray [e+2] [w] = "b";
      }
      else {
        battleShipArray [e-1] [w] = "b";
        battleShipArray [e-2] [w] = "b";
      }
    }
    // end of one battleship
    // start of two piece battleship
    int m = (int)(Math.random()*9);
    int n = (int)(Math.random()*9);
    while(m==e || n==w ){
      if (m==e){
        m= (int)(Math.random()*9);
      }
      if (n==w){
        n= (int)(Math.random()*9);
      }
    }
    
  while (true) {
    battleShipArray [m] [n] = "b";
    if (p==1 && battleShipArray [m] [n+1] != "b"){
      battleShipArray [m] [n+1] = "b";
      break;
    }
    else if (battleShipArray [m+1] [n] != "b")  {
      battleShipArray [m+1] [n] = "b";
      break;
    }
    else {
      battleShipArray [m] [n] = "-";
      m = (int)(Math.random()*9);
      n = (int)(Math.random()*9);
    }
  }
  // end of two piece battle ship

    System.out.println (Arrays.deepToString(battleShipArray));
    return (battleShipArray);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  
  
  
  
  
  
  public static boolean gridWithInput(String [] [] finalBattleShipPlaces, String [] [] dashes){
    Scanner in = new Scanner (System.in);
    
    System.out.println ("What collum?");
    int z= in.nextInt();
    System.out.println ("What row?");
    int q = in.nextInt();
    if (dashes [q] [z] == "x" || dashes [q] [z] == "O"){
      System.out.println ("you already hit this one");
      return false;
    }
    else if (finalBattleShipPlaces [q] [z] == "b"){
      dashes [q] [z] = "x";
      return true;
      
    }
    else{
      dashes [q] [z] = "O";
      return false;
    }
  }
  
  public static String [] [] computerBattleshipPlacement (){
    Scanner in = new Scanner (System.in);
    Scanner placement = new Scanner (System.in);
    String [][] computerDashes = new String [10] [10];
    for (int q=0; q<10; q++){
        for (int z=0; z<10; z++){
          computerDashes [q] [z] = "-";
        }
      }
    System.out.println ("Where would the starting point of your three long battleship to be?");
    System.out.println ("collum?");
    int z= in.nextInt();
    System.out.println ("row?");
    int q= in.nextInt();
    System.out.println ("vertical or horizontal?");
    String h= placement.nextLine();
    
    if (h.equals ("vertical")){
      computerDashes [q] [z] = "b";
      computerDashes [q+1] [z] ="b";
      computerDashes [q+2] [z] = "b";
    }
    else {
      computerDashes [q] [z] = "b";
      computerDashes [q] [z+1] = "b";
      computerDashes [q] [z+2] = "b";
    }
  System.out.println ("Where would the starting point of your two long battleship to be?");
  System.out.println ("collum?");
  z= in.nextInt();
  System.out.println ("row?");
  q= in.nextInt();
  System.out.println ("vertical or horizontal?");
  h= placement.nextLine();
    if (h.equals ("vertical")){
      computerDashes [q] [z] = "b";
      computerDashes [q+1] [z] ="b";
    }
    else {
      computerDashes [q] [z] = "b";
      computerDashes [q] [z+1] = "b";
    }
      grid(computerDashes);    
      return computerDashes;
  }
  
  public static boolean computerGuessing (String [] [] computerGrid, String [] [] computerHits){
    int q = (int)(Math.random()*10);
    int z = (int)(Math.random()*10);
    
    while (computerHits [q] [z] == "x" || computerHits [q] [z] == "O"){
      q = (int)(Math.random()*10);
      z = (int) (Math.random()*10);
    }
    
    if (computerGrid [q] [z] == "b"){
      computerHits [q] [z] = "x";
      
      return true;
    }
    else {
      computerHits [q] [z] = "O";
      return false;
    }
   
    
  }
  
  

  
  
  
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static void main(String[] args) {
    	
    	// user code preset
    	int e=0;
      int u=0;
    	battleShipPlaces();
    	String [] [] finalBattleShipPlaces = battleShipPlaces();
    	String [] [] dashes = new String [10] [10] ;
      for (int q=0; q<10; q++){
        for (int z=0; z<10; z++){
          dashes [q] [z] = "-";
        }
      }
      String [] [] computerGrid = computerBattleshipPlacement();
    	Scanner placement = new Scanner (System.in);
      String [][] computerHits = new String [10] [10];
      for (int q=0; q<10; q++){
        for (int z=0; z<10; z++){
          computerHits [q] [z] = "-";
        }
      }
    	//computerGuessing(computerGrid, computerHits);
      
      
      
      
      
      
    	while (true){
    	// User AI
    	if (e==5){
    	  grid(dashes);
    	  System.out.println ("You win");
    	  break;
    	}
    	grid(dashes); 
    	if (gridWithInput(finalBattleShipPlaces, dashes)){
    	  e++;
    	  
    	}
    	System.out.println ("Your view");
    	grid(dashes);
    	
    	// Computer logic
    		if (computerGuessing(computerGrid, computerHits)){
    	  u++;
    	  if (u==5){
    	    grid(computerHits);
    	    System.out.println("Computer Wins!");
    	    break;
    	  }
    	}
    	System.out.println("computer veiw");
    	grid(computerHits);
    	System.out.println(u);
    	
    	}
    	
  
    	

    }
}

import java.util.*;

public class Bakery {
  private String name;
  private String address;
  private ArrayList<BakedGood> bakedGoods = new ArrayList<>();
  private ArrayList<Worker> workers = new ArrayList<>();

  public Bakery(String n, String a) {
    name = n;
    address = a;
  }

  // NESTED BAKEDGOODS CLASS ----------------------------------------
  private final class BakedGood {
    private String name;
    private String[] ingredients;
    private int numIngredients;
    private String flavour;
    private int batchSize;

    public BakedGood(String n, String[] i, int ni, String f, int b) {
    this.name = n;
    this.ingredients = i;
    this.numIngredients = ni;
    this.flavour = f;
    this.batchSize = b;
    }

    public String getFlavour() {
    return flavour;
    }

    public int getNumIngredients() {
      return numIngredients;
    }

    public void setBatchSize(int b) {
      batchSize = b;
    }

    private String returnIngredients() {
      String ingredientsList = "";

      for (int i = 0; i < numIngredients; i++) {
        if (i < numIngredients - 1) {
          ingredientsList += ingredients[i] + ", ";
        } else {
          ingredientsList += ingredients[i];
        }
      }
      return ingredientsList;
    }

    public String toString() {
      return name + "\n\tFlavour: " + flavour + "\n\tIngredients: " + returnIngredients();
    }
  }

  // NESTED WORKER CLASS --------------------------------------------
  private final class Worker {
    private String name;
    private String position;
    private boolean employeeOfTheMonth;
    private double salary;

    public Worker(String n, String p, boolean e, double s) {
      name = n;
      position = p;
      employeeOfTheMonth = e;
      salary = s;
    }

    public String getName() {
      return name;
    }

    public double getSalary() {
      return salary;
    } 

    public void giveRaise(double raiseIncrease) {
      salary += raiseIncrease;
    }

    public boolean isEmployeeOfTheMonth() {
      return employeeOfTheMonth;
    }

    public void makeEmployeeOfTheMonth() {
      employeeOfTheMonth = true;
    }

    public String getPosition(){
      return position;
    }

    public void changePosition(String p){
      position = p;
    }

    public String toString() {
      String s = "Name: " + name + "\n\tPosition: " + position + "\n\tSalary: $" + String.format("%.2f", salary) + " per hour";

      if (employeeOfTheMonth) {
        s += "\n\tEmployee of the Month";
      }

      return s; 
    }
  }

  //PROVIDED METHODS ------------------------------------------------
  public String getName() {
    return name;
  }
  public String getAddress() {
    return address;
  }
  public int getNumWorkers() {
    return workers.size();
  }

  //BAKERY METHODS --------------------------------------------------
  
  /**
  * creates the given number of Worker objects and adds them to the workers ArrayList
  * @param numWorkers - the number of Worker objects to create
  **/
  public void hireWorkers(int numWorkers) {
    for(int z=0;z<numWorkers;z++){
      System.out.println("What is the name of the worker?");
      Scanner in= new Scanner(System.in);
      String name=in.nextLine();
    
      System.out.println("What is the posistion of the worker?");
      String posistion=in.nextLine();
    
      System.out.println("is he the employeeOfTheMonth?");
      boolean employeeOfTheMonth=in.nextBoolean();
    
      System.out.println("What is his salary?");
      double salary=in.nextDouble();
    
      
      
        workers.add(new Worker(name,posistion,employeeOfTheMonth,salary));
      
    }
    
  }
  /**
  * creates the given number of BakedGood objects and adds them to the bakedGoods ArrayList
  * @param numBakedGoods - the number of BakedGood objects to create
  **/
  public void addBakedGoods(int numBakedGoods) {
    for (int z=0; z<numBakedGoods;z++){
      System.out.println("What is the name of the good?");
      Scanner in=new Scanner(System.in);
      String name=in.nextLine();
    
      System.out.println("How many ingredients are there?");
      int ingredientAmount=in.nextInt()+1;
    
      System.out.println("What are the ingredients?");
      String [] ingredients=new String [ingredientAmount];
      for(int q=0; q<ingredientAmount;q++){
        ingredients[q]=in.nextLine();
      }

      System.out.println("What is the flavour");
      String flavour=in.nextLine();
    
      System.out.println("What is the batch size");
      int batchSize = in.nextInt();
    
      
      bakedGoods.add(new BakedGood(name,ingredients,ingredientAmount,flavour, batchSize));
      
    }
 
    
    
    
  }
  public String toString() {
    String goods= "";
    for (int x=0; x<bakedGoods.size(); x++){
      goods= goods + (bakedGoods.get(x));
    }
    
    String returnWorkers="";
    for(int z=0; z<workers.size();z++){
      returnWorkers=returnWorkers+(workers.get(z));
      
    }
    
    return goods+"\n"+returnWorkers; 
    
    
    
   
  }
}

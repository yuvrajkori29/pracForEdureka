package practice;

//to import scanner class and utility functionalities.
import java.util.*;  


//Abstract class for Animal
abstract class Animal{
	protected String nameAnimal;
	protected String colorAnimal;
	
	Animal(String nameAnimal, String colorAnimal)
	{
		this.nameAnimal = nameAnimal;
		this.colorAnimal = colorAnimal;
	}
	
	Animal(){}
	abstract void breathe();  //function to tell how they can breathe
}

//Extending Animal class by the help of 4 classes.

//class lion

class Lion extends Animal{
	
	Lion(String nameAnimal,String colorAnimal)
	{
		super(nameAnimal,colorAnimal);
	}
   
	Lion()
	{
		super();
	}
	void breathe() {
		System.out.println("Welcomne to Lion Kingdom : I breathe using Lungs " );
	}
	void home()
	{
		System.out.println("Hey, I live in Forest and I am The King Of Jungle :"
				+ "Caution : I am  bit dangerous. " );
	}
}

class Frog extends Animal{
	
	Frog(String nameAnimal,String colorAnimal)
	{
		super(nameAnimal,colorAnimal);
	}
   
	Frog()
	{
		super();
	}
	
	void breathe() {
		System.out.println("Welcomne to Frog Kingdom : I breathe using Lungs. " );
	}
	void home()
	{
		System.out.println("Hey, I am amphibian and I live on land as well as water"
				+ "Caution : You usually have seen me during rainy season. " );
	}
}

class Cow extends Animal{
	
	Cow(String nameAnimal,String colorAnimal)
	{
		super(nameAnimal,colorAnimal);
	}
   
	Cow()
	{
		super();
	}
	void breathe() {
		System.out.println("Welcomne to Cow Kingdom : I breathe using Lungs " );
	}
	void home()
	{
		System.out.println("Hey,I live on land and btw Did you drank your milk today "
				+ "Fact : Have you ever heard about cowdung cakes. " );
	}
}

class Fish extends Animal{
	
	Fish(String nameAnimal,String colorAnimal)
	{
		super(nameAnimal,colorAnimal);
	}
   
	Fish()
	{
		super();
	}
	void breathe() {
		System.out.println("Welcomne to Fish Kingdom : I breathe using Gills " );
	}
	void home()
	{
		System.out.println("Hey,You'll find me in Water. Do you want to swim : ?? "
				+ "Fact : Water Child " );
	}
}

//This is the main method to access all classes(Lion,Frog,Fish,Cow)
public class AssesmentAnimal {
	public static void main(String args[])
	{
		 System.out.println("");
		 System.out.println("-------------------------------------------------------------------");
		 System.out.println("");
		 System.out.println("                         Hello Welcome To Animal Kingdom      ");
	     System.out.println("-------------------------------------------------------------------");
	     System.out.println("");
		 
	     
	     //This is an arrayList to store list of animals
		 ArrayList<Animal> animalsList =  new ArrayList<>();
		 Scanner sc = new Scanner(System.in);
		 
		 System.out.println("Enter the Total Animals in KingDom : " );
		 int lenKingdom = sc.nextInt();
		 int j =1;
		 
		 //user input to enter no of animals
		 for(int i=0;i<lenKingdom;i++)
		 {
			 
			 System.out.print("Enter the name of "+ j + " Animal (Lion,Cow,Frog,Fish) : ");
			 String animalName = sc.next();
			 j++;
//			 animalName.toUpperCase();
			 
			 if(animalName.equalsIgnoreCase("LION"))
			 {
				 Animal obj = new Lion("Lion","Yellow");
				 animalsList.add(obj);
			 }
			 else if(animalName.equalsIgnoreCase("COW"))
			 {
				 Animal obj = new Cow("Cow","White");
				 animalsList.add(obj);
			 }
			 else if(animalName.equalsIgnoreCase("FISH"))
			 {
				 Animal obj = new Fish("Fish","Blue");
				 animalsList.add(obj);
			 }
			 else if(animalName.equalsIgnoreCase("FROG"))
			 {
				 Animal obj = new Frog("Frog","Green");
				 animalsList.add(obj);
			 }
			 else 
			 {
				System.out.println("Oh you wasted your chance you entered wrong Animal");
				lenKingdom--;
			 }
		 }
		 
		 //Printing The animals in Kingdom.
		 System.out.println("-------------------------------------------------------------------");
	     System.out.println("Total Animals In Kingdom Are : " + lenKingdom);
		 System.out.println("-------------------------------------------------------------------");
		 for(Animal list : animalsList)
		 {
			 System.out.println("Name of Animal: "+ list.nameAnimal);
			 
			 
			 if(list.nameAnimal.equalsIgnoreCase("LION"))
			 {
				 Lion obj = new Lion();
				 obj.breathe();
				 obj.home();
				
			 }
			 else  if(list.nameAnimal.equalsIgnoreCase("FROG"))
			 {
				 Frog obj = new Frog();
				 obj.breathe();
				 obj.home();
				
			 }
			 else  if(list.nameAnimal.equalsIgnoreCase("COW"))
			 {
				 Cow obj = new Cow();
				 obj.breathe();
				 obj.home();
				
			 }
			 else  if(list.nameAnimal.equalsIgnoreCase("FISH"))
			 {
				 Fish obj =  new Fish();
				 obj.breathe();
				 obj.home();
				
			 }			 
		
			 System.out.println("Color of  " + list.nameAnimal +  "  " + list.colorAnimal);
			 System.out.println("-------------------------------------------------------------------");
			 
		 }
		 
		 sc.close();
		 
	}
}
 
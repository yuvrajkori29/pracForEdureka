package practiceProblems;

import java.util.*;

abstract class Furniture{
	String nameOfFurniture;
	
	Furniture(String nameOfFurniture)
	{
		this.nameOfFurniture = nameOfFurniture;
		
	}
}

interface operationSit{
	void sit(); //sofa
}

interface operationKeep{
	void keep();   //Table
}

interface operationStore
{
	void store();  //cupboard
}

class SitAndStore extends Furniture  implements operationSit,operationStore{
	SitAndStore(String nameOfFurniture){
		super(nameOfFurniture);
		sit();
		store();
	}
	
	public void sit()
	{
		System.out.println("To sit " + nameOfFurniture);
	}
	
	public void store()
	{
		System.out.println("To store  " + nameOfFurniture);
	}
	
}

class Sit extends Furniture  implements operationSit{
	Sit(String nameOfFurniture){
		super(nameOfFurniture);
		sit();
		
	}
	
	public void sit()
	{
		System.out.println("To sit " + nameOfFurniture);
	}
	
}
public class accessFurnitures {
	public static void main(String[] args) {
    	    Furniture st = new SitAndStore("bed");
    	    Furniture st1 = new Sit("Table");
    	    
      }
}

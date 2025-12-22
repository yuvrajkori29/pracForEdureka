package practiceProblems;


abstract class CakeFactory{
	public abstract void createCake();
}

class Cake extends CakeFactory {
	 String nameCake;
	 String flavourOfCake;
	
	Cake(String nameOfCake,String flavourOfCake)
	{
		this.nameCake = nameOfCake;
		this.flavourOfCake = flavourOfCake;
	}
	
//    void aboutCake() {
//    	
//    }
    public void createCake()
    {
    	System.out.println("This is " + nameCake + flavourOfCake);
    }
	
}

class Blueberry extends Cake{
	Blueberry(String nameCake,String flavourOfCake)
	{
		super(nameCake,flavourOfCake);
		
	}
	
}

public class factoryDesignPrac{
	public static void main(String[] args)
	{
		Cake cake1 = new Blueberry("blueberry"," blueberry");
		
		cake1.createCake();

	}

}

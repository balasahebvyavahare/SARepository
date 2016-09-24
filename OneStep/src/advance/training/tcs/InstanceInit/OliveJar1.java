package advance.training.tcs.InstanceInit;

import java.util.ArrayList;

import advance.training.tcs.Olive;

public class OliveJar1 {

	/**
	 * @param args
	 */
	public  ArrayList<Olive> olives; 
	
	{                                           // this non static block will be called once in lifetime of class // it would be called before any constructor. 
		
		System.out.println("Starting Application...");
		
		olives = new ArrayList<>();
		
		olives.add(new Olive("GoldenOlive"));
		
	}
	
    public OliveJar1()
    {
    	System.out.println("Constructor ......");
    }
    
    public OliveJar1(int nOlives, String nameOlive , long color)
    {
    	for(int i = 0; i <nOlives ; i++){
    		olives.add(new Olive(nameOlive , color));
    	}
    }

}

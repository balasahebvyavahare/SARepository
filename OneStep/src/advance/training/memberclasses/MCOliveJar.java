package advance.training.memberclasses;

import java.util.ArrayList;

import advance.training.tcs.Olive;

public class MCOliveJar {

	/**
	 * @param args
	 */
	public  ArrayList<MCOlive> olives; 
	
	{                                           // this non static block will be called once in lifetime of class // it would be called before any constructor. 
		
		System.out.println("Starting Application...");
		
		olives = new ArrayList<>();
		
		olives.add(new MCOlive("GoldenOlive"));
		
	}
	
    public MCOliveJar()
    {
    	System.out.println("Constructor ......");
    }
    
    public MCOliveJar(int nOlives, String nameOlive , long color)
    {
    	for(int i = 0; i <nOlives ; i++){
    		olives.add(new MCOlive(nameOlive , color));
    	}
    }
    
    public void addOlive(String oliveName , long color){
    	olives.add(new MCOlive(oliveName , color));
    }
    
    public void reportOlive(){
    	for(MCOlive o : olives){
    		System.out.println("Its  : " + o.oliveName);
    	}
    }
    
    
    public class MCOlive {    // INNER CLASS
    	
    	public static final long BLACK = 0x000000; // Final fields mentioned in Capital ,  
    	
    	public String oliveName;
    	public long color = BLACK;
    	
    	public MCOlive() {
    	}

    	public MCOlive(String oliveName) {
    		this.oliveName = oliveName;
    	}
    	
    	public MCOlive(String oliveName, long color) {
    		this(oliveName);
    		this.color = color;
    	}
    	
    	public String toString() {
    		return "name: " + this.oliveName + ": " + "color   : " +  this.color;
    	}

    }


}

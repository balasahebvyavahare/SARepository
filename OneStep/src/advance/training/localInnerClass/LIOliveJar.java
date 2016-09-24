package advance.training.localInnerClass;

import java.util.ArrayList;

import advance.training.tcs.Olive;

public class LIOliveJar {

	/**
	 * @param args
	 */
	public  ArrayList<LIOlive> olives; 
	
	{                                           // this non static block will be called once in lifetime of class // it would be called before any constructor. 
		
		System.out.println("Starting Application...");
		
		olives = new ArrayList<>();
		
		olives.add(new LIOlive("GoldenOlive"));
		
	}
	
    public LIOliveJar()
    {
    	System.out.println("Constructor ......");
    }
    
    public LIOliveJar(int nOlives, String nameOlive , long color)
    {
    	for(int i = 0; i <nOlives ; i++){
    		olives.add(new LIOlive(nameOlive , color));
    	}
    }
    
    public void addOlive(String oliveName , long color){
    	olives.add(new LIOlive(oliveName , color));
    }
    
    public void reportOlive(){
    	
    	class JarLid{                        
    		public void open(){
    			System.out.println("Twist twist twist ...");
    			System.out.println("Open");
    		}
    	}
    	
    	new JarLid().open();    // INNER classes can be used to define complex functionality
    	
    	for(LIOlive o : olives){
    		System.out.println("Its  : " + o.oliveName);
    	}
    }
    
    
    public class LIOlive {    // INNER CLASS
    	
    	public static final long BLACK = 0x000000; // Final fields mentioned in Capital ,  
    	
    	public String oliveName;
    	public long color = BLACK;
    	
    	public LIOlive() {
    	}

    	public LIOlive(String oliveName) {
    		this.oliveName = oliveName;
    	}
    	
    	public LIOlive(String oliveName, long color) {
    		this(oliveName);
    		this.color = color;
    	}
    	
    	public String toString() {
    		return "name: " + this.oliveName + ": " + "color   : " +  this.color;
    	}

    }


}

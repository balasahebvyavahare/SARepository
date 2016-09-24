package advance.training.tcs.staticinit;

import java.util.ArrayList;
import advance.training.tcs.*;

public class OliveJar {

	/**
	 * @param args
	 */
	public static ArrayList<Olive> olives;
	
	static {                                               // The static initializer , We are using this in class StaticInit.java , This block is called automatically. 
		
		System.out.println("Starting Application...");
		
		olives = new ArrayList<>();
		
		olives.add(new Olive("MangoOlive"));
		olives.add(new Olive("SantraOlive"));
		olives.add(new Olive("ChikuOlive"));
		
	}

}

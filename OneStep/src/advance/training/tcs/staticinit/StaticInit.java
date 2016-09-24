package advance.training.tcs.staticinit;

import java.util.ArrayList;

import advance.training.tcs.Olive;

public class StaticInit {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		ArrayList<Olive> OliveList = OliveJar.olives;
		System.out.println("Initializing....");
		
		for(Olive o:OliveList){
			System.out.println("Its " + o.oliveName);
		}
		
	}

}

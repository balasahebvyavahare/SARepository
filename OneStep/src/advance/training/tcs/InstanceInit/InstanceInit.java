package advance.training.tcs.InstanceInit;

import java.util.ArrayList;

import advance.training.tcs.Olive;

public class InstanceInit {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Olive> oliveList = new OliveJar1(2, "GuOlive" , 0X000000 ).olives;
		
			
		
		for(Olive o:oliveList){
			System.out.println("Its " + o.oliveName);
		}
		
	}

}

package advance.training.EnumClasses;

import java.util.ArrayList;

public class MemberClassesDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EnumOliveJar jar = new EnumOliveJar();
		
		jar.addOlive(EnumOlive.G, 0x00000);
		jar.addOlive(EnumOlive.H, 0x00000);
		jar.addOlive(EnumOlive.T, 0x00000);
		jar.addOlive(EnumOlive.S, 0x00000);
		
		
		jar.reportOlive();
		
		
		
	}

}

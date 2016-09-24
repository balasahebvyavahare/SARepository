package advance.training.EnumClasses;

import java.util.ArrayList;

public class MemberClassesDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EnumOliveJar jar = new EnumOliveJar();
		
		jar.addOlive(EnumOlive.GU, 0x00000);
		jar.addOlive(EnumOlive.HUGAN, 0x00000);
		jar.addOlive(EnumOlive.TATTI, 0x00000);
		jar.addOlive(EnumOlive.SANDAS, 0x00000);
		
		
		jar.reportOlive();
		
		
		
	}

}

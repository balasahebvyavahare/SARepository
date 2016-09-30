package advance.training.memberclasses;

import java.util.ArrayList;

public class MemberClassesDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MCOliveJar jar = new MCOliveJar();
		
		jar.addOlive("TOlive", 0x00000);
		jar.addOlive("GOlive", 0x00000);
		jar.addOlive("SmellyOlive", 0x00000);
		jar.addOlive("TAgain_Olive", 0x00000);
		jar.addOlive("GBlackForest", 0x00000);
		jar.reportOlive();
		
		
		
	}

}

package advance.training.memberclasses;

import java.util.ArrayList;

public class MemberClassesDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MCOliveJar jar = new MCOliveJar();
		
		jar.addOlive("TattiOlive", 0x00000);
		jar.addOlive("GuOlive", 0x00000);
		jar.addOlive("SmellyOlive", 0x00000);
		jar.addOlive("TattiAgain_Olive", 0x00000);
		jar.addOlive("GuBlackForest", 0x00000);
		jar.reportOlive();
		
		
		
	}

}

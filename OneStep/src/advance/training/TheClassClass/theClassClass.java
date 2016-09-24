package advance.training.TheClassClass;

public class theClassClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EnumOliveJar jar = new EnumOliveJar();
		
		Class <?> c = jar.getClass();
		
		System.out.println(c.getName());
		System.out.println(c.getSimpleName());
				
		
	}

}




public class PrintHi {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	   String s = new String("s111111\"1111umit");
	   
	   
	   
	   int counter = 0;
	   for( int i=0; i<s.length(); i++ ) {
	       if( s.charAt(i) == '"' ) {
	           counter++;
	       } 
	       
	   }
	   System.out.println(counter);
	   System.out.println("comminting the first change to git local");
	   System.out.println("test1");
	}

}

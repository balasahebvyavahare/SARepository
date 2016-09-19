package coreJava.Inheritance;

class A{
	int i = 5, j = 7 ;
	
	void showIJ(){
		System.out.println("I and J in A " + i + "  " + j );
	}
	
}

class B extends A{
	
	int k = 10;
	
	void showIJK(){
		System.out.println("I and J and K in A " + i + "  " + j + " " + k);
	}
}


public class SimpleInheritance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		B b = new B();
		int a = new A().hashCode();
	
		System.out.println("hashcode with two people contributing to one repo  " + a);
		
	}

}

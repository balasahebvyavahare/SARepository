package j_completereference;


public class ClassDemo {

	static int a = 0;
	int b = 5;

	public void printa() {
		System.out.println("The Value of a is : " + a);
	}
	
	public static void staticMethodDemo()
	{
		System.out.println("I am in static and the value of a is :" + a );
	}

	public static void main(String[] args) {

		ClassDemo obj = new ClassDemo();
		obj.printa();
	}

}

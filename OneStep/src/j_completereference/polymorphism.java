package j_completereference;

class A2 {
	int i = 10;

	public void printValue() {
		System.out.println("Value-A");
	};
}

class B2 extends A2 {
	int i = 12;

	public void printValue() {
		System.out.print("Value-B");
	}
}

public class polymorphism {
	public static void main(String argv[]) {

		A2 a = new B2();
		a.printValue();
		System.out.println(a.i);

	}
}

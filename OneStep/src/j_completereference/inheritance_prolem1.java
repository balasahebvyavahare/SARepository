package j_completereference;

class A {
	int add(int i, int j) {
		return i + j;
	}
}

public class inheritance_prolem1 extends A {

	public static void main(String[] args) {
		int s = 9;
		System.out.println(add(s, 6));

	}
}


/*Cannot make a static reference to the non-static method add(int, int) from the type A. The
short s is autoboxed correctly, but the add() method cannot be invoked from a static
method because add() method is not static. */
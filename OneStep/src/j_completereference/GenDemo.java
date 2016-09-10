package j_completereference;

class Gen<T ,V> {
	T ob1;
	V ob2;

	Gen(T o1 , V o2) {
		ob1 = o1;
		ob2 = o2;
		
	}

	T getob1() {
		return ob1;
	}
	
	V getob2() {
		return ob2;
	}

	void showO1Type() {
		System.out.println("Type of T is " + ob1.getClass().getName());
	}
	void showO2Type() {
		System.out.println("Type of V is " + ob2.getClass().getName());
	}
}

public class GenDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Gen<String , Integer> gendemo1 = new Gen<String, Integer>("Sumit" , 100);
		gendemo1.showO1Type();
		gendemo1.showO2Type();
		
		String str = gendemo1.getob1();
		int i = gendemo1.getob2();
		
		System.out.println("value ob1 = " + str);
		System.out.println("value ob2= " + i);
		
	}

}

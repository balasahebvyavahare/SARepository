package j_completereference;

public class outerClass {

	int outer_x = 5;

	class innerClass {

		int inner_y = 7;

		void display() {
			System.out.println("value of outer X : " + outer_x);
			System.out.println("value of inner Y : " + inner_y);
		}

	}

	void test() {
		innerClass inner = new innerClass();
		inner.display();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		outerClass oc = new outerClass();
		oc.test();

	}

}

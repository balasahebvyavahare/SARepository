package j_completereference;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

class MyComp implements Comparator<String> {

	public int compare(String a , String b){
		
		return (b.compareTo(a));
	}
	
}

public class TreeSetDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		TreeSet<String> ts = new TreeSet<>(new MyComp());

		ts.add("A");
		ts.add("E");
		ts.add("C");
		ts.add("B");
		ts.add("F");
		ts.add("D");

		Iterator<String> it = ts.iterator();

		while (it.hasNext()) {
			String s = it.next();
			System.out.println("TreeSetWithIterator + " + s);
		}

		System.out.println("Test: + " + ts);

	}

}

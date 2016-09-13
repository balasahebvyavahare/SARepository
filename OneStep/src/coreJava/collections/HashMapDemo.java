package coreJava.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashMap<Integer, String> hm = new HashMap<Integer, String>();

		hm.put(1, "sumit");
		hm.put(2, "Amit");
		hm.put(3, "rohit");

		Set<Map.Entry<Integer, String>> sp = hm.entrySet();

		for (Map.Entry<Integer, String> me : sp) {
			System.out.print("key " + me.getKey());
			System.out.println(" value " + me.getValue());
		}

	}
}

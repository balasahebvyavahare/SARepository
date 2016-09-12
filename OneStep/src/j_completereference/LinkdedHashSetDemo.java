package j_completereference;

import java.util.LinkedHashSet;

import j_completereference.HashSetDemo;

public class LinkdedHashSetDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Employee e = new Employee( 1 , "first");
		
		LinkedHashSet<Employee> lhs = new LinkedHashSet<Employee>();

		lhs.add(e);
		lhs.add(new Employee(2,"Second"));
		for( Employee e1 : lhs) System.out.println("Employee " + e1.getName());
		
	}

}

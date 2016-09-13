package coreJava.collections;

import java.util.HashSet;

class Employee{
	
	int empId;
	String empName;
	
	Employee(int id , String name)
	{
		this.empId = id;
		this.empName = name;
	}
	
	String getName(){
		return(this.empName);
	}
	
}


public class HashSetDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<Employee> hs = new HashSet<Employee>();
		
		Employee testDuplicate = new Employee(6, "TESTDUPLICATE");
		
		hs.add(new Employee(1, "Sumit"));
		hs.add(new Employee(2, "Amit"));
		hs.add(new Employee(3, "I"));
		hs.add(new Employee(4, "LOVE"));
		hs.add(new Employee(5, "JAVA"));
		hs.add(testDuplicate);
		hs.add(testDuplicate);  // Duplicate will be discarded
		
		for(Employee e: hs ) System.out.println("Value : = " + e.getName());
		
		
		
		
		
		
		
	}

}

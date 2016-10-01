package coreJava.collections;

import java.util.ArrayList;

public class ArrayListDemo {

	public static void main(String args[]){
		
		// Creating instance of String ArrayList
		ArrayList<String> a = new ArrayList<String>();
		
		
		//Add Method of ArrayList
		a.add("Sumit");
		a.add("Amit");
		
		//Add with Index method of ArrayList
		a.add(1,"Rohit");
		
		//Printint the size of ArrayList
		System.out.println("Contents of AL = : " + a.size() );
		
		//Remove method of ArrayList
		a.remove(1);
		
		//Printing the contents of ArrayList
		System.out.println("Contents of AL = : " + a ) ;
		
		
		// toArray Method of ArrayList
		String alarray[] = new String[a.size()];
		alarray = a.toArray(alarray);
		
		for(String s :a ) System.out.println(s);
		
		
	}
	
	
	
}

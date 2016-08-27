package j_completereference;

public class SplitDemo {
	
	public static void main(String args[]){
		
		String str = "10001|1953-09-02|Georgi|Facello|M|1986-06-26|d005";
		
		String str1[] = str.split("\\|");
		
		System.out.println(str1[1]);
		
	}

}

package Collection;

import java.util.ArrayList;
import java.util.List;

public class ListExp1 {
	
	public static void main(String[] args) {
		
		List<String> lt = new ArrayList<>();
		lt.add("Manish");
		lt.add("Aashu");
		lt.add("Saurabh");
		lt.add("Maurya");
		
		
		for(String val:lt) {
			System.out.println("List Val... "+val);
		}
	}

}

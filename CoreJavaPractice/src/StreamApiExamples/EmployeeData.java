package StreamApiExamples;

import java.util.Arrays;
import java.util.List;

public class EmployeeData {
	
	public static List<Employee> getAllEmp(){
		Projects p1 = new Projects("P001", "Alfa", "ABC Corp", "Alice");
		Projects p2 = new Projects("P002", "Beta", "ABCD Corp", "Bob");
		Projects p3 = new Projects("P003", "Gama", "ABC Corp", "Zebra");
		Projects p4 = new Projects("P004", "Zeta", "ABCE Corp", "Lion");
		Projects p5 = new Projects("P005", "Leta", "ABCF Corp", "Deer");
		Projects p6 = new Projects("P006", "Feta", "ABCA Corp", "Bear");
		Projects p7 = new Projects("P007", "Meta", "ABCZ Corp", "Near");
		Projects p8 = new Projects("P008", "Geta", "ABCX Corp", "Arnold");
		Projects p9 = new Projects("P009", "Heta", "ABCO Corp", "James");
		Projects p10 = new Projects("P010", "Teta", "ABCM Corp", "Ghost");
		
		Employee emp1 = new Employee(1L, "GIO", "Development", 23L, 12133, "M", Arrays.asList(p1));
		Employee emp2 = new Employee(2L, "JIO", "Hr", 24L, 12533, "F", Arrays.asList(p2));
		Employee emp3 = new Employee(3L, "KIO", "Development", 26L, 14133, "M", Arrays.asList(p3));
		Employee emp4 = new Employee(4L, "LIO", "Sales", 27L, 15133, "F", Arrays.asList(p4));
		Employee emp5 = new Employee(5L, "MIO", "Marketing", 27L, 10133, "M", Arrays.asList(p5));
		Employee emp6 = new Employee(6L, "NIO", "Finance", 22L, 12333, "F", Arrays.asList(p6));
		Employee emp7 = new Employee(7L, "PIO", "Hr", 23L, 12139, "M", Arrays.asList(p7));
		Employee emp8 = new Employee(8L, "RIO", "Development", 24L, 22133, "M", Arrays.asList(p8));
		Employee emp9 = new Employee(9L, "SIO", "Sales", 28L, 12123, "F", Arrays.asList(p9));
		Employee emp10 = new Employee(10L, "TIO", "Marketing", 26L, 12333, "M", Arrays.asList(p10));
		
		return Arrays.asList(emp1,emp2,emp3,emp4,emp5,emp6,emp7,emp8,emp9,emp10);
	}

}

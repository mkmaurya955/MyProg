package StreamApiExamples;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApiLearn {

	public static void main(String[] args) {

		List<Employee> allEmp = EmployeeData.getAllEmp();
//		forEach
//		allEmp.forEach(e->System.out.println(e));
//		allEmp.forEach(System.out::println);
//		allEmp.forEach(e -> System.out.println(e.getName() + " " + e.getGender() + " " + e.getSalary()));

//		filter
		List<Employee> collectedByDept = allEmp.stream().filter(e -> e.getDeptName().equalsIgnoreCase("Development"))
				.collect(Collectors.toList());

		List<Employee> collectedByDeptAndSal = allEmp.stream()
				.filter(e -> e.getDeptName().equalsIgnoreCase("Development") && e.getSalary() > 14000)
				.collect(Collectors.toList());

		Set<Employee> collectBySet = allEmp.stream().filter(e -> e.getDeptName().equalsIgnoreCase("Development"))
				.collect(Collectors.toSet());

		Map<Long, String> collectByMap = allEmp.stream().filter(e -> e.getDeptName().equalsIgnoreCase("Development"))
				.collect(Collectors.toMap(Employee::getId, Employee::getName));

//		map
		List<String> collectOnlyDept = allEmp.stream().map(e -> e.getDeptName()).collect(Collectors.toList());
		List<String> collectOnlyDeptUniq = allEmp.stream().map(e -> e.getDeptName()).distinct()
				.collect(Collectors.toList());
		List<String> collectOnlyUniqDept = allEmp.stream().map(e -> e.getDeptName()).distinct()
				.collect(Collectors.toList());

//		List<Stream<String>> collectedProjectName = allEmp.stream()
//				.map(e -> e.getProjects().stream().map(e1 -> e1.getName()).collect(Collectors.toList()));

//		flatmap
		List<String> collectByFlatMap = allEmp.stream()
				.flatMap(e -> e.getProjects().stream().map(e1 -> e1.getName()).distinct()).collect(Collectors.toList());

//		sorted
		
		List<Employee> collect2 = allEmp.stream().sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());
//		System.out.println(collect2);

//		Filter employee based on deptName
		List<Employee> collectedEmp = allEmp.stream().filter(emp -> emp.getDeptName().equalsIgnoreCase("Hr"))
				.collect(Collectors.toList());

//		collectedEmp.forEach(System.out::println);

//		Find all count of particular word
		String str = "india";
		Map<Character, Long> collect = str.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(c -> c, Collectors.counting()));

		Map<Character, Long> collect1 = str.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		Entry<Character, Long> nonRepeat = str.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(c->c,LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(e->e.getValue()==1).findFirst().orElse(null);
				System.out.println(nonRepeat);
		
//		All non repeating character
		List<Character> nonRepeat1 = str.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(c->c,LinkedHashMap::new, Collectors.counting()))
		.entrySet().stream().filter(e->e.getValue()==1).map(Map.Entry::getKey).collect(Collectors.toList());
		System.out.println(nonRepeat1);
		
		

//		System.out.println(collect1);

	}

}

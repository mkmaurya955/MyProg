package comparatorandcomparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestComparator {
	
	public static void main(String[] args) {
		List<Student> st = new ArrayList<>();
		st.add(new Student("Manish","121",23));
		st.add(new Student("Kumar","122",29));
		st.add(new Student("Maurya","123",28));
		st.add(new Student("Kushwaha","124",33));
		System.out.println("===================Age==================");
		Collections.sort(st,new AgeComparator());
		st.stream().forEach(e->System.out.println(e));
		System.out.println("===================Name=================");
		Collections.sort(st,new NameComparator());
		st.stream().forEach(e->System.out.println(e));
	}

}

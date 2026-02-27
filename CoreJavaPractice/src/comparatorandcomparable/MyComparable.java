package comparatorandcomparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyComparable implements Comparable<MyComparable>{
	
	private String studentName;
	
	private String studentRollNo;
	
	private int age;

	@Override
	public int compareTo(MyComparable o) {
		if(age == o.age)
			return 0;
		else if(age>o.age)
			return 1;
		else
			return -1;
			
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentRollNo() {
		return studentRollNo;
	}

	public void setStudentRollNo(String studentRollNo) {
		this.studentRollNo = studentRollNo;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public MyComparable(String studentName, String studentRollNo, int age) {
		super();
		this.studentName = studentName;
		this.studentRollNo = studentRollNo;
		this.age = age;
	}

	public MyComparable() {
		super();
	}

	@Override
	public String toString() {
		return "MyComparable [studentName=" + studentName + ", studentRollNo=" + studentRollNo + ", age=" + age + "]";
	}

	
	public static void main(String [] args) {
		List<MyComparable> mycomp = new ArrayList<>();
		mycomp.add(new MyComparable("Manish","121",28));
		mycomp.add(new MyComparable("Kumar","122",27));
		mycomp.add(new MyComparable("Maurya","123",25));
		mycomp.add(new MyComparable("Kushwaha","124",38));
		
		Collections.sort(mycomp);
		
		mycomp.stream().forEach(e->System.out.println(mycomp));
		
	}
	
	
}

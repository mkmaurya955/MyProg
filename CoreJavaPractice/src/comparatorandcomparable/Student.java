package comparatorandcomparable;

public class Student {
	
	private String StudentName;
	
	private String rollNo;
	
	private int age;

	public String getStudentName() {
		return StudentName;
	}

	public void setStudentName(String studentName) {
		StudentName = studentName;
	}

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [StudentName=" + StudentName + ", rollNo=" + rollNo + ", age=" + age + "]";
	}

	public Student(String studentName, String rollNo, int age) {
		super();
		StudentName = studentName;
		this.rollNo = rollNo;
		this.age = age;
	}

	public Student() {
		super();
	}
	
	

}

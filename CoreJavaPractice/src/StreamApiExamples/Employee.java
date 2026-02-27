package StreamApiExamples;

import java.util.List;

public class Employee {

	private Long id;

	private String name;

	private String deptName;

	private Long age;

	private double salary;

	private String gender;

	private List<Projects> projects;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<Projects> getProjects() {
		return projects;
	}

	public void setProjects(List<Projects> projects) {
		this.projects = projects;
	}

	public Employee(Long id, String name, String deptName, Long age, double salary, String gender,
			List<Projects> projects) {
		super();
		this.id = id;
		this.name = name;
		this.deptName = deptName;
		this.age = age;
		this.salary = salary;
		this.gender = gender;
		this.projects = projects;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", deptName=" + deptName + ", age=" + age + ", salary="
				+ salary + ", gender=" + gender + ", projects=" + projects + "]";
	}

}

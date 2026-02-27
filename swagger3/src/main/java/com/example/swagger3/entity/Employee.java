package com.example.swagger3.entity;

import org.springframework.stereotype.Component;

@Component
public class Employee {

	private String empId;

	private String empName;

	private String empDesign;

	private String empSal;

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpDesign() {
		return empDesign;
	}

	public void setEmpDesign(String empDesign) {
		this.empDesign = empDesign;
	}

	public String getEmpSal() {
		return empSal;
	}

	public void setEmpSal(String empSal) {
		this.empSal = empSal;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empDesign=" + empDesign + ", empSal=" + empSal
				+ "]";
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String empId, String empName, String empDesign, String empSal) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empDesign = empDesign;
		this.empSal = empSal;
	}

}

package com.cts;


	

	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;
	@Entity
	@Table(name="users")
	public class Employee {
	private long emp_Id;
	private String name;
	private String email;
	private String department;

	@Column(name="emp_Id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long getEmp_Id() {
		return emp_Id;
	}
	public void setEmp_Id(long emp_Id) {
		this.emp_Id = emp_Id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "Employee [emp_Id=" + emp_Id + ", name=" + name + ", email=" + email + ", department=" + department
				+ "]";
	}

	}



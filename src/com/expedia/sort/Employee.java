package com.expedia.sort;

public class Employee implements Comparable<Employee>  {

	private String firstName;
	private String lastName;
	private int salary;
	
	public Employee() {}
	public Employee(String firstName, String lastName, int salary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public int compareTo(Employee emplpyee) {
		return this.getSalary() - emplpyee.getSalary();
	}
	
	
}

package Model;

import java.util.Date;

public class Employee {
    private int employeeId;
    private String name;
    private String email;
    private double age;
    private Date dateOfRegistration;

    /**
     * Constructor
     */
    public Employee() {
	this.employeeId = 0;
	this.name = "";
	this.email = "";
	this.age = 0.0;
    }

    public Employee(int employeeId, String name, String email, double age, Date dateOfRegistration) {
	this.employeeId = employeeId;
	this.name = name;
	this.email = email;
	this.age = age;
	this.dateOfRegistration = dateOfRegistration;
    }

    public int getEmployeeId() {
	return employeeId;
    }

    public void setEmployeeId(int employeeId) {
	this.employeeId = employeeId;
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

    public double getAge() {
	return age;
    }

    public void setAge(double age) {
	this.age = age;
    }

    public Date getDateOfRegistration() {
	return dateOfRegistration;
    }

    public void setDateOfRegistration(Date dateOfRegistration) {
	this.dateOfRegistration = dateOfRegistration;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + employeeId;
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Employee other = (Employee) obj;
	if (employeeId != other.employeeId)
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "EmployeeId :" + employeeId + "\n Name :" + name + " \n  Email :" + email + "\n Age :" + age + " \n DateOfRegistration :"
		+ dateOfRegistration;
    }

}

package com.metacube.Question2;

public class Employee {

    private String employeeName;
    private int employee_id;
    @JsonIgnore
    private String email_id;
    @JsonIgnore
    private String date_Of_Birth;
    private String date_Of_Joining;
    @JsonIgnore
    private int ctcPerAnnum;

    public Employee() {
    }

    public String getEmployeeName() {
	return employeeName;
    }

    public void setEmployeeName(String employeeName) {
	this.employeeName = employeeName;
    }

    public int getEmployee_id() {
	return employee_id;
    }

    public void setEmployee_id(int employee_id) {
	this.employee_id = employee_id;
    }

    @JsonProperty
    public String getEmail_id() {
	return email_id;
    }

    @JsonIgnore
    public void setEmail_id(String email_id) {
	this.email_id = email_id;
    }

    @Override
    public String toString() {
	return "Employee [employeeName=" + employeeName + ", employee_id=" + employee_id + ", email_id=" + email_id + ", date_Of_Birth="
		+ date_Of_Birth + ", date_Of_Joining=" + date_Of_Joining + ", ctcPerAnnum=" + ctcPerAnnum + "]";
    }

    @JsonIgnore
    public String getDate_Of_Birth() {
	return date_Of_Birth;
    }

    public void setDate_Of_Birth(String date_Of_Birth) {
	this.date_Of_Birth = date_Of_Birth;
    }

    public String getDate_Of_Joining() {
	return date_Of_Joining;
    }

    public void setDate_Of_Joining(String date_Of_Joining) {
	this.date_Of_Joining = date_Of_Joining;
    }

    @JsonIgnore
    public int getCtcPerAnnum() {
	return ctcPerAnnum;
    }

    public void setCtcPerAnnum(int ctcPerAnnum) {
	this.ctcPerAnnum = ctcPerAnnum;
    }
}

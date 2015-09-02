package assignmentds6;

import java.util.ArrayList;
import java.util.List;

public class Employees {
    private List<Employee> employeesList = new ArrayList<Employee>();

    // will return the employee based on employeeid
    public Employee getEmployee(int empId) {
	return employeesList.get(empId);
    }

    // will prevent if the employee with same employeeid has been added
    public void addEmployee(Employee employee) {
	if (!employeesList.contains(employee))
	    employeesList.add(employee);
    }

    public List<Employee> getEmployees() {
	return employeesList;
    }

    // will print data of all employees
    public void printDataOfEmployees() {
	for (Employee employee : employeesList) {
	    System.out.println(employee.toString());
	}
    }

    // generating random data
    public void generateRandomData() {
	employeesList.add(new Employee(8, "HSuresh", "Address1"));
	employeesList.add(new Employee(7, "GRamesh", "Address2"));
	employeesList.add(new Employee(6, "FMahesh", "Address3"));
	employeesList.add(new Employee(5, "ENaresh", "Address4"));
	employeesList.add(new Employee(4, "DShivRamesh", "Address5"));
	employeesList.add(new Employee(3, "CRamNaresh", "Address6"));
	employeesList.add(new Employee(2, "BShyamNaresh", "Address7"));
	employeesList.add(new Employee(1, "ARamNaresh", "Address7"));
    }
}

package assignmentds6;

/* Assignment one
 * Create a custom class say Employee with fields as empId, name and address. 
 * Create a collection of this employee class. EmpId of the class with be unique.
 * Perform sorting on this collection i.e natural order.
 * Perform sorting on this collection based on the employee Name. (ascending order by Employee Name)
 * Create a collection for these employees to avoid any duplicate employee entry. 
 * (Employee having same empId will consider as duplicate. If one try to add the same employe again it should avoid that.)
 */
public class Employee implements Comparable<Employee> {
    private int empId;
    private String name;
    private String address;

    public Employee(int empId, String name, String address) {
	this.empId = empId;
	this.name = name;
	this.address = address;
    }

    public int getEmpId() {
	return empId;
    }

    public String getName() {
	return name;
    }

    public String getAddress() {
	return address;
    }

    @Override
    public String toString() {
	return "Employee [Id=" + empId + ", Name=" + name + ", Address=" + address + "]";
    }

    @Override
    public int compareTo(Employee employee) {
	return getEmpId() - employee.getEmpId();
    }
}

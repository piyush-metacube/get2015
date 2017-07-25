package com.metacube.db.helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.metacube.db.ConnectionFactory;
import com.metacube.model.Employee;

public class EmployeeDBHelper {

    private static final String GET_EMPLOYEE_LIST_QUERY = "SELECT * FROM Employee";
    private static final String GET_EMPLOYEE_BY_ID_QUERY = "SELECT * FROM Employee where id = ?";
    private static final String CREATE_EMPLOYEE_QUERY = "INSERT INTO employee(name, email, address) VALUES(?, ?, ?)";
    private static final String GET_EMPLOYEE_BY_NAME_QUERY = "SELECT * FROM Employee WHERE name = ?";
    private static final String DELETE_EMPLOYEE_BY_ID_QUERY = "delete from Employee where id = ?";

    public int createEmployee(Employee employee) {
	int created = -1;
	try {
	    Connection connection = ConnectionFactory.getConnection();
	    PreparedStatement preparedStatement = connection.prepareStatement(CREATE_EMPLOYEE_QUERY);
	    preparedStatement.setString(1, employee.getName());
	    preparedStatement.setString(2, employee.getEmail());
	    preparedStatement.setString(3, employee.getAddress());
	    created = preparedStatement.executeUpdate();
	    System.out.println(created);
	    connection.commit();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return created;
    }

    public List<Employee> getEmployeeList() {

	List<Employee> employeeList = new ArrayList<Employee>();
	try {
	    Connection connection = ConnectionFactory.getConnection();
	    Statement statement = connection.createStatement();
	    ResultSet resultSet = statement.executeQuery(GET_EMPLOYEE_LIST_QUERY);
	    while (resultSet.next()) {
		Employee employee = new Employee();
		employee.setName(resultSet.getString("name"));
		employee.setId(resultSet.getInt("id"));
		employee.setEmail(resultSet.getString("email"));
		employee.setAddress(resultSet.getString("address"));
		employeeList.add(employee);
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return employeeList;
    }

    public Employee getEmployeeById(int id) {
	Employee employee = null;
	try {
	    Connection connection = ConnectionFactory.getConnection();
	    PreparedStatement preparedStatement = connection.prepareStatement(GET_EMPLOYEE_BY_ID_QUERY);
	    preparedStatement.setInt(1, id);
	    ResultSet resultSet = preparedStatement.executeQuery();
	    if (resultSet.next()) {
		employee = new Employee();
		employee.setName(resultSet.getString("name"));
		employee.setEmail(resultSet.getString("email"));
		employee.setAddress(resultSet.getString("address"));
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return employee;
    }

    public List<Employee> getEmployeeByName(String name) {
	Employee employee = null;
	List<Employee> employees = new ArrayList<Employee>();
	try {
	    Connection connection = ConnectionFactory.getConnection();
	    PreparedStatement preparedStatement = connection.prepareStatement(GET_EMPLOYEE_BY_NAME_QUERY);
	    preparedStatement.setString(1, name);
	    ResultSet resultSet = preparedStatement.executeQuery();
	    while (resultSet.next()) {
		employee = new Employee();
		employee.setId(resultSet.getInt("id"));
		employee.setName(resultSet.getString("name"));
		employee.setEmail(resultSet.getString("email"));
		employee.setAddress(resultSet.getString("address"));
		employees.add(employee);
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return employees;
    }

    public int deleteEmployeeById(int id) {
	int isDelete = 0;
	Connection connection = ConnectionFactory.getConnection();
	try {
	    PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE_BY_ID_QUERY);
	    preparedStatement.setInt(1, id);
	    isDelete = preparedStatement.executeUpdate();

	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return isDelete;
    }
}

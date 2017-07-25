package com.factory.company;

public class Developer implements IEngineer {

    String name;
    String role;

    protected Developer() {

    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getRole() {
	return role;
    }

    public void setRole(String role) {
	this.role = role;
    }

    @Override
    public String toString() {
	// TODO Auto-generated method stub
	return "Name -> " + name + "\nRole -> " + role + "\n";
    }
}

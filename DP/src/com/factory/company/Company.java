package com.factory.company;

import java.util.ArrayList;
import java.util.List;

public class Company extends Developer {

    private List<Developer> developerList = new ArrayList<Developer>();
    private static Company company = new Company();

    private Company() {
	super();
    }

    public static Company getInstance() {
	return company;
    }

    public void addDeveloper(String name, String role) {
	Developer developer = new Developer();
	developer.setName(name);
	developer.setRole(role);
	developerList.add(developer);

    }

    public void showList() {
	for (Developer developer : developerList) {
	    System.out.println(developer.toString());
	}
    }

}

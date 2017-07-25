package com.metacube.Question1;

/* This class inherits the annotation in its functions */
public class Employee {

    @RequestForEnhancement(id = 1, synopsis = "Amit")
    public static void employeeDetail(int id, String synopsis, String engineer, String date) {
	System.out.println("Hi " + id + " -> " + synopsis + " -> " + engineer + " -> " + date);
    }

    @RequestForEnhancement(id = 1, synopsis = "Amit", engineer = "Software", date = "10/16/2015")
    public static void employeeDetails(int id, String synopsis, String engineer, String date) {
	System.out.println("Hi " + id + " -> " + synopsis + " -> " + engineer + " -> " + date);
    }

    public static void employeeDetail() {
	System.out.println("Not Annotation");
    }

}

package com.factory.company;

import java.util.Scanner;

public class Factory {

    public static void main(String[] args) {

	String name;
	String role;
	char choice;
	// getting instance of company
	Company company = Company.getInstance();
	Scanner scanner = new Scanner(System.in);
	do {
	    System.out.println("1 ->To add developer");
	    System.out.println("2 ->to print list");

	    int doChoice;
	    do {

		System.out.println("enter integer value");
		while (!scanner.hasNextInt()) {
		    System.out.println("Please enter a number again");
		    scanner.next();
		}
		doChoice = scanner.nextInt();
	    } while (doChoice < 0);

	    switch (doChoice) {
	    case 1:
		// adding data in list
		System.out.println("Enter name---");
		name = scanner.next();
		System.out.println("enter role---");
		role = scanner.next();
		company.addDeveloper(name, role);
		break;
	    case 2:
		// showing list
		company.showList();
		break;
	    default:
		System.out.println("enter correct choice");
		break;
	    }
	    System.out.println("want to continue(y/n)");
	    choice = scanner.next().charAt(0);
	} while (choice == 'y' || choice == 'Y');
	scanner.close();
    }
}

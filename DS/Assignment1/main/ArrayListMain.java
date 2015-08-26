package datastructureclasses.main;

import java.util.Scanner;

import datastructureclasses.MyArrayList;

public class ArrayListMain {
    public static void main(String args[]) {
	MyArrayList linkList = new MyArrayList();
	int ch, item, loc;
	Scanner sc = new Scanner(System.in);
	do {
	    System.out.println("1. Add Element");
	    System.out.println("2. Add Element at particular Location ");
	    System.out.println("3. Removal of an item based on its value");
	    System.out.println("4. Removal of an item based on its index");
	    System.out.println("5. Retrieval of an item of particular index");
	    System.out.println("6. Reversal of linked list");
	    System.out.println("7. Sorting of linked list");
	    System.out.println("8. Display linked list");
	    System.out.println("9. Exit");
	    System.out.println("\n Enter Your choice : ");
	    ch = sc.nextInt();
	    switch (ch) {
	    case 1:
		System.out.print("\n Enter value : ");
		item = sc.nextInt();
		linkList.addElement(item);
		break;
	    case 2:
		System.out.print("\n Enter  value : ");
		item = sc.nextInt();
		System.out.print("\n Enter Location : ");
		loc = sc.nextInt();
		linkList.addElement(item, loc);
		break;
	    case 3:
		System.out.print("\n Enter value : ");
		loc = sc.nextInt();
		linkList.removeItem(loc);
		break;
	    case 4:
		System.out.print("\n Enter location to delete : ");
		loc = sc.nextInt();
		linkList.removeItem(loc);
		break;
	    case 5:
		System.out.print("\n Enter index of item ");
		loc = sc.nextInt();
		linkList.getItem(loc);
		break;
	    case 6:
		linkList.reverse();
		break;
	    case 7:
		linkList.sort();
		break;
	    case 8:
		linkList.display();
		break;
	    case 9:
		return;
	    }
	} while (true);
    }

}

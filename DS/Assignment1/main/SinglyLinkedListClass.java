package datastructureclasses.main;

import java.util.Scanner;

import datastructureclasses.SinglyLinkList;

public class SinglyLinkedListClass {
    public static void main(String args[]) {
	SinglyLinkList linkList = new SinglyLinkList();
	int ch, item, loc;
	Scanner sc = new Scanner(System.in);
	do {
	    System.out.println("1. Add Element");
	    System.out.println("2. Add Element at particular Location ");
	    System.out.println("3. Removal of an item based on its index");
	    System.out.println("4. Retrieval of an item of particular index");
	    System.out.println("5. Reversal of linked list");
	    System.out.println("6. Sorting of linked list");
	    System.out.println("7. Display linked list");
	    System.out.println("8. Exit");
	    System.out.println("\n Enter Your choice : ");
	    ch = sc.nextInt();
	    switch (ch) {
	    case 1:
		System.out.print("\n Enter node value : ");
		item = sc.nextInt();
		linkList.add(item);
		break;
	    case 2:
		System.out.print("\n Enter node value : ");
		item = sc.nextInt();
		System.out.print("\n Enter Location : ");
		loc = sc.nextInt();
		linkList.add(item, loc);
		break;
	    case 3:
		System.out.print("\n Enter Location : ");
		loc = sc.nextInt();
		linkList.remove(loc);
		break;
	    case 4:
		System.out.print("\n Enter Location : ");
		loc = sc.nextInt();
		linkList.get(loc);
		break;
	    case 5:
		linkList.reverse();
		break;
	    case 7:
		linkList.sort();
		break;
	    case 8:
		linkList.displayList();
		break;
	    case 9:
		return;
	    }
	} while (true);
    }
}

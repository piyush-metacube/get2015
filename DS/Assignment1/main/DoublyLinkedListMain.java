package datastructureclasses.main;

import java.util.Scanner;

import datastructureclasses.DoublyLinkList;

public class DoublyLinkedListMain {
    public static void main(String args[]) {
	DoublyLinkList doublyLinkList = new DoublyLinkList();

	int ch, item, loc;
	Scanner sc = new Scanner(System.in);
	do {
	    System.out.println("1. Create DoublyLinked List");
	    System.out.println("2. Add Element at particular Location");
	    System.out.println("3. Removal of an item based on its value ");
	    System.out.println("4. Removal of an item based on its index");
	    System.out.println("5. Retrieval of an item of particular index");
	    System.out.println("6. Reversal of linked list");
	    System.out.println("7. Sorting of linked list");
	    System.out.println("8. Display linked list");
	    System.out.println("9. Exit");
	    System.out.println(" Enter Your choice : ");
	    ch = sc.nextInt();
	    switch (ch) // Apply switch case and call corresponding method
			// according to the user's choice
	    {
	    case 1:
		System.out.print("\n Enter node value : ");
		item = sc.nextInt();
		doublyLinkList.CreateLinkList(item);
		break;
	    case 2:
		System.out.println("\n Enter node value : ");
		item = sc.nextInt();
		System.out.println("\n Enter Location : ");
		loc = sc.nextInt();
		doublyLinkList.insertAtPos(item, loc);
		break;
	    case 3:
		System.out.println("\n Enter node value : ");
		item = sc.nextInt();
		doublyLinkList.deleteItemOnValue(item);
		break;
	    case 4:
		System.out.println("\n Enter Location : ");
		loc = sc.nextInt();
		doublyLinkList.deleteAtPos(loc);
		break;
	    case 5:
		System.out.println("\n Enter Location : ");
		loc = sc.nextInt();
		doublyLinkList.deleteAtPos(loc);
		break;
	    case 6:
		doublyLinkList.reverse();
		break;
	    case 7:
		doublyLinkList.sort();
		break;
	    case 8:
		doublyLinkList.display();
		break;
	    case 9:
		return;
	    }
	} while (true);

    }
}

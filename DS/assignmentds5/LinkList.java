package assignmentds5;

import java.util.LinkedList;

/* Assignment 3
 * Write a program to insert a number in sorted LinkList. Use recursive approach. */

public class LinkList {
    private LinkedList<Integer> integersLinkedList = new LinkedList<Integer>();

    public void add(int integer) {
	addAtPos(0, integer);
    }

    // this method will out appropriate location where to put the element
    public void addAtPos(int index, int integer) {
	if (index == integersLinkedList.size()) {
	    integersLinkedList.add(integer);
	} else if ((integersLinkedList.get(index) < integer) && ((index + 1) <= integersLinkedList.size()))
	    addAtPos(index + 1, integer);
	else
	    integersLinkedList.add(index, integer);
    }

    @Override
    public String toString() {
	return "LinkList [integersLinkedList=" + integersLinkedList + "]";
    }

    public static void main(String[] args) {
	LinkList linkList = new LinkList();
	linkList.add(25);
	linkList.add(24);
	linkList.add(23);
	linkList.add(22);
	linkList.add(20);
	linkList.add(40);
	linkList.add(300);
	linkList.add(2140);
	linkList.add(80000);
	System.out.println(linkList);
    }
    /* output LinkList [integersLinkedList=[20, 22, 23, 24, 25, 40, 300, 2140, 80000]] */
}

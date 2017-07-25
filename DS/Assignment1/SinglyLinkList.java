package datastructureclasses;

public class SinglyLinkList {
    private Node head;
    private int listCount;

    public SinglyLinkList() {
	head = new Node(0);
	listCount = -1;
    }

    // appends the element to the end of this list.
    public void add(int data) {
	Node temp = new Node(data);
	Node current = head;

	while (current.getNext() != null) { // crawl to the end of the list
	    current = current.getNext();
	}
	current.setNext(temp);
	listCount++;
    }

    // add element at the specified position in this list.
    public void add(int data, int index) {
	Node temp = new Node(data);
	Node current = head;
	// crawl to the index or the last element in the list
	for (int i = 0; i < index - 1 && current.getNext() != null; i++) {
	    current = current.getNext();
	}
	temp.setNext(current.getNext());
	current.setNext(temp);
	listCount++;
    }

    public void sort() {
	{
	    Node temp, current = head;
	    int check;
	    while (current != null) // apply simple sorting to sort the elements of Linked list
	    {
		temp = head;
		while (temp.getNext() != null) {
		    if (temp.getData() > temp.getNext().getData()) {
			check = temp.getData();
			temp.setData(temp.getNext().getData());
			temp.getNext().setData(check);
		    }
		    temp = temp.getNext();
		}
		current = current.getNext();
	    }
	}
    }

    // returns the element at the specified position in this list.
    public int get(int index) {
	if (index < 0)
	    return -1;

	Node current = head.getNext();

	for (int i = 0; i < index - 1; i++) {
	    if (current.getNext() != null) {
		current = current.getNext();
	    }
	}
	return current.getData();
    }

    // removes the element at the specified position in this list
    public boolean remove(int index)

    {
	// if the index is out of range return false
	if (index < 0 || index > size())
	    return false;

	Node current = head;
	for (int i = 0; i < index - 1; i++) {
	    if (current.getNext() != null) {
		current = current.getNext();
	    }
	}
	current.setNext(current.getNext().getNext()); // pointing out to next node
	listCount--;
	return true;
    }

    // returns the number of elements in this list.
    public int size() {
	return listCount;
    }

    public String toString() {
	Node current = head.getNext();
	String output = "";
	while (current != null) {
	    output += "[" + current.getData() + "]";
	    current = current.getNext();
	}
	return output;
    }

    // will reverse the list
    public void reverse() {
	Node reversedPart = null;
	Node current = head;
	while (current != null) {
	    Node next = current.getNext();
	    current.setNext(reversedPart);
	    reversedPart = current;
	    current = next;
	}
    }

    // will print the list
    public void displayList() {
	Node current = head;
	while (current != null) {
	    System.out.println(current.getData());
	    current = current.getNext();
	}

    }
}

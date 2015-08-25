package datastructureclasses;

public class DoublyLinkList {
    private DoublyNode start;
    private DoublyNode end;
    private int size;

    public DoublyLinkList() {
	start = null;
	end = null;
	size = 0;
    }

    // to create linklist
    public void CreateLinkList(int value) {
	DoublyNode newNode = new DoublyNode(value, null, null);
	if (start == null) {
	    start = newNode;
	    newNode.setPrev(start);

	} else {
	    DoublyNode temp = start;
	    while (temp.getNext() != null)
		temp = temp.getNext();
	    temp.setNext(newNode);
	    newNode.setPrev(temp.getNext());

	}
    }

    // will return size
    public int getSize() {
	return size;
    }

    // will sort the list
    void sort() {
	DoublyNode temp, current = start;
	int check;
	while (current != null) // apply simple sorting to sort the elements of Linked list
	{
	    temp = start;
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

    // Function to insert element at begining
    public void insertAtStart(int val) {
	DoublyNode nptr = new DoublyNode(val, null, null);
	if (start == null) {
	    start = nptr;
	    end = start;
	} else {
	    start.setPrev(nptr);
	    nptr.setNext(start);
	    start = nptr;
	}
	size++;
    }

    // Function to insert element at end
    public void insertAtEnd(int val) {
	DoublyNode nptr = new DoublyNode(val, null, null);
	if (start == null) {
	    start = nptr;
	    end = start;
	} else {
	    nptr.setPrev(end);
	    end.setNext(nptr);
	    end = nptr;
	}
	size++;
    }

    // Function to insert element at position
    public void insertAtPos(int val, int pos) {
	DoublyNode nptr = new DoublyNode(val, null, null);
	if (pos == 1) {
	    insertAtStart(val);
	    return;
	}
	DoublyNode ptr = start;
	for (int i = 2; i <= size; i++) {
	    if (i == pos) {
		DoublyNode tmp = ptr.getNext();
		ptr.setNext(nptr);
		nptr.setPrev(ptr);
		nptr.setNext(tmp);
		tmp.setPrev(nptr);
	    }
	    ptr = ptr.getNext();
	}
	size++;
    }

    // Function to delete node at position
    public void deleteAtPos(int pos) {
	if (pos == 1) {
	    if (size == 1) {
		start = null;
		end = null;
		size = 0;
		return;
	    }
	    start = start.getNext();
	    start.setPrev(null);
	    size--;
	    return;
	}
	if (pos == size) {
	    end = end.getPrev();
	    end.setNext(null);
	    size--;
	}
	DoublyNode ptr = start.getNext();
	for (int i = 2; i <= size; i++) {
	    if (i == pos) {
		DoublyNode p = ptr.getPrev();
		DoublyNode n = ptr.getNext();

		p.setNext(n);
		n.setPrev(p);
		size--;
		return;
	    }
	    ptr = ptr.getNext();
	}
    }

    // Function to display status of list
    public void display() {
	if (size == 0) {
	    System.out.println("empty");
	    return;
	}
	if (start.getNext() == null) {
	    System.out.println(start.getData());
	    return;
	}
	DoublyNode ptr = start;
	System.out.print(start.getData() + " <-> ");
	ptr = start.getNext();
	while (ptr.getNext() != null) {
	    System.out.print(ptr.getData() + " <-> ");
	    ptr = ptr.getNext();
	}
	System.out.print(ptr.getData() + "\n");
    }

    // delete the item based on value
    public void deleteItemOnValue(int item) {
	DoublyNode current = start;
	DoublyNode temp = current;
	if (start == null) {
	    System.out.println("Empty List");
	} else {
	    while (current != null) {
		if (current.getData() == item) {
		    if (temp == start) {
			start = temp.getNext();
			temp.setPrev(null);
			return;
		    } else {
			temp.setNext(current.getNext());
			temp.setPrev(current.getPrev());
			return;
		    }
		}
		temp = current;
		current = current.getNext();
	    }
	}
    }

    // will reverse the list
    public void reverse() {
	DoublyNode temp = null;
	DoublyNode current = start;

	while (current != null) {
	    temp = current.getPrev();
	    current.setPrev(current.getNext());
	    current.setNext(temp);
	    current = current.getPrev();
	}
	if (temp != null)
	    start.setNext(temp.getPrev());
    }

}

package mycollectionclasses;

//customised stack based on linked list
public class Stack {
    Node headNode;
    private int length;

    public Stack() {
	headNode = null;
	length = 0;
    }

    // push the value to stack
    public void push(Object object) {
	Node node = new Node(object);
	node.setNext(headNode);
	headNode = node;
	length++;
    }

    // to remove top node
    public Object pop() {
	if (headNode == null) // in case when stack is empty
	    return null;
	length--;
	Object itemObject = headNode.getData();
	headNode = headNode.getNext();
	return itemObject;
    }

    // check data of first element without popping
    public Object peek() {
	if (headNode == null) { // in case when stack is empty
	    return null;
	} else {
	    return headNode.getData();
	}
    }

    // to display all elements
    public void display() {
	Node temp = headNode;
	while (temp != null) {
	    System.out.println(temp.getData());
	    temp = temp.getNext();
	}
    }

    // will return no of elements in the stack
    public int size() {
	return length;
    }
}

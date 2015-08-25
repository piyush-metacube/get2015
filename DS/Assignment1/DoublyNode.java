package datastructureclasses;

public class DoublyNode {
    private int data;
    private DoublyNode next, prev;

    public DoublyNode() {
	next = null;
	prev = null;
	data = 0;
    }

    public DoublyNode(int d, DoublyNode n, DoublyNode p) {
	data = d;
	next = n;
	prev = p;
    }

    public void setNext(DoublyNode n) {
	next = n;
    }

    public void setPrev(DoublyNode p) {
	prev = p;
    }

    public DoublyNode getNext() {
	return next;
    }

    public DoublyNode getPrev() {
	return prev;
    }

    public void setData(int d) {
	data = d;
    }

    public int getData() {
	return data;
    }
}

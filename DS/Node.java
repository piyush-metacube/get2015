package ads;

public class Node {
    private Object data;
    private Node next;
    private int tag;

    public Node() {
	tag = 0;
	data = null;
    }

    public Node(int tag, Object data) {
	this.data = data;
	next = null;
	this.tag = tag;
    }

    public Node getNext() {
	return next;
    }

    public void setNext(Node next) {
	this.next = next;
    }

    public Object getData() {
	return data;
    }

    public int getTag() {
	return tag;
    }

    public void setTag(int tag) {
	this.tag = tag;
    }

    public void setData(Object data) {
	this.data = data;
    }

}
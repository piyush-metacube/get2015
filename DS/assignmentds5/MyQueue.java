package assignmentds5;

import java.util.LinkedList;

/*	Assignment 2:
 *	Write a program to implement the Queue functionality using the java collections. 
 *	Look for the best collection to meet this requirement. 
 *	Provide some points justifying your collection choice. 
 *
 *	Collection using : LinkedList
 *	Why?
 *	Insert and remove operations give good performance (O(1)) in LinkedList
 *	compared to ArrayList(O(n)). Hence if there is a requirement of frequent
 *	addition and deletion in application then LinkedList is a best choice.
 */
public class MyQueue {
    private LinkedList<Object> linkedList = new LinkedList<Object>();

    @Override
    public String toString() {
	return "MyQueue [Queue=" + linkedList + "]";
    }

    // will add the element to the last of the linked list
    public void enqueue(Object object) {
	linkedList.add(object);
    }

    // will remove first element of the queue
    public Object dequeue() {
	return linkedList.removeFirst();
    }

    // will clear out the linked list
    public void makeEmpty() {
	linkedList.clear();
    }

    // will return front element without removing it
    public Object getFront() {
	return linkedList.getFirst();
    }

    public static void main(String[] args) {
	MyQueue queue = new MyQueue();
	queue.enqueue("element_1");
	queue.enqueue("element_2");
	queue.enqueue("element_3");
	queue.enqueue("element_4");
	queue.enqueue("element_5");
	System.out.println(queue.toString());
	queue.dequeue();
	System.out.println(queue.toString());
    }
    /*
     * Output
     * 
     * MyQueue [Queue=[element_1, element_2, element_3, element_4, element_5]]
     * 
     * MyQueue [Queue=[element_2, element_3, element_4, element_5]]
     */

}

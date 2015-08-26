package mycollectionclasses;

import java.util.Scanner;

import mycollectionclasses.college.counseling.Councellor;

public class CollectionsMain {

    public static void main(String[] args) {
	Stacks();
	infixToPostfix();
	Queues();
	councellor();
    }

    public static void Queues() {
	Queue queue = new Queue();
	queue.enqueue(1);
	queue.enqueue(2);
	queue.enqueue(3);
	queue.display();
	queue.dequeue();
	queue.dequeue();
	System.out.println(queue.getFront());
	queue.makeEmpty();
	queue.display();
    }

    public static void Stacks() {
	Stack stack = new Stack();
	stack.push(1);
	stack.push(2);
	stack.push(10);
	stack.push(11);
	stack.push(12);
	stack.push(13);
	stack.display();
	System.out.println(">" + stack.size());
	stack.pop();
	stack.display();
	System.out.println(">" + stack.size());
    }

    public static void infixToPostfix() {
	InfixToPostFix infixToPostFix = new InfixToPostFix();
	Scanner scanner = new Scanner(System.in);
	System.out.print("Enter Infix : ");
	String infix = scanner.next();
	System.out.print("Postfix : " + infixToPostFix.convertToPostfix(infix));
    }

    public static void councellor() {
	Councellor councellor = new Councellor();
	councellor.generateSortedStudentList(); // read up student marks and names
	councellor.setupQueueOfStudent(); // setting up queue based on student marks
	councellor.generateCollegeQueue(); // reading college data and setting up college queue
	councellor.startAllotments();// initiating allotments
	councellor.printAllotments();// printAllotments
    }
}
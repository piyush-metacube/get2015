package assignmentds4;

/* Assignment Ds4
 * By using Heap data structure techniques write a program to handle the jobs sent to the admin department's printer:
 * Jobs sent by the department chair should be printed first, then jobs sent by professors,
 * then those sent by graduate students, and finally those sent by undergraduates. The job 
 * put into as per the priority of the sender (e.g., using 4 for the chair, 3 for professors,
 * 2 for grad students, and 1 for undergrads), and the associated information would be the
 * document to print. Each time the printer is free, the job with the highest priority would 
 * be removed from the print queue, and printed. (Note there could be multiple jobs with the same priority)  

 * Following operations must be satisfied by program:
 *	1. create an empty priority queue for JOB
 *	2. Insertion of new JOB
 *	3. Print the job based on priority*/

/* some considerations
 * as per http://www.cs.cmu.edu/~adamchik/15-121/lectures/Binary%20Heaps/heaps.html
 * The root is the second item in the array. 
 * We skip the index zero cell of the array for the convenience of implementation.
 * Consider k-th element of the array
 * 	its left child is located at 2*k index 
 * 	its right child is located at 2*k+1. index 
 * 	its parent is located at k/2 index
 * root element will always be greater than children
 */

public class Heap {
    private int[] heap;
    private int size;
    private final int MAXSIZE = 15;
    private final int FRONT = 1;

    public Heap() {
	size = 0;
	heap = new int[MAXSIZE + 1];
	heap[0] = Integer.MAX_VALUE;// ignoring the zero index, so initializing it with some large random number
    }

    // find out parent of node
    private int parent(int pos) {
	return pos / 2;
    }

    // to find out the the left child of the node...
    private int leftChild(int pos) {
	return (2 * pos);
    }

    // to find out the the right child of the node
    private int rightChild(int pos) {
	return (2 * pos) + 1;
    }

    // check whether the item on given position is leaf or not
    private boolean isLeaf(int pos) {
	if (pos >= (size / 2) && pos <= size) {
	    return true;
	}
	return false;
    }

    // to swap value at two index
    private void swap(int item1, int item2) {
	int tmp;
	tmp = heap[item1];
	heap[item1] = heap[item2];
	heap[item2] = tmp;
    }

    // comparing whether the child of item at position pos is greater, if then swapping with parent
    private void heapify(int pos) {
	if (!isLeaf(pos)) {
	    if (heap[pos] < heap[leftChild(pos)] || heap[pos] < heap[rightChild(pos)]) {
		if (heap[leftChild(pos)] > heap[rightChild(pos)]) {
		    swap(pos, leftChild(pos));
		    heapify(leftChild(pos));
		} else {
		    swap(pos, rightChild(pos));
		    heapify(rightChild(pos));
		}
	    }
	}
    }

    // inserting the element in leaf of the heap
    public void insert(int element) {
	heap[++size] = element;
	int current = size;
	// resetting the parent and element values
	while (heap[current] > heap[parent(current)]) {
	    swap(current, parent(current));
	    current = parent(current);
	}
    }

    // restructuring the heap elements
    public void maxHeap() {
	for (int pos = (size / 2); pos >= 1; pos--) {
	    heapify(pos);
	}
    }

    // remove the front of the queue
    public int remove() {
	int popped = heap[FRONT];
	heap[FRONT] = heap[size--];
	heapify(FRONT);
	return popped;
    }

    // will print the jobs based on heap
    public void printJobs() {
	int n = size;// size is reducing everytime a item is popped off the heap...so this causes issue in loop..i.e keeping it for first time run only
	for (int i = 0; i < n; i++) {
	    System.out.print("  Job> " + remove());// remove() will pop max element...i.e element with higher priority
	}
    }

    public static void main(String... arg) {
	Heap jobHeap = new Heap();
	jobHeap.insert(1);
	jobHeap.insert(1);
	jobHeap.insert(1);
	jobHeap.insert(1);
	jobHeap.insert(4);
	jobHeap.insert(3);
	jobHeap.insert(2);
	jobHeap.insert(2);
	jobHeap.insert(3);
	jobHeap.maxHeap();// resetting things up
	jobHeap.printJobs();
    }

}
/*
 * Higher priority job is taken first... output>> Job> 4 Job> 3 Job> 3 Job> 2 Job> 2 Job> 1 Job> 1 Job> 1 Job> 1
 */

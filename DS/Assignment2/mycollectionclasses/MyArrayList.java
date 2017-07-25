package mycollectionclasses;

//customised arraylist based on array
public class MyArrayList {

    private Object myArray[];
    private int size;

    public MyArrayList() {
	myArray = new Object[10];
	size = 0;
    }

    // Adding an item into array list and check if list is full, then resizing the arraylist
    public void addElement(Object item) {
	if (size < myArray.length) {
	    myArray[size] = item;
	    size++;
	} else {
	    Object newArray[] = new Object[myArray.length + 5];
	    for (int i = 0; i < myArray.length; i++) {
		newArray[i] = myArray[i];
	    }
	    newArray[size] = item;
	    size++;
	    myArray = newArray;
	}
    }

    // Adding an item into array list at the given particular location i
    public Object[] addElement(int index, Object item) {
	for (int i = size; i > index; i--) {
	    myArray[i] = myArray[i - 1];
	}
	myArray[index] = item;
	size++;
	return myArray;
    }

    // Retrieving the first occurrence of an item
    public Object retrievingPosition(Object obj) {
	for (int i = 0; i < size; i++) {
	    if (myArray[i] == obj) {
		return i;
	    }
	}
	return -1;
    }

    // Retrieving the first occurrence of an item based on its given location
    public Object retrievingPositionBasedOnLocation(Object obj, int position) {
	for (int i = position; i < size; i++) {
	    if (myArray[i] == obj) {
		return i;
	    }
	}
	return -1;
    }

    // Removing an item based on particular location
    public Object[] removeAtIndex(int index) {
	for (int i = index; i < size; i++) {
	    myArray[i] = myArray[i + 1];
	}
	size--;
	return myArray;
    }

    // Remove given particular item from the arraylist
    public Object[] removeItem(Object item) {
	for (int i = 0; i < size; i++) {
	    if (myArray[i] == item) {
		for (int j = i; j < size - 1; j++) {
		    myArray[j] = myArray[j + 1];
		}
	    }
	}
	size--;
	return myArray;
    }

    // print all elements
    public void printAllElements() {
	for (int i = 0; i < size; i++) {
	    System.out.println(myArray[i]);
	}
    }

    // Return Reverse of arraylist
    public Object[] reverse() {
	Object[] tempArray = new Object[size];
	for (int i = size; i > 0; i--) {
	    tempArray[i] = myArray[i];
	}
	return myArray;
    }

    // will return value at given position
    public Object get(int index) {
	return myArray[index];
    }

    // return whole list
    public Object[] get() {
	return myArray;
    }

    public void clearList() {
	size = 0;
    }

    // to sort the array
    public void sort() {
	Object temp;
	for (int i = 0; i < size; i++) {
	    for (int j = i + 1; j < size; j++) {
		if (myArray[i].equals(myArray[j])) {
		    temp = myArray[j];
		    myArray[j] = myArray[i];
		    myArray[i] = temp;
		}
	    }
	}
    }

    // will display all elements
    public void display() {
	for (int i = 0; i < size; i++) {
	    System.out.println("  " + myArray[i].toString());
	}
    }
}

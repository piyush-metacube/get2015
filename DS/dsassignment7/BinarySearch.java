package dsassignment7;

public class BinarySearch {

    // method to find leftmost occurrence of value to find
    public int leftMost(int[] sortedArray, int index, int key) {
	if (sortedArray[index - 1] == key)
	    return leftMost(sortedArray, index - 1, key);
	else
	    return index;
    }

    // binary search recursive method
    public int recursiveBinarySearch(int[] sortedArray, int start, int end, int key) {

	if (start < end) {
	    int mid = (start + end) / 2;
	    if (key == sortedArray[mid]) {
		if (mid > 1) {// the case if element is in first position so it cant be backtracked
		    return leftMost(sortedArray, mid, key);// if the element if found then check backward}
		} else {
		    return mid;
		}
	    }
	    if (key < sortedArray[mid]) {
		return recursiveBinarySearch(sortedArray, start, mid, key);
	    } else if (key > sortedArray[mid]) {
		return recursiveBinarySearch(sortedArray, mid + 1, end, key);
	    }
	}
	return -1; // if value is not found
    }

    // binary search method loop variant
    public int binarySearchWithLoop(int[] array, int value) {
	int start = 0;
	int end = array.length - 1;

	for (int i = 0; i < array.length; i++) {
	    int mid = (end + start) / 2;

	    if (array[i] == value)
		return i;
	    else if (array[mid] > value)
		end = mid - 1;
	    else
		start = mid + 1;
	}
	return -1; // if value is not found
    }

}

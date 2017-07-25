package dsassignment7;

public class BinarySearch {

    // method to find leftmost occurrence of value to find
    public int leftMost(int[] sortedArray, int index, int key) {
	if (sortedArray[index - 1] == key)
	    return leftMost(sortedArray, index - 1, key);
	else
	    return index;
    }

    // binary search loop invariant
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
}

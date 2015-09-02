package dsassignment7;

public class ProgramMain {

    public static void main(String[] args) {

	BinarySearch binarySearch = new BinarySearch();
	int[] sortedArray = { 1, 2, 3, 4, 5, 5, 5 };
	int valueToSearch = 5;
	int start = 0;
	int end = sortedArray.length;
	System.out.println("left most occurrence of " + valueToSearch + " is "
		+ binarySearch.recursiveBinarySearch(sortedArray, start, end, valueToSearch));

    }
}

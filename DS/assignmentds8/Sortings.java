package assignmentds8;

import java.util.Arrays;

public class Sortings {

    public void bubbleSort(int[] array) {
	int temp;
	for (int i = 0; i < array.length - 1; i++) {
	    for (int j = 0; j < array.length - i - 1; j++) {
		if (array[j] > array[j + 1]) {
		    temp = array[j];
		    array[j] = array[j + 1];
		    array[j + 1] = temp;
		}
	    }
	}
    }

    public int[] countingSort(int[] itemArray, int maximumElement) {

	// arrayLength holds the length of input itemArray
	int arrayLength = itemArray.length;

	// bucket in array of size 1 more than maximumElement
	int[] bucket = new int[maximumElement + 1];

	// bucketLength holds the length of bucket array
	int bucketLength = bucket.length;

	// loop to fill the bucket according to the numbers in itemArray
	for (int count = 0; count < arrayLength; count++) {
	    bucket[itemArray[count]] = bucket[itemArray[count]] + 1;
	}

	// for loop to fill the itemArray with sorted order of elements by using the bucket
	for (int count = 0, j = 0; count < bucketLength;) {
	    if (bucket[count] != 0) {
		itemArray[j] = count;
		j++;
		bucket[count] = bucket[count] - 1;
	    } else
		count++;
	}
	return itemArray;
    }

    public void quickSort(int[] arr, int left, int right) {
	int i = left;
	int j = right;
	int temp;
	int pivot = arr[(left + right) / 2];
	while (i <= j) {
	    while (arr[i] < pivot)
		i++;
	    while (arr[j] > pivot)
		j--;
	    if (i <= j) {
		temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		i++;
		j--;
	    }
	}
	if (left < j)
	    quickSort(arr, left, j);
	if (i < right)
	    quickSort(arr, i, right);
    }

    public void radixSort(int[] arr, int maxElement) {
	int count, divisor = 1, size = arr.length;
	int[] tempArray = new int[size];

	while (maxElement / divisor > 0) {
	    int[] bucket = new int[10];

	    for (count = 0; count < size; count++)
		bucket[(arr[count] / divisor) % 10]++;

	    for (count = 1; count < 10; count++)
		bucket[count] = bucket[count] + bucket[count - 1];

	    for (count = size - 1; count >= 0; count--)
		tempArray[--bucket[(arr[count] / divisor) % 10]] = arr[count];

	    for (count = 0; count < size; count++)
		arr[count] = tempArray[count];

	    divisor *= 10;
	}
    }

    // this method will control the sorting process based on sortType
    public void sortingController(SortProcessSelector.Sortings sortType, int[] array) {
	switch (sortType) {
	case BUBBLE:
	    bubbleSort(array);
	    break;
	case COUNTING:
	    countingSort(array, getMax(array));
	    break;
	case QUICK:
	    quickSort(array, 0, array.length - 1);// (array, left, right);
	    break;
	case RADIX:
	    radixSort(array, getMax(array));
	    break;
	default:
	    break;
	}
    }

    // this method will return max value in an integer array
    private int getMax(int[] arr) {
	int[] tempArray = arr.clone();
	Arrays.sort(tempArray);
	return tempArray[arr.length - 1];
    }
}

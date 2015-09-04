package assignmentds8;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TreeSortJUnit {

    private TreeSort treeSort = new TreeSort();

    @Test
    public void treeSortJUnit() {
	Integer[] array = { 8, 9, 7, 6, 5, 4, 3, 0, 0, 2, 1 };
	for (int i : array) {
	    treeSort.addElement(i);
	}
	Assert.assertEquals(sortArray(array), treeSort.getDataTraversingOrderList());
    }

    // insertion sort method to check sorting order
    private List<Integer> sortArray(Integer[] numArray) {
	for (int j = 1; j < numArray.length; j++) {
	    int key = numArray[j];
	    int i = j - 1;
	    while ((i > -1) && (numArray[i] > key)) {
		numArray[i + 1] = numArray[i];
		i--;
	    }
	    numArray[i + 1] = key;
	}
	return Arrays.asList(numArray);
    }

}

package assignmentds8;

import org.junit.Assert;
import org.junit.Test;

import assignmentds8.SortProcessSelector.SortType;

public class SortingEnvironmentJUnitTestCases {

    private Sortings sortings = new Sortings();

    @Test
    public void comparisonSortForElementsLessThanTen() {
	int[] array = { 9, 8, 7, 4, 5, 6, 3, 2, 1 };
	SortProcessSelector.Sortings sortingTechnique = SortProcessSelector.sortProcess(array, SortType.COMPARISON);
	sortings.sortingController(sortingTechnique, array);
	Assert.assertEquals(true, isArraySortedInAscendingOrder(array));
    }

    @Test
    public void comparisonSortForElementsMoreThanTen() {
	int[] array = { 9, 8, 7, 4, 5, 6, 3, 2, 1, -80, 789, -7898 };
	SortProcessSelector.Sortings sortingTechnique = SortProcessSelector.sortProcess(array, SortType.COMPARISON);
	sortings.sortingController(sortingTechnique, array);
	Assert.assertEquals(true, isArraySortedInAscendingOrder(array));
    }

    @Test
    public void LinearSortRadixSortingTestCase() {
	int[] array = { 9, 8, 7, 4, 5, 6, 3, 2, 1, 789 };
	SortProcessSelector.Sortings sortingTechnique = SortProcessSelector.sortProcess(array, SortType.LINEAR);
	sortings.sortingController(sortingTechnique, array);
	Assert.assertEquals(true, isArraySortedInAscendingOrder(array));
    }

    @Test
    public void LinearSortCountingSortingTestCase() {
	int[] array = { 9, 8, 7, 4, 5, 6, 3, 2, 1 };
	SortProcessSelector.Sortings sortingTechnique = SortProcessSelector.sortProcess(array, SortType.LINEAR);
	sortings.sortingController(sortingTechnique, array);
	Assert.assertEquals(true, isArraySortedInAscendingOrder(array));
    }

    // method to check whether an array is sorted
    private boolean isArraySortedInAscendingOrder(int[] array) {
	boolean isSorted = true;
	for (int j = 0; j < array.length - 1; j++) {
	    if (array[j] > array[j + 1]) {
		isSorted = false;
		break;
	    }
	}
	return isSorted;
    }

}

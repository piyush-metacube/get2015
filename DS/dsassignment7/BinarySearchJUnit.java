package dsassignment7;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BinarySearchJUnit {
    BinarySearch binarySearch = new BinarySearch();
    static int[] array = { 1, 2, 3, 3, 3, 4, 5, 6, 7 };

    @Test
    public void testLeftMost1() {
	assertEquals(2, binarySearch.recursiveBinarySearch(array, 0, array.length, 3));
    }

    @Test
    public void testLeftMost2() {
	assertEquals(0, binarySearch.recursiveBinarySearch(array, 0, array.length, 1));
    }

    @Test
    public void testLeftMost3() {
	assertEquals(5, binarySearch.recursiveBinarySearch(array, 0, array.length, 4));
    }

    @Test
    public void testLeftMost4() {
	assertEquals(-1, binarySearch.recursiveBinarySearch(array, 0, array.length, 43));
    }

    @Test
    public void testLeftMost5() {
	assertEquals(8, binarySearch.recursiveBinarySearch(array, 0, array.length, 7));
    }

    @Test
    public void testLeftMost6() {
	assertEquals(-1, binarySearch.recursiveBinarySearch(array, 0, array.length, 73));
    }

}

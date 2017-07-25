import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class day3JUnit
{
	Day3Assignment assign = new Day3Assignment();

	// test cases for gcd
	@Test
	public void checkforGCD()
	{
		assertEquals("GCD not calculated", 5, assign.gcd(10, 5));
	}

	@Test
	public void checkforGCD1()
	{
		assertEquals("GCD not calculated", 6, assign.gcd(12, 18));
	}

	@Test
	public void checkforGCD2()
	{
		assertEquals("GCD not calculated", 1, assign.gcd(100, 3));
	}

	// test cases for checking reminder
	@Test
	public void checkForReminder()
	{
		assertEquals("Nothing Found", 2, assign.rem(2, 1));
	}

	@Test
	public void checkForReminder1()
	{
		assertEquals("Nothing Found", Integer.MIN_VALUE, assign.rem(2, 0));
	}

	@Test
	public void checkForReminder2()
	{
		assertEquals("Nothing Found", 1, assign.rem(100, 3));
	}

	// test cases for checking largest integer
	@Test
	public void checkForLargestInt()
	{
		int number = 2;
		assertEquals("Nothing Found", 2, assign.largestdigit(number));
	}

	@Test
	public void checkForLargestInt1()
	{
		int number = 1257369;
		assertEquals("Nothing Found", 9, assign.largestdigit(number));
	}

	@Test
	public void checkForLargestInt2()
	{
		int number = 444;
		assertEquals("Nothing Found", 4, assign.largestdigit(number));
	}

	// test cases for checking Linear Search
	@Test
	public void checkLinearSearch()
	{
		int[] array = { 2, 5, 8, 9, 10, 77, 55 };
		int itemToCheck = 88;
		int position = assign.linearSearch(array, 0, array.length - 1, itemToCheck);
		assertEquals("Element Not Found", -1, position);
	}

	@Test
	public void checkLinearSearch2()
	{
		int[] array = { 2, 5, 8, 9, 10, 77, 55, 11 };
		int itemToCheck = 77;
		int position = assign.linearSearch(array, 0, array.length - 1, itemToCheck);
		assertEquals("Element Not Found", 5, position);
	}

	// test cases for checking Binary Search
	@Test
	public void checkBinarySearch()
	{
		int[] array = { 2, 5, 8, 9, 10, 55, 77 };
		int itemToCheck = 88;
		int position = assign.linearSearch(array, 0, array.length - 1, itemToCheck);
		assertEquals("Element Not Found", -1, position);
	}

	@Test
	public void checkBinarySearch2()
	{
		int[] array = { 2, 5, 8, 9, 10, 55, 77 };
		int itemToCheck = 77;
		int position = assign.linearSearch(array, 0, array.length - 1, itemToCheck);
		assertEquals("Element Not Found", 6, position);
	}

	// test cases for checking quick sort
	@Test
	public void checkQuickSorting()
	{
		int[] array = { -4, -2, -3, 5, 6, 7 };
		int[] expArray = { -4, -3, -2, 5, 6, 7 };
		assign.quickSorting(array, 0, array.length - 1);
		assertArrayEquals("Not matched", expArray, array);
		;
	}

	@Test
	public void checkQuickSorting2()
	{
		int[] array = { -4, -2, -3, 5, 6, 7, -58 };
		int[] expArray = { -58, -4, -3, -2, 5, 6, 7 };
		assign.quickSorting(array, 0, array.length - 1);
		assertArrayEquals("Not matched", expArray, array);
		;
	}
}

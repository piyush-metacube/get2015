public class Day3Assignment
{
	// to find out the largest digit in the number x ..ie. 9 in 12345679
	int largestdigit(int x)
	{
		if (x <= 0) return 0;

		int max = x % 10;
		x = largestdigit(x / 10);

		if (x > max) max = x;

		return max;
	}

	// to compute the greatest common divisor of x and y.
	int gcd(int x, int y)
	{
		if (x > 0 && y > 0)
			return gcd(y, x % y);
		else
			return x;

	}

	// to compute the remainder of x divided by y.
	int rem(int x, int y)
	{
		if (y == 1)
			return x;
		else if (y == 0) return Integer.MIN_VALUE; // In the case when divisor is zero then Integer.MIN_Value is returned

		if (x < 0)
			return x + y; // the case of negative number
		else if (x == 0) return 0;
		return rem(x - y, y); // for the case when number is positive

	}

	// to search for a given value x in an array using linear search strategy.

	int linearSearch(int arr[], int start, int end, int item)
	{
		if (end < start) return -1;

		if (arr[start] == item) return start;

		return linearSearch(arr, start + 1, end, item);
	}

	// to search for a given value x in an array using binary search strategy.

	int binarySearch(int arr[], int start, int end, int item)
	{
		int first = 0;
		int last = end - 1;
		int mid = (first + last) / 2;

		if (item == arr[mid])
			return mid;
		else if (arr[mid] > item)
			binarySearch(arr, first, mid, item);
		else if (arr[mid] < item) binarySearch(arr, mid + 1, end, item);

		return -1;

	}

	// recursive function to sort the given array in ascending order using quicksort.
	public void quickSorting(int arr[], int start, int end)
	{
		int q = partition(arr, start, end);
		if (start < q - 1) quickSorting(arr, start, q - 1);
		if (end > q) quickSorting(arr, q, end);
	}

	// to partition the array in quick sort
	public int partition(int arr[], int start, int end)
	{
		int left = start;
		int right = end;
		int pivot = arr[start];
		while (left <= right)
		{
			while (pivot > arr[left])
				left++;

			while (pivot < arr[right])
				right--;

			// swapping right and left pointers
			if (left <= right)
			{
				int temp = arr[right];
				arr[right] = arr[left];
				arr[left] = temp;

				right--;
				left++;
			}

		}
		return left;
	}

}

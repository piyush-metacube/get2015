package assignmentds8;

import java.util.Scanner;

import assignmentds8.SortProcessSelector.SortType;

/*   Assignment 2:
 *   Write a sorting system, which takes input from user and provide a sorted list.
 *   Here User could choose if he want to go with Comparison Sorting Or Linear Sorting.
 *  
 *   Given Conditions:
 *    1 - For comparison sorting system will use Bubble Sort or Quick Sort techniques.
 *     (When less number of inputs (input elements <= 10) use Bubble Sort else Quicksort)
 *  
 *    2 - For linear sorting system will use Counting Sort or Radix Sort techniques 
 *     (When large inputs(more than 2 digit) use Radix Sort else Counting Sort)
 *    
 *    (System should be intelligent to pick suitable techniques for sort as per provided input )
 *    
 *    Expected output : System has used XYZ sorting technique and sorted list as below :
 *    n , n+1, ........... K -1, K
 */
public class SortingEnvironment {

    private static Sortings sortings = new Sortings();
    private static SortProcessSelector.Sortings sortingTechnique;

    public static void main(String[] args) {
	int size;

	Scanner sc = new Scanner(System.in);
	do {
	    System.out.println("Choose an Option");
	    System.out.println("1. comparison sorting");
	    System.out.println("2. linear sorting");
	    System.out.println("3. exit");
	    int choice = sc.nextInt();

	    System.out.println("enter number of elements");
	    size = sc.nextInt();

	    System.out.println("enter numbers to sort");
	    int[] arr = new int[size];
	    for (int i = 0; i < size; i++) {
		arr[i] = sc.nextInt();
	    }

	    switch (choice) {
	    case 1:
		sortingTechnique = SortProcessSelector.sortProcess(arr, SortType.COMPARISON);
		sortings.sortingController(sortingTechnique, arr);
		printArray(arr);
		break;
	    case 2:
		sortingTechnique = SortProcessSelector.sortProcess(arr, SortType.LINEAR);
		sortings.sortingController(sortingTechnique, arr);
		printArray(arr);
		break;
	    case 3:
		sc.close();
		return;
	    default:
		break;
	    }
	} while (true);
    }

    private static void printArray(int[] array) {
	System.out.println("> array is : ");
	for (int i : array) {
	    System.out.print(i + " ");
	}
    }
}

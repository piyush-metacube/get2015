package assignmentds8;

import java.util.Arrays;

public class SortProcessSelector {

    public static enum Sortings {
	BUBBLE, QUICK, COUNTING, RADIX
    };

    public static enum SortType {
	COMPARISON, LINEAR
    };

    // it will return a sorting process type based on number of elements and SortType
    public static Sortings sortProcess(int[] array, SortType sortType) {
	switch (sortType) {
	case COMPARISON:
	    if (array.length <= 10) {
		return Sortings.BUBBLE;
	    } else {
		return Sortings.QUICK;
	    }
	case LINEAR:
	    if (getMax(array) > 99) {
		return Sortings.RADIX;
	    } else {
		return Sortings.COUNTING;
	    }
	}
	return null;
    }

    private static int getMax(int[] arr) {
	int[] tempArray = arr.clone();
	Arrays.sort(tempArray);
	return tempArray[arr.length - 1];
    }

}

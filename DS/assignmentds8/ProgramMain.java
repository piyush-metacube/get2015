package assignmentds8;

public class ProgramMain {

    public static void main(String[] args) {
	TreeSort treeSort = new TreeSort();
	int[] array = { 8, 9, 7, 6, 5, 4, 3, 0, 0, 2, 1 };

	for (int i : array) {
	    treeSort.addElement(i);
	}
	System.out.println(treeSort.getDataTraversingOrderList());
    }
}

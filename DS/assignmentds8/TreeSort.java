package assignmentds8;

import java.util.List;

/*
 * Assignment 1: Write a program to print disorderly provided role
 *  numbers of n students in  ascending series using tree sort?
 */
public class TreeSort {
    private BTree bTree = new BTree();

    void addElement(int value) {
	bTree.addDataNode(value);
    }

    void printDataInAscendingOrder() {
	System.out.println(bTree.getDataTraversingOrderList());
    }

    public List<Integer> getDataTraversingOrderList() {
	bTree.inOrderTraversing();
	return BTree.getDataTraversingOrderList();
    }
}

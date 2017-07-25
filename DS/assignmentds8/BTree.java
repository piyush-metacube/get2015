package assignmentds8;

import java.util.ArrayList;
import java.util.List;

//Btree that will store data and will print the data in ascending order
public class BTree {

    private int data;
    private BTree left;
    private BTree right;
    private static List<Integer> dataTraversingOrderList;

    public static List<Integer> getDataTraversingOrderList() {
	return dataTraversingOrderList;
    }

    public static void setDataTraversingOrderList(List<Integer> dataTraversingOrderList) {
	BTree.dataTraversingOrderList = dataTraversingOrderList;
    }

    // will create blank node i.e root=-1
    public BTree() {
	data = -1;
	dataTraversingOrderList = new ArrayList<Integer>();// will be instantiated once at the time of creation of root node
    }

    // will create rootnode initialized with num
    public BTree(int num) {
	data = num;
    }

    // it will add data to binary tree
    public void addDataNode(int num) {
	if (data == -1) {// if data is negative means tree is empty
	    data = num;
	} else {
	    if (num < data) {// if data is greater than num then move left
		if (left != null) {
		    left.addDataNode(num);
		} else {
		    left = new BTree(num);
		}

	    } else {// if data is less than num then move right
		if (right != null) {
		    right.addDataNode(num);
		} else {
		    right = new BTree(num);
		}
	    }
	}
    }

    // in order traversing provides ascending order of elements
    public void inOrderTraversing() {
	if (left != null) {
	    left.inOrderTraversing();
	}
	dataTraversingOrderList.add(data);
	if (right != null) {
	    right.inOrderTraversing();
	}
    }
}

package ds3assignment;

public class BTree {

	private int data;
	private BTree left;
	private BTree right;

	public BTree(int num) {
		data = num;
		left = null;
		right = null;
	}

	public void addNode(int num) {
		if (num < data) {
			if (left != null) {
				left.addNode(num);
			} else {
				left = new BTree(num);
			}

		} else {
			if (right != null) {
				right.addNode(num);
			} else {
				right = new BTree(num);
			}
		}
	}

	public void traversePreOrder() {
		System.out.println(data);
		if (left != null) {
			left.traversePreOrder();
		}
		if (right != null) {
			right.traversePreOrder();
		}
	}

	public void traversePostOrder() {
		if (left != null) {
			this.left.traversePostOrder();
		}
		if (right != null) {
			right.traversePostOrder();
		}
		System.out.println(data);
	}

	public static boolean isMirrorImage(BTree tree1, BTree tree2) {
		if (tree1 == null && tree2 == null) {// trees are empty,case one
			return true;
		} else if (tree1 != null && tree2 != null) {
			return tree1.data == tree2.data && isMirrorImage(tree1.left, tree2.right)
					&& isMirrorImage(tree1.right, tree2.left);
		} else {// in the case if one tree is null
			return false;
		}
	}

}

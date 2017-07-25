package ds3assignment;

import java.util.Scanner;

public class ProgramMain {

	public static void main(String args[]) {
		BTree treeObject = new BTree();
		BTree treeObject2 = new BTree();
		int item;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("1. Insert in Tree");
			System.out.println("2. Insert in Tree2");
			System.out.println("3. Pre-Order Traversal for Tree One");
			System.out.println("4. Post-Order Traversal for Tree One ");
			System.out.println("5. Compare Mirror Image");
			System.out.println("6. Exit");
			System.out.println("Enter Your choice : ");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter node value : ");
				item = sc.nextInt();
				treeObject.addNode(item);
				break;
			case 2:
				System.out.println("Enter node value : ");
				item = sc.nextInt();
				treeObject2.addNode(item);
				break;
			case 3:
				treeObject.preOrderTraversal();
				break;
			case 4:
				treeObject.postOrderTraversal();
				break;
			case 5:
				if (treeObject.isMirror(treeObject.getRoot(), treeObject2.getRoot())) {
					System.out.println("Both trees are mirror image of each other");
				} else {
					System.out.println("Trees are not mirror image of each other");
				}
				break;
			case 6:
				return;
			default:
				break;
			}
		} while (true);
	}
}

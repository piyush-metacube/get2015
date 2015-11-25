package ads;

public class List {

    Node root;

    String list, str = "";
    int position = 0;

    public List() {
	list = null;
    }

    public List(String string) {
	list = string;
    }

    void insert(Node node) {

	if (position < list.length()) {
	    if (node == null) {
		Node temp;
		if (list.charAt(position) == '(') {
		    temp = new Node(1, null);
		} else {

		    while (list.charAt(position) != ',' && list.charAt(position) != '(' && list.charAt(position) != ')') {
			str += list.charAt(position);
			position++;
			System.out.println(str);
		    }

		    temp = new Node(0, Integer.parseInt(str));
		    str = "";
		}
		root = temp;
		position++;
		insert(temp);
	    } else if (list.charAt(position) == '(') {
		Node temp = new Node(1, null);
		node.setNext(temp);
		position++;
		insert(node.getNext());
		insert(node.getNext());
	    } else if (list.charAt(position) == ')') {
		position++;
		return;
	    } else if (list.charAt(position) == ',') {
		position++;
		insert(node);
	    } else {

		while (list.charAt(position) != ',' && list.charAt(position) != '(' && list.charAt(position) != ')') {
		    str += list.charAt(position);
		    position++;
		}

		Node temp = new Node(0, Integer.parseInt(str));
		str = "";
		if (node.getTag() == 0) {
		    node.setNext(temp);
		    System.out.println("node is created  0 tag->" + temp.getData() + "+" + node.getData());
		    position++;
		    insert(temp);

		} else if (node.getTag() == 1 && node.getData() != null) {
		    node.setNext(temp);
		    System.out.println("node is created  0 tag and store in main list->" + node.getNext().getData());
		    position++;
		    insert(temp);
		} else {

		    node.setData(temp);
		    System.out.println("node is created 0 tag and store under sublist->" + temp.getData());
		    position++;
		    insert(temp);
		}
	    }
	}
    }

    int sumOfelements(Node node, int sum) {

	if (node != null) {
	    if (node.getTag() == 0) {
		sum = sum + (int) node.getData();
		sum = sumOfelements(node.getNext(), sum);
	    } else {
		sum = sumOfelements((Node) node.getData(), sum);
		sum = sumOfelements(node.getNext(), sum);
	    }
	}
	return sum;
    }

    void display(Node node) {
	if (node != null) {
	    if (node.getTag() == 0) {
		System.out.println(node.getData());
		display(node.getNext());

	    } else {
		display((Node) node.getData());
		display(node.getNext());
	    }
	}
    }

    int max(Node node, int max) {
	if (node != null) {
	    if (node.getTag() == 0) {
		if (max < (int) node.getData())
		    max = (int) node.getData();
		max = max(node.getNext(), max);

	    } else {
		max = max((Node) node.getData(), max);
		max = max(node.getNext(), max);
	    }
	}
	return max;
    }

    boolean search(Node node, int element, boolean search) {
	if (node != null) {
	    if (node.getTag() == 0) {
		if ((int) node.getData() == element) {
		    return true;

		}
		search = search(node.getNext(), element, search);

	    } else {

		search = search((Node) node.getData(), element, search);
		search = search(node.getNext(), element, search);
	    }
	}
	return search;
    }

    public static void main(String[] args) {
	List list = new List("((251,3),5,((13,2),1,(1,1),(10,(0),7)))");
	System.out.println(list.list);
	list.insert(list.root);
	list.display(list.root);
	System.out.println(list.search(list.root, 31, false));
	System.out.println("sum of elements is ->" + list.sumOfelements(list.root, 0));
	System.out.println("sum of elements is ->" + list.max(list.root, -1275867));
    }
}

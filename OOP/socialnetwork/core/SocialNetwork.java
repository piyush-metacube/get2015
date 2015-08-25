package socialnetwork.core;

import java.util.Scanner;

public class SocialNetwork {
    private static Graph graph = new Graph();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String args[]) {
	graph.generatePerson(); // setting up data base
	graph.generateConnections();// setting up connections
	do {
	    graph.showMainMenu();
	    int choice = scanner.nextInt();
	    if (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5)
		continue;
	    switch (choice) {
	    case 1:
		addConnection();
		break;
	    case 2:
		graph.show();
		break;
	    case 3:
		printSummaryOfAnEntity();
		break;
	    case 4:
		deleteConnection();
		break;
	    case 5:
	    default:
		return;
	    }
	} while (true);
    }

    // will setup connection between two entities
    public static void addConnection() {

	System.out.println("Enter email of entity");
	String emailToSearch = scanner.next();

	System.out.println("Enter email of entity to add connection with " + emailToSearch);
	String emailToAdd = scanner.next();

	graph.getEdge().addConnection(emailToSearch, emailToAdd);
    }

    // will show summary for an entity
    public static void printSummaryOfAnEntity() {

	System.out.println("Enter name of entity");
	String nameToSearchString = scanner.next();
	scanner.nextLine();
	for (Entity entity : graph.findSimilarNames(nameToSearchString)) {
	    System.out.println(entity.getName() + "  " + entity.getEmail());
	}

	System.out.println("Enter email of entity to print summary");
	String emailToSearch = scanner.next();
	scanner.nextLine();
	System.out.println(graph.getNodeMap().get(emailToSearch).toString());

	graph.getEdge().printConnections(emailToSearch);
    }

    // will delete connection between two entities
    public static void deleteConnection() {

	System.out.println("Enter email of entity one to delete");
	String emailToDelete1 = scanner.next();

	System.out.println("Enter email of entity two to delete");
	String emailToDelete2 = scanner.next();

	graph.getEdge().removeConnection(emailToDelete1, emailToDelete2);
    }
}

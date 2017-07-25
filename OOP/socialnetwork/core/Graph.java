package socialnetwork.core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    private static Map<String, Entity> nodeMap = new HashMap<String, Entity>();
    private static Edge edge = new Edge();

    private final String NODE_DATA_FILE = "D:\\SocialNetworkData.txt";
    private final String CONNECTION_DATA_FILE = "D:\\Connections.txt";

    public static Map<String, Entity> getNodeMap() {
	return nodeMap;
    }

    public static void setNodeMap(Map<String, Entity> nodeMap) {
	Graph.nodeMap = nodeMap;
    }

    public static Edge getEdge() {
	return edge;
    }

    public static void setEdge(Edge edge) {
	Graph.edge = edge;
    }

    // will read text file to read the details of entities
    public void generatePerson() {
	BufferedReader br;
	try {
	    br = new BufferedReader(new FileReader(NODE_DATA_FILE));
	    String sCurrentLine;
	    while ((sCurrentLine = br.readLine()) != null) {
		String[] dataFileData = sCurrentLine.split(",");
		if (dataFileData.length == 5) {
		    if (dataFileData[0].equalsIgnoreCase("p")) { // case for person

			Entity entity = new Person(dataFileData[1], dataFileData[2], Integer.parseInt(dataFileData[3]), dataFileData[4]);
			// creating nodes based on datafile data
			nodeMap.put(dataFileData[1], entity);

			// creating connections for this data
			edge.generateConnectionEdge(entity);

		    } else { // case for an organisation
			Entity entity = new Organisation(dataFileData[1], dataFileData[2], dataFileData[3], Integer.parseInt(dataFileData[4]));
			// creating nodes based on datafile data
			nodeMap.put(dataFileData[1], entity);

			// creating connections for this data
			edge.generateConnectionEdge(entity);
		    }
		}
	    }

	} catch (IOException e1) {
	    e1.printStackTrace();
	}
    }

    // will read text file to find connections among people
    public void generateConnections() {
	BufferedReader br;
	try {
	    br = new BufferedReader(new FileReader(CONNECTION_DATA_FILE));
	    String sCurrentLine;
	    while ((sCurrentLine = br.readLine()) != null) {
		String[] dataFileData = sCurrentLine.split(",");
		if (dataFileData.length > 2) {
		    for (String emailString : dataFileData) {
			edge.addConnection(nodeMap.get(dataFileData[0]), nodeMap.get(emailString));
		    }
		}
	    }
	} catch (IOException e1) {
	    e1.printStackTrace();
	}
    }

    // will suggest friends based on similar age
    public List<Entity> suggestFriends(String email) {
	List<Entity> list = new ArrayList<Entity>();
	for (Entity entity : nodeMap.values()) {
	    if (!entity.getEmail().equalsIgnoreCase(email) && nodeMap.get(entity.getEmail()).equals(nodeMap.get(email))) {
		list.add(entity);
	    }
	}
	return list;
    }

    // will display whole network nodes
    public void show() {
	for (Entity entity : nodeMap.values()) {
	    // printing details of entity
	    System.out.println("\n");
	    System.out.print("||" + entity.getName() + "||>");
	    // printing details of friends
	    for (String emailString : edge.findFriends(entity)) {
		System.out.print(nodeMap.get(emailString).getName() + ",");// Connections of that entity
	    }
	}
    }

    // will return the list of similarNames in network
    public List<Entity> findSimilarNames(String nameToSearch) {
	List<Entity> list = new ArrayList<Entity>();
	for (Entity entity : nodeMap.values()) {
	    if (entity.getName().contains(nameToSearch)) {
		list.add(entity);
	    }
	}
	return list;
    }

    // Menu options

    public void showMainMenu() {

	System.out.println("Graph Search");
	System.out.println("Press 1. To Add Connection");
	System.out.println("Press 2. To Display the network");
	System.out.println("Press 3. To Print summary of an entity");
	System.out.println("Press 4. To Remove a Connection");
	System.out.println("Press 5. To Exit");

    }
}

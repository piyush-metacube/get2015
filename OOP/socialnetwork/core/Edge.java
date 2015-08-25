package socialnetwork.core;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Edge implements Connection {
    public Map<String, Map<String, String>> edgeMap = new HashMap<String, Map<String, String>>();

    // to make connection between two entities
    @Override
    public void addConnection(Entity entity1, Entity entity2) {
	/* a node cant be friend of his own */
	if (entity1.getEmail().equalsIgnoreCase(entity2.getEmail()))
	    return;
	edgeMap.get(entity1.getEmail()).put(entity2.getEmail(), "");
	edgeMap.get(entity2.getEmail()).put(entity1.getEmail(), "");
    }

    // will remove between two entities based on emails passed
    @Override
    public void removeConnection(String entity1EmailString, String entity2EmailString) {
	edgeMap.get(entity1EmailString).remove(entity2EmailString);
	edgeMap.get(entity2EmailString).remove(entity1EmailString);
    }

    @Override
    public void addConnection(String entity1Email, String entity2Email) {
	/* a node cant be friend of his own */
	if (entity1Email.equalsIgnoreCase(entity2Email))
	    return;
	edgeMap.get(entity1Email).put(entity2Email, "");
	edgeMap.get(entity2Email).put(entity1Email, "");
    }

    // to generate connection map for an new entity
    public void generateConnectionEdge(Entity entity) {
	if (!edgeMap.containsKey(entity.getEmail()))
	    edgeMap.put(entity.getEmail(), new HashMap<String, String>());
    }

    // to remove connection between two entities
    @Override
    public void removeConnection(Entity e1, Entity e2) {
	edgeMap.get(e1.getEmail()).remove(e2.getEmail());
	edgeMap.get(e2.getEmail()).remove(e1.getEmail());
    }

    // to find friends based on email
    @Override
    public Set<String> findFriends(String email) {
	return edgeMap.get(email).keySet();
    }

    // to find friends for an entity
    @Override
    public Set<String> findFriends(Entity entity) {
	return edgeMap.get(entity.getEmail()).keySet();
    }

    // will print existing connections for an entity
    public void printConnections(String emailString) {
	System.out.println("Connections");
	for (String string : edgeMap.get(emailString).keySet()) {
	    System.out.println(">" + string);
	}
    }
}
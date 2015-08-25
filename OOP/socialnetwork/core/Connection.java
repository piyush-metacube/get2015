package socialnetwork.core;

import java.util.Set;

public interface Connection {

    public void addConnection(Entity e1, Entity e2);

    public void addConnection(String e1, String e2);

    public void removeConnection(Entity e1, Entity e2);

    public void removeConnection(String e1, String e2);

    public Set<String> findFriends(String email);

    public Set<String> findFriends(Entity entity);
}

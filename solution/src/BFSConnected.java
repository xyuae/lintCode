import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Xiaojun YU on 2017-02-13.
 */
public class BFSConnected {
    ;
    /**
     * @param graph: A list of Directed graph node
     * @param s: the starting Directed graph node
     * @param t: the terminal Directed graph node
     * @return: a boolean value
     */
    public boolean hasRoute(ArrayList<DirectedGraphNode> graph,
                            DirectedGraphNode s, DirectedGraphNode t) {
        // test corner case where s is t
        if (s == t) return true;
        // use BFS to test connectivity
        HashSet<DirectedGraphNode> visited = new HashSet<>();
        Queue<DirectedGraphNode> queue = new LinkedList<>();

        queue.offer(s);
        while (!queue.isEmpty()) {
            DirectedGraphNode parentNode = queue.poll();
            for (DirectedGraphNode childNode : parentNode.neighbors) {
                if (visited.contains(childNode)) continue;
                visited.add(childNode);
                queue.offer(childNode);
                if (childNode == t) return true;
            }
        }
        return false;
    }
}

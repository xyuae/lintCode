import java.util.ArrayList;

/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class DirectedGraphNode {
      public int label;
      public ArrayList<DirectedGraphNode> neighbors;
      DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
  }

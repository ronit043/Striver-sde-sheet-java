package Day23;
import java.util.*;

/*    TC: O(V + E), SC: O(V); V: #Vertices, E: #Edges

If the actual node is empty there is nothing to copy, so return null. Make a dfs call for traversing all the
vertices of the root node and return its value.

Creating cloned node for original node.val. Adding cloned node with original node.val in the vis to keep track
of which node is already cloned. Now work on cloning its neighbours as well. So iterating over the neighbours
of original node, we can use the same neighbours to clone them and add the links to the cloned node

Base case:
If that node is already visited, retrieve that node's value from visited map, and it'll be added as the
adjacent node of prev copied node
 */
class Clone_Graph {
   public Node cloneGraph(Node node) {
      if (node == null) return null;
      return dfs(node, new HashMap<>());
   }

   Node dfs(Node node, Map<Integer, Node> vis) {
      if (vis.containsKey(node.val)) return vis.get(node.val);
      Node newNode = new Node(node.val);
      vis.put(node.val, newNode);
      for (Node n : node.neighbors) newNode.neighbors.add(dfs(n, vis));
      return newNode;
   }
}
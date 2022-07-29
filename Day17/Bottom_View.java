package Day17;
import java.util.*;

/*    TC: O(n), SC: O(n)
We use an approach similar to BFS but this time when we encounter a node for the first
time i.e. when we get a unique column value, we add it along with its column value in the map, if the node
is already present then we replace the column value & node, to get the bottom node for a column value. Also
since we created a queue of Nodes we won't use the row field, so we assign the row of each node as 0.
 */
public class Bottom_View {
   List<Integer> getBottomView(TreeNode root) {
      List<Integer> res = new ArrayList<>();
      Queue<Node> q = new ArrayDeque<>();
      TreeMap<Integer, TreeNode> tm = new TreeMap<>();
      if (root == null) return res;

      q.add(new Node(root, 0, 0));
      while (!q.isEmpty()) {
         Node p = q.poll();

         if (!tm.containsKey(p.col)) tm.put(p.col, p.node);
         else tm.replace(p.col, p.node);

         if (p.node.left != null) q.add(new Node(p.node.left, 0, p.col - 1));
         if (p.node.right != null) q.add(new Node(p.node.right, 0, p.col + 1));
      }

      for (TreeNode t : tm.values()) res.add(t.val);
      return res;
   }
}
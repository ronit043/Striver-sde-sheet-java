package Day17;
import java.util.*;

/*    TC: O(n), SC: O(n)
We use an approach similar to BFS but this time when we encounter a node for the first time i.e. when we get
a unique column value, we add it along with its column value in the map.

Map here is to store the first node of every column value, and we keep the column as the key so that the map
sorts on the basis of column values(keys).
 */
class Top_View {
   List<Integer> getTopView(TreeNode root) {
      List<Integer> res = new ArrayList<>();
      Queue<Node> q = new ArrayDeque<>();
      Map<Integer, TreeNode> tm = new TreeMap<>();
      if (root == null) return res;

      q.add(new Node(root, 0));
      while (!q.isEmpty()) {
         Node p = q.poll();
         if (!tm.containsKey(p.col)) tm.put(p.col, p.node);
         if (p.node.left != null) q.add(new Node(p.node.left, p.col - 1));
         if (p.node.right != null) q.add(new Node(p.node.right, p.col + 1));
      }

      for (TreeNode t : tm.values()) res.add(t.val);
      return res;
   }
}
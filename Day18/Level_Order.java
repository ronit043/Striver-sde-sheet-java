package Day18;
import java.util.*;
import Day17.TreeNode;

/*    TC: O(n), SC: O(n)
In the level order traversal, we will be using FIFO queue because nodes which come first in current level the
children of that node will also come first for the next level. So, we visit all the nodes one by one of the
current level and push into the queue so that when we will be complete with the current level, then we can
start exploring nodes of the next level from the queue.  We will keep doing until our queue does not become
empty and store all the nodes into “output”.
 */
class Level_Order {
   public List<List<Integer>> levelOrder(TreeNode root) {
      Queue<TreeNode> q = new ArrayDeque<>();
      List<List<Integer>> ans = new ArrayList<>();
      if (root == null) return ans;

      q.add(root);
      while (!q.isEmpty()) {
         int level_size = q.size();
         List<Integer> layer = new ArrayList<>();
         while (level_size-- > 0) {
            TreeNode node = q.poll();
            layer.add(node.val);

            if (node.left != null) q.add(node.left);
            if (node.right != null) q.add(node.right);
         }
         ans.add(layer);
      }

      return ans;
   }
}
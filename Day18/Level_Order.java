package Day18;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Deque;
import Day17.TreeNode;

/*    TC: O(n), SC: O(n)
In the level order traversal, we will be using FIFO queue because nodes which come first in current level the
children of that node will also come first for the next level. So, we visit all the nodes one by one of the
current level and push into the queue so that when we will be complete with the current level, then we can
start exploring nodes of the next level from the queue.  We will keep doing until our queue does not become
empty and store all the nodes into “output”.
 */
public class Level_Order {
   public List<List<Integer>> levelOrder(TreeNode root) {
      Deque<TreeNode> q = new ArrayDeque<>();
      List<List<Integer>> ans = new ArrayList<>();
      if (root == null) return ans;

      q.add(root);
      while (!q.isEmpty()) {
         int level_size = q.size();
         List<Integer> layer_vals = new ArrayList<>();
         while (level_size-- > 0) {
            TreeNode temp = q.poll();
            layer_vals.add(temp.val);

            if (temp.left != null) q.add(temp.left);
            if (temp.right != null) q.add(temp.right);
         }
         ans.add(layer_vals);
      }

      return ans;
   }
}
package Day18;
import java.util.*;
import Day17.TreeNode;
/*    TC: O(n), SC: O(n)
We need to add the nodes to the list, level by level, our first guess would definitely be that it's related
level order traversal. If we closely examine, for even levels we need to go from left to right while
for odd levels we need to go from right to left, hence we maintain a level_num variable.

Once a level is covered we increase the value of level_num and add the node values in list to 2d list.
 */
public class Zig_Zag_traversal {
   public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
      Queue<TreeNode> q = new LinkedList<>();
      List<List<Integer>> ans = new ArrayList<>();
      int level_num = 0;
      if (root == null) return ans;

      q.add(root);
      while (!q.isEmpty()) {
         int level_size = q.size();
         List<Integer> layer_vals = new ArrayList<>();

         while (level_size-- > 0) {
            TreeNode curr = q.poll();
            if (level_num % 2 == 0) layer_vals.add(curr.val);
            else layer_vals.add(0, curr.val);

            if (curr.left != null) q.add(curr.left);
            if (curr.right != null) q.add(curr.right);
         }

         ans.add(layer_vals);
         level_num++;
      }

      return ans;
   }
}

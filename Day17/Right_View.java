package Day17;
import java.util.*;

/*    TC: O(n), SC: O(n)
Use preorder traversal and for each level of the binary tree include the rightmost node in the answer. In the
preorder traversal, we will traverse the right subtree of any node before the left subtree so that all nodes
to the right of the current node are visited before the nodes which are on the left of the current node.
Hence, for any level, we will reach the rightmost node before we reach any other node in the same level, and
we only need to include the rightmost node of each level in our answer.
 */

class Right_View {
   public List<Integer> getRightView(TreeNode root) {
      List<Integer> al = new ArrayList<>();
      dfs(al, root, 0);
      return al;
   }

   void dfs(List<Integer> al, TreeNode node, int curr_depth) {
      if (node == null) return;
      if (al.size() == curr_depth) al.add(node.val);
      dfs(al, node.right, curr_depth + 1);
      dfs(al, node.left, curr_depth + 1);
   }
}
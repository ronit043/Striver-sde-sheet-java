package Day17;
import java.util.*;

/*    TC: O(n), SC: O(n)
Use preorder traversal and for each level of the binary tree include the leftmost node in the answer. In the
preorder traversal, we will traverse the left subtree of any node before the right subtree so that all nodes
to the left of the current node are visited before the nodes which are on the right of the current node.
Hence, for any level, we will reach the leftmost node before we reach any other node in the same level, and
we only need to include the leftmost node of each level in our answer.
 */
class Left_View {
   public List<Integer> getLeftView(TreeNode root) {
      List<Integer> ans = new ArrayList<>();
      dfs(ans, root, 0);
      return ans;
   }

   void dfs(List<Integer> al, TreeNode node, int curr_depth) {
      if (node == null) return;
      if (al.size() == curr_depth) al.add(node.val);
      dfs(al, node.left, curr_depth + 1);
      dfs(al, node.right, curr_depth + 1);
   }
}
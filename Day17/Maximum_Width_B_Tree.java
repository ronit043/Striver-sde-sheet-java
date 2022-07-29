package Day17;
import java.util.ArrayList;
import java.util.List;

/*    TC: O(n), SC: O(n)
We traverse using a pre-order traversal. We calculate the maximum width of the level by taking max of
current width and right_most – left_most + 1. Where idx is the right_most, and al.get(level) is left_most
We assign an idx to every node as:

Left child gets: 2 * current col value
Right child gets: 2 * current col value + 1
 */
class Maximum_Width_B_Tree {
   public int widthOfBinaryTree(TreeNode root) {
      int[] width = new int[1];
      dfs(root, new ArrayList<>(), width, 1, 0);
      return width[0];
   }

   void dfs(TreeNode node, List<Integer> al, int[] width, int idx, int level) {
      if (node == null) return;
      if (al.size() == level) al.add(idx);
      width[0] = Math.max(width[0], idx - al.get(level) + 1);
      dfs(node.left,  al, width, idx * 2, level + 1);
      dfs(node.right, al, width, idx * 2 + 1, level + 1);
   }
}
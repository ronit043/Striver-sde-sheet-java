package Day18;
import Day17.TreeNode;
/*
Use post-order traversal calculate left and right subtree heights. Once we have the heights at the current
node, we can easily calculate the diameter of the current node.

In the Post Order of every node, calculate diameter and height of the current node.
Update diameter to store the maximum diameter possible.
Return height of current node to the previous recursive call.
 */
public class Diameter_of_B_tree {
   public int diameterOfBinaryTree(TreeNode root) {
      int[] diameter = new int[1];
      dfs(root, diameter);
      return diameter[0];
   }

   int dfs(TreeNode root, int[] diameter) {
      if (root == null) return 0;
      int lh = dfs(root.left, diameter), rh = dfs(root.right, diameter);

      diameter[0] = Math.max(diameter[0], lh + rh);
      return 1 + Math.max(lh, rh);
   }
}
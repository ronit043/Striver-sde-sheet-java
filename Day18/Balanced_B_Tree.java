package Day18;
import Day17.TreeNode;
/*
Making use of post-order traversal, calculate the heights of the left and right subtrees and perform
validation. It's balanced only, if both of its left and right subtrees are balanced and their depths differ
by at most 1. The depth of the current subtree is one + depth of deeper one (left and right subtree) i.e.
max(lh, rh) + 1. The base case is a null tree -- we see it as balanced and of depth 0.
 */
class Balanced_B_Tree {
   boolean isBalanced(TreeNode root) { return dfs(root) != -1; }
   int dfs(TreeNode root) {
      if (root == null) return 0;
      int lh = dfs(root.left), rh = dfs(root.right);
      if (lh == -1 || rh == -1 || Math.abs(lh - rh) > 1) return -1;
      return 1 + Math.max(lh, rh);
   }
}
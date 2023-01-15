package Day20;
import Day17.TreeNode;

class Validate_BST {
   boolean isValidBST(TreeNode root) { return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE); }

   boolean dfs(TreeNode node, long minVal, long maxVal) {
      // A null node is a BST, so we return true
      if (node == null) return true;

      // Return false if this node violates the min/max constraints
      if (node.val <= minVal || node.val >= maxVal) return false;
      // Otherwise check the subtrees recursively tightening the min/max constraints
      // Allow only distinct values
      return dfs(node.left, minVal, node.val) && dfs(node.right, node.val, maxVal);
   }
}
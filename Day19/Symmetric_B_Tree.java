package Day19;
import Day17.TreeNode;

class Symmetric_B_Tree {
   public boolean isSymmetric(TreeNode root) { return dfs(root.left, root.right); }

   boolean dfs(TreeNode p, TreeNode q) {
      // Unequal nullity denotes that the trees may-not be the same
      // In that case check if they're referring to the same node or not
      if (p == null || q == null) return p == q;
      if (p.val != q.val) return false; // Found a mismatch
      // Compare the left subtree of `p` with the right subtree of `q`
      // and the right subtree of `p` with the left subtree of `q`
      return dfs(p.left, q.right) && dfs(p.right, q.left);
   }
}
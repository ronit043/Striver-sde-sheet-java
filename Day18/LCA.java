package Day18;
import Day17.TreeNode;
/*
Start moving from the root node. Now consider the following situations:
1. If either p or q is the root node, then the LCA of p and q will be the root node itself.
2. If p and q exist in the left subtree, then the LCA will must be present in the left subtree because
the farthest common ancestor from the root node will be present in the left subtree.
3. Similarly, if p and q exist in the right subtree, then the LCA must be present in the right subtree.
4. If both p and q are present in the different subtrees, then the LCA will be the root node.
 */
public class LCA {
   public TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
      // If root is null or root is p or q(given), return root as it'll be the LCA
      if (root == null || root == p || root == q) return root;

      // Find the LCA in the left and right subtree and store it in left and right
      TreeNode left = lca(root.left, p, q), right = lca(root.right, p, q);

      // If any node is null, return the other node as LCA won't be present in that subtree.
      if (left == null) return right;
      else if (right == null) return left;
      // Both left and right aren't null, meaning left and right
      // are in different subtrees, so root must be LCA
      else return root;
   }
}
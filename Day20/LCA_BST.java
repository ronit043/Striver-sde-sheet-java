package Day20;
import Day17.TreeNode;
/*
Remember to take advantage of the property of BSTs, which is, node.left.val < node.val < node.right.val.
Moreover, both p and q will be the descendants of the root of the subtree that contains
both of them. And the node with the largest depth is the lowest common ancestor.
 */
public class LCA_BST {
   public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      TreeNode lca = root;

      while (lca != null) {
         // If currNode.val is greater than p.val & q.val, then LCA would be in the left subtree.
         if (lca.val > p.val && lca.val > q.val) lca = lca.left;
         // If currNode.val is less than p.val & q.val, then LCA would be in the right subtree.
         else if (lca.val < p.val && lca.val < q.val) lca = lca.right;
         else break;
      }

      return lca;
   }
}
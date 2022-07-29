package Day18;
import Day17.TreeNode;

// TC: O(n), SC: O(n)
public class Same_B_Tree {
   public boolean isSameTree(TreeNode p, TreeNode q) {
      // Unequal nullity denotes that the trees may-not be the same
      // In that case check if they're referring to the same node or not
      if (p == null || q == null) return (p == q);

      // If both nodes of current subtrees aren't null and their values are equal
      // then recursively compare for both left child, and both right child
      return (p.val == q.val) &&
              isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
   }
}
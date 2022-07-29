package Day21;
import Day17.TreeNode;

/*    TC: O(n), SC: O(1)
Initialize ‘ceil’ to store the ceil value to be returned. Run a while loop till node is not equal to NULL.

If the node value >= key, then we store the value of the node in ‘ceil’ and traverse the left subtree
If the node value < key, then we traverse the right subtree.
Finally, return ‘ceil’ as our answer.
 */
public class Ceil_in_BST {
   public int findCeil(TreeNode root, int x) {
      int ceil = -1;

      while (root != null) {
         if (root.val >= x) {
            ceil = root.val;
            root = root.left;
         } else root = root.right;
      }

      return ceil;
   }
}
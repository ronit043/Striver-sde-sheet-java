package Day21;
import Day17.TreeNode;

/*    TC: O(n), SC: O(1)
Initialize ‘floor’ to store the floor value to be returned. Run a while loop till node is not equal to NULL.

If the node value <= key, then we store the value of the node in ‘floor’ and traverse the right subtree
If the node value > key, then we traverse the left subtree.
Finally, return ‘floor’ as our answer.
 */
class Floor_in_BST {
   public static int floorInBST(TreeNode root, int x) {
      int floor = -1;

      while (root != null) {
         if (root.val <= x) {
            floor = root.val;
            root = root.right;
         } else root = root.left;
      }

      return floor;
   }
}
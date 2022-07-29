package Day20;
import Day17.TreeNode;
/*    TC: O(n), SC: O(1)
To search for the number, we start at the root, and then we compare the value to be searched with the
root value if it’s equal we are done with the search if it’s smaller we know that we need to go to the
left subtree because in a BST all the items in the left subtree are smaller and all the items
in the right subtree are larger.
 */
public class Search_in_BST {
   public TreeNode searchBST(TreeNode root, int x) {
      while (root != null) {
         if (root.val > x) root = root.left;
         else if (root.val < x) root = root.right;
         else return root;
      }
      return root;
   }
}
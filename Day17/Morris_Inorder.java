package Day17;
import java.util.*;

/*    TC: O(n), SC: O(1)
Step 1: Initialize current as root
Step 2: While current is not NULL,

   If current does not have left child
       1. Add current’s value
       2. Go to the right, i.e., current = current.right

   Else
       1. In current's left subtree, make current the right child of the rightmost node
       2. Go to this left child, i.e., current = current.left
 */
public class Morris_Inorder {
   public List<Integer> inorderTraversal(TreeNode root) {
      List<Integer> res = new ArrayList<>();
      TreeNode curr = root, pre;

      while (curr != null) {
         if (curr.left == null) {
            res.add(curr.val);
            curr = curr.right; // move to next right node
         } else { // has a left subtree
            pre = curr.left;
            while (pre.right != null) pre = pre.right; // find rightmost
            pre.right = curr; // put cur after the pre node
            TreeNode temp = curr; // store cur node
            curr = curr.left; // move cur to the top of the new tree
            temp.left = null; // original cur left be null, avoid infinite loops
         }
      }
      return res;
   }
}
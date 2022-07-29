package Day17;
import java.util.*;

public class Morris_Preorder {
   public List<Integer> preorderTraversal(TreeNode root) {
      List<Integer> pre = new ArrayList<>();
      TreeNode curr = root;

      while (curr != null) {
         if (curr.left == null) {
            // include in the current list
            pre.add(curr.val);
            //move right since left is null
            curr = curr.right;
         } else {
            TreeNode prev = curr.left;
            // Moving to the rightmost node of the left subtree
            // and the right shouldn't be pointing to itself
            while (prev.right != null && prev.right != curr)
               prev = prev.right;

            if (prev.right == null) {
               prev.right = curr;
               pre.add(curr.val);
               curr = curr.left;
            }
            // If the previous reference points to curr
            else {
               prev.right = null;
               curr = curr.right;
            }
         }
      }

      return pre;
   }
}
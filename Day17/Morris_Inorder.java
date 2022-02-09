package Day17;

import java.util.ArrayList;
import java.util.List;

public class Morris_Inorder {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> in = new ArrayList<>();
        TreeNode curr = root;

        while (curr != null) {
            if (curr.left == null) {
                // include in the current list
                in.add(curr.val);
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
                    curr = curr.left;
                } 
                // If the previous reference points to curr
                else {
                    prev.right = null;
                    in.add(curr.val);
                    curr = curr.right;
                }
            }
        }

        return in;
    }
}
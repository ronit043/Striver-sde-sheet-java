package Day21;

import Day17.TreeNode;

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
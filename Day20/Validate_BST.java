package Day20;

import Day17.TreeNode;

public class Validate_BST {
    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    boolean validate(TreeNode root, long minValue, long maxValue) {
        if (root == null) return true;
        if(root.val < minValue || root.val > maxValue) return false;
        return validate(root, root.val, maxValue) && validate(root, minValue, root.val);
    }
}
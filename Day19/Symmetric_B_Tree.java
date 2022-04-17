package Day19;

import Day17.TreeNode;

public class Symmetric_B_Tree {
    public boolean isSymmetric(TreeNode root) {
        return symmHelp(root.left, root.right);
    }

    boolean symmHelp(TreeNode left, TreeNode right) {
        if (left == null || right == null) return left == right;
        if (left.val != right.val) return false;
        return symmHelp(left.left, right.right) && symmHelp(left.right, right.left);
    }
}
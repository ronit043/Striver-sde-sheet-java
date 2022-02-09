package Day18;

import Day17.TreeNode;

public class Balanced_B_Tree {
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }
    public int height(TreeNode root) {
        if(root == null) return 0;
        int l = height(root.left), r = height(root.right);
        if(l == -1 || r == - 1 || Math.abs(l - r) > 1) return -1;
        return Math.max(l, r) + 1;
    }
}
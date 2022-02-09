package Day18;

import Day17.TreeNode;

public class Height_of_B_Tree {
    public int height(TreeNode root) {
        if(root == null) return 0;
        int l = height(root.left), r = height(root.right);
        return Math.max(l, r) + 1;
    }
}
package Day18;

import Day17.TreeNode;

public class Diameter_of_B_tree {

    public int diameterOfBinaryTree(TreeNode root) {
        int[] max = new int[1];
        maxDepth(root, max);
        return max[0];
    }

    int maxDepth(TreeNode root, int[] max) {
        if (root == null) return 0;
        int left = maxDepth(root.left, max), right = maxDepth(root.right, max);
        max[0] = Math.max(max[0], left + right);
        return Math.max(left, right) + 1;
    }
}
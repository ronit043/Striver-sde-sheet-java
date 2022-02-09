package Day19;

import Day17.TreeNode;

public class B_Tree_Max_Path_Sum {
    public int maxPathSum(TreeNode root) {
        int[] maxV = new int[1];
        maxV[0] = Integer.MIN_VALUE;
        maxP(maxV, root);
        return maxV[0];
    }

    int maxP(int[] maxV, TreeNode root) {
        if (root == null) return 0;
        int ls = Math.max(0, maxP(maxV, root.left)), rs = Math.max(0, maxP(maxV, root.right));
        maxV[0] = Math.max(maxV[0], root.val + ls + rs);
        return root.val + Math.max(ls, rs);
    }
}
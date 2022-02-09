package Day18;

import Day17.TreeNode;

public class LCA {
    public TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);

        if(left == null) return right;
        else if(right == null) return left;
        // both left and right aren't null, so we found answer
        else return root;
    }
}
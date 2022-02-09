package Day20;

import Day17.TreeNode;

public class LCA_BST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode lca = root;

        while (lca != null) {
            if(lca.val > p.val && lca.val > q.val) lca = lca.left;
            else if (lca.val < p.val && lca.val < q.val) lca = lca.right;
            else break;
        }

        return lca;
    }
}
package Day20;

import Day17.TreeNode;

public class BST_From_Preorder {
    public TreeNode bstFromPreorder(int[] preorder) {
        return buildTree(preorder, Integer.MAX_VALUE);
    }

    TreeNode buildTree(int[] preorder, int ub) {
        return new TreeNode(preorder[0]);
    }
}
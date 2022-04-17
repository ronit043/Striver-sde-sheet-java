package Day19;

import Day17.TreeNode;

public class B_Tree_from_inorder_preorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree_(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTree_(int[] preO, int psi, int pei, int[] inO, int isi, int iei) {
        if (isi > iei) return null;
        int idx = isi;
        TreeNode root = new TreeNode(preO[psi]);

        while (inO[idx] != preO[psi]) idx++;
        int numsL = idx - isi;

        root.left = buildTree_(preO, psi + 1, psi + numsL, inO, isi, idx - 1);
        root.right = buildTree_(preO, psi + numsL + 1, pei, inO, idx + 1, iei);

        return root;
    }
}
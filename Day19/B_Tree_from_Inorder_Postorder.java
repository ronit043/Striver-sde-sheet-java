package Day19;

import Day17.TreeNode;

public class B_Tree_from_Inorder_Postorder {
    public TreeNode buildTree(int[] postorder, int[] inorder) {
        return buildTree_(postorder, 0, postorder.length - 1,
                                inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTree_(int[] pstO, int psi, int pei, int[] inO, int isi, int iei) {
        if(isi > iei) return null;
        int idx = isi;
        TreeNode root = new TreeNode(pstO[pei]);

        while (inO[idx] != pstO[pei]) idx++;
        int numsL = idx - isi;

        root.left = buildTree_(pstO, psi, psi + numsL - 1, inO, isi, idx - 1);
        root.right = buildTree_(pstO, psi + numsL, pei - 1, inO, idx + 1, iei);

        return root;
    }
}
package Day21;

import Day17.TreeNode;

public class Kth_Smallest_Element_BST {
    int count = 0, ans = Integer.MIN_VALUE;

    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return ans;
    }

    public void traverse(TreeNode node, int k) {
        if (node == null) return;

        traverse(node.left, k);
        count++;
        if (count == k) ans = node.val;
        traverse(node.right, k);
    }
}
package Day20;

import Day17.TreeNode;

public class Search_in_BST {
    public TreeNode searchBST(TreeNode root, int x) {
        while (root != null) {
            if (x < root.val) root = root.left;
            else if (x > root.val) root = root.right;
            else return root;
        }
        return root;
    }
	/*
	public TreeNode searchBST(TreeNode root, int val) {
        if(root == null || root.val == val) return root;
        return (val < root.val) ? searchBST(root.left, val) : searchBST(root.right, val);
    }
	*/
}
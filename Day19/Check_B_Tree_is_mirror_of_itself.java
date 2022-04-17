package Day19;

import Day17.TreeNode;

public class Check_B_Tree_is_mirror_of_itself {
    void mirror(TreeNode root) {
        if (root == null) return;
        mirror(root.left);
        mirror(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
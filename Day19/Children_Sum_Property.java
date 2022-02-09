package Day19;

import Day17.TreeNode;

public class Children_Sum_Property {
    public static void changeTree(TreeNode root) {
        // Base Cases.
        if (root == null || (root.left == null && root.right == null)) return;

        // Calculate the difference between the root and its children.
        int difference = root.val
                - ((root.left != null ? root.left.val : 0)
                + (root.right != null ? root.right.val : 0));

        // If the difference is positive, increment either left or right child node.
        if (difference > 0) {
            if (root.left != null) root.left.val += difference;
            else root.right.val += difference;
        }

        // Call this function again for the left and right subtree.
        changeTree(root.left);
        changeTree(root.right);

        // Update root with the sum of the left and right child's val.
        root.val = ((root.left != null ? root.left.val : 0) +
                (root.right != null ? root.right.val : 0));
    }
}
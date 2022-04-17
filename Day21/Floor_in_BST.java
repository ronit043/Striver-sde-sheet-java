package Day21;

import Day17.TreeNode;

public class Floor_in_BST {
    public static int floorInBST(TreeNode root, int x) {
        int floor = -1;

        while (root != null) {
            if (root.val <= x) {
                floor = root.val;
                root = root.right;
            } else root = root.left;
        }

        return floor;
    }
}
package Day18;

import java.util.List;
import java.util.ArrayList;

import Day17.TreeNode;

public class Boundary_Traversal {
    public List<Integer> boundary(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        res.add(root.val);
        addLeftB(root.left, res);
        leafNodes(root, res);
        addRightB(root.right, res);

        return res;
    }

    void addLeftB(TreeNode root, List<Integer> res) {
        if (root == null || (root.left == null && root.right == null)) return;
        if (root.left == null) {
            res.add(root.val);
            addLeftB(root.right, res);
        } else {
            res.add(root.val);
            addLeftB(root.left, res);
        }
    }

    void leafNodes(TreeNode root, List<Integer> res) {
        if (root.left == null && root.right == null) res.add(root.val);
        if (root.left != null) leafNodes(root.left, res);
        if (root.right != null) leafNodes(root.right, res);
    }

    void addRightB(TreeNode root, List<Integer> res) {
        if (root == null || (root.left == null && root.right == null)) return;
        if (root.right == null) {
            addRightB(root.left, res);
            res.add(root.val);
        } else {
            addRightB(root.right, res);
            res.add(root.val);
        }
    }
}
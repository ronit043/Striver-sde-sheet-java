package Day20;

import Day17.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Predecessor_Successor_BST {
    public List<Integer> predecessorSuccessor(TreeNode root, int key) {
        List<Integer> res = new ArrayList<>();
        findPre(root, res, key);
        findSucc(root, res, key);
        return res;
    }

    void findPre(TreeNode node, List<Integer> res, int key) {
        while (node != null) {
            if (node.val >= key) node = node.left;
            else {
                res.add(node.val);
                node = node.right;
            }
        }
    }

    void findSucc(TreeNode node, List<Integer> res, int key) {
        while (node != null) {
            if (node.val <= key) node = node.right;
            else {
                res.add(node.val);
                node = node.left;
            }
        }
    }
}
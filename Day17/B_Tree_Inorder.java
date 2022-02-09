package Day17;

import java.util.*;

public class B_Tree_Inorder {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inHelp(root, res);
        return res;
    }

    void inHelp(TreeNode root, List<Integer> res) {
        if (root == null) return;
        inHelp(root.left, res);
        res.add(root.val);
        inHelp(root.right, res);
    }

    //Iterative

    // public List<Integer> inorderTraversal(TreeNode root) {
    //     List<Integer> ans = new ArrayList<>();
    //     Deque<TreeNode> stq = new ArrayDeque<>();

    //     while(root != null || !stq.isEmpty()) {
    //         while(root != null) {
    //             stq.push(root);
    //             root = root.left;
    //         }
    //         root = stq.pop();
    //         ans.add(root.val);
    //         root = root.right;
    //     }
    //     return ans;
    // }
}
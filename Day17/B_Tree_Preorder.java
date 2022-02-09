package Day17;

import java.util.*;

public class B_Tree_Preorder {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preHelp(root, ans);
        return ans;
    }
    void preHelp(TreeNode root, List<Integer> al) {
        if(root == null) return;
        al.add(root.val);
        preHelp(root.left, al);
        preHelp(root.right, al);
    }

    //Iterative

    // public List<Integer> preorderTraversal(TreeNode root) {
    //     List<Integer> ans = new ArrayList<>();
    //     Deque<TreeNode> stq = new ArrayDeque<>();

    //     if(root == null) return ans;
    //     stq.push(root);
    //     while (!stq.isEmpty()) {
    //         root = stq.pop();
    //         ans.add(root.val);
    //         if(root.right != null) stq.push(root.right);
    //         if(root.left != null) stq.push(root.left);
    //     }

    //     return ans;
    // }
    
}
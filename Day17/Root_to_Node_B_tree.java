package Day17;

import java.util.ArrayList;
import java.util.List;

public class Root_to_Node_B_tree {
    public List<Integer> solve(TreeNode root, int target) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        dfs(root, res, target);
        return res;
    }

    void dfs(TreeNode node, List<Integer> ans, int key) {
        if (node == null) return;
        ans.add(node.val);
        
        dfs(node.left, ans, key);
        if (ans.get(ans.size() - 1) == key) return;

        dfs(node.right, ans, key);
        if (ans.get(ans.size() - 1) == key) return;

        ans.remove(ans.size() - 1);
        return;
    }
}
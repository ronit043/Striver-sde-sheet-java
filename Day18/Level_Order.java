package Day18;

import java.util.ArrayDeque; import java.util.ArrayList; import java.util.List; import java.util.Deque;

import Day17.TreeNode;

public class Level_Order {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> q = new ArrayDeque<>();
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        
        q.offer(root);
        while(!q.isEmpty()) {
            int count = q.size();
            List<Integer> layer_vals = new ArrayList<>();
            for(int i = 0; i < count; i++) {
                TreeNode temp = q.poll();
                layer_vals.add(temp.val);

                if(temp.left != null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);
            }
            ans.add(layer_vals);
        }
        
        return ans;
    }
}
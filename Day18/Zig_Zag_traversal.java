package Day18;

import java.util.ArrayList; import java.util.LinkedList; import java.util.List;
import java.util.Queue;

import Day17.TreeNode;

public class Zig_Zag_traversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        boolean order = true;
        
        if(root == null) return ans;
        
        q.offer(root);
        while(!q.isEmpty()) {
            int count = q.size();
            List<Integer> layer_vals = new ArrayList<>();
            
            for(int i = 0; i < count; i++) {
                TreeNode temp = q.poll();
                if(order) layer_vals.add(temp.val);
                else layer_vals.add(0, temp.val);
                
                if(temp.left != null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);
            }
            ans.add(layer_vals);
            order = order ? false : true;
        }
        
        return ans;
    }
}

package Day17;

import java.util.*;

public class Bottom_View {
    List<Integer> getBottomView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        TreeMap<Integer, TreeNode> tm = new TreeMap<>();
        if(root == null) return res;

        q.offer(new Pair(root, 0));
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int l = p.line;
            TreeNode curr = p.node;

            if (!tm.containsKey(l)) tm.put(l, curr);
            else tm.replace(l, curr);
            
            if (curr.left != null) q.offer(new Pair(curr.left, l - 1));
            if (curr.right != null) q.offer(new Pair(curr.right, l + 1));
        }
        
        for (TreeNode t : tm.values()) res.add(t.val);
        return res;
    }
}
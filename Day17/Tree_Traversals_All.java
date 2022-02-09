package Day17;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Tree_Traversals_All {
    public static List<List<Integer>> getTreeTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> pre = new ArrayList<>(), in = new ArrayList<>(), post = new ArrayList<>();
        Deque<Pair> stq = new ArrayDeque<>();

        if(root == null) return ans;

        stq.push(new Pair(root, 1));
        while (!stq.isEmpty()) {
            Pair p = stq.pop();
            if (p.line == 1) {
                pre.add(p.line);
                p.line++;
                if (p.node.left != null) stq.push(new Pair(p.node.left, 1));
                
            } else if(p.line == 2) {
                in.add(p.line);
                p.line++;
                if (p.node.right != null) stq.push(new Pair(p.node.right, 2));
            }
            else {
                post.add(p.line);
                stq.pop(); 
            } 
        }
        ans.add(pre);
        ans.add(in);
        ans.add(post);
        return ans;
    }
}
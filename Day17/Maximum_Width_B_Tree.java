package Day17;

import java.util.LinkedList;

public class Maximum_Width_B_Tree {
    public int widthOfBinaryTree(TreeNode root) {
        LinkedList<TreeNode> q = new LinkedList<>();
        int ans = 1;
        
        if(root == null) return 0;
        q.offer(root);
        
        while (!q.isEmpty()) {
            int sz = q.size();
            ans = Math.max(ans, q.peekLast().val - q.peekFirst().val + 1);
            for (int i = 0; i < sz; i++) {
                root = q.poll();
                if (root.left != null) {
                    root.left.val = root.val * 2;
                    q.offer(root.left);
                }
                if (root.right != null) {
                    root.right.val = root.val * 2 + 1;
                    q.offer(root.right);
                }
            }
        }
        return ans;
    }
}
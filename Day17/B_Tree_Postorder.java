package Day17;

import java.util.*;

public class B_Tree_Postorder {
     public List<Integer> postorderTraversal(TreeNode root) {
         List<Integer> ans = new ArrayList<>();
         postHelp(root, ans);
         return ans;
     }
     void postHelp(TreeNode root, List<Integer> al) {
         if(root == null) return;
         postHelp(root.left, al);
         postHelp(root.right, al);
         al.add(root.val);
     }

    // Iterative

//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        Deque<TreeNode> stq = new ArrayDeque<>();
//
//        if(root == null) return list;
//        stq.push(root);
//        while(!stq.isEmpty()){
//            root = stq.pop();
//            list.add(0, root.val);
//            if(root.left != null) stq.push(root.left);
//            if(root.right != null) stq.push(root.right);
//        }
//
//        return list;
//    }
}
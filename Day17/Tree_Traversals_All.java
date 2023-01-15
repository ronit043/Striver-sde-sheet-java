package Day17;
import java.util.*;

class Tree_Traversals_All {
   public static List<List<Integer>> getTreeTraversal(TreeNode root) {
      List<List<Integer>> ans = new ArrayList<>();
      List<Integer> pre = new ArrayList<>(), in = new ArrayList<>(), post = new ArrayList<>();
      Deque<Node> stq = new ArrayDeque<>();

      if (root == null) return ans;
      stq.push(new Node(root, 0, 1));
      while (!stq.isEmpty()) {
         Node p = stq.pop();
         if (p.col == 1) {
            pre.add(p.col);
            p.col++;
            if (p.node.left != null) stq.push(new Node(p.node.left, 0, 1));

         } else if (p.col == 2) {
            in.add(p.col);
            p.col++;
            if (p.node.right != null) stq.push(new Node(p.node.right, 0, 2));
         } else {
            post.add(p.col);
            stq.pop();
         }
      }
      ans.add(in);
      ans.add(pre);
      ans.add(post);

      return ans;
   }
}
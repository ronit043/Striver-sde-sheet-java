package Day17;
import java.util.*;

//    TC: O(n), SC: O(n)
public class B_Tree_Inorder {
   public List<Integer> inorderTraversal(TreeNode root) {
      List<Integer> res = new ArrayList<>();
      dfs(root, res);
      return res;
   }

   void dfs(TreeNode root, List<Integer> res) {
      if (root == null) return;
      dfs(root.left, res);
      res.add(root.val);
      dfs(root.right, res);
   }

   // Iterative, linear space
   // TC: O(n), SC: O(n)
   // This method is similar to first method, expect this time we're using a stack

   /* public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> stq = new ArrayDeque<>();

        while (!stq.isEmpty() || root != null) {
            while (root != null) {
   // Push the node to the stack, so that on popping we're in the "in" area of the node
                stq.push(root);
   // go to the last node on the left boundary
                root = root.left;
            }
   // Control will come here, when we're in the "in" area of the node, so we pop the node
            root = stq.pop();
   // add the node's value to the list
            ans.add(root.val);
   // after that go to right child of the current node.
            root = root.right;
        }

        return ans;
   }*/
}
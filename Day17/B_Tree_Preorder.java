package Day17;
import java.util.*;

public class B_Tree_Preorder {
   
/*    TC: O(n), SC: O(n)
Recursion is the simple approach and mimics the concept of root -> left -> right for preorder traversal
We need to pass the list as a parameter, so we can add the values of the visited nodes to it.
*/
   public List<Integer> preorderTraversal(TreeNode root) {
      List<Integer> ans = new ArrayList<>();
      dfs(root, ans);
      return ans;
   }

   void dfs(TreeNode root, List<Integer> al) {
      if (root == null) return;
      al.add(root.val);
      dfs(root.left, al);
      dfs(root.right, al);
   }

// Iterative

/*
1. Create an empty stack, Push root node to the stack.
2. Do following while stack (a LIFO data structure) is not empty.
   2.1. pop an item from the stack and add it to the list.
   2.2. push the right child of popped item to stack.
   2.3. push the left child of popped item to stack.

So, when we pop the stack, We get the left subtree first before the right subtree since it's pushed last
*/
   // public List<Integer> preorderTraversal(TreeNode root) {
   //     List<Integer> ans = new ArrayList<>();
   //     Deque<TreeNode> stq = new ArrayDeque<>();
   //     if (root == null) return ans;

   //     stq.push(root);
   //     while (!stq.isEmpty()) {
   //         root = stq.pop();
   //         ans.add(root.val);
   //         if (root.right != null) stq.push(root.right);
   //         if (root.left != null) stq.push(root.left);
   //     }

   //     return ans;
   // }

}
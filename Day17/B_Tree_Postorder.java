package Day17;
import java.util.*;

public class B_Tree_Postorder {
/*    TC: O(n), SC: O(n)
Recursion is the simple approach and mimics the concept of left -> right -> root for postorder traversal
We need to pass the list as a parameter, so we can add the values of the visited nodes to it.
*/
   public List<Integer> postorderTraversal(TreeNode root) {
      List<Integer> ans = new ArrayList<>();
      dfs(root, ans);
      return ans;
   }

   void dfs(TreeNode root, List<Integer> al) {
      if (root == null) return;
      dfs(root.left, al);
      dfs(root.right, al);
      al.add(root.val);
   }

// Iterative

/*
1. Create an empty stack, Push root node to the stack.
2. Do following while stack (a LIFO data structure) is not empty.
   2.1. pop an item from the stack and add it to the list at index 0.
   2.2. push the left child of popped item to stack.
   2.3. push the right child of popped item to stack.

So, when we pop the stack, We get the right subtree first before the left subtree since it's pushed last,
and we can add the right node's value in the 0 index of the list.
*/
//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> al = new ArrayList<>();
//        Deque<TreeNode> stq = new ArrayDeque<>();
//        if (root == null) return al;

//        stq.push(root);
//        while (!stq.isEmpty()) {
//            root = stq.pop();
//            al.add(0, root.val);
//            if (root.left != null) stq.push(root.left);
//            if (root.right != null) stq.push(root.right);
//        }
//
//        return al;
//    }
}
package Day20;
import Day17.TreeNode;

/*    TC: O(N), SC: O(N)
Give the function a parent_value: The maximum number it will handle.
The left recursion will take the elements smaller than node.val
The right recursion will take the remaining elements smaller than parent_value.

We can pass the parent value to the recursive function to generate the left subtree. The generation will
stop when the value in the preorder array exceeds the parent value. That will be our split point to start
generating the right subtree.
 */
class BST_From_Preorder {
   public TreeNode bstFromPreorder(int[] pre) { return dfs(pre, new int[]{0}, Integer.MAX_VALUE); }

   TreeNode dfs(int[] preorder, int[] idx, int parent_value) {
      if (idx[0] == preorder.length || preorder[idx[0]] > parent_value) return null;

      TreeNode node = new TreeNode(preorder[idx[0]++]);

      node.left = dfs(preorder, idx, node.val);
      node.right = dfs(preorder, idx, parent_value);

      return node;
   }
}
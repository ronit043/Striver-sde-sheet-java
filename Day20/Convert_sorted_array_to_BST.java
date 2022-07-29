package Day20;
import Day17.TreeNode;
/*    TC: O(n), SC: O(log(n))
We need to build BST so that it's a height balanced BST. So we choose nums[mid] as the node value this
will ensure that both left and right subtree have equal elements thus maintaining balance of the tree.
Then divide arrays into 2 halves:

One half from [left...mid - 1] for building the left subtree.
Other half from [mid + 1...right] for building the right subtree.
Repeat the recursion until we've completed build BST from all elements in nums array.
 */
public class Convert_sorted_array_to_BST {
   TreeNode sortedArrayToBST(int[] nums) { return dfs(nums, 0, nums.length - 1); }

   public TreeNode dfs(int[] nums, int l, int r) {
      if (l > r) return null;
      int mid = l + (r - l) / 2;
      TreeNode node = new TreeNode(nums[mid]);
      node.left = dfs(nums, l, mid - 1);
      node.right = dfs(nums, mid + 1, r);
      return node;
   }
}
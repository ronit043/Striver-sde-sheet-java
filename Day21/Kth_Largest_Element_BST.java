package Day21;

import Day17.TreeNode;

class Kth_Largest_Element_BST {
   int count = 0, ans = Integer.MIN_VALUE;

   public int kthLargest(TreeNode root, int k) {
      traverse(root, k);
      return ans;
   }

   public void traverse(TreeNode node, int k) {
      if (node == null) return;

      traverse(node.right, k);
      count++;
      if (count == k) ans = node.val;
      traverse(node.left, k);
   }
}

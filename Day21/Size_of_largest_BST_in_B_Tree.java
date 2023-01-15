package Day21;

import Day17.TreeNode;

class Size_of_largest_BST_in_B_Tree {
   public int maxSumBST(TreeNode root) {
      return postOrder(root).maxS;
   }

   public NodeValue postOrder(TreeNode root) {
      if (root == null) return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);

      NodeValue left = postOrder(root.left);
      NodeValue right = postOrder(root.right);

      // Current node is greater than max in left AND smaller than min in right, it is a BST.
      if (left.maxN < root.val && root.val < right.minN) {
         // It is a BST.
         return new NodeValue(Math.min(root.val, left.minN), Math.max(root.val, right.maxN),
                 left.maxS + right.maxS + 1);
      }

      // Otherwise, return [-inf, inf] so that parent can't be valid BST
      return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE,
              Math.max(left.maxS, right.maxS));
   }
}

class NodeValue {
   public int maxN, minN, maxS;

   NodeValue(int maxN, int minN, int maxS) {
      this.maxN = maxN;
      this.minN = minN;
      this.maxS = maxS;
   }
}
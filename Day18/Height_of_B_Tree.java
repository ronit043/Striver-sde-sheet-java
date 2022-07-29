package Day18;
import Day17.TreeNode;
/*
Recursive post order traversal; TC: O(n), SC: O(n)

To calculate the Maximum Depth, we can simply take the maximum depths of the left or right subtree
and add 1 to it. Why take Maximum?? Because we need maximum depth so if we know left & right children’s
maximum depth then we’ll definitely get to the maximum depth of the entire tree.

We start to travel recursively and do our work in Post Order. Reason behind using Post Order comes from our
intuition, that if we know the result of left and right child then we can calculate the result using that.

Base Case is when root == null, so we need to return 0;
 */
public class Height_of_B_Tree {
   public int height(TreeNode root) {
      if (root == null) return 0;
      int l = height(root.left), r = height(root.right);
      return 1 + Math.max(l, r);
   }
}
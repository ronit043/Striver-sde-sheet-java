package Day19;
import Day17.TreeNode;

class Mirror_B_Tree {
   void mirror(TreeNode root) {
      if (root == null) return;

      // calling mirror function recursively for left and right subtrees.
      mirror(root.left);
      mirror(root.right);

      // swapping the left and right subtree.
      TreeNode temp = root.left;
      root.left = root.right;
      root.right = temp;
   }
}
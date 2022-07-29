package Day19;
import Day17.TreeNode;

/*
The idea is to iteratively traverse the tree.
While exploring the current node we place its right subtree (of the current node) at the correct position
in the tree (i.e. make it the right child of the rightmost node in the left subtree, pre-order predecessor)
and make the left subtree the new right subtree of the current node.

This way we can also avoid keeping track of the last node of the linked list.
*/
public class Flatten_B_Tree_to_LL {
   public void flatten(TreeNode root) {
      TreeNode curr = root; // curr: Presently explored node, start exploring root

      while (curr != null) {
         // If the current node has a left child
         if (curr.left != null) {
            // Place the right subtree at its correct position (according to the linked list).
            // To do this, find the rightmost node present in the left subtree.
            TreeNode prev = curr.left;
            while (prev.right != null) prev = prev.right;

            // Make the right subtree of the current node as right child of "prev".
            prev.right = curr.right;
            // Make the left subtree of the current node as the new right subtree.
            curr.right = curr.left;
            // Set the left child of the current node is NULL.
            curr.left = null;
         }
         // Set the right child of the node as the current node
         curr = curr.right;
      }
   }
}
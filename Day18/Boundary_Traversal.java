package Day18;
import java.util.*;
import Day17.TreeNode;
/*    TC: O(N), SC: O(N)
Boundary traversal in an ACW direction can be described as a traversal consisting of three parts:

Part 1: Left Boundary of the tree (excluding the leaf nodes).
Part 2: All the leaf nodes travelled in the left to right direction.
Part 3: Right Boundary of the tree (excluding the leaf nodes), traversed in the reverse direction.

The root node is coming from both the boundaries (left and right). Therefore, to avoid any confusion, we add
it to our list at the very start.

Left boundary, excluding leaves:
-------------------------------------------
If the root is null, or it's a leaf node, then ignore it and return.
If the left child doesn't exist : Add the node's value to the list and move right
Otherwise : Add the node's value to the list and move left

Adding leaves
-----------------
If we're at a leaf node, we add its value to the list. Doing a preorder traversal, to check if the current
node is a leaf node or not. Note that we want the leaves to come in a specific order which is bottom-left
to top-right, therefore a level order traversal will not work because it will print the upper-level leaves
first. Therefore, we use a preorder traversal.

Right boundary, excluding leaves in the reverse direction
------------------------------------------------------------
If the node is null, or it's a leaf node, then ignore it and return.
If the right child doesn't exist : Move left and add the node's value to the list.
Otherwise : Move right and add node's value to the list

Flow of operations for traversing subtrees is reversed as we want reverse right boundary traversal.
 */
class Boundary_Traversal {
   public List<Integer> boundary(TreeNode root) {
      List<Integer> res = new ArrayList<>();
      if (root == null) return res;

      res.add(root.val);
      addLeftB(root.left, res);
      leafNodes(root, res);
      addRightB(root.right, res);

      return res;
   }

   void addLeftB(TreeNode root, List<Integer> res) {
      if (root == null || (root.left == null && root.right == null)) return;
      if (root.left == null) {
         res.add(root.val);
         addLeftB(root.right, res);
      } else {
         res.add(root.val);
         addLeftB(root.left, res);
      }
   }

   void leafNodes(TreeNode root, List<Integer> res) {
      if (root.left == null && root.right == null) res.add(root.val);
      if (root.left != null) leafNodes(root.left, res);
      if (root.right != null) leafNodes(root.right, res);
   }

   void addRightB(TreeNode root, List<Integer> res) {
      if (root == null || (root.left == null && root.right == null)) return;
      if (root.right == null) {
         addRightB(root.left, res);
         res.add(root.val);
      } else {
         addRightB(root.right, res);
         res.add(root.val);
      }
   }
}
package Day20;
import Day17.TreeNode;

/*    TC: O(n), SC: O(1)
Usually standard DFS/BFS takes O(N) space, but since we are given the next pointers in each node, we can use
them to space-optimize our traversal to O(1).

We first populate the next pointers of child nodes of current level. This makes it possible to traverse the
next level without using a queue. To populate next pointers of child, the exact same logic as above is used
We simply traverse to root's left child and repeat the process - traverse current level, fill next pointers
with child nodes and then again update root = root -> left. So, we are basically performing standard BFS
traversal in O(1) space by using next pointers to our advantage.
The process continues till we reach the last level of tree.
 */
class Populate_next_right_pointers_of_tree {
   public TreeNode connect(TreeNode root) {
      TreeNode head = root;

      for (; root != null; root = root.left) {
         for (TreeNode cur = root; cur != null; cur = cur.next) {
            if (cur.left != null) {
               cur.left.next = cur.right;
               if (cur.next != null) cur.right.next = cur.next.left;
            } else break;
         }
      }

      return head;
   }
}
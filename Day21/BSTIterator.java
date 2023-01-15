package Day21;

import Day17.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

class BSTIterator {
   Deque<TreeNode> stq = new ArrayDeque<>();
   // reverse = true -> before
   // reverse = false -> next
   boolean reverse;

   public BSTIterator(TreeNode root, boolean reverse) {
      this.reverse = reverse;
      pushAll(root);
   }

   public int next() {
      TreeNode top = stq.pop();
      pushAll(!reverse ? top.right : top.left);
      return top.val;
   }

   public boolean hasNext() {
      return !stq.isEmpty();
   }

   public void pushAll(TreeNode node) {
      for (; node != null; node = !reverse ? node.left : node.right) stq.push(node);
   }
}
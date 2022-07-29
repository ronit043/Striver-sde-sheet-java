package Day17;

public class TreeNode {
   public int val;
   public TreeNode left, right, next;
   public TreeNode(int val) { this.val = val; }
   public TreeNode(int val, TreeNode left, TreeNode right, TreeNode next) {
      this.val = val;
      this.left = left;
      this.right = right;
      this.next = next;
   }
}
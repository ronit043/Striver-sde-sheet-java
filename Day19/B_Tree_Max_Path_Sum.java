package Day19;
import Day17.TreeNode;
/*
I first set my sum to Integer.MIN_VALUE. I can do either of the options presented:
1. I can choose to take up the left subtree or drop it.
2. I can either choose to take up the right subtree or drop it.
3. I check for a possibility if I were to take both left subtree and right subtree would that beat
my current sum?

I do my postorder traversal with a bit of variation:-
int l = max(dfs(root.left, sum), 0);
int r = max(dfs(root.right, sum), 0);

Why? This is because I have the option to discard the negative value.
 */
public class B_Tree_Max_Path_Sum {
   public int maxPathSum(TreeNode root) {
      int[] sum = new int[1];
      sum[0] = Integer.MIN_VALUE;
      dfs(root, sum);
      return sum[0];
   }

   int dfs(TreeNode node, int[] sum) {
      if (node == null) return 0;

      int ls = Math.max(0, dfs(node.left, sum)), rs = Math.max(0, dfs(node.right, sum));

      sum[0] = Math.max(sum[0], ls + rs + node.val);
      return node.val + Math.max(ls, rs);
   }
}
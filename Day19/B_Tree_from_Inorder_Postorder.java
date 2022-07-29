package Day19;
import Day17.TreeNode;
/*
The basic idea of this approach is to build the tree recursively by utilizing the property of pre and in
order traversal of a binary tree.
 */
public class B_Tree_from_Inorder_Postorder {
   public TreeNode buildTree(int[] postorder, int[] inorder) {
      return dfs(postorder, 0, postorder.length - 1,
              inorder, 0, inorder.length - 1);
   }

   public TreeNode dfs(int[] pstO, int pL, int pR, int[] inO, int iL, int iR) {
      if (iL > iR) return null;
      int idx = iL;
      TreeNode root = new TreeNode(pstO[pR]);

      while (inO[idx] != pstO[pR]) idx++;
      int numsL = idx - iL;

      root.left = dfs(pstO, pL, pL + numsL - 1, inO, iL, idx - 1);
      root.right = dfs(pstO, pL + numsL, pR - 1, inO, idx + 1, iR);

      return root;
   }
}
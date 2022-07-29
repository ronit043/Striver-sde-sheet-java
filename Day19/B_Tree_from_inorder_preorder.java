package Day19;
import Day17.TreeNode;
import java.util.HashMap;
import java.util.Map;

public class B_Tree_from_inorder_preorder {
   public TreeNode buildTree(int[] preorder, int[] inorder) {
      Map<Integer, Integer> inMap = new HashMap<>();
      for (int i = 0; i < inorder.length; i++) inMap.put(inorder[i], i);
      return dfs(preorder, inorder, 0, preorder.length - 1, new int[1], inMap);
   }

   TreeNode dfs(int[] pre, int[] in, int pL, int pR, int[] c, Map<Integer, Integer> inMap) {
      if (pL > pR) return null;
      TreeNode node = new TreeNode(pre[c[0]++]);
      int mid = inMap.get(node.val);
      node.left = dfs(pre, in, pL, mid - 1, c, inMap);
      node.right = dfs(pre, in, mid + 1, pR, c, inMap);
      return node;
   }
}
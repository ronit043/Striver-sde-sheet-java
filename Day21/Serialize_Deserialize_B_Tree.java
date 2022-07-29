package Day21;

import Day17.TreeNode;

public class Serialize_Deserialize_B_Tree {
   // Encodes a tree to a single string.
   public String serialize(TreeNode root) {
      StringBuilder sb = new StringBuilder();
      dfs(root, sb);
      return sb.toString();
   }

   public void dfs(TreeNode x, StringBuilder sb) {
      if (x == null) {
         sb.append("null ");
         return;
      }
      sb.append(String.valueOf(x.val));
      sb.append(' ');
      dfs(x.left, sb);
      dfs(x.right, sb);
   }

   // Decodes your encoded data to tree.
   public TreeNode deserialize(String data) {
      String[] node = data.split(" ");
      int[] d = new int[1];
      return dfs(node, d);
   }

   public TreeNode dfs(String[] node, int[] d) {
      if (node[d[0]].equals("null")) {
         d[0]++;
         return null;
      }

      TreeNode root = new TreeNode(Integer.parseInt(node[d[0]]));
      d[0]++;
      root.left = dfs(node, d);
      root.right = dfs(node, d);

      return root;
   }
}
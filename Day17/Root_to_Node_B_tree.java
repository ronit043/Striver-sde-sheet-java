package Day17;
import java.util.*;

public class Root_to_Node_B_tree {
   public List<Integer> solve(TreeNode root, int target) {
      List<Integer> res = new ArrayList<>();
      dfs(res, root, target);
      return res;
   }

   void dfs(List<Integer> ans, TreeNode node, int key) {
      // If root is null, there is no path
      if (node == null) return;
      // Add the node's val to answer list
      ans.add(node.val);

      // Go to the left-subtree,
      dfs(ans, node.left, key);
      // if the last item of the list == key, then we got the item and can return
      if (ans.get(ans.size() - 1) == key) return;

      // Go to the right-subtree,
      dfs(ans, node.right, key);
      // if the last item of the list == key, then we got the item and can return
      if (ans.get(ans.size() - 1) == key) return;

      // required node does not lie either in the left or right subtree of the
      // current node, so we backtrack, i.e. remove the last item from the list
      ans.remove(ans.size() - 1);
   }
}
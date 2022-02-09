package Day17;

import java.util.ArrayList;
import java.util.List;

public class Left_View {
    public List<Integer> getLeftView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        leftHelp(root, ans, 0);
        return ans;
    }
    void leftHelp(TreeNode node, List<Integer> ans, int l) {
        if(node == null) return;
        if(ans.size() == l) ans.add(node.val);
        leftHelp(node.left, ans, l + 1);
        leftHelp(node.right, ans, l + 1);
    }  
}
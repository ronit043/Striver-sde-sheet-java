package Day17;

import java.util.*;

public class Vertical_Order {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        List<List<Integer>> res = new LinkedList<>();

        if (root == null) return null;

        dfs(map, root, 0, 0);
        for (int key : map.keySet()) {
            List<Integer> list = new LinkedList<>();
            TreeMap<Integer, PriorityQueue<Integer>> tm = map.get(key);
            for (int k : tm.keySet()) {
                PriorityQueue<Integer> pq = tm.get(k);
                while (!pq.isEmpty()) list.add(pq.poll());
            }
            res.add(list);
        }

        return res;
    }

    void dfs(Map<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map, TreeNode root, int index, int level) {

        if (root == null) return;

        map.putIfAbsent(index, new TreeMap<>());
        map.get(index).putIfAbsent(level, new PriorityQueue<>());
        map.get(index).get(level).add(root.val);

        dfs(map, root.left, index - 1, level + 1);
        dfs(map, root.right, index + 1, level + 1);
    }
}
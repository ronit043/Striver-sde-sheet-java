package Day17;
import java.util.*;
/*    TC: O(n Log(n)), SC: O(n)
Firstly, we need to create a class Node having the current node and with its row & column values.
We can use PriorityQueue of Nodes, as it gives us the minimum value at the top. We use a lambda expression
so that values of the same row will be in ascending order else, the value on a row which comes first will
be on the top.
We need a TreeMap that links column number to the nodes in that column. Where column value is the key and
the nodes (in the list) is the value.

As like the BFS solution we add the root (along with its row and column values) in the PriorityQueue.
Beginning the iteration, we remove the item from atop the PriorityQueue. If for that column value,
there exists a list of values, then we fetch the list (from the map) otherwise create a new list.
We add the current node's value in the list & then add the column value along with the list in the map.
Now we'll check whether the left and right subtree of the current node exist or not.

If the left subtree exists:
Increase the row value, decrease the column value and add the node as an object of node class in the queue.

If the right subtree exists
Increase the row value, increase the column value and add the node as an object of node class in the queue.

Once the PriorityQueue is empty, we add all the lists in the 2d list and return it.
*/
class Vertical_Order {
   public List<List<Integer>> verticalTraversal(TreeNode root) {
      Queue<Node> pq = new PriorityQueue<>((a, b) ->
         a.row == b.row ? a.node.val - b.node.val : a.row - b.row
      );
      Map<Integer, List<Integer>> tm = new TreeMap<>();

      pq.add(new Node(root, 0, 0));
      while (!pq.isEmpty()) {
         Node curr = pq.poll();
         List<Integer> al = tm.getOrDefault(curr.col, new ArrayList<>());
         al.add(curr.node.val);
         tm.put(curr.col, al);

         if (curr.node.left != null)
            pq.add(new Node(curr.node.left, curr.row + 1, curr.col  - 1));

         if (curr.node.right != null)
            pq.add(new Node(curr.node.right, curr.row + 1, curr.col + 1));
      }

      return new ArrayList<>(tm.values());
   }
}
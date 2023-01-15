package Day17;

class Node {
   TreeNode node;
   int row, col;

   Node(TreeNode node, int row, int col) {
      this.node = node;
      this.row = row;
      this.col = col;
   }

   Node(TreeNode node, int col) {
      this.node = node;
      this.col = col;
   }
}

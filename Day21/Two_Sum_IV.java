package Day21;

import Day17.TreeNode;

public class Two_Sum_IV {
    public boolean findTarget(TreeNode root, int k) {
        BSTIterator leftI = new BSTIterator(root.left, false);
        BSTIterator rightI = new BSTIterator(root.right, true);

        int l = leftI.next(), r = rightI.next();
        while (l < r) {
            if (l + r == k) return true;
            else if(l + r < k) l = leftI.next();
            else r = rightI.next();
        }
        return false;
    }
}
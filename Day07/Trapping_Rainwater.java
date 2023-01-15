package Day07;

/*
        TC : O(n), SC : O(1)

We'll maintain a highL and highR to store the max height of blocks on the left and right side.
With highL or highR we can figure water height, that can be bounded by highL or highR.

If the height on the left is smaller, then we are in the left block otherwise in the right block. We need to
store the maximum of (highL or height @ l) or (highR or height @ r) depending on the block, now add the height
difference to total and depending on the block increase l or decrease r. At last return the water trapped.
 */
class Trapping_Rainwater {
   public int trap(int[] height) {
      int total = 0, highL = 0, highR = 0;

      for (int l = 0, r = height.length - 1; l < r; ) {
         if (height[l] < height[r]) {
            highL = Math.max(highL, height[l]);
            total += highL - height[l++];
         } else {
            highR = Math.max(highR, height[r]);
            total += highR - height[r--];
         }
      }

      return total;
   }
}
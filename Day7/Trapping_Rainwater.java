package Day7;

public class Trapping_Rainwater {
    public int trap(int[] height) {
        int total = 0, highL = 0, highR = 0;

        for (int l = 0, r = height.length - 1; l < r;) {
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
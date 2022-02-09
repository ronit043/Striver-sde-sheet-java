package Day8;

import java.util.Arrays;

public class Minimum_Platforms {
    public int findPlatform(int[] arr, int[] dep, int n) {
        int maxP = 1, arrH = 0, depH = 0, plt = 1;
        Arrays.sort(arr); Arrays.sort(dep);
        while (arrH < n - 1) {
            if(dep[depH] >= arr[arrH + 1]) {
                plt++;
                arrH++;
            }
            else {
                plt--;
                depH++;
            }
            maxP = Math.max(maxP, plt);
        }

        return maxP;
    }
}
package Day8;

import java.util.Arrays;

public class Job_Sequencing {
    int[] JobScheduling(Job[] arr, int n) {
        Arrays.sort(arr, (p1, p2) -> p2.profit - p1.profit);
        int maxD = 0, profit = 0, jobs = 0, ans[] = new int[2];

        for (Job i : arr) maxD = Math.max(maxD, i.deadline);
        int timeline[] = new int[maxD + 1];

        for (Job i : arr) {
            if (timeline[i.deadline] == 0) {
                profit += i.profit;
                jobs++;
                timeline[i.deadline] = 1;
            } else {
                int j = i.deadline;
                while (j > 0) {
                    if (timeline[j] == 0) {
                        profit += i.profit;
                        jobs++;
                        timeline[j] = 1;
                        break;
                    }
                    j--;
                }
            }
        }
		ans[0] = jobs; ans[1] = profit;
        return ans;
    }
}

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        id = x;
        deadline = y;
        profit = z;
    }
}
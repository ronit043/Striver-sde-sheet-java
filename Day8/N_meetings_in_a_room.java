package Day8;

import java.util.Arrays;

public class N_meetings_in_a_room {
    public static int maxMeetings(int[] start, int[] end, int n) {
        int next = 0, cont = 0;
        Activity[] arr = new Activity[n];
        for (int i = 0; i < n; i++)
            arr[i] = new Activity(start[i], end[i]);

        Arrays.sort(arr, (x, y) -> x.b - y.b);

        for (int i = 0; i < n; i++) {
            if (arr[i].a > next) {
                cont += 1;
                next = arr[i].b;
            }
        }

        return cont;
    }
}

class Activity {
    int a, b;
    Activity(int a, int b) {
        this.a = a;
        this.b = b;
    }
}
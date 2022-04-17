package Day11;

import java.io.*; import java.util.*;

public class Aggressive_Cows {
    public static void main(String[] args) {
        int tt = getInt();
        for (int i = 0; i < tt; i++) {
            int stalls = getInt(), cows = getInt();
            int[] stallPos = getIntArray(stalls);
            Arrays.sort(stallPos);
            out.println(binarySearch(cows, stallPos));
        }
        out.close();
    }

    static int binarySearch(int cows, int[] arr) {
        int l = 1, r = arr[arr.length - 1] - arr[0], ans = -1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if(check(m, cows, arr)) {
                ans = m;
                l = m + 1;
            }
            else r = m - 1;
        }

        return ans;
    }

    static boolean check(int dist, int cows, int[] arr) {
        int lastPlaced = arr[0], cowPlaced = 1;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] - lastPlaced >= dist) {
                cowPlaced++;
                lastPlaced = arr[i];
            }
        }
        return cowPlaced >= cows;
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); static StringTokenizer st = new StringTokenizer("");
    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    static String get() { while (!st.hasMoreTokens() || st == null) {try { st = new StringTokenizer(br.readLine()); }  catch (IOException e) { e.printStackTrace(); } } return st.nextToken();}
    static int getInt() { return Integer.parseInt(get()); }
    static int[] getIntArray(int n) { int[] a = new int[n]; for (int i = 0; i < n; i++) a[i] = getInt(); return a; }
}
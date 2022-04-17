package Day10;

import java.util.List;

public class M_Coloring {
    public static boolean graphColoring(List<Integer>[] G, int[] color, int i, int m) {
        return check(i, G.length, G, color, m);
    }
    static boolean check(int node, int n, List<Integer>[] G, int []color, int m) {
        if (node == n) return true;
        for (int i = 1; i <= m; i++) {
            if (isPossible(i, G, node, color)) {
                color[node] = i;
                if (check(node + 1, n, G, color, m)) return true;
                color[node] = 0;
            }
        }
        return false;
    }
    static boolean isPossible(int clr, List<Integer>[] G, int node, int []color) {
        for (int k : G[node])
            if (color[k] == clr) return false;
        return true;
    }
}
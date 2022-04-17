package Day10;

import java.util.ArrayList;
import java.util.List;

public class Rat_in_a_maze {
    public List<String> findPath(int[][] m, int n) {
        List<String> ans = new ArrayList<>();
        if (m[0][0] == 0 || m[n - 1][n - 1] == 0)
            return ans;

        dfs(m, n, 0, 0, "", ans);
        return ans;
    }


    void dfs(int[][] m, int n, int x, int y, String path, List<String> ans) {
        if (x < 0 || x >= n || y < 0 || y >= n || m[x][y] == 0)
            return;

        if (x == n - 1 && y == n - 1) {
            ans.add(path);
            return;
        }

        m[x][y] = 0;
        dfs(m, n, x + 1, y, path + "D", ans);
        dfs(m, n, x, y - 1, path + "L", ans);
        dfs(m, n, x, y + 1, path + "R", ans);
        dfs(m, n, x - 1, y, path + "U", ans);
        m[x][y] = 1;
    }
}
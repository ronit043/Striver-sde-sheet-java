package Day10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N_Queens {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] cs : board) Arrays.fill(cs, '.');
        List<List<String>> al = new ArrayList<>();
        dfs(board, 0, al);
        return al;
    }

    public void dfs(char[][] board, int row, List<List<String>> res) {
        if (row == board.length) {
            List<String> possibleResult = resultBuilder(board);
            res.add(possibleResult);
            return;
        }

        for(int i = 0; i < board.length; i++) {
            if(isSafe(board, i, row)) {
                board[i][row] = 'Q';
                dfs(board, row + 1, res);
                board[i][row] = '.';
            }
        }
    }

    public boolean isSafe(char[][] board, int x, int y) {
        for(int i = 0; i < board.length; i++) { for(int j = 0; j < y; j++)
            if(board[i][j] == 'Q' && (x + j == y + i || x + y == i + j || x == i))
                return false;
        }
        return true;
    }

    public List<String> resultBuilder(char[][] matrix) {
        List<String> list = new ArrayList<>();
        for (char[] chars : matrix) list.add(new String(chars));
        return list;
    }
}
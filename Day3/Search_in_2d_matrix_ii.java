package Day3;

public class Search_in_2d_matrix_ii {
	public boolean searchMatrix(int[][] matrix, int target) {
		int r = 0, c = matrix[0].length - 1;
		while (r <= matrix.length - 1 && c >= 0) {
			if (target == matrix[r][c]) return true;
			else if (matrix[r][c] > target) c--;
			else r++;
		}
		return false;
	}
}
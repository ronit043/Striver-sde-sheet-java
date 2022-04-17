package Day2;

public class Rotate_Matrix {
    public void rotate(int[][] matrix) {
		int r = matrix.length, c = r;

		// transpose logic
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < i; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		// flip logic
		for (int i = 0; i < r; i++) {
			for (int l = 0, ri = c - 1; l <= ri; l++, ri--) {
				int temp = matrix[i][ri];
				matrix[i][ri] = matrix[i][l];
				matrix[i][l] = temp;
			}
		}
	}
}

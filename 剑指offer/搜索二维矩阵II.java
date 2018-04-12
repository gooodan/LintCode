public class Solution {

	public int searchMatrix(int[][] matrix, int target) {

		if (matrix[0].length == 0 || matrix == null) return 0;

		m = matrix.length;
		n = matrix[0].length;

		x = m - 1;
		y = 0;
		int count = 0;

		while (x >= 0 && y < n) {
			if (matrix[x][y] < target) {
				y++;
			} else if (matrix[x][y] > target) {
				x--;
			} else {
				x--;
				y++;
				count++;
			}
		}

		return count;

	}

}
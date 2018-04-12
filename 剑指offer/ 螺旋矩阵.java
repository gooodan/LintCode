// 算法思想：
// 首先考虑最简单的情况,如图我们先找最外面这圈X,这种情况下我们是第一行找前4个
// 最后一列找前4个，最后一行找后4个，第一列找后4个
// 这里我们可以发现，第一行和最后一行，第一列和最后一列都是有对应关系的。
// 即对i行，其对应行是m - i - 1，对于第j列，其对应的最后一列是n - j - 1。
// 参照网站：https://segmentfault.com/a/1190000003817711#articleHeader1

public class Solution {
    /**
     * @param matrix: a matrix of m x n elements
     * @return: an integer list
     */
    public List<Integer> spiralOrder(int[][] matrix) {

		List<Integer> result = new ArrayList<Integer>();

		if (matrix.length == 0) return result;

		int m = matrix.length;
		int n = matrix[0].length;
		
		int lvl = (Math.min(m, n) + 1) / 2;

		for (int i = 0; i < lvl; i++) {
			int lastRow = m - i - 1;
			int lastCol = n - i - 1;

			// 最后一行和第一行相同
			if (i == lastRow) {
				for (int j = i; j <= lastCol; j++) {
					result.add(matrix[i][j]);
				}

			// 最后一列和第一列相同
			} else if (i == lastCol) {
				for (int j = i; j <= lastRow; j++) {
					result.add(matrix[j][i]);
				}
			} else {
				// 第一行
				for (int j = i; j < lastCol; j++) {
					result.add(matrix[i][j]);
				}
				// 最后一列
				for (int j = i; j < lastRow; j++) {
					result.add(matrix[j][lastCol]);
				}
				// 最后一行
				for (int j = lastCol; j > i; j--) {
					result.add(matrix[lastRow][j]);
				}
				// 第一列
				for (int j = lastRow; j > i; j--) {
					result.add(matrix[j][i]);
				}
			}
		}

		return result;
    }

}
package array;

public class TransposeMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4, 5 /* , 6 */},
				{ 7, 8, 9, 10, 11 /* , 12 */}, { 13, 14, 15, 16, 17 /* , 18 */},
				{ 19, 20, 21, 22, 23 /* , 24 */}, { 25, 26, 27, 28, 29 /* , 30 */} };
		matrix = transposeMatrix(matrix);
		for (int m = 0; m < matrix.length; m++) {
			for (int n = 0; n < matrix[m].length; n++) {
				System.out.print(matrix[m][n]+" | ");
			}
			System.out.println("");
		}
	}

	public static int[][] transposeMatrix(int[][] matrix) {
		for (int m = 0; m < matrix.length; m++) {
			for (int n = m; n < matrix[m].length; n++) {
				if (m != n) {
					int temp = matrix[m][n];
					matrix[m][n] = matrix[n][m];
					matrix[n][m] = temp;
				}
			}
		}
		return matrix;
	}
}

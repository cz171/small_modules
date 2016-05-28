package printMatrix;

import java.util.ArrayList;

public class PrintMatrix {
	public static ArrayList<ArrayList<Integer>> print(int[][] matrix) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		int n = matrix.length;
		if (n == 0) {
			return res;
		}
		
		
		for (int iter = 0; iter < n; iter++) {
			int row = 0;
			int col = n - iter - 1;
			
			ArrayList<Integer> partRes = new ArrayList<>();
			while (row < n && col < n) {
				partRes.add(matrix[row++][col++]);
			}
			res.add(partRes);
		}
		
//		for (int iter = 1; iter < n; iter++) {
//			int col = 1;
//			int row = n - iter - 1;
//		}
		for (int iter = 1; iter < n ; iter++) {
			int col = 0;
			int row = iter;
			ArrayList<Integer> partRes = new ArrayList<>();
			while (row < n && col < n) {
				partRes.add(matrix[row++][col++]);
			}
			res.add(partRes);
		}
		return res;
	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = new int[][] {{1 , 2, 3}, {4, 5, 6}, {7, 8, 9}};
		
		ArrayList<ArrayList<Integer>> result = print(matrix);
		System.out.println(result);
	}

}

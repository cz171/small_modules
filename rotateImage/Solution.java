package rotateImage;

import java.util.Arrays;

public class Solution {
	private static void rotate(int[][] grid) {
		//rotate a image clockwise
		int n = grid.length;
		for (int i = 0; i < n ; i++) {
			for (int j = 0; j < i; j++) {
				int temp = grid[i][j];
				grid[i][j] = grid[j][j];
				grid[j][i] = temp;
			}
		}
		
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n / 2; j++) {
				int temp = grid[i][j];
				grid[i][j] = grid[i][n - j - 1];
				grid[i][n - j - 1] = temp;
			}
		}
	}
	
	private static void rotateAntiClock(int[][] grid) {
		//the same thing
		int n = grid.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; i + j <= n / 2; j++) {
				System.out.println(i + " " + j);

				System.out.println((i + n - j - 1) + " " + (n - i - 1));
				int temp = grid[i][j];
				grid[i][j] = grid[i + n - j - 1][n - i - 1];
				grid[i + n - j - 1][n - i - 1] = temp;
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n / 2; j++) {
				int temp = grid[i][j];
				grid[i][j] = grid[i][n - j - 1];
				grid[i][n - j - 1] = temp;
			}
		}
	}
	
	public static void main(String[] args) {
		int[][] image = new int[][] {
			{1, 2, 3},
			{4, 5, 6},
			{7, 8, 9}
		};
		
		rotateAntiClock(image);
		for (int i = 0; i < image.length; i++) {
			System.out.println(Arrays.toString(image[i]));
		}
	}
}

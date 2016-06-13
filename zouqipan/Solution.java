package zouqipan;
import java.util.*;
public class Solution {
	//在一个8*8的棋盘上给两个坐标和一个integer k，
	//返回一共有多少种不同走法，走k步从一个坐标到另一个坐标。
	//用dfs，然后问复杂度。然后follow up怎么降低复杂度。
	static int[] dx = new int[] {-1, 0, 0, 1};
	static int[] dy = new int[] {0, 1, -1, 0};
	static int cnt;
	
	public static int numOfWays(int[][] matrix, int[] p1, int[] p2, int step) {
		//bfs or dfs?
		//bfs似乎不好搞？
		cnt = 0;
		boolean[][] goodPath = new boolean[matrix.length][matrix[0].length];
		boolean[][] visited = new boolean[matrix.length][matrix[0].length];
		dfs(matrix, visited, p1[0], p1[1], p2, step, goodPath);
		return cnt;
	}
	
	public static boolean dfs(int[][] matrix, boolean[][] visited, int i, int j, int[] endPoint, int remain, boolean[][] goodPath) {
		if (goodPath[i][j] && (i != endPoint[0] || j != endPoint[1])) {
			return true;
		}
		
		if (remain < 0) {
			return false;
		}
		
		if (endPoint[0] == i && endPoint[1] == j) {
			if (remain == 0) {
				cnt++;
				return true;
			} 
			return false;
		}
		
		boolean result = false;
		visited[i][j] = true;
		for (int k = 0; k < 4; k++) {
			int row = i + dx[k];
			int col = j + dy[k];
			if (row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length && !visited[row][col]) {
				if (dfs(matrix, visited, row, col, endPoint, remain - 1, goodPath)) {
					goodPath[row][col] = true;
					result = true;
				}
			}
		}
		
		visited[i][j] = false;
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = new int[3][3];
		System.out.println(numOfWays(matrix, new int[] {2, 0}, new int[] {1, 1}, 2));
	}

}

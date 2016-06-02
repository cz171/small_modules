package longestIncreasing;
import java.util.*;


//perfect
//dfs + memorization
//speedup = 1.5 after memorization
public class Solution {
	static int[] dx = {1, 0, 0, -1};
	static int[] dy = {0, 1, -1, 0};
	
	public static int findLongestIncreasingPath(int[][] matrix) {
		//dfs
		int max = 0;
		int[][] map = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				boolean[][] visited = new boolean[matrix.length][matrix[0].length];
				ArrayList<Integer> path = new ArrayList<>();
				max = Math.max(max, dfs(matrix, visited, map, i, j, path));
				
			}
		}
		
		return max;
	}
	
	private static int dfs(int[][] matrix, boolean[][] visited, int[][] map, int i, int j, ArrayList<Integer> path) {
		visited[i][j] = true;
		path.add(matrix[i][j]);
		
 		if (map[i][j] != 0) {
 			return map[i][j];
		}
		
		if (path.size() == 7) {
			printPath(path);
		}
		
		int max = 1;
		for (int iter = 0; iter < 4; iter++) {
			int row = i + dx[iter];
			int col = j + dy[iter];
			if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length) {
				continue;
			}
			
			if (matrix[i][j] < matrix[row][col]) {
				max = Math.max(max, 1 + dfs(matrix, visited, map, row, col, path));
			}
			
		}
		
		path.remove(path.size() - 1);
		visited[i][j] = false;
		//uncomment the following line if don't need to print the path
//		map[i][j] = max; 
		

		return max;
	}
	
	public static void printPath(ArrayList<Integer> path) {
		StringBuilder sb = new StringBuilder();
		for (int node: path) {
			sb.append(node).append("->");
		}
		
		if (path.size() != 0) {
			System.out.println(sb.toString().substring(0,  sb.length() - 2));
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//test case
		int[][] matrix = new int[][] {
			{1, 2, 3, 4},
			{8, 0, 4, 5},
			{11, 10, 9, 2}
		};
		long tStart = System.nanoTime();

		System.out.println(findLongestIncreasingPath(matrix));
		long tEnd = System.nanoTime();
		System.out.println(tEnd - tStart);

		
	}

}

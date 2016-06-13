package findPath;
import java.util.*;

public class Solution {
	static int[] dx = new int[] {-1, 0, 0, 1};
	static int[] dy = new int[] {0, 1, -1, 0};
	
	//let -1 -> visited and false
	//    0 - > unvisited
	//    1 -> visited and true
	private static boolean dfs(int[][] matrix, boolean[][] visited, int i, int j, int[] endPoint, ArrayList<int[]> path) {
		// 1 means obstacle

		if (i < 0 || i > matrix.length || j < 0 || j > matrix[0].length || visited[i][j] || matrix[i][j] == 1) {
			return false;
		}
		
		if (i == endPoint[0] && j == endPoint[1]) {
			path.add(endPoint);
			printPath(path);
			return true;
		}
		
		path.add(new int[] {i, j});
		visited[i][j] = true;
		for (int k = 0; k < 4; k++) {
			int row = i + dx[k];
			int col = j + dy[k];
			
			if (dfs(matrix, visited, row, col, endPoint, path)) {
				return true;
			}
		}
		
		path.remove(path.size() - 1);
		visited[i][j] = false;
		return false;
	}
	
	private static void printPath(ArrayList<int[]> path) {
		String res = "";
		for (int[] point: path) {
			res += point[0] + "," + point[1] + "->";
		}
		
		res = res.length() < 2 ? "" : res.substring(0, res.length() - 2);
		System.out.println(res);
	}
	
	public static boolean findPath(int[][] matrix, int[] startPoint, int[] endPoint) {
		boolean[][] visited = new boolean[matrix.length][matrix[0].length];
		int i = startPoint[0];
		int j = startPoint[1];
		ArrayList<int[]> path = new ArrayList<>();
		if (dfs(matrix, visited, i, j, endPoint, path)) {
			return true;
		}
		
		return false;	
	}
	
	
	public static void main(String[] args) {
		int[][] matrix = new int[][] {
				{0, 0, 1},
				{1, 0, 1},
				{1, 0, 0}
		};
		
		System.out.println(findPath(matrix, new int[] {0, 0}, new int[] {2, 2}));
	}

}

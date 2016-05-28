package color;
import java.util.*;

public class Solution {
	static int[] dx = new int[] {-1, 1, 0, 0};
	static int[] dy = new int[] {0, 0, -1, 1};
	static class Entry {
		int color;
		int id;
		public Entry(int id, int color) {
			this.id = id;
			this.color = color;
		}
	}
	/*
	 * 给了个board，每个entry有一个颜色，给定一个entry和一种颜色A，
	 * 把所有和该entry颜色相同的connected board涂上颜色A。
	 * follow up: DFS 和 BFS有什么优缺点，时间空间复杂度. 
	 */
	public static void bfs(Entry[][] matrix, Entry target, int iTarget, int jTarget) {
		int row = matrix.length;
		int col = matrix[0].length;
		boolean[][] visited = new boolean[row][col];
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {iTarget, jTarget});
		while (!queue.isEmpty()) {
			int size = queue.size();	
			for (int i = 0; i < size; i++) {
				int[] point = queue.poll();
				for (int iter = 0; iter < 4; iter++) {
					int x = dx[iter] + point[0];
					int y = dy[iter] + point[1];
					if (x < 0 || x >= row || y < 0 || y >= col ||visited[x][y]) {
						continue;
					}
					if (matrix[x][y].color == target.color) {
//						matrix[x][y].color = 
					}
					
				}
			}
			
			
		}
		
	}
	
	public static void main(String[] args) {
		
		
		
	}

}

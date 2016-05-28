package shortestDist;
import java.util.*;
public class Solution {
	class Point {
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	int[] dx = new int[] {-1, 1, 0, 0};
	int[] dy = new int[] {0, 0, 1, -1};
	//Shortest distance to '1'. Given a matrix with 1s and 2s, find shortest distance from any 2, to any 1.. 鐣欏鐢
	public int shortestDist(int[][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;
		int len = 0;
		
		Queue<Point> queue = new LinkedList<>();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] == 2) {
					queue.offer(new Point(i, j));
				}
			}
		}
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Point p = queue.poll();
				
				for (int iter = 0; iter < 4; iter++) {
					int x = p.x + dx[iter];
					int y = p.y + dy[iter];
					if (x < 0 || x >= row || y < 0 || y >= col) {
						continue;
					}
					
					if (matrix[x][y] == 1) {
						return len + 1;
					} else {
						queue.offer(new Point(x, y));
					}
				}
			}
			
			len++;
		}
		
		return -1;
		
	}
	
	
}

package maze;

import java.util.LinkedList;
import java.util.Queue;

public class Maze {
	// maze[i][j] == Integer.MAX_VALUE -> end point
	// maze[i][j] == -1 -> wall
	
	int[] dx = {-1, 1, 0, 0};
	int[] dy = {0, 0, -1, 1};
	
	public boolean dfs(int[][] maze, boolean[][] visited, int iStart, int jStart) {
		if (maze[iStart][jStart] == Integer.MAX_VALUE) {
			return true;
		}
		
		if (maze[iStart][jStart] == -1) {
			return false;
		}

		visited[iStart][jStart] = true;
		for (int i = 0; i < 4; i++) {
			int row = iStart + dx[i];
			int col = jStart + dy[i];
			
			if (row < 0 || row >= maze.length || col < 0 || col >= maze.length) {
				continue;
			}
			
			if (!visited[row][col]) {
				if (dfs(maze, visited, row, col)) {
					return true;
				}
			}
			
		}
		
		visited[iStart][jStart] = false;
		
		return false;
	}	
	
	public int shortestPath(int[][] maze, int iStart, int jStart) {
		if (maze == null || maze.length == 0) {
			return -1;
		}
		
		if (maze[0] == null || maze[0].length == 0) {
			return -1;
		}
		
		int step = 0;
		boolean[][] visited = new boolean[maze.length][maze[0].length];
		Queue<int[]> q = new LinkedList<>();
		if (maze[iStart][jStart] == 0) {
			return -1;
		}

		q.offer(new int[] {iStart, jStart});
		visited[iStart][jStart] = true;
		
		while (!q.isEmpty()) {
			int size = q.size();
			for (int id = 0; id < size; id++) {
				int[] curr = q.poll();
				if (maze[curr[0]][curr[1]] == Integer.MAX_VALUE) {
					return step;
				}
				
				for (int i = 0; i < 4; i++) {
					int row = curr[0] + dx[i];
					int col = curr[1] + dy[i];
					
					if (row < 0 || row >= maze.length || col < 0 || col >= maze[0].length) {
						continue;
					}
					
					if (visited[row][col] || maze[row][col] == -1) {
						continue;
					}
					
					q.offer(new int[] {row, col});
				}
			}
			
			step++;

		}
		
		return step;
	}
}

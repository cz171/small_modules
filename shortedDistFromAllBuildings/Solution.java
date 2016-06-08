package shortedDistFromAllBuildings;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	int[] dx = new int[] {-1, 0, 0, 1};
	int[] dy = new int[] {0, -1, 1, 0};
	public int shortestDistFromAllBuildings(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return -1;
		}
		
		int row = matrix.length;
		int col = matrix[0].length;
		int[][] distance = new int[row][col];
		int[][] reach = new int[row][col];
		int buildingNum = 0;
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] == 1) {
					buildingNum++;
					
					Queue<int[]> queue = new LinkedList<>();
					queue.offer(new int[] {i, j});
					
					boolean[][] isVisited = new boolean[row][col];
					int level = 1;

					while (!queue.isEmpty()) {
						int qSize = queue.size();
						for (int q = 0; q < qSize; q++) {
							int[] curr = queue.poll();
							
							for (int iter = 0; iter < 4; iter++) {
								int nextRow = curr[0] + dx[iter];
								int nextCol = curr[1] + dy[iter];
								 if (nextRow >= 0 && nextRow < row && nextCol >= 0 && nextCol < col
		                                    && matrix[nextRow][nextCol] == 0 && !isVisited[nextRow][nextCol]) {
									distance[nextRow][nextCol] += level;
                                    reach[nextRow][nextCol]++;

                                    isVisited[nextRow][nextCol] = true;
                                    queue.offer(new int[] {nextRow, nextCol});
								}
							}
						}
						level++;

					}
				}
			}
		}
		
		int shortestDist = Integer.MAX_VALUE;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] == 0 && reach[i][j] == buildingNum) {
					shortestDist = Math.min(distance[i][j], shortestDist);
				}
			}
		}
		
		return shortestDist;
	}
}

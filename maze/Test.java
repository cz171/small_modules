package maze;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] maze = new int[][] {
				{1, -1, 1},
				{1, -1, 1},
				{1, 1, Integer.MAX_VALUE}
		};
		
		boolean[][] visited = new boolean[maze.length][maze[0].length];
		Maze m = new Maze();
		System.out.println(m.dfs(maze, visited, 0, 0));
		System.out.println(m.shortestPath(maze, 0, 0));

		
	}

}

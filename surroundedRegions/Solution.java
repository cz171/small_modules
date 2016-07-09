package surroundedRegions;

import java.util.Arrays;

public class Solution {
    static int[] dx = new int[] {-1, 0, 0, 1};
    static int[] dy = new int[] {0, 1, -1, 0};
    
    public static void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            setBoarder(board, visited, i, 0);
            setBoarder(board, visited, i, n - 1);
        }
        
        for (int j = 0; j < n; j++) {
            setBoarder(board, visited, 0, j);
            setBoarder(board, visited, m - 1, j);
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }
        
    }
    
    private static void setBoarder(char[][] board, boolean[][] visited, int i, int j) {
        if (board[i][j] == 'O') {
                board[i][j] = '*';
                visited[i][j] = true;
                dfs(board, visited, i, j);
        }
    }
    
    private static void dfs(char[][] board, boolean[][] visited, int i, int j) {
        for (int k = 0; k < 4; k++) {
            int row = i + dx[k];
            int col = j + dy[k];
            if (row < 0 || row > board.length - 1 || col < 0 || col > board[0].length - 1) {
                continue;
            }
            if (board[row][col] == 'O' && !visited[row][col]) {
                board[row][col] = '*';
                visited[row][col] = true;
                dfs(board, visited, row, col);
            }
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = new char[][] {
			{'X', 'X', 'X'},
			{'X', 'O', 'X'},
			{'X', 'X', 'X'}
		};
		
		solve(board);
		for (int i = 0; i < board.length; i++) {
			System.out.println(Arrays.toString(board[i]));
		}
 	}

}

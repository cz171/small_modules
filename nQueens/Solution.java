package nQueens;
import java.util.*;
public class Solution {
	//solve n * n
	public static List<List<String>> solve(int n) {
		List<List<String>> result = new ArrayList<>();
		char[][] board = new char[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = '.';
			}
		}
		
		
	}
	
	private static List<String> construct(char[][] board) {
		List<String> res = new ArrayList<>();
		for (int i = 0; i < board.length; i++) {
			res.add(board[i].toString());
		}
		return res;
	}
	
	private static boolean validate(char[][] board, int i, int j) {
		if ()
	}
	private static void dfs(List<List<String>> result, char[][] board, int colIndex) {
		if (colIndex == board.length) {
			result.add(construct(board));
			return;
		}
		
		for (int rowIndex = 0; rowIndex < board.length; rowIndex++) {
			if (validate(board, rowIndex, colIndex)) {
				
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

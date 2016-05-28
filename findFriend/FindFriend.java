package findFriend;
import java.util.*;
public class FindFriend {
	
	public static void main(String[] args) {
		//test case
		int cnt = 0;
		HashSet<Integer> visited = new HashSet<Integer>();
		int[][] matrix = new int[][] {
			{1, 0, 1},
			{0, 1, 1},
			{1, 1, 1}
		};
		
		UnionFind uf = new UnionFind(matrix);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if (matrix[i][j] == 1) {
					uf.union(i, j);
				}
			}
		}
		
		System.out.println(uf.cnt);
		
		
	}
}

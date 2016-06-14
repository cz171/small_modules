package mergeKArrays;
import java.util.*;
public class Solution {
	static class Point {
		int x;
		int y;
		int val;
		public Point(int x, int y, int val) {
			this.x = x;
			this.y = y;
			this.val = val;
		}
	}
	
	//O(nlogk) k -> arrays.length
	public static List<Integer> mergeKArrays(int[][] arrays) {
		List<Integer> result = new ArrayList<>();
		if (arrays == null || arrays.length == 0) {
			return result;
		}
		
		Queue<Point> pq = new PriorityQueue<>(arrays.length, (a, b) -> (a.val - b.val));
		for (int i = 0; i < arrays.length; i++) {
			pq.add(new Point(i, 0, arrays[i][0]));
		}
		
		while (!pq.isEmpty()) {
			Point p = pq.poll();
			result.add(p.val);
			if (p.y < arrays[0].length - 1) {
				pq.offer(new Point(p.x, p.y + 1, arrays[p.x][p.y + 1]));
			}	
		}
		
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] test = new int[][] {
			{1, 2, 3, 5, 6},
			{2, 3, 5, 6, 7}, 
			{3, 5, 7, 8, 10}
		};
		
		List<Integer> result = mergeKArrays(test);
		System.out.println(Arrays.toString(result.toArray()));
	}

}

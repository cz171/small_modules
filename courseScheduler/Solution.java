package courseScheduler;
import java.util.*;
public class Solution {
	public static String sort(String[][] projects) {
		String res = "";
		Map<String, Integer> indegree = new HashMap<>();
		Map<String, HashSet<String>> map = new HashMap<>();
		for (String[] project: projects) {
			String pre = project[1];
			String proj = project[0];
			if (!map.containsKey(pre)) {
				map.put(pre, new HashSet<String>());
			}
			
			map.get(pre).add(proj);
			
			if (!indegree.containsKey(proj)) {
				indegree.put(proj, 0);
			}
			indegree.put(proj, indegree.get(proj) + 1);

			if (!indegree.containsKey(pre)) {
				indegree.put(pre, 0);
			}
		}
		
		
		for (String pre: map.keySet()) {
			System.out.print(pre + " ");
			for (String proj : map.get(pre)) {
				System.out.print(proj + " ");
			}
			System.out.println();
		}
		
		Queue<String> queue = new LinkedList<>();
		for (String proj: indegree.keySet()) {
			if (indegree.get(proj) == 0) {
				queue.offer(proj);
			}
		}
		
		while (!queue.isEmpty()) {
			String pre = queue.poll();
			res += pre + "->";
			if (!map.containsKey(pre)) {
				continue;
			}
			
			for (String proj: map.get(pre)) {
				indegree.put(proj, indegree.get(proj) - 1);
				if (indegree.get(proj) == 0) {
					queue.offer(proj);
				}
			}
		}
		
		return res == "" ? res : res.substring(0, res.length() - 2);		
		
	}
	
	public static void main(String[] args) {
		String[][] projects = {
				{"project1", "project0"},
				{"project2", "project1"},
				{"project1", "project4"}
		};
		
		System.out.println(sort(projects));
	}
}

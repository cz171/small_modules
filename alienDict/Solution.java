package alienDict;
import java.util.*;

public class Solution {
	public static String alienDict(String[] words) {
		Map<Character, HashSet<Character>> map = new HashMap<>();
		Map<Character, Integer> indegree = new HashMap<>();
	
		for (String word: words) {
			for (char c: word.toCharArray()) {
				indegree.put(c, 0);
			}
		}
		
		for (int i = 0 ; i < words.length - 1; i ++) {
			String curr = words[i];
			String next = words[i + 1];
			int len = Math.min(curr.length(), next.length());
			
			for (int j = 0; j < len; j++) {
				char c1 = curr.charAt(j);
				char c2 = next.charAt(j);
				
				if (c1 != c2) {
					if (!map.containsKey(c1)) {
						map.put(c1, new HashSet<>());
					}
					
					map.get(c1).add(c2);
					indegree.put(c2, indegree.get(c2) + 1);
					break;
				}
			}
		}
		
		//topological sort
		StringBuilder sb = new StringBuilder();
		Queue<Character> queue = new LinkedList<>();
		
		for (char c: indegree.keySet()) {
			if (indegree.get(c) == 0) {
				queue.add(c);
			}
		}
		
		int cnt = 0;
		while (!queue.isEmpty()) {
			char c = queue.poll();
			cnt++;
			sb.append(c);
			if (map.containsKey(c)) {
				for (char ch: map.get(c)) {
					indegree.put(ch, indegree.get(ch) - 1);
					if (indegree.get(ch) == 0) {
						queue.offer(ch);
					}
				}
			}
		}
		
		return indegree.size() == cnt ? sb.toString() : "";
				
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		  String[] words = {
//				  "wrt",
//				  "wrf",
//				  "er",
//				  "ett",
//				  "rftt"
//		  };
		  
		// try dictionary doesn't exist
		  String[] words = {
				  "wr",
				  "rw",
				  "wr"
		  };
		  
		  System.out.println(alienDict(words));
		 
	}

}

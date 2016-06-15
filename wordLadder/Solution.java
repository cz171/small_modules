package wordLadder;
import java.util.*;

public class Solution {
	public static int wordLadder(String begin, String end, Set<String> dict) {
		Queue<String> queue = new LinkedList<>();
		queue.offer(begin);
		Set<String> visited = new HashSet<>();
		visited.add(begin);
		dict.add(end);
		int len = 1;
		
		while (!queue.isEmpty()) {
			len++;
			int qSize = queue.size();
			for (int i = 0; i < qSize; i++) {
				String s = queue.poll();
				List<String> nextWordList = getList(s, dict);
				for (String nextWord : nextWordList) {
					if (visited.contains(nextWord)) {
						continue;
					}
					
					if (nextWord.equals(end)) {
						return len;
					}
					
					visited.add(nextWord);
					queue.offer(nextWord);
				}
			}
		}
		
		return 0;
	}
	
	private static String replace(String s, int pos, char c) {
		char[] chars = s.toCharArray();
		chars[pos] = c;
		return String.valueOf(chars);
	}
	
	private static List<String> getList(String s, Set<String> dict) {
		List<String> res = new ArrayList<>();
		for (char c = 'a'; c <= 'z'; c++) {
			for (int i = 0; i < s.length(); i++) {
				String next = replace(s, i, c);
				if (dict.contains(next)) {
					res.add(next);
				}
			}
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//["hot","dot","dog","lot","log"]
		Set<String> dict = new HashSet<>();
		dict.add("hot");
		dict.add("dog");
		dict.add("dot");
		dict.add("lot");
		dict.add("log");
		
		System.out.println(wordLadder("hit", "cog", dict));
	}

}

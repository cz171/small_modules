package combination;
import java.util.*;

//[hello, hi]
//[world, jack, kelly]
		
public class Solution {
	public static ArrayList<String> combination(ArrayList<ArrayList<String>> list) {	
		ArrayList<String> result = new ArrayList<>();
		helper(list, result, "", 0);
		return result;
	}
	
	public static void helper(ArrayList<ArrayList<String>> list, ArrayList<String> result, String path, int depth) {
		if (depth == list.size()) {
			result.add(path);
			return;
		}
		
		for (int i = 0; i < list.get(depth).size(); i++) {
			String part = path + (path.isEmpty() ? "" : " ") + list.get(depth).get(i);
			helper(list, result, part, depth + 1);
		}
		
	}
	
	
	public static void main(String[] args) {
		ArrayList<ArrayList<String>> list = new ArrayList<>();
		ArrayList<String> p1 = new ArrayList<>();
		ArrayList<String> p2 = new ArrayList<>();
		p1.add("hello");
		p1.add("hi");
		p2.add("tim");
		p2.add("jack");
		p2.add("tina");
		list.add(p1);
		list.add(p2);
		
		ArrayList<String> result = combination(list);
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
		
	}
}

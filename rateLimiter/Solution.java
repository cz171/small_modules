package rateLimiter;
import java.util.*;
public class Solution {
	public static void processElements(List<? super Integer> elements) {
		for (Object o: elements) {
			System.out.println(o);
		}
	}
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		processElements(list);
	}
}

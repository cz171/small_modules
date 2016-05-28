package iterator;
import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		List<String> list = new ArrayList<String>();
//		list.add("a");
//		list.add("b");
//		list.add("c");
//		Iterator<String> i = list.iterator();
//		while (i.hasNext()) {
//			System.out.println(i.next());
//		}
//		
		Sequence<String> list = new Sequence();
		list.add("a");
		list.add("b");
		list.add("c");
		Iterator<String> i = list.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}
		

	}

}

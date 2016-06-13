package objectHashMap;
import java.util.*;
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Point, Integer> map = new HashMap<>();
		map.put(new Point(1, 1), 0);
		map.put(new Point(1, 2), 1);
		
		System.out.println(map.get(new Point(1, 2)));
	}

}

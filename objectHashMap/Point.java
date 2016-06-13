package objectHashMap;

public class Point {
	int x;
	int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int hashCode() {
		int hashcode = 0;
		hashcode += 31 *(x + y);
		return hashcode;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Point) {
			Point p = (Point) obj;
			return x == p.x && y == p.y;
		}
		
		return false;
	}
}

package test;

public class Box {
	int length;
	int width;
	public Box(int length, int width) {
		this.length = length;
		this.width = width;
	}
	
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		
		Box box = (Box) o;
		if (box.length != length) {
			return false;
		}
		
		if (box.width != width) {
			return false;
		}
		
		return true;
	}
}

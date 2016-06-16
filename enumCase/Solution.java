package enumCase;

public class Solution {
	public enum Color {
		RED (0),
		BLACK (255);
		
		private int color;
		Color(int color) {
			this.color = color;
		}
		
		public int getColor() {
			return color;
		}
	}
	
	public static void main(String[] args) {
		for (Color c: Color.values()) {
			System.out.println(c + ":" + c.getColor());
		}
	}
}

package clockAngel;

public class Solution {
	//Given a clock, return the angle formed by the hour and minute arrows
	public static int angle(String s) { 	
		String[] strs = s.split(":");
		Integer min = Integer.valueOf(strs[1]);
		Integer hr = Integer.valueOf(strs[0]);
		
		int angleMin = (360 * min / 60) % 360;
		int angleHr = (30 * hr + 30 * min / 60) % 360;
		return Math.abs(angleMin - angleHr);
		
	}
	public static void main(String[] args) {
		System.out.println(angle("12:00"));
		System.out.println(angle("1:30"));
		System.out.println(angle("2:30"));


	}
}

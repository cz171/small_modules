package spellingPluralNouns;

public class Solution {
	public static String addPlural(String s) {
		String res = new String(s);
		if (s.endsWith("ch") || s.endsWith("sh") || s.endsWith("s")
				|| s.endsWith("x") || s.endsWith("z")) {
			res += "es";
		} else if (s.endsWith("ay") || s.endsWith("ey") || s.endsWith("iy")
				|| s.endsWith("oy") || s.endsWith("uy")) {
			res += "s";
		} else if (s.endsWith("y")) {
			res = res.substring(0, res.length() - 1) + "ies";
		} else if (s.endsWith("f") || s.endsWith("fe")) {
			int pos = s.lastIndexOf("f");
			res = res.substring(0, pos) + "ves";
		} else if (s.endsWith("ao") || s.endsWith("eo") || s.endsWith("io")
				|| s.endsWith("oo") || s.endsWith("uo")) {
			res += "s";
		} else if (s.startsWith("o")) {
			res += "es";
		} else {
			res += "s";
		}
		
		return res;

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//test case
		System.out.println(addPlural("kangaroo"));
	}

}

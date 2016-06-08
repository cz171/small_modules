package teneryExpressionParser;

public class Solution {
	public static String tenaryExpressionParser(String s) {
		String[] exps = s.split("\\?");
		String[] res = exps[1].split(":");
		
		String output = "";
		String[] condition = exps[0].split("=");
		
		if (condition[1].trim().equals("T")) { 
			output = res[0];
		} else {
			output = res[1];
		}
		
		return output;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(tenaryExpressionParser("1 = T ? a: b"));

	}

}

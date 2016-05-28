package numToEnglish;

public class NumToEng {

	static private String[] digits = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", 
			"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
			"nineteen"};
	static private String[] tens = {"zero", "ten", "twenty", "thirty", "fourty", "fifty", "sixty", 
			"seventy", "eighty", "nighty"};

	public static String numToWord(int n) {
		if (n == 0) {
			return "zero";
		}
		
		String s = helper(n);
		return s.substring(1);
	}
	public static String helper(int n) {
		if (n >= 1000000000) {
			return helper(n / 1000000000) + " billion " + helper(n % 1000000000);
		}
		
		if (n >= 1000000) {
			return helper(n / 1000000) + " million" + helper(n % 1000000);
		}
		
		if (n >= 1000) {
			return helper(n / 1000) + " thousand" + helper(n % 1000);
		}
				
		if (n >= 100) {
			return helper(n / 100) + " hundred" + helper(n % 100);
		}
		
		if (n >= 20) {
			return " " + tens[n / 10] + helper(n % 10);
		}
		
		if (n >= 1) {
			return " "  + digits[n];
		}
		
		return "";
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//test case 1
		System.out.println(numToWord(13232));
		System.out.println(numToWord(1013232));

	}

}

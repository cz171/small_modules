package alphabetical;

public class AlphabeticalOrder {

	public static int findPrefix(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		
		int len = 1;
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) >= s.charAt(i - 1)) {
				len++;
			} else {
				break;
			}
		}
		
		return len;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Write a function that takes in a string and returns the length of the longest string prefix in which all characters are arranged in alphabetical order.  Use the language with which you are the most familiar.

		Examples:
        alphaprefix("ransom")   = 1
        alphaprefix("google") = 3
        alphaprefix("knotty")   = 6

		 */
		//test case
		System.out.println(findPrefix("knotty"));
	}

}

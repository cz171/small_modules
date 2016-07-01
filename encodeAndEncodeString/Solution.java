package encodeAndEncodeString;

public class Solution {

	/**
	 * decode string, 输入 a[4]bcd[3]efg, 要返回 aaaabcdddefg
	 * @param args
	 */
	
	public static String decode(String s) {
		if (s == null || s.length() == 0) {
			return null;
		}
		
		StringBuilder sb = new StringBuilder();
		int i = 0;
		int times = 0;
		char letter = '\0';
		char last = '\0';
		while (i < s.length()) {
			char c = s.charAt(i);
			if (!Character.isDigit(c)) {
				if (last != c && times == 0) {
					sb.append(last);
				}
				
				letter = c;
				last = c;
				i++;
			} else {
				while (i < s.length() && Character.isDigit(s.charAt(i))) {
					times = times * 10 + s.charAt(i) - '0';
					i++;
				}
				
				for (int k = 0; k < times; k++) {
					sb.append(letter);
				}
				
				times = 0;
			}
		}
		
		if (last != sb.charAt(sb.length() - 1)) {
			sb.append(last);
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String s = "a4bcd3efg";
		System.out.println(decode(s));
		System.out.println(decode("abcd"));

		
	}

}

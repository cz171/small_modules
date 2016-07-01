package zigzag;

import java.util.Arrays;

public class Solution {
    public static String convert(String s, int numRows) {
        char[] chars = s.toCharArray();
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
        	sb[i] = new StringBuilder();
        }
        
        StringBuilder res = new StringBuilder();
        int i = 0;
        
        while (i < s.length()) {
            for (int idx = 0; idx < numRows && i < s.length(); idx++) {
                sb[idx].append(chars[i++]);
            }
            
            for (int idx = numRows - 2; idx >= 1 && i < s.length(); idx--) {
                sb[idx].append(chars[i++]);
            }
        }
        
        for (StringBuilder part: sb) {
            res.append(part);
        }
        
        return res.toString();
    }
    
	public static void main(String[] args) {
		System.out.println(convert("A", 2));
	}

}

package versionControl;

import java.util.Arrays;

public class Solution {
	public static int compareVersion(String version1, String version2) {
        String[] s1 = version1.split(".");
        String[] s2 = version2.split(".");
        String intPart1 = !version1.contains(".") ? version1 : s1[0];
        String intPart2 = !version2.contains(".") ? version2 : s2[0];
        if (intPart1.compareTo(intPart2) < 0) {
            return -1;
        } else if (intPart1.compareTo(intPart2) > 0) {
            return 1;
        }
        
        String num1 = s1[1];
        String num2 = s2[1];
        int i = 0;
        while (i < num1.length() && i < num2.length()) {
            if (num1.charAt(i) < num2.charAt(i)) {
                return -1;
            } else if (num1.charAt(i) > num2.charAt(i)) {
                return 1;
            }
        }
        
        if (i < num1.length()) {
            return 1;
        }
        
        if (i < num2.length()) {
            return -1;
        }
        
        return 0;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] test = "d.s".split(".");
		System.out.println(Arrays.toString(test));
	}

}

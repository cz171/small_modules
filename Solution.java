import java.util.*;

public class Solution {

    public static boolean isPowerOfFour(int n) {
    	int cnt = 0;
        while (n > 0 && ((n & (n - 1)) == 0)) {
        	while (n > 1) {
        		n >>= 1;
        		cnt++;
        	}
        	
        	return cnt % 2 == 0;
        }
        
        return false;
    }
    
    public static void main(String[] args) {
    	//test case
    	int[] a = new int[]{1, 4, 15, 16, 64};
    	for (int num : a) {
    		System.out.print(num + " is power of 4 ? : ");
    		System.out.println(isPowerOfFour(num));
    	}
        
    }
}
package getUniqueNumWithRange;

public class Solution {
	public static int getNumWithinRange(int n) {
		
	}
	
	public static int getNumToN(int num) {
		int len = 0;
		int base = 10;
		while (num / base != 0) {
			base *= 10;
			len++;
		}
		
		base /= 10;
		int left = getNumWithLength(len);
		int right = 0;
		
		int leftMost = num % base;
		int leftMostCnt = 1;
		for (int j = 1; j < leftMost; j++) {
			leftMostCnt *= (9 - j + 1);
		}
		
		right += leftMostCnt * (leftMost - 1);
		
		num %= base;
		
		for (int i = )
	}
	
	public static int getNumWithLength(int n) {
		if (n == 0) {
			return 1;
		}
		
		int ans = 10;
		int base = 9;
		for (int i = 2; i <= n && i <= 10; i++) {
			base = base * (9 - i + 2);
			ans += base;
		}
		
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

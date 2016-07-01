package maximumNights;

public class Solution {
	/*
	 *  Provide a set of positiveintegers (an array of integers). Each integer represent number of nights userrequest on Airbnb.com. If you are a host, you need to design and implement analgorithm to find out the maximum number a nights you can accommodate. Theconstrain is that you have to reserve at least one day between each request, sothat you have time to clean the room.

	Example:
	1) Input: [1, 2, 3]===&gt; output: 4, because you will pick 1 and 3
	2) input: [5,1, 2, 6] ===&gt; output: 11, because you will pick 5 and 6
	3) input: [5,1, 2, 6, 20, 2] ===&gt; output: 27, because you will pick 5, 2, 20  
	 */

	public static int maxNights(int[] nights) {
		if (nights == null || nights.length == 0) {
			return 0;
		}
		
		int n = nights.length;
		if (n < 2) {
			return nights[0];
		}
		if (n < 3) {
			return Math.max(nights[0], nights[1]);
		}
		
		int[] maxNights = new int[n];
		maxNights[0] = nights[0];
		maxNights[1] = nights[1];
		for (int i = 2; i < n; i++) {
			if (i == 2) {
				maxNights[i] = maxNights[i - 2] + nights[i];
				continue;
			}
			
			maxNights[i] = Math.max(maxNights[i - 3] + nights[i], maxNights[i - 2] + nights[i]);
		}
		
		return Math.max(maxNights[n - 1], maxNights[n - 2]);
	}
	
	public static void main(String[] args) {
		int[] n1 = new int[] {
				1, 2, 3
		};
		
		int[] n2 = new int[] {
				5,1, 2, 6
		};
		
		int[] n3 = new int[] {
				5,1, 2, 6, 20, 2
		};
		
		System.out.println(maxNights(n1));
		System.out.println(maxNights(n2));
		System.out.println(maxNights(n3));

	}

}

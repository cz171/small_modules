package minSteps;

public class Solution {
	//给一个string，只含有a和b,a可以变成b,b可以变成a,也可以不操作，返回操作次数最少就可以得到的sort的string
	public static int minStep(char[] input) {
		if (input == null || input.length == 0) {
			return 0;
		}
		int len = input.length;
		int[] front = new int[len + 1];
		int[] back = new int[len + 1];
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < len; i++) {
			if (input[i] == 'a') {
				front[i + 1] = front[i];
			} else {
				front[i + 1] = front[i] + 1;
			}
 		}
		
		for (int i = len - 1; i >= 0; i--) {
			if (input[i] == 'b') {
				back[i] = back[i + 1];
			} else {
				back[i] = back[i + 1] + 1;
			}
			
			min = Math.min(min, front[i] + back[i]);
		}
		
		return min;
	}
	
	public static void main(String[] args) {
		char[] input = new char[] {
				'a', 'a', 'a', 'b'
		};
		
		char[] input1 = new char[] {
				'a', 'b', 'a', 'b'
		};
		
		char[] input2 = new char[] {
				'b', 'b', 'b', 'b', 'a', 'a', 'a', 'a'
		};
		
		System.out.println(minStep(input));
		System.out.println(minStep(input1));
		System.out.println(minStep(input2));

	}
}	

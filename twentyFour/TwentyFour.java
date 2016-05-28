package twentyFour;

public class TwentyFour {
	final static double E = 1E-10;
	public static boolean dfs(double[] pokers, int len) {
		if (len == 1) {
			if (Math.abs(pokers[0] - 24) < E) {
				return true;
			}	
		}
		
		if (len < 1) {
			return false;
		}
		
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				double first = pokers[i];
				double second = pokers[j];
				pokers[j] = pokers[len - 1];
				
				pokers[i] = first + second;
				if (dfs(pokers, len - 1)) {
					return true;
				}
				
				pokers[i] = first - second;
				if (dfs(pokers, len - 1)) {
					return true;
				}
				
				pokers[i] = second - first;
				if (dfs(pokers, len - 1)) {
					return true;
				}
				
				pokers[i] = first * second;
				if (dfs(pokers, len - 1)) {
					return true;
				}
				
				if (Math.abs(second - 0) < E) {
					pokers[i] = first / second;
					if (dfs(pokers, len - 1)) {
						return true;
					}
				}
				
				if (Math.abs(first - 0) < E) {
					pokers[i] = second / first;
					if (dfs(pokers, len - 1)) {
						return true;
					}
				}
				
				pokers[i] = first;
				pokers[j] = second;
				
			}
		}
		
		return false;
	}
	
	
	public static void main(String[] args) {
		//test
		double[] test1 = new double[] {1, 2, 3, 4};
		System.out.println(dfs(test1, 4));
		double[] test2 = new double[] {2,3,4,5};
		System.out.println(dfs(test2, 4));
		
	}
}

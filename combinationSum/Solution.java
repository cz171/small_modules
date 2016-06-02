package combinationSum;
import java.util.*;
public class Solution {
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        if (k < 1 || n < 1) {
            return result;
        }
        
        helper(result, new ArrayList<Integer>(), 1, 0, k, n);
        return result;
    }
    
    public static void helper(List<List<Integer>> result, ArrayList<Integer> path, int pos, int sum, int k, int n) {
        if (sum > n) {
            return;
        }
        
        if (path.size() == k) {
        	System.out.println(sum);
        	System.out.println(Arrays.toString(path.toArray()));
            if (sum == n) {
                result.add(new ArrayList<Integer>(path));
            }
            return;
        }
        
        for (int i = pos; i < 10; i++) {
            System.out.println("i is " + i + " sum is " + sum);
            path.add(i);
            helper(result, path, i + 1, sum + i, k, n);
            path.remove(path.size() - 1);
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		combinationSum3(2, 6);
	}

}

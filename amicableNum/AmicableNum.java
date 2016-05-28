package amicableNum;
import java.util.*;
public class AmicableNum {
	public static int sumOfDivisor(int num) {
		int sum = 1;
 		int i = 2;
 		while (i <= num / 2) {
 			if (num % i == 0) {
 				sum += i;
 			}
 			i++;
 		}
 		
 		return sum;
	}
	
 	public static boolean isPair(int a, int b) {
 		if (a == b) {
 			return false;
 		}
 		
 		if (sumOfDivisor(a) == b && sumOfDivisor(b) == a) {
 			return true;
 		}
 		
 		return false;
 	}
 	
 	public static ArrayList<ArrayList<Integer>> amicableNum(int n) {
 		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
 		for (int i = 1; i < n; i++) {
 			for (int j = i + 1; j <= n; j++) {
 				ArrayList<Integer> pair = new ArrayList<>();
 				if (isPair(i, j)) {
 					pair.add(i);
 					pair.add(j);
 				}
 				
 				if (pair.size() == 2) {
 					res.add(pair);
 				}
 			}
 		}
 		
 		return res;
 	}
 	
 	public static ArrayList<ArrayList<Integer>> amicableNumFast(int n) {
 		int[] record = new int[n + 1];
 		for (int i = 0; i < n + 1; i++) {
 			record[i] += 1;
 		}
 		
 		for (int div = 2; div <= n / 2; div++) {
 			for (int index = div * 2; index <= n; index += div) {
 				record[index] += div;
 			}
 		}
 		
 		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
 		
 		for (int i = 1; i < n + 1; i++) {
 			if (i < record[i] && record[i] <= n && record[record[i]] == i) {
 				ArrayList<Integer> partRes = new ArrayList<>();
 				partRes.add(i);
 				partRes.add(record[i]);
 				res.add(partRes);
 			}
 		}
 		
 		return res;
 		
 	}
 	
 	public static void main(String[] args) {
 		//test 
 		System.out.println(amicableNumFast(10000).toString());
 	}
}

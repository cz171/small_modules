package quickSelect;
import java.util.*;
public class Solution {
	 public static int quickselect(int[] G, int k) {
		  return quickselect(G, 0, G.length - 1, k - 1);
		}
		 
		private static int quickselect(int[] G, int first, int last, int k) {
		  if (first <= last) {
		    int pivot = partition(G, first, last);
		    if (pivot == k) {
		      return G[k];
		    }
		    if (pivot > k) {
		      return quickselect(G, first, pivot - 1, k);
		    }
		    return quickselect(G, pivot + 1, last, k);
		  }
		  return Integer.MIN_VALUE;
		}
		 
		private static int partition(int[] G, int first, int last) {
		  int pivot = first + new Random().nextInt(last - first + 1);
		  swap(G, last, pivot);
		  for (int i = first; i < last; i++) {
		    if (G[i] > G[last]) {
		      swap(G, i, first);
		      first++;
		    }
		  }
		  swap(G, first, last);
		  return first;
		}
		 
		private static void swap(int[] G, int x, int y) {
		  int tmp = G[x];
		  G[x] = G[y];
		  G[y] = tmp;
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//test case
		int[] nums = new int[] {
				2, 3, 4, 1, 5
		};
		
		System.out.println(quickselect(nums, 2));
	}

}

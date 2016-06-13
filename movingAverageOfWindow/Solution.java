package movingAverageOfWindow;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Stream;
import java.util.Iterator;

public class Solution {
	/**
	 * 1. Moving Average of An Input Stream. The size of a window is n
	For example:
	input = [1, 1, 2, 3, 3, 4, 4, 4, 5.....], n = 3;
	moving average = [1, 1, 1.33, 2, 2.67, 3.33, 3.67, 4, 4.33...]

	 **/
	public static void movingAverage(Stream input, int windowSize) {
		Deque<Integer> deque = new ArrayDeque<>();
		int sum = 0;
		
		Iterator iter = input.iterator();
=		while (iter.hasNext()) {
			Object now = iter.next();
			if (deque.size() < windowSize) {
				sum += now;
				
			}
		}
	}
}

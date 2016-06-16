package findClosestTime;

public class Solution {
	/**
	 * 
	palantir coding challenge 120 mins 2 problems1. find minimum difference
	Input: String[], HH:MM 格式, unsorted
	return minimum minute difference, for example， 如果 11:00 和 11:01 差距最小 则返回1
	note: 24小时制 23:59 和 00:00 差1min
	 * @param args
	 */
	
	/**
	 * 首先如果array长度大于或等于60*24 = 1440时，
	 * 那么肯定有重复的，返回0。所以只看长度小于1440的情况。
	 * 想到的办法是将时间string转化为int，如02:14转化为：2*60+14=134，
	 * 然后存在一个长为1439的boolean数组里面。存完扫一遍，找到最近的2个true的位置。
	 * 不知道还有没有更优的方法？
	 * @param strs
	 * @return
	 */
	
	public static int find(String[] strs) {
		boolean[] timeStamp = new boolean[1440];
		for (String time: strs) {
			String[] parts = time.split(":");
			int hour = Integer.valueOf(parts[0]);
			int sec = Integer.valueOf(parts[1]);
			System.out.println(hour + " " + sec);
			timeStamp[hour * 60 + sec] = true;
		}
		
		int prev = -1;
		int closest = Integer.MAX_VALUE;
		for (int i = 0; i < timeStamp.length; i++) {
			if (timeStamp[i]) {
				if (prev == -1) {
					prev = i;
				} else {
					closest = Math.min(closest, i - prev);
					prev = i;
				}
			}
		}
		
		return closest;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//test case
		String[] times = {"11:22", "11:01", "11:11"};
		System.out.println(find(times));
	}

}

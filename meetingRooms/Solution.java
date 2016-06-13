package meetingRooms;
import java.util.*;
public class Solution {
	static class Interval {
		int startTime;
		int endTime;
		public Interval(int sTime, int eTime) {
			startTime = sTime;
			endTime = eTime;
		}
	}
	
	static class Meeting {
		int roomId;
		Interval interval;
		public Meeting(int id, Interval interval) {
			roomId = id;
			this.interval = interval;
		}
	}
	
	public static List<Meeting> getMeetingRooms(Interval[] intervals) {
		List<Meeting> res = new ArrayList<>();
		if (intervals == null || intervals.length == 0) {
			return res;
		}
		
		Arrays.sort(intervals, (a, b) -> (a.startTime - b.startTime));
		Queue<Meeting> pq = new PriorityQueue<>(intervals.length, (a, b) -> (a.interval.endTime - b.interval.endTime));
		int id = 0;
		pq.offer(new Meeting(id++, intervals[0]));
		for (int i = 1; i < intervals.length; i++) {
			Meeting m = pq.poll();
			if (intervals[i].startTime >= m.interval.endTime) {
				m.interval.endTime = intervals[i].endTime;
			} else {
				pq.offer(new Meeting(id, intervals[i]));
				id++;
			}
			
			pq.offer(m);
		}
		
		while (!pq.isEmpty()) {
			res.add(pq.poll());
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		   Interval a = new Interval(0,2);
		   Interval b = new Interval(1,4);
		   Interval c = new Interval(2,3);
		   Interval d = new Interval(2,5);
		  
		   Interval[] interval = {c,b,a,d};
		   List<Meeting> res = getMeetingRooms(interval);
		   for (Meeting meeting: res) {
			   System.out.println("room id: " + meeting.roomId + ", Interval: " + 
					   meeting.interval.startTime + "," + meeting.interval.endTime);
		   }
	}

}

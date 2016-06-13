package uber;
import java.util.*;
public class Solution {
	//输入一组数据，用户名字，登录时间，登出时间，输出用户个数在所有登录/登出时间
	/**
	 * input = [
		['A', 1.1, 2.3],
		['B', 1.3, 3.4]
		]
		output= [
		[1.1, 1],
		[1.3, 2],
		[2.3, 1],
		[3.4, 0]
		]
	 * @param args
	 */
	
	static class Log {
		String name;
		double startTime;
		double endTime;
		public Log(String name, double startTime, double endTime) {
			this.name = name;
			this.startTime = startTime;
			this.endTime = endTime;
		}
	}
	
	static class Node {
		double time;
		int cnt;
		public Node(double time, int cnt) {
			this.time = time;
			this.cnt = cnt;
		}
	}
	
	public static List<Node> getTimePoint(Log[] logs) {
		List<Node> res = new ArrayList<>();
		Arrays.sort(logs, (a, b) -> ((int) (a.startTime - b.startTime)));

		Queue<Log> queue = new PriorityQueue<>(logs.length, (a, b) -> (int) (a.endTime - b.endTime));
		queue.offer(logs[0]);
		int cnt = 1;
		res.add(new Node(logs[0].startTime, 1));
		for (int i = 1; i < logs.length; i++) {
			Log earliestEnd = queue.poll();
			if (logs[i].startTime < earliestEnd.endTime) {
				cnt += 1;
				res.add(new Node(logs[i].startTime, cnt));
			} else {
				cnt--;
				res.add(new Node(earliestEnd.endTime, cnt));
				res.add(new Node(logs[i].startTime, cnt));
			}
			
			queue.offer(earliestEnd);
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Log log1 = new Log("A", 1.1, 2.3);
		Log log2 = new Log("B", 1.3, 3.4);
		
		Log[] list = new Log[2];
		list[0] = log1;
		list[1] = log2;
		
		List<Node> res = getTimePoint(list);
		for (Node n: res) {
			System.out.println(n.time + " " + n.cnt);
		}
	}

}

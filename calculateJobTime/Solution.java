package calculateJobTime;
import java.util.*;
public class Solution {
	static class Node {
		String name;
		long timeCost;
		public Node(String name, long timeCost){
			this.name = name;
			this.timeCost = timeCost;
		}
	}
	
	static class Log {
		String jobname;
		boolean startOrEnd;
		long timeStamp;
		public Log(String jobname, boolean startOrEnd, long timeStamp) {
			this.jobname = jobname;
			this.startOrEnd = startOrEnd;
			this.timeStamp = timeStamp;
		}
	}
	
	public static List<Node> getJobList(List<Log> logs) {
		List<Node> list = new ArrayList<>();
		if (logs == null || logs.size() == 0) {
			return list;
		}
		
		Map<String, Long> map = new HashMap<>();
		for (Log log: logs) {
			if (log.startOrEnd) {
				map.put(log.jobname, (long) 0);
			} else {
				
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}

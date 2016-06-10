package api;
import java.util.*;
public class Solution {
	static class Snap {
		int snapId;
		int count;
	}
	
	static class Person {
		List<Person> friends;
		Map<Snap, Integer> snapList;
		public Person() {
			friends = new ArrayList<>();
			snapList = new HashMap<>();
		}
	}
	
	static class Node {
		Snap snap;
		int count;
		public Node(Snap snap, int count) {
			this.snap = snap;
			this.count = count;
		}
	}
	//设计一个API, 返回所有朋友看的snap 从高到低的snap, 
	//所有数据结构自己构造，我就想了个Person的class, 
	//里面有friend List, 以及一个hashMap统计各个snap的观看纪录，
	//然后就是bfs, 再一个大的hashmap统计了,
	//最后加了个Node class {private int snapId, private int count}, 
	//用Collections.sort出结果
	
	//Snaps are meant to make conversation more spontaneous, 
	//visual and fun! Snaps are picture or video messages taken 
	//and shared with friends on Snapchat in real-time. Snaps can be 
	//viewed for up to 10 seconds, depending on the amount of time 
	//the user chooses.
	
	public List<Snap> api(Person person) {
		List<Person> list = person.friends;
		
		Map<Snap, Integer> snapList = person.snapList;
		for (Person p: list) {
			for (Snap snap: p.snapList.keySet()) {
				if (!snapList.containsKey(snap)) {
					snapList.put(snap, p.snapList.get(snap));
				}
				
				snapList.put(snap, snapList.get(snap) + p.snapList.get(snap));
			}
		}
		
		List<Node> nodes = new ArrayList<>();
		for (Map.Entry<Snap, Integer> record: snapList.entrySet()) {
			nodes.add(new Node(record.getKey(), record.getValue()));
		}
		
		Collections.sort(nodes, (a, b) -> (b.count - a.count));
		List<Snap> result = new ArrayList<>();
		
		for (Node n: nodes) {
			result.add(n.snap);
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

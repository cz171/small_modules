package pairProblem;
import java.util.*;
public class Solution {
	//题目是手机上的通讯录，每条记录只有(name, number)这种pair,
	//有些记录名字重复，有些记录号码重复，让我返回一个list<list<Record>>，
	//将所有记录按人分组。比较tricky的点在于(A,123), (A, 456), (B, 456)三条记录，
	//第一条和第三条也属于同一个人。要求时间复杂度尽量小。
	//
	static class Record {
		String name;
		int number;
		public Record(String name, int number) {
			this.name=  name;
			this.number = number;
		}
	}
	
	
	public static List<List<Record>> getPair(List<Record> records) {
		List<List<Record>> result = new ArrayList<>();
		//two pass version
		Set<String> names = new HashSet<>();
		Set<Integer> numbers = new HashSet<>();
		
		for (Record record: records) {
			names.add(record.name);
			numbers.add(record.number);
		}
		
		while (!names.isEmpty() && !numbers.isEmpty()) {
			List<Record> path = new ArrayList<>();
			for (Record record: records) {
				if (names.contains(record.name)) {
					path.add(record);
				} 
				
			}
		}
		
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Record> records = new ArrayList<>();
		records.add(new Record("ABC", 123));
		records.add(new Record("ABC", 456));
		records.add(new Record("BCD", 456));
	}

}

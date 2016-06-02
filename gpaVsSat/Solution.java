package gpaVsSat;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Solution {
	/*
	 * Given a data set of (sat, gpa) for the final year of
	 *  a group of students, devise an algorithm to construct
	 *   the longest sequence of (sati, gpai) of students with 
	 *   progressively better SAT scores, and progressively worse gpa’s, 
	 *   i.e. sat1 < sat2 < … < satk and gpa1 > gpa2 > … > gpak 
	 *   ( Assume SAT scores and gpa’s are unique )
	 */
	static class Student {
		int id;
		String name;
		double gpa;
		int sat;
		public Student(int id, String name, int sat, double gpa) {
			this.id = id;
			this.name = name;
			this.gpa = gpa;
			this.sat = sat;
		}
	}
	
	public static ArrayList<Student> LongestMonotonicSubsequence(ArrayList<Student> students) {
		ArrayList<Student> result = new ArrayList<>();
		
		int len = students.size();
		if (len == 0) {
			return result;
		}
		
		//sort by sat 
		Collections.sort(students, (a, b) -> (a.sat - b.sat));
		
		int max = 0;
		
		//O(n^2)
		//a naive way but easy to be understood
		for (int i = 0; i < students.size() - 1; i++) {
			int last = i;
			ArrayList<Student> tmp = new ArrayList<>();
			tmp.add(students.get(last));
			for (int j = 1;  j < students.size(); j++) {
				if (students.get(j).gpa < students.get(last).gpa) {
					tmp.add(students.get(j));
					last = j;
				} 
			}
			
			if (tmp.size() > max) {
				max = tmp.size();
				result = tmp;
			}
		}	
		return result;
	}
	
	public static void print(ArrayList<Student> students) {
		for (Student s: students) {
			System.out.println(s.sat + " " + s.gpa);
		}
	}
	
	//encapsulate the input
	public static ArrayList<Student> readFile(File file) throws FileNotFoundException {
		Scanner sc = new Scanner(file);
		ArrayList<Student> students = new ArrayList<>();
		while (sc.hasNextLine()) {
			String s = sc.nextLine();
			String[] parts = s.split(" ");
			int id = Integer.valueOf(parts[0]);
			String name = parts[1];
			int sat = Integer.valueOf(parts[2]);
			double gpa = Double.valueOf(parts[3]);
			Student student = new Student(id, name, sat, gpa);
			students.add(student);
		}
		
		return students;
	}
	
	public static void main(String[] args) throws FileNotFoundException {		
		//including the file path here
		//test file should be in below format (id, name, sat, gpa)
		//1 Marry 651 3.22
		//2 John 641 3.24
		//3 Adam 631 3.33
		//4 Watson 621 3.55
		//5 Eric 611 3.66
		
		File file = new File("/Users/zhanchen/Downloads/test.txt");
		
		ArrayList<Student> students = readFile(file);
		
		ArrayList<Student> result = LongestMonotonicSubsequence(students);
		print(result);
		
	}

}

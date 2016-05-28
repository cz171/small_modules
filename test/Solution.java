package test;
import java.util.*;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Solution {
	
	//insertion sort 
	private static void insertSort(int[] arr) {
		int len = arr.length;
		for (int i = 1; i < len; i++) {
			int pivot = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > pivot) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = pivot;
		}
		
	}
	
	private static void swap(int[] arr, int s, int e) {
		int temp = arr[s];
		arr[s] = arr[e];
		arr[e] = temp;
	}
	
	private static void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}
			
			if (min != i) {
				swap(arr, i, min);
			}
		}
	}
	
	private static char[] filter(char[] s, char c) {
		int ptr1 = 0, ptr2 = 0;
		while (ptr2 < s.length) {
			if (s[ptr2] == c) {
				ptr2++;
			} else {
				s[ptr1++] = s[ptr2++];
			}
		}
		
		while (ptr1 < s.length) {
			s[ptr1++] = ' ';
		}
		return s;
		
	}
	
	public enum ItemType {
		COMPANY_WIDE("Company"),
		DEPARTMENTAL("Departmental"),
		PROJECT_SPECIFIC("Project");
		
		private String itemCode;
		private ItemType(String dbCode) {
			itemCode = dbCode;
		}
		
		public String getItemCode() {
			return itemCode;
		}
		
	}
//	private static final char SE = 0x20;
//	private static final int MES = 1;
//	private final Character m_value = 'a';
//	public String toString() {
//		return "" + m_value;
//	}
	
	public static int api(int x_a, int y_a, int x_b, int y_b) {
		return 1;
	}
	
	public static final int MAX_RESTAURANT = 50;
	public static int getArea(int x_a, int y_a, int x_b, int y_b) {
//		//recursive
//		int num = api(x_a, y_a, x_b, y_b);
//		if (num < MAX_RESTAURANT) {
//			return num;
//		}
//		
//		//divide and conquer
//		int left = getArea(x_a, y_a, x_a + (x_b - x_a) / 2, y_b);
//		int right = getArea(x_a + (x_b - x_a) / 2, y_a, x_b, y_b);
//	
//		return left + right;
		
		//iteration
		int sum = 0;
		Stack<Point> s = new Stack<Point>();
		s.push(new Point(x_a, y_a, x_b, y_b));
		while (!s.isEmpty()) {
			Point p = s.pop();
			int xA = p.xA;
			int xB = p.xB;
			int yA = p.yA;
			int yB = p.yB;
			
			int area = api(xA, yA, xB, yB);
			if (area < MAX_RESTAURANT) {
				sum += area;
			} else {
				s.push(new Point(xA, yA, xA + (xB - xA) / 2, yB));
				s.push(new Point(xA + (xB - xA) / 2, yA, xB, yB));
			}
		}
		return sum;
		
	}
	
	public static String findCommon(String a, String b) {
//		HashSet<Character> set = new HashSet<Character>();
		char[] aArray = a.toCharArray();
		char[] bArray = b.toCharArray();
		StringBuilder result = new StringBuilder();
		
		int[] set = new int[256];
		for (char c: aArray) {
			set[(int)c]++;
		}
		
		for (char c: bArray) {
			if (set[(int)c] > 0) {
				result.append(c);
				set[(int)c]--;
			}
		}
		
//		for (char c: aArray) {
//			set.add(c);
//		}
//		
//		for (char c: bArray) {
//			if (set.contains(c)) {
//				result.append(c);
//				set.remove(c);
//			} 
//		}
		
		return result.toString();
		
	}
	
	public static void mergeSort(int[] num) {
		int[] temp = new int[num.length];
		mergeSort(num, temp, 0, num.length - 1);
	}
	
	public static void mergeSort(int[] num, int[] temp, int left, int right) {
		if (left < right) {
			int middle = left + (right - left) / 2;
			mergeSort(num, temp, left, middle);
			mergeSort(num, temp, middle + 1, right);
			merge(num, temp, left, middle + 1, right);
		}
		
	}
	
	public static void merge(int[] num, int[] temp, int left, int right, int rightEnd) {
		int leftEnd = right - 1;
		int k = left;
		int cnt = rightEnd - left + 1;
		while (left <= leftEnd && right <= rightEnd) {
			if (num[left] <= num[right]) {
				temp[k++] = num[left++];
			} else {
				temp[k++] = num[right++];
			}
		}
		
		while (left <= leftEnd) {
			temp[k++] = num[left++];
		}
		
		while (right <= rightEnd) {
			temp[k++] = num[right++];
		}
		
		for (int i = 0; i < cnt; i++, rightEnd--) {
			num[rightEnd] = temp[rightEnd];
		}
	}
	
	public enum Color {
		BLACK(255),
		WHITE(0);
		private int color;
		
		Color(int color) {
			this.color = color;
		}
		
		public int getColor() {
			return color;
		}
	}
	
	public static ArrayList<Integer> findPrime(int[] nums) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (nums == null || nums.length == 0) {
			return result;
		}
		
		for (int i = 0; i < nums.length; i++) {
			boolean isPrime = true;
			for (int j = 2; j < nums[i]; j++) {
				if (nums[i] % j == 0) {
					isPrime = false;
					break;
				}
			}
			
			if (isPrime && (nums[i] != 1)) {
				result.add(nums[i]);
			}
		}
		
		return result;
	}
	
	public static ArrayList<Integer> topThree(int[] arr) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (arr == null || arr.length < 3) {
			return res;
		}
		
		Queue<Integer> pq = new PriorityQueue<Integer>();
			
		for (int num: arr) {
			if (pq.size() < 3) {
				pq.offer(num);
			} else {
				if (pq.peek() < num) {
					pq.poll();
					pq.offer(num);
				}
			}
		}
		
		while (!pq.isEmpty()) {
			res.add(pq.poll());
		}
		
		return res;
	}
	
	public static void main(String[] args) {
//		int[] a = new int[]{32, 32, 42, 32, 1, 3};
//		mergeSort(a);
//		System.out.println(Arrays.toString(a));
			
//		Color black = Color.BLACK;
//		System.out.println(black.getColor());
		
		int[] nums = new int[] {1, 32, 2, 5};
		System.out.println(findPrime(nums).toString());
		
		//test
//		String a = "adss";
//		String b = "fssd";
//		System.out.println(findCommon(a, b));
		
		//test case
//		int[] nums = new int[] {2, 32, 412, 5, 12,3 };
		System.out.println(topThree(nums).toString());
		
	}
	
		
}

// TODO Auto-generated method stub
//HashMap<String, Integer> hash = new HashMap<String, Integer>();
//hash.put("aa", 0);
//hash.put("bb", 1);
//for (String s : hash.keySet()) {
//	System.out.println(hash.get(s));
//}
//int[] arr = new int[]{3, 512, 32, 31, 1, 5};
//selectionSort(arr);
//for (int num : arr) {
//	System.out.println(num);
//}

////test case
//String s = "adsbds";
//System.out.println(filter(s.toCharArray(), 'a'));
//
//String a = "immiTablds";
//String b = a.toUpperCase();
//System.out.println(b);

//Swapper swapper = new Swapper();
//int x = 42, y = 24;
//swapper.swap(x, y);
//System.out.println("X" + x + "Y" + y);
//
//List<Double> prices = new ArrayList<Double>();
//prices.add(42.0);
//System.out.println(prices);
//Box box1 = new Box(5, 4);
//Box box2 = new Box(5, 4);
//Box box3 = new Box(5, 3);
//System.out.println(box1.equals(box1));
//
//System.out.println(box1.equals(box2));
//System.out.println(box1.equals(box3));
//
//ItemType type = ItemType.valueOf("PROJECT_SPECIFIC");
//ItemType type1 = ItemType.values()[0];

//List<Plant> plants = new ArrayList<Plant>();
//plants.add(new Plant());
//List<? extends Plant> trees = plants;
//Plant plant = trees.get(0);

//List<Tree> trees = new ArrayList<Tree>();
//trees.add(new Tree());
//List<? extends Plant> plants = trees;
//Tree tree = trees.get(0);

//System.out.println(SE + MES + "=A");
//try {
//	Field f = Solution.class.getDeclaredField("m_value");
//	f.setAccessible(true);
//	Solution a = new Solution();
//	f.set(a, (char)'b');
//	System.out.println(a);
//} catch (Exception e) {
//	e.printStackTrace();
//	
//	
//}

//for (byte b = Byte.MIN_VALUE; b < Byte.MAX_VALUE; b++) {
//	if (b == 0x90) {
//		System.out.println("we found it");
//	}
//}
//
//String line = "";
//String pattern = "^([0-9]+)$";
//Pattern r = Pattern.compile(pattern);
//Matcher m = r.matcher(line);
//if (m.find()) {
//	System.out.println("find it !");
//			
//}

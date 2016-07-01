package testTest;

public class Solution {
	static class Node {
		Node next;
		int val;
		public Node(int val) {
			this.val = val;
			next = null;
		}
	}
	
	public int getSum(int i, int j) {
		return i + j;
	}
	
	public static void main(String[] args) {
		String s = "a";
//		System.out.println(s.substring(0, 0));
//		System.out.println(s.substring(1));
//		
		Node head = new Node(0);
		Node newHead = head;
		Node pre = head;
		head = head.next;
		pre.next = new Node(1);
		while (newHead != null) {
			System.out.println(newHead.val);
			newHead = newHead.next;
		}
	}
}	

package linkedList;

public class Solution {
	static class Node {
		Node next;
		int val;
		public Node(int val) {
			next = null;
			this.val = val;
		}
	}
	
	public static void splitList(Node n) {
		Node dummy1 = new Node(-1);
		Node dummy2 = new Node(-1);
		Node odd = dummy1;
		Node even = dummy2;
		
		while (n != null) {
			if (n.val % 2 == 0) {
				even.next = n;
				even = n;
			} else {
				odd.next = n;
				odd = n;
			}
			n = n.next;
		}
		
		even.next = null;
		odd.next = null;
		
		while (dummy1.next != null) {
			dummy1 = dummy1.next;
			System.out.print(dummy1.val);
		}
		
		System.out.println();
		while (dummy2.next != null) {
			dummy2 = dummy2.next;
			System.out.print(dummy2.val);
		}
		
		System.out.println();
	}
	public static void main(String[] args) { 
		Node n1 = new Node(0);
		Node n2 = new Node(1);
		Node n3 = new Node(2);
		n1.next = n2;
		n2.next = n3;
		splitList(n1);
	}
}

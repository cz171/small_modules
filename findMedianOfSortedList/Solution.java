package findMedianOfSortedList;

public class Solution {
	static class Node {
		int val;
		Node next;
		public Node(int val) {
			this.val = val;
			next = null;
		}
	}
	
	public static int findMedian(Node n1, Node n2) {
		//1. merge two sorted list -> find median with two pointers
		//O(n + m) time  O(n + m) space
		Node dummy = new Node(-1);
		Node curr = dummy;
		while (n1 != null && n2 != null) {
			if (n1.val < n2.val) {
				curr.next = n1;
				curr = curr.next;
				n1 = n1.next;
			} else {
				curr.next = n2;
				curr = curr.next;
				n2 = n2.next;
			}
		}
		

		if (n1 != null) {
			curr.next = n1;
		}
		
		if (n2 != null) {
			curr.next = n2;
		}
		
		curr = dummy.next;
		Node slow = curr;
		Node fast = curr.next;
		

		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow.val;
	}
	
	public static int findMedianConstant(Node n1, Node n2) {
		int size = 0;
		Node head1 = n1;
		Node head2 = n2;
		
		while (n1 != null) {
			size++;
			n1 = n1.next;
		}
		
		while (n2 != null) {
			size++;
			n2 = n2.next;
		}
		
		n1 = head1;
		n2 = head2;
		int cnt = 0;
//		0, 1, 2, 3 len 4
//		0, 1, 2 len 3 
		int val = -1;
		while (n1 != null && n2 != null) {
			System.out.println(cnt + " " + n1.val + " " + n2.val);
			if (cnt == size / 2) {
				return val;
			}
			if (n1.val < n2.val) {
				val = n1.val;
				n1 = n1.next;
			} else {
				val = n2.val;
				n2 = n2.next;
			}
		}
		
		while (n1 != null) {
			if (cnt == size / 2) {
				return val;
			}
			val = n1.val;
			n1 = n1.next;
			cnt++;

		}
		
		while (n2 != null ) {
			if (cnt == size / 2) {
				return val;
			}
			val = n2.val;
			n2 = n2.next;
			cnt++;
		}
		
		return -1;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n1 = new Node(0);
		Node n2 = new Node(1);
		Node n3 = new Node(3);
		n1.next = n2;
		n2.next = n3;
		
		Node n4 = new Node(2);
		Node n5 = new Node(5);
		n4.next = n5;
		
//		System.out.println(findMedian(n1, n4));
		System.out.println(findMedianConstant(n1, n4));

	}

}

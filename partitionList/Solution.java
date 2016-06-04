package partitionList;

public class Solution {
	static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
     }
	
    public static ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(-1);
        ListNode curr1 = dummy1;
        ListNode dummy2 = new ListNode(-1);
        ListNode curr2 = dummy2;
        
        while (head != null) {
            if (head.val < x) {
                curr1.next = head;
                curr1 = curr1.next;
            } else {
                curr2.next = head;
                curr2 = curr2.next;
            }
            head = head.next;
        }
        
        curr2.next = null;
        curr1.next = dummy2.next;
        return dummy1.next;
    }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode n = new ListNode(2);
		ListNode n1 = new ListNode(1);
		n.next = n1;
		ListNode res = partition(n, 2);
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}

}

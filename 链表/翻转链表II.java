/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }    
 */

public class Solution {

	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null || head.next == null) return head;

		ListNode ptr = new ListNode(0);
		ptr.next = head;
		ListNode pre = ptr;
		for (int i = 1; i < m; i++) {
			pre = pre.next;
		}

		ListNode cur = pre.next;
		for (int i = 0; i < n - m; i++) {
			ListNode move = cur.next;
			cur.next = move.next;
			move.next = pre.next;
			pre.next = move;			
		}

		return ptr.next;
	}
}





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

	public ListNode reverse(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode ptr = new ListNode(0);
		ptr.next = head;
		while (head.next != null) {
			ListNode move = head.next;
			head.next = move.next;
			move.next = ptr.next;
			ptr.next = move;
		}
		return ptr.next;
	}

}